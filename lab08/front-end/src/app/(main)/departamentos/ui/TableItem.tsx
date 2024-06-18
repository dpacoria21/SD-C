'use client';

import { deleteDepartamento } from '@/actions/departamentos/deleteDepartamento';
import { Departamento} from '@/interfaces/interfaces';
import { useRouter } from 'next/navigation';

export default function TableItem({id,nombre,fax,telefono}: Departamento) {

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
                {telefono}
            </td>
            <td className="px-6 py-4">
                {fax}
            </td>
            <td className="px-6 py-4 flex gap-3">
                <button onClick={() => deleteDepartamento(id)} className='text-slate-50 rounded-sm px-2 py-1 bg-red-500'>
                    Delete
                </button>
                <button onClick={() => {
                    router.push(`/departamentos/${id}`);
                }} className='text-slate-50 rounded-sm px-2 py-1 bg-blue-500'>
                    Update
                </button>
            </td>
        </tr>
    );
}
