package com.student.appointment.enums;

public enum AppointmentStatus {

    SHOW_DATE(8),//表示可以预约哪一天
    CANAEL_DATE(1),//提前几天可以取消预约
    SHUANGYUE_TIME(3),//爽约次数
    ADVANCED_TIME(3),//提前几天可以预约
    ;
	
	 private Integer code;

	
	 public Integer getCode() {
		return code;
	}


	AppointmentStatus(Integer code) {
       this.code = code;
       
   }
}
