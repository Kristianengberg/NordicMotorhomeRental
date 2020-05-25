package nmr.demo.repositories;

import nmr.demo.models.MotorHome;
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


    public CustomerRepository() { //ret til i database at den skal lave try catch
        this.conn = DatabaseConnectionManager.getDBConnection();
    }



    @Override
    public boolean create(Customer model) {
        try {
            PreparedStatement CreateCustomer = conn.prepareStatement("INSERT INTO customer" + "(CustomerName,address,zipCode,phone,email,customerType)VALUES" + "(?,?,?,?,?,?);");
            CreateCustomer.setString(1,model.getCustomerName());
            CreateCustomer.setString(2,model.getAddress());
            CreateCustomer.setString(3,model.getZipCode());
            CreateCustomer.setInt(4,model.getPhone());
            CreateCustomer.setString(5,model.getEmail());
            CreateCustomer.setString(6,model.getCustomerType());

            CreateCustomer.executeUpdate();
            return true;

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Customer read(int id) {
        return null;
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
                tempCustomer.setZipCode(rs.getString(4));
                tempCustomer.setPhone(rs.getInt(5));
                tempCustomer.setEmail(rs.getString(6));
                tempCustomer.setCustomerType(rs.getString(7));

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

            String sql = "DELETE FROM Customer WHERE Customer_id = ?";

            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);

                pstmt.setInt(1, id);

                pstmt.executeUpdate();
                return true;


            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Fail");

        return false;
    }


}
