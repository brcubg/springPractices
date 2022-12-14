package com.brcubg.demospringproject.repository;

import com.brcubg.demospringproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // List<User> findByUserNameContaining(String userName);
}
