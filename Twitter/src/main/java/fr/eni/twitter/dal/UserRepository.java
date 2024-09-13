package fr.eni.twitter.dal;

import fr.eni.twitter.bo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //Java Persistence Query Language
    @Query("SELECT u FROM User u WHERE u.username LIKE :keyword")
    List<User> searchUserByUsername(@Param("keyword") String keyword);


    @Query(value = "SELECT u.* FROM users u WHERE u.email = :keyword", nativeQuery = true)
    Optional<User> searchUserByEmail(@Param("keyword") String keyword);


}
