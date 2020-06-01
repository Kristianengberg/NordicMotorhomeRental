package nmr.demo.repositories;

import nmr.demo.utilities.DatabaseConnectionManager;


import nmr.demo.models.MotorHome;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MotorhomeRepository implements IRepository<MotorHome> {

    private Connection conn;


    public MotorhomeRepository() {
        this.conn = DatabaseConnectionManager.getDBConnection();
    }
    @Override
    public boolean create(MotorHome model) {
        try {
            String sql = "INSERT INTO Motorhome (licensPlateNo, Model, Beds, isAccessible, Km,Price,EngineBlockNo) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement CreateMotorHome = conn.prepareStatement(sql);
            CreateMotorHome.setString(1, model.getLicensePlateNo());
            CreateMotorHome.setString(2,model.getModel());
            CreateMotorHome.setInt(3,model.getBeds());
            CreateMotorHome.setString(4,model.getAccessible());
            CreateMotorHome.setDouble(5,model.getKilometers());
            CreateMotorHome.setDouble(6,model.getPrice());
            CreateMotorHome.setInt(7,model.getEngineBlockNo());
            CreateMotorHome.executeUpdate();
            return true;

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public MotorHome read(int id) {
        MotorHome MotorHomeToReturn = new MotorHome();
        try {
            PreparedStatement getSingleMotorHome = conn.prepareStatement("SELECT * FROM Motorhome WHERE engineBlockNo=" + id);
            ResultSet rs = getSingleMotorHome.executeQuery();
            while(rs.next()){
                MotorHomeToReturn.setLicensePlateNo(rs.getString(1));
                MotorHomeToReturn.setModel(rs.getString(2));
                MotorHomeToReturn.setBeds(rs.getInt(3));
                MotorHomeToReturn.setAccessible(rs.getString(4));
                MotorHomeToReturn.setKilometers(rs.getDouble(5));
                MotorHomeToReturn.setPrice(rs.getDouble(6));
                MotorHomeToReturn.setEngineBlockNo(rs.getInt(7));
                MotorHomeToReturn.setStart(rs.getDate(8));
                MotorHomeToReturn.setFinish(rs.getDate(9));


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
                tempMotorHome.setAccessible(rs.getString(4));
                tempMotorHome.setKilometers(rs.getDouble(5));
                tempMotorHome.setPrice(rs.getDouble(6));
                tempMotorHome.setEngineBlockNo(rs.getInt(7));
                tempMotorHome.setStart(rs.getDate(8));
                tempMotorHome.setFinish(rs.getDate(9));
                allMotorHome.add(tempMotorHome);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allMotorHome;
    }

    public MotorHome readByLicense(String licensePlateNo) {
        MotorHome MotorHomeToReturn = new MotorHome();
        try {
            PreparedStatement getSingleMotorHome = conn.prepareStatement("SELECT * FROM Motorhome WHERE LicensPlateNo=?");
            getSingleMotorHome.setString(1, licensePlateNo);
            ResultSet rs = getSingleMotorHome.executeQuery();
            while(rs.next()){
                MotorHomeToReturn.setLicensePlateNo(rs.getString(1));
                MotorHomeToReturn.setModel(rs.getString(2));
                MotorHomeToReturn.setBeds(rs.getInt(3));
                MotorHomeToReturn.setAccessible(rs.getString(4));
                MotorHomeToReturn.setKilometers(rs.getDouble(5));
                MotorHomeToReturn.setPrice(rs.getDouble(6));
                MotorHomeToReturn.setEngineBlockNo(rs.getInt(7));
                MotorHomeToReturn.setStart(rs.getDate(8));
                MotorHomeToReturn.setFinish(rs.getDate(9));


            }
        }
        catch(SQLException s){
            s.printStackTrace();
        }
        return MotorHomeToReturn;
    }

    @Override
    public boolean update(MotorHome motorHome) {
        try {
            PreparedStatement myStmt = conn.prepareStatement("UPDATE Motorhome SET LicensPlateNo = ?, Model = ?, Beds = ?, isAccessible = ?, Km = ?, Price = ?, EngineBlockNo = ? WHERE engineBlockNo=" + motorHome.getEngineBlockNo());
            myStmt.setString(1, motorHome.getLicensePlateNo());
            myStmt.setString(2, motorHome.getModel());
            myStmt.setInt(3, motorHome.getBeds());
            myStmt.setString(4, motorHome.getAccessible());
            myStmt.setDouble(5, motorHome.getKilometers());
            myStmt.setDouble(6, motorHome.getPrice());
            myStmt.setInt(7, motorHome.getEngineBlockNo());
            myStmt.setDate(8, motorHome.getStart());
            myStmt.setDate(9, motorHome.getFinish());
            myStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    /*public boolean delete(int id) {
        return false;
    }
*/
    public boolean delete(int id){
            String sql = "DELETE FROM Motorhome WHERE engineBlockNo = ?";

            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);

                pstmt.setInt(1, id);

                pstmt.executeUpdate();
                return true;


            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        return false;

    }
}
