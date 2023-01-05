package com.revagenda.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

/**
 * This is a model or entity class. We mark it with the @Entity annotation which indicates to Spring that this
 * is a class which describes objects we will want to persist in a database. These aren't beans, there's no need
 * to scan the packages with the models. Spring is made aware of this class when we typify the repository.
 *
 * The annotations here come from the jakarta.persistence library, not from spring itself, though the library is
 * a sub-dependency of the spring data JPA module. So, when we include a dependency for spring data, we also get
 * jakarta and these annotations automatically.
 *
 * The @Table annotation allows us to set some attributes that control how spring (and hibernate) are going to
 * build the table schema for us.
 */

@Entity
@Table(name = "tasks", schema = "public")
public class Task {
    @Id
    @Column(name = "task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private Boolean completed;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private User user;

    @Transient//transient sets this field to be ignored by spring data and hibernate. This will not be saved to the db.
    @JsonIgnore//similar to @Transient, this tells the fasterXML objectmapper to ignore this field.
    private String transientMessage = "This never goes into the database, because it is marked @Transient";

    /*
    Remember that both the fasterXML objectmapper and hibernate both utilize a no-args constructor. If
    you write a constructor and don't also explicitly include a no-args overload, objectmapper and hibernate will
    throw exceptions.
     */
    public Task() {
    }

    public Task(String title, String description, Boolean completed, User user) {
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.user = user;
    }

    public Task(Integer id, String title, String description, Boolean completed, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTransientMessage() {
        return transientMessage;
    }

    public void setTransientMessage(String transientMessage) {
        this.transientMessage = transientMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(title, task.title) && Objects.equals(description, task.description) && Objects.equals(completed, task.completed) && Objects.equals(user, task.user) && Objects.equals(transientMessage, task.transientMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, completed, user, transientMessage);
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                ", user=" + user +
                ", transientMessage='" + transientMessage + '\'' +
                '}';
    }
}
