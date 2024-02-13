package com.BMT.blog.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BMT.blog.entities.RefreshToken;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long>{

	RefreshToken findByUserId(Long userId);
	
}