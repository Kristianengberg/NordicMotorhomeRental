package nmr.demo.controllers;

import nmr.demo.repositories.AccessoryRepository;
import nmr.demo.repositories.IRepository;
import nmr.demo.repositories.MotorhomeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccessoriesController {
    private IRepository accessoriesRepository;

    public AccessoriesController() {
        accessoriesRepository = new AccessoryRepository();

    }

    @GetMapping("/accessories")
    public String index(Model model) {
        model.addAttribute("accessories", accessoriesRepository.readAll());
        return "accessories";
    }
}

