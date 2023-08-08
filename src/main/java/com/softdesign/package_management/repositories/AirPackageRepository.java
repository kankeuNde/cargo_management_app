package com.softdesign.package_management.repositories;

import com.softdesign.package_management.entities.AirPackage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirPackageRepository extends JpaRepository<AirPackage, Long> {
}
