package com.ll.service.impl;

import com.ll.VO.AppointmentResult;
import com.ll.VO.AppointmentStatusVo;
import com.ll.mapper.*;
import com.ll.pojo.*;
import com.ll.utils.DateUtils;
import com.student.appointment.enums.AppointmentResultEnum;
import com.student.appointment.enums.AppointmentStatus;
import com.student.appointment.enums.StudentStatus;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Service
public class appointmentCancel {

    @Autowired
    SubjectTimeMapper subjectTimeMapper;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    ReadyTestMapper readyTestMapper;

    @Autowired
    AppointmentMapper appointmentMapper;

    @Autowired
    TrainerMapper trainerMapper;

    Logger logger = LoggerFactory.getLogger(appointmentCancel.class);

    public synchronized AppointmentResult updateAppointment(HttpSession session, String trainerName,
                                                            String ap, String day) {

        // Date date = DateUtils.getDate(day);

        Student student = (Student) session.getAttribute("student");
        String card = student.getStudentIdcard();
        AppointmentResult app = new AppointmentResult();
        int sub = DateUtils.getDays(day);
        if(sub <= AppointmentStatus.ADVANCED_TIME.getCode()){
            app.setCode(AppointmentResultEnum.SUB_TIME.getCode());
            app.setMessage(AppointmentResultEnum.SUB_TIME.getMessage());
            logger.debug(AppointmentResultEnum.SUB_TIME.getMessage());
            return app;
        }
        // 1.判断该学生当日是否已经预约
        Appointment appointment_ = findAppointmnentByIdCard(card, day);
        if (null != appointment_) {
            app.setCode(AppointmentResultEnum.ALREADY_APPOINTMNET.getCode());
            app.setMessage(AppointmentResultEnum.ALREADY_APPOINTMNET.getMessage());
            logger.debug(AppointmentResultEnum.ALREADY_APPOINTMNET.getMessage());
            return app;
        }
        // 2.查看当前教练是否有空
        Object[] result = findTrainer(trainerName, ap, day);
        // 3.若有空,则进行预约
        if ((Boolean) result[0]) {
            SubjectTime subjectTime = (SubjectTime) result[1];
            // 判断该学生是否可以预约该科目
            logger.debug(subjectTime.getTestName());

            boolean flag = !subjectTime.getTestName().equals(student.getStudentProject());
            if (flag) {
                app.setCode(AppointmentResultEnum.SUBJECT_ERROR.getCode());
                app.setMessage(AppointmentResultEnum.SUBJECT_ERROR.getMessage() + subjectTime.getTestName());
                logger.debug(AppointmentResultEnum.SUBJECT_ERROR.getMessage() + subjectTime.getTestName());

                return app;
            }
            if (ap.toLowerCase().equals("am")) {
                subjectTime.setTrainerStatusam(subjectTime.getTrainerStatusam() - 1);
            } else {
                subjectTime.setTrainerStatuspm(subjectTime.getTrainerStatuspm() - 1);

            }

            // 判断学生状态
            showStudentStatus(student, app);
            if (!app.getMessage().equals("")) {
                return app;
            }

            // 将信息填入预约表
            Appointment appointment = new Appointment();
            appointment.setAppointmentAp(ap);
            appointment.setAppointmentTime(day);
            appointment.setStudentIdcard(card);
            appointment.setStudentPhone(student.getStudentPhone());
            appointment.setTestSubject(student.getStudentProject());
            appointment.setTrainerName(trainerName);
            appointment.setStudentName(student.getStudentName());
            appointment.setAppointmentClicktime(DateUtils.getDateToSS());
            System.out.println(appointment);
            appointmentMapper.insert(appointment);

            // 判断该学生此次练完车后,是否可以加入备考名单
            if (student.getStudentTime() == 0) {
                ReadyTest readyTest = new ReadyTest();
                readyTest.setStudentIdcard(card);
                readyTest.setStudentName(student.getStudentName());
                readyTestMapper.insert(readyTest);
            }
            // 更新学生可练车次数
            studentMapper.updateByPrimaryKeySelective(student);

            // 更细教练的可预约次数
            subjectTimeMapper.updateByPrimaryKeySelective(subjectTime);
            session.setAttribute("student", student);
            app.setCode(AppointmentResultEnum.SUCCESS.getCode());
            app.setMessage(AppointmentResultEnum.SUCCESS.getMessage());
            logger.debug(AppointmentResultEnum.SUCCESS.getMessage());
            session.setAttribute("student", student);
            logger.info("重置session中学生状态");
            session.setMaxInactiveInterval(30 * 60);
            return app;

        } else {
            app.setCode(AppointmentResultEnum.TRAINER_BUSY.getCode());
            app.setMessage(AppointmentResultEnum.TRAINER_BUSY.getMessage());
            logger.debug(AppointmentResultEnum.TRAINER_BUSY.getMessage());
            return app;
        }
    }

    // 查看当前教练是否有空
    public Object[] findTrainer(String trainerName, String ap, String date) {
        Object o[] = new Object[2];
        SubjectTimeExample example = new SubjectTimeExample();
        SubjectTimeExample.Criteria criteria= example.createCriteria();
        criteria.andTrainerNameEqualTo(trainerName);
        criteria.andTestTimeEqualTo(date);
        if (ap.toLowerCase().equals("am")) {
            criteria.andTrainerStatusamNotEqualTo(0);
        } else {
            criteria.andTrainerStatuspmNotEqualTo(0);
        }
        List<SubjectTime> subjectTimes = subjectTimeMapper.selectByExample(example);
        if (null != subjectTimes && subjectTimes.size() > 0) {
            o[0] = true;
            o[1] = subjectTimes.get(0);
        } else {
            o[0] = false;

        }
        logger.debug("教练状态" + o[0]);
        return o;
    }

    // 判断学生状态
    public void showStudentStatus(Student student, AppointmentResult appointmentResult) {

        // 查看该学生最近一次爽约时间
        int time = student.getStudentShaungyue();
        if (time > 0) {
            String shuangyuedateString = student.getStudentCartime();
            int days = DateUtils.getDay(shuangyuedateString);
            if (days <= AppointmentStatus.SHUANGYUE_TIME.getCode()) {
                appointmentResult.setCode(AppointmentResultEnum.SHUNGYUE_TIME.getCode());

                appointmentResult.setMessage(AppointmentResultEnum.SHUNGYUE_TIME.getMessage());
                logger.debug(AppointmentResultEnum.SHUNGYUE_TIME.getMessage());
            }

        }

        int ststus = student.getStudentSatus();
        if (ststus == StudentStatus.NORMAL.getCode()) {
            if (student.getStudentTime() > 0) {
                student.setStudentTime(student.getStudentTime() - 1);
            } else {
                appointmentResult.setCode(AppointmentResultEnum.STSTUS_BUSY.getCode());
                appointmentResult.setMessage(AppointmentResultEnum.STSTUS_BUSY.getMessage());
                logger.debug(AppointmentResultEnum.STSTUS_BUSY.getMessage());

            }
        } else if (ststus == StudentStatus.AGAIN.getCode()) {
            if (student.getStudentTime() > 0) {
                student.setStudentTime(student.getStudentTime() - 1);
            } else {
                appointmentResult.setCode(AppointmentResultEnum.STSTUS_BUSY.getCode());

                appointmentResult.setMessage(AppointmentResultEnum.STSTUS_BUSY.getMessage());
                logger.debug(AppointmentResultEnum.STSTUS_BUSY.getMessage());

            }
        } else {
            appointmentResult.setCode(AppointmentResultEnum.STATUS_ERROR.getCode());

            appointmentResult.setMessage(AppointmentResultEnum.STATUS_ERROR.getMessage());
            logger.debug(AppointmentResultEnum.STATUS_ERROR.getMessage());

        }
    }

    // 取消预约
    public synchronized AppointmentResult updateAppointmentCancel(HttpSession session, String date) {
        Student student = (Student) session.getAttribute("student");
        String card = student.getStudentIdcard();
        AppointmentResult app = new AppointmentResult();

        // 1.判断该学生是否可以取消预约
        studentCanCancel(date, app);
        if (!app.getMessage().equals("")) {
            return app;
        }

        // 2.判断该学生在当日是否预约
        Appointment appointment = findAppointmnentByIdCard(card, date);
        if (null == appointment) {
            app.setCode(AppointmentResultEnum.NO_APPOINTMENT.getCode());
            app.setMessage(AppointmentResultEnum.NO_APPOINTMENT.getMessage());
            logger.debug(AppointmentResultEnum.NO_APPOINTMENT.getMessage());

            return app;
        }

        // 3.取消预约
        // ①教练剩余预约次数加一
        String ap = appointment.getAppointmentAp();
        SubjectTime subjectTime = findTrainerByCard(appointment);
        if (ap.toLowerCase().equals("am")) {
            subjectTime.setTrainerStatusam(subjectTime.getTrainerStatusam() + 1);
        } else {
            subjectTime.setTrainerStatuspm(subjectTime.getTrainerStatuspm() + 1);

        }
        subjectTimeMapper.updateByPrimaryKeySelective(subjectTime);
        // ②学生预约次数加一
        int status = student.getStudentTime();
        // ②.1 如果该学生石由于最后一次预约,加入的备考表,则需将该学生从备考表中删除
        if (status == 0) {
            ReadyTestExample readyTestExample = new ReadyTestExample();
          ReadyTestExample.Criteria criteriaready = readyTestExample
                    .createCriteria();
            criteriaready.andStudentIdcardEqualTo(card);
            readyTestMapper.deleteByExample(readyTestExample);
        }
        // ②.2

        student.setStudentTime(++status);

        studentMapper.updateByPrimaryKeySelective(student);

        // ③删除预约表
        appointmentMapper.deleteByPrimaryKey(appointment.getId());

        session.setAttribute("student", student);
        app.setCode(AppointmentResultEnum.SUCCESS.getCode());
        app.setMessage(AppointmentResultEnum.SUCCESS.getMessage());
        logger.info(AppointmentResultEnum.SUCCESS.getMessage());
        session.setAttribute("student", student);
        logger.info("重置session中学生状态");
        session.setMaxInactiveInterval(30 * 60);
        return app;
    }

    public Appointment findAppointmnentByIdCard(String card, String day) {
        AppointmentExample example = new AppointmentExample();
        AppointmentExample.Criteria criteria = example.createCriteria();
        criteria.andStudentIdcardEqualTo(card);
        criteria.andAppointmentTimeEqualTo(day);
        List<Appointment> appointments = appointmentMapper.selectByExample(example);
        if (null != appointments && appointments.size() > 0) {
            return appointments.get(0);
        } else {
            logger.info("无预约学生信息");
            return null;

        }
    }

    public SubjectTime findTrainerByCard(Appointment appointment) {

        String trainerName = appointment.getTrainerName();
        SubjectTimeExample example = new SubjectTimeExample();
        SubjectTimeExample.Criteria criteria = example.createCriteria();
        criteria.andTrainerNameEqualTo(trainerName);
        criteria.andTestTimeEqualTo(appointment.getAppointmentTime());
        SubjectTime subjectTime = subjectTimeMapper.selectByExample(example).get(0);

        return subjectTime;
    }

    // 查看学生预约状态
    public List<AppointmentStatusVo> findStudentAppointmentStatus(HttpSession session) {
        DateTime dateTime = new DateTime();
        String StringDate = dateTime.toString("yyyy-MM-dd");
        List<String> strings = DateUtils.getDaysCanvel(AppointmentStatus.SHOW_DATE.getCode());
        strings.add(StringDate);
        AppointmentExample example = new AppointmentExample();
        AppointmentExample.Criteria criteria = example.createCriteria();
        criteria.andAppointmentTimeIn(strings);
        Student student = (Student) session.getAttribute("student");
        criteria.andStudentPhoneEqualTo(student.getStudentPhone());
        List<Appointment> appointments = appointmentMapper.selectByExample(example);
        List<AppointmentStatusVo> appointmentStatusVos = new ArrayList<AppointmentStatusVo>();
        if (null != appointments && appointments.size() > 0) {
            for (Appointment appointment : appointments) {
                AppointmentStatusVo appointmentStatusVo = new AppointmentStatusVo();
                BeanUtils.copyProperties(appointment, appointmentStatusVo);
                String trainerName = appointment.getTrainerName();
                String carCard = trainerMapper.selectCardByTrainerName(trainerName);
                appointmentStatusVo.setTrainerCard(carCard);
                appointmentStatusVos.add(appointmentStatusVo);
            }
        }
        return appointmentStatusVos;
    }


//todo
    public synchronized AppointmentResult updateStudentAppointemnt(String studentIDCard,
                                                                   String oldAppointmentDate, String trainerName, String ap, String newAppointmentDate) {

        AppointmentResult app = new AppointmentResult();
        // 1.判断是否可以更改学生预约信息
        studentCanCancel(oldAppointmentDate, app);
        if (!app.getMessage().equals("")) {
            return app;
        }

        if (trainerName.equals("") || newAppointmentDate.equals("")) {
            // 取消学生预约信息逻辑
            updateStudentCancel(studentIDCard, oldAppointmentDate, app);
        }

        // 2.查看当前预约表中是否有该学生信息.
        Appointment appointment = findAppointmnentByIdCard(studentIDCard, oldAppointmentDate);

        if (null != appointment) {
            // 可以进行修改
            // 3.查询传入的教练的状态
            Object[] result = findTrainer(trainerName, ap, newAppointmentDate);
            if ((Boolean) result[0]) {
                SubjectTime subjectTime = (SubjectTime) result[1];

                if (ap.toLowerCase().equals("am")) {
                    subjectTime.setTrainerStatusam(subjectTime.getTrainerStatusam() - 1);
                } else {
                    subjectTime.setTrainerStatuspm(subjectTime.getTrainerStatuspm() - 1);
                }

                // 更新教练预约信息表
                subjectTimeMapper.updateByPrimaryKeySelective(subjectTime);

                // 更新预约信息表
                appointment.setAppointmentTime(newAppointmentDate);
                app.setCode(AppointmentResultEnum.SUCCESS.getCode());
                app.setMessage(AppointmentResultEnum.SUCCESS.getMessage());
                logger.debug(AppointmentResultEnum.SUCCESS.getMessage());

            } else {
                app.setCode(AppointmentResultEnum.TRAINER_BUSY.getCode());

                app.setMessage(AppointmentResultEnum.TRAINER_BUSY.getMessage());
                logger.debug(AppointmentResultEnum.TRAINER_BUSY.getMessage());

            }

        } else {
            app.setCode(AppointmentResultEnum.NO_APPOINTMENT.getCode());

            app.setMessage(AppointmentResultEnum.NO_APPOINTMENT.getMessage());
            logger.debug(AppointmentResultEnum.NO_APPOINTMENT.getMessage());

        }

        return app;

    }

    public AppointmentResult updateStudentCancel(String studentIdCard, String date, AppointmentResult app) {
        Student student = studentMapper.getStudnetBystudnetIdCard(studentIdCard);

        String card = student.getStudentIdcard();

        // 1.判断该学生是否可以取消预约
        // int days = DateUtils.getDays(date);
        // if (days <= 1) {
        // app.setMessage("距离练车时间不足一天,不能取消预约");
        // return app;
        // }

        // 2.判断该学生在当日是否预约
        Appointment appointment = findAppointmnentByIdCard(card, date);
        if (null == appointment) {
            app.setCode(AppointmentResultEnum.NO_APPOINTMENT.getCode());
            app.setMessage(AppointmentResultEnum.NO_APPOINTMENT.getMessage());
            logger.info(AppointmentResultEnum.NO_APPOINTMENT.getMessage());

            return app;
        }

        // 3.取消预约
        // ①教练剩余预约次数加一
        String ap = appointment.getAppointmentAp();
        SubjectTime subjectTime = findTrainerByCard(appointment);
        if (ap.toLowerCase().equals("am")) {
            subjectTime.setTrainerStatusam(subjectTime.getTrainerStatusam() + 1);
        } else {
            subjectTime.setTrainerStatuspm(subjectTime.getTrainerStatuspm() + 1);

        }
        subjectTimeMapper.updateByPrimaryKeySelective(subjectTime);
        // ②学生预约次数加一
        int status = student.getStudentTime();
        // ②.1 如果该学生石由于最后一次预约,加入的备考表,则需将该学生从备考表中删除
        if (status == 0) {
            ReadyTestExample readyTestExample = new ReadyTestExample();
            ReadyTestExample.Criteria criteriaready = readyTestExample
                    .createCriteria();
            criteriaready.andStudentIdcardEqualTo(card);
            readyTestMapper.deleteByExample(readyTestExample);
        }
        // ②.2

        student.setStudentTime(++status);

        studentMapper.updateByPrimaryKeySelective(student);

        // ③删除预约表
        appointmentMapper.deleteByPrimaryKey(appointment.getId());
        app.setCode(AppointmentResultEnum.SUCCESS.getCode());
        app.setMessage(AppointmentResultEnum.SUCCESS.getMessage());
        logger.info(AppointmentResultEnum.SUCCESS.getMessage());

        return app;
    }

    public void studentCanCancel(String oldDate, AppointmentResult app) {
        int days = DateUtils.getDays(oldDate);
        if (days <= AppointmentStatus.CANAEL_DATE.getCode()) {
            app.setCode(AppointmentResultEnum.CANCEL_ERROR.getCode());
            app.setMessage(AppointmentResultEnum.CANCEL_ERROR.getMessage());
            logger.info(AppointmentResultEnum.CANCEL_ERROR.getMessage());

        }
    }

}

