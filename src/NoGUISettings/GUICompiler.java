package NoGUISettings;

import NoGUISettings.TemplateComponents.ModuleSettings;
import NoGUISettings.TemplateComponents.Parameter;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
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

        // Test
        ///*
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
        //*/


        Group resultGroup = new Group();

        resultGroup.getStylesheets().add(Main.stylesheet);

        BackgroundImage backgroundImage = new BackgroundImage(new Image("/NoGUISettings/TemplateComponents/background.jpeg",32,32,false,true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        Background background = new Background(backgroundImage);

        vBox = new VBox();

        vBox.getStyleClass().add("vboxGray");

        vBox.setBackground(background);

        vBox.setFillWidth(true);

        //-----------------------------------------Вывод информации о модулях:

        for (ModuleSettings settings: allModules) {

            VBox moduleSettings = new VBox();

            moduleSettings.getStyleClass().add("vbox");

            Label modNameLabel = new Label("ModName: " + settings.moduleName);

            modNameLabel.getStyleClass().add("label-header");

            Label modDescriptionLabel = new Label("ModDescription: " + settings.description);

            modDescriptionLabel.setMaxWidth(700);

            modDescriptionLabel.setWrapText(true);

            modDescriptionLabel.setMaxHeight(9000);

            moduleSettings.getChildren().add(modNameLabel);

            moduleSettings.getChildren().add(modDescriptionLabel);

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
}
