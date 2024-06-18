import { Ingeniero } from '@/interfaces/interfaces';

export const getIngenieros = async(): Promise<Ingeniero[]> => {
    const res = await fetch('http://localhost:8080/ingeniero', {
        method: 'GET',
    });
    return res.json();
};