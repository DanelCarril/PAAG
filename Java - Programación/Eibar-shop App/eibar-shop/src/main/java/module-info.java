module paagbat {
    requires javafx.controls;
    requires javafx.base;
    requires javafx.fxml;
    requires java.sql;

    opens paagbat to javafx.fxml;
    opens paagbat.controller to javafx.fxml;
    opens paagbat.model to javafx.fxml;
    opens paagbat.model.base to javafx.base;
    exports paagbat;
    exports paagbat.controller;
    exports paagbat.model;
    exports paagbat.model.base;
}
