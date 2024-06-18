package dao;

import conexion.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartamentoDAO {

    private Connection connection;

    public DepartamentoDAO() {
        Conectar conectar = new Conectar();
        this.connection = conectar.getConexion();
    }

    public boolean insertarDepartamento(String nombre, String telefono, String fax) {
        String sql = "INSERT INTO Departamentos (Nombre, Telefono, Fax) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setString(2, telefono);
            statement.setString(3, fax);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarDepartamento(int idDpto, String nombre, String telefono, String fax) {
        String sql = "UPDATE Departamentos SET Nombre = ?, Telefono = ?, Fax = ? WHERE IDDpto = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setString(2, telefono);
            statement.setString(3, fax);
            statement.setInt(4, idDpto);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarDepartamento(int idDpto) {
        String sql = "DELETE FROM Departamentos WHERE IDDpto = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idDpto);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet obtenerTodosLosDepartamentos() {
        String sql = "SELECT * FROM Departamentos";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet obtenerNombresYIdsDeDepartamentos() {
        String sql = "SELECT IDDpto, Nombre FROM Departamentos";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
