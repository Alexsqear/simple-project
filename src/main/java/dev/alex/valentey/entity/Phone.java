package dev.alex.valentey.entity;

public class Phone {
    private long phoneId;
    private String countryCode;
    private int operatorCode;
    private int phoneNumber;

    public Phone(long phoneid, String countryCode, int operatorCode, int phoneNumber) {
        this.phoneId = phoneid;
        this.countryCode = countryCode;
        this.operatorCode = operatorCode;
        this.phoneNumber = phoneNumber;
    }

    public Phone(String countryCode, int operatorCode, int phoneNumber) {
        this.countryCode = countryCode;
        this.operatorCode = operatorCode;
        this.phoneNumber = phoneNumber;
    }

    public Phone() {

    }

    public long getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(long phoneId) {
        this.phoneId = phoneId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public int getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(int operatorCode) {
        this.operatorCode = operatorCode;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phoneid=" + phoneId +
                ", countryCode='" + countryCode + '\'' +
                ", operatorCode=" + operatorCode +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
