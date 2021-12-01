package nl.jiankai.year2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.abs;

public class Day8 {
    private static List<String> instructions = Arrays.asList(("nop +346\n" +
            "acc +44\n" +
            "acc +15\n" +
            "jmp +473\n" +
            "acc +29\n" +
            "acc -13\n" +
            "jmp +525\n" +
            "acc +22\n" +
            "acc +13\n" +
            "nop +265\n" +
            "jmp +397\n" +
            "jmp +39\n" +
            "acc +39\n" +
            "nop -1\n" +
            "acc +36\n" +
            "acc +25\n" +
            "jmp +153\n" +
            "nop +374\n" +
            "jmp +27\n" +
            "jmp +282\n" +
            "jmp +1\n" +
            "jmp +1\n" +
            "jmp +15\n" +
            "acc +33\n" +
            "acc -3\n" +
            "jmp +533\n" +
            "acc +25\n" +
            "acc -14\n" +
            "acc -16\n" +
            "jmp +245\n" +
            "nop +567\n" +
            "acc +7\n" +
            "jmp +147\n" +
            "acc +26\n" +
            "acc +40\n" +
            "acc -9\n" +
            "jmp +295\n" +
            "acc +14\n" +
            "nop +388\n" +
            "acc -1\n" +
            "jmp -21\n" +
            "nop +524\n" +
            "nop +166\n" +
            "nop +515\n" +
            "jmp +18\n" +
            "jmp +214\n" +
            "acc +42\n" +
            "nop -35\n" +
            "acc +7\n" +
            "jmp +492\n" +
            "acc +14\n" +
            "acc +48\n" +
            "jmp +326\n" +
            "acc +48\n" +
            "acc -18\n" +
            "acc -5\n" +
            "jmp +343\n" +
            "jmp +81\n" +
            "acc +18\n" +
            "acc +16\n" +
            "acc +21\n" +
            "jmp +355\n" +
            "acc +48\n" +
            "nop +358\n" +
            "acc +49\n" +
            "acc -2\n" +
            "jmp +89\n" +
            "acc +4\n" +
            "jmp +171\n" +
            "acc +6\n" +
            "jmp +299\n" +
            "acc -8\n" +
            "jmp +150\n" +
            "acc +41\n" +
            "acc -9\n" +
            "acc +48\n" +
            "jmp +73\n" +
            "jmp +523\n" +
            "nop +471\n" +
            "jmp +493\n" +
            "acc -16\n" +
            "nop +440\n" +
            "acc +2\n" +
            "acc +33\n" +
            "jmp +117\n" +
            "acc +3\n" +
            "acc +34\n" +
            "jmp +310\n" +
            "acc +8\n" +
            "jmp +197\n" +
            "acc +26\n" +
            "acc +47\n" +
            "jmp +194\n" +
            "nop +115\n" +
            "jmp +259\n" +
            "nop +456\n" +
            "jmp +420\n" +
            "nop +398\n" +
            "jmp +235\n" +
            "acc +44\n" +
            "acc +47\n" +
            "jmp +218\n" +
            "jmp +1\n" +
            "jmp +275\n" +
            "acc +12\n" +
            "jmp +434\n" +
            "acc +50\n" +
            "acc +10\n" +
            "nop +361\n" +
            "jmp +367\n" +
            "acc -16\n" +
            "acc +44\n" +
            "jmp +96\n" +
            "acc +9\n" +
            "acc +38\n" +
            "acc -15\n" +
            "nop -31\n" +
            "jmp -55\n" +
            "nop +421\n" +
            "acc +50\n" +
            "acc +12\n" +
            "jmp -64\n" +
            "acc +33\n" +
            "acc +25\n" +
            "jmp +382\n" +
            "acc +7\n" +
            "jmp -22\n" +
            "jmp +95\n" +
            "acc +44\n" +
            "acc +32\n" +
            "acc +23\n" +
            "jmp +1\n" +
            "jmp +456\n" +
            "acc +49\n" +
            "jmp +15\n" +
            "jmp +312\n" +
            "acc +6\n" +
            "jmp +216\n" +
            "acc +7\n" +
            "jmp +458\n" +
            "jmp +465\n" +
            "nop +372\n" +
            "acc +35\n" +
            "acc +32\n" +
            "acc +13\n" +
            "jmp -35\n" +
            "acc +50\n" +
            "nop +32\n" +
            "jmp +143\n" +
            "jmp +327\n" +
            "acc +0\n" +
            "nop -82\n" +
            "nop -62\n" +
            "acc +41\n" +
            "jmp -81\n" +
            "acc -10\n" +
            "nop -106\n" +
            "jmp +82\n" +
            "acc +1\n" +
            "acc +11\n" +
            "jmp +124\n" +
            "acc +25\n" +
            "acc +17\n" +
            "jmp -73\n" +
            "nop +8\n" +
            "acc +29\n" +
            "acc +33\n" +
            "acc +10\n" +
            "jmp +123\n" +
            "jmp +236\n" +
            "acc +41\n" +
            "jmp +370\n" +
            "acc +17\n" +
            "acc -13\n" +
            "acc +35\n" +
            "jmp -47\n" +
            "nop +287\n" +
            "acc +22\n" +
            "jmp +38\n" +
            "jmp +1\n" +
            "nop -52\n" +
            "nop -9\n" +
            "acc +22\n" +
            "jmp +253\n" +
            "acc +12\n" +
            "acc -18\n" +
            "acc +21\n" +
            "nop -69\n" +
            "jmp +28\n" +
            "acc +16\n" +
            "jmp +392\n" +
            "jmp +325\n" +
            "jmp -74\n" +
            "acc +34\n" +
            "acc +47\n" +
            "acc +41\n" +
            "jmp +201\n" +
            "nop +361\n" +
            "acc +50\n" +
            "jmp +30\n" +
            "jmp -127\n" +
            "nop -171\n" +
            "jmp +349\n" +
            "acc +11\n" +
            "nop +156\n" +
            "acc +1\n" +
            "acc -18\n" +
            "jmp +393\n" +
            "acc -8\n" +
            "jmp +1\n" +
            "acc -17\n" +
            "nop +188\n" +
            "jmp +134\n" +
            "acc -9\n" +
            "acc -14\n" +
            "jmp +206\n" +
            "jmp -209\n" +
            "jmp +1\n" +
            "acc +49\n" +
            "nop +112\n" +
            "acc -4\n" +
            "jmp -20\n" +
            "acc +41\n" +
            "jmp -145\n" +
            "acc +8\n" +
            "jmp +276\n" +
            "acc +48\n" +
            "jmp -5\n" +
            "jmp -143\n" +
            "acc +0\n" +
            "jmp -161\n" +
            "jmp +238\n" +
            "acc +8\n" +
            "jmp -134\n" +
            "acc +34\n" +
            "acc +10\n" +
            "jmp +1\n" +
            "nop +109\n" +
            "jmp -100\n" +
            "acc +41\n" +
            "acc -4\n" +
            "jmp -12\n" +
            "acc +42\n" +
            "acc +46\n" +
            "acc -7\n" +
            "acc +28\n" +
            "jmp +85\n" +
            "jmp +216\n" +
            "jmp +364\n" +
            "acc +0\n" +
            "acc -6\n" +
            "nop +331\n" +
            "acc +33\n" +
            "jmp +163\n" +
            "acc +37\n" +
            "acc +20\n" +
            "acc +33\n" +
            "acc +45\n" +
            "jmp -159\n" +
            "acc +34\n" +
            "acc +10\n" +
            "acc +48\n" +
            "acc +10\n" +
            "jmp +358\n" +
            "acc -9\n" +
            "jmp +276\n" +
            "acc +27\n" +
            "acc +45\n" +
            "nop +129\n" +
            "acc +32\n" +
            "jmp +243\n" +
            "acc +0\n" +
            "acc -5\n" +
            "jmp -24\n" +
            "acc +44\n" +
            "nop +307\n" +
            "acc -18\n" +
            "acc +13\n" +
            "jmp +37\n" +
            "acc +5\n" +
            "nop -125\n" +
            "nop -126\n" +
            "acc -18\n" +
            "jmp +186\n" +
            "jmp -87\n" +
            "jmp -262\n" +
            "nop -20\n" +
            "jmp -108\n" +
            "acc +26\n" +
            "acc +20\n" +
            "jmp +193\n" +
            "nop +185\n" +
            "jmp +129\n" +
            "acc +26\n" +
            "jmp +122\n" +
            "acc -8\n" +
            "nop +143\n" +
            "nop +166\n" +
            "jmp -236\n" +
            "acc +33\n" +
            "jmp -139\n" +
            "acc +38\n" +
            "jmp +1\n" +
            "acc +21\n" +
            "acc +31\n" +
            "jmp -79\n" +
            "acc -13\n" +
            "jmp -78\n" +
            "acc +29\n" +
            "jmp +160\n" +
            "acc +48\n" +
            "acc -8\n" +
            "acc +28\n" +
            "acc +15\n" +
            "jmp -284\n" +
            "jmp +25\n" +
            "acc +24\n" +
            "jmp +1\n" +
            "jmp -92\n" +
            "acc +22\n" +
            "jmp +169\n" +
            "acc -15\n" +
            "acc +16\n" +
            "acc +4\n" +
            "jmp -85\n" +
            "acc -18\n" +
            "acc -19\n" +
            "acc -2\n" +
            "jmp -278\n" +
            "acc +48\n" +
            "jmp -195\n" +
            "jmp -40\n" +
            "jmp -110\n" +
            "acc +47\n" +
            "jmp -26\n" +
            "acc +26\n" +
            "nop -187\n" +
            "acc +40\n" +
            "acc +42\n" +
            "jmp +167\n" +
            "acc +50\n" +
            "acc +36\n" +
            "acc -14\n" +
            "jmp -313\n" +
            "nop -203\n" +
            "jmp +227\n" +
            "acc -15\n" +
            "acc +22\n" +
            "jmp -23\n" +
            "acc +6\n" +
            "acc +30\n" +
            "acc +12\n" +
            "jmp +69\n" +
            "nop -212\n" +
            "nop -105\n" +
            "acc +12\n" +
            "jmp -155\n" +
            "nop +69\n" +
            "acc -16\n" +
            "jmp -68\n" +
            "acc -18\n" +
            "acc +35\n" +
            "acc +34\n" +
            "acc +6\n" +
            "jmp -80\n" +
            "acc +7\n" +
            "acc +19\n" +
            "acc -8\n" +
            "jmp -94\n" +
            "acc +12\n" +
            "nop -148\n" +
            "acc +33\n" +
            "nop -41\n" +
            "jmp -107\n" +
            "acc +25\n" +
            "acc +9\n" +
            "nop +107\n" +
            "jmp -44\n" +
            "jmp +1\n" +
            "jmp -254\n" +
            "acc +10\n" +
            "acc +0\n" +
            "acc +37\n" +
            "acc +33\n" +
            "jmp +137\n" +
            "nop +136\n" +
            "jmp -225\n" +
            "acc -4\n" +
            "acc -17\n" +
            "acc +39\n" +
            "jmp -286\n" +
            "jmp +150\n" +
            "nop -380\n" +
            "acc +34\n" +
            "acc +16\n" +
            "nop +146\n" +
            "jmp +105\n" +
            "jmp +119\n" +
            "jmp -190\n" +
            "acc +0\n" +
            "nop +205\n" +
            "nop -302\n" +
            "jmp -17\n" +
            "acc -4\n" +
            "jmp -7\n" +
            "jmp -14\n" +
            "jmp -394\n" +
            "acc +34\n" +
            "acc -1\n" +
            "acc +37\n" +
            "acc -17\n" +
            "jmp -312\n" +
            "nop -180\n" +
            "nop -139\n" +
            "acc +21\n" +
            "jmp -378\n" +
            "acc +24\n" +
            "acc +38\n" +
            "jmp +129\n" +
            "acc +26\n" +
            "jmp +19\n" +
            "acc +31\n" +
            "jmp -190\n" +
            "acc +29\n" +
            "acc -5\n" +
            "jmp +14\n" +
            "nop +186\n" +
            "acc +12\n" +
            "acc +9\n" +
            "acc -16\n" +
            "jmp +9\n" +
            "acc +2\n" +
            "nop -382\n" +
            "nop -284\n" +
            "nop -377\n" +
            "jmp -169\n" +
            "jmp +129\n" +
            "acc +49\n" +
            "jmp -297\n" +
            "acc +48\n" +
            "acc +18\n" +
            "acc +8\n" +
            "jmp +170\n" +
            "acc +12\n" +
            "acc -4\n" +
            "acc +28\n" +
            "jmp -20\n" +
            "acc -11\n" +
            "jmp -363\n" +
            "jmp +1\n" +
            "acc +9\n" +
            "acc +31\n" +
            "jmp +31\n" +
            "acc +36\n" +
            "acc +42\n" +
            "acc +2\n" +
            "nop -131\n" +
            "jmp -322\n" +
            "acc +35\n" +
            "acc +44\n" +
            "acc +11\n" +
            "acc +14\n" +
            "jmp -213\n" +
            "acc -16\n" +
            "acc -15\n" +
            "acc -5\n" +
            "jmp -277\n" +
            "acc -17\n" +
            "jmp -252\n" +
            "acc -19\n" +
            "acc +31\n" +
            "acc -16\n" +
            "acc -5\n" +
            "jmp +48\n" +
            "jmp +1\n" +
            "jmp -97\n" +
            "acc +5\n" +
            "jmp -382\n" +
            "acc +26\n" +
            "acc +41\n" +
            "acc +31\n" +
            "acc -2\n" +
            "jmp -392\n" +
            "acc +41\n" +
            "jmp -124\n" +
            "acc +45\n" +
            "acc +24\n" +
            "acc +10\n" +
            "jmp -339\n" +
            "acc +29\n" +
            "acc -10\n" +
            "acc -10\n" +
            "acc +3\n" +
            "jmp -456\n" +
            "jmp -25\n" +
            "acc +37\n" +
            "acc +39\n" +
            "acc -11\n" +
            "acc -1\n" +
            "jmp +106\n" +
            "jmp -328\n" +
            "jmp -489\n" +
            "nop -111\n" +
            "nop -458\n" +
            "acc +31\n" +
            "jmp -100\n" +
            "acc -18\n" +
            "jmp -258\n" +
            "acc -17\n" +
            "nop -46\n" +
            "acc +43\n" +
            "acc +45\n" +
            "jmp -127\n" +
            "jmp +34\n" +
            "acc +33\n" +
            "jmp -200\n" +
            "nop -90\n" +
            "acc +20\n" +
            "jmp -271\n" +
            "acc +41\n" +
            "jmp -189\n" +
            "acc -16\n" +
            "nop -321\n" +
            "acc +25\n" +
            "acc -12\n" +
            "jmp -62\n" +
            "acc -1\n" +
            "jmp +1\n" +
            "acc +35\n" +
            "acc +39\n" +
            "jmp -184\n" +
            "jmp -236\n" +
            "nop -331\n" +
            "acc +12\n" +
            "jmp +78\n" +
            "acc +15\n" +
            "jmp -30\n" +
            "acc -11\n" +
            "jmp -117\n" +
            "jmp -8\n" +
            "jmp +9\n" +
            "acc +2\n" +
            "jmp -497\n" +
            "acc +10\n" +
            "acc +0\n" +
            "acc -6\n" +
            "jmp -155\n" +
            "jmp -148\n" +
            "jmp -95\n" +
            "jmp -96\n" +
            "jmp -249\n" +
            "nop -277\n" +
            "nop -411\n" +
            "acc -13\n" +
            "acc -2\n" +
            "jmp -383\n" +
            "acc -13\n" +
            "jmp -110\n" +
            "acc +13\n" +
            "acc +16\n" +
            "acc +5\n" +
            "acc -2\n" +
            "jmp -67\n" +
            "acc +37\n" +
            "jmp -491\n" +
            "acc +35\n" +
            "acc +34\n" +
            "acc +32\n" +
            "acc -2\n" +
            "jmp -546\n" +
            "acc -19\n" +
            "jmp -322\n" +
            "acc +48\n" +
            "acc +18\n" +
            "acc +35\n" +
            "acc +8\n" +
            "jmp -448\n" +
            "acc +41\n" +
            "acc -15\n" +
            "acc +34\n" +
            "acc +46\n" +
            "jmp -50\n" +
            "acc +12\n" +
            "nop -184\n" +
            "acc +14\n" +
            "acc +38\n" +
            "jmp -370\n" +
            "jmp +10\n" +
            "acc -14\n" +
            "acc -16\n" +
            "nop -259\n" +
            "nop -300\n" +
            "jmp -400\n" +
            "acc +38\n" +
            "acc +29\n" +
            "acc +27\n" +
            "jmp -175\n" +
            "jmp -456\n" +
            "acc +30\n" +
            "jmp -308\n" +
            "jmp -538\n" +
            "jmp +1\n" +
            "acc -16\n" +
            "nop -127\n" +
            "jmp -407\n" +
            "acc +5\n" +
            "jmp -57\n" +
            "acc +21\n" +
            "acc +3\n" +
            "acc +42\n" +
            "acc +43\n" +
            "jmp -521\n" +
            "acc -9\n" +
            "acc +20\n" +
            "nop -217\n" +
            "jmp -15\n" +
            "acc +37\n" +
            "acc -12\n" +
            "acc -18\n" +
            "jmp +1\n" +
            "jmp -465\n" +
            "acc +37\n" +
            "nop -577\n" +
            "acc +8\n" +
            "acc +43\n" +
            "jmp +1").split("\n"));

    public static void main(String[] args) {
//        part1();
        part2();
    }

    private static void part1() {
        List<Integer> history = new ArrayList<>();
        int accumulator = 0;
        int index = 0;

        while (true) {
            String[] instructionLineSplit = instructions.get(index).split(" ");
            final String instruction = instructionLineSplit[0];
            final int value = Integer.parseInt(instructionLineSplit[1]);
            if (history.contains(index)) {
                break;
            }

            history.add(index);

            switch (instruction) {
                case "acc" -> {
                    accumulator += value;
                    index++;
                }
                case "nop" -> index++;
                case "jmp" -> index += value;
            }
        }

        System.out.println(accumulator);
    }

    private static void part2() {
        int accumulator = 0;
        int currentIndex = 0;

        while (currentIndex < instructions.size() - 1) {
            String[] instructionLineSplit = instructions.get(currentIndex).split(" ");
            final String instruction = instructionLineSplit[0];
            final int value = Integer.parseInt(instructionLineSplit[1]);

            if (instruction.startsWith("jmp") && value < 0) {
                String[] jumpedInstructionLine = instructions.get(currentIndex + value).split(" ");
                final String jumpedInstruction = jumpedInstructionLine[0];
                final int jumpedValue = Integer.parseInt(jumpedInstructionLine[1]);

                if (!jumpedInstruction.startsWith("jmp")) {
                    instructions.set(currentIndex, "nop " + value);
                    System.out.println(currentIndex);
                } else if (jumpedInstruction.startsWith("jmp") && abs(jumpedValue) <= abs(value)) {
                    instructions.set(currentIndex, "nop " + value);
                    System.out.println(currentIndex);
                }

                accumulator = 0;
                currentIndex = 0;
                continue;
            }

            switch (instruction) {
                case "acc" -> {
                    accumulator += value;
                    currentIndex++;
                }
                case "nop" -> currentIndex++;
                case "jmp" -> currentIndex += value;
            }
        }

        System.out.println(accumulator);
    }
}
