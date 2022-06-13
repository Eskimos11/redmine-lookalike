package com.pap.redminelookalike.dao;


import com.pap.redminelookalike.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role getReferenceById(Long roleId);

}
