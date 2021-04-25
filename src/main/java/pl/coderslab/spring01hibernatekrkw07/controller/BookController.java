package pl.coderslab.spring01hibernatekrkw07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01hibernatekrkw07.dao.BookDao;
import pl.coderslab.spring01hibernatekrkw07.dao.PublisherDao;
import pl.coderslab.spring01hibernatekrkw07.entity.Book;
import pl.coderslab.spring01hibernatekrkw07.entity.Publisher;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/book")
public class BookController {
    private BookDao bookDao;
    private PublisherDao publisherDao;

    public BookController(BookDao bookDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
    }

    @GetMapping("/create")
    @ResponseBody
    public String create() {
        final Book b = new Book()
                .setTitle("W pustyni i w puszczy")
                .setDescription("Klasyczna książka przygodowa.")
                .setRating(9);

        bookDao.create(b);
        return b.toString();
    }

    @GetMapping("/create/{title}/{description}/{rating}")
    @ResponseBody
    public String create(@PathVariable String title,
                         @PathVariable String description,
                         @PathVariable int rating
                         ) {
        final Book b = new Book()
                .setTitle(title)
                .setDescription(description)
                .setRating(rating);

        bookDao.create(b);
        return b.toString();
    }

    @GetMapping("/createwp/{title}/{description}/{rating}/{pubId}")
    @ResponseBody
    public String createWithPublisher(@PathVariable String title,
                         @PathVariable String description,
                         @PathVariable int rating,
                         @PathVariable long pubId
    ) {
        final Publisher p = publisherDao.readById(pubId);

        final Book b = new Book()
                .setTitle(title)
                .setDescription(description)
                .setRating(rating)
                .setPublisher(p);

        bookDao.create(b);
        return b.toString();
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public String read(@PathVariable long id) {
        return bookDao.readById(id).toString();
    }

    @GetMapping("/update/{id}/{title}/{description}/{rating}")
    @ResponseBody
    public String update(@PathVariable long id,
                       @PathVariable String title,
                       @PathVariable String description,
                       @PathVariable int rating) {
        Book b = bookDao.readById(id);
        b.setTitle(title);
        b.setDescription(description);
        b.setRating(rating);

        bookDao.update(b);

        return b.toString();
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable long id) {
        Book b = bookDao.readById(id);
        bookDao.delete(b);

        return "Usunięto: "+b;
    }

    @GetMapping("/createwp")
    @ResponseBody
    public String createWithPublisher() {
        Publisher p = new Publisher()
                .setName("PWN");
        publisherDao.create(p);

        final Book b = new Book()
                .setTitle("Thinking in Java")
                .setPublisher(p)
                .setDescription("Klasyczna książka programistyczna.")
                .setRating(8);

        bookDao.create(b);
        return b.toString();
    }

    @GetMapping("/all")
    @ResponseBody
    public String showAll(){
        final String html = bookDao.readAll()
                .stream()
                .map(Book::toString)
                .collect(Collectors.joining("</div>\r\n<div>","<div>", "</div>"));

        return html;
    }

    @GetMapping("/byratinggte")
    @ResponseBody
    public String showByRatingGTE(@RequestParam(required = false) Integer minRating){
        if(minRating==null){
            minRating = 8;
        }

        final String html = bookDao.readByRatingGTE(minRating)
                .stream()
                .map(Book::toString)
                .collect(Collectors.joining("</div>\r\n<div>","<div>", "</div>"));

        return html;
    }
}
