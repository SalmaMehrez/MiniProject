package com.salma.medecins.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import com.salma.medecins.entities.User;
public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}