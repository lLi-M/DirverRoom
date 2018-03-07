package com.student.appointment.enums;

public enum AppointmentResultEnum {

	  SUCCESS(0,"成功"),//表示预约或者取消预约成功
	  
	  ALREADY_APPOINTMNET(1,"你今天已经预约,不能再次进行预约!"),//表示今日已经预约
	  
	  SUBJECT_ERROR(3,"当前只能预约"),//表示与当前能预约的科目不符
	  
	  TRAINER_BUSY(4,"教练以满,手速有点慢哦"),//表示教练忙
	  
	  STATUS_ERROR(5,"你已被拉黑,暂时不能预约"),//表示该学生已被拉黑
	  
	  STSTUS_BUSY(6,"你的预约次数已满"),//表示学生预约次数已满
	  
	  NO_APPOINTMENT(7,"你在还没有进行预约,请先预约!"),//表示当日该学生没有预约
	  
	  CANCEL_ERROR(8,"距离练车时间不足一天,不能更改!"),//表示取消预约失败
	  SHUNGYUE_TIME(9,"爽约处罚时间未过,暂不能练车"),
	   SUB_TIME(10,"请提前三天预约教练"),

	  ;
	
	 private Integer code;
	 private String message;

    AppointmentResultEnum(Integer code,String message) {
        this.code = code;
        this.message=message;
    }
    
  
    
    public Integer getCode() {
		return code;
	}



	public String getMessage() {
		return message;
	}

	

	
}

	