package manager;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

import interfaces.Actions;
import services.Tasks;

public class TaskManager implements Actions {

    private Map<Integer, Tasks> tasks;
    private Scanner scanner;
    private int nextId;

    public TaskManager(Scanner scanner) {
        this.tasks = new HashMap<>();
        this.scanner = scanner;
        this.nextId = 1;
    }

    @Override
    public void create() {
        System.out.println("Digite o nome da tarefa: ");
        String title = scanner.nextLine();

        System.out.println("Digite a descrição da tarefa: ");
        String description = scanner.nextLine();

        Tasks task = new Tasks(nextId, title, description);
        tasks.put(nextId, task);
        nextId++;
    }

    @Override
    public void list() {
        if (tasks.isEmpty()) {
            System.out.println("Não existem tasks salvas!");
            return;
        }

        for (Tasks t : tasks.values()) {
            System.out.println(t);
        }
    }

    @Override
    public void edit() {
        System.out.println("Digite o ID da tarefa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Tasks task = tasks.get(id);

        if (task == null) {
            System.out.println("Tarefa não encontrada.");
            return;
        }

        System.out.println("Novo título: ");
        task.setTitle(scanner.nextLine());

        System.out.println("Nova descrição: ");
        task.setDescription(scanner.nextLine());

        System.out.println("Tarefa salva!");
    }

    @Override
    public void remove() {
        System.out.println("Digite o ID da tarefa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (tasks.remove(id) == null) {
            System.out.println("Tarefa não encontrada.");
        } else {
            System.out.println("Tarefa removida com sucesso.");
        }
    }
}
