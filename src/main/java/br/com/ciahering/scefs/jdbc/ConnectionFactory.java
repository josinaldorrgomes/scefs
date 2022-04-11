package br.com.ciahering.scefs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/scefs", "scefs",
					"0sm3lh0r35@TI.2020<3");
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("Ocorreu um erro de SQLException na classe ConnectionFactory...", e);
		}
	}

}
