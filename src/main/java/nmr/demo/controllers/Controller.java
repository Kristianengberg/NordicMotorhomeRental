package nmr.demo.controllers;


import nmr.demo.repositories.IRepository;
import nmr.demo.repositories.MotorhomeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class AutocamperController {

    private IRepository autocamperRepository;
    public AutocamperController(){
        autocamperRepository = new MotorhomeRepository();
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("autocamper",autocamperRepository.readAll());
        return "index";
    }

}
