package com.tenpo.prueba.infrastructure.dao.mapper;

import com.tenpo.prueba.domain.model.History;
import com.tenpo.prueba.infrastructure.dao.entity.HistoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface HistoryMapper {

    HistoryMapper INSTANCE = Mappers.getMapper(HistoryMapper.class);

    @Mapping(target = "id", ignore = true)
    HistoryEntity toEntity(History history);

    History toDomain(HistoryEntity entity);

}
