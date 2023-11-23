package vn.edu.iuh.fit.lab6.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20,name = "blog_id")
    private Long id;
    private String title;
    @ManyToOne
    private User author;
    @OneToMany
    @JoinColumn(name = "blog_id")
    private List<Post> posts;
    @OneToMany(mappedBy = "blog")
    private List<UserBlog> blogs;
    public Blog() {
    }
    public Blog(String title, User author) {
        this.title = title;
        this.author = author;
    }
    public Blog(String title, User author, List<Post> posts) {
        this.title = title;
        this.author = author;
        this.posts = posts;
    }

    public List<UserBlog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<UserBlog> blogs) {
        this.blogs = blogs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
