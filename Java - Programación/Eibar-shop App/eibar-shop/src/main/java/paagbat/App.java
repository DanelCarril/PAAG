package paagbat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import paagbat.model.DendarenAtzipena;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    public static DendarenAtzipena ProductDendarenAtzipena = new DendarenAtzipena("localhost", "challenge_3_database", "product", "Don Omar", "FrioPolar");
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("logIn"), 600, 390);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}