package com.BMT.blog.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.BMT.blog.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserName(String userName);

}