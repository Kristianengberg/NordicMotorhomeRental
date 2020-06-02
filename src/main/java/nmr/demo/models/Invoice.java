package nmr.demo.models;

import java.util.Date;

public class Invoice {
    private int invoiceId;
    private Date dateStart;
    private Date dateEnd;
    private String pickUp;
    private String dropOff;
    private double totalPrice;
    private int employeeId = 1;
    private int customerId;
    private int accessoriesId;
    private String licensePlateNo;
    private Boolean invoiceDone;


    public Invoice() {
    }

    public Invoice(int invoiceId, Date dateStart, Date dateEnd, String pickUp, String dropOff, double totalPrice, int employeeId, int customerId, int accessoriesId, String licensePlateNo) {
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

    public int getInvoiceId() {
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

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getAccessoriesId() {
        return accessoriesId;
    }

    public void setAccessoriesId(int accessoriesId) {
        this.accessoriesId = accessoriesId;
    }

    public String getLicensePlateNo() {
        return licensePlateNo;
    }

    public void setLicensePlateNo(String licensePlateNo) {
        this.licensePlateNo = licensePlateNo;
    }

    public Boolean getInvoiceDone() {
        return invoiceDone;
    }

    public void setInvoiceDone(Boolean invoiceDone) {
        this.invoiceDone = invoiceDone;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", pickUp='" + pickUp + '\'' +
                ", dropOff='" + dropOff + '\'' +
                ", totalPrice=" + totalPrice +
                ", employeeId=" + employeeId +
                ", customerId=" + customerId +
                ", accessoriesId=" + accessoriesId +
                ", licensePlateNo='" + licensePlateNo + '\'' +
                ", invoiceDone=" + invoiceDone +
                '}';
    }
}