package nmr.demo.Models;

public class AutoCamper {
    private String licensePlate;
    private char model;
    private int bedSpace;
    private double price;
    private double fuel;
    private double kilometers;
    private int serialNumbers;

    public AutoCamper() {
    }

    public AutoCamper(String licensePlate, char model, int bedSpace, double price, double fuel, double kilometers, int serialNumbers) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.bedSpace = bedSpace;
        this.price = price;
        this.fuel = fuel;
        this.kilometers = kilometers;
        this.serialNumbers = serialNumbers;
    }



    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
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
