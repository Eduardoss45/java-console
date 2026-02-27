import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Tarefa> tarefas = new ArrayList<>();
        int proximoId = 0;

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 5) {
            mostrarMenu();
            System.out.println("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        scanner.nextLine();
                        TarefaManager.criarTarefa(tarefas, scanner, proximoId++);
                        break;
                    case 2:
                        TarefaManager.listarTarefas(tarefas);
                        break;
                    case 3:
                        // ! Ação
                        break;
                    case 4:
                        // ! Ação
                        break;
                    case 5:
                        // ! Ação
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } else {
                System.out.println("Por favor, digite um número válido.");
                scanner.next();
                opcao = -1;
            }
        }
        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("1. Criar tarefa");
        System.out.println("2. Listar tarefa");
        System.out.println("3. Editar tarefa");
        System.out.println("4. Excluir tarefa");
        System.out.println("5. Sair");
    }

}