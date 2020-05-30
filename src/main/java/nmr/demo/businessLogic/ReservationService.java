package nmr.demo.businessLogic;

import nmr.demo.models.Employee;
import nmr.demo.repositories.*;
import nmr.demo.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservationService {
    private IRepository accessoryRepository;
    private CustomerRepository customerRepository;
    private IRepository employeeRepository;
    private InvoiceRepository invoiceRepository;
    private IRepository motorhomeRepository;

    private Accessories accessories;
    private Customer customer;
    private Employee employee;
    private Invoice invoice;
    private MotorHome motorhome;

    public ReservationService(){
        this.accessoryRepository = new AccessoryRepository();
        this.customerRepository = new CustomerRepository();
        this.employeeRepository = new EmployeeRepository();
        this.invoiceRepository = new InvoiceRepository();
        this.motorhomeRepository = new MotorhomeRepository();





    }


    public Accessories getAccessories() {
        return accessories;
    }

    public void setAccessories(int id) {
        this.accessories = (Accessories) accessoryRepository.read(id);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(int id) {
        this.customer =  customerRepository.readPhone(id);
    }

    public void setCustomerByPhone(int id){
        this.customer = customerRepository.readPhone(id);
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(int id) {
        this.employee = (Employee) employeeRepository.read(id);
    }



    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(int id) {
        this.invoice = (Invoice) invoiceRepository.read(id);
    }

    public void setInvoiceByCustomerID(int id){ this.invoice = invoiceRepository.readByCustomerID(id); }

    public MotorHome getMotorhome() {
        return motorhome;
    }

    public void setMotorhome(int licensePlate) {
        this.motorhome = (MotorHome) motorhomeRepository.read(licensePlate);
    }




}