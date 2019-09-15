package mergesort;

import mergesort.ArgsParser;
import mergesort.FileReader;
import mergesort.FileWriter;
import org.apache.commons.cli.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * This is a utility which is sorting arrays of Integers or Chars from files (in1,in2,in3 ... etc).
 *
 * @author Alexandrov Kirill
 * @version 1.0
 */

public class Main {

    private static String statusOfType;
    private static String statusOfSort;
    private static String outFileName;
    private static List<String> inFiles = new ArrayList<>();

    public static String getOutFileName() {
        return outFileName;
    }

    public static String getStatusOfType() {
        return statusOfType;
    }

    public static void main(String[] args) throws ParseException, IOException {


        ArgsParser argsParser = new ArgsParser();
        argsParser.parseArgs(args);

        outFileName = argsParser.getOutFileName();
        statusOfSort = argsParser.getStatusOfSort();
        statusOfType = argsParser.getStatusOfType();
        inFiles = argsParser.getInFiles();

        readFiles();

    }

    private static void readFiles() throws IOException {

        FileReader fileReader = new FileReader();
        FileWriter fileWriter = new FileWriter();

        for (String l : inFiles) {

            fileReader.readFile(outFileName, l, statusOfSort, statusOfType);
            fileWriter.writeToOutFite(statusOfSort);
            fileWriter.eraseFile("temp.txt");
        }

        fileWriter.checkDescendingSort(statusOfSort);

    }


}
