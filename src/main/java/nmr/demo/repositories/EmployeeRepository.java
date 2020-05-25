package nmr.demo.repositories;

import nmr.demo.models.Customer;
import nmr.demo.models.Employee;
import nmr.demo.models.MotorHome;
import nmr.demo.utilities.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class EmployeeRepository implements IRepository<Employee> {

    private Connection conn;


    public EmployeeRepository() throws SQLException { //ret til i database at den skal lave try catch
        this.conn = DatabaseConnectionManager.getDBConnection();
    }


    @Override
    public boolean create(Employee model) {
        try {
            PreparedStatement CreateEmployee = conn.prepareStatement("INSERT INTO employee" + "(empName,position,address,zipCode,phone,email)VALUES" + "(?,?,?,?,?,?);");
            CreateEmployee.setString(1, model.getEmpName());
            CreateEmployee.setString(2,model.getPosition());
            CreateEmployee.setString(3,model.getAddress());
            CreateEmployee.setInt(4,model.getZipCode());
            CreateEmployee.setInt(5,model.getPhone());
            CreateEmployee.setString(6,model.getEmail());


            CreateEmployee.executeUpdate();
            return true;

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Employee read(int id) {
        return null;
    }

    @Override
    public List<Employee> readAll() {
        return null;
    }

    @Override
    public boolean update(Employee model) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        if(Employee.getEmployeeId() == id) {
            String sql = "DELETE FROM Customer WHERE Employee_id = ?";

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
