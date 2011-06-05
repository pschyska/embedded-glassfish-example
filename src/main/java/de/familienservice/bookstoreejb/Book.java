
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.familienservice.bookstoreejb;

import java.io.Serializable;

import javax.annotation.Generated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author pasc
 */
@Entity
@NamedQuery(name = "Book.findAllBooks",
query = "SELECT b FROM Book b")
public class Book implements Serializable {

    @Column(length = 2000)
    private String description;
    @Id
    @GeneratedValue
    private Long id;
    private Boolean illustrations;
    private String isbn;
    private Integer nbOfPages;
    private Float price;
    @Column(nullable = false)
    private String title;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final Book other = (Book) obj;

        if (( this.id != other.id ) && ( ( this.id == null ) || !this.id.equals(other.id) )) {
            return false;
        }

        if (( this.title == null )
                ? ( other.title != null )
                : !this.title.equals(other.title)) {
            return false;
        }

        if (( this.price != other.price ) && ( ( this.price == null ) || !this.price.equals(other.price) )) {
            return false;
        }

        if (( this.description == null )
                ? ( other.description != null )
                : !this.description.equals(other.description)) {
            return false;
        }

        if (( this.isbn == null )
                ? ( other.isbn != null )
                : !this.isbn.equals(other.isbn)) {
            return false;
        }

        if (( this.nbOfPages != other.nbOfPages )
                && ( ( this.nbOfPages == null ) || !this.nbOfPages.equals(other.nbOfPages) )) {
            return false;
        }

        if (( this.illustrations != other.illustrations )
                && ( ( this.illustrations == null ) || !this.illustrations.equals(other.illustrations) )) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;

        hash = 97 * hash + ( ( this.id != null )
                ? this.id.hashCode()
                : 0 );
        hash = 97 * hash + ( ( this.title != null )
                ? this.title.hashCode()
                : 0 );
        hash = 97 * hash + ( ( this.price != null )
                ? this.price.hashCode()
                : 0 );
        hash = 97 * hash + ( ( this.description != null )
                ? this.description.hashCode()
                : 0 );
        hash = 97 * hash + ( ( this.isbn != null )
                ? this.isbn.hashCode()
                : 0 );
        hash = 97 * hash + ( ( this.nbOfPages != null )
                ? this.nbOfPages.hashCode()
                : 0 );
        hash = 97 * hash + ( ( this.illustrations != null )
                ? this.illustrations.hashCode()
                : 0 );

        return hash;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIllustrations() {
        return illustrations;
    }

    public void setIllustrations(Boolean illustrations) {
        this.illustrations = illustrations;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getNbOfPages() {
        return nbOfPages;
    }

    public void setNbOfPages(Integer nbOfPages) {
        this.nbOfPages = nbOfPages;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}