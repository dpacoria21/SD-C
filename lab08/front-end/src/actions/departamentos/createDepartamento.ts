'use server';

import { revalidatePath } from 'next/cache';

export const createDepartamento = async(prevState: any, formData: FormData) => {

    const nombre = formData.get('fullName');
    const telefono = formData.get('telefono');
    const fax = formData.get('fax');

    const departamento = {
        nombre,
        telefono,
        fax,
    };

    try{
        const createdDepartamento = await fetch('http://localhost:8080/departamento', {
            headers: {
                'Content-Type': 'application/json',
            },
            method: 'POST',
            body: JSON.stringify(departamento) 
        });

        revalidatePath('/departamentos');
        
    }catch(err){
        console.log(err);
    }
    
};