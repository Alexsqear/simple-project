package dev.alex.valentey.entity;

public class Passport {
    private long passportId;
    private String series;
    private String place;

    public Passport(long passportId, String series, String place) {
        this.passportId = passportId;
        this.series = series;
        this.place = place;
    }

    public Passport(String series, String place) {
        this.series = series;
        this.place = place;
    }

    public Passport() {
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public long getPassportId() {
        return passportId;
    }

    public void setPassportId(long passportId) {
        this.passportId = passportId;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "series='" + series + '\'' +
                ", IdNumber=" + passportId +
                ", place='" + place + '\'' +
                '}';
    }
}
