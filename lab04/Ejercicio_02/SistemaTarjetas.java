package lab04.Ejercicio_02;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SistemaTarjetas extends Remote {
    public int getSaldo(String dni) throws RemoteException;

    public int addSaldo(String dni, BigDecimal saldo) throws RemoteException;

    public int subSaldo(String dni, BigDecimal saldo) throws RemoteException;

}
