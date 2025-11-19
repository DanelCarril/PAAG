package carril.danel.app;

import carril.danel.model.Producto;
import carril.danel.convertidor.CsvConverter;
import carril.danel.convertidor.JsonConverter;
import carril.danel.convertidor.XmlConverter;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class XmlMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Producto> productos = null;
        String archivoXml = "";
        String archivoXmlCompleto = "";

        System.out.println("\n===== MINI MENÚ XML-PRINCIPAL =====");

        // Paso obligatorio: leer un XML
        while (productos == null) {
            System.out.print("Introduce el nombre del XML inicial (ej: productos): ");
            archivoXml = "input/" + scanner.nextLine();
            archivoXmlCompleto = archivoXml + ".xml";

            File file = new File(archivoXmlCompleto);
            if (!file.exists()) {
                System.out.println("❌ El archivo no existe. Intenta con otro nombre.");
                continue; // vuelve a preguntar
            }

            try {
                productos = XmlConverter.xmlToProductos(archivoXmlCompleto);
                System.out.println("Productos leídos desde XML:");
                productos.forEach(System.out::println);
            } catch (Exception e) {
                System.out.println("❌ Error leyendo XML: " + e.getMessage());
            }
        }

        // Menú principal
        while (true) {
            System.out.println("\nOpciones:");
            System.out.println("1. Guardar productos a CSV");
            System.out.println("2. Guardar productos a JSON");
            System.out.println("3. Guardar en CSV / JSON");
            System.out.println("4. Leer productos desde XML nuevamente");
            System.out.println("5. Agregar un producto");
            System.out.println("0. Volver al menú principal");
            System.out.print("Elige una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1" -> {
                    String archivoCsv = archivoXml + ".csv";
                    CsvConverter.productosToCsv(productos, archivoCsv);
                    System.out.println("Productos guardados en CSV: " + archivoCsv);
                }
                case "2" -> {
                    String archivoJson = archivoXml + ".json";
                    JsonConverter.productosToJson(productos, archivoJson);
                    System.out.println("Productos guardados en JSON: " + archivoJson);
                }
                case "3" -> {
                    String archivoCsv = archivoXml + ".csv";
                    CsvConverter.productosToCsv(productos, archivoCsv);
                    String archivoJson = archivoXml + ".json";
                    JsonConverter.productosToJson(productos, archivoJson);
                    System.out.println("Productos guardados en CSV / JSON");
                }
                case "4" -> {
                    productos = XmlConverter.xmlToProductos(archivoXmlCompleto);
                    System.out.println("Productos leídos desde XML:");
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
                    XmlConverter.productosToXml(productos, archivoXmlCompleto);
                    System.out.println("Producto agregado y guardado en CSV: " + archivoXmlCompleto);
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
