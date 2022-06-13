package com.pap.redminelookalike.repository;

import com.pap.redminelookalike.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
//    User findByUsernameAndRole(String username);
}
