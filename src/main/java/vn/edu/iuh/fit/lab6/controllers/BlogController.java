package vn.edu.iuh.fit.lab6.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.lab6.ids.UserBlogId;
import vn.edu.iuh.fit.lab6.models.Blog;
import vn.edu.iuh.fit.lab6.models.User;
import vn.edu.iuh.fit.lab6.models.UserBlog;
import vn.edu.iuh.fit.lab6.repositories.BlogUserRepository;
import vn.edu.iuh.fit.lab6.services.BlogService;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private BlogUserRepository blogUserRepository;
    @GetMapping("/create")
    public String createBlog(){
        return "blogs/create-blog";
    }
    @PostMapping("/create")
    public String createBlogPost(HttpSession session, @RequestParam("title")String title){
        User user = (User) session.getAttribute("user");
        Blog blog = new Blog(title,user);
        user.getBlogs().add(blog);
        blogService.addBlog(blog);
        return "redirect:/post";
    }
    @GetMapping("/manage")
    public String manageBlog(HttpSession session, HttpServletRequest request,@RequestParam(value = "title",defaultValue = "") String title){
        User user = (User) session.getAttribute("user");
        request.setAttribute("blogs",blogService.getBlogByUserId(user.getId()));
        if(!title.isEmpty()){
            List<Blog> blogFound = blogService.getBlogByTitle(title);
            request.setAttribute("blogFound",blogFound);
        }
        return "blogs/manage";
    }
    @GetMapping("/unfollow/{blogId}")
    public String unfollowBlog(HttpSession session,@PathVariable("blogId") String blogId){
        User user = (User) session.getAttribute("user");
        Blog blog = blogService.findById(Long.parseLong(blogId));
        user.getBlogs().remove(blog);
        blogUserRepository.delete(new UserBlog(new UserBlogId(user,blog)));
        return "redirect:/blog/manage";
    }
    @GetMapping("/follow/{blogId}")
    public String followBlog(HttpSession session,@PathVariable("blogId") String blogId){
        User user = (User) session.getAttribute("user");
        Blog blog = blogService.findById(Long.parseLong(blogId));
        user.getBlogs().add(blog);
        UserBlog userBlog = new UserBlog(new UserBlogId(user,blog));
        blogUserRepository.save(userBlog);
        return "redirect:/blog/manage";
    }
}
