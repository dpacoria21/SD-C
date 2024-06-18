import TableItem from './TableItem';
import { getProyectos } from '@/utils/proyectos/getProyectos';

export default async function Table() {

    const proyectos = await getProyectos(); 
    
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
                            Fecha Inicio
                        </th>
                        <th scope="col" className="px-6 py-3">
                            Fecha Final
                        </th>

                        <th scope="col" className="px-6 py-3">
                            Departamento ID
                        </th>

                        <th scope="col" className="px-6 py-3">
                            Opciones
                        </th>
                    </tr>
                </thead>
                <tbody>
                    {proyectos.map(proyecto => <TableItem key={proyecto.id} {...proyecto} />)}                    
                </tbody>
            </table>
        </div>
    );
}
