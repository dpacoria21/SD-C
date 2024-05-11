package lab02.Algoritmo_de_Cristian;

import java.net.*;
import java.io.*;

public class ClockServer {
    private static final int SERVER_PORT = 8000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Servidor de reloj iniciado en el puerto " + SERVER_PORT);

            // Aceptar conexiones y enviar la hora (implementación pendiente)
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}