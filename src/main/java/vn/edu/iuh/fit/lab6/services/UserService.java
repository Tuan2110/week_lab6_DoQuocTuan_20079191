package vn.edu.iuh.fit.lab6.services;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lab6.models.User;
import vn.edu.iuh.fit.lab6.repositories.UserRepository;

import java.security.MessageDigest;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User login(String email, String passwordHash) {
        Optional<User> optional = userRepository.findByEmailAndPasswordHash(email, toSHA1(passwordHash));
        if(optional.isPresent()) {
            return optional.get();
        }
        throw new RuntimeException("User not found");
    }
    private String toSHA1(String password) {
        String salt = "tuan123avceidasdf";
        String result = null;
        password = password+salt;
        try {
            byte[] dataBytes = password.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            result = Base64.encodeBase64String(md.digest(dataBytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
