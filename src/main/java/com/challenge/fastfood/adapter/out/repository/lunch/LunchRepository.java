package com.challenge.fastfood.adapter.out.repository.lunch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LunchRepository extends JpaRepository<LunchEntity, Long> {
}
