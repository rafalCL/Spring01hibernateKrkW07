package pl.coderslab.spring01hibernatekrkw07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.spring01hibernatekrkw07.dao.BookDao;
import pl.coderslab.spring01hibernatekrkw07.entity.Book;

@Controller
@RequestMapping("/book")
public class BookController {
    private BookDao bookDao;

    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
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
}
