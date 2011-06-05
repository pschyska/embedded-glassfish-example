package de.familienservice.bookstoreejb;

import javax.ejb.EJB;

public class Main {
    @EJB
    private static BookEJBRemote bookEJB;

    public static void main(String[] args) {
        System.out.println("Hello, friend");
        Book book=new Book();
        book.setTitle("The Hitchhiker's Guide to the Galaxy");
        book.setPrice(12.5F);
        book.setDescription("Scifi book created by Douglas Adams");
        book.setIsbn("1-84023-742-2");
        book.setNbOfPages(354);
        book.setIllustrations(false);

        bookEJB.createBook(book);
        book.setTitle("H2G2");
        bookEJB.updateBook(book);
        bookEJB.deleteBook(book);
    }
}

