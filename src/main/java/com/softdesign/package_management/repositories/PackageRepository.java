package com.softdesign.package_management.repositories;

import com.softdesign.package_management.entities.Package;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository<Package, Long> {
}
