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
            int coutA = 0;
            int coutB = 0;


            while ((it.hasNext()) & (lt.hasNext())) {

                if (c == a) {

                    str = it.next();
                    a = Integer.parseInt(str);

                    coutA++;

                } else {
                    String str2 = lt.next();
                    b = Integer.parseInt(str2);

                    coutB++;

                }
                System.out.println("==========");
                System.out.println("a = " + a);
                System.out.println("b = " + b);
                if (a <= b) {

                    result.add(a);
                    c = a;

                } else {

                    result.add(b);
                    c = b;
                }

            }

            while ((it.hasNext()) | (lt.hasNext())) {

                if (!it.hasNext()) {
                    String str2 = lt.nextLine();
                    b = Integer.parseInt(str2);
                    result.add(b);



                } else if (!lt.hasNext()) {

                    str = it.nextLine();
                    a = Integer.parseInt(str);
                    result.add(a);


                }

            }
//            else {
//
//                    String str = it.nextLine();
//                    a = Integer.parseInt(str);
//                    result.add(a);

           // System.out.println("coutA = " + coutA);
          //  System.out.println("coutB = " + coutB);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

         //result.remove(0);

        return result;
    }

}
