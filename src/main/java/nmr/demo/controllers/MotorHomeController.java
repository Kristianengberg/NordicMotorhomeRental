package nmr.demo.controllers;

import nmr.demo.models.MotorHome;
import nmr.demo.repositories.EmployeeRepository;
import nmr.demo.repositories.IRepository;
import nmr.demo.repositories.MotorhomeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
class MotorHomeController {

    private IRepository motorHomeRepository;

    public MotorHomeController() {
        motorHomeRepository = new MotorhomeRepository();

    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("autocamper", motorHomeRepository.readAll());
        return "index";
    }
    @GetMapping("/motorhome")
    public String motorhome(Model model) {
        model.addAttribute("autocamper", motorHomeRepository.readAll());
        return "index";
    }
    @GetMapping("/createMotorhome")
    public String createMotorHome(Model model){
        model.addAttribute("motorhome",new MotorHome());
        return "create";
    }
    @PostMapping("/save")
    public String saveMotorHome(@ModelAttribute MotorHome motorHome){
        motorHomeRepository.create(motorHome);
        return "/index";
    }
}
