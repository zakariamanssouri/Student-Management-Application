package ma.enset.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
    @GetMapping(path = "/errors/403")
    public String unathorizedPage() {
        return "403";
    }
}
