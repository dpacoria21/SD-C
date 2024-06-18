'use client';

import { updateIngeniero } from '@/actions/ingenieros/updateIngeniero';
import { updateProyecto } from '@/actions/proyectos/updateProyecto';
import { SubmitButton } from '@/components/Form/SubmitButton';
import { Departamento, Ingeniero, Proyecto } from '@/interfaces/interfaces';
import { useRouter } from 'next/navigation';
import { useEffect} from 'react';
import { SubmitHandler, useForm } from 'react-hook-form';

interface Props {
    params: {
        id: string
    }
}

interface Inputs {
    fullName: string,
    fecInicio: Date,
    fecFinal: Date,
    departamentoId: string,
}

export default function ProjectForm({params}: Props) {

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
        formData.append('fecInicio', JSON.stringify(data.fecInicio));
        formData.append('fecFinal', JSON.stringify(data.fecFinal));
        formData.append('departamentoId', data.departamentoId);
        await updateProyecto(formData);
        router.push('/proyectos');
    };

    useEffect(() => {
        const res = fetch(`http://localhost:8080/proyecto/${id}`, {method: 'GET'}).then(res => res.json());
        res.then((data: Proyecto) => {
            setValue('fullName', data.nombre);
            setValue('fecInicio', data.fecInicio);
            setValue('fecFinal', data.fecTermino);
            setValue('departamentoId', data.departamentoId+'');
        });
    }, []);

    return (
        <section className='w-full h-full flex flex-col justify-center items-center'>
            <h1 className='text-3xl font-semibold'>Actualizar Proyecto</h1>
            <form onSubmit={handleSubmit(onSubmit)} className="w-full max-w-lg mt-10">
                <div className="flex flex-wrap -mx-3 mb-6">
                    <div className="w-full md:w-1/2 px-3">
                        <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="fullName">
                            Nombre del Proyecto
                        </label>
                        <input className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" {...register('fullName')} id="fullName" type="text" placeholder="Ingeniería Civil"/>
                    </div>
                    <div className="w-full md:w-1/2 px-3">
                        <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="fecInicio">
                            Fecha de Inicio
                        </label>
                        <input className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" {...register('fecInicio')} id="fecInicio" type="date" placeholder="Ingeniería Civil"/>
                    </div>
                </div>
                <div className="flex flex-wrap -mx-3 mb-6">
                    <div className="w-full md:w-1/2 px-3 mb-6 md:mb-0">
                        <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="fecFinal">
                            Fecha Final
                        </label>
                        <input className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" {...register('fecFinal')} id="fecFinal" type="date" placeholder="Jefe de Proyecto"/>
                    </div>
                    <div className="w-full md:w-1/2 px-3">
                        <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="departamentoId">
                            ID del Departamento
                        </label>
                        <input className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" {...register('departamentoId')}  id="departamentoId" type="number" placeholder="123" disabled/>
                    </div>
                </div>
                
                <SubmitButton label='Actualizar'/>
            </form>
        </section>
    );
}
