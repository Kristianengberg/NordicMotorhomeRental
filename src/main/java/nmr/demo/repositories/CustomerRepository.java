package nmr.demo.repositories;

// import nmr.demo.util.DataBaseConnectionManager;
import nmr.demo.models.Customer;

import java.util.List;

public class CustomerRepository implements IRepository<Customer> {
    @Override
    public boolean create(Customer model) {
        return false;
    }

    @Override
    public Customer read(int id) {
        return null;
    }

    @Override
    public List<Customer> readAll() {
        return null;
    }

    @Override
    public boolean update(Customer model) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    // private Connection conn;


    /*public CustomerRepository() {
        this.conn = DataBaseConnectionManager.getDataBaseConnection();
    }
    */


}
