package main;

import gui.DepartamentoForm;
import gui.IngenieroForm;
import gui.ProyectoForm;
import gui.ConsultaProyectosForm;
import gui.ConsultaIngenierosProyectoForm;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MainApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestión de la Empresa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Departamentos", new DepartamentoForm());
        tabbedPane.addTab("Ingenieros", new IngenieroForm());
        tabbedPane.addTab("Proyectos", new ProyectoForm());
        tabbedPane.addTab("Consulta de proyectos", new ConsultaProyectosForm());
        tabbedPane.addTab("Consulta de ingenieros", new ConsultaIngenierosProyectoForm());

        frame.add(tabbedPane);
        frame.setVisible(true);
    }
}
