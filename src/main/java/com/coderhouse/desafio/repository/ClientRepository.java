package com.coderhouse.desafio.repository;

import com.coderhouse.desafio.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
