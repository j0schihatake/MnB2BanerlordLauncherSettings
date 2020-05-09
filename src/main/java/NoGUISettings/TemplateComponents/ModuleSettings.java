package NoGUISettings.TemplateComponents;

import java.util.ArrayList;

public class ModuleSettings {

    public String moduleName;

    public String description;

    public ArrayList<Parameter> parameters;

    public ModuleSettings(){
        parameters = new ArrayList<Parameter>();
    }
}
