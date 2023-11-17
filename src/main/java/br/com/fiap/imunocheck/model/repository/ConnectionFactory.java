package br.com.fiap.imunocheck.model.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Classe que cria a conexão com o banco de dados
 * @author Luiz Fillipe
 * @version 3.0
 */
public class ConnectionFactory {
    private static ConnectionFactory instance;
    private Connection conexao;
    private String url;
    private String user;
    private String pass;
    private String driver;

    private ConnectionFactory(String url, String user, String pass, String driver) {
        this.url = url;
        this.user = user;
        this.pass = pass;
        this.driver = driver;
    }
    

    /**
     * Método que inicia o login com o banco de dados
     * @return Instância da ConnectionFactory
     */
    public static ConnectionFactory getInstance() {
        if (instance == null) {
            Properties prop = new Properties();
            try (FileInputStream file = new FileInputStream("./src/main/resources/aplication.properties")) {
                prop.load(file);
                String url = prop.getProperty("datasource.url");
                String user = prop.getProperty("datasource.username");
                String pass = prop.getProperty("datasource.password");
                String driver = prop.getProperty("datasource.driver-class-name");
                instance = new ConnectionFactory(url, user, pass, driver);
            } catch (IOException e) {
                System.out.println("Erro ao carregar o arquivo de propriedades: " + e.getMessage());
            }
        }
        return instance;
    }

    /**
     * Método que abre a conexão com o banco de dados e verifica erros de login e SQL.
     * @return Conexão com o banco de dados
     */
    public Connection getConexao() {
        try {
            if (this.conexao != null && !this.conexao.isClosed()) {
                return this.conexao;
            }
            if (this.getDriver() == null || this.getDriver().equals("")) {
                System.out.println("Erro: nome da classe");
                throw new RuntimeException("Erro: nome da classe");
            }
            if (this.getUrl() == null || this.getUrl().equals("")) {
                System.out.println("Erro: Url de conexao");
                throw new RuntimeException("Erro: Url de conexao");
            }
            if (this.getUser() == null || this.getUser().equals("")) {
                System.out.println("Erro: Usuario incorreto");
                throw new RuntimeException("Erro: Usuario incorreto");
            }
            Class.forName(this.getDriver());
            this.conexao = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
        } catch (ClassNotFoundException e) {
            System.out.println("Erro nome da classe: " + e.getMessage());
            System.exit(1);
        } catch (SQLException e) {
            System.out.println("Erro no SQL: " + e.getMessage());
            System.exit(1);
        }
        return conexao;
    }

    private String getPass() {
        return pass;
    }

    private String getDriver() {
        return driver;
    }

    private String getUrl() {
        return url;
    }

    private String getUser() {
        return user;
    }
}
