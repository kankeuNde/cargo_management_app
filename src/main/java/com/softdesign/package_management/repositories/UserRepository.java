package com.softdesign.package_management.repositories;

import com.softdesign.package_management.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
