package com.altiora.ec.repository;

import org.springframework.stereotype.Repository;

import com.altiora.ec.common.GenericRepository;
import com.altiora.ec.entity.Cliente;

@Repository
public interface IClienteRepository extends GenericRepository<Cliente, Long>{

}