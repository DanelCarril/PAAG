package carril.danel.convertidor;

import carril.danel.model.Producto;
import java.io.*;
import java.util.*;

public class CsvConverter {

    public static List<Producto> csvToProductos(String archivoCsv) {
        List<Producto> productos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCsv))) {
            String linea;
            br.readLine(); // <-- Esta línea salta la primera fila (encabezado)
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                productos.add(new Producto(
                        Integer.parseInt(partes[0]),
                        partes[1],
                        Double.parseDouble(partes[2]),
                        Integer.parseInt(partes[3])));
            }
        } catch (Exception e) {
            System.out.println("? Error leyendo CSV: " + e.getMessage());
        }
        return productos;
    }

    public static void productosToCsv(List<Producto> productos, String filePath) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            // Escribir encabezado
            pw.println("ID,Nombre,Precio,Stock");
            for (Producto p : productos) {
                pw.println(p.getId() + "," + p.getNombre() + "," + p.getPrecio() + "," + p.getStock());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}