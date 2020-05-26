package nmr.demo.models;

public class Accessories {
    private static int accessories_id;
    private double price;
    private String accessoryType;

    public Accessories() {
    }

    public Accessories(int accessories_id, double price, String type) {
        this.accessories_id = accessories_id;
        this.price = price;
        this.accessoryType = accessoryType;
    }

    public static int getAccessoriesId() {
        return accessories_id;
    }

    public void setAccessoriesId(int accessoriesId) {
        this.accessories_id = accessories_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public  String getType() {
        return accessoryType;
    }

    public void setType(String type) {
        this.accessoryType = accessoryType;
    }
}
