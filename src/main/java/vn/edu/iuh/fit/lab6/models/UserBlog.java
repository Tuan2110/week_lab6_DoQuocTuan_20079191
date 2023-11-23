package vn.edu.iuh.fit.lab6.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.lab6.ids.UserBlogId;

@Entity
@Table(name = "blog_follower")
@IdClass(UserBlogId.class)
public class UserBlog {
    @Id
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;
    @Id
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name = "blog_id")
    private Blog blog;
    public UserBlog() {
    }
    public UserBlog(UserBlogId userBlogId) {
        this.user = userBlogId.getUser();
        this.blog = userBlogId.getBlog();
    }
    public UserBlog(User user, Blog blog) {
    }
}
