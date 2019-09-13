import java.io.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

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

        String outFileName = "out.txt";
        //File file = new File("./src/main/resources/" + outFileName);
        //PrintWriter pw = new PrintWriter(file);

        Writer output = new BufferedWriter(new FileWriter("./src/main/resources/" + outFileName, true));

        System.out.println("i= " + i);
        output.append(i + "\n");
        output.flush();
        output.close();
    }

    public static void writeFile() throws IOException {

        String outFileName = "test5.txt";
        //File file = new File("./src/main/resources/" + outFileName);
        //PrintWriter pw = new PrintWriter(file);

        Writer output = new BufferedWriter(new FileWriter("./src/main/resources/" + outFileName, true));

        for(int i = -50; i<1000; i++)
        output.write(i + "\n");

        output.close();
    }




}
