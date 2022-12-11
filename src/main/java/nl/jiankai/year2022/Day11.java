package nl.jiankai.year2022;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Day11 {
    public static void main(String[] args) {
        part1();
    }

    private static void part1() {
        Map<Integer, Monkey> monkeys = parseMonkeys();
        long totalStartTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            long localStartTime = System.currentTimeMillis();
            for (Monkey monkey : monkeys.values()) {
                monkey.executeRound();
            }
            long localEndTime = System.currentTimeMillis();
            long totalEndTime = System.currentTimeMillis();
            System.out.println("Round: %s. Round time: %s ms %s s. Total time: %s minutes".formatted((i + 1), (localEndTime - localStartTime), (localEndTime - localStartTime) / 1000, TimeUnit.MILLISECONDS.toMinutes(totalEndTime - totalStartTime)));
        }
        System.out.println(monkeys.values().stream().mapToLong(m -> m.inspectionCount).boxed().sorted(Comparator.reverseOrder()).limit(2).reduce((a, b) -> a * b).get());
    }

    private static Map<Integer, Monkey> parseMonkeys() {
        Map<Integer, Monkey> monkeys = new HashMap<>();
        for (String monkeyString : input) {
            String[] monkeySplit = monkeyString.split("\n");
            String[] monkeyIdLine = monkeySplit[0].split(" ");
            Integer monkeyId = Character.getNumericValue(monkeyIdLine[1].charAt(0));
            List<Long> startingItems = new ArrayList<>(Arrays.stream(monkeySplit[1].split(":")[1].split(",")).map(n -> Long.parseLong(n.trim())).toList());
            String[] operationLine = monkeySplit[2].split(" ");
            String[] divisionValue = monkeySplit[3].split(" ");
            String[] trueLine = monkeySplit[4].split(" ");
            String[] falseLine = monkeySplit[5].split(" ");

            monkeys.put(monkeyId, new Monkey(startingItems, monkeys) {
                @Override
                public long performOperation(long worryLevel) {
                    String operation = operationLine[operationLine.length - 2];

                    long val;
                    try {
                        val = Long.parseLong(operationLine[operationLine.length - 1]);
                    } catch (Exception ex) {
                        val = worryLevel;
                    }
                    return switch (operation) {
                        case "*" -> worryLevel * val;
                        case "+" -> worryLevel + val;
                        default -> throw new UnsupportedOperationException();
                    };
                }

                @Override
                public int throwToMonkey(int index, List<Long> items, long worryLevel) {

                    int modVal = Integer.parseInt(divisionValue[divisionValue.length - 1]);
                    int trueMonkey = Integer.parseInt(trueLine[trueLine.length - 1]);
                    int falseMonkey = Integer.parseInt(falseLine[falseLine.length - 1]);

                    long newWorryLevel = worryLevel;
                    for (long div = worryLevel; div >= 2; div--) {
                        if (((worryLevel / div) % modVal) == (worryLevel % modVal)) {
                            newWorryLevel = worryLevel / gcdByEuclidsAlgorithm(wo);
                            items.set(index, newWorryLevel);
                            break;
                        }
                    }
                    if (newWorryLevel % modVal == 0) {
                        return trueMonkey;
                    } else {
                        return falseMonkey;
                    }
                }
                private int gcdByEuclidsAlgorithm(int n1, int n2) {
                    if (n2 == 0) {
                        return n1;
                    }
                    return gcdByEuclidsAlgorithm(n2, n1 % n2);
                }
            });
        }
        return monkeys;
    }

    private static List<String> input = Arrays.asList(("Monkey 0:\n" +
            "  Starting items: 79, 98\n" +
            "  Operation: new = old * 19\n" +
            "  Test: divisible by 23\n" +
            "    If true: throw to monkey 2\n" +
            "    If false: throw to monkey 3\n" +
            "\n" +
            "Monkey 1:\n" +
            "  Starting items: 54, 65, 75, 74\n" +
            "  Operation: new = old + 6\n" +
            "  Test: divisible by 19\n" +
            "    If true: throw to monkey 2\n" +
            "    If false: throw to monkey 0\n" +
            "\n" +
            "Monkey 2:\n" +
            "  Starting items: 79, 60, 97\n" +
            "  Operation: new = old * old\n" +
            "  Test: divisible by 13\n" +
            "    If true: throw to monkey 1\n" +
            "    If false: throw to monkey 3\n" +
            "\n" +
            "Monkey 3:\n" +
            "  Starting items: 74\n" +
            "  Operation: new = old + 3\n" +
            "  Test: divisible by 17\n" +
            "    If true: throw to monkey 0\n" +
            "    If false: throw to monkey 1").split("\n\n"));

    private static abstract class Monkey {
        private List<Long> items;
        private Map<Integer, Monkey> monkeys;
        private long inspectionCount = 0;

        private Monkey(List<Long> items, Map<Integer, Monkey> monkeys) {
            this.items = items;
            this.monkeys = monkeys;
        }

        public void addToItems(Long item) {
            items.add(item);
        }

        public abstract long performOperation(long worryLevel);

        public abstract int throwToMonkey(int index, List<Long> items, long worryLevel);

        public void executeRound() {
            for (int i = 0; i < items.size(); i++) {
                inspectionCount++;
//                long newWorryLevel = performOperation(items.get(i)) / 3; //part 1
                Long newWorryLevel = performOperation(items.get(i));
                monkeys.get(throwToMonkey(i, items, newWorryLevel)).addToItems(items.get(i));
            }
            items = new ArrayList<>();
        }
    }
}
