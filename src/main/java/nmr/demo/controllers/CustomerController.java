package nmr.demo.controllers;

import nmr.demo.models.Customer;
import nmr.demo.repositories.CustomerRepository;
import nmr.demo.repositories.IRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {
    private IRepository customerRpository;

    public CustomerController() {
        customerRpository = new CustomerRepository();

    }
    @GetMapping("/managecustomers")
    public String manageCustomers(Model model){
        model.addAttribute("viewCustomers",customerRpository.readAll());
        return "/customer/managecustomers";
    }

    @GetMapping("/createcustomer")
    public String createCustomer(Model model) {
        model.addAttribute("createCustomer", new Customer());
        return "/customer/createcustomer";
    }

    @PostMapping("/createcustomer")
    public String createCustomerDB(@ModelAttribute Customer customer) {
        customerRpository.create(customer);
        return "/customer/createcustomer";
    }
    @GetMapping("/deletecustomer")
    public String deleteCustomer(Model model, @RequestParam int id){
        Customer customer = (Customer) customerRpository.read(id);
        model.addAttribute("customer",customer);
        return "customer/deletecustomer";
    }
    @PostMapping("/deletecustomer")
    public String deleteCustomerDB(int id){
        customerRpository.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/updatecustomer")
    public String updateCustomer(Model model,@RequestParam int id){
        Customer customer = (Customer) customerRpository.read(id);
        model.addAttribute("customer",customer);
        return "customer/updatecustomer";
    }

    @PostMapping ("/updatecustomer")
    public String updateCustomerDB(@ModelAttribute Customer customer){
        customerRpository.update(customer);
        return "redirect:/";
    }


}
