package paagbat.model.base;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {

    public enum Role {
        ADMIN, USER  // Asegúrate de que coincidan exactamente con el ENUM en tu base de datos
    }

    private final StringProperty id;
    private final StringProperty username;
    private final StringProperty firstname;
    private final StringProperty lastname;
    private final StringProperty email;
    private final StringProperty password;
    private Role role;  // Enum en lugar de StringProperty
    private final StringProperty createdAt;

    // Constructor completo (con id y createdAt)
    public User(int id, String username, String firstname, String lastname,
                String email, String password, Role role, String createdAt) {
        this.id = new SimpleStringProperty(String.valueOf(id));
        this.username = new SimpleStringProperty(username);
        this.firstname = new SimpleStringProperty(firstname);
        this.lastname = new SimpleStringProperty(lastname);
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
        this.role = role;
        this.createdAt = new SimpleStringProperty(createdAt);
    }

    // Constructor sin id ni createdAt (útil para crear usuarios sin estos campos)
    public User(String username, String firstname, String lastname,
                String email, String password, Role role) {
        this.username = new SimpleStringProperty(username);
        this.firstname = new SimpleStringProperty(firstname);
        this.lastname = new SimpleStringProperty(lastname);
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
        this.role = role;
        this.createdAt = new SimpleStringProperty("");  // Default empty value or set it to null
        this.id = new SimpleStringProperty("");  // Default empty value or set it to null
    }

    // Métodos de propiedad
    public StringProperty idProperty() {
        return id;
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public StringProperty firstnameProperty() {
        return firstname;
    }

    public StringProperty lastnameProperty() {
        return lastname;
    }

    public StringProperty emailProperty() {
        return email;
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public StringProperty createdAtProperty() {
        return createdAt;
    }

    // Getters y setters tradicionales
    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getUsername() {
        return username.get();
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getFirstname() {
        return firstname.get();
    }

    public void setFirstname(String firstname) {
        this.firstname.set(firstname);
    }

    public String getLastname() {
        return lastname.get();
    }

    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getCreatedAt() {
        return createdAt.get();
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt.set(createdAt);
    }

    @Override
    public String toString() {
        return "ID: " + getId() + ", Username: " + getUsername() + ", Email: " + getEmail() + ", Role: " + role;
    }
}
