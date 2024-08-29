package com.altiora.ec.service;

import com.altiora.ec.common.GenericCRUD;
import com.altiora.ec.entity.Orden;

public interface IOrdenService extends GenericCRUD<Orden, String> {
	
	void guardarOrdenYDetalles(Orden orden);

}
