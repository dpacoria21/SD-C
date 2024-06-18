import TableItem from './TableItem';
import { getDepartamentos } from '@/utils/departamentos/getDepartamentos';

export default async function Table() {

    const departamentos = await getDepartamentos(); 
    
    return (
        <div className="relative overflow-x-auto">
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
                            Teléfono
                        </th>
                        <th scope="col" className="px-6 py-3">
                            Fax
                        </th>

                        <th scope="col" className="px-6 py-3">
                            Opciones
                        </th>
                    </tr>
                </thead>
                <tbody>
                    {departamentos.map(departamento => <TableItem key={departamento.id} {...departamento} />)}                    
                </tbody>
            </table>
        </div>
    );
}
