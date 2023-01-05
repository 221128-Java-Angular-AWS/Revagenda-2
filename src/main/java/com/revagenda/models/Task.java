package com.revagenda.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

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

    @Transient
    @JsonIgnore
    private String transientMessage = "This never goes into the database, because it is marked @Transient";

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
