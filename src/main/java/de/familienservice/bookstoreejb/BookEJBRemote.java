/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.familienservice.bookstoreejb;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author pasc
 */
@Remote
public interface BookEJBRemote {

    Book createBook(Book book);

    void deleteBook(Book book);

    Book findBookById(Long id);

    List<Book> findBooks();

    Book updateBook(Book book);
}