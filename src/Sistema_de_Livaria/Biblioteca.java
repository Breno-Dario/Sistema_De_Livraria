package Sistema_de_Livaria;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();


    public void adicionaLivro(Livro livro){
        livros.add(livro);
    }

    //Lista todos os livros
    public List<Livro> listarLivro(){
        return  livros;
    }

    //Lista todos os livros disponiveis
    public List<Livro> listarLivrosDisponiveis(){
        List<Livro> livroDisponiveis = new ArrayList<>();
        for (Livro livro : livros){
            if (livro.isDisponivel()){
                livroDisponiveis.add(livro);
            }
        }

        return  livroDisponiveis;
    }

    //Busca o livro pelo ID
    public Livro buscarLivrosPorId(int id){
        for (Livro livro : livros){
            if (livro.getId() == id){
                return livro;
            }
        }
        return null;

    }

    //Atualização de livros
    public Livro atualizarLivro(int id, String novoTitulo){
        for (Livro livro : livros){
            if (livro.getId() == id){
                livro.setTitulo(novoTitulo);
                break;
            }
        }
        return null;
    }

    //Remover livro
    public void removerLivro(int id){
        livros.removeIf(livro -> livro.getId() == id);
    }

    //Adicionar autor
    public void adicionarAutor(Autor autor){
        autores.add(autor);
    }

    //Listar todos os autores
    public List<Autor> listarAutores(){
        return autores;
    }

    //Atualizando o nome do autor
    public void atualizarAutor(int id, String novoAutor){
        for (Autor autor : autores){
            if (autor.getId() == id){
                autor.setNomeAutor(novoAutor);
            }
        }
    }

    //Remover o autor
    public void removerAutor(int id){
        autores.removeIf(autor ->  autor.getId() == id);
    }

    //Emprestimo de livro
    public void emprestimoLivros(Livro livro, Cliente cliente){
        if(livro.isDisponivel()) {
            Emprestimo emprestimo = new Emprestimo(livro, cliente);
            emprestimos.add(emprestimo);
            livro.setDisponivel(false);
        }else {
            System.out.println("Livro não disponível no momento!");
        }
    }

    //Devolver Livro
    public void devolverLivro(int idEmprestimo){
        for(Emprestimo emprestimo : emprestimos){
            if(emprestimo.getId() == idEmprestimo && emprestimo.isAtivo());
            emprestimo.devolverLivro();
            break;
        }
    }

    //Lista todos os emprétimos
    public List<Emprestimo> listarEmprestimos(){
        return emprestimos;
    }

    //Adiconar Cliente
    public  void adicionarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    //Lista todos os clietes
    public List<Cliente> listarClientes(){
        return  clientes;
    }

    //Busca Cliente
    public Cliente buscarClientePorId(int id){
        for(Cliente cliente : clientes){
            if (cliente.getId() == id){
                return  cliente;
            }
        }
        return null;
    }

    //Busca histórico do emprestimo dos livros por cliente
    public List<Emprestimo> buscarEmprestimoPorCliente(int clienteId){
        List<Emprestimo> historico = new ArrayList<>();
        for(Emprestimo emprestimo : emprestimos){
            if (emprestimo.getCliente().getId() == clienteId){
                historico.add(emprestimo);
            }
        }
        return  historico;
    }

    //Buscar o historico só do livros emprestados
    public List<Emprestimo> buscarEmprestimosPorLivro(int livroId){
        List<Emprestimo> historico = new ArrayList<>();
        for(Emprestimo emprestimo : emprestimos ) {
            if(emprestimo.getLivro().getId() == livroId){
                historico.add(emprestimo);
            }
        }
        return  historico;
    }



}
