'use client';

import { SubmitButton } from '@/components/Form/SubmitButton';
import { useRef } from 'react';


interface Props {
    fn: (id: number) => void
}

export default function ProjectsPerDepartmentForm({fn}: Props) {

    const ref = useRef<HTMLFormElement>(null);

    return (
        <>
            <h1 className='text-3xl font-semibold'>Ver Proyectos por Departamento</h1>
            <form ref={ref} action={async(formData) => {
                // console.log(formData);
                if(formData.get('departamentoId') == null) return;
                const id = +formData.get('departamentoId')!;
                fn(id);
                ref.current?.reset();
            }} className="w-full max-w-lg mt-10">
                <div className="flex flex-wrap -mx-3 mb-6">
                    <div className="w-full md:w-1/2 px-3 mb-6 md:mb-0">
                        <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="departamentoId">
                            Id del Departamento
                        </label>
                        <input className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" name='departamentoId' required id="departamentoId" type="number" placeholder="123"/>
                    </div>
                </div>
                <SubmitButton label='Crear'/>
            </form>
        </>
    );
}
