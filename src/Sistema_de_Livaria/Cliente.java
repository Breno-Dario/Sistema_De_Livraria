package Sistema_de_Livaria;

import java.util.Date;

public class Cliente {
    private int id;
    private String nome;
    private Date dataNascimento;
    private String email;

    public Cliente(int id, String nome, Date dataNascimento, String email){
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
        return "Cliente {" + ", NOME: " + nome + ", DATANASCIMENTO: " + dataNascimento + ", email" + email + '\'' + '}';

    }
}
