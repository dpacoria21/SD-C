export const getIngenierosProyecto = async(id: number) => {
    const res = await fetch(`http://localhost:8080/ingeniero/proyecto/${id}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        }
    });
    return res.json();
};