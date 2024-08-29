package com.altiora.ec.service;

import org.springframework.stereotype.Service;

import com.altiora.ec.common.GenericCRUDImpl;
import com.altiora.ec.common.GenericRepository;
import com.altiora.ec.entity.Articulo;
import com.altiora.ec.repository.IArticuloRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticuloServiceImpl extends GenericCRUDImpl<Articulo, Long> implements IArticuloService {

	private final IArticuloRepository articuloRepository;

	@Override
	protected GenericRepository<Articulo, Long> getRepository() {
		return articuloRepository;
	}

}