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


    public AccessoryRepository()  { // try catch
        this.conn = DatabaseConnectionManager.getDBConnection();
    }




    @Override
    public boolean create(Accessories model) {
        try {
            PreparedStatement CreateAccessory = conn.prepareStatement("INSERT INTO accessories" + "(accessoryType,price)VALUES" + "(?,?);");
            CreateAccessory.setString(1,model.getAccessoriesType());
            CreateAccessory.setDouble(2,model.getPrice());



            CreateAccessory.executeUpdate();
            return true;

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Accessories read(int id) {
        Accessories AccessoriesToReturn = new Accessories();
        try {
            PreparedStatement getSingleAccessory = conn.prepareStatement("SELECT * FROM accessories WHERE Accessory_id=" + id);
            ResultSet rs = getSingleAccessory.executeQuery();
            while(rs.next()){
                AccessoriesToReturn.setAccessory_id(rs.getInt(1));
                AccessoriesToReturn.setType(rs.getString(2));
                AccessoriesToReturn.setPrice(rs.getDouble(3));
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
                tempAccessories.setAccessory_id(rs.getInt(1));
                tempAccessories.setType(rs.getString(2));
                tempAccessories.setPrice(rs.getDouble(3));
                allAccessories.add(tempAccessories);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allAccessories;
    }

    @Override
    public boolean update(Accessories accessories) {
        try {
           PreparedStatement myStmt = conn.prepareStatement("UPDATE Accessories SET accessory_id = ?, price = ?, type = ? WHERE accessory_id =" + Accessories.getAccessory_id());
           myStmt.setInt(1, accessories.getAccessory_id());
           myStmt.setDouble(2, accessories.getPrice());
           myStmt.setString(3,accessories.getAccessoriesType());

            System.out.println(myStmt);
            myStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if(Accessories.getAccessory_id() == id) {
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
