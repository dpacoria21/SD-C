import { Proyecto } from '@/interfaces/interfaces';

export const getProyectos = async(): Promise<Proyecto[]> => {
    const res = await fetch('http://localhost:8080/proyecto', {
        method: 'GET',
    });
    return res.json();
};