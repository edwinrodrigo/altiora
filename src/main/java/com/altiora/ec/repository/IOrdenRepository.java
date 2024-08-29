package com.altiora.ec.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.altiora.ec.common.GenericRepository;
import com.altiora.ec.entity.Orden;

@Repository
public interface IOrdenRepository extends GenericRepository<Orden, String> {
	
	@Query(value = "select max(id) id from (select cast(split_part(id_orden, '-',2) as INTEGER) id  from orden)", nativeQuery = true)
	public Integer getMaxValueId();

}