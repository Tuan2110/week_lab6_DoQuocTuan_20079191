package vn.edu.iuh.fit.lab6.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.edu.iuh.fit.lab6.models.Post;
import vn.edu.iuh.fit.lab6.models.PostComment;
import vn.edu.iuh.fit.lab6.models.User;
import vn.edu.iuh.fit.lab6.services.PostCommentService;
import vn.edu.iuh.fit.lab6.services.PostService;

import java.time.Instant;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private PostCommentService commentService;
    @Autowired
    private PostService postService;
    @GetMapping
    public String comment(HttpServletRequest request, @PathParam("postId") String postId,@PathParam("content") String content,@PathParam("parentId") String parentId){
        User user = (User) request.getSession().getAttribute("user");
        Post post = postService.findById(Long.parseLong(postId));
        PostComment parent = null;
        if(!parentId.isEmpty()){
            parent = commentService.findById(Long.parseLong(parentId));
        }
        PostComment comment = new PostComment(post,parent,"",true, Instant.now(),Instant.now(),content,null,user);
        commentService.save(comment);
        return "redirect:/post/detail/"+postId;
    }
}
