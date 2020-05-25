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
    public boolean update(Employee employee) {
        try {
            PreparedStatement myStmt = conn.prepareStatement("UPDATE Employee SET employeeId = ?, empName = ?, position = ?, address = ?, zipCode = ?, phone = ?, email = ? WHERE employeeId =" + Employee.getEmployeeId());
            myStmt.setInt(1, employee.getEmployeeId());
            myStmt.setString(2, employee.getEmpName());
            myStmt.setString(3, employee.getPosition());
            myStmt.setString(4, employee.getAddress());
            myStmt.setInt(5, employee.getZipCode());
            myStmt.setInt(6, employee.getPhone());
            myStmt.setString(7, employee.getEmail());

            System.out.println(myStmt);
            myStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
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
