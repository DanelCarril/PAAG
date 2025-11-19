package carril.danel;

import java.util.Scanner;

public class FileConverterApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== MENÚ PRINCIPAL DE CONVERSIONES =====");
            System.out.println("1. Mini menú CSV-principal");
            System.out.println("2. Mini menú JSON-principal");
            System.out.println("3. Mini menú XML-principal");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1" -> {
                    System.out.println("➡ Abriendo menú CSV-principal...");
                    carril.danel.app.CsvMain.main(null);
                }
                case "2" -> {
                    System.out.println("➡ Abriendo menú JSON-principal...");
                    carril.danel.app.JsonMain.main(null);
                }
                case "3" -> {
                    System.out.println("➡ Abriendo menú XML-principal...");
                    carril.danel.app.XmlMain.main(null);
                }
                case "0" -> {
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                }
                default -> System.out.println("❌ Opción no válida, intenta de nuevo.");
            }
        }
    }
}
