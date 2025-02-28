package com.row49382.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.row49382.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
