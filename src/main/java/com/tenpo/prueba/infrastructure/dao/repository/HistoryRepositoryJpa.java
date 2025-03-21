package com.tenpo.prueba.infrastructure.dao.repository;

import com.tenpo.prueba.infrastructure.dao.entity.HistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepositoryJpa extends JpaRepository<HistoryEntity, Long> {
}
