package hhhhh;


public class LogElement
{
public static final String ORA = "ORA-";
public static final String WARNING = "Warning";
    
    public String fileName;
    public String logSegment;

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        builder.append("filename: \"");
        builder.append(fileName);
        builder.append("\";\n");
        builder.append("log segment: \"");
        builder.append(logSegment);
        builder.append("\"");

        return builder.toString();
    }
    
    public boolean containsORA()
    {
        return logSegment != null && logSegment.contains(ORA);
    }
    
    public boolean containsWarning()
    {
        return logSegment != null && logSegment.contains(WARNING);
    }
    
    public boolean isValid()
    {
        return !(containsORA() || containsWarning()); 
    }
}
