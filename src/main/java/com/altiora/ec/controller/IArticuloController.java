package com.altiora.ec.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.altiora.ec.dto.request.ArticuloRequest;
import com.altiora.ec.dto.response.ArticuloResponse;
import com.altiora.ec.exception.CustomErrorResponse;
import com.altiora.ec.util.SwaggerConstants;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = SwaggerConstants.ARTICULO_TAG, description = SwaggerConstants.ARTICULO_DESCRIPTION)
@RequestMapping("/articulo")
public interface IArticuloController {

	
    @PostMapping
    @Operation(summary = "Create un nuevo articulo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Articulo creado"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<ArticuloResponse> create(@Valid @RequestBody ArticuloRequest articuloRequest) throws CustomErrorResponse;
	
    @Operation(summary = "Obtiene todos los articulos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Articulo encontrado"),
            @ApiResponse(responseCode = "204", description = "No Articulo found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    ResponseEntity<List<ArticuloResponse>> getAllArticulos() throws CustomErrorResponse;

    @Operation(summary = "Obtiene Articulo Por ID")
    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Articulo encontrado"),
            @ApiResponse(responseCode = "404", description = "Articulo not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<ArticuloResponse> obtieneArticuloPorId(Long id) throws CustomErrorResponse;

    @Operation(summary = "Actualiza Articulo Por Id")
    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Articulo encontrado"),
            @ApiResponse(responseCode = "404", description = "Articulo not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<ArticuloResponse> actualizaArticuloPorId(@RequestBody ArticuloRequest articuloRequest) throws CustomErrorResponse;

    @Operation(summary = "Elimina Articulo Por Id")
    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Articulo eliminado"),
            @ApiResponse(responseCode = "404", description = "Articulo not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<Void> eliminaArticuloPorId(Long id) throws CustomErrorResponse;
    
}