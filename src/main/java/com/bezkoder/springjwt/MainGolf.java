package com.bezkoder.springjwt;

import com.bezkoder.springjwt.models.ClientRegister;
import com.bezkoder.springjwt.models.ERole;
import com.bezkoder.springjwt.models.Role;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.ClientRepository;
import com.bezkoder.springjwt.repository.RoleRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class MainGolf implements CommandLineRunner{ // implements CommandlineRunner

    private ClientRepository repository;
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    //@Autowired
    public MainGolf(UserRepository userRepository, ClientRepository repository,RoleRepository roleRepository){

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.repository = repository;

    }

     @Override
    public void run(String... args) throws Exception {
       User user = new User("admin","admin@test.com","admin123","admin1","admin1");
        repository.save(new ClientRegister("1","Adam","Svensson","123","spelare"));
        Role role = new Role(ERole.ROLE_USER);
        //roleRepository.delete(ERole.ROLE_ADMIN);
        roleRepository.delete(role);
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(ERole.ROLE_ADMIN));
        user.setRoles(roles);
        //userRepository.save(user);

    }

}
