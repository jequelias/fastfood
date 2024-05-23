package com.challenge.fastfood.adapter.out.repository.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    ClientEntity findByNameOrCpfOrEmail(String name, String cpf, String email);
    List<ClientEntity> findAllByNameOrCpfOrEmail(String name, String cpf, String email);

    Optional<Object> findByCpf(String cpf);
}
