package com.altiora.ec.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.altiora.ec.dto.request.OrdenDetalleRequest;
import com.altiora.ec.dto.response.OrdenDetalleResponse;
import com.altiora.ec.exception.CustomErrorResponse;
import com.altiora.ec.util.SwaggerConstants;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = SwaggerConstants.ORDEN_DETALLE_TAG, description = SwaggerConstants.ORDEN_DETALLE_DESCRIPTION)
@RequestMapping("/ordendetalle")
public interface IOrdenDetalleController {

    @PostMapping
    @Operation(summary = "Create un nuevo OrdenDetalle")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Detalle de Orden creado"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<OrdenDetalleResponse> create(@Valid @RequestBody OrdenDetalleRequest OrdenDetalleRequest) throws CustomErrorResponse;
	
    @Operation(summary = "Obtiene todos los OrdenDetalles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Detalle de Orden Encontrado encontrado"),
            @ApiResponse(responseCode = "204", description = "No OrdenDetalle found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    ResponseEntity<List<OrdenDetalleResponse>> getAllOrdenDetalles() throws CustomErrorResponse;

    @Operation(summary = "Obtiene OrdenDetalle Por ID")
    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OrdenDetalle encontrado"),
            @ApiResponse(responseCode = "404", description = "OrdenDetalle not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<OrdenDetalleResponse> obtieneOrdenDetallePorId(Long id) throws CustomErrorResponse;

    @Operation(summary = "Actualiza OrdenDetalle Por Id")
    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OrdenDetalle encontrado"),
            @ApiResponse(responseCode = "404", description = "OrdenDetalle not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<OrdenDetalleResponse> actualizaOrdenDetallePorId(@RequestBody OrdenDetalleRequest OrdenDetalleRequest) throws CustomErrorResponse;

    @Operation(summary = "Elimina OrdenDetalle Por Id")
    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OrdenDetalle eliminado"),
            @ApiResponse(responseCode = "404", description = "OrdenDetalle not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<Void> eliminaOrdenDetallePorId(Long id) throws CustomErrorResponse;
	
}