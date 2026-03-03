import java.util.Scanner;

import interfaces.Actions;
import services.TaksService;
import ui.Prompt;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Actions manager = new TaksService(scanner);

        int option = 0;

        while (option != 5) {
            Prompt.showPrompt();
            System.out.println("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        scanner.nextLine();
                        manager.create();
                        break;
                    case 2:
                        manager.list();
                        break;
                    case 3:
                        scanner.nextLine();
                        manager.edit();
                        break;
                    case 4:
                        scanner.nextLine();
                        manager.remove();
                        break;
                    case 5:
                        scanner.close();
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } else {
                System.out.println("Por favor, digite um número válido.");
                scanner.next();
                option = -1;
            }
        }
    }
}