import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {


    public void readFile(String fileName, String fileName2, String status) {


        File f = new File("./src/main/resources/" + fileName);
        File s = new File("./src/main/resources/" + fileName2);


        try {
            LineIterator fileA = FileUtils.lineIterator(f, "UTF-8");
            LineIterator fileB = FileUtils.lineIterator(s, "UTF-8");


            String strA = fileA.nextLine();

            int numberA = checkInType(strA, status);
            int numberB = 0;
            int c = 0;
            int lastNumberA = 0;
            int lastNumberB = 0;
            FileWriter fileWriter = new FileWriter();

            while ((fileA.hasNext()) & (fileB.hasNext())) {

                if (c == numberA) {

                    strA = fileA.next();
                    numberA = checkInType(strA, status);


                } else {
                    String strB = fileB.next();
                    numberB = checkInType(strB, status);

                }

                if (numberA <= numberB) {

                    fileWriter.write(numberA);

                    c = numberA;

                } else {

                    fileWriter.write(numberB);

                    c = numberB;
                }

                lastNumberA = numberA;
                lastNumberB = numberB;

            }


            while ((fileA.hasNext()) | (fileB.hasNext())) {


                if (fileB.hasNext()) {

                    if (lastNumberA <= lastNumberB) {
                        fileWriter.write(lastNumberB);

                        while (fileB.hasNext()) {

                            String strB = fileB.next();
                            numberB = checkInType(strB, status);

                            fileWriter.write(numberB);


                        }
                    } else {

                        String strB = fileB.next();
                        numberB = checkInType(strB, status);


                        if (lastNumberA < numberB) {

                            fileWriter.write(lastNumberA);

                            fileWriter.write(numberB);

                            while (fileB.hasNext()) {

                                strB = fileB.next();
                                numberB = checkInType(strB, status);
                                fileWriter.write(numberB);

                            }
                        } else {
                            fileWriter.write(numberB);
                            if (!fileB.hasNext()) {
                                fileWriter.write(lastNumberA);
                            }

                        }
                    }
                } else {

                    if (lastNumberB <= lastNumberA) {

                        fileWriter.write(lastNumberA);

                        while (fileA.hasNext()) {

                            strA = fileA.next();
                            numberA = checkInType(strA, status);
                            fileWriter.write(numberA);

                        }
                    } else {

                        strA = fileA.next();
                        numberA = checkInType(strA, status);


                        if (lastNumberB < numberA) {

                            fileWriter.write(lastNumberB);
                            fileWriter.write(numberA);

                            while (fileA.hasNext()) {


                                strA = fileA.next();
                                numberA = checkInType(strA, status);
                                fileWriter.write(numberA);

                            }
                        } else {
                            fileWriter.write(numberA);
                            if (!fileA.hasNext()) {
                                fileWriter.write(lastNumberB);
                            }
                        }
                    }
                }
            }

            fileA.close();
            fileB.close();

        } catch (
                FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

    private int checkInType(String string, String status) {

        int fin = 0;

        if (status.equals("int")) {

            try {
                fin = Integer.parseInt(string);
            } catch (NumberFormatException e) {
                System.out.println("Wrong format");
            }


        } else if (status.equals("string")) {

            try {
                fin = string.charAt(0);
            } catch (NumberFormatException e) {
                System.out.println("Wrong format");
            }

        }

        return fin;
    }


}
