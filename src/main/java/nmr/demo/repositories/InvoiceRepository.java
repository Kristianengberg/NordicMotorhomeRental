package nmr.demo.repositories;

import nmr.demo.models.*;
import nmr.demo.utilities.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        return null;
    }

    @Override
    public List<Invoice> readAll() {
        return null;
    }

    @Override
    public boolean update(Invoice invoice) {
        Employee employeeToReturn = new Employee();
        Customer customerToReturn = new Customer();
        Accessories accessoriesToReturn = new Accessories();
        MotorHome motorHomeToReturn = new MotorHome();

        try {
            PreparedStatement myStmt = conn.prepareStatement("UPDATE Invoice SET invoiceId = ?, dateStart = ?, dateEnd = ?, pickUp = ?,  dropOff = ?, totalPrice = ?, employeeId = ?, customerId = ?, accessoriesId = ?, licensePlateNo = ? WHERE invoiceId =" + Invoice.getInvoiceId());
            myStmt.setInt(1, invoice.getInvoiceId());
            myStmt.setDate(2, (Date) invoice.getDateStart());
            myStmt.setDate(3, (Date) invoice.getDateEnd());
            myStmt.setString(4, invoice.getPickUp());
            myStmt.setString(5, invoice.getDropOff());

            myStmt.setInt(7, employeeToReturn.getEmployeeId());
            myStmt.setInt(8, customerToReturn.getCustomerId());
            myStmt.setInt(9, accessoriesToReturn.getId());
            myStmt.setString(10, motorHomeToReturn.getLicensePlateNo());

            System.out.println(myStmt);
            myStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
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
