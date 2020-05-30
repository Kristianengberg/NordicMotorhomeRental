package nmr.demo.repositories;

import nmr.demo.models.Customer;
import nmr.demo.models.Employee;
import nmr.demo.models.MotorHome;
import nmr.demo.utilities.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmployeeRepository implements IRepository<Employee> {

    private Connection conn;


    public EmployeeRepository() { //ret til i database at den skal lave try catch
        this.conn = DatabaseConnectionManager.getDBConnection();
    }


    @Override
    public boolean create(Employee model) {
        try {
            PreparedStatement CreateEmployee = conn.prepareStatement("INSERT INTO employee" + "(empName,position,address,zipCode,phone,email)VALUES" + "(?,?,?,?,?,?);");
            CreateEmployee.setString(1, model.getEmpName());
            CreateEmployee.setString(2,model.getPosition());
            CreateEmployee.setString(3,model.getAddress());
            CreateEmployee.setString(4,model.getZipCode());
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
        Employee employeeToReturn = new Employee();
        try {
            PreparedStatement getSingleEmployee = conn.prepareStatement("SELECT * FROM Employee WHERE Employee_id=" + id);
            ResultSet rs = getSingleEmployee.executeQuery();
            while(rs.next()){
                employeeToReturn.setEmployeeId(rs.getInt(1));
                employeeToReturn.setEmpName(rs.getString(2));
                employeeToReturn.setPosition(rs.getString(3));
                employeeToReturn.setAddress(rs.getString(4));
                employeeToReturn.setZipCode(rs.getString(5));
                employeeToReturn.setPhone(rs.getInt(6));
                employeeToReturn.setEmail(rs.getString(7));
            }
        }
        catch(SQLException s){
            s.printStackTrace();
        }
        return employeeToReturn;
    }

    @Override
    public List<Employee> readAll() {
        List<Employee> allEmployees = new ArrayList<Employee>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Employee");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Employee tempEmployee = new Employee();
                tempEmployee.setEmployeeId(rs.getInt(1));
                tempEmployee.setEmpName(rs.getString(2));
                tempEmployee.setPosition(rs.getString(3));
                tempEmployee.setAddress(rs.getString(4));
                tempEmployee.setZipCode(rs.getString(5));
                tempEmployee.setPhone(rs.getInt(6));
                tempEmployee.setEmail(rs.getString(7));

                allEmployees.add(tempEmployee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allEmployees;
    }

    @Override
    public boolean update(Employee employee) {
        try {
            PreparedStatement myStmt = conn.prepareStatement("UPDATE Employee SET employeeId = ?, empName = ?, position = ?, address = ?, zipCode = ?, phone = ?, email = ? WHERE employeeId =" + Employee.getEmployeeId());
            myStmt.setInt(1, employee.getEmployeeId());
            myStmt.setString(2, employee.getEmpName());
            myStmt.setString(3, employee.getPosition());
            myStmt.setString(4, employee.getAddress());
            myStmt.setString(5, employee.getZipCode());
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
