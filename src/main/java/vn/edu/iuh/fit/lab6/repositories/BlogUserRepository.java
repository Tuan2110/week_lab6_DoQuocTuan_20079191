package vn.edu.iuh.fit.lab6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import vn.edu.iuh.fit.lab6.ids.UserBlogId;
import vn.edu.iuh.fit.lab6.models.UserBlog;

public interface BlogUserRepository extends JpaRepository<UserBlog, UserBlogId> {
//    @Modifying
//    @Query("DELETE FROM UserBlog ub WHERE ub.user.id = ?1 AND ub.blog.id = ?2")
//    void delete(Long userId,Long blogId);
}
