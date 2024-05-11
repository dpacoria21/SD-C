package lab02.Algoritmo_de_Cristian;

import javax.swing.*;

public class CristianClockClient extends JFrame {

    public CristianClockClient() {
        setTitle("Reloj de Cristian");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
    }

    public static void main(String[] args) {
        CristianClockClient client = new CristianClockClient();
        client.setVisible(true);
    }
}