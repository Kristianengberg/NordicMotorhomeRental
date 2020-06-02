package nmr.demo.controllers;


import nmr.demo.businessLogic.ReservationService;
import nmr.demo.models.Customer;
import nmr.demo.models.Invoice;
import nmr.demo.repositories.IRepository;
import nmr.demo.repositories.InvoiceRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

@Controller
public class InvoiceController {

    private IRepository invoiceRepository;
    private ReservationService service;
    private Invoice invoice;

    public InvoiceController(){
        this.invoiceRepository = new InvoiceRepository();
        this.service = new ReservationService();
    }



    @GetMapping("/createreservation")
    public String inputCostumerPhone(){
        System.out.println("create reservation");
        invoice = new Invoice();
        invoice.setInvoiceDone(false);
        return "invoice/check-for-customer";
    }



    @GetMapping("/send-costumer-phone/")
    public ModelAndView findExistingCustomer(Model model, @RequestParam("id") int id) {
        System.out.println(service.getCustomerRepository().readPhone(id));
        if (service.getCustomerRepository().readPhone(id).getPhone() != id){
            System.out.println("phone is null");
            ModelAndView mav = new ModelAndView("reservations/createcustomerreservation");
            Customer customer = new Customer();
            customer.setPhone(id);
            mav.addObject("customer", customer);

            return mav;
        } else {
            ModelAndView mav = new ModelAndView("invoice/existing-customer-invoice");


            service.setCustomerByPhone(id);
            invoice.setCustomerId(service.getCustomer().getCustomerId());
            //service.getInvoice().setCustomerId(service.getCustomer().getCustomerId());

            mav.addObject("customer", service.getCustomer());

            return mav;
        }
    }

    @GetMapping("/mapped-costumer")
    public String displayDateAndBeds(Model model, @RequestParam("beds") int beds, @RequestParam("start") Date start, @RequestParam("finish") Date finish) throws ParseException {
        invoice.setDateStart(start);
        invoice.setDateEnd(finish);
        model.addAttribute("customer", service.getCustomer());
        model.addAttribute("motorhomes", service.getMotorhomeByDateAndBeds(beds, start, finish));


        return "invoice/existing-customer-invoice";
    }

   @GetMapping("/invoice/existing-customer-invoice/{id}/{licensePlateNo}")
   public String addedMotorhome(Model model, @PathVariable("id") int id, @PathVariable("licensePlateNo") String licensePlateNo ){
        invoice.setLicensePlateNo(licensePlateNo);
        service.setMotorhome(id);
        model.addAttribute("customer", service.getCustomer());
       // model.addAttribute("chosenMotorhome", service.getMotorhomeRepository().read(id));
        model.addAttribute("chosenMotorhome", service.getMotorhome());
        model.addAttribute("accessories", service.getAccessoryRepository().readAll());
        model.addAttribute("service", service);

        System.out.println(service.getAccessoryRepository().readAll().toString());

        invoice.setTotalPrice(service.calculatePrice(invoice));


        model.addAttribute("invoice", invoice);
        if(invoice == null) {
            System.out.println("invoice is null");
        }
        System.out.println(invoice.toString());



        return "invoice/existing-customer-invoice";
   }
    @GetMapping("/invoice/existing-customer-invoice/{id}")
    public String addedMotorhome(Model model, @PathVariable("id") int id){
        System.out.println(id);
        model.addAttribute("customer", service.getCustomer());
        model.addAttribute("chosenMotorhome", service.getMotorhome());
        model.addAttribute("accessories", service.getAccessoryRepository().readAll());
        model.addAttribute("service", service);
        model.addAttribute("accessory", service.getAccessoryRepository().read(id));
        System.out.println(service.getAccessoryRepository().read(id).toString());
        service.setAccessories(id);
        invoice.setAccessoriesId(id);

        invoice.setTotalPrice(service.calculatePrice(invoice));


        model.addAttribute("invoice", invoice);
        if(invoice == null) {
            System.out.println("invoice is null");
        }
        System.out.println(invoice.toString());



        return "invoice/existing-customer-invoice";
    }
    @GetMapping("/submit-invoice")
    public String submitInvoice(Model model, @RequestParam("pris") double price){

        invoice.setTotalPrice(price);
        service.getInvoiceRepository().create(invoice);
        model.addAttribute("invoice", invoice);
        model.addAttribute("customer", service.getCustomer());
        model.addAttribute("motorhome", service.getMotorhome());
        model.addAttribute("accessory", service.getAccessories());

        return "invoice/invoice";
    }

    @GetMapping("/return-home")
    public String returnHome(){

        return "index";
    }

}



