package nmr.demo.controllers;

import nmr.demo.models.Customer;
import nmr.demo.models.MotorHome;
import nmr.demo.repositories.IRepository;
import nmr.demo.repositories.MotorhomeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MotorhomeController {

    private IRepository motorHomeRepository;
    public MotorhomeController(){
        this.motorHomeRepository = new MotorhomeRepository();
    }

    @GetMapping("/createmotorhome")
    public String createMotorHome(Model model){
        model.addAttribute("autocamper",new MotorHome());
        return "/motorhome/createmotorhome";
    }

    @PostMapping("/createmotorhome")
    public String createMotorhomeDB(@ModelAttribute MotorHome motorhome) {
        motorHomeRepository.create(motorhome);
        return "redirect:/managemotorhomes";
    }

    @GetMapping("/managemotorhomes")
    public String seeAllMotorhomes(Model model) {
        model.addAttribute("autocamper", motorHomeRepository.readAll());
        return "/motorhome/managemotorhomes";
    }

    @GetMapping("/findesinglemotorhome")
    public String findSingleMotorhome(Model model, @RequestParam int id){
        MotorHome motorHome = (MotorHome) motorHomeRepository.read(id);
        model.addAttribute("autocamper", motorHome);
        return "/motorhome/findesinglemotorhome";
    }

    @RequestMapping("/updatemotorhome")
    public String updateMotorhome(Model model,@RequestParam int id){
        MotorHome motorhome = (MotorHome) motorHomeRepository.read(id);
        model.addAttribute("autocamper", motorhome);
        return "motorhome/updatemotorhome";
    }

    @RequestMapping(value = "/updatemotorhome", method = RequestMethod.POST)
    public String updateMotorhomeDB(@ModelAttribute("autocamper") MotorHome motorhome) {
        motorHomeRepository.update(motorhome);
        return "redirect:/managemotorhomes";
    }



    @GetMapping("/deletemotorhome")
    public String deleteMotorhome(Model model, @RequestParam int id){
        MotorHome motorHome = (MotorHome) motorHomeRepository.read(id);
        model.addAttribute("autocamper",motorHome);
        return "motorhome/deletemotorhome";
    }
    @PostMapping("/deletemotorhome")
    public String deleteMotorhomeDB(int id){
        motorHomeRepository.delete(id);
        return "redirect:/managemotorhomes";
    }


}
