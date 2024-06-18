package dao;

import conexion.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProyectoDAO {

    private Connection connection;

    public ProyectoDAO() {
        Conectar conectar = new Conectar();
        this.connection = conectar.getConexion();
    }

    public boolean insertarProyecto(String nombre, String fec_inicio, String fec_termino, int idIng) {
        String sql = "INSERT INTO Proyectos (Nombre, Fec_Inicio, Fec_Termino, IDDpto, IDIng) VALUES (?, ?, ?, (SELECT IDDpto FROM Ingenieros WHERE IDIng = ?), ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setString(2, fec_inicio);
            statement.setString(3, fec_termino);
            statement.setInt(4, idIng);
            statement.setInt(5, idIng);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarProyecto(int idProy, String nombre, String fec_inicio, String fec_termino, int idIng) {
        String sql = "UPDATE Proyectos SET Nombre = ?, Fec_Inicio = ?, Fec_Termino = ?, IDDpto = (SELECT IDDpto FROM Ingenieros WHERE IDIng = ?), IDIng = ? WHERE IDProy = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setString(2, fec_inicio);
            statement.setString(3, fec_termino);
            statement.setInt(4, idIng);
            statement.setInt(5, idIng);
            statement.setInt(6, idProy);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarProyecto(int idProy) {
        String sql = "DELETE FROM Proyectos WHERE IDProy = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idProy);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet obtenerTodosLosProyectos() {
        String sql = "SELECT * FROM Proyectos";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ResultSet obtenerProyectoPorId(int idProy) {
        String sql = "SELECT * FROM Proyectos WHERE IDProy = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idProy);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet obtenerProyectosPorDepartamento(int idDpto) {
        String sql = "SELECT * FROM Proyectos WHERE IDDpto = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idDpto);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public ResultSet obtenerNombresYIdsDeProyectos() {
        String sql = "SELECT IDProy, Nombre FROM Proyectos";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
