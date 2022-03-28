import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            String[] firstArray = setArray();
            String[] secondArray = setArray();

            Map<String, String> result = SimilarStringsFinder.find(firstArray, secondArray);

            result.forEach((s1, s2) -> System.out.println(s1 + " : " + s2));

        } catch (IOException e){
            System.out.println("Input error");
            e.printStackTrace();
        }
    }

    public static String[] setArray() throws IOException {
        try {
            Scanner console = new Scanner(System.in);

            System.out.print("Number of strings in the array: ");
            int size = console.nextInt();
            String[] result = new String[size];

            console.nextLine();
            for (int i = 0; i < size; i++) {
                System.out.print((i + 1) + ": ");
                result[i] = console.nextLine();
            }

            return result;
        } catch (Exception e) {
            throw new IOException();
        }
    }
}
