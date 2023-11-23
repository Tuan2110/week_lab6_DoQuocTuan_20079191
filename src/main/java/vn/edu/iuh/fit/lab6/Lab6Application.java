package vn.edu.iuh.fit.lab6;

import net.datafaker.Faker;
import net.datafaker.providers.base.Device;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.lab6.models.Blog;
import vn.edu.iuh.fit.lab6.models.Post;
import vn.edu.iuh.fit.lab6.models.PostComment;
import vn.edu.iuh.fit.lab6.models.User;
import vn.edu.iuh.fit.lab6.repositories.BlogRepository;
import vn.edu.iuh.fit.lab6.repositories.PostCommentRepository;
import vn.edu.iuh.fit.lab6.repositories.PostRepository;
import vn.edu.iuh.fit.lab6.repositories.UserRepository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Random;

@SpringBootApplication
public class Lab6Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab6Application.class, args);
    }
    CommandLineRunner commandLineRunner(UserRepository userRepository,
                                        BlogRepository blogRepository,
                                        PostRepository postRepository,
                                        PostCommentRepository postCommentRepository){
        return args -> {
//            Faker faker = new Faker();
//            Random rnd = new Random();
//            Device device = faker.device();
//            for (long i = 0; i <= 99; i++) {
//                User user = new User(
//                        faker.name().firstName(),
//                        faker.name().lastName(),
//                        faker.name().lastName(),
//                        faker.phoneNumber().cellPhone(),
//                        faker.internet().emailAddress(),
//                        faker.internet().password(),
//                        Instant.now(),
//                        Instant.now(),
//                        faker.lorem().paragraph(1),
//                        faker.lorem().paragraph(1)
//                );
//                userRepository.save(user);
//                Blog blog = new Blog(
//                     faker.book().title()
//                        ,userRepository.findById(rnd.nextLong(rnd.nextLong(1,10))).get()
//                );
//                blogRepository.save(blog);
//                Blog blog = blogRepository.findById(rnd.nextLong(rnd.nextLong(1,9))).get();
//
//                Post post = new Post(
//                        blog.getAuthor(),
//                        null,
//                        faker.book().title(),
//                        faker.book().title(),
//                        faker.lorem().paragraph(1),
//                        true,
//                        Instant.now(),
//                        Instant.now(),
//                        Instant.now(),
//                        faker.lorem().paragraph(1),
//                        blog
//                );
//                postRepository.save(post);
//            }
    };
}
}
