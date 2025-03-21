package com.tenpo.prueba.infrastructure.repository;

import com.tenpo.prueba.domain.model.History;
import com.tenpo.prueba.domain.repository.HistoryRepository;
import com.tenpo.prueba.infrastructure.dao.entity.HistoryEntity;
import com.tenpo.prueba.infrastructure.dao.mapper.HistoryMapper;
import com.tenpo.prueba.infrastructure.dao.repository.HistoryRepositoryJpa;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Repository
@RequiredArgsConstructor
public class HistoryRepositoryImpl implements HistoryRepository {

    private final HistoryRepositoryJpa historyRepositoryJpa;


    @Override
    public void save(History history) {
       historyRepositoryJpa.save(HistoryMapper.INSTANCE.toEntity(history));
    }

    @Override
    public List<History> getAll() {
        return historyRepositoryJpa.findAll()
                .stream()
                .map(HistoryMapper.INSTANCE::toDomain)
                .collect(Collectors.toList());
    }
}
