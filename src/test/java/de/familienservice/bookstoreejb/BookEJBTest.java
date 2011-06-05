/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.familienservice.bookstoreejb;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.xml.ws.WebServiceRef;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pasc
 */
public class BookEJBTest {

    private static EJBContainer ec=null;
    private static Context ctx=null;

    public BookEJBTest() {
    }

    @BeforeClass
    public static void initContainer() throws Exception {
        Map<String, Object> props=new HashMap<String, Object>();
        props.put(EJBContainer.MODULES, new File("target/embedded-classes"));
        props.put("org.glassfish.ejb.embedded.glassfish.instance.root","./src/test/testing-domain");
        props.put("org.glassfish.ejb.embedded.glassfish.web.http.port","");
        ec = EJBContainer.createEJBContainer(props);
        ctx = ec.getContext();
    }


    @AfterClass
    public static void closeContainer() throws Exception {
        if(ctx!=null)
            ctx.close();
        if(ec!=null)
            ec.close();
    }

    @Test
    public void shouldCreateABook() throws Exception {

        Book book = new Book();
        book.setTitle("The Hitchhiker's Guide to the Galaxy");
        book.setPrice(12.5F);
        book.setDescription("Scifi book created by Douglas Adams");
        book.setIsbn("1-84023-742-2");
        book.setNbOfPages(354);
        book.setIllustrations(false);

        BookEJB bookEJB = (BookEJB) ctx.lookup("java:global/embedded-classes/BookEJB!de.familienservice.bookstoreejb.BookEJB");

        book = bookEJB.createBook(book);
        assertNotNull("ID should not be null", book.getId());
    }

}
