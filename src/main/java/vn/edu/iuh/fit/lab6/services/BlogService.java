package vn.edu.iuh.fit.lab6.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lab6.models.Blog;
import vn.edu.iuh.fit.lab6.repositories.BlogRepository;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;
    public List<Blog> getBlogByUserId(Long userId) {
        return blogRepository.getBlogByUserId(userId);
    }

    public Blog findById(long blogId) {
        return blogRepository.findById(blogId).orElse(null);
    }

    public void addBlog(Blog blog) {
        blogRepository.save(blog);
    }

    public List<Blog> getBlogByTitle(String title) {
        return blogRepository.getBlogByTitle(title);
    }
}
