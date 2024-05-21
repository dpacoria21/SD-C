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

            String dni;
            int numeroTarjeta;
            boolean validInput = false;

            while (!validInput) {
                try {
                    System.out.println("Ingrese DNI:");
                    dni = scanner.nextLine();

                    System.out.println("Ingrese número de tarjeta:");
                    numeroTarjeta = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer de entrada

                    // Verificar si el DNI y el número de tarjeta existen antes de continuar
                    s.getSaldo(dni, numeroTarjeta);

                    validInput = true; // Si no hay excepciones, la entrada es válida

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
                            System.out.println(
                                    "Saldo después de agregar: " + s.addSaldo(dni, numeroTarjeta, saldoAgregar));
                            break;
                        case 3:
                            System.out.println("Ingrese saldo a restar:");
                            BigDecimal saldoRestar = scanner.nextBigDecimal();
                            System.out
                                    .println("Saldo después de restar: " + s.subSaldo(dni, numeroTarjeta, saldoRestar));
                            break;
                        default:
                            System.out.println("Opción no válida");
                            break;
                    }
                } catch (RemoteException re) {
                    System.out.println("Error en la operación: " + re.getMessage());
                } catch (Exception e) {
                    System.out.println("Error de entrada: " + e.getMessage());
                    scanner.nextLine(); // Limpiar el buffer de entrada en caso de excepción
                }
            }

            scanner.close();
        } catch (MalformedURLException murle) {
            System.out.println("MalformedURLException: " + murle);
        } catch (RemoteException re) {
            System.out.println("RemoteException: " + re);
        } catch (NotBoundException nbe) {
            System.out.println("NotBoundException: " + nbe);
        }
    }
}