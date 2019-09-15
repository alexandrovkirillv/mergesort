package mergesort;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.input.ReversedLinesFileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileReader {


    public void readFile(String fileName, String fileName2, String statusOfSort, String statusOfType) throws IOException {

        if (statusOfSort.equals("asc")) {
            readFileAndAscendingSort(fileName, fileName2, statusOfSort, statusOfType);
        } else if (statusOfSort.equals("dec")) {
            readFilesAndDescendingSort(fileName, fileName2, statusOfSort, statusOfType);
        }

    }


    public void readFileAndAscendingSort(String fileName, String fileName2, String statusOfSort, String statusOfType) {


        File f = new File(fileName);
        File s = new File(fileName2);


        try {
            LineIterator fileA = FileUtils.lineIterator(f, "UTF-8");
            LineIterator fileB = FileUtils.lineIterator(s, "UTF-8");

            if (!fileA.hasNext()) {

                readOneFile(fileName2, statusOfSort, statusOfType);
                return;

            } else if (!fileB.hasNext()) {
                readOneFile(fileName, statusOfSort, statusOfType);
                return;
            }

            String strA = fileA.nextLine();

            int currentA = checkInType(strA, statusOfType);
            int currentB = 0;
            int c = 0;
            int lastNumberA = 0;
            int lastNumberB = 0;
            int previousA;
            int previousB;

            FileWriter fileWriter = new FileWriter();

            while ((fileA.hasNext()) & (fileB.hasNext())) {

                if (c == currentA) {

                    strA = fileA.next();
                    previousA = currentA;
                    currentA = checkInType(strA, statusOfType);

                    if (previousA > currentA) {
                        currentA = previousA;
                        continue;
                    }


                } else {
                    String strB = fileB.next();
                    previousB = currentB;
                    currentB = checkInType(strB, statusOfType);

                    if (previousB > currentB) {
                        currentB = previousB;

                        continue;
                    }

                }

                if (currentA <= currentB) {

                    fileWriter.write(currentA);

                    c = currentA;

                } else {

                    fileWriter.write(currentB);

                    c = currentB;
                }

                lastNumberA = currentA;
                lastNumberB = currentB;

            }


            while ((fileA.hasNext()) | (fileB.hasNext())) {

                if (fileB.hasNext()) {

                    if (lastNumberA <= lastNumberB) {
                        fileWriter.write(lastNumberB);

                        while (fileB.hasNext()) {

                            previousB = currentB;
                            String strB = fileB.next();
                            currentB = checkInType(strB, statusOfType);


                            if (previousB > currentB) {
                                currentB = previousB;
                                break;
                            }

                            fileWriter.write(currentB);

                        }
                    } else {

                        previousB = currentB;
                        String strB = fileB.next();
                        currentB = checkInType(strB, statusOfType);


                        if (previousB > currentB) {

                            break;

                        }

                        if (lastNumberA < currentB) {

                            fileWriter.write(lastNumberA);

                            fileWriter.write(currentB);

                            while (fileB.hasNext()) {

                                previousB = currentB;
                                strB = fileB.next();
                                currentB = checkInType(strB, statusOfType);
                                if (previousB > currentB) {
                                    break;
                                }
                                fileWriter.write(currentB);

                            }
                        } else {
                            fileWriter.write(currentB);

                            if (!fileB.hasNext()) {
                                fileWriter.write(lastNumberA);
                            }

                        }
                    }
                } else {

                    if (lastNumberB <= lastNumberA) {

                        fileWriter.write(lastNumberA);

                        while (fileA.hasNext()) {

                            previousA = currentA;
                            strA = fileA.next();
                            currentA = checkInType(strA, statusOfType);

                            if (previousA > currentA) {

                                currentA = previousA;
                                System.out.println("=======");
                                break;

                            }

                            fileWriter.write(currentA);

                        }
                    } else {

                        previousA = currentA;
                        strA = fileA.next();
                        currentA = checkInType(strA, statusOfType);

                        if (previousA > currentA) {
                            System.out.println("========");
                            break;
                        }

                        if (lastNumberB < currentA) {

                            fileWriter.write(lastNumberB);
                            fileWriter.write(currentA);

                            while (fileA.hasNext()) {

                                previousA = currentA;
                                strA = fileA.next();
                                currentA = checkInType(strA, statusOfType);

                                if (previousA > currentA) {
                                    System.out.println("========");
                                    break;

                                }
                                fileWriter.write(currentA);

                            }
                        } else {
                            fileWriter.write(currentA);
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


    public void readFilesAndDescendingSort(String fileName, String fileName2, String statusOfSort, String statusOfType) throws IOException {

        File f = new File(fileName);
        File s = new File(fileName2);
        try {
            ReversedLinesFileReader fileA = new ReversedLinesFileReader(f, Charset.defaultCharset());
            ReversedLinesFileReader fileB = new ReversedLinesFileReader(s, Charset.defaultCharset());

            String tempA;
            String tempB;

            if ((tempA = fileA.readLine()) == null) {

                readOneFile(fileName2, statusOfSort, statusOfType);
                return;

            } else if ((tempB = fileB.readLine()) == null) {
                readOneFile(fileName, statusOfSort, statusOfType);
                return;
            }

            String currentStrA = tempA;
            System.out.println("tempA = " + tempA);
            System.out.println("tempB = " + tempB);
            String currentStrB = tempB;
            int currentA = checkInType(currentStrA, statusOfType);
            int currentB = checkInType(currentStrB, statusOfType);
            int c = 0;
            int lastNumberA = 0;
            int lastNumberB = 0;
            int previousA;
            int previousB;

            FileWriter fileWriter = new FileWriter();

            do {

                if (currentA >= currentB) {

                    fileWriter.write(currentA);

                    c = currentA;

                } else {

                    fileWriter.write(currentB);

                    c = currentB;
                }

                if (c == currentA) {

                    currentStrA = fileA.readLine();
                    previousA = currentA;
                    currentA = checkInType(currentStrA, statusOfType);

                    if (previousA < currentA) {
                        currentA = previousA;
                        continue;
                    }


                } else {
                    String currentSrtB = fileB.readLine();
                    previousB = currentB;
                    currentB = checkInType(currentSrtB, statusOfType);


                    if (previousB < currentB) {
                        currentB = previousB;
                        continue;
                    }

                }


            } while ((currentStrA != null) & (currentStrB != null));


            fileA.close();
            fileB.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);

        } catch (NullPointerException e) {

            System.out.println("NullPointerException");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private int checkInType(String string, String statusOfType) {

        int fin = 0;

        if (statusOfType.equals("int")) {

            try {
                fin = Integer.parseInt(string);
            } catch (NumberFormatException e) {


            }


        } else if (statusOfType.equals("string")) {

            try {
                fin = string.charAt(0);
            } catch (NumberFormatException e) {

            }

        }

        return fin;
    }

    public void readOneFileAndDescendingSort(String inFileName, String statusOfType) {

        try {
            ReversedLinesFileReader fileA = new ReversedLinesFileReader(new File(inFileName), Charset.defaultCharset());

            String currentSrtA = fileA.readLine();
            int currentA = checkInType(currentSrtA, statusOfType);
            int previousA;
            FileWriter fileWriter = new FileWriter();

            do {

                fileWriter.write(currentA);

                previousA = currentA;
                currentSrtA = fileA.readLine();
                currentA = checkInType(currentSrtA, statusOfType);

                if (previousA < currentA) {
                    break;
                }

            } while (currentSrtA != null);

            fileA.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);

        } catch (NullPointerException e) {

            System.out.println("NullPointerException");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void readOneFileAndAscendingSort(String inFileName, String statusOfType) {

        try {
            LineIterator fileA = FileUtils.lineIterator(new File(inFileName));

            String currentSrtA = fileA.nextLine();
            int currentA = checkInType(currentSrtA, statusOfType);
            int previousA;
            FileWriter fileWriter = new FileWriter();

            while (fileA.hasNext()) {

                fileWriter.write(currentA);

                previousA = currentA;
                currentSrtA = fileA.nextLine();
                currentA = checkInType(currentSrtA, statusOfType);

                if (previousA > currentA) {
                    break;
                }

            }
            fileWriter.write(currentA);
            fileA.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);

        } catch (NullPointerException e) {

            System.out.println("NullPointerException");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void readOneFile(String inFileName, String statusOfSort, String statusOfType) {


        if (statusOfSort.equals("dec")) {
            readOneFileAndDescendingSort(inFileName, statusOfType);

        } else {

            readOneFileAndAscendingSort(inFileName, statusOfType);
        }


    }
}
