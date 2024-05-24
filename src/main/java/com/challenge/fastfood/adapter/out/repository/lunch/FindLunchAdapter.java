package com.challenge.fastfood.adapter.out.repository.lunch;

import com.challenge.fastfood.adapter.out.mapstruct.LunchMapper;
import com.challenge.fastfood.domain.entities.Lunch;
import com.challenge.fastfood.domain.ports.out.lunch.FindLunchAdapterPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindLunchAdapter implements FindLunchAdapterPort {

    private final LunchRepository lunchRepository;
    private final LunchMapper lunchMapper;


    @Override
    public List<Lunch> findLunchs() {
        List<LunchEntity> lunchRepositoryAll = lunchRepository.findAll();
        return lunchMapper.lunchsEntityToLunchs(lunchRepositoryAll);
    }

    @Override
    public Lunch findLunchById(Long id) {
        LunchEntity lunchRepositoryAll = lunchRepository.findById(id).orElse(null);
        return lunchMapper.lunchEntityToLunch(lunchRepositoryAll);
    }
}
