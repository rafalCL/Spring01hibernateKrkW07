package pl.coderslab.spring01hibernatekrkw07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01hibernatekrkw07.entity.Person;
import pl.coderslab.spring01hibernatekrkw07.repository.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/person")
public class PersonController {
    private PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/list")
    @ResponseBody
    public String list() {
        List<Person> persons = personRepository.findAll();
        return persons.stream()
                .map(Person::toString)
                .collect(Collectors.joining("</div><div>", "<div>", "</div>"));
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
        personRepository.save(person);
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
        personRepository.save(person);
        return person.toString();
    }

    @GetMapping("/bylogin/{login}")
    @ResponseBody
    public String findByLogin(@PathVariable String login){
        return personRepository.findByLogin(login).toString();
    }
}
