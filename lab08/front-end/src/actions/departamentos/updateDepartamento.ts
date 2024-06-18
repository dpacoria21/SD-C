'use server';

import { revalidatePath } from 'next/cache';

export const updateDepartamento = async(formData: FormData) => {

    const id = formData.get('id');
    const nombre = formData.get('fullName');
    const telefono = formData.get('telefono');
    const fax = formData.get('fax');

    const departamento = {
        nombre,
        telefono,
        fax,
    };

    try{
        const updateDepartamento = await fetch(`http://localhost:8080/departamento/${id}`, {
            headers: {
                'Content-Type': 'application/json',
            },
            method: 'PUT',
            body: JSON.stringify(departamento) 
        });

        revalidatePath('/departamentos');
        
    }catch(err){
        console.log(err);
    }
    
};