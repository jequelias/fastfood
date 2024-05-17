package com.challenge.fastfood.adapter.out.repository;

import com.challenge.fastfood.adapter.out.mapstruct.LunchItemMapper;
import com.challenge.fastfood.domain.entities.LunchItem;
import com.challenge.fastfood.domain.entities.LunchItemType;
import com.challenge.fastfood.domain.ports.out.DeleteLunchItemAdapterPort;
import com.challenge.fastfood.domain.ports.out.FindLunchItemsAdapterPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DeleteLunchItemsAdapter implements DeleteLunchItemAdapterPort {

    private final LunchItemsRepository lunchItemsRepository;


    @Override
    public Boolean deleteLunchItem(Long idLunchItem) {
        var status = false;
        try {
            if(idLunchItem != null && lunchItemsRepository.existsById(idLunchItem)){
                LunchItemEntity lunchItemsRepositoryById = lunchItemsRepository.findById(idLunchItem)
                        .orElse(null);
                lunchItemsRepositoryById.setStatus(false);
                LunchItemEntity itemEntity = lunchItemsRepository.save(lunchItemsRepositoryById);
                status = itemEntity.getStatus();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return status;
    }
}
