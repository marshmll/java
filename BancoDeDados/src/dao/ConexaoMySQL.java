package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
    private static ConexaoMySQL conexaoMySQL;
    private Connection conexao;

    private ConexaoMySQL() {
        try {
            conexao = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/rede_social?useSSL=false",
                    "root",
                    "PUC@1234"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ConexaoMySQL getInstance() {
        if (conexaoMySQL == null) {
            conexaoMySQL = new ConexaoMySQL();
        }

        return conexaoMySQL;
    }

    public Connection getConexao() {
        return conexao;
    }
}
