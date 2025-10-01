package paagbat.model.base;

import javafx.beans.property.*;

public class ProductsBase {
    private final StringProperty id;  // Nuevo campo para el ID del producto
    private final StringProperty userId;
    private final StringProperty productName;
    private final StringProperty category;
    private final StringProperty description;
    private final FloatProperty price;

    // Constructor modificado para incluir el ID del producto
    public ProductsBase(String id, String userId, String productName, String category,
            String description, Float price) {
        this.id = new SimpleStringProperty(id);
        this.userId = new SimpleStringProperty(userId);
        this.productName = new SimpleStringProperty(productName);
        this.category = new SimpleStringProperty(category);
        this.description = new SimpleStringProperty(description);
        this.price = new SimpleFloatProperty(price);
    }

    // Métodos para obtener y establecer el ID
    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public StringProperty idProperty() {
        return id;
    }

    // Métodos para obtener y establecer el userId
    public String getUserId() {
        return userId.get();
    }

    public void setUserId(String userId) {
        this.userId.set(userId);
    }

    public StringProperty userIdProperty() {
        return userId;
    }

    // Métodos para obtener y establecer el nombre del producto
    public String getProductName() {
        return productName.get();
    }

    public void setProductName(String productName) {
        this.productName.set(productName);
    }

    public StringProperty productNameProperty() {
        return productName;
    }

    // Métodos para obtener y establecer el precio
    public float getPrice() {
        return price.get();
    }

    public void setPrice(float price) {
        this.price.set(price);
    }

    public FloatProperty priceProperty() {
        return price;
    }

    public StringProperty getCategory() {
        return category;
    }

    public StringProperty getDescription() {
        return description;
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public void setDescription(String descripción) {
        this.description.set(descripción);
    }
}
