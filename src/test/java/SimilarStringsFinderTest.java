import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class SimilarStringsFinderTest {

    @Test
    public void findTest1() {
        String[] firstArray = new String[]{"гвоздь", "шуруп", "краска синяя", "ведро для воды"};
        String[] secondArray = new String[]{"краска", "корыто для воды", "шуруп 3х1.5"};

        Map<String, String> expect = new LinkedHashMap<>();
        expect.put("гвоздь", "?");
        expect.put("шуруп", "шуруп 3х1.5");
        expect.put("краска синяя", "краска");
        expect.put("ведро для воды", "корыто для воды");

        assertEquals(expect, SimilarStringsFinder.find(firstArray, secondArray));
    }

    @Test
    public void findTestPunct() {
        String[] firstArray = new String[]{"гвоздь", "шуруп,", "(краска) (синяя)", "ведро для, воды,"};
        String[] secondArray = new String[]{"краска", "корыто для воды", "шуруп 3х1.5", "гвоздь!!!"};

        Map<String, String> expect = new LinkedHashMap<>();
        expect.put("гвоздь", "гвоздь!!!");
        expect.put("шуруп,", "шуруп 3х1.5");
        expect.put("(краска) (синяя)", "краска");
        expect.put("ведро для, воды,", "корыто для воды");

        assertEquals(expect, SimilarStringsFinder.find(firstArray, secondArray));
    }

    @Test
    public void findTest2() {
        String[] firstArray = new String[]{"отвертка крестовая", "плитка", "раковина", "ключ гаечный", "паркет светлый"};
        String[] secondArray = new String[]{"отвертка", "кухонная раковина", "ключ", "светлый пол"};

        Map<String, String> expect = new LinkedHashMap<>();
        expect.put("отвертка крестовая", "отвертка");
        expect.put("плитка", "?");
        expect.put("раковина", "кухонная раковина");
        expect.put("ключ гаечный", "ключ");
        expect.put("паркет светлый", "светлый пол");

        assertEquals(expect, SimilarStringsFinder.find(firstArray, secondArray));
    }
}