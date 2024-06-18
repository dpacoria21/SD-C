'use server';

import { revalidatePath } from 'next/cache';

export const updateProyecto = async(formData: FormData) => {

    const id = formData.get('id');
    const nombre = formData.get('fullName');
    const fecInicio = new Date(formData.get('fecInicio') + '');
    const fecTermino = new Date(formData.get('fecFinal')+'');
    const departamentoId = formData.get('departamentoId');

    const proyecto = {
        nombre,
        fecInicio,
        fecTermino,
        departamentoId  
    };

    try{
        const updatedIngeniero = await fetch(`http://localhost:8080/proyecto/${id}`, {
            headers: {
                'Content-Type': 'application/json',
            },
            method: 'PUT',
            body: JSON.stringify(proyecto) 
        });

        revalidatePath('/proyectos');
        
    }catch(err){
        console.log(err);
    }
    
};