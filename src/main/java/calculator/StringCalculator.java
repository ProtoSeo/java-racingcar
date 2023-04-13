package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static class SplitString {

        public static final String DELIMITER = ",|:";

        public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(?<delimiter>.)\n(?<values>.*)");

        public static String[] split(String text) {
            Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
            if (matcher.find()) {
                return matcher.group("values").split(matcher.group("delimiter"));
            }
            return text.split(DELIMITER);
        }

    }

    public static final int ZERO = 0;

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return ZERO;
        }

        return sum(toInts(SplitString.split(text)));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static int sum(List<Integer> numbers) {
        int sum = ZERO;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static List<Integer> toInts(String[] values) {
        List<Integer> numbers = new ArrayList<>();
        for (int i=0; i< values.length; i++) {
            int number = toInt(values[i]);
            numbers.add(number);
        }
        return numbers;
    }

    private static int toInt(String values) {
        int number = Integer.parseInt(values);
        if (number < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return number;
    }

}
