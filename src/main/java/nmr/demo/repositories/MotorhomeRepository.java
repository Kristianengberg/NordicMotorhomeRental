package nmr.demo.repositories;

import nmr.demo.utilities.DatabaseConnectionManager;


import nmr.demo.models.MotorHome;

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
        MotorHome MotorHomeToReturn = new MotorHome();
        try {
            PreparedStatement getSingleStudent = conn.prepareStatement("SELECT * FROM Motorhome WHERE id=" + id);
            ResultSet rs = getSingleStudent.executeQuery();
            while(rs.next()){
                MotorHomeToReturn.setLicensePlateNo(rs.getString(1));
                MotorHomeToReturn.setModel(rs.getString(2));
                MotorHomeToReturn.setBeds(rs.getInt(3));
                MotorHomeToReturn.setKilometers(rs.getDouble(4));
                MotorHomeToReturn.setPrice(rs.getDouble(5));
                MotorHomeToReturn.setEngineBlockNo(rs.getInt(6));
                MotorHomeToReturn.setAccessible(rs.getString(7));

            }
        }
        catch(SQLException s){
            s.printStackTrace();
        }
        return MotorHomeToReturn;
    }

    @Override
    public List<MotorHome> readAll() {
        List<MotorHome> allMotorHome = new ArrayList<MotorHome>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Motorhome");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                MotorHome tempMotorHome = new MotorHome();
                tempMotorHome.setLicensePlateNo(rs.getString(1));
                tempMotorHome.setModel(rs.getString(2));
                tempMotorHome.setBeds(rs.getInt(3));
                tempMotorHome.setKilometers(rs.getDouble(4));
                tempMotorHome.setPrice(rs.getDouble(5));
                tempMotorHome.setEngineBlockNo(rs.getInt(6));
                tempMotorHome.setAccessible(rs.getString(7));
                allMotorHome.add(tempMotorHome);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allMotorHome;
    }

    @Override
    public boolean update(MotorHome model) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    public boolean delete(String id){
        if(MotorHome.getLicensePlateNo() == id) {
            String sql = "DELETE FROM Motorhome WHERE LicensPlateNo = ?";

            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);

                pstmt.setString(1, id);

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

