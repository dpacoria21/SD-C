'use server';

import { revalidatePath } from 'next/cache';

export const deleteIngeniero = async(id:number) => {
    await fetch(`http://localhost:8080/ingeniero/${id}`, {
        method: 'DELETE'
    });
    revalidatePath('/ingenieros');
};