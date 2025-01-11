package com.BackTienda.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BackTienda.entities.CustomUser;

public interface ICustomUserRepository extends JpaRepository<CustomUser, Long>{

	Optional<CustomUser> findByEmail(String email);
}
