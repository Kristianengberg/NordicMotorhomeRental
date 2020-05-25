package nmr.demo.repositories;

import nmr.demo.utilities.DatabaseConnectionManager;
import nmr.demo.models.Customer;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CustomerRepository implements IRepository<Customer> {

    private Connection conn;


    public CustomerRepository() throws SQLException { //ret til i database at den skal lave try catch
        this.conn = DatabaseConnectionManager.getDBConnection();
    }


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
        if(Customer.getCustomerId() == id) {
            String sql = "DELETE FROM Customer WHERE Customer_id = ?";

            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);

                pstmt.setInt(1, id);

                pstmt.executeUpdate();


            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }else{
            System.out.println("Fail");
        }
        return false;
    }


}
