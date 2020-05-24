package nmr.demo.Models;

public class AutoCamper {

    private String model;
    private int id;


    public AutoCamper(String model, int id){
        this.model = model;
        this.id = id;
    }
    public AutoCamper(){}


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
