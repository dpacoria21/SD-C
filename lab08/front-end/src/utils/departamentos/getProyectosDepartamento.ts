export const getProyectosDepartamento = async(id: number) => {
    const res = await fetch(`http://localhost:8080/proyecto/departamento/${id}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        }
    });
    return res.json();
};