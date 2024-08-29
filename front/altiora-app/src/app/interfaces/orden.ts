import { OrdenDetalle } from './ordenDetalle';
import { Cliente } from './cliente';
export interface Orden {
    idOrden?: string,
    fecha?: Date,
    total?: number,
    cliente: Cliente,
    ordenDetalle?: OrdenDetalle[]
}
