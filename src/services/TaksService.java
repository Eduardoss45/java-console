package services;

import java.util.Map;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import ui.Prompt;
import interfaces.Actions;
import models.Developer;
import models.Manager;
import models.Tasks;
import models.User;
import enums.Priority;
import enums.States;
import exceptions.TaskNotFoundException;

public class TaksService implements Actions {

    private Map<Integer, User> users = new HashMap<>();
    private Map<Integer, Tasks> tasks;
    private Scanner scanner;
    private int nextId;

    public TaksService(Scanner scanner) {
        this.tasks = new HashMap<>();
        this.scanner = scanner;
        this.nextId = 1;
        users.put(1, new Developer(1, "Eduardo", "edu@email.com", "Java"));
        users.put(2, new Manager(2, "Carlos", "carlos@email.com", 5));
    }

    @Override
    public void create() {
        States state = States.PENDING;
        Priority priority = Priority.LOW;

        System.out.println("Digite o ID do usuário responsável: ");
        int userId = scanner.nextInt();
        scanner.nextLine();

        User responsible = users.get(userId);

        if (responsible != null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        System.out.println("Digite o nome da tarefa: ");
        String title = scanner.nextLine();

        System.out.println("Digite a descrição da tarefa: ");
        String description = scanner.nextLine();

        System.out.println("Escolha o status da tarefa: ");
        int stateOption = 0;

        while (stateOption < 1 || stateOption > 3) {
            Prompt.showPromptStates();
            System.out.println("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                stateOption = scanner.nextInt();
                scanner.nextLine();

                if (stateOption >= 1 && stateOption <= 3) {
                    state = States.fromCode(stateOption);
                } else {
                    System.out.println("Opção inválida!");
                }
            } else {
                System.out.println("Por favor, digite um número válido.");
                scanner.nextLine();
            }
        }

        System.out.println("Escolha a prioridade da tarefa: ");
        int priorityOption = 0;

        while (priorityOption < 1 || priorityOption > 3) {
            Prompt.showPromptPriority();
            System.out.println("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                priorityOption = scanner.nextInt();
                scanner.nextLine();

                if (priorityOption >= 1 && priorityOption <= 3) {
                    priority = Priority.fromCode(priorityOption);
                } else {
                    System.out.println("Opção inválida!");
                }
            } else {
                System.out.println("Por favor, digite um número válido.");
                scanner.nextLine();
            }
        }

        Tasks task = new Tasks(nextId, title, description, state, priority, responsible);
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
        try {
            System.out.println("Digite o ID da tarefa: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Tasks task = tasks.get(id);

            if (task == null) {
                throw new TaskNotFoundException("Tarefa com ID " + id + " não encontrada.");
            }

            System.out.println("Novo título: ");
            task.setTitle(scanner.nextLine());

            System.out.println("Nova descrição: ");
            task.setDescription(scanner.nextLine());

            System.out.println("Escolha o status da tarefa: ");
            int stateOption = 0;

            while (stateOption < 1 || stateOption > 3) {
                Prompt.showPromptStates();
                System.out.println("Escolha uma opção: ");

                if (scanner.hasNextInt()) {
                    stateOption = scanner.nextInt();
                    scanner.nextLine();

                    if (stateOption >= 1 && stateOption <= 3) {
                        task.setState(States.fromCode(stateOption));
                    } else {
                        System.out.println("Opção inválida!");
                    }
                } else {
                    System.out.println("Por favor, digite um número válido.");
                    scanner.nextLine();
                }
            }

            System.out.println("Escolha a prioridade da tarefa: ");
            int priorityOption = 0;

            while (priorityOption < 1 || priorityOption > 3) {
                Prompt.showPromptPriority();
                System.out.println("Escolha uma opção: ");

                if (scanner.hasNextInt()) {
                    priorityOption = scanner.nextInt();
                    scanner.nextLine();

                    if (priorityOption >= 1 && priorityOption <= 3) {
                        task.setPriority(Priority.fromCode(priorityOption));
                    } else {
                        System.out.println("Opção inválida!");
                    }
                } else {
                    System.out.println("Por favor, digite um número válido.");
                    scanner.nextLine();
                }
            }

            System.out.println("Tarefa salva!");
        } catch (InputMismatchException e) {
            System.out.println("Erro: Informe um número válido para o ID.");
            scanner.nextLine();
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void remove() {
        try {
            System.out.println("Digite o ID da tarefa: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            if (!tasks.containsKey(id)) {
                throw new TaskNotFoundException("Tarefa não encontrada.");
            }
            tasks.remove(id);
            System.out.println("Tarefa removida com sucesso.");
        } catch (InputMismatchException e) {
            System.out.println("Erro: O ID deve ser um número.");
            scanner.nextLine();
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
