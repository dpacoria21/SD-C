package dao;

import conexion.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IngenieroDAO {

    private Connection connection;

    public IngenieroDAO() {
        Conectar conectar = new Conectar();
        this.connection = conectar.getConexion();
    }

    public boolean insertarIngeniero(String nombre, String especialidad, String cargo, int idDpto) {
        String sql = "INSERT INTO Ingenieros (Nombre, Especialidad, Cargo, IDDpto) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setString(2, especialidad);
            statement.setString(3, cargo);
            statement.setInt(4, idDpto);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarIngeniero(int idIng, String nombre, String especialidad, String cargo, int idDpto) {
        String sql = "UPDATE Ingenieros SET Nombre = ?, Especialidad = ?, Cargo = ?, IDDpto = ? WHERE IDIng = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setString(2, especialidad);
            statement.setString(3, cargo);
            statement.setInt(4, idDpto);
            statement.setInt(5, idIng);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarIngeniero(int idIng) {
        String sql = "DELETE FROM Ingenieros WHERE IDIng = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idIng);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet obtenerTodosLosIngenieros() {
        String sql = "SELECT * FROM Ingenieros";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
