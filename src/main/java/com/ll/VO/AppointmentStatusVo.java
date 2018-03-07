package com.ll.VO;

import java.io.Serializable;

public class AppointmentStatusVo implements Serializable {
	  	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		private String trainerName;

	    private String appointmentTime;

	    private String appointmentAp;

	    private String testSubject;
	    
	    private String appointmentClicktime;
	    
	    private String trainerCard;
	    


		public String getTrainerCard() {
            return trainerCard;
        }

        public void setTrainerCard(String trainerCard) {
            this.trainerCard = trainerCard;
        }

        public String getAppointmentClicktime() {
            return appointmentClicktime;
        }

        public void setAppointmentClicktime(String appointmentClicktime) {
            this.appointmentClicktime = appointmentClicktime;
        }

        public String getTrainerName() {
			return trainerName;
		}

		public void setTrainerName(String trainerName) {
			this.trainerName = trainerName;
		}

		public String getAppointmentTime() {
			return appointmentTime;
		}

		public void setAppointmentTime(String appointmentTime) {
			this.appointmentTime = appointmentTime;
		}

		public String getAppointmentAp() {
			return appointmentAp;
		}

		public void setAppointmentAp(String appointmentAp) {
			this.appointmentAp = appointmentAp;
		}

		public String getTestSubject() {
			return testSubject;
		}

		public void setTestSubject(String testSubject) {
			this.testSubject = testSubject;
		}

}
