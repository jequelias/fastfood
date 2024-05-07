package com.challenge.fastfood.adapter.out.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    ClientEntity findByNameOrCpfOrEmail(String name, String cpf, String email);
}
