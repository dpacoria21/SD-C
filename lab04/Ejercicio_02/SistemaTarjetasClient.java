package lab04.Ejercicio_02;

import java.math.BigDecimal;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.util.Scanner;

public class SistemaTarjetasClient {
    public static void main(String[] args) {
        try {
            SistemaTarjetas s = (SistemaTarjetas) Naming.lookup("rmi://localhost/SistemaTarjetasService");
            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingrese DNI:");
            String dni = scanner.nextLine();

            System.out.println("Ingrese número de tarjeta:");
            int numeroTarjeta = scanner.nextInt();

            System.out.println("Seleccione una opción:");
            System.out.println("1. Ver saldo");
            System.out.println("2. Agregar saldo");
            System.out.println("3. Restar saldo");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("El saldo actual de la tarjeta " + numeroTarjeta + " es: "
                            + s.getSaldo(dni, numeroTarjeta));
                    break;
                case 2:
                    System.out.println("Ingrese saldo a agregar:");
                    BigDecimal saldoAgregar = scanner.nextBigDecimal();
                    System.out.println("Saldo después de agregar: " + s.addSaldo(dni, numeroTarjeta, saldoAgregar));
                    break;
                case 3:
                    System.out.println("Ingrese saldo a restar:");
                    BigDecimal saldoRestar = scanner.nextBigDecimal();
                    System.out.println("Saldo después de restar: " + s.subSaldo(dni, numeroTarjeta, saldoRestar));
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }

            scanner.close();
        } catch (MalformedURLException murle) {
            System.out.println();
            System.out.println("MalformedURLException");
            System.out.println(murle);
        } catch (RemoteException re) {
            System.out.println();
            System.out.println("RemoteException");
            System.out.println(re);
        } catch (NotBoundException nbe) {
            System.out.println();
            System.out.println("NotBoundException");
            System.out.println(nbe);
        }
    }
}