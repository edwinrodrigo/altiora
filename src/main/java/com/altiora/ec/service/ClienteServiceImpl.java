package com.altiora.ec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altiora.ec.common.GenericCRUDImpl;
import com.altiora.ec.common.GenericRepository;
import com.altiora.ec.entity.Cliente;
import com.altiora.ec.repository.IClienteRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClienteServiceImpl extends GenericCRUDImpl<Cliente, Long> implements IClienteService{

    private final IClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    protected GenericRepository<Cliente, Long> getRepository() {
        return clienteRepository;
    }
	
}
