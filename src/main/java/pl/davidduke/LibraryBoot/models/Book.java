package pl.davidduke.LibraryBoot.models;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty(message = "The name of the book must not be empty")
    @Size(min = 2, max = 100, message = "The length of the title must be from 2 to 100 characters!")
    @Column(name = "title")
    private String title;

    @NotEmpty
    @Size(min = 2, max = 100, message = "The length of the author must be from 2 to 100 characters!")
    @Column(name = "author")
    private String author;

    @Min(value = 1500, message = "Year of publication must be greater than 1500!")
    @Column(name = "publication_year")
    private int publicationYear;

    public Book() {
        super();
    }


    public Book(int id, String title, String author, int publicationYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
}
