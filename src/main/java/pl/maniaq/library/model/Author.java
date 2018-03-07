package pl.maniaq.library.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="authorName")
    private String authorName;

    @Column(name="authorLastName")
    private String authorLastName;

    @Column(name="bornDate")
    private Date bornDate;

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
}
