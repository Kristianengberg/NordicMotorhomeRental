package nmr.demo.models;

import java.util.Date;

public class MotorHome {
    private String licensePlateNo;
    private String model;
    private int beds;
    private String accessible;
    private double kilometers;
    private double price;
    private int engineBlockNo;
    private Date start;
    private Date finish;



    public MotorHome() {
    }

    public MotorHome(String licensePlateNo, String model, int beds,String accessible, double kilometers, double price, int engineBlockNo) {
        this.licensePlateNo = licensePlateNo;
        this.model = model;
        this.beds = beds;
        this.accessible = accessible;
        this.kilometers = kilometers;
        this.price = price;
        this.engineBlockNo = engineBlockNo;
    }

    public String getLicensePlateNo() {
        return licensePlateNo;
    }

    public void setLicensePlateNo(String licensePlateNo) {
        this.licensePlateNo = licensePlateNo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public double getKilometers() {
        return kilometers;
    }

    public void setKilometers(double kilometers) {
        this.kilometers = kilometers;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getEngineBlockNo() {
        return engineBlockNo;
    }

    public void setEngineBlockNo(int engineBlockNo) {
        this.engineBlockNo = engineBlockNo;
    }

    public String getAccessible() {
        return accessible;
    }

    public void setAccessible(String accessible) {
        this.accessible = accessible;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getFinish() {
        return finish;
    }

    public void setFinish(Date finish) {
        this.finish = finish;
    }

    @Override
    public String toString() {
        return model +" " + accessible;
    }
}
