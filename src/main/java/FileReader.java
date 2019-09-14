import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {


    public void readInteger(String fileName, String fileName2, String status) {


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
            Main main = new Main();

            while ((fileA.hasNext()) & (fileB.hasNext())) {

                if (c == numberA) {

                    strA = fileA.next();
                    numberA = checkInType(strA, status);


                } else {
                    String strB = fileB.next();
                    numberB = checkInType(strB, status);

                }

                if (numberA <= numberB) {

                    main.write(numberA);

                    c = numberA;

                } else {

                    main.write(numberB);

                    c = numberB;
                }

                lastNumberA = numberA;
                lastNumberB = numberB;

            }


            while ((fileA.hasNext()) | (fileB.hasNext())) {


                if (fileB.hasNext()) {

                    if (lastNumberA <= lastNumberB) {
                        main.write(lastNumberB);

                        while (fileB.hasNext()) {

                            String strB = fileB.next();
                            numberB = checkInType(strB, status);

                            main.write(numberB);


                        }
                    } else {

                        String strB = fileB.next();
                        numberB = checkInType(strB, status);


                        if (lastNumberA < numberB) {

                            main.write(lastNumberA);

                            main.write(numberB);

                            while (fileB.hasNext()) {

                                strB = fileB.next();
                                numberB = checkInType(strB, status);
                                main.write(numberB);

                            }
                        } else {
                            main.write(numberB);
                            if (!fileB.hasNext()) {
                                main.write(lastNumberA);
                            }

                        }
                    }
                } else {

                    if (lastNumberB <= lastNumberA) {

                        main.write(lastNumberA);

                        while (fileA.hasNext()) {

                            strA = fileA.next();
                            numberA = checkInType(strA, status);
                            main.write(numberA);

                        }
                    } else {

                        strA = fileA.next();
                        numberA = checkInType(strA, status);


                        if (lastNumberB < numberA) {

                            main.write(lastNumberB);
                            main.write(numberA);

                            while (fileA.hasNext()) {


                                strA = fileA.next();
                                numberA = checkInType(strA, status);
                                main.write(numberA);

                            }
                        } else {
                            main.write(numberA);
                            if (!fileA.hasNext()) {
                                main.write(lastNumberB);
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

    public int checkInType(String string, String status) {

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
