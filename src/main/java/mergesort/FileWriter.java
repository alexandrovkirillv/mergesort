package mergesort;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.input.ReversedLinesFileReader;

import java.io.*;
import java.nio.charset.Charset;

public class FileWriter {

    private Main main = new Main();

    public void write(int i) throws IOException {


        Writer output = new PrintWriter(new java.io.FileWriter("temp.txt", true));

        String string = checkInTypeToWrite(i);

        output.append(string);
        output.append(" \n");
        output.flush();
        output.close();

    }

    public void eraseFile(String fileName) throws FileNotFoundException {

        PrintWriter output = new PrintWriter(new File(fileName));
        output.write("");
        output.flush();
        output.close();

    }

    public void writeToOutFile(String statusOfSort) throws IOException {

        if (statusOfSort.equals("dec")) {
            descendingWriteToOutFile("temp.txt", main.getOutFileName());

        } else if (statusOfSort.equals("asc")) {
            ascendingWriteToOutFile("temp.txt", main.getOutFileName());
        }

    }

    public void descendingWriteToOutFile(String inFileName, String outFileName) throws IOException {


        try {
            ReversedLinesFileReader fileA = new ReversedLinesFileReader(new File(inFileName), Charset.defaultCharset());
            Writer printWriter = new PrintWriter(new File(outFileName));
            String string;

            while ((string = fileA.readLine()) != null) {

                printWriter.write(string + " \n");


            }

            fileA.close();
            printWriter.flush();
            printWriter.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found" + inFileName);
            System.exit(0);

        } catch (NullPointerException e) {

            System.out.println("NullPointerException");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void ascendingWriteToOutFile(String inFileName, String outFileName) throws IOException {


        String string;
        try {
            LineIterator fileA = FileUtils.lineIterator(new File(inFileName), "UTF-8");
            Writer printWriter = new PrintWriter(new File(outFileName));


            while (fileA.hasNext()) {

                string = fileA.nextLine();

                printWriter.write(string + " \n");

            }

            fileA.close();
            printWriter.flush();
            printWriter.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);

        } catch (NullPointerException e) {

            System.out.println("NullPointerException");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private String checkInTypeToWrite(int i) {

        String status = main.getStatusOfType();

        String s;
        if (status.equals("string")) {

            char c = (char) i;
            s = Character.toString(c);

        } else {

            s = String.valueOf(i);

        }

        return s;
    }

    public void checkDescendingSort(String statusOfSort) throws IOException {


        if (statusOfSort.equals("dec")) {

            descendingWriteToOutFile(main.getOutFileName(), "temp.txt");

            ascendingWriteToOutFile("temp.txt", main.getOutFileName());

            eraseFile("temp.txt");
        }

    }

}
