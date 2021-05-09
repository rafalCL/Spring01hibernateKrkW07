package pl.coderslab.spring01hibernatekrkw07.controller;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01hibernatekrkw07.dao.AuthorDao;
import pl.coderslab.spring01hibernatekrkw07.dao.BookDao;
import pl.coderslab.spring01hibernatekrkw07.dao.PublisherDao;
import pl.coderslab.spring01hibernatekrkw07.entity.Author;
import pl.coderslab.spring01hibernatekrkw07.entity.Book;
import pl.coderslab.spring01hibernatekrkw07.entity.Category;
import pl.coderslab.spring01hibernatekrkw07.entity.Publisher;
import pl.coderslab.spring01hibernatekrkw07.repository.BookRepository;
import pl.coderslab.spring01hibernatekrkw07.repository.CategoryRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/bf")
public class BookFormController {
    private BookDao bookDao;
    private BookRepository bookRepository;
    private PublisherDao publisherDao;
    private AuthorDao authorDao;
    private CategoryRepository categoryRepository;

    public BookFormController(BookDao bookDao, BookRepository bookRepository, PublisherDao publisherDao, AuthorDao authorDao, CategoryRepository categoryRepository) {
        this.bookDao = bookDao;
        this.bookRepository = bookRepository;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
        this.categoryRepository = categoryRepository;
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

    @GetMapping("/bycatid/{catId}")
    @ResponseBody
    @Transactional
    public String byCatId(@PathVariable long catId){
        List<Book> books = bookRepository.findByCategoryId(catId);

        for(Book b : books){
            Hibernate.initialize(b.getAuthors());
        }

        return books.toString();
    }

    @GetMapping("/bycat/{catId}")
    @ResponseBody
    @Transactional
    public String byCat(@PathVariable long catId){
        Optional<Category> category = categoryRepository.findById(catId);
        if (category.isEmpty()){
            return "Nie znaleziono kategorii";
        }

        List<Book> books = bookRepository.findByCategory(category.get());

        for(Book b : books){
            Hibernate.initialize(b.getAuthors());
        }

        return books.toString();
    }

    @GetMapping("/bycatname/{catName}")
    @ResponseBody
    @Transactional
    public String byCatId(@PathVariable String catName){
        List<Book> books = bookRepository.findByCategoryNameIgnoreCase(catName);

        for(Book b : books){
            Hibernate.initialize(b.getAuthors());
        }

        return books.toString();
    }

    @GetMapping("/querybycat/{catId}")
    @ResponseBody
    @Transactional
    public String queryByCat(@PathVariable long catId){
        Optional<Category> category = categoryRepository.findById(catId);
        if (category.isEmpty()){
            return "Nie znaleziono kategorii";
        }

        List<Book> books = bookRepository.queryByCategory(category.get());

        for(Book b : books){
            Hibernate.initialize(b.getAuthors());
        }

        return books.toString();
    }

    @GetMapping("/querybytitle/{title}")
    @ResponseBody
    @Transactional
    public String queryByTitle(@PathVariable String title){
        List<Book> books = bookRepository.queryByTitle(title);

        for(Book b : books){
            Hibernate.initialize(b.getAuthors());
        }

        return books.toString();
    }

    @GetMapping("/queryonebycatid/{catId}")
    @ResponseBody
    @Transactional
    public String queryOneByCatId(@PathVariable long catId){
        Book book = bookRepository.queryFirstInCategory(catId);
        Hibernate.initialize(book.getAuthors());

        return book.toString();
    }

    @GetMapping("/queryid/{id}")
    @ResponseBody
    @Transactional
    public String queryId(@PathVariable long id){
        List<Object[]> book = bookRepository.queryPart(id);
        BigInteger iddb = (BigInteger)book.get(0)[0];
        String title = (String)book.get(0)[1];

        return iddb+" : "+title;
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
