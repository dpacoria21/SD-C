'use client';
import { useState } from 'react';
import EngineerPerProjectForm from './ui/EngineerPerProjectForm';
import Table from './ui/Table';
import { Ingeniero } from '@/interfaces/interfaces';
import { getIngenierosProyecto } from '@/utils/proyectos/getIngenierosProyecto';

export default function page() {

    // eslint-disable-next-line react-hooks/rules-of-hooks
    const [id, setId] = useState<number>(1);

    return (
        <section className='w-full flex flex-col justify-center items-center mt-10'>
            
            <EngineerPerProjectForm fn={
                (id) => {
                    setId(id);
                }}/>

            <div className='mt-10'/>

            <Table id={id!}/>

        </section>
    );
}
