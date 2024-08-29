package com.altiora.ec.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.altiora.ec.dto.request.OrdenRequest;
import com.altiora.ec.dto.response.OrdenResponse;
import com.altiora.ec.exception.CustomErrorResponse;
import com.altiora.ec.util.SwaggerConstants;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = SwaggerConstants.ORDEN_TAG, description = SwaggerConstants.ORDEN_DESCRIPTION)
@RequestMapping("/orden")
public interface IOrdenController {
	
	@PostMapping
    @Operation(summary = "Create un nuevo Orden")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Orden creado"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<OrdenResponse> create(@Valid @RequestBody OrdenRequest OrdenRequest) throws CustomErrorResponse;
	
    @Operation(summary = "Obtiene todos los Ordens")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Orden encontrado"),
            @ApiResponse(responseCode = "204", description = "No Orden found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    ResponseEntity<List<OrdenResponse>> getAllOrdenes() throws CustomErrorResponse;

    @Operation(summary = "Obtiene Orden Por ID")
    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Orden encontrado"),
            @ApiResponse(responseCode = "404", description = "Orden not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<OrdenResponse> obtieneOrdenPorId(String id) throws CustomErrorResponse;

    @Operation(summary = "Actualiza Orden Por Id")
    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Orden encontrado"),
            @ApiResponse(responseCode = "404", description = "Orden not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<OrdenResponse> actualizaOrdenPorId(@RequestBody OrdenRequest OrdenRequest) throws CustomErrorResponse;

    @Operation(summary = "Elimina Orden Por Id")
    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Orden eliminado"),
            @ApiResponse(responseCode = "404", description = "Orden not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<Void> eliminaOrdenPorId(String id) throws CustomErrorResponse;

}