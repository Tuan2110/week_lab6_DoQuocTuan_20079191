package vn.edu.iuh.fit.lab6.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.lab6.models.Post;
import vn.edu.iuh.fit.lab6.models.User;
import vn.edu.iuh.fit.lab6.services.BlogService;
import vn.edu.iuh.fit.lab6.services.PostCommentService;
import vn.edu.iuh.fit.lab6.services.PostService;

import java.time.Instant;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private PostService postService;
    @Autowired
    private PostCommentService postCommentService;
    @GetMapping
    public String getPosts(HttpServletRequest request, HttpSession session, @RequestParam(value = "blogId",defaultValue = "") String blogId) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            request.setAttribute("blogs", blogService.getBlogByUserId(user.getId()));
        }
        List<Post> posts = postService.findAllByOrderByCreatedAtDesc();
        if(!blogId.isEmpty()){
            posts = postService.getPostByBlogId(Long.parseLong(blogId));
            request.setAttribute("blogId",blogId);
        }
        request.setAttribute("posts", posts);
        return "home";
    }
    @GetMapping("/mypost")
    public String getMyPosts(HttpServletRequest request, HttpSession session,@RequestParam(value = "blogId",defaultValue = "") String blogId) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            request.setAttribute("blogs", blogService.getBlogByUserId(user.getId()));
        }
        request.setAttribute("blogId",blogId);
        List<Post> posts = postService.findPostByBlogId(Long.parseLong(blogId));
        request.setAttribute("posts", posts);
        return "posts/post";
    }
    @GetMapping("/delete")
    public String deletePost(@RequestParam("postId") String postId,@RequestParam("blogId") String blogId){
        postService.deletePost(Long.parseLong(postId));
        return "redirect:/post/mypost?blogId="+blogId;
    }
    @GetMapping("update")
    public String updatePost(@RequestParam("postId") String postId,HttpServletRequest request){
        Post post = postService.findById(Long.parseLong(postId));
        request.setAttribute("post",post);
        return "posts/update-post";
    }
    @PostMapping("update")
    public String updatePost(@RequestParam("postId") String postId,@RequestParam("title") String title,@RequestParam("content") String content,@RequestParam("summary") String summary){
        Post post = postService.findById(Long.parseLong(postId));
        post.setTitle(title);
        post.setMetaTitle(title);
        post.setContent(content);
        post.setSummary(summary);
        post.setUpdatedAt(Instant.now());
        postService.createPost(post);
        return "redirect:/post/mypost?blogId="+post.getBlog().getId();
    }
    @GetMapping("/detail/{postId}")
    public String getPostDetail(HttpServletRequest request,@PathVariable("postId") String postId){
        Post post = postService.findById(Long.parseLong(postId));
        request.setAttribute("post",post);
        request.setAttribute("comments",postCommentService.findAllByPostId(Long.parseLong(postId)));
        return "posts/post-detail";
    }
    @GetMapping("/create")
    public String createPost(@RequestParam("blogId") String blogId,HttpServletRequest request){
        request.setAttribute("blogId",blogId);
        return "posts/create-post";
    }
    @PostMapping("/create")
    public String createPost(HttpServletRequest request,@RequestParam("blogId") String blogId,@RequestParam("title") String title,@RequestParam("content") String content,@RequestParam("summary") String summary){
        User user = (User) request.getSession().getAttribute("user");
        Post post = new Post(
                user,
                null,
                title,
                title,
                summary,
                true,
                Instant.now(),
                Instant.now(),
                Instant.now(),
                content,
                blogService.findById(Long.parseLong(blogId))
        );
        postService.createPost(post);
        return "redirect:/post/mypost?blogId="+blogId;
    }
}
