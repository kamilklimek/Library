package pl.maniaq.library.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "DEFAULT_SEQ")
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="releaseYear")
    private Integer releaseYear;

    @OneToOne(cascade = {CascadeType.ALL}, targetEntity = Author.class)
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToOne(cascade = {CascadeType.ALL}, targetEntity = Category.class)
    @JoinColumn(name = "category_id")
    private Category category;


    public Book(){

    }

    public Book(String title, String description, Integer releaseYear, Author author, Category category) {
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.author = author;
        this.category = category;
    }



    public static class BookBuilder{
        private String title;
        private String description;
        private Integer releaseYear;
        private Author author = new Author();
        private Category category = new Category();

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

        public BookBuilder setAuthorId(Long id){
            this.author.setId(id);
            return this;
        }

        public BookBuilder setCategoryId(Long id){
            this.category.setId(id);
            return this;
        }

        public BookBuilder setAuthor(Author author){
            this.author=author;
            return this;
        }

        public BookBuilder setCategory(Category category){
            this.category=category;
            return this;
        }


        public Book createBook(){
            return new Book(title, description, releaseYear, author, category);
        }

    }

    public void setAuthorId(Long id){
        author.setId(id);
    }

    public void setCategoryId(Long id){
        category.setId(id);
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
                Objects.equals(author, book.author) &&
                Objects.equals(category, book.category);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, description, releaseYear, author, category);
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", releaseYear=" + releaseYear;
    }
}
