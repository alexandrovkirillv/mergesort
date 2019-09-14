import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWriter {

    private Main main = new Main();

    public void write(int i) throws IOException {

        String outFileName = main.getOutFileName();

        Writer output = new BufferedWriter(new java.io.FileWriter("./src/main/resources/" + outFileName, true));

        String string = checkInTypeToWrite(i) ;
        output.append(string + "\n");
        output.flush();
        output.close();

    }

    private String checkInTypeToWrite(int i) {

        String status = main.getStatus();

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
