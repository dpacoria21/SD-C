import { Departamento} from '@/interfaces/interfaces';

export const getDepartamentos = async(): Promise<Departamento[]> => {
    const res = await fetch('http://localhost:8080/departamento', {
        method: 'GET',
    });
    return res.json();
};