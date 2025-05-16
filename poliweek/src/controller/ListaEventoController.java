package controller;

import dao.EventoDao;
import model.Evento;
import view.ListaEventoView;

import java.util.ArrayList;

public class ListaEventoController {

    private final ListaEventoView lev;

    public ListaEventoController() {
        lev = new ListaEventoView();
    }

    public void run() {
        EventoDao ed = new EventoDao();
        ArrayList<Evento> eventos = ed.listarEventos2025();
        lev.showEvents(eventos);
    }
}
