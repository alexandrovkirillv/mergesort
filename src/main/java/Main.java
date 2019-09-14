import org.apache.commons.cli.ParseException;

import java.util.List;

public class Main {

    private static String status;
    private static String outFileName;

    public static String getOutFileName() {
        return outFileName;
    }

    public String getStatus() {
        return status;
    }

    public static void main(String[] args) throws ParseException {


        ArgsParser argsParser = new ArgsParser();
        argsParser.parseArgs(args);
        outFileName = argsParser.getOutFileName();
        status = argsParser.getStatus();

        List<String> inFiles = argsParser.getInFiles();


        FileReader fileReader = new FileReader();
        fileReader.readFile(inFiles.get(0), inFiles.get(1), status);

    }


}
