package nmr.demo.controllers;

import nmr.demo.repositories.IRepository;
import nmr.demo.repositories.MotorhomeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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


    @GetMapping("/logoutuser")
    public String hello(){

        return "/security/logoutuser";
    }

    @GetMapping("/login")
    public String login(){

        return "/security/login";
    }

    }


