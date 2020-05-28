package nmr.demo.controllers;

import nmr.demo.models.MotorHome;
import nmr.demo.repositories.IRepository;
import nmr.demo.repositories.MotorhomeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MotorhomeController {

    private IRepository motorHomeRepository;
    public MotorhomeController(){
        this.motorHomeRepository = new MotorhomeRepository();
    }

    @GetMapping("/createmotorhome")
    public String createMotorHome(Model model){
        model.addAttribute("motorhome",new MotorHome());
        return "/motorhome/createmotorhome";
    }

    @GetMapping("/seeallmotorhomes")
    public String seeAllMotorhomes(Model model) {
        model.addAttribute("autocamper", motorHomeRepository.readAll());
        return "managemotorhomes";
    }

    @GetMapping("/findesinglemotorhome")
    public String findSingleMotorhome(Model model){
        model.addAttribute("motorhome",new MotorHome());
        return "/motorhome/findesinglemotorhome";
    }

    @GetMapping("/updatemotorhome")
    public String updateMotorhome(Model model) {
        model.addAttribute("autocamper", motorHomeRepository.readAll());
        return "/motorhome/updatemotorhome";
    }

    @GetMapping("/deletemotorhome")
    public String deleteMotorhome(Model model) {
        model.addAttribute("autocamper", motorHomeRepository.readAll());
        return "/motorhome/deletemotorhome";
    }




    @PostMapping("/savemotorhome")
    public String saveMotorHome(@ModelAttribute MotorHome motorHome){
        motorHomeRepository.create(motorHome);
        return "/index";
    }
}
