package com.ll.pojo;

public class Messagetitle {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message_title.id
     *
     * @mbg.generated Fri Dec 22 10:22:42 CST 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message_title.message_title
     *
     * @mbg.generated Fri Dec 22 10:22:42 CST 2017
     */
    private String messageTitle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message_title.meaasge_date
     *
     * @mbg.generated Fri Dec 22 10:22:42 CST 2017
     */
    private String meaasgeDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message_title.id
     *
     * @return the value of message_title.id
     *
     * @mbg.generated Fri Dec 22 10:22:42 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message_title.id
     *
     * @param id the value for message_title.id
     *
     * @mbg.generated Fri Dec 22 10:22:42 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message_title.message_title
     *
     * @return the value of message_title.message_title
     *
     * @mbg.generated Fri Dec 22 10:22:42 CST 2017
     */
    public String getMessageTitle() {
        return messageTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message_title.message_title
     *
     * @param messageTitle the value for message_title.message_title
     *
     * @mbg.generated Fri Dec 22 10:22:42 CST 2017
     */
    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle == null ? null : messageTitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message_title.meaasge_date
     *
     * @return the value of message_title.meaasge_date
     *
     * @mbg.generated Fri Dec 22 10:22:42 CST 2017
     */
    public String getMeaasgeDate() {
        return meaasgeDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message_title.meaasge_date
     *
     * @param meaasgeDate the value for message_title.meaasge_date
     *
     * @mbg.generated Fri Dec 22 10:22:42 CST 2017
     */
    public void setMeaasgeDate(String meaasgeDate) {
        this.meaasgeDate = meaasgeDate == null ? null : meaasgeDate.trim();
    }
}