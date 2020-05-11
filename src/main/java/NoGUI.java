import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class NoGUI extends Application {

    public static final int WIDTH = 780;

    public static final int HEIGHT = 600;

    public static GUICompiler compiler;

    public static String stylesheet;

    public static Background background;

    public void start(Stage primaryStage){

        // Prepare file:
        //------------------------------------------------- GUI

        stylesheet = getClass().getResource("/style.css").toExternalForm();

        BackgroundImage backgroundImage = new BackgroundImage(new Image("/background.jpg",32,32,false,true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        background = new Background(backgroundImage);

        compiler = new GUICompiler();
        Scene scene = new Scene(compiler.createGUI(), WIDTH, HEIGHT);
        scene.getStylesheets().add(stylesheet);
        primaryStage.setTitle("MnB2Bannerlord Mods");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
