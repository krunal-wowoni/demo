package com.wowoni.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wowoni.auth.model.User;

public interface UserRepository extends JpaRepository
{
	User findByUsername(String username);
}
