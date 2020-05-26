package nmr.demo.repositories;

import nmr.demo.models.Invoice;
import nmr.demo.utilities.DatabaseConnectionManager;
import nmr.demo.models.Accessories;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        return null;
    }

    @Override
    public List<Accessories> readAll() {
        return null;
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
