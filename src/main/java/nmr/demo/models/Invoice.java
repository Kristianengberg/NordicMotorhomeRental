package nmr.demo.models;

import java.util.Date;

public class Invoice {
    private static int invoiceId;
    private Date dateStart;
    private Date dateEnd;
    private String pickUp;
    private String dropOff;
    private double totalPrice;
    Employee employeeId;
    Customer customerId;
    Accessories accessoriesId;
    MotorHome licensePlateNo;


    public Invoice() {
    }

    public Invoice(int invoiceId, Date dateStart, Date dateEnd, String pickUp, String dropOff, double totalPrice, Employee employeeId, Customer customerId, Accessories accessoriesId, MotorHome licensePlateNo) {
        this.invoiceId = invoiceId;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.pickUp = pickUp;
        this.dropOff = dropOff;
        this.totalPrice = totalPrice;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.accessoriesId = accessoriesId;
        this.licensePlateNo = licensePlateNo;
    }

    public static int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getPickUp() {
        return pickUp;
    }

    public void setPickUp(String pickUp) {
        this.pickUp = pickUp;
    }

    public String getDropOff() {
        return dropOff;
    }

    public void setDropOff(String dropOff) {
        this.dropOff = dropOff;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Accessories getAccessoriesId() {
        return accessoriesId;
    }

    public void setAccessoriesId(Accessories accessoriesId) {
        this.accessoriesId = accessoriesId;
    }

    public MotorHome getLicensePlateNo() {
        return licensePlateNo;
    }

    public void setLicensePlateNo(MotorHome licensePlateNo) {
        this.licensePlateNo = licensePlateNo;
    }
}