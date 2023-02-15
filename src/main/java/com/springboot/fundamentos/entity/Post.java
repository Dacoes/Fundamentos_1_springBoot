package com.springboot.fundamentos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="post")
@Getter @Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPost", nullable = false,unique = true)
    private Long id;

    @Column(name = "description",length = 255)
    private String description;

    @ManyToOne
    private User user;

    public Post() {
    }

    public Post(String description, User user) {
        this.description = description;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }
}
