import org.apache.commons.cli.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Main {

    public static String outFileName;

    public static void main(String[] args) throws IOException, ParseException {

        ArgsParser argsParser = new ArgsParser();

        argsParser.parseArgs(args);
        outFileName = argsParser.getOutFileName();

        FileReader fileReader = new FileReader();

        String fileName = "text1.txt";
        String fileName2 = "text2.txt";

        fileReader.readInteger(fileName, fileName2);


        String str = "S";
        char[] chars = str.toCharArray();
        char ch = 's';
        int letter = chars[0];


        //writeFile();


        // System.out.println("letter is " + letter );

    }

    public static void write(int i) throws IOException {


        //File file = new File("./src/main/resources/" + outFileName);
        //PrintWriter pw = new PrintWriter(file);

        Writer output = new BufferedWriter(new FileWriter("./src/main/resources/" + outFileName, true));

        output.append(i + "\n");
        output.flush();
        output.close();

    }

    public static void writeFile() throws IOException {

        String outFileName = "test5.txt";
        //File file = new File("./src/main/resources/" + outFileName);
        //PrintWriter pw = new PrintWriter(file);

        Writer output = new BufferedWriter(new FileWriter("./src/main/resources/" + outFileName, true));

        for (int i = -50; i < 1000; i++)
            output.write(i + "\n");

        output.close();
    }


}
