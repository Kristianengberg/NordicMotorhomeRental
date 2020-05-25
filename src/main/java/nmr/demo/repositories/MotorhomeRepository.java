package nmr.demo.repositories;

// import nmr.demo.util.DataBaseConnectionManager;

import nmr.demo.models.MotorHome;
import nmr.demo.utilities.DatabaseConnectionManager;

import java.sql.Connection;
import java.util.List;




public class MotorhomeRepository implements IRepository<MotorHome> {

     private Connection conn;


    public MotorhomeRepository() {
        this.conn = DatabaseConnectionManager.getDBConnection();
    }



    public boolean create(MotorHome model) {
        return false;
    }

    @Override
    public MotorHome read(int id) {
        return null;
    }

    @Override
    public List<MotorHome> readAll() {
        return null;
    }

    @Override
    public boolean update(MotorHome model) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
