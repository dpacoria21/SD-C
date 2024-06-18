package gui;

import dao.ProyectoDAO;
import dao.IngenieroProyectoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ConsultaIngenierosProyectoForm extends JPanel {
    private JComboBox<String> comboProyectos;
    private JButton btnBuscar;
    private JTable table;
    private IngenieroProyectoDAO ingenieroProyectoDAO;
    private ProyectoDAO proyectoDAO;
    private Map<String, Integer> proyectosMap;

    public ConsultaIngenierosProyectoForm() {
        ingenieroProyectoDAO = new IngenieroProyectoDAO();
        proyectoDAO = new ProyectoDAO();
        proyectosMap = new HashMap<>();
        initComponents();
        cargarProyectos();
    }

    private void initComponents() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel panelForm = new JPanel();
        panelForm.setLayout(new BoxLayout(panelForm, BoxLayout.Y_AXIS));

        panelForm.add(new JLabel("Buscar por Proyecto:"));
        comboProyectos = new JComboBox<>();
        panelForm.add(comboProyectos);

        btnBuscar = new JButton("Buscar");
        panelForm.add(btnBuscar);

        add(panelForm);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarIngenierosPorProyecto();
            }
        });
    }

    private void cargarProyectos() {
        try {
            ResultSet rs = proyectoDAO.obtenerNombresYIdsDeProyectos();
            comboProyectos.removeAllItems();
            proyectosMap.clear();
            while (rs.next()) {
                int idProy = rs.getInt("IDProy");
                String nombre = rs.getString("Nombre");
                proyectosMap.put(nombre, idProy); // Guardar el ID y el nombre en el mapa
                comboProyectos.addItem(nombre);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar proyectos: " + e.getMessage());
        }
    }

    private void buscarIngenierosPorProyecto() {
        String proyecto = (String) comboProyectos.getSelectedItem();
        if (proyecto == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un proyecto.");
            return;
        }
        int idProy = proyectosMap.get(proyecto);

        DefaultTableModel model = new DefaultTableModel(new String[]{"ID Ingeniero", "Nombre", "Especialidad", "Cargo", "Departamento"}, 0);
        try {
            ResultSet rs = ingenieroProyectoDAO.obtenerIngenierosPorProyecto(idProy);
            while (rs.next()) {
                int idIng = rs.getInt("IDIng");
                String nombre = rs.getString("Nombre");
                String especialidad = rs.getString("Especialidad");
                String cargo = rs.getString("Cargo");
                String nombreDpto = rs.getString("NombreDpto");
                model.addRow(new Object[]{idIng, nombre, especialidad, cargo, nombreDpto});
            }
            table.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al consultar los ingenieros: " + e.getMessage());
        }
    }
}
