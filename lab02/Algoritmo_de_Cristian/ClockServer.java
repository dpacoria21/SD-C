package lab02.Algoritmo_de_Cristian;

import java.net.*;
import java.io.*;
import java.util.Date;

public class ClockServer {
    private static final int SERVER_PORT = 8000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Servidor de reloj iniciado en el puerto " + SERVER_PORT);

            while (true) {
                System.out.println("Esperando conexiones...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado desde " + clientSocket.getInetAddress());

                Date now = new Date();
                String timeStr = String.valueOf(now.getTime());

                OutputStream os = clientSocket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(timeStr + "\n");
                bw.flush();

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}