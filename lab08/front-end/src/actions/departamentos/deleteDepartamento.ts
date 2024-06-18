'use server';

import { revalidatePath } from 'next/cache';

export const deleteDepartamento = async(id:number) => {
    await fetch(`http://localhost:8080/departamento/${id}`, {
        method: 'DELETE'
    });
    revalidatePath('/departamentos');
};