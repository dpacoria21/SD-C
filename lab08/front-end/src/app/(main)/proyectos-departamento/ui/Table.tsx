'use client';

import { getIngenierosProyecto } from '@/utils/proyectos/getIngenierosProyecto';
import TableItem from './TableItem';
import { Ingeniero, Proyecto } from '@/interfaces/interfaces';
import { useEffect, useState } from 'react';
import { getProyectosDepartamento } from '@/utils/departamentos/getProyectosDepartamento';

interface Props {
    id: number
}

export default function Table({id}: Props) {

    // const ingenieros:Ingeniero[] = await getIngenierosProyecto(id) || [];
    // const ingenieros:Ingeniero[] = [];
    const [proyectos, setProyectos] = useState<Proyecto[]>([]);

    useEffect(() => {
        getProyectosDepartamento(id).then((res: []) => {
            setProyectos([...res]);
        }).catch(() => {
            setProyectos([]);  
        });
    }, [id]);

    return (
        <div className="relative overflow-x-auto">
            {proyectos.length===0 ? 'No existen proyectos o el departamento no existe' : 
                (
                    
                    <table className="w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
                        <thead className="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                            <tr>
                                <th scope="col" className="px-6 py-3">
                            ID
                                </th>
                                <th scope="col" className="px-6 py-3">
                            Nombre
                                </th>
                                <th scope="col" className="px-6 py-3">
                            Fecha Inicio
                                </th>
                                <th scope="col" className="px-6 py-3">
                            Fecha Final
                                </th>

                                <th scope="col" className="px-6 py-3">
                            Departamento ID
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            {proyectos.map((proyecto) => <TableItem key={proyecto.id} {...proyecto} />)}                    
                        </tbody>
                    </table>
                )
            }
        </div>
    );
}
