import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        FileReader fileReader = new FileReader();

        String fileName = "text1.txt";
        String fileName2 = "test3.txt";

        fileReader.readInteger(fileName, fileName2);


        String str = "S";
        char[] chars = str.toCharArray();
        char ch = 's';
        int letter = chars[0];

        //write();


        // System.out.println("letter is " + letter );

    }

    public static void write(int i) throws FileNotFoundException {

        String outFileName = "test4.txt";
        File file = new File("./src/main/resources/" + outFileName);
        PrintWriter pw = new PrintWriter(file);

        for(int j = 0 ;)
        pw.append(Integer.toString(i));

        pw.close();
    }


}
