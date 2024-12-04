package nl.jiankai.year2024;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {

    public static void main(String[] args) {
        part1();
        part2();
    }

    private static void part1() {
        String regex = "mul\\((\\d+),(\\d+)\\)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> matches = new ArrayList<>();

        while (matcher.find()) {
            matches.add(matcher.group()); // Add the full match to the list
        }
        int ans = 0;
        for (String match : matches) {
            String mulRegex = "mul\\((\\d+),(\\d+)\\)";
            Pattern mulPattern = Pattern.compile(mulRegex);
            Matcher mulMatcher = mulPattern.matcher(match);
            mulMatcher.find();
            ans += Integer.parseInt(mulMatcher.group(1)) * Integer.parseInt(mulMatcher.group(2));
        }
        System.out.println(ans);
    }

    private static void part2() {
        String regex = "mul\\((\\d+),(\\d+)\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> matches = new ArrayList<>();
        List<Integer> indices = new ArrayList<>();

        while (matcher.find()) {
            indices.add(matcher.start());
            matches.add(matcher.group());
        }

        String doDontRegex = "(?:don't\\(\\)|do\\(\\))";
        List<String> doDonts = new ArrayList<>();
        List<Integer> doDontsIndices = new ArrayList<>();

        Pattern doDontPattern = Pattern.compile(doDontRegex);
        Matcher doDontMatcher = doDontPattern.matcher(input);

        while (doDontMatcher.find()) {
            doDonts.add(doDontMatcher.group());
            doDontsIndices.add(doDontMatcher.start());
        }

        int currentConditionalIndex = 0;
        String currentConditional = "";
        int ans = 0;

        for (int i = 0; i < matches.size(); i++) {
            String match = matches.get(i);
            if (!doDonts.isEmpty()) {
                int matchIndex = indices.get(i);
                int conditionalIndex = doDontsIndices.get(currentConditionalIndex);
                if (conditionalIndex < matchIndex) {
                    currentConditional = doDonts.get(currentConditionalIndex);
                    currentConditionalIndex++;
                }
                if (currentConditional.equals("don't()")) {
                    continue;
                }
            }
            String mulRegex = "mul\\((\\d+),(\\d+)\\)";
            Pattern mulPattern = Pattern.compile(mulRegex);
            Matcher mulMatcher = mulPattern.matcher(match);
            mulMatcher.find();
            ans += Integer.parseInt(mulMatcher.group(1)) * Integer.parseInt(mulMatcher.group(2));
        }
        System.out.println(ans);
    }
    private static String input="xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))";
}
