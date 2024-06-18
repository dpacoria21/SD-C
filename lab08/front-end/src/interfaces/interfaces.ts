export interface Ingeniero {
    id:           number;
    especialidad: string;
    cargo:        string;
    proyectoId:   number;
}

export interface Departamento {
    id:       number;
    nombre:   string;
    telefono: string;
    fax:      string;
}

export interface Proyecto {
    id:             number;
    nombre:         string;
    fecInicio:      Date;
    fecTermino:     Date;
    departamentoId: number;
}
