package lab04.Ejercicio_02;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class SistemaTarjetasImpl extends UnicastRemoteObject implements SistemaTarjetas {

    HashMap<String, Persona> personas = new HashMap<String, Persona>();

    protected SistemaTarjetasImpl() throws RemoteException {
        super();
    }

    @Override
    public BigDecimal getSaldo(String dni, int numeroTarjeta) throws RemoteException {
        return personas.get(dni).getTarjeta(numeroTarjeta).getSaldo();

    }

    @Override
    public BigDecimal addSaldo(String dni, int numeroTarjeta, BigDecimal saldo) throws RemoteException {
        BigDecimal saldoActual = personas.get(dni).getTarjeta(numeroTarjeta).getSaldo();
        BigDecimal nuevoSaldo = saldoActual.add(saldo);
        personas.get(dni).getTarjeta(numeroTarjeta).setSaldo(nuevoSaldo);
        return nuevoSaldo;
    }

    @Override
    public BigDecimal subSaldo(String dni, int numeroTarjeta, BigDecimal saldo) throws RemoteException {
        BigDecimal saldoActual = personas.get(dni).getTarjeta(numeroTarjeta).getSaldo();
        BigDecimal nuevoSaldo = saldoActual.subtract(saldo);
        if (nuevoSaldo.compareTo(BigDecimal.ZERO) < 0) {
            throw new RemoteException("Saldo insuficiente");
        }
        personas.get(dni).getTarjeta(numeroTarjeta).setSaldo(nuevoSaldo);
        return nuevoSaldo;
    }
}
