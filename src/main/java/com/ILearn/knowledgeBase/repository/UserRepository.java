package com.ILearn.knowledgeBase.repository;

import com.ILearn.knowledgeBase.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);
}
