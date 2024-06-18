'use server';

import { revalidatePath } from 'next/cache';

export const deleteProyecto = async(id:number) => {
    await fetch(`http://localhost:8080/proyecto/${id}`, {
        method: 'DELETE'
    });
    revalidatePath('/proyectos');
};