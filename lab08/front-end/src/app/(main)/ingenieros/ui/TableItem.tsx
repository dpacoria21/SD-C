'use client';

import { deleteIngeniero } from '@/actions/ingenieros/deleteIngeniero';
import { Ingeniero } from '@/interfaces/interfaces';
import { useRouter } from 'next/navigation';

export default function TableItem({id, cargo, especialidad, proyectoId}: Ingeniero) {

    const router = useRouter();
    
    return (
        <tr className="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
            <td scope="row" className="px-6 py-4 font-medium whitespace-nowrap">
                {id}
            </td>
            <td className="px-6 py-4">
                {especialidad}
            </td>
            <td className="px-6 py-4">
                {cargo}
            </td>
            <td className="px-6 py-4">
                {proyectoId}
            </td>
            <td className="px-6 py-4 flex gap-3">
                <button onClick={() => deleteIngeniero(id)} className='text-slate-50 rounded-sm px-2 py-1 bg-red-500'>
                    Eliminar
                </button>
                <button onClick={() => {
                    router.push(`/ingenieros/${id}`);
                }} className='text-slate-50 rounded-sm px-2 py-1 bg-blue-500'>
                    Actualizar
                </button>
            </td>
        </tr>
    );
}
