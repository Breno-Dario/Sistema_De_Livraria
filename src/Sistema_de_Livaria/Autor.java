package Sistema_de_Livaria;

import java.util.Date;

public class Autor {
    private int id;
    private String autor;
    private Date dataNascimento;

    public Autor(int id, String autor, Date dataNascimento){
        this.id = id;
        this.autor = autor;
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeAutor() {
        return autor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.autor = autor;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;

    }

    public String toString(){
        return "Autor{" + "ID:" + id + ", NOME:'" + autor + '\'' + ", DATANASCIMENTO:" + dataNascimento + '}';
    }


}
