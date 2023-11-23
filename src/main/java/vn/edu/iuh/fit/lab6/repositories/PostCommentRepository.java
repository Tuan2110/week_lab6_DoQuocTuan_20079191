package vn.edu.iuh.fit.lab6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.edu.iuh.fit.lab6.models.PostComment;

import java.util.List;

public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
    @Query("SELECT pc FROM PostComment pc WHERE pc.post.id=?1 and pc.parent.id is null ORDER BY pc.createdAt ASC")
    List<PostComment> findAllByPostId(Long postId);
}
