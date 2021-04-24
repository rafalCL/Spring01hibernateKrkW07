package pl.coderslab.spring01hibernatekrkw07.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernatekrkw07.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

// Na podstawie przykładu z prezentacji utwórz klasę BookDao.
//Klasa ma realizować podstawowe operacje na encji:
//zapis encji
//edycja encji
//pobieranie po id
//usuwanie po id

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    private EntityManager em;

    public void create(Book e){
        em.persist(e);
    }

    public Book readById(long id){
        return em.find(Book.class, id);
    }

    public void update(Book e){
        em.merge(e);
    }

    public void delete(Book e){
        em.remove(em.contains(e) ? e : em.merge(e));
    }
}
