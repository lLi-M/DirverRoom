package com.student.appointment.enums;

public enum StudentStatus {

	NORMAL(1),
	AGAIN(2),
	ERROR(3),
	;
	
	private Integer code;

	StudentStatus(Integer code) {
        this.code = code;
    }
    
  
    
    public Integer getCode() {
		return code;
	}
}
