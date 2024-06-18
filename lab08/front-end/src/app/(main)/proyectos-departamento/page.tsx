'use client';
import { useState } from 'react';
import Table from './ui/Table';
import ProjectsPerDepartmentForm from './ui/ProjectsPerDepartmentForm';

export default function page() {

    // eslint-disable-next-line react-hooks/rules-of-hooks
    const [id, setId] = useState<number>(0);

    return (
        <section className='w-full flex flex-col justify-center items-center mt-10'>
            
            <ProjectsPerDepartmentForm fn={
                (id) => {
                    setId(id);
                }}/>

            <div className='mt-10'/>

            <Table id={id!}/>

        </section>
    );
}
