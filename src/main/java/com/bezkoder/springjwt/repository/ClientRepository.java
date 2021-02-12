package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.ClientRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientRegister, String> {

    Optional<ClientRegister> findByFirstName( String name);
}
