package nmr.demo.repositories;

// import nmr.demo.util.DataBaseConnectionManager;
import nmr.demo.models.Invoice;

import java.util.List;

public class InvoiceRepository implements IRepository<Invoice> {
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

    // private Connection conn;


    /*public InvoiceRepository() {
        this.conn = DataBaseConnectionManager.getDataBaseConnection();
    }
    */


}
