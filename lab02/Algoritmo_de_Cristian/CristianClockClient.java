package lab02.Algoritmo_de_Cristian;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CristianClockClient extends JFrame implements Runnable {
    private JTextArea logArea;
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

        isRunning = false;
    }

    @Override
    public void run() {
        // Implementación de la sincronización
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