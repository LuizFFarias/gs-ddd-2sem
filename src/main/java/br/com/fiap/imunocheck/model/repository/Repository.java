package br.com.fiap.imunocheck.model.repository;

import java.sql.Connection;

/***
 * Classe responsável pela conexão do projeto com o banco de dados
 * @author Luiz Fillipe
 */

public abstract class Repository {
	
	protected static Connection connection;
	
	public Repository () {
		getConnection();
	}
	
	/***
	 * Método que abre a conexão com o banco de dados
	 * @author Luiz Fillipe
	 */
	public static Connection getConnection() {
		try {
			connection = ConnectionFactory.getInstance().getConexao();
			return connection;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	/***
	 * Método que fecha a conexão com o banco de dados
	 * @author Luiz Fillipe
	 */
	public static void closeConnection() {
		try {
			if (!connection.isClosed()) {
				connection.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
