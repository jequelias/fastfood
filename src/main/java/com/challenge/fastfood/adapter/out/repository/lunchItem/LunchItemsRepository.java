package com.challenge.fastfood.adapter.out.repository.lunchItem;

import com.challenge.fastfood.domain.entities.LunchItemType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LunchItemsRepository extends JpaRepository<LunchItemEntity, Long> {

    List<LunchItemEntity> findByTypeAndStatusTrue(LunchItemType lunchItemType);
    LunchItemEntity findByName(String name);
    LunchItemEntity findByIdAndStatusTrue(Long id);
}
