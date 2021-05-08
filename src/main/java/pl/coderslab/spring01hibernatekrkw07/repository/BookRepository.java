package pl.coderslab.spring01hibernatekrkw07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.spring01hibernatekrkw07.entity.Book;
import pl.coderslab.spring01hibernatekrkw07.entity.Category;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    // metodę wyszukującą książki dla zadanego tytułu.
    List<Book> findByTitleIgnoreCase(String title);
    //metodę wyszukującą książki dla zadanej kategorii
    List<Book> findByCategory(Category category);
    List<Book> findByCategoryNameIgnoreCase(String catName);
    //metodę wyszukującą książki dla zadanego id kategorii
    List<Book> findByCategoryId(long catId);
}
