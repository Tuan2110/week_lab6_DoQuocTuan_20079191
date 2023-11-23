package vn.edu.iuh.fit.lab6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.edu.iuh.fit.lab6.models.Blog;

import java.util.List;
import java.util.Optional;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    @Query("SELECT b FROM Blog b join UserBlog ub on b.id = ub.blog.id WHERE ub.user.id = ?1")
    List<Blog> getBlogByUserId(Long userId);

    @Query("SELECT b FROM Blog b WHERE b.title like %:title%")
    List<Blog> getBlogByTitle(String title);
}
