package controller;

import dao.EventoDao;
import model.Evento;
import view.ListaEventoPorDiaView;

import java.util.ArrayList;

public class ListaEventoPorDiaController {

    private final ListaEventoPorDiaView ledv;

    public ListaEventoPorDiaController() {
        ledv = new ListaEventoPorDiaView();
    }

    public void run() {
        EventoDao ed = new EventoDao();
        ArrayList<Evento> eventos = ed.listarEventos2025DiaSemana("Quarta");
        ledv.showEvents(eventos);
    }
}
