package nmr.demo.repositories;

import nmr.demo.models.*;
import nmr.demo.utilities.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvoiceRepository implements IRepository<Invoice> {

    private Connection conn;


    public InvoiceRepository() throws SQLException { //ret til i database at den skal lave try catch
        this.conn = DatabaseConnectionManager.getDBConnection();
    }


    @Override
    public boolean create(Invoice model) {
        return false;
    }

    @Override
    public Invoice read(int id) {
        Invoice invoiceToReturn = new Invoice();
        Employee employeeToReturn = new Employee();
        Customer customerToReturn = new Customer();
        Accessories accessoriesToReturn = new Accessories();
        MotorHome licensePlateNoToReturn = new MotorHome();
        try {
            PreparedStatement getSingleInvoice = conn.prepareStatement("SELECT * FROM Invoice WHERE id=" + id);
            ResultSet rs = getSingleInvoice.executeQuery();
            while(rs.next()){
                invoiceToReturn.setInvoiceId(rs.getInt(1));
                invoiceToReturn.setDateStart(rs.getDate(2));
                invoiceToReturn.setDateEnd(rs.getDate(3));
                invoiceToReturn.setPickUp(rs.getString(4));
                invoiceToReturn.setDropOff(rs.getString(5));
                invoiceToReturn.setTotalPrice(rs.getDouble(6));
                employeeToReturn.setEmployeeId(rs.getInt(7));
                customerToReturn.setCustomerId(rs.getInt(8));
                accessoriesToReturn.setAccessoriesId(rs.getInt(9));
                licensePlateNoToReturn.setLicensePlateNo(rs.getString(10));
            }
        }
        catch(SQLException s){
            s.printStackTrace();
        }
        return invoiceToReturn;
    }

    @Override
    public List<Invoice> readAll() {
        List<Invoice> allInvoices = new ArrayList<Invoice>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Invoice");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Invoice tempInvoice = new Invoice();
                Employee tempEmployee = new Employee();
                Customer tempCustomer = new Customer();
                Accessories tempAccessory = new Accessories();
                MotorHome tempLicensePlateNo = new MotorHome();

                tempInvoice.setInvoiceId(rs.getInt(1));
                tempInvoice.setDateStart(rs.getDate(2));
                tempInvoice.setDateEnd(rs.getDate(3));
                tempInvoice.setPickUp(rs.getString(4));
                tempInvoice.setDropOff(rs.getString(5));
                tempInvoice.setTotalPrice(rs.getInt(6));
                tempEmployee.setEmployeeId(rs.getInt(7));
                tempCustomer.setCustomerId(rs.getInt(8));
                tempAccessory.setAccessoriesId(rs.getInt(9));
                tempLicensePlateNo.setLicensePlateNo(rs.getString(10));

                allInvoices.add(tempInvoice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allInvoices;
    }

    @Override
    public boolean update(Invoice model) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        if(Invoice.getInvoiceId() == id) {
            String sql = "DELETE FROM Invoice WHERE Invoice_id = ?";

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
