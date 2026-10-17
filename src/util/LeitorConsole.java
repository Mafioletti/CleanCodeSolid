package util;

import java.util.Scanner;

public class LeitorConsole {
    private final Scanner scanner;

    // Recebe o Scanner por injeção de dependência
    public LeitorConsole(Scanner scanner) {
        this.scanner = scanner;
    }

    public String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    public int lerInteiro(String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida! Digite um número inteiro.");
            scanner.next(); // Descarta a entrada inválida
            System.out.print(mensagem);
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do Enter (\n)
        return valor;
    }
}