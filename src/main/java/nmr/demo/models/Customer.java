package nmr.demo.models;

public class Customer {
    private static int CustomerId;
    private String CustomerName;
    private String address;
    private int zipCode;
    private int phone;
    private String email;
    private boolean customerType;

    public Customer() {
    }

    public Customer(int customerId, String customerName, String address, int zipCode, int phone, String email, boolean customerType) {
        CustomerId = customerId;
        CustomerName = customerName;
        this.address = address;
        this.zipCode = zipCode;
        this.phone = phone;
        this.email = email;
        this.customerType = customerType;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isCustomerType() {
        return customerType;
    }

    public void setCustomerType(boolean customerType) {
        this.customerType = customerType;
    }
}
