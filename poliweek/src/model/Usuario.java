package model;

public class Usuario {
    private int idUsuario;
    private String nome;
    private String email;
    private String curso;
    private String senha;
    private String nivelAcesso;
    private int confirmacao;
    private int tokenConfirmacao;
    private int tokenRecurepacao;
    private String datahora;

    public Usuario(String nome, String email, String curso, String senha, String nivelAcesso, int confirmacao, int tokenConfirmacao, int tokenRecurepacao, String datahora) {
        this.nome = nome;
        this.email = email;
        this.curso = curso;
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
        this.confirmacao = confirmacao;
        this.tokenConfirmacao = tokenConfirmacao;
        this.tokenRecurepacao = tokenRecurepacao;
        this.datahora = datahora;
    }

    public Usuario(int idUsuario, String nome, String email, String curso, String senha, String nivelAcesso, int confirmacao, int tokenConfirmacao, int tokenRecurepacao, String datahora) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.curso = curso;
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
        this.confirmacao = confirmacao;
        this.tokenConfirmacao = tokenConfirmacao;
        this.tokenRecurepacao = tokenRecurepacao;
        this.datahora = datahora;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public int getConfirmacao() {
        return confirmacao;
    }

    public void setConfirmacao(int confirmacao) {
        this.confirmacao = confirmacao;
    }

    public int getTokenConfirmacao() {
        return tokenConfirmacao;
    }

    public void setTokenConfirmacao(int tokenConfirmacao) {
        this.tokenConfirmacao = tokenConfirmacao;
    }

    public int getTokenRecurepacao() {
        return tokenRecurepacao;
    }

    public void setTokenRecurepacao(int tokenRecurepacao) {
        this.tokenRecurepacao = tokenRecurepacao;
    }

    public String getDatahora() {
        return datahora;
    }

    public void setDatahora(String datahora) {
        this.datahora = datahora;
    }
}
