package lab02.Algoritmo_de_Cristian;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class CristianClockClient extends JFrame implements Runnable {
    private static final int SERVER_PORT = 8000;
    private JTextArea logArea;
    private int localTime;
    private int serverTime;
    private boolean isRunning;

    public CristianClockClient() {
        super("Reloj de Cristian");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        logArea = new JTextArea();
        logArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logArea);
        add(scrollPane, BorderLayout.CENTER);

        JButton startButton = new JButton("Iniciar sincronización");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isRunning) {
                    isRunning = true;
                    Thread thread = new Thread(CristianClockClient.this);
                    thread.start();
                }
            }
        });
        add(startButton, BorderLayout.SOUTH);

        localTime = 0;
        isRunning = false;

    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                Socket socket = new Socket("localhost", SERVER_PORT);
                InputStream inputStream = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String serverTimeStr = reader.readLine();
                serverTime = (int) (Long.parseLong(serverTimeStr) / 1000);
                socket.close();

                int transmissionTime = localTime;
                localTime = Math.max(localTime, serverTime) + 1;

                logArea.append("Hora local: " + localTime + "\n");
                logArea.append("Hora del servidor: " + serverTime + "\n");
                logArea.append("Tiempo de transmisión: " + transmissionTime + "\n");
                logArea.append("---------------------------------------\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CristianClockClient client = new CristianClockClient();
                client.setVisible(true);
            }
        });
    }
}