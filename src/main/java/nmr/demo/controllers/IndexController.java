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
class IndexController {

    private IRepository motorHomeRepository;

    public IndexController() {
        motorHomeRepository = new MotorhomeRepository();

    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("autocamper", motorHomeRepository.readAll());
        return "index";
    }

    @GetMapping("/test")
    public String test(){

        return "/security/test";
    }
    @GetMapping("/test2")
    public String test2(){

        return "/security/test";
    }

    }


