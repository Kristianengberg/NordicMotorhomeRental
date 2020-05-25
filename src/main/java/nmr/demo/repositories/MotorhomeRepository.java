package nmr.demo.repositories;

import nmr.demo.utilities.DatabaseConnectionManager;


import nmr.demo.models.MotorHome;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
