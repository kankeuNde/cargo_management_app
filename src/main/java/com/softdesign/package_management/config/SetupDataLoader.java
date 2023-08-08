package com.softdesign.package_management.config;

import com.softdesign.package_management.entities.*;
import com.softdesign.package_management.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    boolean alreadySetup = false;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PrivilegeRepository privilegeRepository;

    private AirPackageRepository air_packageRepository;
    private PackageRepository packageRepository;
    private PackageItemsRepository packageItemsRepository;

    @Autowired
    public SetupDataLoader(UserRepository userRepository, RoleRepository roleRepository, PrivilegeRepository privilegeRepository, AirPackageRepository air_packageRepository, PackageRepository packageRepository, PackageItemsRepository packageItemsRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.privilegeRepository = privilegeRepository;
        this.air_packageRepository = air_packageRepository;
        this.packageRepository = packageRepository;
        this.packageItemsRepository = packageItemsRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(alreadySetup)
            return;
        Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

        List<Privilege> adminPrivileges = new ArrayList<>();
        adminPrivileges.add(readPrivilege);
        adminPrivileges.add(writePrivilege);

        List<Privilege> userPrivileges = new ArrayList<>();
        userPrivileges.add(readPrivilege);

        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", userPrivileges);

        Role adminRole = roleRepository.findByName("ROLE_ADMIN");

        User user = new User();
        user.setFirstname("Test");
        user.setLastname("Test");
        user.setPassword("Test");
        user.setEmail("test@test.com");
        //user.setRoles(Arrays.asList(adminRole));
        user.setEnabled(true);
        userRepository.save(user);

        AirPackage pck = new AirPackage();
        pck.setItemName("Item Name");
        pck.setDescription("Description");
        pck.setWeight(10);
        pck.setUnitPriceKgs(BigDecimal.valueOf(2000));

        //Package_items pck_items = new Package_items();
        //packageItemsRepository.save(pck_items);

        air_packageRepository.save(pck);


        alreadySetup = true;
    }

    @Transactional
    private Role createRoleIfNotFound(String name, List<Privilege> privileges) {
        Role role = roleRepository.findByName(name);
        if(role == null){
            role = new Role(name);
            //role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }

    @Transactional
    private Privilege createPrivilegeIfNotFound(String name) {
        Privilege privilege = privilegeRepository.findByName(name);
        if(privilege == null){
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }
}
