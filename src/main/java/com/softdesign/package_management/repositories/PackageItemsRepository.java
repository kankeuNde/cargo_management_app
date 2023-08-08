package com.softdesign.package_management.repositories;

import com.softdesign.package_management.entities.PackageItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageItemsRepository extends JpaRepository<PackageItems, Long> {
}
