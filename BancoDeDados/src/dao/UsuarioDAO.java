package dao;

import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {
    private Connection conexao;
    private String query;

    public UsuarioDAO() {
        conexao = ConexaoMySQL.getInstance().getConexao();
    }

    public void criarUsuario(Usuario usuario) {
        query = "INSERT INTO Usuario (email, senha) VALUES(?, ?)";

        try {
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getSenha());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Usuario> listarUsuarios() {
        query = "SELECT * FROM Usuario";
        ArrayList<Usuario> lista = new ArrayList<>();

        try {
            PreparedStatement stmt = conexao.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_usuario");
                String email = rs.getString("email");
                String senha = rs.getString("senha");

                Usuario u = new Usuario(email, senha);
                u.setIdUsuario(id);

                lista.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
