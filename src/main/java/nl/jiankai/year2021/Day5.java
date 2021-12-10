package nl.jiankai.year2021;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day5 {
    static int[][] test = new int[1000][1000];
    public static void main(String[] args) {
        part1();
        part2();
    }

    private static void part1() {
        int overlapping = 0;

        for (String line : input) {
            String[] points = line.split(" -> ");
            String[] point1 = points[0].split(",");
            String[] point2 = points[1].split(",");
            int x1 = Integer.parseInt(point1[0]);
            int y1 = Integer.parseInt(point1[1]);
            int x2 = Integer.parseInt(point2[0]);
            int y2 = Integer.parseInt(point2[1]);

            doHorizontalOrVertical(x1, y1, x2, y2);
        }
        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test[i].length; j++) {
                if (test[i][j] >= 2) {
                    overlapping++;
                }
            }
        }

        System.out.println(overlapping);
    }

    static void part2() {
        int overlapping = 0;

        for (String line : input) {
            String[] points = line.split(" -> ");
            String[] point1 = points[0].split(",");
            String[] point2 = points[1].split(",");
            int x1 = Integer.parseInt(point1[0]);
            int y1 = Integer.parseInt(point1[1]);
            int x2 = Integer.parseInt(point2[0]);
            int y2 = Integer.parseInt(point2[1]);

            boolean isDiagonalLine = Math.abs(x1 - x2) > 0 && Math.abs(y1 - y2) > 0;


            if (isDiagonalLine) {
                doDiagonal(x1, y1, x2, y2);
            } else {
                doHorizontalOrVertical(x1, y1, x2, y2);
            }
        }
        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test[i].length; j++) {
                if (test[i][j] >= 2) {
                    overlapping++;
                }
            }
        }

        System.out.println(overlapping);
    }

    private static void doDiagonal(int x1, int y1, int x2, int y2) {
        while (x1 != x2 || y1 != y2) {
            test[x1][y1]++;
            if (x1 < x2) {
                x1++;
            } else if (x1 > x2){
                x1--;
            }

            if (y1 < y2) {
                y1++;
            } else if (y1 > y2) {
                y1--;
            }
            if (x1 == x2 && y1 == y2) {
                test[x1][y1]++;
            }
        }
    }

    private static void doHorizontalOrVertical(int x1, int y1, int x2, int y2) {
        if (x1 == x2) {
            if (y1 < y2) {
                for (int i = y1; i <= y2; i++) {
                    test[x1][i]++;
                }
            } else {
                for (int i = y2; i <= y1; i++) {
                    test[x1][i]++;
                }
            }
        } else if (y1 == y2) {
            if (x1 < x2) {
                for (int i = x1; i <= x2; i++) {
                    test[i][y1]++;
                }
            } else {
                for (int i = x2; i <= x1; i++) {
                    test[i][y1]++;
                }
            }
        }
    }

    static List<String> input = Arrays.stream(("682,519 -> 682,729\n" +
            "852,131 -> 25,958\n" +
            "303,481 -> 206,481\n" +
            "199,682 -> 183,666\n" +
            "363,190 -> 571,190\n" +
            "930,290 -> 221,290\n" +
            "364,627 -> 952,39\n" +
            "234,309 -> 234,821\n" +
            "130,864 -> 130,886\n" +
            "462,347 -> 699,110\n" +
            "375,969 -> 481,969\n" +
            "989,859 -> 275,145\n" +
            "221,748 -> 212,748\n" +
            "870,173 -> 106,937\n" +
            "604,33 -> 604,142\n" +
            "780,35 -> 780,206\n" +
            "636,808 -> 721,808\n" +
            "944,989 -> 334,989\n" +
            "477,113 -> 192,113\n" +
            "879,265 -> 879,358\n" +
            "754,974 -> 17,974\n" +
            "10,989 -> 989,10\n" +
            "337,320 -> 674,657\n" +
            "225,96 -> 557,428\n" +
            "129,354 -> 299,354\n" +
            "717,695 -> 695,695\n" +
            "94,255 -> 317,478\n" +
            "90,87 -> 90,187\n" +
            "77,942 -> 952,67\n" +
            "804,315 -> 989,315\n" +
            "619,470 -> 491,342\n" +
            "466,90 -> 466,755\n" +
            "840,121 -> 840,469\n" +
            "638,127 -> 638,77\n" +
            "844,40 -> 151,40\n" +
            "653,987 -> 653,631\n" +
            "195,583 -> 195,623\n" +
            "88,985 -> 570,503\n" +
            "921,897 -> 165,141\n" +
            "230,27 -> 171,27\n" +
            "737,771 -> 832,771\n" +
            "563,365 -> 665,467\n" +
            "942,940 -> 776,774\n" +
            "12,903 -> 644,903\n" +
            "308,390 -> 308,971\n" +
            "572,943 -> 572,15\n" +
            "104,389 -> 104,73\n" +
            "346,721 -> 974,93\n" +
            "30,53 -> 562,53\n" +
            "804,682 -> 804,120\n" +
            "952,45 -> 15,982\n" +
            "475,456 -> 475,348\n" +
            "409,247 -> 664,247\n" +
            "345,18 -> 816,489\n" +
            "571,158 -> 505,158\n" +
            "59,195 -> 27,195\n" +
            "230,681 -> 23,681\n" +
            "258,711 -> 921,711\n" +
            "658,112 -> 366,404\n" +
            "842,220 -> 842,825\n" +
            "815,744 -> 540,744\n" +
            "192,314 -> 703,825\n" +
            "869,573 -> 869,888\n" +
            "603,268 -> 603,301\n" +
            "816,668 -> 816,189\n" +
            "148,606 -> 948,606\n" +
            "117,461 -> 506,461\n" +
            "986,955 -> 986,315\n" +
            "131,250 -> 192,189\n" +
            "988,148 -> 518,618\n" +
            "682,900 -> 31,900\n" +
            "652,839 -> 652,236\n" +
            "466,812 -> 466,611\n" +
            "881,346 -> 401,346\n" +
            "229,639 -> 731,639\n" +
            "104,476 -> 840,476\n" +
            "10,988 -> 988,10\n" +
            "29,15 -> 987,973\n" +
            "825,348 -> 825,240\n" +
            "989,989 -> 10,10\n" +
            "430,796 -> 926,796\n" +
            "49,293 -> 610,854\n" +
            "325,288 -> 918,288\n" +
            "625,309 -> 439,495\n" +
            "536,150 -> 356,150\n" +
            "834,558 -> 822,558\n" +
            "315,408 -> 315,635\n" +
            "257,973 -> 813,973\n" +
            "713,52 -> 122,52\n" +
            "323,970 -> 578,970\n" +
            "447,49 -> 829,49\n" +
            "941,709 -> 941,390\n" +
            "148,323 -> 391,80\n" +
            "23,171 -> 23,49\n" +
            "475,265 -> 322,112\n" +
            "506,407 -> 69,844\n" +
            "567,284 -> 483,368\n" +
            "114,745 -> 114,765\n" +
            "392,252 -> 109,535\n" +
            "65,188 -> 455,188\n" +
            "732,779 -> 732,52\n" +
            "233,214 -> 759,214\n" +
            "232,969 -> 957,244\n" +
            "20,669 -> 20,308\n" +
            "49,972 -> 285,972\n" +
            "501,383 -> 433,383\n" +
            "918,15 -> 32,901\n" +
            "255,268 -> 935,948\n" +
            "757,588 -> 757,919\n" +
            "530,803 -> 284,557\n" +
            "688,926 -> 48,286\n" +
            "331,245 -> 331,777\n" +
            "448,544 -> 209,544\n" +
            "10,970 -> 951,29\n" +
            "233,11 -> 897,11\n" +
            "145,392 -> 628,392\n" +
            "935,971 -> 935,280\n" +
            "169,632 -> 54,632\n" +
            "155,244 -> 155,334\n" +
            "56,284 -> 205,284\n" +
            "553,428 -> 553,520\n" +
            "977,176 -> 497,656\n" +
            "323,339 -> 971,987\n" +
            "616,355 -> 616,248\n" +
            "72,660 -> 72,334\n" +
            "644,822 -> 510,956\n" +
            "356,841 -> 587,841\n" +
            "413,468 -> 605,468\n" +
            "85,22 -> 645,582\n" +
            "924,850 -> 522,850\n" +
            "448,45 -> 345,148\n" +
            "102,566 -> 551,566\n" +
            "80,39 -> 847,806\n" +
            "936,436 -> 934,436\n" +
            "53,24 -> 495,466\n" +
            "234,173 -> 282,173\n" +
            "145,680 -> 456,680\n" +
            "960,759 -> 960,282\n" +
            "984,814 -> 308,138\n" +
            "398,808 -> 716,808\n" +
            "509,536 -> 25,52\n" +
            "289,777 -> 803,263\n" +
            "766,892 -> 257,892\n" +
            "301,733 -> 688,733\n" +
            "24,109 -> 887,972\n" +
            "180,32 -> 577,429\n" +
            "985,801 -> 687,503\n" +
            "901,582 -> 586,582\n" +
            "50,56 -> 50,267\n" +
            "344,373 -> 437,373\n" +
            "542,133 -> 905,496\n" +
            "420,624 -> 420,716\n" +
            "645,106 -> 645,574\n" +
            "356,37 -> 114,37\n" +
            "324,919 -> 357,919\n" +
            "126,797 -> 120,797\n" +
            "288,689 -> 435,836\n" +
            "93,915 -> 639,369\n" +
            "106,391 -> 478,19\n" +
            "277,501 -> 714,64\n" +
            "253,277 -> 643,277\n" +
            "568,972 -> 350,972\n" +
            "213,235 -> 213,406\n" +
            "595,888 -> 595,233\n" +
            "577,63 -> 37,603\n" +
            "649,732 -> 931,732\n" +
            "469,892 -> 549,892\n" +
            "953,895 -> 953,457\n" +
            "222,213 -> 290,213\n" +
            "841,800 -> 841,336\n" +
            "685,143 -> 25,143\n" +
            "441,127 -> 441,146\n" +
            "646,586 -> 56,586\n" +
            "698,122 -> 465,122\n" +
            "641,502 -> 641,240\n" +
            "111,91 -> 185,91\n" +
            "927,755 -> 874,808\n" +
            "108,151 -> 108,567\n" +
            "309,453 -> 309,210\n" +
            "890,657 -> 491,657\n" +
            "404,244 -> 404,123\n" +
            "939,28 -> 26,941\n" +
            "596,970 -> 596,870\n" +
            "489,556 -> 489,589\n" +
            "607,621 -> 903,325\n" +
            "912,284 -> 571,284\n" +
            "921,702 -> 743,524\n" +
            "719,36 -> 719,394\n" +
            "100,905 -> 798,207\n" +
            "316,260 -> 316,887\n" +
            "799,940 -> 885,940\n" +
            "835,287 -> 199,923\n" +
            "422,760 -> 64,760\n" +
            "727,113 -> 727,679\n" +
            "733,56 -> 59,730\n" +
            "141,399 -> 485,743\n" +
            "769,629 -> 769,797\n" +
            "62,486 -> 62,205\n" +
            "192,332 -> 800,332\n" +
            "15,931 -> 727,931\n" +
            "854,915 -> 988,915\n" +
            "349,610 -> 886,610\n" +
            "72,110 -> 72,903\n" +
            "955,110 -> 78,987\n" +
            "591,553 -> 591,428\n" +
            "708,467 -> 516,467\n" +
            "397,589 -> 353,589\n" +
            "930,336 -> 930,532\n" +
            "639,50 -> 228,50\n" +
            "472,17 -> 472,244\n" +
            "420,825 -> 420,562\n" +
            "203,197 -> 203,35\n" +
            "984,964 -> 223,203\n" +
            "944,269 -> 935,260\n" +
            "933,119 -> 87,965\n" +
            "696,290 -> 696,580\n" +
            "925,960 -> 52,87\n" +
            "451,470 -> 235,254\n" +
            "562,71 -> 562,149\n" +
            "405,126 -> 405,67\n" +
            "356,424 -> 356,673\n" +
            "859,649 -> 859,291\n" +
            "210,651 -> 210,544\n" +
            "403,783 -> 403,122\n" +
            "672,87 -> 586,87\n" +
            "409,668 -> 984,668\n" +
            "917,352 -> 511,758\n" +
            "395,953 -> 141,953\n" +
            "152,795 -> 152,313\n" +
            "839,344 -> 811,372\n" +
            "114,649 -> 650,649\n" +
            "60,517 -> 60,27\n" +
            "448,392 -> 845,392\n" +
            "33,849 -> 719,163\n" +
            "151,988 -> 876,988\n" +
            "805,556 -> 124,556\n" +
            "361,538 -> 706,193\n" +
            "974,941 -> 141,108\n" +
            "271,813 -> 968,116\n" +
            "500,697 -> 80,277\n" +
            "586,731 -> 586,480\n" +
            "128,147 -> 174,101\n" +
            "882,681 -> 882,745\n" +
            "531,730 -> 677,730\n" +
            "989,11 -> 11,989\n" +
            "74,332 -> 234,492\n" +
            "360,326 -> 932,898\n" +
            "136,288 -> 113,311\n" +
            "666,645 -> 916,895\n" +
            "977,478 -> 561,62\n" +
            "20,83 -> 566,83\n" +
            "331,942 -> 331,646\n" +
            "180,291 -> 405,291\n" +
            "637,763 -> 637,941\n" +
            "120,138 -> 120,820\n" +
            "951,24 -> 14,961\n" +
            "204,304 -> 204,51\n" +
            "84,168 -> 880,168\n" +
            "955,145 -> 955,903\n" +
            "437,427 -> 437,354\n" +
            "875,67 -> 189,753\n" +
            "46,767 -> 802,11\n" +
            "52,59 -> 889,896\n" +
            "926,56 -> 102,880\n" +
            "500,30 -> 964,30\n" +
            "329,488 -> 329,972\n" +
            "63,11 -> 889,837\n" +
            "707,168 -> 707,584\n" +
            "580,10 -> 735,10\n" +
            "105,620 -> 105,110\n" +
            "187,531 -> 323,531\n" +
            "82,947 -> 82,941\n" +
            "737,199 -> 737,851\n" +
            "612,650 -> 217,650\n" +
            "971,15 -> 82,904\n" +
            "16,590 -> 506,100\n" +
            "950,877 -> 832,759\n" +
            "570,470 -> 570,276\n" +
            "213,411 -> 213,195\n" +
            "670,755 -> 89,755\n" +
            "906,963 -> 906,984\n" +
            "458,463 -> 442,463\n" +
            "956,969 -> 10,23\n" +
            "87,215 -> 195,107\n" +
            "819,454 -> 819,467\n" +
            "594,793 -> 686,793\n" +
            "395,724 -> 787,332\n" +
            "315,461 -> 644,461\n" +
            "448,247 -> 249,48\n" +
            "620,302 -> 247,675\n" +
            "607,134 -> 932,134\n" +
            "312,776 -> 312,289\n" +
            "850,942 -> 54,146\n" +
            "31,538 -> 851,538\n" +
            "729,126 -> 640,126\n" +
            "702,199 -> 702,706\n" +
            "402,783 -> 254,783\n" +
            "110,59 -> 203,59\n" +
            "27,10 -> 965,948\n" +
            "747,261 -> 47,261\n" +
            "628,742 -> 972,742\n" +
            "712,742 -> 657,797\n" +
            "877,871 -> 877,758\n" +
            "665,313 -> 449,529\n" +
            "498,157 -> 498,68\n" +
            "870,922 -> 27,79\n" +
            "856,697 -> 856,429\n" +
            "447,271 -> 963,787\n" +
            "495,302 -> 495,520\n" +
            "526,47 -> 721,47\n" +
            "826,179 -> 826,741\n" +
            "565,461 -> 893,461\n" +
            "512,328 -> 127,328\n" +
            "487,920 -> 522,920\n" +
            "614,452 -> 614,146\n" +
            "331,574 -> 331,840\n" +
            "985,79 -> 285,779\n" +
            "812,320 -> 985,320\n" +
            "118,69 -> 429,69\n" +
            "644,525 -> 644,878\n" +
            "271,132 -> 156,132\n" +
            "955,782 -> 565,392\n" +
            "630,939 -> 630,372\n" +
            "51,203 -> 840,203\n" +
            "202,490 -> 202,479\n" +
            "579,868 -> 579,92\n" +
            "979,336 -> 979,623\n" +
            "843,865 -> 260,282\n" +
            "685,872 -> 685,503\n" +
            "721,193 -> 721,510\n" +
            "908,661 -> 908,955\n" +
            "19,950 -> 715,254\n" +
            "233,730 -> 233,101\n" +
            "922,954 -> 27,954\n" +
            "399,444 -> 399,403\n" +
            "380,712 -> 380,718\n" +
            "238,264 -> 849,875\n" +
            "458,577 -> 458,139\n" +
            "418,244 -> 469,295\n" +
            "460,375 -> 964,879\n" +
            "276,445 -> 815,445\n" +
            "463,910 -> 648,725\n" +
            "26,384 -> 968,384\n" +
            "955,385 -> 955,143\n" +
            "942,775 -> 733,566\n" +
            "425,326 -> 531,326\n" +
            "364,545 -> 364,873\n" +
            "182,759 -> 182,819\n" +
            "390,757 -> 390,475\n" +
            "217,417 -> 217,157\n" +
            "669,286 -> 65,890\n" +
            "257,11 -> 257,858\n" +
            "557,397 -> 557,20\n" +
            "888,946 -> 32,90\n" +
            "971,938 -> 971,578\n" +
            "874,248 -> 874,485\n" +
            "87,268 -> 87,135\n" +
            "756,679 -> 103,26\n" +
            "771,250 -> 771,107\n" +
            "320,711 -> 967,711\n" +
            "293,219 -> 293,706\n" +
            "103,565 -> 103,538\n" +
            "388,256 -> 388,261\n" +
            "468,953 -> 503,953\n" +
            "424,142 -> 287,142\n" +
            "24,930 -> 850,930\n" +
            "316,167 -> 316,161\n" +
            "481,421 -> 208,148\n" +
            "938,926 -> 938,933\n" +
            "701,653 -> 701,780\n" +
            "536,390 -> 536,559\n" +
            "40,954 -> 829,165\n" +
            "404,985 -> 247,985\n" +
            "94,628 -> 94,500\n" +
            "441,637 -> 441,271\n" +
            "766,946 -> 97,277\n" +
            "428,363 -> 428,37\n" +
            "542,694 -> 542,347\n" +
            "11,16 -> 979,984\n" +
            "938,651 -> 632,957\n" +
            "779,127 -> 243,663\n" +
            "636,294 -> 636,787\n" +
            "533,744 -> 636,641\n" +
            "521,950 -> 458,950\n" +
            "988,12 -> 18,982\n" +
            "954,621 -> 954,271\n" +
            "638,951 -> 813,951\n" +
            "822,911 -> 632,911\n" +
            "714,849 -> 512,849\n" +
            "696,88 -> 385,88\n" +
            "65,451 -> 65,687\n" +
            "976,973 -> 976,907\n" +
            "368,489 -> 368,571\n" +
            "358,831 -> 690,499\n" +
            "436,704 -> 178,704\n" +
            "690,619 -> 606,535\n" +
            "96,701 -> 358,701\n" +
            "885,562 -> 420,562\n" +
            "581,480 -> 613,512\n" +
            "44,970 -> 970,44\n" +
            "216,796 -> 892,120\n" +
            "72,623 -> 72,72\n" +
            "896,283 -> 896,326\n" +
            "794,195 -> 22,967\n" +
            "134,326 -> 134,889\n" +
            "420,141 -> 944,665\n" +
            "941,194 -> 941,421\n" +
            "940,525 -> 298,525\n" +
            "653,300 -> 769,300\n" +
            "227,424 -> 406,603\n" +
            "275,850 -> 113,850\n" +
            "648,850 -> 92,850\n" +
            "638,389 -> 638,10\n" +
            "379,404 -> 584,609\n" +
            "833,931 -> 833,520\n" +
            "772,286 -> 500,558\n" +
            "372,262 -> 333,262\n" +
            "689,18 -> 131,576\n" +
            "687,499 -> 687,188\n" +
            "344,499 -> 37,806\n" +
            "778,496 -> 134,496\n" +
            "938,87 -> 344,681\n" +
            "788,401 -> 479,401\n" +
            "828,903 -> 756,903\n" +
            "423,625 -> 285,763\n" +
            "218,489 -> 218,819\n" +
            "488,384 -> 891,787\n" +
            "817,532 -> 788,532\n" +
            "512,27 -> 512,149\n" +
            "369,794 -> 54,794\n" +
            "534,590 -> 827,883\n" +
            "84,310 -> 39,265\n" +
            "357,545 -> 665,545\n" +
            "539,807 -> 539,781\n" +
            "378,683 -> 22,327\n" +
            "71,909 -> 943,37\n" +
            "740,552 -> 348,552\n" +
            "698,315 -> 45,968\n" +
            "516,835 -> 360,835\n" +
            "629,141 -> 629,385\n" +
            "695,908 -> 303,908\n" +
            "795,707 -> 386,707\n" +
            "211,397 -> 291,397\n" +
            "64,620 -> 236,620\n" +
            "97,638 -> 97,445\n" +
            "46,103 -> 893,950\n" +
            "468,122 -> 979,122\n" +
            "810,486 -> 433,486\n" +
            "532,899 -> 461,970\n" +
            "232,60 -> 235,60\n" +
            "549,708 -> 549,90\n" +
            "294,978 -> 294,124\n" +
            "865,406 -> 640,406\n" +
            "755,305 -> 664,305\n" +
            "12,989 -> 987,14\n" +
            "275,249 -> 260,234\n" +
            "502,783 -> 67,783\n" +
            "863,938 -> 297,372\n" +
            "516,961 -> 516,272\n" +
            "67,510 -> 611,510\n" +
            "980,951 -> 312,283\n" +
            "325,512 -> 325,169\n" +
            "142,429 -> 542,29\n" +
            "273,964 -> 822,964\n" +
            "370,217 -> 508,217\n" +
            "131,131 -> 331,331\n" +
            "734,824 -> 734,817\n" +
            "75,89 -> 687,701\n" +
            "155,255 -> 702,802\n" +
            "577,395 -> 130,395\n" +
            "684,94 -> 555,94\n" +
            "393,881 -> 173,881\n" +
            "894,750 -> 773,750\n" +
            "380,269 -> 380,338\n" +
            "427,36 -> 427,77\n" +
            "637,107 -> 637,846\n" +
            "53,437 -> 53,221\n" +
            "128,979 -> 960,147\n" +
            "838,211 -> 838,645\n" +
            "898,39 -> 849,39\n" +
            "862,495 -> 951,495\n" +
            "754,406 -> 76,406\n" +
            "951,960 -> 113,122\n" +
            "830,125 -> 15,940\n" +
            "190,117 -> 190,973\n" +
            "192,956 -> 718,430\n" +
            "895,162 -> 88,969\n" +
            "135,196 -> 70,131\n" +
            "578,642 -> 578,789\n" +
            "713,268 -> 625,268\n" +
            "938,719 -> 938,604\n" +
            "30,863 -> 99,863\n" +
            "844,309 -> 287,309\n" +
            "131,837 -> 459,509\n" +
            "61,206 -> 722,867\n" +
            "95,974 -> 283,974\n" +
            "746,672 -> 558,672\n" +
            "552,32 -> 352,32\n" +
            "21,637 -> 21,781\n" +
            "945,847 -> 945,303").split("\n")).collect(Collectors.toList());
}
