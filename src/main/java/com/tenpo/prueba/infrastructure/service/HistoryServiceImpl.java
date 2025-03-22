package com.tenpo.prueba.infrastructure.service;

import com.tenpo.prueba.domain.model.History;
import com.tenpo.prueba.domain.repository.HistoryRepository;
import com.tenpo.prueba.domain.service.HistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRepository historyRepository;

    @Async
    @Override
    public void save(History history) {
        log.info("[HistoryServiceImpl] - save: Guardando historial async: {} ", history);
        historyRepository.save(history);
    }

    @Override
    public List<History> getAll() {
        return historyRepository.getAll();
    }
}
