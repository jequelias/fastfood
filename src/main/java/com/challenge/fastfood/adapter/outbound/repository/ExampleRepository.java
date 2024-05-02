package com.challenge.fastfood.adapter.outbound.repository;

import com.challenge.fastfood.domain.actor.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleRepository  extends JpaRepository<ExampleEntity, Long> {
    ExampleEntity findByName(String name);
}
