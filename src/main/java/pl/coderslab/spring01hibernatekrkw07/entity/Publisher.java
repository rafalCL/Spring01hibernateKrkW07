package pl.coderslab.spring01hibernatekrkw07.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany(mappedBy = "publisher")
    private List<Book> books = new ArrayList<>();

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Publisher setName(String name) {
        this.name = name;
        return this;
    }

    public Publisher setId(long id) {
        this.id = id;
        return this;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
