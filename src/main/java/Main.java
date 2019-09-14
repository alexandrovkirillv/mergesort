import org.apache.commons.cli.ParseException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static String outFileName;
    public static FileReader fileReader = new FileReader();
    public static String status;
    public static List<String> inFiles = new ArrayList<>();

    public static void main(String[] args) throws ParseException {

        ArgsParser argsParser = new ArgsParser();

        argsParser.parseArgs(args);
        outFileName = argsParser.getOutFileName();
        status = argsParser.getStatus();
        inFiles = argsParser.getInFiles();

        fileReader.readInteger(inFiles.get(0), inFiles.get(1), status);

    }

    public static void write(int i) throws IOException {

        Writer output = new BufferedWriter(new FileWriter("./src/main/resources/" + outFileName, true));

        String string = checkInTypeToWrite(i) ;
        output.append(string + "\n");
        output.flush();
        output.close();

    }

    public static String checkInTypeToWrite(int i) {

        String s;
        if (status.equals("string")) {

            char c = (char) i;
            s = Character.toString(c);

        } else {

            s = String.valueOf(i);

        }

        return s;
    }


}
