package nmr.demo.models;

public class Accessories {
    private static int id;
    private double price;
    private String type;

    public Accessories() {
    }

    public Accessories(int id, double price, String type) {
        this.id = id;
        this.price = price;
        this.type = type;
    }

    public static int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public  String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
