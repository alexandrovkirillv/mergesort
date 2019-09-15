package mergesort;

import org.apache.commons.cli.*;

import java.util.ArrayList;
import java.util.List;

public class ArgsParser {

    private String outFileName;
    private String statusOfType;
    private String statusOfSort;
    private List<String> inFiles = new ArrayList<>();

    public String getOutFileName() {
        return outFileName;
    }

    public List<String> getInFiles() {
        return inFiles;
    }

    public void parseArgs(String[] args) throws ParseException {

        Options options = new Options();

        options.addOption("i", false, "Sort for integer");
        options.addOption("s", false, "Sort for string");
        options.addOption("d", false, "descending sort");
        options.addOption("a", false, "ascending sort");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);
        argsSet(cmd, args);

    }


    public String getStatusOfSort() {
        return statusOfSort;
    }

    public String getStatusOfType() {
        return statusOfType;
    }

    public void argsSet(CommandLine cmd, String[] args) {


        String maskForInFiles = "in.+?txt";
        String maskForOutFiles = "out.+?txt";

        if (cmd.hasOption("i")) {
            statusOfType = "int";
        }

        if (cmd.hasOption("s")) {

            statusOfType = "string";

        }

        if (cmd.hasOption("a")) {

            statusOfSort = "asc";

        }

        if (cmd.hasOption("d")) {

            statusOfSort = "dec";

        }

        if ((!cmd.hasOption("a")) & (!cmd.hasOption("d"))) {

            statusOfSort = "asc";
        }


        for (String a : args) {

            if (a.matches(maskForInFiles)) {

                inFiles.add(a);

            }
            if (a.matches(maskForOutFiles)) {

                outFileName = a;

            }

        }

    }

}
