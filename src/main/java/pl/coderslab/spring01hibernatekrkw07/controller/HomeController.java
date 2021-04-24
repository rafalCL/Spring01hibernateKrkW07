package pl.coderslab.spring01hibernatekrkw07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
// slajd 14 kolumna w Phone
@Controller
public class HomeController {
    @GetMapping("")
    public String home(){
        return "home";
    }

    @GetMapping("/enc")
    @ResponseBody
    public String encoding(){
        return "ąęćółńżź";
    }
}