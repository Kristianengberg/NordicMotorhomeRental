package nmr.demo.repositories;

import nmr.demo.models.*;
import nmr.demo.utilities.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvoiceRepository implements IRepository<Invoice> {

    private Connection conn;


    public InvoiceRepository()  { //ret til i database at den skal lave try catch
        this.conn = DatabaseConnectionManager.getDBConnection();
    }


    @Override
    public boolean create(Invoice model) {
        try {
            PreparedStatement CreateInvoice = conn.prepareStatement("INSERT INTO Invoice" + "(DateStart,DateEnd,PickUp,DropOff,TotalPrice,Employee_id_fk,Customer_id_fk,Accessory_id_fk,Motorhome_LicensPlateNo,InvoiceDone)VALUES" + "( ?, ?, ?,?, ?, ?,?, ?, ?, ?);");
            //CreateInvoice.setInt(1, model.getInvoiceId());
            CreateInvoice.setDate(1, (Date) model.getDateStart());
            CreateInvoice.setDate(2, (Date) model.getDateEnd());
            CreateInvoice.setString(3, model.getPickUp());
            CreateInvoice.setString(4, model.getDropOff());
            CreateInvoice.setDouble(5, model.getTotalPrice());
            CreateInvoice.setInt(6, model.getEmployeeId());
            CreateInvoice.setInt(7, model.getCustomerId());
            CreateInvoice.setInt(8, model.getAccessoriesId());
            CreateInvoice.setString(9, model.getLicensePlateNo());
            CreateInvoice.setBoolean(10, model.getInvoiceDone());

            CreateInvoice.executeUpdate();
            return true;

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Invoice read(int id) {
        Invoice invoiceToReturn = new Invoice();
        Employee employeeToReturn = new Employee();
        Customer customerToReturn = new Customer();
        Accessories accessoriesToReturn = new Accessories();
        MotorHome licensePlateNoToReturn = new MotorHome();

        try {
            System.out.print(id);
            PreparedStatement getSingleInvoice = conn.prepareStatement("SELECT * FROM Invoice WHERE Invoice_id=" + id);
            ResultSet rs = getSingleInvoice.executeQuery();
            while(rs.next()){
                invoiceToReturn.setInvoiceId(rs.getInt(1));

                invoiceToReturn.setDateStart(rs.getDate(2));


                invoiceToReturn.setDateEnd(rs.getDate(3));


                invoiceToReturn.setPickUp(rs.getString(4));


                invoiceToReturn.setDropOff(rs.getString(5));


                invoiceToReturn.setTotalPrice(rs.getDouble(6));


                invoiceToReturn.setEmployeeId(rs.getInt(7));


                invoiceToReturn.setCustomerId(rs.getInt(8));

                invoiceToReturn.setAccessoriesId(rs.getInt(9));

                invoiceToReturn.setLicensePlateNo(rs.getString(10));

            }
        }
        catch(SQLException s){
            s.printStackTrace();
        }
        return invoiceToReturn;
    }

    public Invoice readByCustomerID(int id) {
        Invoice invoiceToReturn = new Invoice();

        try {

            PreparedStatement getSingleInvoice = conn.prepareStatement("SELECT * FROM Invoice WHERE Customer_id_fk=" + id);
            ResultSet rs = getSingleInvoice.executeQuery();
            while(rs.next()){
                invoiceToReturn.setInvoiceId(rs.getInt(1));
                invoiceToReturn.setDateStart(rs.getDate(2));
                invoiceToReturn.setDateEnd(rs.getDate(3));
                invoiceToReturn.setPickUp(rs.getString(4));
                invoiceToReturn.setDropOff(rs.getString(5));
                invoiceToReturn.setTotalPrice(rs.getDouble(6));
                invoiceToReturn.setEmployeeId(rs.getInt(7));
                invoiceToReturn.setCustomerId(rs.getInt(8));
                invoiceToReturn.setAccessoriesId(rs.getInt(9));
                invoiceToReturn.setLicensePlateNo(rs.getString(10));
                invoiceToReturn.setInvoiceDone(rs.getBoolean(11));

            }
        }
        catch(SQLException s){
            s.printStackTrace();
        }
        return invoiceToReturn;
    }

    @Override
    public List<Invoice> readAll() {
        List<Invoice> allInvoices = new ArrayList<Invoice>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Invoice");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Invoice tempInvoice = new Invoice();
                Employee tempEmployee = new Employee();
                Customer tempCustomer = new Customer();
                Accessories tempAccessory = new Accessories();
                MotorHome tempLicensePlateNo = new MotorHome();

                tempInvoice.setInvoiceId(rs.getInt(1));
                tempInvoice.setDateStart(rs.getDate(2));
                tempInvoice.setDateEnd(rs.getDate(3));
                tempInvoice.setPickUp(rs.getString(4));
                tempInvoice.setDropOff(rs.getString(5));
                tempInvoice.setTotalPrice(rs.getInt(6));
                tempEmployee.setEmployeeId(rs.getInt(7));
                tempCustomer.setCustomerId(rs.getInt(8));
                tempAccessory.setAccessory_id(rs.getInt(9));
                tempLicensePlateNo.setLicensePlateNo(rs.getString(10));


                allInvoices.add(tempInvoice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allInvoices;
    }


    @Override
    public boolean update(Invoice invoice) {
        Employee employeeToReturn = new Employee();
        Customer customerToReturn = new Customer();
        Accessories accessoriesToReturn = new Accessories();
        MotorHome motorHomeToReturn = new MotorHome();

        try {
            PreparedStatement myStmt = conn.prepareStatement("UPDATE Invoice SET invoiceId = ?, dateStart = ?, dateEnd = ?, pickUp = ?,  dropOff = ?, totalPrice = ?, employeeId = ?, customerId = ?, accessoriesId = ?, licensePlateNo = ? WHERE invoiceId =" + invoice.getInvoiceId());
            myStmt.setInt(1, invoice.getInvoiceId());
            myStmt.setDate(2, (Date) invoice.getDateStart());
            myStmt.setDate(3, (Date) invoice.getDateEnd());
            myStmt.setString(4, invoice.getPickUp());
            myStmt.setString(5, invoice.getDropOff());
            myStmt.setInt(7, employeeToReturn.getEmployeeId());
            myStmt.setInt(8, customerToReturn.getCustomerId());
            myStmt.setInt(9, accessoriesToReturn.getAccessory_id());
            myStmt.setString(10, motorHomeToReturn.getLicensePlateNo());

            System.out.println(myStmt);
            myStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {

            String sql = "DELETE FROM Invoice WHERE Invoice_id = ?";

            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);

                pstmt.setInt(1, id);

                pstmt.executeUpdate();

                return true;


            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Fail");

        return false;


    }

}
