package com.office.cafe.admin;

public class AdminMemberDto {
    private int amNo;
    private String amId;
    private String amPw;
    private String amName;
    private String amPhone;
    private String amRegDate;
    private String amModDate;

    public int getAmNo() { return amNo; }
    public void setAmNo(int amNo) { this.amNo = amNo; }

    public String getAmId() { return amId; }
    public void setAmId(String amId) { this.amId = amId; }

    public String getAmPw() { return amPw; }
    public void setAmPw(String amPw) { this.amPw = amPw; }

    public String getAmName() { return amName; }
    public void setAmName(String amName) { this.amName = amName; }

    public String getAmPhone() { return amPhone; }
    public void setAmPhone(String amPhone) { this.amPhone = amPhone; }

    public String getAmRegDate() { return amRegDate; }
    public void setAmRegDate(String amRegDate) { this.amRegDate = amRegDate; }

    public String getAmModDate() { return amModDate; }
    public void setAmModDate(String amModDate) { this.amModDate = amModDate; }
}
