package nmr.demo.repositories;

import nmr.demo.models.Customer;
import nmr.demo.models.Employee;
import nmr.demo.utilities.DatabaseConnectionManager;
import nmr.demo.models.Invoice;

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
        Invoice InvoiceToReturn = new Invoice();
        try {
            PreparedStatement getSingleInvoice = conn.prepareStatement("SELECT * FROM Invoice WHERE id=" + id);
            ResultSet rs = getSingleInvoice.executeQuery();
            while(rs.next()){
                InvoiceToReturn.setInvoiceId(rs.getInt(1));
                InvoiceToReturn.setDateStart(rs.getDate(2));
                InvoiceToReturn.setDateEnd(rs.getDate(3));
                InvoiceToReturn.setPickUp(rs.getString(4));
                InvoiceToReturn.setDropOff(rs.getString(5));
                InvoiceToReturn.setTotalPrice(rs.getDouble(6));
                InvoiceToReturn.setEmployeeId(rs.getInt(7));
                InvoiceToReturn.setCustomerId(rs.getInt(8));
                InvoiceToReturn.setAccessoriesId(rs.getInt(9));
                InvoiceToReturn.setLicensePlateNo(rs.getInt(10));
            }
        }
        catch(SQLException s){
            s.printStackTrace();
        }
        return InvoiceToReturn;
    }

    @Override
    public List<Invoice> readAll() {
        List<Invoice> allInvoices = new ArrayList<Invoice>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Invoice");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Invoice tempInvoice = new Invoice();
                tempInvoice.setInvoiceId(rs.getInt(1));
                tempInvoice.setDateStart(rs.getDate(2));
                tempInvoice.setDateEnd(rs.getDate(3));
                tempInvoice.setPickUp(rs.getString(4));
                tempInvoice.setDropOff(rs.getString(5));
                tempInvoice.setTotalPrice(rs.getInt(6));
                tempInvoice.setEmployeeId(rs.getInt(7));
                tempInvoice.setCustomerId(rs.getInt(8));
                tempInvoice.setAccessoriesId(rs.getInt(9));
                tempInvoice.setLicensePlateNo(rs.getString(10));


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
