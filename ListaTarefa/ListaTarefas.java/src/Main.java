import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<String> tarefas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean executando = true;
        while (executando) {
            System.out.println("\n=== Lista de Tarefas ===");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Remover tarefa");
            System.out.println("3. Listar tarefas");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    adicionarTarefa();
                    break;
                case 2:
                    removerTarefa();
                    break;
                case 3:
                    listarTarefas();
                    break;
                case 4:
                    executando = false;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void adicionarTarefa() {
        System.out.print("Digite a tarefa a ser adicionada: ");
        String tarefa = scanner.nextLine();
        tarefas.add(tarefa);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    private static void removerTarefa() {
        if (tarefas.isEmpty()) {
            System.out.println("A lista está vazia. Nada para remover.");
            return;
        }
        listarTarefas();
        System.out.print("Digite o número da tarefa a ser removida: ");
        int indice = scanner.nextInt() - 1; // Ajustar para índice baseado em 0
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.remove(indice);
            System.out.println("Tarefa removida com sucesso!");
        } else {
            System.out.println("Número inválido.");
        }
    }

    private static void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("A lista de tarefas está vazia.");
        } else {
            System.out.println("Tarefas:");
            for (int i = 0; i < tarefas.size(); i++) {
                System.out.println((i + 1) + ". " + tarefas.get(i)); // ✅ Correção aqui
            }
        }
    }
}
