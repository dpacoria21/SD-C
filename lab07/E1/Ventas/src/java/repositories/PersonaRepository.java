package repositories;

import entities.Persona;
import java.util.HashMap;
import java.util.Map;

public class PersonaRepository {

    private Map<Integer, Persona> personas;
    private Integer size = 0;

    public void addPersona(Persona persona) {
        persona.setCode(++size);
        personas.put(persona.getCode(), persona);
    }

    public Persona getPersona(int codigo) {
        return personas.get(codigo);
    }

    public String updateSaldo(int codigo, double nuevoSaldo) {
        Persona persona = personas.get(codigo);
        if (persona != null) {
            persona.setSaldo(nuevoSaldo);
            return "Saldo actualizado con éxito. Nuevo saldo: " + persona.getSaldo();
        } else {
            return "Persona no encontrada.";
        }
    }

    public Map<Integer, Persona> getAllPersonas() {
        return personas;
    }
    
    public double getSaldo(int codigo){
        return personas.get(codigo).getSaldo();
    }

    public PersonaRepository() {
        personas = new HashMap<Integer, Persona>();
        Persona persona1 = new Persona("Juan", "Perez", 1, 1000.0);
        Persona persona2 = new Persona("Maria", "Gonzalez", 2, 2000.0);
        Persona persona3 = new Persona("Pedro", "Martinez", 3, 1500.0);
        Persona persona4 = new Persona("Ana", "Lopez", 4, 2500.0);
        Persona persona5 = new Persona("Luis", "Fernandez", 5, 3000.0);

        personas.put(1, persona1);
        personas.put(2, persona2);
        personas.put(3, persona3);
        personas.put(4, persona4);
        personas.put(5, persona5);
        size = 5;
    }
}
