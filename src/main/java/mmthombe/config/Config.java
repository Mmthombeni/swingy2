package mmthombe.config;

import mmthombe.enums.DisplayMode;

public class Config{
    public static DisplayMode DISPLAY_MODE = DisplayMode.GUI;
    public static Boolean IS_DEVELOPMENT = false;

    public void init(String[] args){
        for (String str: args) {
            if (str.equalsIgnoreCase("console") || str.equalsIgnoreCase("GUI")){
                if (str.equalsIgnoreCase("console")){
                    DISPLAY_MODE = DisplayMode.CONSOLE;
                }
            }
            else if (str.equalsIgnoreCase("dev") || str.equalsIgnoreCase("development")){
                IS_DEVELOPMENT = true;
            }
        }
    }
}