package Sistema_de_Livaria;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        //Adicionado autores
        Autor autor1 = new Autor(1, "Charles soule", new Date());
        Autor autor2 = new Autor(2, "Charle Bukowski", new Date());

        biblioteca.adicionarAutor(autor1);
        biblioteca.adicionarAutor(autor2);

        //Adicionado livros
        Livro livro1 = new Livro(1, "Luz dos Jedi", autor1);
        Livro livro2 = new Livro(2, "Misto Quente", autor2);
        Livro livro3 = new Livro(3, "Fabulário geral do delírio cotidiano", autor2);

        biblioteca.adicionaLivro(livro1);
        biblioteca.adicionaLivro(livro2);
        biblioteca.adicionaLivro(livro3);

        // Criando clientes
        Cliente cliente1 = new Cliente(1, "Maria Silva", new Date(), "maria@email.com");
        Cliente cliente2 = new Cliente(2, "Joana Lima", new Date(), "joana@email.com");

        biblioteca.adicionarCliente(cliente1);
        biblioteca.adicionarCliente(cliente2);

        //Realizando empréstimo
        biblioteca.emprestimoLivros(livro1, cliente1);

        List<Emprestimo> emprestimosDoCliente = biblioteca.buscarEmprestimoPorCliente(1);
        for (Emprestimo emprestimo : emprestimosDoCliente) {
            System.out.println("Livro: " + emprestimo.getLivro().getTitulo() + " | Empréstimo: " + emprestimo.getDataEmprestimo() + " | Devolvido: " + (emprestimo.isAtivo() ? "Não" : "Sim"));

        }

        // Loop de interação
        while (true) {
            System.out.println("Deseja ver livros disponíveis no momento? (sim/não)");
            String resposta = scanner.next().toLowerCase();

            if (resposta.equals("sim")) {
                List<Livro> livrosDisponiveis = biblioteca.listarLivrosDisponiveis();

                if (livrosDisponiveis.isEmpty()) {
                    System.out.println("Não há livros disponíveis.");
                } else {
                    System.out.println("Livros disponíveis: ");
                    for (Livro livro : livrosDisponiveis) {
                        System.out.println(livro.getId() + ": " + livro.getTitulo());
                    }

                    System.out.println("Digite o ID do livro que você deseja emprestar: ");
                    int idLivro = scanner.nextInt();
                    scanner.nextLine(); // limpar buffer

                    Livro livroSelecionado = biblioteca.buscarLivrosPorId(idLivro);

                    if (livroSelecionado != null && livroSelecionado.isDisponivel()) {

                        // Mostrando clientes cadastrados
                        System.out.println("Clientes cadastrados:");
                        for (Cliente cliente : biblioteca.listarClientes()) {
                            System.out.println("ID: " + cliente.getId() + " | Nome: " + cliente.getNome());
                        }

                        System.out.println("Digite o ID do Cliente: ");
                        int idCliente = scanner.nextInt();
                        scanner.nextLine();

                        Cliente cliente = biblioteca.buscarClientePorId(idCliente);

                        if (cliente != null) {
                            biblioteca.emprestimoLivros(livroSelecionado, cliente);
                            System.out.println("O livro " + livroSelecionado.getTitulo() + " foi emprestado para " + cliente.getNome() + ".");
                        } else {
                            System.out.println("Cliente não encontrado.");
                        }
                    } else {
                        System.out.println("Livro não encontrado ou indisponível.");
                    }
                }
            } else if (resposta.equals("não")) {
                System.out.println("Obrigado por utilizar o sistema da biblioteca.");
                break;
            } else {
                System.out.println("Resposta inválida. Por favor, responda com 'sim' ou 'não'.");
            }
        }

        scanner.close();
    }
}
