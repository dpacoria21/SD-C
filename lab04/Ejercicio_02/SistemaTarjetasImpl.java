package lab04.Ejercicio_02;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class SistemaTarjetasImpl extends UnicastRemoteObject implements SistemaTarjetas {

    HashMap<String, Persona> personas = new HashMap<String, Persona>();

    protected SistemaTarjetasImpl() throws RemoteException {
        super();
        Persona persona1 = new Persona("Juan", "Perez", "12345678");
        Persona persona2 = new Persona("Maria", "Gomez", "87654321");

        Tarjeta tarjeta1 = new Tarjeta(1, TipoTarjeta.CREDITO, "12/2023", "123", "Juan Perez", new BigDecimal("1000"));
        Tarjeta tarjeta2 = new Tarjeta(2, TipoTarjeta.DEBITO, "06/2024", "456", "Maria Gomez",
                new BigDecimal("2000"));

        persona1.addTarjeta(tarjeta1);
        persona2.addTarjeta(tarjeta2);

        personas.put(persona1.getDni(), persona1);
        personas.put(persona2.getDni(), persona2);
    }

    @Override
    public BigDecimal getSaldo(String dni, int numeroTarjeta) throws RemoteException {
        checkConsult(dni, numeroTarjeta);
        return personas.get(dni).getTarjeta(numeroTarjeta).getSaldo();
    }

    @Override
    public BigDecimal addSaldo(String dni, int numeroTarjeta, BigDecimal saldo) throws RemoteException {
        checkConsult(dni, numeroTarjeta);
        BigDecimal saldoActual = personas.get(dni).getTarjeta(numeroTarjeta).getSaldo();
        BigDecimal nuevoSaldo = saldoActual.add(saldo);
        personas.get(dni).getTarjeta(numeroTarjeta).setSaldo(nuevoSaldo);
        return nuevoSaldo;
    }

    @Override
    public BigDecimal subSaldo(String dni, int numeroTarjeta, BigDecimal saldo) throws RemoteException {
        checkConsult(dni, numeroTarjeta);
        BigDecimal saldoActual = personas.get(dni).getTarjeta(numeroTarjeta).getSaldo();
        BigDecimal nuevoSaldo = saldoActual.subtract(saldo);
        if (nuevoSaldo.compareTo(BigDecimal.ZERO) < 0) {
            throw new RemoteException("Saldo insuficiente");
        }
        personas.get(dni).getTarjeta(numeroTarjeta).setSaldo(nuevoSaldo);
        return nuevoSaldo;
    }

    private void checkConsult(String dni, int numeroTarjeta) throws RemoteException {
        if (!personas.containsKey(dni)) {
            throw new RemoteException("Persona no encontrada");
        }
        if (!personas.get(dni).getTarjetas().containsKey(numeroTarjeta)) {
            throw new RemoteException("Tarjeta no encontrada");
        }
    }

}
