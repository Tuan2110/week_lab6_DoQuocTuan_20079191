package vn.edu.iuh.fit.lab6.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.lab6.models.User;
import vn.edu.iuh.fit.lab6.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpServletRequest request) {
        User user = userService.login(email, password);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        return "redirect:/post";
    }
}
