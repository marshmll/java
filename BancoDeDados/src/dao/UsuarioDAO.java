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
        query = "INSERT INTO Usuario (nome, email) VALUES (?, ?)";

        try {
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
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
                String nome = rs.getString("nome");
                String email = rs.getString("email");

                Usuario u = new Usuario(id, email, nome);
                lista.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void atualizarUsuario(Usuario u) {
        query = "UPDATE Usuario SET nome = ?, email = ? WHERE id_usuario = ?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setInt(3, u.getIdUsuario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirUsuario(int idUsuario) {
        query = "DELETE FROM Usuario WHERE id_usuario = ?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, idUsuario);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
