'use client';

import { deleteDepartamento } from '@/actions/departamentos/deleteDepartamento';
import { Departamento} from '@/interfaces/interfaces';

export default function TableItem({id,nombre,fax,telefono}: Departamento) {
    return (
        <tr className="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
            <td scope="row" className="px-6 py-4 font-medium whitespace-nowrap">
                {id}
            </td>
            <td className="px-6 py-4">
                {nombre}
            </td>
            <td className="px-6 py-4">
                {fax}
            </td>
            <td className="px-6 py-4">
                {telefono}
            </td>
            <td className="px-6 py-4">
                <button onClick={() => deleteDepartamento(id)} className='text-slate-50 rounded-sm px-2 py-1 bg-red-500'>
                    delete
                </button>
            </td>
        </tr>
    );
}
