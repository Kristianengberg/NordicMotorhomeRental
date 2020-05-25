package nmr.demo.repositories;

// import nmr.demo.util.DataBaseConnectionManager;

import nmr.demo.Models.Invoice;
import nmr.demo.Models.Motorhome;

import java.util.List;




public class MotorhomeRepository implements IRepository {

    // private Connection conn;


    /*public MotorhomeRepository() {
        this.conn = DataBaseConnectionManager.getDataBaseConnection();
    }
    */


    public boolean create(Motorhome model) {
        return false;
    }

    @Override
    public Motorhome read(int id) {
        return null;
    }

    @Override
    public List<Motorhome> readAll() {
        return null;
    }

    @Override
    public boolean update(Motorhome model) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
