package dao;

import conexion.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IngenieroProyectoDAO {
    private Connection connection;

    public IngenieroProyectoDAO() {
        Conectar conectar = new Conectar();
        this.connection = conectar.getConexion();
    }

    public ResultSet obtenerIngenierosPorProyecto(int idProy) {
        String sql = "SELECT Ingenieros.IDIng, Ingenieros.Nombre, Ingenieros.Especialidad, Ingenieros.Cargo, Departamentos.Nombre AS NombreDpto " +
                     "FROM Ingenieros " +
                     "JOIN Proyectos ON Ingenieros.IDIng = Proyectos.IDIng " +
                     "JOIN Departamentos ON Ingenieros.IDDpto = Departamentos.IDDpto " +
                     "WHERE Proyectos.IDProy = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idProy);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
