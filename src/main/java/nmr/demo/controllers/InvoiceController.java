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

import java.util.List;
import java.util.Map;

@Controller
public class InvoiceController {

    private IRepository invoiceRepository;
    private ReservationService service;

    public InvoiceController(){
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

    @GetMapping("/findsingleinvoice/")
    public String findSingleMotorhome(Model model, @RequestParam int id){
        System.out.println("find single motorhome");

        service.setInvoice(id);

        service.setAccessories(service.getInvoice().getAccessoriesId());
        service.setCustomer(id);
        service.setEmployee(id);




        model.addAttribute("invoice", service.getInvoice());
        model.addAttribute("customer", service.getCustomer());
        model.addAttribute("employee", service.getEmployee());
        model.addAttribute("accessories", service.getAccessories());

        return "invoice/findsingleinvoice";
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



