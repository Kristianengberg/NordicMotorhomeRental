package nmr.demo.controllers;


import nmr.demo.models.Invoice;
import nmr.demo.models.MotorHome;
import nmr.demo.repositories.IRepository;
import nmr.demo.repositories.InvoiceRepository;
import nmr.demo.repositories.MotorhomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InvoiceController {

    private IRepository invoiceRepository;


import nmr.demo.models.Invoice;
import nmr.demo.models.MotorHome;
import nmr.demo.repositories.IRepository;
import nmr.demo.repositories.InvoiceRepository;
import nmr.demo.repositories.MotorhomeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InvoiceController {

    private IRepository invoiceRepository;

    public InvoiceController(){
        this.invoiceRepository = new InvoiceRepository();
    }



    @GetMapping("/createreservation")
    public String createreservation(){
        System.out.println("Hello createreservation");
        return "/invoice/determineinvoice";
    }

    @PostMapping("/determineinvoice/phonenumber")
    @ResponseBody
    public ModelAndView findCostumer(@RequestParam(name = "phonenumber") int id){
        System.out.println("find costumer");
        ModelAndView mav = new ModelAndView("/invoice/createinvoice");
        Invoice invoice = (Invoice) invoiceRepository.read(id); //cast???
        System.out.print(invoice.toString());
        mav.addObject("invoice", invoice);
        return mav;
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

    @GetMapping("/findesingleinvoice")
    public String findSingleMotorhome(Model model){
        model.addAttribute("invoice",new Invoice());
        return "/invoice/findsingeinvoice";
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



