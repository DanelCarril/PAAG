package paagbat.model.base;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SalesBase {
    private final StringProperty id;
    private final StringProperty userId;
    private final StringProperty productId;

    public SalesBase(String id, String userId, String productId) {
        this.id = new SimpleStringProperty(id);
        this.userId = new SimpleStringProperty(userId);
        this.productId = new SimpleStringProperty(productId);
    }

    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public StringProperty idProperty() {
        return id;
    }

    public String getUserId() {
        return userId.get();
    }

    public void setUserId(String userId) {
        this.userId.set(userId);
    }

    public StringProperty userIdProperty() {
        return userId;
    }

    public String getProductId() {
        return productId.get();
    }

    public void setProductId(String productId) {
        this.productId.set(productId);
    }

    public StringProperty productIdProperty() {
        return productId;
    }

    @Override
    public String toString() {
        return "SalesBase [id=" + id.get() + ", userId=" + userId.get() + ", productId=" + productId.get() + "]";
    }
}
