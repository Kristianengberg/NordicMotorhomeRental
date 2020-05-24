package nmr.demo.repositories;

import nmr.demo.Models.AutoCamper;
import nmr.demo.utilities.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutoCamperRepositoryImpl implements IAutoCamperRepository {

    private Connection conn;
    public AutoCamperRepositoryImpl(){
        try {
            this.conn = DatabaseConnectionManager.getDBConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public AutoCamper read(int id) {
        return null;
    }

    @Override
    public boolean create() {
        return false;
    }

    @Override
    public List<AutoCamper> readAll() {
        List<AutoCamper> allAutoCampers = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM autocamper");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                AutoCamper tempAutoCamper = new AutoCamper();
                tempAutoCamper.setId(rs.getInt(1));
                tempAutoCamper.setModel(rs.getString(2));
                allAutoCampers.add(tempAutoCamper);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allAutoCampers;
    }

    @Override
    public boolean update() {
        return false;
    }

    @Override
    public boolean delete() {
        return false;
    }
}

