package nmr.demo.models;

public class Accessories {
    private static int accessoriesId;
    private double price;
    private String type;

    public Accessories() {
    }

    public Accessories(int accessoriesId, double price, String type) {
        this.accessoriesId = accessoriesId;
        this.price = price;
        this.type = type;
    }

    public static int getAccessoriesId() {
        return accessoriesId;
    }

    public void setAccessoriesId(int accessoriesId) {
        this.accessoriesId = accessoriesId;
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
