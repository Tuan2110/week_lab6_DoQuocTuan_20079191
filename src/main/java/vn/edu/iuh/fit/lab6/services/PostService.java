package vn.edu.iuh.fit.lab6.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lab6.models.Post;
import vn.edu.iuh.fit.lab6.repositories.PostRepository;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    public List<Post> getPostByBlogId(Long blogId) {
        return postRepository.getPostByBlogId(blogId);
    }
    public List<Post> findAllByOrderByCreatedAtDesc() {
        return postRepository.findAllByOrderByCreatedAtDesc();
    }

    public List<Post> findPostByBlogId(long blogId) {
        return postRepository.findPostByBlogId(blogId);
    }

    public void deletePost(long postId) {
        postRepository.deleteById(postId);
    }

    public Post findById(long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public void createPost(Post post) {
        postRepository.save(post);
    }
}
