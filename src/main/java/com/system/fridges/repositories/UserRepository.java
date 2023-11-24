package com.system.fridges.repositories;

import com.system.fridges.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM user WHERE password = ?1 AND email = ?2", nativeQuery = true)
    Optional<User> findUserByPasswordEmail(String password, String email);

    @Query(value = "SELECT * FROM user as u WHERE u.email = email", nativeQuery = true)
    User findUserByEmail(@Param("email") String email);
}
