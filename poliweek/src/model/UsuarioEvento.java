package model;

public class UsuarioEvento {
    private int idUsuarioEvento;
    private int idUsuario;
    private int idEvento;
    private int checkin;
    private String datahora;

    public UsuarioEvento(int idUsuarioEvento, int idUsuario, int idEvento, int checkin, String datahora) {
        this.idUsuarioEvento = idUsuarioEvento;
        this.idUsuario = idUsuario;
        this.idEvento = idEvento;
        this.checkin = checkin;
        this.datahora = datahora;
    }

    public UsuarioEvento(int idUsuario, int idEvento, int checkin, String datahora) {
        this.idUsuario = idUsuario;
        this.idEvento = idEvento;
        this.checkin = checkin;
        this.datahora = datahora;
    }

    public int getIdUsuarioEvento() {
        return idUsuarioEvento;
    }

    public void setIdUsuarioEvento(int idUsuarioEvento) {
        this.idUsuarioEvento = idUsuarioEvento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getCheckin() {
        return checkin;
    }

    public void setCheckin(int checkin) {
        this.checkin = checkin;
    }

    public String getDatahora() {
        return datahora;
    }

    public void setDatahora(String datahora) {
        this.datahora = datahora;
    }
}
