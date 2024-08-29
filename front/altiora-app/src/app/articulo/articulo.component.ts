import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { OrdenService } from '../orden.service';
import { Articulo } from '../interfaces/articulo';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-articulo',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterModule],
  templateUrl: './articulo.component.html',
  styleUrl: './articulo.component.css'
})
export class ArticuloComponent implements OnInit{

  articleForm!: FormGroup;
  submitted = false;

  constructor(private formBuilder: FormBuilder,
              private ordenService: OrdenService
  ) { }

  ngOnInit(): void {
    this.articleForm = this.formBuilder.group({
      nombre: ['', Validators.required],
      precioUnitario: [0, [Validators.required, Validators.min(0.01)]],
      stock: [0, [Validators.required, Validators.min(0)]]
    });
  }

  get f() { 
    return this.articleForm.controls; 
  }

  onSubmit(): void {
    this.submitted = true;

    if (this.articleForm.invalid) {
      return;
    }

    const articulo : Articulo = {
      nombre: this.articleForm.value.nombre,
      precioUnitario: this.articleForm.value.precioUnitario,
      stock: this.articleForm.value.stock
    };

    console.log(this.ordenService.saveArticulo(articulo));

    console.log('Artículo registrado:', articulo);
    alert('Artículo registrado con éxito');
  }

}
