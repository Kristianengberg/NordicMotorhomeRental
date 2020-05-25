package nmr.demo.repositories;

import nmr.demo.models.Customer;
import nmr.demo.utilities.DatabaseConnectionManager;
import nmr.demo.models.Invoice;

import java.sql.Connection;
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
