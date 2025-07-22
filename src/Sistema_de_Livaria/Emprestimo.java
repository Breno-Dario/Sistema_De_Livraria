package Sistema_de_Livaria;

import java.util.Date;

public class Emprestimo {
    private int id;
    private static int contadorId = 1;
    private Livro livro;
    private Cliente cliente;
    private String nomeUsuario;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private boolean ativo;

    public Emprestimo(Livro livro, Cliente cliente){
        this.id = contadorId++;
        this.livro = livro;
        this.cliente = cliente;
        this.dataEmprestimo = new Date();
        this.ativo = true;
    }

    //Método de devolver livro
    public void devolverLivro(){
        this.dataDevolucao = new Date();
        this.ativo = false;
        this.livro.setDisponivel(false);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getContadorId() {
        return contadorId;
    }

    public static void setContadorId(int contadorId) {
        Emprestimo.contadorId = contadorId;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getNomeUsuariario() {
        return nomeUsuario;
    }

    public void setNomeUsuariario(String nomeUsuariario) {
        this.nomeUsuario = nomeUsuariario;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolução) {
        this.dataDevolucao = dataDevolução;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public String toString(){
        return "Emprestimo{" + "ID: " + id + ", NOMEUSUARIO:" + nomeUsuario + '\'' + ", DATAEMPRESTIMO: " + dataEmprestimo + ", DATADEVOLUCAO: " + dataDevolucao + ", ATIVO: " + '}';

    }

}
