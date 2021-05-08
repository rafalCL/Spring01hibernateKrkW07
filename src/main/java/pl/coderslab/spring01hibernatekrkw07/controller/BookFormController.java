package pl.coderslab.spring01hibernatekrkw07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01hibernatekrkw07.dao.AuthorDao;
import pl.coderslab.spring01hibernatekrkw07.dao.BookDao;
import pl.coderslab.spring01hibernatekrkw07.dao.PublisherDao;
import pl.coderslab.spring01hibernatekrkw07.entity.Author;
import pl.coderslab.spring01hibernatekrkw07.entity.Book;
import pl.coderslab.spring01hibernatekrkw07.entity.Publisher;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/bf")
public class BookFormController {
    private BookDao bookDao;
    private PublisherDao publisherDao;
    private AuthorDao authorDao;

    public BookFormController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @GetMapping("/all")
    @ResponseBody
    public String showAll(){
        final String html = bookDao.readAllWithAuthors()
                .stream()
                .map(Book::toString)
                .collect(Collectors.joining("</div>\r\n<div>","<div>", "</div>"));

        return html;
    }

    @GetMapping("/addform")
    public String addForm(Model m){
        m.addAttribute("book", new Book());
        return "book/form";
    }

    @PostMapping("/addform")
    public String addFormPost(@ModelAttribute @Valid Book book, BindingResult violations){
        if(violations.hasErrors()){
            return "book/form";
        }
        bookDao.create(book);
        return "redirect:all";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable long id, Model m){
        m.addAttribute("book", bookDao.readWithAuthorsById(id));
        return "book/form";
    }

    @PostMapping("/{id}/edit")
    public String editFormPost(@ModelAttribute @Valid Book book, BindingResult violations){
        if(violations.hasErrors()){
            return "book/form";
        }
        bookDao.update(book);
        return "redirect:../all";
    }

    @ModelAttribute("publishers")
    public List<Publisher> publishers() {
        return publisherDao.readAll();
    }

    @ModelAttribute("authors")
    public List<Author> authors() {
        return authorDao.readAll();
    }
}
