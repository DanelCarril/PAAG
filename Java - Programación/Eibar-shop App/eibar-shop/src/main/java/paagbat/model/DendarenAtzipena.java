package paagbat.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import paagbat.model.base.ProductsBase;
import paagbat.model.base.SalesBase;
import paagbat.model.base.User;

public class DendarenAtzipena {
    private String server;
    private String db;
    private String taula;

    String user;
    String pass;

    public DendarenAtzipena(String server, String db, String taula, String user, String pass) {
        this.server = server;
        this.db = db;
        this.taula = taula;
        this.user = user;
        this.pass = pass;
    }

    public Connection konektatu() {
        String url = "jdbc:mariadb://" + server + "/" + db;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, pass);
            // System.out.println(server + " zerbidoreko " + db + " datu-basera konektatu
            // zara.");
        } catch (SQLException e) {
            if (e.getErrorCode() == 1045)
                System.out.println("Erabiltzaile edo pasahitz okerrak");
            else if (e.getErrorCode() == 0)
                System.out.println("Ezin zerbitzariarekin konektatu");
            else
                System.out.println(e.getErrorCode() + "-" + e.getMessage());
        }
        return conn;
    }

    public List<String> getUsersId() {
        String sql = "SELECT id FROM users";
        List<String> usersIdLista = new ArrayList<String>();

        try (Connection conn = konektatu();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            // loop through the result set
            while (rs.next()) {
                usersIdLista.add(rs.getString("id"));
            }
            return usersIdLista;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<String> getProductsId() {
        String sql = "SELECT ID FROM product";
        List<String> productsIdLista = new ArrayList<String>();

        try (Connection conn = konektatu();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            // loop through the result set
            while (rs.next()) {
                productsIdLista.add(rs.getString("ID"));
            }
            return productsIdLista;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<String> validateUser(String username, String password) {
        List<String> userData = new ArrayList<>();
        
        // Consulta SQL para verificar el nombre de usuario, contraseña y rol
        String query = "SELECT username, role FROM users WHERE username = ? AND password = ? AND role = 'admin'";

        try (Connection conn = konektatu(); 
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                userData.add(rs.getString("username"));
                userData.add(rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userData;
    }

    public String getUserId(String username) {
        String sql = "SELECT id FROM users WHERE username = ?";

        try (Connection conn = konektatu();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String userId = rs.getString("id");
                return userId;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public int addSale(String uId, String pId) {
        String checkSql = "SELECT COUNT(*) FROM user_product WHERE product_id = ?";
        
        try (Connection conn = konektatu();
             PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
            
            checkStmt.setString(1, pId);
            ResultSet rs = checkStmt.executeQuery();
            
            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("El producto con ID " + pId + " ya está registrado.");
                return -1;
            }
            
            String sql = "INSERT INTO user_product (user_id, product_id) VALUES (?, ?)";
            
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, uId);
                pstmt.setString(2, pId);
                pstmt.executeUpdate();
                return 1;
            } catch (SQLException e) {
                e.printStackTrace();
                return 0;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<SalesBase> getAllSales() {
        String sql = "SELECT * FROM user_product";
        List<SalesBase> sales = new ArrayList<SalesBase>();

        try (Connection conn = konektatu();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            // loop through the result set
            while (rs.next()) {
                sales.add(new SalesBase(rs.getString("id"), rs.getString("user_id"), rs.getString("product_id")));
            }
            return sales;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<ProductsBase> getAllProducts() {
        List<ProductsBase> productList = new ArrayList<ProductsBase>();
        String sql = "SELECT * FROM product";
        try (Connection conn = konektatu(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                productList.add(new ProductsBase(rs.getString("id"), rs.getString("user_id"), rs.getString("name"), rs.getString("category"), rs.getString("description"), rs.getFloat("price")));
            }
            return productList;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public void updateSale(SalesBase sale) {
        String query = "UPDATE user_product SET user_id = ?, product_id = ? WHERE id = ?";
    
        try (Connection conn = konektatu();
             PreparedStatement stmt = conn.prepareStatement(query)) {
    
            stmt.setString(1, sale.getUserId());
            stmt.setString(2, sale.getProductId());
            stmt.setString(3, sale.getId());
    
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Sale updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSale(SalesBase sale) {
        String query = "DELETE FROM user_product WHERE id = ?";

        try (Connection conn = konektatu();
             PreparedStatement stmt = conn.prepareStatement(query)) {
    
            stmt.setString(1, sale.getId());
    
            stmt.executeUpdate();
            }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int updateProduct(ProductsBase product) {
        // La consulta SQL ahora también incluye 'category' en la actualización.
        String sql = "UPDATE product SET name = ?, price = ?, description = ?, category = ? WHERE id = ?";
        
        try (Connection conn = konektatu(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Usamos .get() para obtener los valores de las propiedades StringProperty
            pstmt.setString(1, product.getProductName());  // Nombre del producto
            pstmt.setFloat(2, product.getPrice());         // Precio del producto
            pstmt.setString(3, product.getDescription().get());  // Descripción del producto
            pstmt.setString(4, product.getCategory().get());     // Categoría del producto
            pstmt.setString(5, product.getId());           // ID del producto (clave primaria)
    
            // Ejecutamos la actualización.
            pstmt.executeUpdate();
            return 1;  // Devuelve 1 si la actualización fue exitosa.
        } catch (SQLException e) {
            // Manejo de excepciones para errores de SQL.
            System.out.println("Error: " + e.getMessage());
            return 0;  // Devuelve 0 si hubo un error.
        }
    }

    public int deleteProduct(ProductsBase product) {
        // Cambiar la consulta para usar el ID del producto (no el ID del usuario)
        String sql = "DELETE FROM product WHERE id = ?"; // Asumiendo que el campo de ID es "id" en la tabla "product"

        try (Connection conn = konektatu(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, product.getId()); // Usa el ID del producto aquí (ajusta el método de acceso si es
                                                        // necesario)
            pstmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }

    


    public List<String> getUser_Id() {
        List<String> userList = new ArrayList<>();
        String sql = "SELECT id FROM users";
        try (Connection conn = konektatu(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                userList.add(rs.getString("id"));
            }
            return userList;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public int addProduct(String user_id, String name, String category, String description, String price) {
        String sql = "INSERT INTO product (user_id, name, category, description, price) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = konektatu(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user_id);
            pstmt.setString(2, name);
            pstmt.setString(3, category);
            pstmt.setString(4, description);
            pstmt.setString(5, price);
            pstmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM users";
        Connection conn = konektatu(); // Establecer la conexión

        if (conn == null) {
            System.out.println("Error: No se pudo establecer la conexión a la base de datos.");
            return userList; // Retorna una lista vacía si no se pudo conectar
        }

        try (PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + " - Username: " + rs.getString("username"));

                // Convertir el string del role a enum
                User.Role roleEnum = User.Role.valueOf(rs.getString("role").toUpperCase());

                User user = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("password"),
                        roleEnum,
                        rs.getString("created_at"));

                userList.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los usuarios: " + e.getMessage());
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close(); // Cierra la conexión
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return userList;
    }

    public void deleteUser(String herriIzena) {
        String sql = "DELETE FROM " + taula + " WHERE username = ?";

        try (Connection conn = konektatu();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, herriIzena);
            pstmt.executeUpdate();
            System.out.println(herriIzena + " ezabatua.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    public void updateUser(User user) {
        String query = "UPDATE users SET username = ?, password = ?, email = ? WHERE id = ?"; // Usamos `id` como clave
                                                                                              // primaria

        try (Connection conn = konektatu(); // Obtener la conexión
                PreparedStatement stmt = conn.prepareStatement(query)) {

            // Establecer los parámetros de la consulta:
            stmt.setString(1, user.getUsername()); // Para `username`, usamos `setString()` porque es de tipo String
            stmt.setString(2, user.getPassword()); // Para `password`, usamos `setString()` porque es de tipo String
            stmt.setString(3, user.getEmail()); // Para `email`, usamos `setString()` porque es de tipo String
            stmt.setInt(4, Integer.parseInt(user.getId()));

            // Ejecutar la actualización
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el usuario: " + e.getMessage());
        }
    }

    public List<String> getEnumRolesFromDB() {
        List<String> roles = new ArrayList<>();
        String sql = "SELECT COLUMN_TYPE FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = ? AND COLUMN_NAME = ?";

        // Nombre de la tabla y columna que deseas consultar
        String tableName = "users"; // O el nombre de tu tabla
        String columnName = "role"; // O el nombre de la columna

        try (Connection conn = konektatu();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Asignar los valores a los parámetros
            stmt.setString(1, tableName);
            stmt.setString(2, columnName);

            // Ejecutar la consulta
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String columnType = rs.getString(1);

                    // Procesar la cadena de tipo ENUM para obtener los valores
                    String enumValues = columnType.substring(columnType.indexOf('(') + 1, columnType.indexOf(')'));
                    String[] rolesArray = enumValues.split(",\\s*");

                    // Limpiar y agregar los valores del ENUM a la lista
                    for (String role : rolesArray) {
                        role = role.replace("'", "").trim(); // Eliminar las comillas simples y los espacios
                        if (!role.isEmpty()) {
                            roles.add(role);
                        }
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener los roles ENUM: " + e.getMessage());
        }

        return roles;
    }

    public boolean insertUser(User user) {
        String sql = "INSERT INTO users (username, firstname, lastname, email, password, role) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = konektatu();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getFirstname());
            stmt.setString(3, user.getLastname());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getPassword());
            stmt.setString(6, user.getRole().name());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            System.err.println("Error inserting user: " + e.getMessage());
            return false;
        }
    }

    public List<ProductsBase> getProductByStatus(String status) {
        List<ProductsBase> productList = new ArrayList<ProductsBase>();
        String sql = "SELECT id, user_id, name, category, description, price FROM " + taula + " WHERE status = \'" + status + "\'";

        try (Connection conn = konektatu();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                productList.add(new ProductsBase(rs.getString("id"),rs.getString("user_id"),rs.getString("name"),rs.getString("category"),rs.getString("description"),rs.getFloat("price")));
            }
            return productList;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    
}
