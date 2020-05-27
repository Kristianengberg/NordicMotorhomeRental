package nmr.demo.controllers;

import nmr.demo.models.Customer;
import nmr.demo.repositories.CustomerRepository;
import nmr.demo.repositories.IRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
    private IRepository customerRpository;

    public CustomerController() {
        customerRpository = new CustomerRepository();

    }

    @GetMapping("/customer")
    public String index(Model model) {
        model.addAttribute("viewCustomers", customerRpository.readAll());
        return "createCustomer";
    }
    @GetMapping("/createCustomer")
    public String createCustomer(Model model) {
        model.addAttribute("createCustomer", new Customer());
        return "createCustomer";
    }
}
