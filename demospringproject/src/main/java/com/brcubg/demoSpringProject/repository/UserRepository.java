package com.brcubg.demoSpringProject.repository;

import com.brcubg.demoSpringProject.entity.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // List<User> findByUserNameContaining(String userName);
}
