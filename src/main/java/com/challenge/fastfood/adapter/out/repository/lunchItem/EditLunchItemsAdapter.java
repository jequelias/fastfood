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
    public Boolean editStatusLunchItem(Long idLunchItem) {
        var status = false;
        try {
            if(idLunchItem != null && lunchItemsRepository.existsById(idLunchItem)){
                LunchItemEntity lunchItemsRepositoryById = lunchItemsRepository.findById(idLunchItem)
                        .orElse(null);
                lunchItemsRepositoryById.setStatus(false);
                LunchItemEntity itemEntity = lunchItemsRepository.save(lunchItemsRepositoryById);
                status = !itemEntity.getStatus();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return status;
    }

    @Override
    @Transactional
    public LunchItem editLunchItem(Long idLunchItem, LunchItem lunchItem) {
        LunchItem toLunchItem ;
        try {
            if(idLunchItem != null && lunchItemsRepository.existsById(idLunchItem)){

                LunchItemEntity lunchItemsRepositoryById = lunchItemsRepository.findById(idLunchItem)
                        .orElseThrow(() -> new LunchItemException("Lunch item not found." ));

                lunchItemsRepositoryById.setName(lunchItem.getName());
                lunchItemsRepositoryById.setPrice(lunchItem.getPrice());
                LunchItemEntity lunchItemEntity = lunchItemsRepository.save(lunchItemsRepositoryById);
                 toLunchItem = lunchItemMapper.lunchItemEntityToLunchItem(lunchItemEntity);

            } else{
                throw new LunchItemException("Lunch Item not found");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
        return toLunchItem;
    }
}
