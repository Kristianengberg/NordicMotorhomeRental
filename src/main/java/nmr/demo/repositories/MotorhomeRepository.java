package nmr.demo.repositories;

// import nmr.demo.util.DataBaseConnectionManager;

import nmr.demo.models.MotorHome;
import nmr.demo.utilities.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        List<MotorHome> allAutoCampers = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM autocamper");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                MotorHome tempAutoCamper = new MotorHome();
                tempAutoCamper.setBeds(rs.getInt(1));
                tempAutoCamper.setModel(rs.getString(2));
                allAutoCampers.add(tempAutoCamper);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allAutoCampers;
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
