package hhhhh;


import java.util.ArrayList;
import java.util.HashMap;


public class Config
{
    public static final String PARAM_SEPARATOR = "separator";
    public static final String PARAM_UNVALID_SEGMENT_MARK = "unvMark";

    private static final String DEFAULT_CONFIG_FILE_PATH = "";
    private static HashMap<String, ArrayList<Object>> params = null;

    public static void loadConfig(String filePath)
    {
        Config.params = ConfigParser.getInstance().parseConfigFile(filePath);
    }

    public static void loadConfig()
    {
        Config.loadConfig(DEFAULT_CONFIG_FILE_PATH);
    }

    public ArrayList<Object> getParamValue(String paramName) throws Exception
    {
        if (params != null)
        {
            return params.get(paramName);
        }
        else
        {
            throw new Exception("Config not initialized");
        }
    }

}
