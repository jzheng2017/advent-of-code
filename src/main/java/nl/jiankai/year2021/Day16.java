package nl.jiankai.year2021;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Day16 {
    static List<Integer> version = new ArrayList<>();
    static int cursor = 0;

    public static void main(String[] args) {
//        part1();
        part2();
    }

    static void part1() {
        String binary = hexadecimalToBinary("E20D79005573F71DA0054E48527EF97D3004653BB1FC006867A8B1371AC49C801039171941340066E6B99A6A58B8110088BA008CE6F7893D4E6F7893DCDCFDB9D6CBC4026FE8026200DC7D84B1C00010A89507E3CCEE37B592014D3C01491B6697A83CB4F59E5E7FFA5CC66D4BC6F05D3004E6BB742B004E7E6B3375A46CF91D8C027911797589E17920F4009BE72DA8D2E4523DCEE86A8018C4AD3C7F2D2D02C5B9FF53366E3004658DB0012A963891D168801D08480485B005C0010A883116308002171AA24C679E0394EB898023331E60AB401294D98CA6CD8C01D9B349E0A99363003E655D40289CBDBB2F55D25E53ECAF14D9ABBB4CC726F038C011B0044401987D0BE0C00021B04E2546499DE824C015B004A7755B570013F2DD8627C65C02186F2996E9CCD04E5718C5CBCC016B004A4F61B27B0D9B8633F9344D57B0C1D3805537ADFA21F231C6EC9F3D3089FF7CD25E5941200C96801F191C77091238EE13A704A7CCC802B3B00567F192296259ABD9C400282915B9F6E98879823046C0010C626C966A19351EE27DE86C8E6968F2BE3D2008EE540FC01196989CD9410055725480D60025737BA1547D700727B9A89B444971830070401F8D70BA3B8803F16A3FC2D00043621C3B8A733C8BD880212BCDEE9D34929164D5CB08032594E5E1D25C0055E5B771E966783240220CD19E802E200F4588450BC401A8FB14E0A1805B36F3243B2833247536B70BDC00A60348880C7730039400B402A91009F650028C00E2020918077610021C00C1002D80512601188803B4000C148025010036727EE5AD6B445CC011E00B825E14F4BBF5F97853D2EFD6256F8FFE9F3B001420C01A88915E259002191EE2F4392004323E44A8B4C0069CEF34D304C001AB94379D149BD904507004A6D466B618402477802E200D47383719C0010F8A507A294CC9C90024A967C9995EE2933BA840");


        parse(binary);

        System.out.println(version.stream().mapToInt(v -> v).sum());
    }

    static void part2() {
        String binary = hexadecimalToBinary("E20D79005573F71DA0054E48527EF97D3004653BB1FC006867A8B1371AC49C801039171941340066E6B99A6A58B8110088BA008CE6F7893D4E6F7893DCDCFDB9D6CBC4026FE8026200DC7D84B1C00010A89507E3CCEE37B592014D3C01491B6697A83CB4F59E5E7FFA5CC66D4BC6F05D3004E6BB742B004E7E6B3375A46CF91D8C027911797589E17920F4009BE72DA8D2E4523DCEE86A8018C4AD3C7F2D2D02C5B9FF53366E3004658DB0012A963891D168801D08480485B005C0010A883116308002171AA24C679E0394EB898023331E60AB401294D98CA6CD8C01D9B349E0A99363003E655D40289CBDBB2F55D25E53ECAF14D9ABBB4CC726F038C011B0044401987D0BE0C00021B04E2546499DE824C015B004A7755B570013F2DD8627C65C02186F2996E9CCD04E5718C5CBCC016B004A4F61B27B0D9B8633F9344D57B0C1D3805537ADFA21F231C6EC9F3D3089FF7CD25E5941200C96801F191C77091238EE13A704A7CCC802B3B00567F192296259ABD9C400282915B9F6E98879823046C0010C626C966A19351EE27DE86C8E6968F2BE3D2008EE540FC01196989CD9410055725480D60025737BA1547D700727B9A89B444971830070401F8D70BA3B8803F16A3FC2D00043621C3B8A733C8BD880212BCDEE9D34929164D5CB08032594E5E1D25C0055E5B771E966783240220CD19E802E200F4588450BC401A8FB14E0A1805B36F3243B2833247536B70BDC00A60348880C7730039400B402A91009F650028C00E2020918077610021C00C1002D80512601188803B4000C148025010036727EE5AD6B445CC011E00B825E14F4BBF5F97853D2EFD6256F8FFE9F3B001420C01A88915E259002191EE2F4392004323E44A8B4C0069CEF34D304C001AB94379D149BD904507004A6D466B618402477802E200D47383719C0010F8A507A294CC9C90024A967C9995EE2933BA840");

        System.out.println(parse(binary));
    }

    static long parse(String binary) {
        if (cursor >= binary.length() || getBinaryToNumber(binary.substring(cursor)).equals(BigInteger.ZERO)) {
            return 0;
        }

        int packetVersion = getBinaryToNumber(binary.substring(cursor, cursor + 3)).intValue();
        int packetTypeId = getBinaryToNumber(binary.substring(cursor + 3, cursor + 6)).intValue();
        cursor += 6;
        version.add(packetVersion);

        return switch (packetTypeId) {
            case 0 -> parseSumOperator(binary);
            case 1 -> parseProductOperator(binary);
            case 2 -> parseMinimumOperator(binary);
            case 3 -> parseMaximumOperator(binary);
            case 4 -> parseLiteral(binary);
            case 5 -> parseGreaterThanOperator(binary);
            case 6 -> parseLessThanOperator(binary);
            case 7 -> parseEqualOperator(binary);
            default -> throw new IllegalStateException();
        };
    }

    private static long parseEqualOperator(String binary) {
        List<Long> packets = parseOperator(binary);

        return Objects.equals(packets.get(0), packets.get(1)) ? 1 : 0;
    }

    private static long parseGreaterThanOperator(String binary) {
        List<Long> packets = parseOperator(binary);

        return packets.get(0) > packets.get(1) ? 1 : 0;
    }

    private static long parseLessThanOperator(String binary) {
        List<Long> packets = parseOperator(binary);

        return packets.get(0) < packets.get(1) ? 1 : 0;
    }

    private static long parseMaximumOperator(String binary) {
        long max = Long.MIN_VALUE;

        for (long num : parseOperator(binary)) {
            max = Math.max(num, max);
        }

        return max;
    }

    private static long parseMinimumOperator(String binary) {
        long min = Long.MAX_VALUE;

        for (long num : parseOperator(binary)) {
            min = Math.min(num, min);
        }

        return min;
    }

    private static long parseProductOperator(String binary) {
        long product = 1;

        for (long num : parseOperator(binary)) {
            product *= num;
        }

        return product;
    }

    private static long parseSumOperator(String binary) {
        long sum = 0;

        for (long num : parseOperator(binary)) {
            sum += num;
        }

        return sum;
    }

    private static List<Long> parseOperator(String binary) {
        List<Long> numbers = new ArrayList<>();
        if (binary.charAt(cursor) == '0') {
            cursor++;
            int totalLengthOfBits = getBinaryToNumber(binary.substring(cursor, cursor + 15)).intValue();
            cursor += 15;
            final int originalCursor = cursor;

            while (cursor < originalCursor + totalLengthOfBits) {
                numbers.add(parse(binary));
            }
        } else if (binary.charAt(cursor) == '1') {
            cursor++;
            int numberOfSubPackets = getBinaryToNumber(binary.substring(cursor, cursor + 11)).intValue();
            cursor += 11;
            for (int i = 0; i < numberOfSubPackets; i++) {
                numbers.add(parse(binary));
            }
        }

        return numbers;
    }


    static long parseLiteral(String binary) {
        StringBuilder core = new StringBuilder();

        for (int i = cursor; i < binary.length(); i += 5) {
            if (cursor + 5 <= binary.length()) {
                String fiveBits = binary.substring(cursor, cursor + 5);
                core.append(fiveBits.substring(1));
                cursor += 5;
                if (fiveBits.startsWith("0")) {
                    break;
                }
            }
        }

        return getBinaryToNumber(core.toString()).longValue();
    }

    static String hexadecimalToBinary(String s) {
        StringBuilder binary = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            binary.append(hexaCharToBinary(s.charAt(i)));
        }
        return binary.toString();
    }

    static String hexaCharToBinary(char c) {
        return switch (c) {
            case '0' -> "0000";
            case '1' -> "0001";
            case '2' -> "0010";
            case '3' -> "0011";
            case '4' -> "0100";
            case '5' -> "0101";
            case '6' -> "0110";
            case '7' -> "0111";
            case '8' -> "1000";
            case '9' -> "1001";
            case 'A' -> "1010";
            case 'B' -> "1011";
            case 'C' -> "1100";
            case 'D' -> "1101";
            case 'E' -> "1110";
            case 'F' -> "1111";
            default -> throw new IllegalStateException();
        };
    }

    static BigInteger getBinaryToNumber(String binary) {
        return new BigInteger(binary, 2);
    }
}
