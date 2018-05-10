package br.com.umc.marcenaria.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

public class ConexaoBancoDeDados {

	private DataSource dataSource;

	public ConexaoBancoDeDados() {
		OracleDataSource pool;
		try {
			pool = new OracleDataSource();
			pool.setURL("jdbc:oracle:thin:@localhost:1521:XE");
			pool.setUser("dataBaseTest");
			pool.setPassword("dataBaseTest");
			this.dataSource = pool;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public static Connection getConnection() throws SQLException {
//
//		Connection connection = dataSource.getConnection();
//		return connection;
//	}

	public Connection getConnection() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection connection = dataSource.getConnection();
//			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "dataBaseTest",
//					"dataBaseTest");
			return connection;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
			
		}
	}

}
