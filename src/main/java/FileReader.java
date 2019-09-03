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
            int integer = 0;
            int integer2 = 0;
            int counter = 0;

            while (it.hasNext()) {

                if (lt.hasNext()) {

                    if  (integer >= integer2) {

                        String str2 = lt.nextLine();
                        integer2 = Integer.parseInt(str2);
                        result.add(integer2);

                    } else {


                        String str = it.nextLine();
                        integer = Integer.parseInt(str);
                        result.add(integer);
                    }


                } else {

                    String str = it.nextLine();
                    integer = Integer.parseInt(str);
                    result.add(integer);


                }


            }


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        result.remove(0);
        result.remove(0);

        return result;
    }

}
