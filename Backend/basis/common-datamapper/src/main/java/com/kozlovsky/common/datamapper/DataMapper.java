package com.kozlovsky.common.datamapper;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.InputStream;
import java.util.Map;

/**
 * Created by anton on 13.06.17.
 */
public interface DataMapper {

    Map<String, Object> convertToMap(Object value) throws MapperException;

    <T> T convert(Map<String, Object> map, Class<T> dataType) throws MapperException;

    <T> T convert(Map<String, Object> map, TypeReference<?> dataType) throws MapperException;

    <T> T mapData(String data, Class<T> dataType) throws MapperException;

    <T> T mapData(String data, TypeReference<?> dataType) throws MapperException;

    <T> T mapData(byte[] message, Class<T> dataType) throws MapperException;

    <T> T readValue(InputStream src, Class<T> valueType) throws MapperException;

    <T> String dataToString(T data) throws MapperException;

    String objectToString(Object data) throws MapperException;

}
