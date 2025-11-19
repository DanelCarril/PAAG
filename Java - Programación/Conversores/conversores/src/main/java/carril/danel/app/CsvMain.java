package carril.danel.app;

import carril.danel.model.Producto;
import carril.danel.convertidor.CsvConverter;
import carril.danel.convertidor.JsonConverter;
import carril.danel.convertidor.XmlConverter;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class CsvMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Producto> productos = null;
        String archivoCsv = "";
        String archivoCsvCompleto = "";

        System.out.println("\n===== MINI MENÚ CSV-PRINCIPAL =====");

        // Paso obligatorio: leer un CSV
        while (productos == null) {
            System.out.print("Introduce el nombre del CSV inicial (ej: productos): ");
            archivoCsv = "input/" + scanner.nextLine();
            archivoCsvCompleto = archivoCsv + ".csv";

            File file = new File(archivoCsvCompleto);
            if (!file.exists()) {
                System.out.println("❌ El archivo no existe. Intenta con otro nombre.");
                continue; // vuelve a preguntar
            }

            try {
                productos = CsvConverter.csvToProductos(archivoCsvCompleto);
                System.out.println("Productos leídos desde CSV:");
                productos.forEach(System.out::println);
            } catch (Exception e) {
                System.out.println("❌ Error leyendo CSV: " + e.getMessage());
                productos = null; // aseguramos que el bucle continue si hay error
            }
        }

        // Menú principal
        while (true) {
            System.out.println("\nOpciones:");
            System.out.println("1. Guardar productos a JSON");
            System.out.println("2. Guardar productos a XML");
            System.out.println("3. Guardar en JSON y XML");
            System.out.println("4. Leer productos desde CSV nuevamente");
            System.out.println("5. Agregar un producto");
            System.out.println("0. Volver al menú principal");
            System.out.print("Elige una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1" -> {
                    String archivoJson = archivoCsv + ".json";
                    JsonConverter.productosToJson(productos, archivoJson);
                    System.out.println("Productos guardados en JSON: " + archivoJson);
                }
                case "2" -> {
                    String archivoXml = archivoCsv + ".xml";
                    XmlConverter.productosToXml(productos, archivoXml);
                    System.out.println("Productos guardados en XML: " + archivoXml);
                }
                case "3" -> {
                    String archivoJson = archivoCsv + ".json";
                    JsonConverter.productosToJson(productos, archivoJson);
                    String archivoXml = archivoCsv + ".xml";
                    XmlConverter.productosToXml(productos, archivoXml);
                    System.out.println("Productos guardados en JSON / XML");
                }
                case "4" -> {
                    productos = CsvConverter.csvToProductos(archivoCsvCompleto);
                    System.out.println("Productos leídos desde CSV:");
                    productos.forEach(System.out::println);
                }
                case "5" -> {
                    int id;
                    if (productos.isEmpty()) {
                        id = 1; // Si no hay productos, empezamos desde 1
                    } else {
                        // Obtenemos el ID más alto y sumamos 1
                        id = productos.stream()
                                .mapToInt(Producto::getId)
                                .max()
                                .getAsInt() + 1;
                    }

                    System.out.print("Introduce el nombre del producto: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Introduce el precio del producto: ");
                    double precio = Double.parseDouble(scanner.nextLine());

                    System.out.print("Introduce el stock del producto: ");
                    int stock = Integer.parseInt(scanner.nextLine());

                    Producto nuevoProducto = new Producto(id, nombre, precio, stock);

                    // Añadir el producto a la lista
                    productos.add(nuevoProducto);
                    CsvConverter.productosToCsv(productos, archivoCsvCompleto);
                    System.out.println("Producto agregado y guardado en CSV: " + archivoCsvCompleto);
                }
                case "0" -> {
                    System.out.println("Volviendo al menú principal...");
                    carril.danel.FileConverterApp.main(null);
                }
                default -> System.out.println("❌ Opción no válida, intenta de nuevo.");
            }
        }
    }
}
