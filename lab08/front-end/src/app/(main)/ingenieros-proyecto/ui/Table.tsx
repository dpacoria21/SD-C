'use client';

import { getIngenierosProyecto } from '@/utils/proyectos/getIngenierosProyecto';
import TableItem from './TableItem';
import { Ingeniero } from '@/interfaces/interfaces';
import { useEffect, useState } from 'react';

interface Props {
    id: number
}

export default function Table({id}: Props) {

    // const ingenieros:Ingeniero[] = await getIngenierosProyecto(id) || [];
    // const ingenieros:Ingeniero[] = [];
    const [ingenieros, setIngenieros] = useState<Ingeniero[]>([]);

    useEffect(() => {
        getIngenierosProyecto(id).then((res: []) => {
            setIngenieros([...res]);
        }).catch(() => {
            setIngenieros([]);  
        });
    }, [id]);

    return (
        <div className="relative overflow-x-auto">
            {ingenieros.length===0 ? 'No existe el proyecto o No hay Ingenieros en el proyecto' : 
                (
                    
                    <table className="w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
                        <thead className="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                            <tr>
                                <th scope="col" className="px-6 py-3">
                                    ID
                                </th>
                                <th scope="col" className="px-6 py-3">
                                    Especialidad
                                </th>
                                <th scope="col" className="px-6 py-3">
                                    Cargo
                                </th>
                                <th scope="col" className="px-6 py-3">
                                    ProyectoId
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            {ingenieros.map((ingeniero) => <TableItem key={ingeniero.id} {...ingeniero} />)}                    
                        </tbody>
                    </table>
                )
            }
        </div>
    );
}
