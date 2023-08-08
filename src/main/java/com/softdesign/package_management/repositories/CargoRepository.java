package com.softdesign.package_management.repositories;

import com.softdesign.package_management.entities.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
}
