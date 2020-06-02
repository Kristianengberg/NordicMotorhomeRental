package nmr.demo.controllers;

import nmr.demo.models.Accessories;
import nmr.demo.models.Customer;
import nmr.demo.repositories.AccessoryRepository;
import nmr.demo.repositories.IRepository;
import nmr.demo.repositories.MotorhomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AccessoriesController {
    private IRepository accessoriesRepository;


    @Autowired
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
        return "accessories/findsingleaccessory";
    }
    @GetMapping("/deleteaccessory")
    public String deleteAccessory(Model model, @RequestParam int id){
        Accessories accessories = (Accessories) accessoriesRepository.read(id);
        model.addAttribute("accessories",accessories);
        return "accessories/deleteaccessory";
    }
    @PostMapping("/deleteaccessory")
    public String deleteAccessoryDB(int id){
        accessoriesRepository.delete(id);
        return "redirect:/manageaccessories";
    }

    @RequestMapping("/updateaccessery")
    public String updateAccessory(Model model,@RequestParam int id){
        Accessories accessories = (Accessories) accessoriesRepository.read(id);
        model.addAttribute("accessories",accessories);
        return "accessories/updateaccessery";
    }

    @RequestMapping(value = "/updateaccessery", method = RequestMethod.POST)
    public String updateAccessoryDB(@ModelAttribute("accessories") Accessories accessories) {
        accessoriesRepository.update(accessories);
        return "redirect:/manageaccessories";
    }

/*
    @GetMapping("/accessories")
    public String index(Model model) {
        model.addAttribute("accessories", accessoriesRepository.readAll());
        return "accessories";
    }*/
}

