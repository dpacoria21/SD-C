package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NoTransacciones {

    public static void main(String[] args) {
        try (Connection connection = Database.getConnection()) {
            // No se desactiva el auto-commit, las operaciones se cometen automáticamente
            try {
                int clienteId = insertarCliente(connection, "Juan Perez", "juan.perez@mail.com");
                insertarPedido(connection, clienteId, "Producto A", 5);
                insertarPedido(connection, clienteId, "Producto B", 3);

                // Simulación de error: inserción de un pedido con cantidad negativa
                insertarPedido(connection, clienteId, "Producto C", -1);

            } catch (SQLException ex) {
                System.err.println("ERROR: " + ex.getMessage());
                // No se realiza rollback, los cambios se mantienen en la base de datos
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private static int insertarCliente(Connection connection, String nombre, String correo) throws SQLException {
        String sql = "INSERT INTO clientes (nombre, correo) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, nombre);
            stmt.setString(2, correo);
            stmt.executeUpdate();
            try (var rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                } else {
                    throw new SQLException("No se pudo obtener el ID del cliente");
                }
            }
        }
    }

    private static void insertarPedido(Connection connection, int clienteId, String producto, int cantidad) throws SQLException {
        if (cantidad < 0) {
            throw new SQLException("La cantidad no puede ser negativa");
        }
        String sql = "INSERT INTO pedidos (cliente_id, producto, cantidad) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, clienteId);
            stmt.setString(2, producto);
            stmt.setInt(3, cantidad);
            stmt.executeUpdate();
        }
    }
}
