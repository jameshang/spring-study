package com.jh.study.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonUtil {

    private static final ObjectMapper mapper=new ObjectMapper();

    public static String toJson(Object obj){
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("To Json failed!", e);
            return "{}";
        }
    }

    public static <T> T toObject(String json, Class<T> type){
        T obj=mapper.convertValue(json, type);
        return obj;
    }

}
