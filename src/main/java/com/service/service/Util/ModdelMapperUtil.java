package com.service.service.Util;

import java.util.Map;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ModdelMapperUtil {

    public static ModdelMapperUtil INSTANCE = new ModdelMapperUtil();

    public static ModdelMapperUtil getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        } else {
            return new ModdelMapperUtil();
        }
    }

    public <S, D> D convert(S source, Class<D> destinationClass) {
        return getModelMapper().map(source, destinationClass);
    }

    public void convertObj(Object source, Object destinationSource) {
        getModelMapper().map(source, destinationSource);
    }

    public Object mapToJson(Map map) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(map);
    }

    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setPropertyCondition(Conditions.isNotNull())
                .setCollectionsMergeEnabled(true)
                .setSkipNullEnabled(true)
                .setFieldMatchingEnabled(true);
        return modelMapper;
    }
}
