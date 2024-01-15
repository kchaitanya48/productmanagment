package com.sample.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.entity.Users;

public interface UserCredentialRepository extends JpaRepository<Users, Integer>{

	  Optional<Users> findByName(String username);
}
