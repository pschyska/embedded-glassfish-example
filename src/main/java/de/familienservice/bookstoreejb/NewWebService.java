package de.familienservice.bookstoreejb;

import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ejb.Stateless;

/**
 *
 * @author pasc
 */
@WebService(serviceName = "NewWebService")
@Stateless()
public class NewWebService {
    @EJB
    private BookEJBRemote ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "createBook")
    public Book createBook(@WebParam(name = "book")
    Book book) {
        return ejbRef.createBook(book);
    }

    @WebMethod(operationName = "deleteBook")
    @Oneway
    public void deleteBook(@WebParam(name = "book")
    Book book) {
        ejbRef.deleteBook(book);
    }

    @WebMethod(operationName = "findBookById")
    public Book findBookById(@WebParam(name = "id")
    Long id) {
        return ejbRef.findBookById(id);
    }

    @WebMethod(operationName = "findBooks")
    public List<Book> findBooks() {
        return ejbRef.findBooks();
    }

    @WebMethod(operationName = "updateBook")
    public Book updateBook(@WebParam(name = "book")
    Book book) {
        return ejbRef.updateBook(book);
    }

}
