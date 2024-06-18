'use client';

import { deleteIngeniero } from '@/actions/ingenieros/deleteIngeniero';
import { deleteProyecto } from '@/actions/proyectos/deleteProyecto';
import { Proyecto } from '@/interfaces/interfaces';
import { useRouter } from 'next/navigation';

export default function TableItem({id, nombre, fecInicio, fecTermino, departamentoId}: Proyecto) {

    const router = useRouter();
    
    return (
        <tr className="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
            <td scope="row" className="px-6 py-4 font-medium whitespace-nowrap">
                {id}
            </td>
            <td className="px-6 py-4">
                {nombre}
            </td>
            <td className="px-6 py-4">
                {JSON.stringify(fecInicio)}
            </td>
            <td className="px-6 py-4">
                {JSON.stringify(fecTermino)}
            </td>
            <td className="px-6 py-4">
                {departamentoId}
            </td>
            <td className="px-6 py-4 flex gap-3">
                <button onClick={() => deleteProyecto(id)} className='text-slate-50 rounded-sm px-2 py-1 bg-red-500'>
                    Delete
                </button>
                <button onClick={() => {
                    router.push(`/proyectos/${id}`);
                }} className='text-slate-50 rounded-sm px-2 py-1 bg-blue-500'>
                    Actualizar
                </button>
            </td>
        </tr>
    );
}
