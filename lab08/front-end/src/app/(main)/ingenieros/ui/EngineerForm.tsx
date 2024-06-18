'use client';

import { createIngeniero } from '@/actions/ingenieros/createIngeniero';
import { SubmitButton } from '@/components/Form/SubmitButton';
import { useRef } from 'react';
import { useFormState } from 'react-dom';

export default function EngineerForm() {

    const [state, formAction] = useFormState(createIngeniero, undefined);
    const ref = useRef<HTMLFormElement>(null);

    return (
        <>
            <h1 className='text-3xl font-semibold'>Crear Ingeniero</h1>
            <form ref={ref} action={async(formData) => {
                formAction(formData);
                ref.current?.reset();
            }} className="w-full max-w-lg mt-10">
                <div className="flex flex-wrap -mx-3 mb-6">
                    <div className="w-full md:w-1/2 px-3 mb-6 md:mb-0">
                        <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="fullName">
                            Nombre del Ingeniero
                        </label>
                        <input className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" name='fullName' required id="fullName" type="text" placeholder="Jane Foster"/>
                    </div>
                    <div className="w-full md:w-1/2 px-3">
                        <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="specialty">
                            Especialidad
                        </label>
                        <input className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" name='specialty' required id="specialty" type="text" placeholder="Ingeniería Civil"/>
                    </div>
                </div>
                <div className="flex flex-wrap -mx-3 mb-6">
                    <div className="w-full md:w-1/2 px-3 mb-6 md:mb-0">
                        <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="position">
                            Cargo
                        </label>
                        <input className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" name='position' required id="position" type="text" placeholder="Jefe de Proyecto"/>
                    </div>
                    <div className="w-full md:w-1/2 px-3">
                        <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="proyectoId">
                            ID del Proyecto
                        </label>
                        <input className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" name='proyectoId' required id="proyectoId" type="number" placeholder="123"/>
                    </div>
                </div>
                
                <SubmitButton label='Crear'/>
            </form>
        </>
    );
}
