package nmr.demo.controllers;


import nmr.demo.businessLogic.ReservationService;
import nmr.demo.models.Invoice;
import nmr.demo.models.MotorHome;
import nmr.demo.repositories.IRepository;
import nmr.demo.repositories.InvoiceRepository;
import nmr.demo.repositories.MotorhomeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
/*
@Controller
public class InvoiceControllerBackUp {

    private IRepository invoiceRepository;
    private ReservationService service;

    public InvoiceControllerBackUp(){
        this.invoiceRepository = new InvoiceRepository();
        this.service = new ReservationService();
    }



    @GetMapping("/createreservation")
    public String createreservation(){
        System.out.println("Hello createreservation");
        return "invoice/createreservation";
    }

    @GetMapping("/createinvoice")
    public String createInvoice(Model model){
        model.addAttribute("motorhome",new Invoice());
        return "/invoice/createinvoice";
    }

    @GetMapping("/manageinvoices")
    public String seeAllInvoices(Model model) {
        model.addAttribute("invoice", invoiceRepository.readAll());
        return "/invoice/manageinvoices";
    }

    @GetMapping("/check-for-costumer/")
    public String findExistingCustomer(Model model, @RequestParam int id){
        service.setCustomerByPhone(id);
        model.addAttribute("customer", service.getCustomer());
        return "invoice/existing-customer-invoice";
    }

    @PostMapping("/return-date-and-beds/")
    public String findMotorhomesAvailable(Model model){

        model.addAttribute("motorhomes", service.getMotorhomeRepository().readAll());

        return "redirect:/check-for-costumer/";
    }


    @GetMapping("/updateinvoice")
    public String updateMotorhome(Model model) {
        model.addAttribute("invoice", invoiceRepository.readAll());
        return "/invoice/updateinvoice";
    }

    @GetMapping("/deleteinvoice")
    public String deleteMotorhome(Model model) {
        model.addAttribute("invoice", invoiceRepository.readAll());
        return "/invoice/deleteinvoice";
    }




    @PostMapping("/saveinvoice")
    public String saveMotorHome(@ModelAttribute Invoice invoice){
        invoiceRepository.create(invoice);
        return "/index";
    }

}
*/


