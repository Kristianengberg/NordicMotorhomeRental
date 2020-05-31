package nmr.demo.controllers;


import nmr.demo.businessLogic.ReservationService;
import nmr.demo.models.Invoice;
import nmr.demo.repositories.IRepository;
import nmr.demo.repositories.InvoiceRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

@Controller
public class InvoiceController {

    private IRepository invoiceRepository;
    private ReservationService service;

    public InvoiceController(){
        this.invoiceRepository = new InvoiceRepository();
        this.service = new ReservationService();
    }





    @GetMapping("/createreservation")
    public String inputCostumerPhone(){
        System.out.println("create reservation");
        return "invoice/check-for-customer";
    }



    @GetMapping("/send-costumer-phone/")
    public ModelAndView findExistingCustomer(Model model, @RequestParam("id") int id){
        ModelAndView mav = new ModelAndView("invoice/existing-customer-invoice");

        service.setCustomerByPhone(id);

        mav.addObject("customer", service.getCustomer());

        return mav;
    }

    @GetMapping("/mapped-costumer")
    public String displayDateAndBeds(Model model, @RequestParam("beds") int beds, @RequestParam("start") Date start, @RequestParam("finish") Date finish) throws ParseException {

        model.addAttribute("customer", service.getCustomer());
        model.addAttribute("motorhomes", service.getMotorhomeByDateAndBeds(beds, start, finish));


        return "invoice/existing-customer-invoice";
    }




}



