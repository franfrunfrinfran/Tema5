package es.Studium.Empresa;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class Modelo 
{
	// Conexión a la base de datos
		static String driver = "com.mysql.jdbc.Driver";
		static String url = "jdbc:mysql://localhost:3306/empresaed?autoReconnect=true&useSSL=false";
		static String usuario = "root";
		static String clave = "Studium2019;";
		static String sentencia = "";
		static Connection connection = null;
		static java.sql.Statement statement = null;
		static ResultSet rs = null;
}
