package nmr.demo.models;

public class Invoice {
    private int invoiceId;
    Customer customerId = new Customer();
    MotorHome licensePlate = new MotorHome();
    Accessories accessoriesId = new Accessories();
    Employee employeeId = new Employee();
    private String date;
    private double totalPrice;
    private String pickUp;
    private String dropOff;

    public Invoice() {
    }

    public Invoice(int invoiceId, Customer customerId, MotorHome licensePlate, Accessories accessoriesId, Employee employeeId, String date, double totalPrice, String pickUp, String dropOff) {
        this.invoiceId = invoiceId;
        this.customerId = customerId;
        this.licensePlate = licensePlate;
        this.accessoriesId = accessoriesId;
        this.employeeId = employeeId;
        this.date = date;
        this.totalPrice = totalPrice;
        this.pickUp = pickUp;
        this.dropOff = dropOff;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public MotorHome getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(MotorHome licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Accessories getAccessoriesId() {
        return accessoriesId;
    }

    public void setAccessoriesId(Accessories accessoriesId) {
        this.accessoriesId = accessoriesId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
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
}
