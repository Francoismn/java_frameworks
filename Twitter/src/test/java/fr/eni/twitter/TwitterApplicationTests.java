package fr.eni.twitter;

import fr.eni.twitter.bo.Profile;
import fr.eni.twitter.bo.User;
import fr.eni.twitter.dal.UserRepository;
import jakarta.persistence.Column;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TwitterApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Commit
    void contextLoads() {
        Profile profile = Profile.builder()
                .firstname("Pierre")
                .lastname("Rocher")
                .build();
        User user = User.builder()
                .username("PierreCailloux")
                .email("pierre@mail.com")
                .profile(profile)
                .password("pass")
                .dateCreated(LocalDate.now())
                .build();

        User userBdd = userRepository.save(user);
        Assertions.assertThat(userBdd).isNotNull();

        System.out.println(userBdd.getProfile());
    }

    //JPQL
    @Test
    public void testSearchUserByUsername() {
        //Arrange
        String motCle = "%Pierre%";
        //Act
        List<User> users = userRepository.searchUserByUsername(motCle);
        //Assert
        Assertions.assertThat(users).hasSize(1);

        System.out.println(users);
    }

    //SQL
    @Test
    public void testSearchUserByEmail() {
        //Arrange
        String motCle = "pierre@mail.com";
        //Act
        Optional<User> users = userRepository.searchUserByEmail(motCle);
        //Assert
        Assertions.assertThat(users).isNotNull();

        System.out.println(users);
    }






}
