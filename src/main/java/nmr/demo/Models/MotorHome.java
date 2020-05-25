package nmr.demo.Models;

public class MotorHome {
    private String licensePlateNo;
    private char model;
    private int bedSpace;
    private double price;
    private double fuel;
    private double kilometers;
    private int serialNumbers;

    public MotorHome() {
    }

    public MotorHome(String licensePlateNo, char model, int bedSpace, double price, double fuel, double kilometers, int serialNumbers) {
        this.licensePlateNo = licensePlateNo;
        this.model = model;
        this.bedSpace = bedSpace;
        this.price = price;
        this.fuel = fuel;
        this.kilometers = kilometers;
        this.serialNumbers = serialNumbers;
    }



    public String getLicensePlateNo() {
        return licensePlateNo;
    }

    public void setLicensePlateNo(String licensePlateNo) {
        this.licensePlateNo = licensePlateNo;
    }

    public char getModel() {
        return model;
    }

    public void setModel(char model) {
        this.model = model;
    }

    public int getBedSpace() {
        return bedSpace;
    }

    public void setBedSpace(int bedSpace) {
        this.bedSpace = bedSpace;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public double getKilometers() {
        return kilometers;
    }

    public void setKilometers(double kilometers) {
        this.kilometers = kilometers;
    }

    public int getSerialNumbers() {
        return serialNumbers;
    }

    public void setSerialNumbers(int serialNumbers) {
        this.serialNumbers = serialNumbers;
    }
}
