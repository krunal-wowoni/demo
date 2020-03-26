package com.wowoni.springboot.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wowoni.springboot.auth.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
