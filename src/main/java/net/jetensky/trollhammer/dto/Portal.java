package net.jetensky.trollhammer.dto;

import javax.persistence.*;

@Entity
public class Portal {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;

    private String title;

    @ManyToOne(optional = false)
    private Company company;

    public Portal() {
    }

    public Portal(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Portal{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
