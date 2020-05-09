package NoGUISettings;

import NoGUISettings.TemplateComponents.ModuleSettings;
import NoGUISettings.TemplateComponents.Parameter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class GUICompiler {

    public static ArrayList<ModuleSettings> allModules = new ArrayList<>();

    public Group createGUI(){

        int scroolSpeed = 10;

        //Test

        int count = 30;

        int parameterCount = 5;

        for(int i = 0; i < count; i++) {

            ModuleSettings testSettings = new ModuleSettings();

            testSettings.moduleName = "Regeneration";

            testSettings.description = "Регенерация здоровья.";

            for(int j = 0; j < parameterCount; j++) {

                Parameter testParameter = new Parameter();

                testParameter.description = "Задержка восстановления здоровья.";

                testParameter.name = "regenerationDelay";

                testParameter.type = "int";

                testSettings.parameters.add(testParameter);
            }

            allModules.add(testSettings);
        }

        /*
              ModName:  название мода
              ModDescription: Краткое описание мода: краткое описание
              Настроечные параметры:

              Parameter Description : описание
              [0]regenerationDelay 	    # 	1   #   int   #   min  #   max   #        Задержка регенерации            #
              [0]regenerationDelay 	    # 	1   #   int   #   ---  #   ---   #        Задержка регенерации            #

              ButtonSave: Save
        */

        Group resultGroup = new Group();

        Image background = new Image("/NoGUISettings/TemplateComponents/background.jpeg");

        ImageView view = new ImageView(background);

        resultGroup.getChildren().addAll(view);

        VBox vBox = new VBox();

        //-----------------------------------------Вывод информации о модулях:

        for (ModuleSettings settings: allModules) {

            VBox moduleSettings = new VBox();

            Label ModNameLabel = new Label("ModName: " + settings.moduleName);

            Label ModDescriptionLabel = new Label("ModName: " + settings.description);

            Label ParametersLabel = new Label("Parameters:");

            moduleSettings.getChildren().add(ModNameLabel);

            moduleSettings.getChildren().add(ModDescriptionLabel);

            moduleSettings.getChildren().add(ParametersLabel);

            for (Parameter parameter: settings.parameters) {

                VBox vBoxParameter = new VBox();

                Label parameterDescription = new Label(parameter.description);

                HBox hBoxParameter = new HBox();

                Label parameterName = new Label(parameter.name);

                TextField paramValue = new TextField();

                paramValue.setText(parameter.value);

                Label paramType = new Label(parameter.type);

                TextField minValue = new TextField();

                minValue.setText("max: " + parameter.minValue);

                TextField maxValue = new TextField();

                maxValue.setText("min: " + parameter.maxValue);

                Button saveButton = new Button("Save");

                vBoxParameter.getChildren().add(parameterDescription);

                hBoxParameter.getChildren().add(paramValue);

                hBoxParameter.getChildren().add(parameterName);

                hBoxParameter.getChildren().add(paramType);

                hBoxParameter.getChildren().add(minValue);

                hBoxParameter.getChildren().add(maxValue);

                vBoxParameter.getChildren().add(hBoxParameter);

                moduleSettings.getChildren().add(vBoxParameter);

                vBoxParameter.getChildren().addAll(saveButton);
            }

            vBox.getChildren().add(moduleSettings);
        }

        // Скроллер:

        ScrollBar scrollBar = new ScrollBar();

        scrollBar.setMin(0);

        scrollBar.setOrientation(Orientation.VERTICAL);

        vBox.setLayoutX(5);
        vBox.setSpacing(10);

        scrollBar.setLayoutX(Main.WIDTH-scrollBar.getWidth());
        scrollBar.setMin(0);
        scrollBar.setOrientation(Orientation.VERTICAL);
        scrollBar.setPrefHeight(Main.HEIGHT);
        scrollBar.setMax(90000);

        resultGroup.getChildren().addAll(vBox, scrollBar);

        scrollBar.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                vBox.setLayoutY(-new_val.doubleValue() + scroolSpeed);
            }
        });

        return resultGroup;
    }
}
