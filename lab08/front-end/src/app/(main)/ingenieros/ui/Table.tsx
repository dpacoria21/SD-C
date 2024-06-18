import { getIngenieros } from '@/utils/ingenieros/getIngenieros';
import TableItem from './TableItem';

export default async function Table() {

    const ingenieros = await getIngenieros(); 
    
    return (
        <div className="relative overflow-x-auto">
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

                        <th scope="col" className="px-6 py-3">
                            Opciones
                        </th>
                    </tr>
                </thead>
                <tbody>
                    {ingenieros.map(ingeniero => <TableItem key={ingeniero.id} {...ingeniero} />)}                    
                </tbody>
            </table>
        </div>
    );
}
