package gui;

import dao.DepartamentoDAO;
import dao.IngenieroDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class IngenieroForm extends JPanel {
    private JTextField txtNombre, txtEspecialidad, txtCargo, txtIdIng;
    private JComboBox<String> comboDepartamentos;
    private JButton btnInsertar, btnActualizar, btnEliminar, btnConsultar, btnRefrescar, btnLimpiar;
    private JTable table;
    private IngenieroDAO ingenieroDAO;
    private DepartamentoDAO departamentoDAO;
    private Map<Integer, String> departamentosMap; // Map para almacenar IDs de departamentos y sus nombres

    public IngenieroForm() {
        ingenieroDAO = new IngenieroDAO();
        departamentoDAO = new DepartamentoDAO();
        departamentosMap = new HashMap<>();
        initComponents();
        consultarIngenieros(); // Mostrar la lista de ingenieros al iniciar
        cargarDepartamentos(); // Cargar los departamentos en el combo box
    }

    private void initComponents() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel panelForm = new JPanel();
        panelForm.setLayout(new BoxLayout(panelForm, BoxLayout.Y_AXIS));
        
        panelForm.add(new JLabel("ID Ingeniero:"));
        txtIdIng = new JTextField(20);
        txtIdIng.setEditable(false); // Bloquear el campo de ID
        panelForm.add(txtIdIng);

        panelForm.add(new JLabel("Nombre:"));
        txtNombre = new JTextField(20);
        panelForm.add(txtNombre);

        panelForm.add(new JLabel("Especialidad:"));
        txtEspecialidad = new JTextField(20);
        panelForm.add(txtEspecialidad);

        panelForm.add(new JLabel("Cargo:"));
        txtCargo = new JTextField(20);
        panelForm.add(txtCargo);

        panelForm.add(new JLabel("Departamento:"));
        comboDepartamentos = new JComboBox<>();
        panelForm.add(comboDepartamentos);

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
                insertarIngeniero();
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarIngeniero();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarIngeniero();
            }
        });

        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarIngeniero();
            }
        });

        btnRefrescar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarIngenieros();
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

    private void insertarIngeniero() {
        String nombre = txtNombre.getText();
        String especialidad = txtEspecialidad.getText();
        String cargo = txtCargo.getText();
        String departamento = (String) comboDepartamentos.getSelectedItem();
        int idDpto = obtenerIdSeleccionado(departamentosMap, departamento);
        if (nombre.isEmpty() || especialidad.isEmpty() || cargo.isEmpty() || idDpto == -1) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
            return;
        }
        if (ingenieroDAO.insertarIngeniero(nombre, especialidad, cargo, idDpto)) {
            JOptionPane.showMessageDialog(this, "Ingeniero insertado con éxito");
            consultarIngenieros();
            limpiarCampos();
        }
    }

    private void actualizarIngeniero() {
        int idIng;
        try {
            idIng = Integer.parseInt(txtIdIng.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Seleccione un ingeniero válido.");
            return;
        }
        String nombre = txtNombre.getText();
        String especialidad = txtEspecialidad.getText();
        String cargo = txtCargo.getText();
        String departamento = (String) comboDepartamentos.getSelectedItem();
        int idDpto = obtenerIdSeleccionado(departamentosMap, departamento);
        if (nombre.isEmpty() || especialidad.isEmpty() || cargo.isEmpty() || idDpto == -1) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
            return;
        }
        if (ingenieroDAO.actualizarIngeniero(idIng, nombre, especialidad, cargo, idDpto)) {
            JOptionPane.showMessageDialog(this, "Ingeniero actualizado con éxito");
            consultarIngenieros();
            limpiarCampos();
        }
    }

    private void eliminarIngeniero() {
        int idIng;
        try {
            idIng = Integer.parseInt(txtIdIng.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Seleccione un ingeniero válido.");
            return;
        }
        if (ingenieroDAO.eliminarIngeniero(idIng)) {
            JOptionPane.showMessageDialog(this, "Ingeniero eliminado con éxito");
            consultarIngenieros();
            limpiarCampos();
        }
    }

    private void consultarIngeniero() {
        // Puedes implementar la lógica para buscar un ingeniero específico si es necesario
        // Actualmente, este método sólo llama a consultarIngenieros
        consultarIngenieros();
    }

    private void consultarIngenieros() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Nombre", "Especialidad", "Cargo", "Departamento"}, 0);
        try {
            ResultSet rs = ingenieroDAO.obtenerTodosLosIngenieros();
            while (rs.next()) {
                int id = rs.getInt("IDIng");
                String nombre = rs.getString("Nombre");
                String especialidad = rs.getString("Especialidad");
                String cargo = rs.getString("Cargo");
                int idDpto = rs.getInt("IDDpto");
                String departamento = departamentosMap.get(idDpto);
                model.addRow(new Object[]{id, nombre, especialidad, cargo, departamento});
            }
            table.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al consultar ingenieros: " + e.getMessage());
        }
    }

    private void limpiarCampos() {
        txtIdIng.setText("");
        txtNombre.setText("");
        txtEspecialidad.setText("");
        txtCargo.setText("");
        comboDepartamentos.setSelectedIndex(-1);
    }

    private void cargarDatosSeleccionados() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            txtIdIng.setText(table.getValueAt(selectedRow, 0).toString());
            txtNombre.setText(table.getValueAt(selectedRow, 1).toString());
            txtEspecialidad.setText(table.getValueAt(selectedRow, 2).toString());
            txtCargo.setText(table.getValueAt(selectedRow, 3).toString());
            String departamento = (String) table.getValueAt(selectedRow, 4);
            comboDepartamentos.setSelectedItem(departamento);
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

    private int obtenerIdSeleccionado(Map<Integer, String> map, String valor) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().equals(valor)) {
                return entry.getKey();
            }
        }
        return -1; // ID no encontrado
    }
}
