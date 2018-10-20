package pl.maniaq.library.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "DEFAULT_SEQ")
    private Long id;

    @Column(name="AUTHOR_NAME")
    private String authorName;

    @Column(name="AUTHOR_LASTNAME")
    private String authorLastName;

    @Column(name="BORN_DATE")
    private Date bornDate;

    @OneToMany(cascade = CascadeType.ALL,  mappedBy = "author")
    private Set<Book> books = new HashSet<>();



    public Author(){

    }

    public Author(String authorName, String authorLastName, Date bornDate) {
        this.authorName = authorName;
        this.authorLastName = authorLastName;
        this.bornDate = bornDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) &&
                Objects.equals(authorName, author.authorName) &&
                Objects.equals(authorLastName, author.authorLastName) &&
                Objects.equals(bornDate, author.bornDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, authorName, authorLastName, bornDate);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", authorLastName='" + authorLastName + '\'' +
                ", bornDate=" + bornDate +
                ", books=" + books +
                '}';
    }
}
