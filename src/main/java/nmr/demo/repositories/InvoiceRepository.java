package nmr.demo.repositories;

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

        return false;

    }




}
