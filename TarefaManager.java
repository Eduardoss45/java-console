import java.util.ArrayList;
import java.util.Scanner;

public class TarefaManager {

    public static void criarTarefa(ArrayList<Tarefa> tarefas, Scanner scanner, int id) {
        String titulo = "";
        String descricao = "";

        System.out.println("Digite o nome da tarefa: ");
        titulo = scanner.nextLine();
        System.out.println("Prompt: " + titulo);

        System.out.println("Digite a descrição da tarefa: ");
        descricao = scanner.nextLine();
        System.out.println("Prompt: " + descricao);

        Tarefa t = new Tarefa(id, titulo, descricao);
        tarefas.add(t);
    }

    public static void listarTarefas(ArrayList<Tarefa> tarefas) {
        if (tarefas.size() == 0)
            System.out.println("Não existem tarefas salvas!");

        for (int i = 0; i < tarefas.size(); i++) {
            System.out.println(tarefas.get(i));
        }
    }

    public static void editarTarefa(ArrayList<Tarefa> tarefas) {
    }

    public static void excluirTarefa(ArrayList<Tarefa> tarefas) {
    }
}
