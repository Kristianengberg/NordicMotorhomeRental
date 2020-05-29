package nmr.demo.controllers;

import nmr.demo.models.Accessories;
import nmr.demo.models.Customer;
import nmr.demo.repositories.AccessoryRepository;
import nmr.demo.repositories.IRepository;
import nmr.demo.repositories.MotorhomeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccessoriesController {
    private IRepository accessoriesRepository;

    public AccessoriesController() {
        accessoriesRepository = new AccessoryRepository();

    }

    @GetMapping("/manageaccessories")
    public String manageAccessories(Model model){
        model.addAttribute("viewAccessories",accessoriesRepository.readAll());
        return "/accessories/manageaccessories";
    }

    @GetMapping("/createaccessory")
    public String createAccessories(Model model) {
        model.addAttribute("createAccessory", new Accessories());
        return "/accessories/createaccessory";
    }

    @PostMapping("/createaccessory")
    public String createAccessoryDB(@ModelAttribute Accessories accessories) {
        accessoriesRepository.create(accessories);
        return "redirect:/manageaccessories";
    }

    @GetMapping("/findsingleaccessory")
    public String findSingleAccessory(Model model, @RequestParam int id){
        Accessories accessories = (Accessories) accessoriesRepository.read(id);
        model.addAttribute("accessory", accessories);
        return "customer/findsingleaccesory";
    }
/*
    @GetMapping("/accessories")
    public String index(Model model) {
        model.addAttribute("accessories", accessoriesRepository.readAll());
        return "accessories";
    }*/
}

