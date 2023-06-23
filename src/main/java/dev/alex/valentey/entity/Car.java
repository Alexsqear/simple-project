package dev.alex.valentey.entity;

public class Car {
    private long carId;
    private int serialNumber;
    private String mark;
    private String model;

    public Car(long carId, int serialNumber, String mark, String model) {
        this.carId = carId;
        this.serialNumber = serialNumber;
        this.mark = mark;
        this.model = model;
    }

    public Car() {
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", serialNumber='" + serialNumber + '\'' +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
