package gui;

import dao.DepartamentoDAO;
import dao.IngenieroDAO;
import dao.ProyectoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ProyectoForm extends JPanel {
    private JTextField txtNombre, txtFecInicio, txtFecTermino, txtIdProy;
    private JComboBox<String> comboDepartamentos, comboIngenieros;
    private JButton btnInsertar, btnActualizar, btnEliminar, btnConsultar, btnRefrescar, btnLimpiar;
    private JTable table;
    private ProyectoDAO proyectoDAO;
    private DepartamentoDAO departamentoDAO;
    private IngenieroDAO ingenieroDAO;
    private Map<Integer, String> departamentosMap; // Mapa para almacenar IDs de departamentos y sus nombres
    private Map<Integer, String> ingenierosMap; // Mapa para almacenar IDs de ingenieros y sus nombres

    public ProyectoForm() {
        proyectoDAO = new ProyectoDAO();
        departamentoDAO = new DepartamentoDAO();
        ingenieroDAO = new IngenieroDAO();
        departamentosMap = new HashMap<>();
        ingenierosMap = new HashMap<>();
        initComponents();
        consultarProyectos(); // Mostrar la lista de proyectos al iniciar
        cargarDepartamentos(); // Cargar los departamentos en el combo box
        cargarIngenieros(); // Cargar los ingenieros en el combo box
    }

    private void initComponents() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel panelForm = new JPanel();
        panelForm.setLayout(new BoxLayout(panelForm, BoxLayout.Y_AXIS));

        panelForm.add(new JLabel("ID Proyecto:"));
        txtIdProy = new JTextField(20);
        txtIdProy.setEditable(false); // Bloquear el campo de ID
        panelForm.add(txtIdProy);

        panelForm.add(new JLabel("Nombre:"));
        txtNombre = new JTextField(20);
        panelForm.add(txtNombre);

        panelForm.add(new JLabel("Fecha Inicio (YYYY-MM-DD):"));
        txtFecInicio = new JTextField(20);
        panelForm.add(txtFecInicio);

        panelForm.add(new JLabel("Fecha Término (YYYY-MM-DD):"));
        txtFecTermino = new JTextField(20);
        panelForm.add(txtFecTermino);

        panelForm.add(new JLabel("Departamento:"));
        comboDepartamentos = new JComboBox<>();
        panelForm.add(comboDepartamentos);

        panelForm.add(new JLabel("Ingeniero Responsable:"));
        comboIngenieros = new JComboBox<>();
        panelForm.add(comboIngenieros);

        btnInsertar = new JButton("Insertar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnConsultar = new JButton("Consultar");
        btnRefrescar = new JButton("Refrescar");
        btnLimpiar = new JButton("Limpiar");

        JPanel panelButtons = new JPanel();
        panelButtons.add(btnInsertar);
        panelButtons.add(btnActualizar);
        panelButtons.add(btnEliminar);
        panelButtons.add(btnConsultar);
        panelButtons.add(btnRefrescar);
        panelButtons.add(btnLimpiar);

        add(panelForm);
        add(panelButtons);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertarProyecto();
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarProyecto();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarProyecto();
            }
        });

        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarProyecto();
            }
        });

        btnRefrescar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarProyectos();
            }
        });

        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });

        table.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting() && table.getSelectedRow() != -1) {
                cargarDatosSeleccionados();
            }
        });
    }

    private void insertarProyecto() {
        String nombre = txtNombre.getText();
        String fecInicio = txtFecInicio.getText();
        String fecTermino = txtFecTermino.getText();
        String ingeniero = (String) comboIngenieros.getSelectedItem();
        int idIng = obtenerIdSeleccionado(ingenierosMap, ingeniero);
        if (nombre.isEmpty() || fecInicio.isEmpty() || fecTermino.isEmpty() || idIng == -1) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
            return;
        }
        if (proyectoDAO.insertarProyecto(nombre, fecInicio, fecTermino, idIng)) {
            JOptionPane.showMessageDialog(this, "Proyecto insertado con éxito");
            consultarProyectos();
            limpiarCampos();
        }
    }

    private void actualizarProyecto() {
        int idProy;
        try {
            idProy = Integer.parseInt(txtIdProy.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Seleccione un proyecto válido.");
            return;
        }
        String nombre = txtNombre.getText();
        String fecInicio = txtFecInicio.getText();
        String fecTermino = txtFecTermino.getText();
        String ingeniero = (String) comboIngenieros.getSelectedItem();
        int idIng = obtenerIdSeleccionado(ingenierosMap, ingeniero);
        if (nombre.isEmpty() || fecInicio.isEmpty() || fecTermino.isEmpty() || idIng == -1) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
            return;
        }
        if (proyectoDAO.actualizarProyecto(idProy, nombre, fecInicio, fecTermino, idIng)) {
            JOptionPane.showMessageDialog(this, "Proyecto actualizado con éxito");
            consultarProyectos();
            limpiarCampos();
        }
    }

    private void eliminarProyecto() {
        int idProy;
        try {
            idProy = Integer.parseInt(txtIdProy.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Seleccione un proyecto válido.");
            return;
        }
        if (proyectoDAO.eliminarProyecto(idProy)) {
            JOptionPane.showMessageDialog(this, "Proyecto eliminado con éxito");
            consultarProyectos();
            limpiarCampos();
        }
    }

    private void consultarProyecto() {
        // Puedes implementar la lógica para buscar un proyecto específico si es necesario
        // Actualmente, este método sólo llama a consultarProyectos
        consultarProyectos();
    }

    private void consultarProyectos() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Nombre", "Fec Inicio", "Fec Termino", "Departamento", "Ingeniero"}, 0);
        try {
            ResultSet rs = proyectoDAO.obtenerTodosLosProyectos();
            while (rs.next()) {
                int id = rs.getInt("IDProy");
                String nombre = rs.getString("Nombre");
                String fecInicio = rs.getString("Fec_Inicio");
                String fecTermino = rs.getString("Fec_Termino");
                int idDpto = rs.getInt("IDDpto");
                int idIng = rs.getInt("IDIng");
                String departamento = departamentosMap.get(idDpto);
                String ingeniero = ingenierosMap.get(idIng);
                model.addRow(new Object[]{id, nombre, fecInicio, fecTermino, departamento, ingeniero});
            }
            table.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al consultar proyectos: " + e.getMessage());
        }
    }

    private void limpiarCampos() {
        txtIdProy.setText("");
        txtNombre.setText("");
        txtFecInicio.setText("");
        txtFecTermino.setText("");
        comboDepartamentos.setSelectedIndex(-1);
        comboIngenieros.setSelectedIndex(-1);
    }

    private void cargarDatosSeleccionados() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            txtIdProy.setText(table.getValueAt(selectedRow, 0).toString());
            txtNombre.setText(table.getValueAt(selectedRow, 1).toString());
            txtFecInicio.setText(table.getValueAt(selectedRow, 2).toString());
            txtFecTermino.setText(table.getValueAt(selectedRow, 3).toString());
            String departamento = (String) table.getValueAt(selectedRow, 4);
            String ingeniero = (String) table.getValueAt(selectedRow, 5);
            comboDepartamentos.setSelectedItem(departamento);
            comboIngenieros.setSelectedItem(ingeniero);
        }
    }

    private void cargarDepartamentos() {
        try {
            ResultSet rs = departamentoDAO.obtenerNombresYIdsDeDepartamentos();
            comboDepartamentos.removeAllItems();
            departamentosMap.clear();
            while (rs.next()) {
                int idDpto = rs.getInt("IDDpto");
                String nombre = rs.getString("Nombre");
                departamentosMap.put(idDpto, nombre); // Guardar el ID y el nombre en el mapa
                comboDepartamentos.addItem(nombre);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar departamentos: " + e.getMessage());
        }
    }

    private void cargarIngenieros() {
        try {
            ResultSet rs = ingenieroDAO.obtenerTodosLosIngenieros();
            comboIngenieros.removeAllItems();
            ingenierosMap.clear();
            while (rs.next()) {
                int idIng = rs.getInt("IDIng");
                String nombre = rs.getString("Nombre");
                ingenierosMap.put(idIng, nombre); // Guardar el ID y el nombre en el mapa
                comboIngenieros.addItem(nombre);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar ingenieros: " + e.getMessage());
        }
    }

    private int obtenerIdSeleccionado(Map<Integer, String> map, String valor) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().equals(valor)) {
                return entry.getKey();
            }
        }
        return -1; // ID no encontrado
    }
}
