'use client';

import { updateDepartamento } from '@/actions/departamentos/updateDepartamento';
import { SubmitButton } from '@/components/Form/SubmitButton';
import { Departamento } from '@/interfaces/interfaces';
import { useRouter } from 'next/navigation';
import React, { useEffect } from 'react';
import { SubmitHandler, useForm } from 'react-hook-form';

interface Props {
    params: {
        id: string
    }
}

interface Inputs {
    fullName: string,
    telefono: string,
    fax: string,
}

export default function DepartmentForm({params}: Props) {

    const id = params.id;
    const router = useRouter();

    const {
        register,
        handleSubmit,
        watch,
        setValue,
        formState: { errors },
    } = useForm<Inputs>();
    const onSubmit: SubmitHandler<Inputs> = async(data) => {
        const formData = new FormData();
        formData.append('id', id);
        formData.append('fullName', data.fullName);
        formData.append('telefono', data.telefono);
        formData.append('fax', data.fax);
        await updateDepartamento(formData);
        router.push('/departamentos');
    };

    useEffect(() => {
        const res = fetch(`http://localhost:8080/departamento/${id}`, {method: 'GET'}).then(res => res.json());
        res.then((data: Departamento) => {
            setValue('fullName', data.nombre);
            setValue('telefono', ''+data.telefono);
            setValue('fax', data.fax);
        });
    }, []);


    return (
        <section className='w-full h-full flex flex-col justify-center items-center'>
            <h1 className='text-3xl font-semibold'>Actualizar Departamento</h1>
            <form onSubmit={handleSubmit(onSubmit)} className="w-full max-w-lg mt-10">
                <div className="flex flex-wrap -mx-3 mb-6">
                    <div className="w-full md:w-1/2 px-3 mb-6 md:mb-0">
                        <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="fullName">
                            Nombre del Departamento
                        </label>
                        <input className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" {...register('fullName')} required id="fullName" type="text" placeholder="Departamento de Logistica"/>
                    </div>
                    <div className="w-full md:w-1/2 px-3">
                        <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="telefono">
                            Telefono
                        </label>
                        <input className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" {...register('telefono')} required id="telefono" type="text" placeholder="123-123-123"/>
                    </div>
                </div>
                <div className="flex flex-wrap -mx-3 mb-6">
                    <div className="w-full md:w-1/2 px-3 mb-6 md:mb-0">
                        <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="fax">
                            Fax
                        </label>
                        <input className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" {...register('fax')} required id="fax" type="text" placeholder="123-123-1234"/>
                    </div>
                </div>
                
                <SubmitButton label='Actualizar'/>
            </form>
        </section>
    );
}
