import org.apache.commons.cli.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ArgsParser {

    String outFileName;
    List<String> inFiles = new ArrayList<>();

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
        argsSet(cmd,args);

    }


    public void argsSet(CommandLine cmd, String[] args ) {



        String maskForInFiles = "in.+?txt";
        String maskForOutFiles = "out.+?txt";

        if (cmd.hasOption("i")) {
            System.out.println("Integer");
        }

        if (cmd.hasOption("s")) {

            System.out.println("String");

        }

        if (cmd.hasOption("a")) {

            System.out.println("ascending sort");

        }

        if (cmd.hasOption("d")) {

            System.out.println("descending sort");

        }


        for (String a : args){

            if(a.matches(maskForInFiles)){

                inFiles.add(a);
                System.out.println("in = " + a);

            }
            if (a.matches(maskForOutFiles)){

                outFileName= a;
                System.out.println("out = " + a);

            }

        }





    }

}
