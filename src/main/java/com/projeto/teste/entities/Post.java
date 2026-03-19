package com.projeto.teste.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.projeto.teste.abstractClasses.Publication;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_posts")
public class Post extends Publication {

    private String imgURL;
    
    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
    private Set<PostLike> postLikes = new HashSet<>();
    
    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<Comment> comments = new HashSet<>();
    
    public Post() {}

    public Post(Long id, String description, String imgURL) {
        this.setId(id); 
        this.setDescription(description); 
        this.imgURL = imgURL;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public Set<PostLike> getPostLikes() {
        return postLikes;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Post other = (Post) obj;
        return Objects.equals(this.getId(), other.getId());
    }
}