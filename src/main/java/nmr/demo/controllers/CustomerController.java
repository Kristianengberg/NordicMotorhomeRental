package nmr.demo.controllers;

import nmr.demo.models.Customer;
import nmr.demo.repositories.CustomerRepository;
import nmr.demo.repositories.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {
    private IRepository customerRpository;

    @Autowired
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
        return "/customer/managecustomers";
    }
    @GetMapping("/deletecustomer")
    public String deleteCustomer(Model model, @RequestParam int id){
        Customer customer = (Customer) customerRpository.read(id);
        model.addAttribute("customer",customer);
        return "customer/deletecustomer";
    }
    @PostMapping("/deletecustomer")
    public String deleteCustomerDB(int id){
        System.out.println(id + "test");
        customerRpository.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/updatecustomer")
    public String updateCustomer(Model model,@RequestParam int id){
        Customer customer = (Customer) customerRpository.read(id);
        model.addAttribute("customer",customer);
        return "customer/updatecustomer";
    }

    @RequestMapping(value = "/updatecustomer", method = RequestMethod.POST)
    public String updateStudentDB(@ModelAttribute("customer") Customer customer) {
        customerRpository.update(customer);
        System.out.println("updated student");
        return "redirect:/";
    }

    @GetMapping("/findsinglecustomer")
    public String findSingleCustomer(Model model, @RequestParam int id){
        Customer customer = (Customer) customerRpository.read(id);
        model.addAttribute("customer",customer);
        return "customer/findsinglecustomer";
    }


}
