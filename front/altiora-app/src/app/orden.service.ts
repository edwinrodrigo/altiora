import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Articulo } from './interfaces/articulo';
import { Cliente } from './interfaces/cliente';
import { Orden } from './interfaces/orden';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrdenService {

  endpoint: string = "http://127.0.0.1:8080/altiora-api";

  pathArticulo: string = this.endpoint + "/articulo";
  pathCliente: string = this.endpoint + "/cliente";
  pathOrden: string = this.endpoint + "/orden";

  constructor(private httpClient: HttpClient) {

  }


  async saveOrden(orden? : Orden) {

    let requestPath = this.pathOrden;
    let requestBody = orden;
    let requestHeader = {};
    let requestParams = {};
    try {
      return await this.post(requestBody, requestParams, requestHeader, requestPath);
    } catch (error) {
      throw error;
    }
    
  }

  async saveCliente(cliente? : Cliente) {

    let requestPath = this.pathCliente;
    let requestBody = cliente;
    let requestHeader = {};
    let requestParams = {};
    try {
      return await this.post(requestBody, requestParams, requestHeader, requestPath);
    } catch (error) {
      throw error;
    }
    
  }

  async saveArticulo(articulo? : Articulo) {

    let requestPath = this.pathArticulo;
    let requestBody = articulo;
    let requestHeader = {};
    let requestParams = {};
    try {
      return await this.post(requestBody, requestParams, requestHeader, requestPath);
    } catch (error) {
      throw error;
    }
    
  }

  getClientes() : Observable<Cliente[]> {

    let requestPath = this.pathCliente;
    try {
      return this.httpClient.get<Cliente[]>(requestPath);
    } catch (error) {
      throw error;
    }
    
  }

  getArticulos() : Observable<Articulo[]> {

    let requestPath = this.pathArticulo;
    try {
      return this.httpClient.get<Articulo[]>(requestPath);
    } catch (error) {
      throw error;
    }
    
  }
  
  async post(requestBody: any, requestParams: any, requestHeader: any = {}, requestPath:string){

    let data: any;
    let path = requestPath;

    try {
      let result = await this.httpClient.post(path, requestBody, { headers: requestHeader, params: requestParams }).subscribe( item => data = item);
      data = result;
    } catch (error) {
      throw error;
    }

    return data;
  }

}
