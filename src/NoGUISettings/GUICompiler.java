package NoGUISettings;

import NoGUISettings.TemplateComponents.ModuleSettings;
import NoGUISettings.TemplateComponents.Parameter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class GUICompiler {

    /*
        ModName:  название мода
        ModDescription: Краткое описание мода: краткое описание
        Настроечные параметры:

        Parameter Description : описание
        [0]regenerationDelay 	    # 	1   #   int   #   min  #   max   #        Задержка регенерации            #
        [0]regenerationDelay 	    # 	1   #   int   #   ---  #   ---   #        Задержка регенерации            #

        ButtonSave: Save
    */

    public VBox vBox;

    public static ArrayList<ModuleSettings> allModules = new ArrayList<>();

    public Group createGUI(){

        Pane testPanel = new Pane();

        int scroolSpeed = 10;

        // Test

        int count =3;

        int parameterCount = 13;

        for(int i = 0; i < count; i++) {

            ModuleSettings testSettings = new ModuleSettings();

            testSettings.moduleName = "Regeneration";

            testSettings.description = "Регенерация здоровья.";

            for(int j = 0; j < parameterCount; j++) {

                Parameter testParameter = new Parameter();

                testParameter.description = "Задержка восстановления здоровья. Задержка восстановления здоровья. Задержка восстановления здоровья. Задержка восстановления здоровья.";

                testParameter.name = "regenerationDelay";

                testParameter.type = "int";

                testParameter.value = "7";

                testParameter.maxValue = "30";

                testParameter.minValue = "1";

                testSettings.parameters.add(testParameter);
            }

            allModules.add(testSettings);
        }

        Group resultGroup = new Group();

        resultGroup.getStylesheets().add(Main.stylesheet);

        Image background = new Image("/NoGUISettings/TemplateComponents/background.jpeg");

        ImageView view = new ImageView(background);

        resultGroup.getChildren().addAll(view);

        vBox = new VBox();

        vBox.getStyleClass().add("vbox");

        //-----------------------------------------Вывод информации о модулях:

        for (ModuleSettings settings: allModules) {

            VBox moduleSettings = new VBox();

            moduleSettings.getStyleClass().add("vbox");

            Label ModNameLabel = new Label("ModName: " + settings.moduleName);

            Label ModDescriptionLabel = new Label("ModDescription: " + settings.description);

            moduleSettings.getChildren().add(ModNameLabel);

            moduleSettings.getChildren().add(ModDescriptionLabel);

            for (Parameter parameter: settings.parameters) {

                VBox vBoxParameter = new VBox();

                vBoxParameter.getStyleClass().add("vBox");

                Label parameterDescription = new Label(parameter.description);

                parameterDescription.setMaxWidth(700);

                parameterDescription.setWrapText(true);

                parameterDescription.setMaxHeight(9000);

                HBox hBoxParameter = new HBox();

                Label parameterName = new Label(parameter.name);

                parameterName.getStyleClass().add("labelInfo");

                TextField paramValue = new TextField();

                paramValue.setText(parameter.value);

                Label paramType = new Label(parameter.type);

                paramType.getStyleClass().add("labelInfo");

                Label minValue = new Label("min: " + parameter.minValue);

                minValue.getStyleClass().add("labelInfo");

                Label maxValue = new Label("max: " + parameter.maxValue);

                maxValue.getStyleClass().add("labelInfo");

                vBoxParameter.getChildren().add(parameterDescription);

                hBoxParameter.getChildren().add(paramValue);

                hBoxParameter.getChildren().add(parameterName);

                hBoxParameter.getChildren().add(paramType);

                hBoxParameter.getChildren().add(minValue);

                hBoxParameter.getChildren().add(maxValue);

                vBoxParameter.getChildren().add(hBoxParameter);

                moduleSettings.getChildren().add(vBoxParameter);

            }

            Button saveButton = new Button("Save");

            moduleSettings.getChildren().addAll(saveButton);

            vBox.getChildren().add(moduleSettings);
        }

        resultGroup.getChildren().addAll(vBox);

        return resultGroup;
    }

    public void addMouseScrolling() {
        if(vBox == null){
            return;
        }
        vBox.setOnScroll((ScrollEvent event) -> {
            double deltaY = event.getDeltaY();

            if(deltaY > 0 && vBox.getLayoutY() < 0) {
                vBox.setLayoutY(vBox.getLayoutY() + deltaY);
            }else if(deltaY < 0){
                vBox.setLayoutY(vBox.getLayoutY() + deltaY);
            }

            int calculateHeight = 0;

            for (Node node :vBox.getChildren()) {
                calculateHeight += node.getBoundsInLocal().getHeight();
                //calculateHeight -= vBox.getLayoutBounds().getHeight();
                calculateHeight -= vBox.getSpacing();
            }
            System.out.println("calculateHeight = " + vBox.getLayoutBounds().getHeight());

            //layoutY+ translateY
            System.out.println("calculateHeight = " + calculateHeight);

            System.out.println("layoutY = " + vBox.getLayoutY());
        });
    }
}
