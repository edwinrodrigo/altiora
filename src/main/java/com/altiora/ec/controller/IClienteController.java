package com.altiora.ec.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.altiora.ec.dto.request.ClienteRequest;
import com.altiora.ec.dto.response.ClienteResponse;
import com.altiora.ec.exception.CustomErrorResponse;
import com.altiora.ec.util.SwaggerConstants;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = SwaggerConstants.CLIENTE_TAG, description = SwaggerConstants.CLIENTE_DESCRIPTION)
@RequestMapping("/cliente")
public interface IClienteController {

	@PostMapping
	@Operation(summary = "Create un nuevo cliente")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Cliente creado"),
			@ApiResponse(responseCode = "400", description = "Bad request"),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	ResponseEntity<ClienteResponse> crear(@Valid @RequestBody ClienteRequest clienteRequest)
			throws CustomErrorResponse;

	@Operation(summary = "Obtiene todos los Clientes")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Cliente encontrado"),
			@ApiResponse(responseCode = "204", description = "No Cliente found"),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	@GetMapping
	ResponseEntity<List<ClienteResponse>> getAllClientes() throws CustomErrorResponse;

	@Operation(summary = "Obtiene Cliente Por ID")
	@GetMapping("/{id}")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Cliente encontrado"),
			@ApiResponse(responseCode = "404", description = "Cliente not found"),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	ResponseEntity<ClienteResponse> obtieneClientePorId(Long id) throws CustomErrorResponse;

	@Operation(summary = "Actualiza Cliente Por Id")
	@PutMapping("/{id}")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Cliente encontrado"),
			@ApiResponse(responseCode = "404", description = "Cliente not found"),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	ResponseEntity<ClienteResponse> actualizaClientePorId(@RequestBody ClienteRequest clienteRequest)
			throws CustomErrorResponse;

	@Operation(summary = "Elimina Cliente Por Id")
	@DeleteMapping("/{id}")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Cliente eliminado"),
			@ApiResponse(responseCode = "404", description = "Cliente not found"),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	ResponseEntity<Void> eliminaClientePorId(Long id) throws CustomErrorResponse;

}