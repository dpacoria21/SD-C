'use server';

import { revalidatePath } from 'next/cache';

export const createProyecto = async(prevState: any, formData: FormData) => {

    const nombre = formData.get('fullName');
    const fecInicio = formData.get('fecInicio');
    const fecTermino = formData.get('fecFinal');
    const departamentoId = formData.get('departamentoId');

    const proyecto = {
        nombre,
        fecInicio,
        fecTermino,
        departamentoId  
    };

    try{
        const createdIngeniero = await fetch('http://localhost:8080/proyecto', {
            headers: {
                'Content-Type': 'application/json',
            },
            method: 'POST',
            body: JSON.stringify(proyecto) 
        });

        revalidatePath('/proyectos');
        
    }catch(err){
        console.log(err);
    }
    
};