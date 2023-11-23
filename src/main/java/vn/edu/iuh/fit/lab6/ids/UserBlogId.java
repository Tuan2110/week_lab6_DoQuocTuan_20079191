package vn.edu.iuh.fit.lab6.ids;


import jakarta.persistence.Column;
import vn.edu.iuh.fit.lab6.models.Blog;
import vn.edu.iuh.fit.lab6.models.User;

public class UserBlogId {

    private User user;

    private Blog blog;

    public UserBlogId() {
    }

    public UserBlogId(User user, Blog blog) {
        this.user = user;
        this.blog = blog;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
