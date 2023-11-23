package vn.edu.iuh.fit.lab6.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lab6.models.PostComment;
import vn.edu.iuh.fit.lab6.repositories.PostCommentRepository;

import java.util.List;

@Service
public class PostCommentService {
    @Autowired
    private PostCommentRepository postCommentRepository;
    public List<PostComment> findAllByPostId(Long postId){
        return postCommentRepository.findAllByPostId(postId);
    }
    public void save(PostComment postComment){
        postCommentRepository.save(postComment);
    }

    public PostComment findById(long parentId) {
        return postCommentRepository.findById(parentId).orElse(null);
    }
}
