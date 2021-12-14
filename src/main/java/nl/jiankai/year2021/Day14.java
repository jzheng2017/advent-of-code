package nl.jiankai.year2021;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day14 {
    static Map<String, String> table = new HashMap<>();

    public static void main(String[] args) {
        createTable();
//        part1();
        part2();
    }

    private static void createTable() {
        for (int i = 2; i < input.size(); i++) {
            String[] s = input.get(i).split(" -> ");
            table.put(s[0], s[1]);
        }
    }

    private static void part1() {
        String finalTemplate = performStep(input.get(0));
        Map<Character, Long> occurrences = countOccurrences(finalTemplate);

        long highest = Long.MIN_VALUE;
        long lowest = Long.MAX_VALUE;

        for (long count : occurrences.values()) {
            if (count > highest) {
                highest = count;
            }

            if (count < lowest) {
                lowest = count;
            }
        }

        System.out.println(highest - lowest);
    }

    static void part2() {
        Map<String, Long> pairOccurrences = new HashMap<>();
        String template = input.get(0);
        for (int i = 0; i < template.length() - 1; i++) {
            String key = Character.toString(template.charAt(i)) + template.charAt(i + 1);
            pairOccurrences.merge(key, 1L, Long::sum);
        }

        for (int i = 0; i < 40; i++) {
            Map<String, Long> tmpPairOccurrences = new HashMap<>();
            for (Map.Entry<String, Long> pairOccurrence : pairOccurrences.entrySet()) {
                String key = pairOccurrence.getKey();
                Long value = pairOccurrence.getValue();
                if (value == 0) continue;

                String betweenCharacter = table.get(key);
                if (betweenCharacter != null) {
                    tmpPairOccurrences.merge(key.charAt(0) + betweenCharacter, value, Long::sum);

                    tmpPairOccurrences.merge(betweenCharacter + key.charAt(1), value, Long::sum);
                }
                pairOccurrence.setValue(0L);
            }

            pairOccurrences.putAll(tmpPairOccurrences);
        }

        Map<Character, Long> charOccurrence = countCharacters(pairOccurrences);
        long highest = Long.MIN_VALUE;
        long lowest = Long.MAX_VALUE;
        for (Long value : charOccurrence.values()) {
            if (value == 0L) continue;

            if (value > highest) {
                highest = value;
            }
            if (value < lowest) {
                lowest = value;
            }
        }
        System.out.println(highest - lowest);
    }

    private static Map<Character, Long> countCharacters(Map<String, Long> polymerTemplate) {
        Map<Character, Long> characterCounts = new HashMap<>();

        for (Map.Entry<String, Long> pair : polymerTemplate.entrySet()) {
            char[] chars = pair.getKey().toCharArray();

            if (characterCounts.isEmpty()) {
                characterCounts.put(chars[0], polymerTemplate.get(pair.getKey()));
            }

            if (!characterCounts.containsKey(chars[1])) {
                characterCounts.put(chars[1], polymerTemplate.get(pair.getKey()));
            } else {
                characterCounts.merge(chars[1], polymerTemplate.get(pair.getKey()), Long::sum);
            }
        }

        return characterCounts;
    }

    private static Map<Character, Long> countOccurrences(String finalTemplate) {
        Map<Character, Long> occurrences = new HashMap<>();

        for (int i = 0; i < finalTemplate.length(); i++) {
            boolean contains = occurrences.containsKey(finalTemplate.charAt(i));

            if (contains) {
                long count = occurrences.get(finalTemplate.charAt(i));
                occurrences.put(finalTemplate.charAt(i), ++count);
            } else {
                occurrences.put(finalTemplate.charAt(i), 1L);
            }
        }
        return occurrences;
    }

    static String performStep(String template) {
        for (int step = 0; step < 10; step++) {
            StringBuilder newTemplate = new StringBuilder();
            for (int i = 0; i < template.length() - 1; i++) {
                String key = template.substring(i, i + 2);
                String betweenString = table.get(key);
                if (i == 0) {
                    newTemplate
                            .append(key.charAt(0))
                            .append(betweenString)
                            .append(key.charAt(1));
                } else {
                    newTemplate
                            .append(betweenString)
                            .append(key.charAt(1));
                }
            }
            template = newTemplate.toString();
        }

        return template;
    }

//

    static List<String> input = Arrays.asList(("PBVHVOCOCFFNBCNCCBHK\n" +
            "\n" +
            "FV -> C\n" +
            "SS -> B\n" +
            "SC -> B\n" +
            "BP -> K\n" +
            "VP -> S\n" +
            "HK -> K\n" +
            "FS -> F\n" +
            "CC -> V\n" +
            "VB -> P\n" +
            "OP -> B\n" +
            "FO -> N\n" +
            "FH -> O\n" +
            "VK -> N\n" +
            "PV -> S\n" +
            "HV -> O\n" +
            "PF -> F\n" +
            "HH -> F\n" +
            "NK -> S\n" +
            "NC -> S\n" +
            "FC -> H\n" +
            "FK -> K\n" +
            "OO -> N\n" +
            "HP -> C\n" +
            "NN -> H\n" +
            "BB -> H\n" +
            "CN -> P\n" +
            "PS -> N\n" +
            "VF -> S\n" +
            "CB -> B\n" +
            "OH -> S\n" +
            "CF -> C\n" +
            "OK -> P\n" +
            "CV -> V\n" +
            "CS -> H\n" +
            "KN -> B\n" +
            "OV -> S\n" +
            "HB -> C\n" +
            "OS -> V\n" +
            "PC -> B\n" +
            "CK -> S\n" +
            "PP -> K\n" +
            "SN -> O\n" +
            "VV -> C\n" +
            "NS -> F\n" +
            "PN -> K\n" +
            "HS -> P\n" +
            "VO -> B\n" +
            "VC -> B\n" +
            "NV -> P\n" +
            "VS -> N\n" +
            "FP -> F\n" +
            "HO -> S\n" +
            "KS -> O\n" +
            "BN -> F\n" +
            "VN -> P\n" +
            "OC -> K\n" +
            "SF -> P\n" +
            "PO -> P\n" +
            "SB -> O\n" +
            "FN -> F\n" +
            "OF -> F\n" +
            "CP -> C\n" +
            "HC -> O\n" +
            "PH -> O\n" +
            "BC -> O\n" +
            "NO -> C\n" +
            "BH -> C\n" +
            "VH -> S\n" +
            "KK -> O\n" +
            "SV -> K\n" +
            "KB -> K\n" +
            "BS -> S\n" +
            "HF -> B\n" +
            "NH -> S\n" +
            "PB -> N\n" +
            "HN -> K\n" +
            "SK -> B\n" +
            "FB -> F\n" +
            "KV -> S\n" +
            "BF -> S\n" +
            "ON -> S\n" +
            "BV -> P\n" +
            "KC -> S\n" +
            "NB -> S\n" +
            "NP -> B\n" +
            "BK -> K\n" +
            "NF -> C\n" +
            "BO -> K\n" +
            "KF -> B\n" +
            "KH -> N\n" +
            "SP -> O\n" +
            "CO -> S\n" +
            "KO -> V\n" +
            "SO -> B\n" +
            "CH -> C\n" +
            "KP -> C\n" +
            "FF -> K\n" +
            "PK -> F\n" +
            "OB -> H\n" +
            "SH -> C").split("\n"));
}
