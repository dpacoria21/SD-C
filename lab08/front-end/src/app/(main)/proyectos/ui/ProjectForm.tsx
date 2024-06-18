'use client';

import { createProyecto } from '@/actions/proyectos/createProyecto';
import { SubmitButton } from '@/components/Form/SubmitButton';
import { useRef } from 'react';
import { useFormState } from 'react-dom';

export default function ProjectForm() {

    const [state, formAction] = useFormState(createProyecto, undefined);
    const ref = useRef<HTMLFormElement>(null);

    return (
        <>
            <h1 className='text-3xl font-semibold'>Crear Proyecto</h1>
            <form ref={ref} action={async(formData) => {
                formAction(formData);
                ref.current?.reset();
            }} className="w-full max-w-lg mt-10">
                <div className="flex flex-wrap -mx-3 mb-6">
                    <div className="w-full md:w-1/2 px-3 mb-6 md:mb-0">
                        <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="fullName">
                            Nombre del Proyecto
                        </label>
                        <input className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" name='fullName' required id="fullName" type="text" placeholder="Sistema de Inventario"/>
                    </div>
                    <div className="w-full md:w-1/2 px-3">
                        <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="fecInicio">
                            Fecha de Inicio
                        </label>
                        <input className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" name='fecInicio' required id="fecInicio" type="date"/>
                    </div>
                </div>
                <div className="flex flex-wrap -mx-3 mb-6">
                    <div className="w-full md:w-1/2 px-3 mb-6 md:mb-0">
                        <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="fecFinal">
                            Fecha Final
                        </label>
                        <input className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" name='fecFinal' required id="fecFinal" type="date" />
                    </div>
                    <div className="w-full md:w-1/2 px-3">
                        <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="departamentoId">
                            ID del Departamento
                        </label>
                        <input className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" name='departamentoId' required id="departamentoId" type="number" placeholder="123"/>
                    </div>
                </div>
                
                <SubmitButton label='Crear'/>
            </form>
        </>
    );
}
