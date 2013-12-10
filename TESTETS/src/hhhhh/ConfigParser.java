package hhhhh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConfigParser
{
    private List<String> paramsNames = Arrays
        .asList(Config.PARAM_SEPARATOR, Config.PARAM_UNVALID_SEGMENT_MARK);
    private static ConfigParser instance = null;

    // public ConfigParser()
    // {
    // // TODO Auto-generated constructor stub
    // }

    public static ConfigParser getInstance()
    {
        if (instance == null)
        {
            instance = new ConfigParser();
        }

        return instance;
    }

    private String getLineParamName(String line)
    {
        String result = null;

        for (String paramName : paramsNames)
        {
            if (line.startsWith(paramName, 0))
            {
                result = paramName;
                break;
            }
        }

        return result;
    }

    public HashMap<String, ArrayList<Object>> parseConfigFile(
        String filepath)
    {
        try
        {
            HashMap<String, ArrayList<Object>> params = new HashMap<String, ArrayList<Object>>();

            BufferedReader reader = new BufferedReader(new FileReader(
                new File(filepath)));

            String paramName;
            String line;
            while ((line = reader.readLine()) != null)
            {
                paramName = getLineParamName(line);
                if (paramName != null)
                {
                    putInMap(params, paramName, getValue(line));
                }
            }

            reader.close();

            return params;

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

    }

    private Object getValue(String line)
    {
        String[] array = line.split("'");
        return array[1];
    }

    private void putInMap(HashMap<String, ArrayList<Object>> map,
        String paramName, Object value)
    {
        ArrayList<Object> values = map.get(paramName);

        if (values == null)
        {
            values = new ArrayList<Object>();
            values.add(value);
            map.put(paramName, values);
        }
        else
        {
            values.add(value);
        }
    }

}
