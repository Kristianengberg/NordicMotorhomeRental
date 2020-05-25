package nmr.demo.repositories;

import nmr.demo.models.Invoice;
import nmr.demo.models.MotorHome;
import nmr.demo.utilities.DatabaseConnectionManager;
import nmr.demo.models.Accessories;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccessoryRepository implements IRepository<Accessories>{

    private Connection conn;


    public AccessoryRepository() throws SQLException { // try catch
        this.conn = DatabaseConnectionManager.getDBConnection();
    }



    @Override
    public boolean create(Accessories model) {
        return false;
    }

    @Override
    public Accessories read(int id) {
        Accessories AccessoriesToReturn = new Accessories();
        try {
            PreparedStatement getSingleAccessory = conn.prepareStatement("SELECT * FROM Motorhome WHERE id=" + id);
            ResultSet rs = getSingleAccessory.executeQuery();
            while(rs.next()){
                AccessoriesToReturn.setAccessoriesId(rs.getInt(1));
                AccessoriesToReturn.setPrice(rs.getDouble(2));
                AccessoriesToReturn.setType(rs.getString(3));
            }
        }
        catch(SQLException s){
            s.printStackTrace();
        }
        return AccessoriesToReturn;
    }

    @Override
    public List<Accessories> readAll() {
        List<Accessories> allAccessories = new ArrayList<Accessories>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM accessories");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Accessories tempAccessories = new Accessories();
                tempAccessories.setAccessoriesId(rs.getInt(1));
                tempAccessories.setPrice(rs.getDouble(2));
                tempAccessories.setType(rs.getString(3));

                allAccessories.add(tempAccessories);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allAccessories;
    }

    @Override
    public boolean update(Accessories model) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        if(Accessories.getAccessoriesId() == id) {
            String sql = "DELETE FROM Invoice WHERE Accessory_id = ?";

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
