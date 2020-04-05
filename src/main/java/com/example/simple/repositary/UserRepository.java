package com.example.simple.repositary;
import com.example.simple.entity.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDAO, Long> {

    Optional<UserDAO> findByEmail(String email);

    UserDAO save(UserDAO user);
}