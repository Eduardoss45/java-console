package ui;

public class Prompt {
    public static void showPrompt() {
        System.out.println("1. Criar tarefa");
        System.out.println("2. Listar tarefa");
        System.out.println("3. Editar tarefa");
        System.out.println("4. Excluir tarefa");
        System.out.println("5. Sair");
    }

    public static void showPromptStates() {
        System.out.println("1. PENDING");
        System.out.println("2. IN_PROGRESS");
        System.out.println("3. DONE");
    }

    public static void showPromptPriority() {
        System.out.println("1. LOW");
        System.out.println("2. MEDIUM");
        System.out.println("3. HIGH");
    }
}
