package dao;

import model.Evento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EventoDao {
    Connection conn;

    public EventoDao() {
        conn = ConexaoMySQL.getInstance().getConexao();
    }

    public ArrayList<Evento> listarEventos2025() {
        ArrayList<Evento> eventos = new ArrayList<>();

        try {
            String query = "SELECT * FROM evento WHERE data_hora BETWEEN '2024-12-31' AND '2026-01-01'";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                eventos.add(new Evento(
                        rs.getInt("id_evento"),
                        rs.getInt("tipo"),
                        rs.getString("curso"),
                        rs.getString("titulo"),
                        rs.getString("descricao"),
                        rs.getString("dia_semana"),
                        rs.getString("inicio"),
                        rs.getString("termino"),
                        rs.getString("turno"),
                        rs.getString("palestrante"),
                        rs.getInt("publico"),
                        rs.getString("localizacao"),
                        rs.getInt("vagas"),
                        rs.getString("software_equipamento"),
                        rs.getString("data_hora")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return eventos;
    }

    public ArrayList<Evento> listarEventos2025DiaSemana(String dia) {
        ArrayList<Evento> eventos = new ArrayList<>();

        try {
            String query = "SELECT * FROM evento WHERE dia_semana = ? AND data_hora BETWEEN '2024-12-31' AND '2026-01-01'";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, dia);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                eventos.add(new Evento(
                        rs.getInt("id_evento"),
                        rs.getInt("tipo"),
                        rs.getString("curso"),
                        rs.getString("titulo"),
                        rs.getString("descricao"),
                        rs.getString("dia_semana"),
                        rs.getString("inicio"),
                        rs.getString("termino"),
                        rs.getString("turno"),
                        rs.getString("palestrante"),
                        rs.getInt("publico"),
                        rs.getString("localizacao"),
                        rs.getInt("vagas"),
                        rs.getString("software_equipamento"),
                        rs.getString("data_hora")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return eventos;
    }
}
