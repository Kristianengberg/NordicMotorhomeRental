package nmr.demo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class AutocamperController {

    private IAutoCamperRepository autocamperRepository;
    public AutocamperController(){
        autocamperRepository = new AutoCamperRepositoryImpl();
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("autocamper",autocamperRepository.readAll());
        return "index";
    }

}
