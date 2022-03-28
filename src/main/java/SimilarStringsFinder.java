import java.util.*;

public class SimilarStringsFinder {

    private static final List<String> prepositions = new ArrayList<>(Arrays.asList(
            "без", "в", "до", "для", "за", "из", "к", "на", "над", "о", "об", "от", "по", "под", "пред",
            "при", "про", "с", "у" , "через", "и"));


    public static Map<String, String> find(String[] firstArray, String[] secondArray) {
        Map<String, String> result = new LinkedHashMap<>();

        for (String str : firstArray) {
            result.put(str, getSimilar(str, secondArray));
        }

        return result;
    }

    private static String getSimilar(String str, String[] secondArray) {
        String mostSimilarString = null;
        int maxNumberOfCoincidences = 0;

        String[] strSplit = splitAndClear(str);

        for (String secondString : secondArray) {
            String[] secondStringSplit = splitAndClear(secondString);

            int numberOfCoincidences = 0;
            for (String firstWord : strSplit) {
                for (String secondWord : secondStringSplit) {
                    if (firstWord.equals(secondWord))
                        numberOfCoincidences++;
                }
            }

            if (numberOfCoincidences > maxNumberOfCoincidences) {
                mostSimilarString = secondString;
                maxNumberOfCoincidences = numberOfCoincidences;
            }
        }

        return (mostSimilarString != null) ? mostSimilarString : "?";
    }

    private static String[] splitAndClear(String str) {
        return Arrays.stream(str.toLowerCase()
                        .replaceAll("\\pP", "")
                        .split(" "))
                .distinct()
                .filter(word -> !isPrepositions(word))
                .toArray(String[]::new);
    }

    private static boolean isPrepositions(String str) {
        return prepositions.contains(str);
    }
}
