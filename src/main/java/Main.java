import java.util.List;

public class Main {

    public static void main(String[] args) {

        FileReader fileReader = new FileReader();

        String fileName = "text1.txt";
        String fileName2 = "text2.txt";

        List<Integer> result = fileReader.readInteger(fileName,fileName2);

        System.out.println(result);

    }


}
