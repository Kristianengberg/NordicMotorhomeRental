package nmr.demo.repositories;

// import nmr.demo.util.DataBaseConnectionManager;

import java.util.List;

public class CustomerRepository implements IRepository {

    // private Connection conn;


    /*public CustomerRepository() {
        this.conn = DataBaseConnectionManager.getDataBaseConnection();
    }
    */

    @Override
    public boolean create(Object model) {
        return false;
    }

    @Override
    public Object read(int id) {
        return null;
    }

    @Override
    public List<Object> readAll() {
        return null;
    }

    @Override
    public boolean update(Object student) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
