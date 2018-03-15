package pl.maniaq.library.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Table(name="BOOKS")
@Entity(name="BOOKS")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="releaseYear")
    private Integer releaseYear;

    @Column(name="author_id")
    private Long authorId;



    public Book(String title, String description, Integer releaseYear) {
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
    }

    private static class BookBuilder{
        private String title;
        private String description;
        private Integer releaseYear;

        public BookBuilder setTitle(String title){
            this.title=title;
            return this;
        }

        public BookBuilder setDescription(String description){
            this.description=description;
            return this;
        }

        public BookBuilder setReleaseYear(Integer releaseYear){
            this.releaseYear=releaseYear;
            return this;
        }


        public Book createBook(){
            return new Book(title, description, releaseYear);
        }

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(title, book.title) &&
                Objects.equals(description, book.description) &&
                Objects.equals(releaseYear, book.releaseYear);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, description, releaseYear);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

}
