'use client';

import { Proyecto } from '@/interfaces/interfaces';

export default function TableItem({id, nombre, fecInicio, fecTermino, departamentoId}: Proyecto) {
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
        </tr>
    );
}
