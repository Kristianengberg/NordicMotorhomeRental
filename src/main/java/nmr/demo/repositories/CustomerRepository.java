package nmr.demo.repositories;

import nmr.demo.models.Accessories;
import nmr.demo.utilities.DatabaseConnectionManager;
import nmr.demo.models.Customer;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        Customer customerToReturn = new Customer();
        try {
            PreparedStatement getSingleCustomer = conn.prepareStatement("SELECT * FROM customer WHERE id=" + id);
            ResultSet rs = getSingleCustomer.executeQuery();
            while(rs.next()){
                customerToReturn.setCustomerId(rs.getInt(1));
                customerToReturn.setCustomerName(rs.getString(2));
                customerToReturn.setAddress(rs.getString(3));
                customerToReturn.setZipCode(rs.getInt(4));
                customerToReturn.setPhone(rs.getInt(5));
                customerToReturn.setEmail(rs.getString(6));
                customerToReturn.setCustomerType(rs.getBoolean(7));
            }
        }
        catch(SQLException s){
            s.printStackTrace();
        }
        return customerToReturn;
    }

    @Override
    public List<Customer> readAll() {
        List<Customer> allCustomer = new ArrayList<Customer>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customer");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Customer tempCustomer = new Customer();
                tempCustomer.setCustomerId(rs.getInt(1));
                tempCustomer.setCustomerName(rs.getString(2));
                tempCustomer.setAddress(rs.getString(3));
                tempCustomer.setZipCode(rs.getInt(4));
                tempCustomer.setPhone(rs.getInt(5));
                tempCustomer.setEmail(rs.getString(6));
                tempCustomer.setCustomerType(rs.getBoolean(7));

                allCustomer.add(tempCustomer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allCustomer;
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
