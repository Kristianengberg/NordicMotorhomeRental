package nmr.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MotorHomeController {

    @GetMapping
    public String index("/"){
        return "index";
    }

}
