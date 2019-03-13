package games;

import java.util.stream.IntStream;

public class StringInverter {
    public static void main(String[] args) {
        String str = "rower";
        System.out.println(stringInverter(str));
    }

    private static String stringInverter(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, str.length())
                .forEach(value -> stringBuilder.append(str.charAt(str.length() - 1 - value)));
        return stringBuilder.toString();

    }
}
