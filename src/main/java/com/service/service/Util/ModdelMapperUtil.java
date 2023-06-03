package com.service.service.Util;

import java.util.Map;

import org.modelmapper.ModelMapper;

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
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(source, destinationClass);
    }

    public Object mapToJson(Map map) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(map);
    }
}
