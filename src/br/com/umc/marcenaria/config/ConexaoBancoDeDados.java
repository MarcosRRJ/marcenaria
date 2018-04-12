package br.com.umc.marcenaria.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBancoDeDados {

	public Connection getConnection() {

		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "HR",
					"HR");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
