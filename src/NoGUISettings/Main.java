package NoGUISettings;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;

    public static GUICompiler compiler;

    public void start(Stage primaryStage) throws Exception {

        String stylesheet = getClass().getResource("/NoGUISettings/style.css").toExternalForm();

        compiler = new GUICompiler();
        Group root = compiler.createGUI();
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        scene.getStylesheets().add(stylesheet);
        primaryStage.setTitle("MnB2Bannerlord Mods");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
