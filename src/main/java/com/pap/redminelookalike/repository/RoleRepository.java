package com.pap.redminelookalike.repository;


import com.pap.redminelookalike.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role getReferenceById(Long roleId);

}
