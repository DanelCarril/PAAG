module paagbat {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires java.sql;

    opens paagbat to javafx.fxml, javafx.graphics;
    exports paagbat.controller;
    opens paagbat.controller to javafx.fxml;
    opens paagbat.model.base to javafx.base;
}

