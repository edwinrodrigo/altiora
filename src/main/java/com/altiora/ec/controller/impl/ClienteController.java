package com.altiora.ec.controller.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.altiora.ec.controller.IClienteController;
import com.altiora.ec.dto.request.ClienteRequest;
import com.altiora.ec.dto.response.ClienteResponse;
import com.altiora.ec.entity.Cliente;
import com.altiora.ec.exception.CustomErrorResponse;
import com.altiora.ec.service.IClienteService;
import com.altiora.ec.util.GenericMapperConverterUtils;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ClienteController implements IClienteController{
	
	private final GenericMapperConverterUtils genericConverterUtils;
	private final IClienteService ClienteService;

	@Override
	public ResponseEntity<ClienteResponse> crear(@Valid ClienteRequest clienteRequest) throws CustomErrorResponse {
		Cliente Cliente = this.genericConverterUtils.convertToEntity(clienteRequest, Cliente.class);
		Cliente = ClienteService.save(Cliente);
		ClienteResponse response = this.genericConverterUtils.convertToDto(Cliente, ClienteResponse.class); 
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@Override
	public ResponseEntity<List<ClienteResponse>> getAllClientes() throws CustomErrorResponse {
		List<Cliente> Clientes = this.ClienteService.findAll();
		return ResponseEntity.ok().body(this.genericConverterUtils.convertListToListDto(Clientes, ClienteResponse.class));
	}

	@Override
	public ResponseEntity<ClienteResponse> obtieneClientePorId(Long id) throws CustomErrorResponse {
		return ResponseEntity.ok().body(this.genericConverterUtils.convertToDto(this.ClienteService.findById(id), ClienteResponse.class));
	}

	@Override
	public ResponseEntity<ClienteResponse> actualizaClientePorId(ClienteRequest clienteRequest)
			throws CustomErrorResponse {
		Cliente Cliente = this.genericConverterUtils.convertToEntity(clienteRequest, Cliente.class);
		Cliente = ClienteService.update(Cliente.getIdCliente(), Cliente);
		ClienteResponse response = this.genericConverterUtils.convertToDto(Cliente, ClienteResponse.class); 
		return ResponseEntity.ok().body(response);
	}

	@Override
	public ResponseEntity<Void> eliminaClientePorId(Long id) throws CustomErrorResponse {
		this.ClienteService.delete(id);
		return ResponseEntity.ok().body(null);
	}

}
