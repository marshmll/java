package view;

import model.Evento;

import java.util.ArrayList;

public class ListaEventoPorDiaView {

    public void showEvents(ArrayList<Evento> eventos) {
        System.out.println("** EVENTOS ***");

        for (Evento evento : eventos) {
            System.out.println("=====================================================");
            System.out.println("id_evento: " + evento.getIdEvento());
            System.out.println("tipo: " + evento.getTipo());
            System.out.println("curso: " + evento.getCurso());
            System.out.println("titulo: " + evento.getTitulo());
            System.out.println("descricao: " + evento.getDescricao());
            System.out.println("dia_semana: " + evento.getDiaSemana());
            System.out.println("inicio: " + evento.getInicio());
            System.out.println("termino: " + evento.getTermino());
            System.out.println("turno: " + evento.getTurno());
            System.out.println("palestrante: " + evento.getPalestrante());
            System.out.println("publico: " + evento.getPublico());
            System.out.println("localizacao: " + evento.getLocalizacao());
            System.out.println("vagas: " + evento.getVagas());
            System.out.println("software_equipamento: " + evento.getSoftwareEquipamento());
            System.out.println("data_hora: " + evento.getDatahora());
        }

        System.out.println("=====================================================");
    }
}
