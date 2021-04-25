package pl.coderslab.spring01hibernatekrkw07.dao;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernatekrkw07.entity.Author;
import pl.coderslab.spring01hibernatekrkw07.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    private EntityManager em;

    public void create(Author e){
        em.persist(e);
    }

    public Author readById(long id){
        return em.find(Author.class, id);
    }

    public void update(Author e){
        em.merge(e);
    }

    public void delete(Author e){
        em.remove(em.contains(e) ? e : em.merge(e));
    }

    public List<Author> readAll() {
        Query q = em.createQuery("SELECT e FROM Author e");
        return q.getResultList();
    }
}
