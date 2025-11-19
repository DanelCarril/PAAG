package carril.danel.convertidor;

import carril.danel.model.Producto;
import jakarta.xml.bind.*;

import java.io.*;
import java.util.List;

// Para lista de productos necesitamos un wrapper
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "productos")
class ProductoListWrapper {
    private List<Producto> productos;

    @XmlElement(name = "producto")
    public List<Producto> getProductos() { return productos; }

    public void setProductos(List<Producto> productos) { this.productos = productos; }
}

public class XmlConverter {

    public static void productosToXml(List<Producto> productos, String filePath) {
        try {
            ProductoListWrapper wrapper = new ProductoListWrapper();
            wrapper.setProductos(productos);

            JAXBContext context = JAXBContext.newInstance(ProductoListWrapper.class, Producto.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(wrapper, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static List<Producto> xmlToProductos(String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(ProductoListWrapper.class, Producto.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ProductoListWrapper wrapper = (ProductoListWrapper) unmarshaller.unmarshal(new File(filePath));
            return wrapper.getProductos();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
