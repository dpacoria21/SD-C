package gui;

import dao.DepartamentoDAO;
import dao.ProyectoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ConsultaProyectosForm extends JPanel {
    private JTextField txtBuscarId;
    private JComboBox<String> comboDepartamentos;
    private JButton btnBuscar;
    private JTable table;
    private ProyectoDAO proyectoDAO;
    private DepartamentoDAO departamentoDAO;
    private Map<String, Integer> departamentosMap;

    public ConsultaProyectosForm() {
        proyectoDAO = new ProyectoDAO();
        departamentoDAO = new DepartamentoDAO();
        departamentosMap = new HashMap<>();
        initComponents();
        cargarDepartamentos();
    }

    private void initComponents() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel panelForm = new JPanel();
        panelForm.setLayout(new BoxLayout(panelForm, BoxLayout.Y_AXIS));

        panelForm.add(new JLabel("Buscar por ID de Proyecto:"));
        txtBuscarId = new JTextField(20);
        panelForm.add(txtBuscarId);

        panelForm.add(new JLabel("Buscar por Departamento:"));
        comboDepartamentos = new JComboBox<>();
        panelForm.add(comboDepartamentos);

        btnBuscar = new JButton("Buscar");
        panelForm.add(btnBuscar);

        add(panelForm);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtBuscarId.getText().isEmpty()) {
                    buscarProyectosPorDepartamento();
                } else {
                    buscarProyectoPorId();
                }
            }
        });
    }

    private void cargarDepartamentos() {
        try {
            ResultSet rs = departamentoDAO.obtenerNombresYIdsDeDepartamentos();
            comboDepartamentos.removeAllItems();
            departamentosMap.clear();
            while (rs.next()) {
                int idDpto = rs.getInt("IDDpto");
                String nombre = rs.getString("Nombre");
                departamentosMap.put(nombre, idDpto); // Guardar el ID y el nombre en el mapa
                comboDepartamentos.addItem(nombre);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar departamentos: " + e.getMessage());
        }
    }

    private void buscarProyectoPorId() {
        int idProyecto;
        try {
            idProyecto = Integer.parseInt(txtBuscarId.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID de proyecto válido.");
            return;
        }

        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Nombre", "Fecha Inicio", "Fecha Fin", "ID Departamento", "ID Ingeniero"}, 0);
        try {
            ResultSet rs = proyectoDAO.obtenerProyectoPorId(idProyecto);
            if (rs.next()) {
                int id = rs.getInt("IDProy");
                String nombre = rs.getString("Nombre");
                String fechaInicio = rs.getString("Fec_Inicio");
                String fechaFin = rs.getString("Fec_Termino");
                int idDpto = rs.getInt("IDDpto");
                int idIng = rs.getInt("IDIng");
                model.addRow(new Object[]{id, nombre, fechaInicio, fechaFin, idDpto, idIng});
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el proyecto con el ID especificado.");
            }
            table.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al consultar el proyecto: " + e.getMessage());
        }
    }

    private void buscarProyectosPorDepartamento() {
        String departamento = (String) comboDepartamentos.getSelectedItem();
        int idDpto = departamentosMap.get(departamento);

        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Nombre", "Fecha Inicio", "Fecha Fin", "Departamento", "ID Ingeniero"}, 0);
        try {
            ResultSet rs = proyectoDAO.obtenerProyectosPorDepartamento(idDpto);
            while (rs.next()) {
                int id = rs.getInt("IDProy");
                String nombre = rs.getString("Nombre");
                String fechaInicio = rs.getString("Fec_Inicio");
                String fechaFin = rs.getString("Fec_Termino");
                int idIng = rs.getInt("IDIng");
                model.addRow(new Object[]{id, nombre, fechaInicio, fechaFin, departamento, idIng});
            }
            table.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al consultar los proyectos: " + e.getMessage());
        }
    }
}
