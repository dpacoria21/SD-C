'use server';

import { revalidatePath } from 'next/cache';

export const updateIngeniero = async(formData: FormData) => {

    const id = formData.get('id');
    const nombre = formData.get('fullName');
    const especialidad = formData.get('specialty');
    const cargo = formData.get('position');
    const proyectoId = formData.get('proyectoId');
    // console.log({nombre, especialidad, cargo, proyectoId});

    const ingeniero = {
        nombre,
        especialidad,
        cargo,
        proyectoId
    };

    try{
        const createdIngeniero = await fetch(`http://localhost:8080/ingeniero/${id}`, {
            headers: {
                'Content-Type': 'application/json',
            },
            method: 'PUT',
            body: JSON.stringify(ingeniero) 
        });

        revalidatePath('/ingenieros');

    }catch(err){
        console.log(err);
    }
    
};