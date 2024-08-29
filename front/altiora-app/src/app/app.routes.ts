import { Routes } from '@angular/router';
import { OrdenComponent } from './orden/orden.component';
import { ArticuloComponent } from './articulo/articulo.component';
import { ClienteComponent } from './cliente/cliente.component';

export const routes: Routes = [
    {path:'orden', component: OrdenComponent},
    {path:'articulo', component: ArticuloComponent},
    {path:'cliente', component: ClienteComponent}
];
