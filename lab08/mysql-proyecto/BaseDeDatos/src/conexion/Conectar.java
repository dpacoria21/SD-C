/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

/**
 *
 * @author GIGABYTE
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class Conectar {
    public static final String URL = "jdbc:mysql://database-1.c4xgpmh4ugnm.sa-east-1.rds.amazonaws.com:3306/EmpresaDB";
    public static final String USER = "admin";
    public static final String CLAVE = "72044250";

    public Connection getConexion() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }
}
