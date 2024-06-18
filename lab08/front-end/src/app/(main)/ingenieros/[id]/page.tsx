'use client';

import { updateIngeniero } from '@/actions/ingenieros/updateIngeniero';
import { SubmitButton } from '@/components/Form/SubmitButton';
import { Ingeniero } from '@/interfaces/interfaces';
import { useRouter } from 'next/navigation';
import { useEffect} from 'react';
import { SubmitHandler, useForm } from 'react-hook-form';

interface Props {
    params: {
        id: string
    }
}

interface Inputs {
    specialty: string,
    position: string,
    proyectoId: string,
}

export default function EngineerForm({params}: Props) {

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
        formData.append('fullName', '');
        formData.append('id', id);
        formData.append('specialty', data.specialty);
        formData.append('position', data.position);
        formData.append('proyectoId', data.proyectoId);
        await updateIngeniero(formData);
        router.push('/ingenieros');
    };

    useEffect(() => {
        const res = fetch(`http://localhost:8080/ingeniero/${id}`, {method: 'GET'}).then(res => res.json());
        res.then((data: Ingeniero) => {
            setValue('position', data.cargo);
            setValue('proyectoId', ''+data.proyectoId);
            setValue('specialty', data.especialidad);
        });
    }, []);

    return (
        <section className='w-full h-full flex flex-col justify-center items-center'>
            <h1 className='text-3xl font-semibold'>Actualizar Ingeniero</h1>
            <form onSubmit={handleSubmit(onSubmit)} className="w-full max-w-lg mt-10">
                <div className="flex flex-wrap -mx-3 mb-6">
                    <div className="w-full md:w-1/2 px-3">
                        <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="specialty">
                            Especialidad
                        </label>
                        <input className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" {...register('specialty')} id="specialty" type="text" placeholder="Ingeniería Civil"/>
                    </div>
                </div>
                <div className="flex flex-wrap -mx-3 mb-6">
                    <div className="w-full md:w-1/2 px-3 mb-6 md:mb-0">
                        <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="position">
                            Cargo
                        </label>
                        <input className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" {...register('position')} id="position" type="text" placeholder="Jefe de Proyecto"/>
                    </div>
                    <div className="w-full md:w-1/2 px-3">
                        <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" htmlFor="proyectoId">
                            ID del Proyecto
                        </label>
                        <input className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" {...register('proyectoId')}  id="proyectoId" type="number" placeholder="123"/>
                    </div>
                </div>
                
                <SubmitButton label='Actualizar'/>
            </form>
        </section>
    );
}
