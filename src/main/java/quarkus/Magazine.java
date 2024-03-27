package quarkus;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Magazine extends PanacheEntity {

    private String title;

    private int numPages;

    private LocalDate pubDate;

    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public LocalDate getPubDate() {
        return pubDate;
    }

    public void setPubDate(LocalDate pubDate) {
        this.pubDate = pubDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Magazine magazine)) return false;
        return numPages == magazine.numPages && Objects.equals(title, magazine.title) && Objects.equals(pubDate, magazine.pubDate) && Objects.equals(description, magazine.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, numPages, pubDate, description);
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "title='" + title + '\'' +
                ", numPages=" + numPages +
                ", pubDate=" + pubDate +
                ", description='" + description + '\'' +
                '}';
    }
}
