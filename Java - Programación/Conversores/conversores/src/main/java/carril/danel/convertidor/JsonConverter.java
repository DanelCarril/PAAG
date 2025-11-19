package carril.danel.convertidor;

import carril.danel.model.Producto;
import javax.json.*;
import java.io.*;
import java.util.*;

public class JsonConverter {

    public static void productosToJson(List<Producto> productos, String filePath) {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (Producto p : productos) {
            JsonObject obj = Json.createObjectBuilder()
                    .add("id", p.getId())
                    .add("nombre", p.getNombre())
                    .add("precio", p.getPrecio())
                    .add("stock", p.getStock())
                    .build();
            arrayBuilder.add(obj);
        }
        JsonArray jsonArray = arrayBuilder.build();

        try (FileWriter fw = new FileWriter(filePath);
             JsonWriter jsonWriter = Json.createWriter(fw)) {
            jsonWriter.writeArray(jsonArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Producto> jsonToProductos(String filePath) {
        List<Producto> productos = new ArrayList<>();
        try (FileReader fr = new FileReader(filePath);
             JsonReader jsonReader = Json.createReader(fr)) {
            JsonArray array = jsonReader.readArray();
            for (JsonValue val : array) {
                JsonObject obj = val.asJsonObject();
                Producto p = new Producto(
                        obj.getInt("id"),
                        obj.getString("nombre"),
                        obj.getJsonNumber("precio").doubleValue(),
                        obj.getInt("stock")
                );
                productos.add(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productos;
    }
}
