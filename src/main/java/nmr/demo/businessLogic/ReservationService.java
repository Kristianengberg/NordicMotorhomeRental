package nmr.demo.businessLogic;

import nmr.demo.models.*;
import nmr.demo.repositories.*;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

//Skrevet af Kristian og Jesper

@Service
public class ReservationService {

    private IRepository accessoryRepository;
    private CustomerRepository customerRepository;
    private IRepository employeeRepository;
    private InvoiceRepository invoiceRepository;
    private MotorhomeRepository motorhomeRepository;

    private Accessories accessories;
    private Customer customer;
    private Employee employee;
    private Invoice invoice;
    private MotorHome motorhome;

    private double extraKilometerPrice = 1;
    private double maxKilometerPerDay = 400;
    private double fullTankPrice = 70;

    public ReservationService() {
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
        this.customer = customerRepository.read(id);
    }

    public void setCustomerByPhone(int id) {
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

    public void setInvoiceByCustomerID(int id) {
        System.out.println("this is setinvoicebycustomer ID " + id);
        this.invoice = invoiceRepository.readByCustomerID(id);
    }

    public MotorHome getMotorhome() {
        return motorhome;
    }

    public void setMotorhome(int id) {
        this.motorhome = (MotorHome) motorhomeRepository.read(id);
    }


    public IRepository getAccessoryRepository() {
        return accessoryRepository;
    }

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public IRepository getEmployeeRepository() {
        return employeeRepository;
    }

    public InvoiceRepository getInvoiceRepository() {
        return invoiceRepository;
    }

    public IRepository getMotorhomeRepository() {
        return motorhomeRepository;
    }

    public List<MotorHome> getMotorhomeByDateAndBeds(int beds, Date start, Date finish) {
        List<MotorHome> tempList = new ArrayList<MotorHome>();
        List<MotorHome> returnList = new ArrayList<MotorHome>();
        tempList = motorhomeRepository.readAll();

        for (MotorHome motorhome : tempList) {
            if (motorhome.getBeds() == beds) {
                if (motorhome.getStart() != null && motorhome.getFinish() != null) {
                    if (!start.after(motorhome.getStart()) && !start.before(motorhome.getFinish())
                            && !finish.after(motorhome.getStart()) && !finish.before(motorhome.getFinish())) {
                        System.out.println(start + " + " + finish);
                        returnList.add(motorhome);
                    }
                }
                else{
                    returnList.add(motorhome);
                }
            }
        }

        return returnList;
    }

    public List<Invoice> getInvoicesForCustomer(int id){
        List<Invoice> tempList = new ArrayList<Invoice>();
        List<Invoice> returnList = new ArrayList<Invoice>();
        int customerId = customerRepository.readPhone(id).getCustomerId();
        tempList = invoiceRepository.readAll();
        for (Invoice invoice : tempList) {
            if(customerId == invoice.getCustomerId()){
                returnList.add(invoice);
            }
        }
        return returnList;

    }

    public double getDays(Date start, Date finish){
        double diff = start.getTime() - finish.getTime();
        double days = (diff / (1000*60*60*24))*-1+1;
        return days;

    }

    public int returnEngineBlockNo(String license){
        int engineBlockNo = motorhomeRepository.readByLicense(license).getEngineBlockNo();

        return engineBlockNo;
    }

    public double calculatePrice(Invoice invoice){
        double price = 0;

        double days = getDays((Date) invoice.getDateStart(), (Date) invoice.getDateEnd());
       /* double diff = invoice.getDateStart().getTime() - invoice.getDateEnd().getTime();
        double days = (diff / (1000*60*60*24))*-1+1;

        */
        price = motorhomeRepository.readByLicense(invoice.getLicensePlateNo()).getPrice();

        price = price * days;
        if(accessories != null) {
            price += accessories.getPrice();
        }
        return price;
    }

    public double calculateExtraPrice(double kilometer, Invoice invoice, String gas) {

        double price = 0;

        double kilometersPerDay = (kilometer - this.motorhome.getKilometers()) / getDays((Date)invoice.getDateStart(),(Date) invoice.getDateEnd()) ;

        if( kilometersPerDay > maxKilometerPerDay )
            price = extraKilometerPrice * (kilometersPerDay - maxKilometerPerDay);
        if(gas == "true"){
            price += fullTankPrice;
        }

        return price;
    }
}


