package gui;

import dao.DepartamentoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DepartamentoForm extends JPanel {
    private JTextField txtNombre, txtTelefono, txtFax, txtIdDpto;
    private JButton btnInsertar, btnActualizar, btnEliminar, btnConsultar, btnRefrescar, btnLimpiar;
    private JTable table;
    private DepartamentoDAO departamentoDAO;

    public DepartamentoForm() {
        departamentoDAO = new DepartamentoDAO();
        initComponents();
        consultarDepartamentos(); // Mostrar la lista de departamentos al iniciar
    }

    private void initComponents() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel panelForm = new JPanel();
        panelForm.setLayout(new BoxLayout(panelForm, BoxLayout.Y_AXIS));
        
        panelForm.add(new JLabel("ID Departamento:"));
        txtIdDpto = new JTextField(20);
        txtIdDpto.setEditable(false); // Bloquear el campo de ID
        panelForm.add(txtIdDpto);

        panelForm.add(new JLabel("Nombre:"));
        txtNombre = new JTextField(20);
        panelForm.add(txtNombre);

        panelForm.add(new JLabel("Teléfono:"));
        txtTelefono = new JTextField(20);
        panelForm.add(txtTelefono);

        panelForm.add(new JLabel("Fax:"));
        txtFax = new JTextField(20);
        panelForm.add(txtFax);

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
                insertarDepartamento();
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarDepartamento();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarDepartamento();
            }
        });

        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarDepartamento();
            }
        });

        btnRefrescar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarDepartamentos();
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

    private void insertarDepartamento() {
        String nombre = txtNombre.getText();
        String telefono = txtTelefono.getText();
        String fax = txtFax.getText();
        if (nombre.isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre y teléfono son campos obligatorios.");
            return;
        }
        if (departamentoDAO.insertarDepartamento(nombre, telefono, fax)) {
            JOptionPane.showMessageDialog(this, "Departamento insertado con éxito");
            consultarDepartamentos();
            limpiarCampos();
        }
    }

    private void actualizarDepartamento() {
        int idDpto;
        try {
            idDpto = Integer.parseInt(txtIdDpto.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Seleccione un departamento válido.");
            return;
        }
        String nombre = txtNombre.getText();
        String telefono = txtTelefono.getText();
        String fax = txtFax.getText();
        if (nombre.isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre y teléfono son campos obligatorios.");
            return;
        }
        if (departamentoDAO.actualizarDepartamento(idDpto, nombre, telefono, fax)) {
            JOptionPane.showMessageDialog(this, "Departamento actualizado con éxito");
            consultarDepartamentos();
            limpiarCampos();
        }
    }

    private void eliminarDepartamento() {
        int idDpto;
        try {
            idDpto = Integer.parseInt(txtIdDpto.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Seleccione un departamento válido.");
            return;
        }
        if (departamentoDAO.eliminarDepartamento(idDpto)) {
            JOptionPane.showMessageDialog(this, "Departamento eliminado con éxito");
            consultarDepartamentos();
            limpiarCampos();
        }
    }

    private void consultarDepartamento() {
        // Puedes implementar la lógica para buscar un departamento específico si es necesario
        // Actualmente, este método sólo llama a consultarDepartamentos
        consultarDepartamentos();
    }

    private void consultarDepartamentos() {
    DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Nombre", "Teléfono", "Fax"}, 0);
    try {
        ResultSet rs = departamentoDAO.obtenerTodosLosDepartamentos();
        while (rs.next()) {
            int id = rs.getInt("IDDpto");
            String nombre = rs.getString("Nombre");
            String telefono = rs.getString("Telefono");
            String fax = rs.getString("Fax");
            model.addRow(new Object[]{id, nombre, telefono, fax});
        }
        table.setModel(model);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al consultar departamentos: " + e.getMessage());
    }
}


    private void limpiarCampos() {
        txtIdDpto.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtFax.setText("");
    }

    private void cargarDatosSeleccionados() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            txtIdDpto.setText(table.getValueAt(selectedRow, 0).toString());
            txtNombre.setText(table.getValueAt(selectedRow, 1).toString());
            txtTelefono.setText(table.getValueAt(selectedRow, 2).toString());
            txtFax.setText(table.getValueAt(selectedRow, 3).toString());
        }
    }
}