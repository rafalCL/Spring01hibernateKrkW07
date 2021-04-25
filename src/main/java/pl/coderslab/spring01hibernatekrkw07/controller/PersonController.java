package pl.coderslab.spring01hibernatekrkw07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01hibernatekrkw07.dao.PersonDao;
import pl.coderslab.spring01hibernatekrkw07.entity.Person;

@Controller
@RequestMapping("/person")
public class PersonController {
    private PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping("/addform")
    public String addForm(){
        return "person/addform";
    }

    @PostMapping("/addform")
    @ResponseBody
    public String addFormPost(@RequestParam String login,
                              @RequestParam String email,
                              @RequestParam String password){
        Person person = new Person()
                .setLogin(login)
                .setEmail(email)
                .setPassword(password);
        personDao.create(person);
        return person.toString();
    }

    @GetMapping("/addformbind")
    public String addFormBind(Model m){
        m.addAttribute("person", new Person());

        return "person/addformbind";
    }

    @PostMapping("/addformbind")
    @ResponseBody
    public String addFormBindPost(@ModelAttribute Person person){
        personDao.create(person);
        return person.toString();
    }
}
