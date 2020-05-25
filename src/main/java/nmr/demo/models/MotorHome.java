package nmr.demo.models;

public class MotorHome {
    private static String licensePlateNo;
    private String model;
    private int beds;
    private double kilometers;
    private double price;
    private int engineBlockNo;
    private String accessible;

    public MotorHome() {
    }

    public MotorHome(String licensePlateNo, String model, int beds, double kilometers, double price, int engineBlockNo, String accessible) {
        this.licensePlateNo = licensePlateNo;
        this.model = model;
        this.beds = beds;
        this.kilometers = kilometers;
        this.price = price;
        this.engineBlockNo = engineBlockNo;
        this.accessible = accessible;
    }

    public static String getLicensePlateNo() {
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

    public String isAccessible() {
        return accessible;
    }

    public void setAccessible(String accessible) {
        this.accessible = accessible;
    }
}
