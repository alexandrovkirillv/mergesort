import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {


    public List<Integer> readInteger(String fileName, String fileName2) {


        File f = new File("./src/main/resources/" + fileName);
        File s = new File("./src/main/resources/" + fileName2);


        List<Integer> result = new ArrayList<>();

        try {
            LineIterator it = FileUtils.lineIterator(f, "UTF-8");
            LineIterator lt = FileUtils.lineIterator(s, "UTF-8");


            String str = it.nextLine();
            int a = Integer.parseInt(str);
            int b = 0;
            int c = 0;
            int lastA = 0;
            int lastB = 0;

            while ((it.hasNext()) & (lt.hasNext())) {

                if (c == a) {

                    str = it.next();
                    a = Integer.parseInt(str);


                } else {
                    String str2 = lt.next();
                    b = Integer.parseInt(str2);

                }

                if (a <= b) {

                    result.add(a);
                    c = a;

                } else {

                    result.add(b);
                    c = b;
                }

                lastA = a;
                lastB = b;



            }

            while ((it.hasNext()) | (lt.hasNext())) {


                if (lt.hasNext()) {

                    if (lastA <= lastB) {
                        result.add(lastB);
                        while (lt.hasNext()) {

                            String str2 = lt.next();
                            b = Integer.parseInt(str2);
                            result.add(b);
                        }
                    } else {

                        String str2 = lt.next();
                        b = Integer.parseInt(str2);


                        if (lastA < b) {

                            result.add(lastA);
                            while (lt.hasNext()) {

                                result.add(b);
                                str2 = lt.next();
                                b = Integer.parseInt(str2);

                            }
                        } else {
                            result.add(b);
                        }
                    }
                }

               else  {

                    if (lastB <= lastA) {
                        result.add(lastA);
                        while (it.hasNext()) {

                            str = it.next();
                            a = Integer.parseInt(str);
                            result.add(a);
                        }
                    } else {

                        str = it.next();
                        a = Integer.parseInt(str);


                        if (lastB < a) {

                            result.add(lastB);
                            while (it.hasNext()) {

                                result.add(a);
                                str = it.next();
                                a = Integer.parseInt(str);

                            }
                        } else {
                            result.add(a);
                        }
                    }
                }
            }

            if (lastA >= result.get(result.size() - 1)) {
                result.add(lastA);
            }
            if (lastB>= result.get(result.size()-1)){
                result.add(lastB);
            }


            it.close();
            lt.close();



        } catch (
                FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        return result;
    }

}
