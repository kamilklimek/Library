package pl.maniaq.library.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "DEFAULT_SEQ")
    public Long id;

    @Column(name="categoryName")
    private String categoryName;

    @Column(name="description")
    private String description;

    @OneToMany(cascade = {CascadeType.ALL},
            targetEntity = Book.class)
    private Set<Book> books = new HashSet<>();

    public Category(){

    }

    Category(final String categoryName){
        this.categoryName=categoryName;
    }

    public Category(final String categoryName, final String description){
        this.categoryName=categoryName;
        this.description=description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) &&
                Objects.equals(categoryName, category.categoryName) &&
                Objects.equals(description, category.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, categoryName, description);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                ", books=" + books +
                '}';
    }
}
