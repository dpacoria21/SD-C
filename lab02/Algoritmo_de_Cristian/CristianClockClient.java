package lab02.Algoritmo_de_Cristian;

import java.awt.*;
import javax.swing.*;

public class CristianClockClient extends JFrame {
    private JTextArea logArea;

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
        add(startButton, BorderLayout.SOUTH);
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