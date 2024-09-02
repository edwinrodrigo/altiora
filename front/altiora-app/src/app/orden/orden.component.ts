import { CommonModule } from '@angular/common';
import { Component, OnInit} from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, Validators} from '@angular/forms';
import { OrdenService } from '../orden.service';
import { Orden } from '../interfaces/orden';
import { Cliente } from '../interfaces/cliente';
import { Articulo } from '../interfaces/articulo';
import { OrdenDetalle } from '../interfaces/ordenDetalle';
import { RouterModule } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-orden',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './orden.component.html',
  styleUrl: './orden.component.css'
})
export class OrdenComponent implements OnInit {
  endpoint: string = "http://127.0.0.1:8080/altiora-api";
  clientes : Cliente[] = [];
  articulos : Articulo[] = [];
  ordenDetalles : OrdenDetalle[] = [];
  ordenDetalle : OrdenDetalle = {idArticulo:-1};
  orden : Orden = {cliente:{idCliente :-1}};
  fecha : Date = new Date();
  exito: boolean = false;
  mensajeError : string = "";
  pathOrden: string = this.endpoint + "/orden";

  constructor(private ordenService: OrdenService, private httpClient: HttpClient) {}

  async ngOnInit() {

    await this.getClientes();
    await this.getArticulos();
  }

  getClientes() {
      this.ordenService.getClientes().subscribe((data) => {
        this.clientes = data;
      },
      (error) => {
        console.error('Error al obtener la data:', error);
      }
    );
  }


  getArticulos() {
    console.log("listar articulos")
      this.ordenService.getArticulos().subscribe((data) => {
        this.articulos = data;
      },
      (error) => {
        console.error('Error al obtener la data:', error);
      }
    );
  }

  agregarArticulo(){

    if(this.orden.cliente && this.orden.cliente.idCliente == -1){
      this.mensajeError = "Seleccione un cliente";
      return;
    }

    if(this.ordenDetalle.idArticulo && this.ordenDetalle.idArticulo == -1){
      this.mensajeError = "Seleccione un articulo";
      return;
    }

    if(!this.ordenDetalle.cantidad){
      this.mensajeError = "Ingrese una cantidad";
      return;
    }
    this.mensajeError = "";

    let art = this.articulos.find(articulo => articulo.idArticulo == this.ordenDetalle.idArticulo);
    console.log(art);
    console.log(this.ordenDetalle);

    let totalArticulo = (art?.precioUnitario == null ? 0 : art?.precioUnitario) * (this.ordenDetalle.cantidad == null ? 0 : this.ordenDetalle.cantidad);

    let ordenDetalleSave : OrdenDetalle = {
      idArticulo: this.ordenDetalle.idArticulo,
      cantidad: this.ordenDetalle.cantidad,
      total: totalArticulo,
      nombreArticulo: art?.nombre,
      costoUnitario: art?.precioUnitario,
    }

    this.ordenDetalles.push(ordenDetalleSave);

    let totalOrden = 0;
    this.ordenDetalles.forEach((item) => totalOrden += (item.total == null ? 0 : item.total));
    this.orden.total = totalOrden;

    this.resetForm();
  }

  resetForm(){
    this.ordenDetalle = {idArticulo: -1};
  }

  offAlert(){

    this.exito = false;
  }

  async onSubmit(){
    this.orden.ordenDetalle = this.ordenDetalles;  
    console.log(this.orden);
    try{


      let data: any;
      let error:any;
  
      let requestPath = this.pathOrden;
      let requestBody = this.orden;
      let requestHeader = {};
      let requestParams = {};

       //let response = this.ordenService.saveOrden(this.orden);
      let result = await this.httpClient.post(requestPath, requestBody, { headers: requestHeader, params: requestParams }).subscribe( 
        result => data = result,
        error => {
          this.mensajeError = error.error.message,
          this.exito = false;
          return;
        }
      );
      console.log(result);
      //alert('Orden registrada con éxito');
      this.exito = true;
      console.log('Orden registrada:', this.orden);
    } catch (e){
      console.log(e);
    }
      
    
    
    
  }

}
