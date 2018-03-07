package pl.maniaq.library.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

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

    @ManyToMany
    private Set<Category> categories;

    @ManyToMany
    private Set<Author> authors;

    public Book(String title, String description, Integer releaseYear, Set<Category> categories, Set<Author> authors) {
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.categories = categories;
        this.authors = authors;
    }

    private static class BookBuilder{
        private String title;
        private String description;
        private Integer releaseYear;
        private Set<Category> categories;
        private Set<Author> authors;

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

        public BookBuilder setCategories(Set<Category> categories){
            this.categories=categories;
            return this;
        }

        public BookBuilder setAuthors(Set<Author> authors){
            this.authors=authors;
            return this;
        }

        public Book createBook(){
            return new Book(title, description, releaseYear, categories, authors);
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
                Objects.equals(releaseYear, book.releaseYear) &&
                Objects.equals(categories, book.categories) &&
                Objects.equals(authors, book.authors);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, description, releaseYear, categories, authors);
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

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
