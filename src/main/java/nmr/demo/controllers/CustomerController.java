package nmr.demo.controllers;

import nmr.demo.models.Customer;
import nmr.demo.models.MotorHome;
import nmr.demo.repositories.AccessoryRepository;
import nmr.demo.repositories.CustomerRepository;
import nmr.demo.repositories.IRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    private IRepository customerRepository;

    public CustomerController() {
        customerRepository = new CustomerRepository();

    }

    @GetMapping("/customer")
    public String createCustomer(Model model){
        model.addAttribute("newCustomer",new Customer());
        return "/customer";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute Customer customer){
        customerRepository.create(customer);
        return "/customerTemp";
    }

    @RequestMapping("/customerTemp")
    public String getCustomerByParameterDetail(@RequestParam int id,Model model) {
        model.addAttribute("customer",customerRepository.read(id));
        return "/customerTemp";
    }
/*
    @RequestMapping("/customerTemp/{id}")
    public ModelAndView showAddProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("customerTemp");
        Customer customer = (Customer) customerRepository.read(id);
        mav.addObject("customer", customer);

        return mav;
    }*/
}
