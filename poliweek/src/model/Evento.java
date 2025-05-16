package model;

public class Evento {
    private int idEvento;
    private int tipo;
    private String curso;
    private String titulo;
    private String descricao;
    private String diaSemana;
    private String inicio;
    private String termino;
    private String turno;
    private String palestrante;
    private int publico;
    private String localizacao;
    private int vagas;
    private String softwareEquipamento;
    private String datahora;

    public Evento(int idEvento, int tipo, String curso, String titulo, String descricao, String diaSemana, String inicio, String termino, String turno, String palestrante, int publico, String localizacao, int vagas, String softwareEquipamento, String datahora) {
        this.idEvento = idEvento;
        this.tipo = tipo;
        this.curso = curso;
        this.titulo = titulo;
        this.descricao = descricao;
        this.diaSemana = diaSemana;
        this.inicio = inicio;
        this.termino = termino;
        this.turno = turno;
        this.palestrante = palestrante;
        this.publico = publico;
        this.localizacao = localizacao;
        this.vagas = vagas;
        this.softwareEquipamento = softwareEquipamento;
        this.datahora = datahora;
    }

    public Evento(int tipo, String curso, String titulo, String descricao, String diaSemana, String inicio, String termino, String turno, String palestrante, int publico, String localizacao, int vagas, String softwareEquipamento, String datahora) {
        this.tipo = tipo;
        this.curso = curso;
        this.titulo = titulo;
        this.descricao = descricao;
        this.diaSemana = diaSemana;
        this.inicio = inicio;
        this.termino = termino;
        this.turno = turno;
        this.palestrante = palestrante;
        this.publico = publico;
        this.localizacao = localizacao;
        this.vagas = vagas;
        this.softwareEquipamento = softwareEquipamento;
        this.datahora = datahora;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getTermino() {
        return termino;
    }

    public void setTermino(String termino) {
        this.termino = termino;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getPalestrante() {
        return palestrante;
    }

    public void setPalestrante(String palestrante) {
        this.palestrante = palestrante;
    }

    public int getPublico() {
        return publico;
    }

    public void setPublico(int publico) {
        this.publico = publico;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public String getSoftwareEquipamento() {
        return softwareEquipamento;
    }

    public void setSoftwareEquipamento(String softwareEquipamento) {
        this.softwareEquipamento = softwareEquipamento;
    }

    public String getDatahora() {
        return datahora;
    }

    public void setDatahora(String datahora) {
        this.datahora = datahora;
    }
}
