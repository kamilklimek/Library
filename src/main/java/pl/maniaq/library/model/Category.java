package pl.maniaq.library.model;


import javax.persistence.*;
import java.util.Objects;

@Entity(name="CATEGORIES")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="categoryName")
    private String categoryName;

    @Column(name="description")
    private String description;

    Category(final String categoryName){
        this.categoryName=categoryName;
    }

    Category(final String categoryName, final String description){
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
}
