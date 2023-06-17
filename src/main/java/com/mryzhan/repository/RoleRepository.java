package com.mryzhan.repository;

import com.mryzhan.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface RoleRepository extends JpaRepository<Role,Long> {


}
