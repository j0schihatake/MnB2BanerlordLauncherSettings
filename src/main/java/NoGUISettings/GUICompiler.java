package NoGUISettings;

import NoGUISettings.TemplateComponents.ModuleSettings;
import NoGUISettings.TemplateComponents.Parameter;
import javafx.geometry.Pos;
import javafx.scene.control.*;
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

    public static ArrayList<ModuleSettings> allModules;

    public ScrollPane createGUI(){

        allModules = new ArrayList<ModuleSettings>();

        test();

        GridPane resultGroup = new GridPane();

        resultGroup.getStylesheets().add(Main.stylesheet);

        VBox vBox = new VBox();

        vBox.getStyleClass().add("vboxGray");

        vBox.setBackground(Main.background);

        vBox.setFillWidth(true);

        //-----------------------------------------Вывод информации о модулях:

        for (ModuleSettings settings: allModules) {
            vBox.getChildren().add(getModuleSettingsGUI(settings));
        }

        resultGroup.setAlignment(Pos.BASELINE_CENTER);

        resultGroup.add (vBox, 2, 1);

        ScrollPane scrollPane = new ScrollPane(resultGroup);

        scrollPane.setFitToHeight(true);

        return scrollPane;
    }

    public VBox getModuleSettingsGUI(ModuleSettings settings){

        VBox moduleSettings = new VBox();

        moduleSettings.getStyleClass().add("vbox");

        Label modNameLabel = new Label("ModName: " + settings.moduleName);

        modNameLabel.getStyleClass().add("label-header");

        Label modDescriptionLabel = new Label("ModDescription: " + settings.description);

        moduleSettings.getChildren().add(modNameLabel);

        moduleSettings.getChildren().add(modDescriptionLabel);

        for (Parameter parameter: settings.parameters) {
            moduleSettings.getChildren().add(getParameterGUI(parameter));
        }

        Button saveButton = new Button("Save");

        moduleSettings.getChildren().addAll(saveButton);

        return moduleSettings;
    }

    public VBox getParameterGUI(Parameter parameter){

        VBox vBoxParameter = new VBox();

        Label parameterDescription = new Label(parameter.description);

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

        return vBoxParameter;
    }

    public void test(){
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
    }
}
