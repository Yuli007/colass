package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        {
            Controller cola = new Controller();
            cola.insertar(10);
            cola.insertar(5);
            cola.insertar(19);
            cola.mostrar();
            cola.extraer(16);
            cola.mostrar();
            cola.insertar(2);
            cola.mostrar();


        }

    }
}


