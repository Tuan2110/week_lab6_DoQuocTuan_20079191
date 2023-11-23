package vn.edu.iuh.fit.lab6.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter @Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20)
    private Long id;
    @Column(length = 50,name = "first_name")
    private String firstName;
    @Column(length = 50,name = "middle_name")
    private String middleName;
    @Column(length = 50,name = "last_name")
    private String lastName;
    @Column(length = 15)
    private String mobile;
    @Column(length = 50,unique = true,nullable = false)
    private String email;
    @Column(length = 32,nullable = false,name = "password_hash")
    private String passwordHash;
    @Column(nullable = false,name = "registered_at")
    private Instant registeredAt;
    @Column(name = "last_login")
    private Instant lastLogin;
    @Lob
    private String intro;
    @Lob
    private String profile;
    @OneToMany(mappedBy = "user")
    private Set<PostComment> postComments = new LinkedHashSet<>();
    @OneToMany(mappedBy = "author")
    private Set<Post> posts = new LinkedHashSet<>();
    @OneToMany(mappedBy = "user")
    private List<UserBlog> users;
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Blog> blogs;

    public User(String firstName, String middleName, String lastName, String mobile, String email, String passwordHash, Instant registeredAt, Instant lastLogin, String intro, String profile, Set<PostComment> postComments, Set<Post> posts) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.passwordHash = passwordHash;
        this.registeredAt = registeredAt;
        this.lastLogin = lastLogin;
        this.intro = intro;
        this.profile = profile;
        this.postComments = postComments;
        this.posts = posts;
    }

    public User(String firstName, String middleName, String lastName, String mobile, String email, String passwordHash, Instant registeredAt, Instant lastLogin, String intro, String profile) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.passwordHash = passwordHash;
        this.registeredAt = registeredAt;
        this.lastLogin = lastLogin;
        this.intro = intro;
        this.profile = profile;
    }
}
