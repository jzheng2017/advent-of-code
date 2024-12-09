package nl.jiankai.year2024;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        part2();
    }

    private static void part1() {
        List<String> convert = new ArrayList<>();
        int id = 0;
        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0) {
                String c = String.valueOf(input.charAt(i));
                int val = Integer.parseInt(c);
                for (int j = 0; j < val; j++) {
                    convert.add(String.valueOf(id));
                }
            } else {
                int val = Character.getNumericValue(input.charAt(i));
                IntStream.range(0, val).forEach(v -> convert.add("."));

                id++;
            }
        }

        int l = 0;
        int r = convert.size() - 1;
        while (l != r) {
            if (!convert.get(l).equals(".")) {
                l++;
                continue;
            }

            String val = convert.get(r);
            try {
                if (Integer.parseInt(val) != id) {
                    id--;
                    continue;
                }
                convert.set(l, val);
                l++;
                convert.set(r, ".");
                r--;
            } catch (NumberFormatException e) {
                r--;
            }

        }

        BigInteger ans = BigInteger.ZERO;
        for (int i = 0; i < convert.size(); i++) {
            if (!convert.get(i).equals(".")) {
                ans = ans.add(BigInteger.valueOf(Integer.parseInt(convert.get(i))).multiply(BigInteger.valueOf(i)));
            } else {
                break;
            }
        }
        System.out.println(ans);
    }

    private static void part2() {
        List<String> convert = new ArrayList<>();
        int id = 0;
        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0) {
                String c = String.valueOf(input.charAt(i));
                int val = Integer.parseInt(c);
                for (int j = 0; j < val; j++) {
                    convert.add(String.valueOf(id));
                }
            } else {
                int val = Character.getNumericValue(input.charAt(i));
                IntStream.range(0, val).forEach(v -> convert.add("."));

                id++;
            }
        }

        int l = 0;
        int r = convert.size() - 1;
        while (l != r) {

            if (l == -1) {
                break;
            }
            r = skipFreeSpace(convert, r);
            int blockSize = blockSize(convert, r, String.valueOf(id));
            int ll = getNextFreeSpace(convert, l, blockSize);
            if (ll == -1) {
                id--;
                continue;
            }
            l = ll;
            for (int i = 0; i < blockSize; i++) {
                convert.set(l + i, convert.get(r));
            }

            for (int i = 0; i < blockSize; i++) {
                convert.set(r - i, ".");
            }
            l += blockSize;
            id--;
            r -= blockSize;
        }

        BigInteger ans = BigInteger.ZERO;
        for (int i = 0; i < convert.size(); i++) {
            if (!convert.get(i).equals(".")) {
                ans = ans.add(BigInteger.valueOf(Integer.parseInt(convert.get(i))).multiply(BigInteger.valueOf(i)));
            } else {
                break;
            }
        }
        System.out.println(ans);
    }

    private static int getNextFreeSpace(List<String> convert, int l, int blockSize) {
        while (freeSpace(convert, l) < blockSize) {
            l += blockSize;
        }

        if (l >= convert.size()) {
            return -1;
        }

        return l;
    }

    private static int skipFreeSpace(List<String> convert, int r) {
        while (convert.get(r).equals(".")) {
            r--;
        }

        return r;
    }

    private static int freeSpace(List<String> convert, int start) {
        int size = 0;
        for (int i = start; i < convert.size(); i++) {
            if (convert.get(i).equals(".")) {
                size++;
            } else if (size > 0) {
                return size;
            }
        }

        return size;
    }

    private static int blockSize(List<String> convert, int start, String id) {
        int size = 0;
        for (int i = start; i >= 0; i--) {
            if (convert.get(i).equals(id)) {
                size++;
            } else {
                return size;
            }
        }

        return size;
    }

    private static String input = "2333133121414131402";

}
