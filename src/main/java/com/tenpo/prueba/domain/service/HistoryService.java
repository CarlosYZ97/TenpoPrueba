package com.tenpo.prueba.domain.service;

import com.tenpo.prueba.domain.model.History;

import java.util.List;

public interface HistoryService {

    void save (History history);
    List<History> getAll();

}
