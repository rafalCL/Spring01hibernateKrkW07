package pl.coderslab.spring01hibernatekrkw07.entity;

// W projekcie Spring01hibernate utwórz encje o nazwie Book.
//Ustal nazwę tabeli bazy danych dla tej encji na books.
//Encja ma zawierać następujące pola:
//id
//title (String)
//rating (int)
//description (String)
//Uruchom aplikację, a następnie sprawdź, czy w bazie danych pojawiła się tabela.

// Dla encji Book ustaw następujące ograniczenia:
//title - minimum 5 znaków
//rating - w przedziale 1 do 10
//description - maksymalnie 600 znaków
//author - pole wymagane
//publisher - pole wymagane
//Rozbuduj encję o pole:
//pages - większe od 1

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Size(min = 5)
    private String title;
    @Range(min = 1, max = 10)
    private int rating;
    @Size(max = 600)
    private String description;
    @NotNull
    @ManyToOne
    private Publisher publisher;
    @NotNull
    @Size(min = 1)
    @ManyToMany
    List<Author> authors = new ArrayList<>();
    @Min(1)
    private int pages;

    public long getId() {
        return id;
    }

    public Book setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getRating() {
        return rating;
    }

    public Book setRating(int rating) {
        this.rating = rating;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Book setDescription(String description) {
        this.description = description;
        return this;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public Book setPublisher(Publisher publisher) {
        this.publisher = publisher;
        return this;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public Book setAuthors(List<Author> authors) {
        this.authors = authors;
        return this;
    }

    public int getPages() {
        return pages;
    }

    public Book setPages(int pages) {
        this.pages = pages;
        return this;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", publisher=" + publisher +
                ", authors=" + authors +
                '}';
    }
}
