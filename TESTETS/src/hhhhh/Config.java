package hhhhh;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Config
{
    public static final String PARAM_SEPARATOR = "separator";
    public static final String PARAM_UNVALID_SEGMENT_MARK = "unvMark";
    
    private static final String DEFAULT_CONFIG_FILE_PATH = "";
    private static HashMap<String, ArrayList<Object>> params;

    public static void loadConfig(String filePath)
    {
        Config.params = ConfigParser.getInstance().parseConfigFile(filePath);
    }

    public static void loadConfig()
    {
        Config.loadConfig(DEFAULT_CONFIG_FILE_PATH);
    }
    
    public ArrayList<Object> getParamValue(String paramName)
    {
        return params.get(paramName);
    }

}
