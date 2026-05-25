import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class ExerciciosJava {

    static class Livro {
        int codigo;
        String titulo;
        String autor;
        boolean disponivel;

        public Livro(int codigo, String titulo, String autor) {
            this.codigo = codigo;
            this.titulo = titulo;
            this.autor = autor;
            this.disponivel = true;
        }
    }

    static class Pedido {
        int numero;
        String nomeCliente;
        String itemPedido;
        double valor;
        String status;

        public Pedido(int numero, String nomeCliente, String itemPedido, double valor) {
            this.numero = numero;
            this.nomeCliente = nomeCliente;
            this.itemPedido = itemPedido;
            this.valor = valor;
            this.status = "PENDENTE";
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int exercicio = -1;

        while (exercicio != 0) {

            System.out.println("\n========= MENU DE EXERCÍCIOS JAVA =========");
            System.out.println("1 - Lista de compras com ArrayList");
            System.out.println("2 - Média de notas com ArrayList");
            System.out.println("3 - Alunos presentes com HashSet");
            System.out.println("4 - Cadastro de alunos com HashMap");
            System.out.println("5 - Fila de clientes com Queue");
            System.out.println("6 - Sistema de biblioteca");
            System.out.println("7 - Sistema de lanchonete");
            System.out.println("0 - Sair");
            System.out.print("Escolha um exercício: ");

            exercicio = scanner.nextInt();
            scanner.nextLine();

            switch (exercicio) {

                case 1:
                    listaDeCompras();
                    break;

                case 2:
                    mediaNotas();
                    break;

                case 3:
                    alunosPresentes();
                    break;

                case 4:
                    cadastroAlunos();
                    break;

                case 5:
                    filaClientes();
                    break;

                case 6:
                    sistemaBiblioteca(scanner);
                    break;

                case 7:
                    sistemaLanchonete(scanner);
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        scanner.close();
    }

    public static void listaDeCompras() {

        ArrayList<String> produtos = new ArrayList<>();

        produtos.add("Arroz");
        produtos.add("Feijão");
        produtos.add("Macarrão");
        produtos.add("Leite");
        produtos.add("Café");

        System.out.println("\nLista de compras:");

        for (String produto : produtos) {
            System.out.println("- " + produto);
        }

        System.out.println("Quantidade total de produtos: " + produtos.size());
    }

    public static void mediaNotas() {

        ArrayList<Double> notas = new ArrayList<>();

        notas.add(8.0);
        notas.add(7.5);
        notas.add(6.0);
        notas.add(9.0);

        double soma = 0;

        for (Double nota : notas) {
            soma = soma + nota;
        }

        double media = soma / notas.size();

        System.out.println("\nMédia da turma: " + media);

        if (media >= 7) {
            System.out.println("A turma ficou com média maior ou igual a 7.");
        } else {
            System.out.println("A turma ficou com média menor que 7.");
        }
    }

    public static void alunosPresentes() {

        HashSet<String> alunos = new HashSet<>();

        alunos.add("Ana");
        alunos.add("Carlos");
        alunos.add("Mariana");
        alunos.add("João");
        alunos.add("Ana");
        alunos.add("Carlos");

        System.out.println("\nAlunos presentes:");

        for (String aluno : alunos) {
            System.out.println("- " + aluno);
        }

        System.out.println("Quantidade de alunos presentes: " + alunos.size());
    }

    public static void cadastroAlunos() {

        HashMap<Integer, String> alunos = new HashMap<>();

        alunos.put(101, "Ana");
        alunos.put(102, "Carlos");
        alunos.put(103, "Mariana");
        alunos.put(104, "João");

        int matriculaBusca = 102;

        System.out.println("\nBuscando matrícula: " + matriculaBusca);

        if (alunos.containsKey(matriculaBusca)) {
            System.out.println("Aluno encontrado: " + alunos.get(matriculaBusca));
        } else {
            System.out.println("Aluno não encontrado.");
        }

        int matriculaRemover = 103;

        System.out.println("\nRemovendo matrícula: " + matriculaRemover);

        if (alunos.containsKey(matriculaRemover)) {
            alunos.remove(matriculaRemover);
            System.out.println("Aluno removido com sucesso.");
        } else {
            System.out.println("Matrícula não encontrada para remoção.");
        }

        System.out.println("\nAlunos cadastrados:");

        for (Integer matricula : alunos.keySet()) {
            System.out.println("Matrícula: " + matricula + " - Nome: " + alunos.get(matricula));
        }
    }

    public static void filaClientes() {

        Queue<String> fila = new LinkedList<>();

        fila.add("Ana");
        fila.add("Carlos");
        fila.add("Mariana");
        fila.add("João");
        fila.add("Pedro");

        System.out.println("\nPróximo cliente a ser atendido: " + fila.peek());

        System.out.println("Cliente atendido: " + fila.poll());
        System.out.println("Cliente atendido: " + fila.poll());

        System.out.println("\nFila atualizada:");

        for (String cliente : fila) {
            System.out.println("- " + cliente);
        }
    }

    public static void sistemaBiblioteca(Scanner scanner) {

        ArrayList<Livro> livros = new ArrayList<>();

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n===== SISTEMA DE BIBLIOTECA =====");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Emprestar livro");
            System.out.println("4 - Devolver livro");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    System.out.print("Digite o código do livro: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o título do livro: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Digite o autor do livro: ");
                    String autor = scanner.nextLine();

                    Livro novoLivro = new Livro(codigo, titulo, autor);
                    livros.add(novoLivro);

                    System.out.println("Livro cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("\n===== LIVROS CADASTRADOS =====");

                    if (livros.isEmpty()) {
                        System.out.println("Nenhum livro cadastrado.");
                    } else {
                        for (Livro livro : livros) {
                            System.out.println("Código: " + livro.codigo);
                            System.out.println("Título: " + livro.titulo);
                            System.out.println("Autor: " + livro.autor);

                            if (livro.disponivel) {
                                System.out.println("Status: Disponível");
                            } else {
                                System.out.println("Status: Indisponível");
                            }

                            System.out.println("-------------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Digite o código do livro que deseja emprestar: ");
                    int codigoEmprestimo = scanner.nextInt();

                    boolean encontradoEmprestimo = false;

                    for (Livro livro : livros) {
                        if (livro.codigo == codigoEmprestimo) {
                            encontradoEmprestimo = true;

                            if (livro.disponivel) {
                                livro.disponivel = false;
                                System.out.println("Livro emprestado com sucesso!");
                            } else {
                                System.out.println("Este livro já está emprestado.");
                            }
                        }
                    }

                    if (!encontradoEmprestimo) {
                        System.out.println("Livro não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Digite o código do livro que deseja devolver: ");
                    int codigoDevolucao = scanner.nextInt();

                    boolean encontradoDevolucao = false;

                    for (Livro livro : livros) {
                        if (livro.codigo == codigoDevolucao) {
                            encontradoDevolucao = true;

                            if (!livro.disponivel) {
                                livro.disponivel = true;
                                System.out.println("Livro devolvido com sucesso!");
                            } else {
                                System.out.println("Este livro já está disponível.");
                            }
                        }
                    }

                    if (!encontradoDevolucao) {
                        System.out.println("Livro não encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    public static void sistemaLanchonete(Scanner scanner) {

        HashMap<Integer, Pedido> pedidos = new HashMap<>();

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n===== SISTEMA DA LANCHONETE =====");
            System.out.println("1 - Cadastrar pedido");
            System.out.println("2 - Listar pedidos");
            System.out.println("3 - Atualizar status de um pedido");
            System.out.println("4 - Buscar pedido pelo número");
            System.out.println("5 - Mostrar valor total dos pedidos");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    System.out.print("Digite o número do pedido: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine();

                    if (pedidos.containsKey(numero)) {
                        System.out.println("Já existe um pedido com esse número.");
                    } else {
                        System.out.print("Digite o nome do cliente: ");
                        String nomeCliente = scanner.nextLine();

                        System.out.print("Digite o item pedido: ");
                        String itemPedido = scanner.nextLine();

                        System.out.print("Digite o valor do pedido: ");
                        double valor = scanner.nextDouble();
                        scanner.nextLine();

                        Pedido novoPedido = new Pedido(numero, nomeCliente, itemPedido, valor);

                        pedidos.put(numero, novoPedido);

                        System.out.println("Pedido cadastrado com sucesso!");
                    }
                    break;

                case 2:
                    System.out.println("\n===== LISTA DE PEDIDOS =====");

                    if (pedidos.isEmpty()) {
                        System.out.println("Nenhum pedido cadastrado.");
                    } else {
                        for (Pedido pedido : pedidos.values()) {
                            System.out.println("Número: " + pedido.numero);
                            System.out.println("Cliente: " + pedido.nomeCliente);
                            System.out.println("Item: " + pedido.itemPedido);
                            System.out.println("Valor: R$ " + pedido.valor);
                            System.out.println("Status: " + pedido.status);
                            System.out.println("----------------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Digite o número do pedido: ");
                    int numeroAtualizar = scanner.nextInt();

                    if (pedidos.containsKey(numeroAtualizar)) {
                        Pedido pedido = pedidos.get(numeroAtualizar);

                        System.out.println("\nStatus atual: " + pedido.status);
                        System.out.println("Escolha o novo status:");
                        System.out.println("1 - PENDENTE");
                        System.out.println("2 - PREPARANDO");
                        System.out.println("3 - FINALIZADO");
                        System.out.print("Opção: ");

                        int opcaoStatus = scanner.nextInt();

                        if (opcaoStatus == 1) {
                            pedido.status = "PENDENTE";
                            System.out.println("Status atualizado para PENDENTE.");
                        } else if (opcaoStatus == 2) {
                            pedido.status = "PREPARANDO";
                            System.out.println("Status atualizado para PREPARANDO.");
                        } else if (opcaoStatus == 3) {
                            pedido.status = "FINALIZADO";
                            System.out.println("Status atualizado para FINALIZADO.");
                        } else {
                            System.out.println("Opção de status inválida.");
                        }

                    } else {
                        System.out.println("Pedido não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Digite o número do pedido que deseja buscar: ");
                    int numeroBusca = scanner.nextInt();

                    if (pedidos.containsKey(numeroBusca)) {
                        Pedido pedido = pedidos.get(numeroBusca);

                        System.out.println("\n===== PEDIDO ENCONTRADO =====");
                        System.out.println("Número: " + pedido.numero);
                        System.out.println("Cliente: " + pedido.nomeCliente);
                        System.out.println("Item: " + pedido.itemPedido);
                        System.out.println("Valor: R$ " + pedido.valor);
                        System.out.println("Status: " + pedido.status);
                    } else {
                        System.out.println("Pedido não encontrado.");
                    }
                    break;

                case 5:
                    double total = 0;

                    for (Pedido pedido : pedidos.values()) {
                        total = total + pedido.valor;
                    }

                    System.out.println("Valor total dos pedidos: R$ " + total);
                    break;

                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
