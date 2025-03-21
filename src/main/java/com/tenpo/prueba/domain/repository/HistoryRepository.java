package com.tenpo.prueba.domain.repository;

import com.tenpo.prueba.domain.model.History;

import java.util.List;

public interface HistoryRepository {
    void save (History history);
    List<History> getAll();
}
