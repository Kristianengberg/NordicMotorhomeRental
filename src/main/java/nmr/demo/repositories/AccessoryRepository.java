package nmr.demo.repositories;

// import nmr.demo.util.DataBaseConnectionManager;
import nmr.demo.Models.Accessories;

import java.util.List;

public class AccessoryRepository implements IRepository<Accessories>{
    @Override
    public boolean create(Accessories model) {
        return false;
    }

    @Override
    public Accessories read(int id) {
        return null;
    }

    @Override
    public List<Accessories> readAll() {
        return null;
    }

    @Override
    public boolean update(Accessories model) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    // private Connection conn;


    /*public AccessoryRepository() {
        this.conn = DataBaseConnectionManager.getDataBaseConnection();
    }
    */


}
