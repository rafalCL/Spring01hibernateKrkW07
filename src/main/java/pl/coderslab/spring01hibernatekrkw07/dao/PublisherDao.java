package pl.coderslab.spring01hibernatekrkw07.dao;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernatekrkw07.entity.Book;
import pl.coderslab.spring01hibernatekrkw07.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PublisherDao {
    @PersistenceContext
    private EntityManager em;

    public void create(Publisher e){
        em.persist(e);
    }

    public Publisher readById(long id){
        return em.find(Publisher.class, id);
    }

    public Publisher readByIdWithBooks(long id){
        Publisher p = readById(id);
        Hibernate.initialize(p.getBooks());

        return p;
    }

    public void update(Publisher e){
        em.merge(e);
    }

    public void delete(Publisher e){
        em.remove(em.contains(e) ? e : em.merge(e));
    }

    public List<Publisher> readAll() {
        Query q = em.createQuery("SELECT e FROM Publisher e");
        return q.getResultList();
    }
}
