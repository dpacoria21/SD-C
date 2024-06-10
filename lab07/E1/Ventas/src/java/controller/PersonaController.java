package controller;

import entities.Persona;
import java.util.Map;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import repositories.PersonaRepository;

@WebService(serviceName = "PersonaController")
public class PersonaController {

    PersonaRepository personaRepository = new PersonaRepository();
    
    @WebMethod(operationName = "getPersonas")
    public String getPersonas() {
        StringBuilder result = new StringBuilder();
        
        Map<Integer, Persona> personas = personaRepository.getAllPersonas();
        
        for (Map.Entry<Integer, Persona> entry : personas.entrySet()) {
            Integer key = entry.getKey();
            Persona persona = entry.getValue();
            result.append("Código: ").append(key)
                  .append(", Nombre: ").append(persona.getNombre())
                  .append(", Apellido: ").append(persona.getApellido())
                  .append(", Saldo: ").append(persona.getSaldo())
                  .append("\n");
        }
        
        return result.toString();
    }

    @WebMethod(operationName = "addPersona")
    public String addPersona(@WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido, @WebParam(name = "saldo") double saldo) {
        Persona persona = new Persona(nombre, apellido, 0, saldo); // code is set in repository
        personaRepository.addPersona(persona);
        return "Persona agregada: " + nombre + " " + apellido;
    }
    
    @WebMethod(operationName = "updateSaldo")
    public String updateSaldo(@WebParam(name = "code") int code, @WebParam(name = "nuevoSaldo") double nuevoSaldo) {
        return personaRepository.updateSaldo(code, nuevoSaldo);
    }
    
    @WebMethod(operationName = "getSaldo")
    public double getSaldo(@WebParam(name = "code") int code) {
        return personaRepository.getSaldo(code);
    }  

    @WebMethod(operationName = "getPersona")
    public String getPersona(@WebParam(name = "code") int code) {
        Persona persona = personaRepository.getPersona(code);
        if (persona != null) {
            return "Persona encontrada: Código: " + code + ", Nombre: " + persona.getNombre() + ", Apellido: " + persona.getApellido() + ", Saldo: " + persona.getSaldo();
        } else {
            return "Persona no encontrada.";
        }
    }
}
