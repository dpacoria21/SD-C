'use client';

import { createDepartamento } from '@/actions/departamentos/createDepartamento';
import { SubmitButton } from '@/components/Form/SubmitButton';
import { useRef } from 'react';
import { useFormState } from 'react-dom';

export default function DepartmentForm() {

    const [state, formAction] = useFormState(createDepartamento, undefined);
    const ref = useRef<HTMLFormElement>(null);

    return (
        <>
            <h1 className='text-3xl font-semibold'>Crear Departamento</h1>
            <form ref={ref} action={async(formData) => {
                formAction(formData);
                ref.current?.reset();
            }} className="w-full max-w-lg mt-10">
                <div className="flex flex-wrap -mx-3 mb-6">
                    <div className="w-full md:w-1/2 px-3 mb-6 md:mb-0">
                        <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="fullName">
                            Nombre del Departamento
                        </label>
                        <input className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" name='fullName' required id="fullName" type="text" placeholder="Departamento de Logistica"/>
                    </div>
                    <div className="w-full md:w-1/2 px-3">
                        <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="telefono">
                            Telefono
                        </label>
                        <input className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" name='telefono' required id="telefono" type="text" placeholder="123-123-123"/>
                    </div>
                </div>
                <div className="flex flex-wrap -mx-3 mb-6">
                    <div className="w-full md:w-1/2 px-3 mb-6 md:mb-0">
                        <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="fax">
                            Fax
                        </label>
                        <input className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" name='fax' required id="fax" type="text" placeholder="123-123-1234"/>
                    </div>
                </div>
                
                <SubmitButton label='Crear'/>
            </form>
        </>
    );
}
