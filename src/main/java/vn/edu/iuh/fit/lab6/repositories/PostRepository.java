package vn.edu.iuh.fit.lab6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.edu.iuh.fit.lab6.models.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByCreatedAtDesc();
    @Query("SELECT p FROM Post p WHERE p.blog.id=?1 ORDER BY p.createdAt DESC")
    List<Post> getPostByBlogId(Long blogId);
    @Query("SELECT p FROM Post p WHERE p.blog.id=?1 ORDER BY p.createdAt DESC")
    List<Post> findPostByBlogId(long blogId);
}
