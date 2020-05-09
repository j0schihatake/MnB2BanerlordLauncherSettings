package NoGUISettings;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    public static final int WIDTH = 780;
    public static final int HEIGHT = 600;

    public static GUICompiler compiler;

    public static String stylesheet;

    public void start(Stage primaryStage){

        stylesheet = getClass().getResource("/NoGUISettings/style.css").toExternalForm();

        BackgroundImage backgroundImage = new BackgroundImage(new Image("/NoGUISettings/TemplateComponents/background.jpeg",32,32,false,true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);

        compiler = new GUICompiler();
        Group root = compiler.createGUI();

        ScrollPane scrollPane = new ScrollPane(root);
        scrollPane.setFitToHeight(true);
        scrollPane.setBackground(background);

        BorderPane root2 = new BorderPane(scrollPane);
        root2.setTop(root);
        root2.setBackground(background);

        Scene scene = new Scene(root2, WIDTH, HEIGHT);
        scene.getStylesheets().add(stylesheet);
        primaryStage.setTitle("MnB2Bannerlord Mods");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
