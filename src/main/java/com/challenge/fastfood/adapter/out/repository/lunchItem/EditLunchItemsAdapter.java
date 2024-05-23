package com.challenge.fastfood.adapter.out.repository.lunchItem;

import com.challenge.fastfood.adapter.out.mapstruct.LunchItemMapper;
import com.challenge.fastfood.config.exception.LunchItemException;
import com.challenge.fastfood.domain.entities.LunchItem;
import com.challenge.fastfood.domain.ports.out.lunchItem.EditLunchItemAdapterPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EditLunchItemsAdapter implements EditLunchItemAdapterPort {

    private final LunchItemsRepository lunchItemsRepository;
    private final LunchItemMapper lunchItemMapper;


    @Override
    @Transactional
    public Boolean editStatusLunchItem(Long idLunchItem, Boolean status) {
        try {
            LunchItemEntity lunchItemsRepositoryById = lunchItemsRepository
                    .findById(idLunchItem)
                    .orElseThrow(() -> new LunchItemException("Lunch item not found." ));
            lunchItemsRepositoryById.setStatus(status);
            lunchItemsRepository.save(lunchItemsRepositoryById);
            return true;

    }   catch (Exception e) {
            throw new LunchItemException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public LunchItem editLunchItem(LunchItem lunchItem, Long idLunchItem) {
        LunchItem toLunchItem ;
        try {

            LunchItemEntity lunchItemEntity = lunchItemsRepository.findById(idLunchItem).orElseThrow(() -> new LunchItemException("Lunch item not found." ));
            lunchItemEntity.setStatus(true);
            lunchItemEntity.setType(lunchItem.getType());
            lunchItemEntity.setPrice(lunchItem.getPrice());
            LunchItemEntity lunchItemSave = lunchItemsRepository.save(lunchItemEntity);
            toLunchItem = lunchItemMapper.lunchItemEntityToLunchItem(lunchItemSave);

        } catch (Exception e) {
            throw new LunchItemException(e.getMessage());
        }
        return toLunchItem;
    }
}
