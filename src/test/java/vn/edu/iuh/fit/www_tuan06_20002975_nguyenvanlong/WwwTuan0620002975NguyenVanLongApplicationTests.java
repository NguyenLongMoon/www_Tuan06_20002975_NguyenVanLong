package vn.edu.iuh.fit.www_tuan06_20002975_nguyenvanlong;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;
import vn.edu.iuh.fit.www_tuan06_20002975_nguyenvanlong.backend.models.User;
import vn.edu.iuh.fit.www_tuan06_20002975_nguyenvanlong.backend.repositories.UserRepository;

import java.time.Instant;
import java.util.List;

@SpringBootTest

@TestConstructor(autowireMode = TestConstructor.AutowireMode.ANNOTATED)
class WwwTuan0620002975NguyenVanLongApplicationTests {
    @Autowired
    private UserRepository userRepository;

    //    @PostConstruct
    void insert() {
        User user;
        for (int i = 0; i < 100; i++) {
            user = new User(
                    LoremIpsum.getInstance().getFirstName(),
                    LoremIpsum.getInstance().getLastName(),
                    LoremIpsum.getInstance().getLastName(),
                    LoremIpsum.getInstance().getPhone(),
                    LoremIpsum.getInstance().getEmail(),
                    BCrypt.withDefaults().hashToString(23, LoremIpsum.getInstance().getPhone().toCharArray()),
                    Instant.now(), null, LoremIpsum.getInstance().getTitle(100),
                    LoremIpsum.getInstance().getWords(1000)
            );

            userRepository.save(user);
        }
    }

    @Test
    void contextLoads() {
        List<User> users = userRepository.findAll();

        Assertions.assertFalse(users.isEmpty());
    }

}
