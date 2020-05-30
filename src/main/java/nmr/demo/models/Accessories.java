package nmr.demo.models;

public class Accessories {
    private static int accessory_id;
    private double price;
    private String accessoryType;

    public Accessories() {
    }

    public Accessories(int accessory_id, String accessoryType, double price) {
        this.accessory_id = accessory_id;
        this.price = price;
        this.accessoryType = accessoryType;
    }

    @Override
    public String toString(){
        return accessory_id + accessoryType + price;
    }

    public static int getAccessory_id() {
        return accessory_id;
    }

    public void setAccessory_id(int accessory_id) {
        this.accessory_id = accessory_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAccessoryType() {
        return accessoryType;
    }

    public void setAccessoryType(String accessoryType) {
        this.accessoryType = accessoryType;
    }
}
