package hhhhh;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Hhhhhh
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        try
        {

            File file = new File("patch.log");

            FileReader fileReader = new FileReader(file);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            ArrayList<LogElement> logArray = new ArrayList<LogElement>();
            ArrayList<LogElement> unvalidSegmentsArray = new ArrayList<LogElement>();
            LogElement logElement = new LogElement();
            StringBuilder logSegment = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null)
            {
                if (!line.contains(".sql"))
                {
                    logSegment.append(line);
                    logSegment.append("\n");
                }
                else
                {
                    logElement.logSegment = logSegment.toString();
                    logArray.add(logElement);
                    if (!logElement.isValid())
                    {
                        unvalidSegmentsArray.add(logElement);
                    }

                    logElement = new LogElement();
                    logElement.fileName = line;

                    logSegment = new StringBuilder();
                    logSegment.append(line);
                    logSegment.append("\n");
                }

            }
            
            bufferedReader.close();

            logElement.logSegment = logSegment.toString();
            logArray.add(logElement);
            if (!logElement.isValid())
            {
                unvalidSegmentsArray.add(logElement);
            }
            
            BufferedWriter writer = new BufferedWriter(new FileWriter("out.log"));
            
            for (LogElement elem : unvalidSegmentsArray)
            {
                writer.write("\n#############################\n\n");
                writer.write(elem.logSegment);
            }
            
            writer.close();

            System.out.println();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
