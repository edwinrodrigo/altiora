import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { RouterModule, RouterOutlet } from '@angular/router';
import { OrdenService } from '../orden.service';
import { Articulo } from '../interfaces/articulo';
import { Cliente } from '../interfaces/cliente';

@Component({
  selector: 'app-cliente',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterOutlet, RouterModule],
  templateUrl: './cliente.component.html',
  styleUrl: './cliente.component.css'
})
export class ClienteComponent implements OnInit{

  customerForm!: FormGroup;
  submitted = false;

  constructor(private formBuilder: FormBuilder,
              private ordenService: OrdenService
  ) { }

  ngOnInit(): void {
    this.customerForm = this.formBuilder.group({
      nombre: ['', Validators.required],
      apellido: ['', Validators.required]
    });
  }

  get f() { return this.customerForm.controls; }

  onSubmit(): void {
    this.submitted = true;

    if (this.customerForm.invalid) {
      return;
    }

    const cliente : Cliente = {
      nombre: this.customerForm.value.nombre,
      apellido: this.customerForm.value.apellido
    };

    console.log(this.ordenService.saveCliente(cliente));

    console.log('Cliente registrado:', cliente);
    alert('Cliente registrado con éxito');
  }

}
