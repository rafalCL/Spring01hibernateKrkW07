package pl.coderslab.spring01hibernatekrkw07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

    // metodę wyszukującą książki dla zadanego tytułu.
    @Query("SELECT e FROM Book e WHERE e.title = ?1")
    List<Book> queryByTitle(String title);
    //metodę wyszukującą książki dla zadanej kategorii
    @Query("SELECT e FROM Book e WHERE e.category = ?1")
    List<Book> queryByCategory(Category category);

    @Query(value = "SELECT * FROM books WHERE category_id = ?1 ORDER BY title LIMIT 1", nativeQuery = true)
    Book queryFirstInCategory(long catId);

    @Query(value = "SELECT id, title FROM books WHERE id = ?1", nativeQuery = true)
    List<Object[]> queryPart(long id);
}
