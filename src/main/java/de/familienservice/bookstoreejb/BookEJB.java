/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.familienservice.bookstoreejb;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pasc
 */
@Stateless
@LocalBean
public class BookEJB implements BookEJBRemote {
    @PersistenceContext(unitName = "bookstore-ejb")
    EntityManager em;

    public List<Book> findBooks() {
        return em.createNamedQuery("Book.findAllBooks", Book.class).getResultList();
    }

    public Book findBookById(Long id) {
        return em.find(Book.class, id);
    }

    public Book createBook(Book book) {
        em.persist(book);
        return book;
    }

    public void deleteBook(Book book) {
        em.remove(em.merge(book));
    }

    public Book updateBook(Book book) {
        return em.merge(book);
    }

}
