package com.altiora.ec.common;

import java.util.List;

import com.altiora.ec.exception.CustomErrorResponse;

public interface GenericCRUD<T, ID> {

    T save(T t) throws CustomErrorResponse;
    T update(ID id, T t) throws CustomErrorResponse;
    List<T> findAll() throws CustomErrorResponse;
    T findById(ID id) throws CustomErrorResponse;
    void delete(ID id) throws CustomErrorResponse;
}
