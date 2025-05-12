package dao;

import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {
    Connection conexao;

    public UsuarioDAO() {
        conexao = ConexaoMySQL.getInstance().getConexao();
    }

    public void cadastrarUsuario(Usuario usuario) {
        try {
            String query = "INSERT INTO Usuario (email, senha, data_hora) VALUES (?, ?, CURRENT_TIMESTAMP())";
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getSenha());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Usuario> listarUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {
            String query = "SELECT * FROM Usuario";
            PreparedStatement stmt = conexao.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                usuarios.add(
                        new Usuario(
                                rs.getInt("id_usuario"),
                                rs.getString("email"),
                                rs.getString("senha"),
                                rs.getString("data_hora")
                        )
                );
            }

            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return usuarios;
    }
}
