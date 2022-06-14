package com.pap.redminelookalike.repository;

import com.pap.redminelookalike.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    List<User> findAll();
//    User findByUsernameAndRole(String username);
}
