package nl.jiankai.year2020;

import java.util.Arrays;
import java.util.List;

public class Day4 {
    private static String s = "byr:1971\n" +
            "eyr:2039\n" +
            "hgt:172in pid:170cm hcl:17106b iyr:2012 ecl:gry\n" +
            "cid:339\n" +
            "\n" +
            "hgt:161cm eyr:2027\n" +
            "ecl:grn iyr:2011 hcl:#a97842 byr:1977 pid:910468396\n" +
            "\n" +
            "cid:257\n" +
            "ecl:gry hgt:186cm iyr:2012\n" +
            "byr:1941\n" +
            "eyr:2029\n" +
            "pid:108935675\n" +
            "hcl:#cfa07d\n" +
            "\n" +
            "hgt:165in\n" +
            "hcl:#cfa07d eyr:2035 pid:82570731\n" +
            "byr:1973\n" +
            "cid:74 ecl:xry\n" +
            "\n" +
            "eyr:2020 cid:105 iyr:2012 pid:947726115\n" +
            "hcl:#ceb3a1 ecl:grn byr:1966 hgt:151cm\n" +
            "\n" +
            "hcl:#888785 eyr:2027 ecl:hzl byr:1966\n" +
            "pid:853607760\n" +
            "iyr:2012\n" +
            "hgt:155cm\n" +
            "\n" +
            "hgt:61cm\n" +
            "iyr:2019\n" +
            "byr:1952 pid:#1468e6 eyr:2033 ecl:#7d39d5 hcl:z\n" +
            "\n" +
            "pid:2306523501\n" +
            "eyr:2032 hcl:z ecl:brn\n" +
            "cid:266 hgt:151in iyr:2024\n" +
            "byr:2008\n" +
            "\n" +
            "hcl:#a97842 hgt:191cm eyr:2025 ecl:gry byr:1923 pid:574171850 iyr:2019\n" +
            "\n" +
            "hgt:140\n" +
            "iyr:1987 byr:2003\n" +
            "eyr:2013 cid:242 hcl:z\n" +
            "ecl:#19177c pid:150cm\n" +
            "\n" +
            "byr:1959\n" +
            "hgt:169cm hcl:#7d3b0c ecl:gry eyr:2028 cid:107 pid:584790749\n" +
            "\n" +
            "byr:1955\n" +
            "cid:309\n" +
            "hcl:#a97842\n" +
            "pid:740105085 iyr:2020\n" +
            "hgt:188cm ecl:oth eyr:2029\n" +
            "\n" +
            "iyr:2016 hcl:#cfa07d eyr:2026\n" +
            "hgt:151cm\n" +
            "pid:394185014 ecl:grn byr:1974\n" +
            "\n" +
            "pid:226566060 ecl:blu cid:272 hgt:188cm hcl:#efcc98\n" +
            "eyr:2029 iyr:2014\n" +
            "byr:1956\n" +
            "\n" +
            "pid:#7c7a9d ecl:#8fa327\n" +
            "eyr:2006 iyr:2022\n" +
            "hcl:#7d3b0c hgt:169\n" +
            "byr:2025\n" +
            "\n" +
            "hgt:188in byr:2015 ecl:xry\n" +
            "iyr:1975\n" +
            "eyr:1928\n" +
            "pid:8939875193 hcl:7bbcce\n" +
            "\n" +
            "hgt:193cm\n" +
            "eyr:2029\n" +
            "pid:141707808 byr:1997\n" +
            "cid:83 iyr:2019\n" +
            "ecl:hzl hcl:#cfa07d\n" +
            "\n" +
            "iyr:2019\n" +
            "pid:681586971\n" +
            "hcl:#6b5442 hgt:165cm\n" +
            "eyr:2022 ecl:brn byr:1985\n" +
            "\n" +
            "byr:1970\n" +
            "iyr:2016 hgt:156in pid:#e32394 eyr:2024\n" +
            "hcl:#efcc98 ecl:grt\n" +
            "\n" +
            "iyr:2013\n" +
            "ecl:grn pid:341584587 eyr:2027 hgt:185cm hcl:#18171d\n" +
            "byr:1935\n" +
            "cid:113\n" +
            "\n" +
            "hcl:#fffffd ecl:grn iyr:2010\n" +
            "pid:738986504 hgt:98 eyr:2024\n" +
            "byr:1968\n" +
            "\n" +
            "pid:175337478 ecl:oth hgt:173cm hcl:#733820\n" +
            "eyr:2025 byr:1960\n" +
            "cid:283 iyr:2018\n" +
            "\n" +
            "byr:1959\n" +
            "hcl:#341e13 eyr:2023\n" +
            "pid:566612260 hgt:176cm\n" +
            "iyr:2017 ecl:grn\n" +
            "\n" +
            "cid:321 pid:355095309 byr:1945\n" +
            "hgt:161cm\n" +
            "eyr:2029 iyr:2017\n" +
            "ecl:brn hcl:#733820\n" +
            "\n" +
            "hcl:#c0946f pid:75316487 iyr:2013 cid:201 hgt:152cm ecl:lzr byr:1996 eyr:1928\n" +
            "\n" +
            "hgt:160cm iyr:2010 hcl:#a018b9\n" +
            "eyr:2024 ecl:amb\n" +
            "cid:347\n" +
            "\n" +
            "eyr:2021\n" +
            "pid:893047101 iyr:2016 ecl:hzl hcl:#866857 byr:1988\n" +
            "hgt:166cm\n" +
            "\n" +
            "hcl:#7d3b0c\n" +
            "ecl:blu pid:085336099 eyr:2024\n" +
            "iyr:2019 hgt:178cm byr:1999\n" +
            "\n" +
            "ecl:grt iyr:2022\n" +
            "hcl:z\n" +
            "hgt:192cm byr:2010\n" +
            "\n" +
            "pid:677187953 eyr:2025 iyr:2020 hgt:163cm byr:1957 ecl:grn hcl:#cfa07d\n" +
            "\n" +
            "cid:213\n" +
            "byr:1987\n" +
            "pid:113078018 ecl:blu iyr:2013 eyr:2022\n" +
            "hcl:#7d3b0c hgt:157cm\n" +
            "\n" +
            "ecl:blu hcl:#c0946f hgt:186cm\n" +
            "byr:1992 eyr:2028 iyr:2010\n" +
            "\n" +
            "pid:#b01156 hgt:67\n" +
            "byr:2014 ecl:#35dca0 eyr:1922 hcl:790130\n" +
            "\n" +
            "hcl:#602927\n" +
            "ecl:blu hgt:173cm byr:1974 pid:116377061 cid:294 eyr:2030 iyr:2010\n" +
            "\n" +
            "hgt:151cm eyr:2022 iyr:2011 ecl:blu byr:1987 hcl:#733820\n" +
            "pid:#b90d2e\n" +
            "\n" +
            "cid:188\n" +
            "byr:1990\n" +
            "hcl:#602927 iyr:2026\n" +
            "pid:530373696\n" +
            "hgt:154cm ecl:gry\n" +
            "eyr:2029\n" +
            "\n" +
            "hgt:178cm eyr:2027\n" +
            "hcl:#733820\n" +
            "ecl:grn iyr:2014 pid:575371227 byr:1965\n" +
            "\n" +
            "hcl:#fffffd iyr:2020\n" +
            "hgt:185cm ecl:amb pid:692760311\n" +
            "byr:1961\n" +
            "\n" +
            "byr:1967 pid:397518948 ecl:lzr iyr:2015 hcl:#cfa07d cid:328\n" +
            "hgt:177cm eyr:2035\n" +
            "\n" +
            "hcl:#8e1608\n" +
            "pid:554618249 iyr:2010 hgt:176cm cid:220\n" +
            "ecl:brn byr:1928 eyr:2029\n" +
            "\n" +
            "eyr:2030\n" +
            "ecl:oth cid:177 hcl:#602927\n" +
            "iyr:2010 hgt:66in\n" +
            "pid:915661465 byr:1992\n" +
            "\n" +
            "ecl:brn pid:558826437 hgt:151cm byr:1936 hcl:#fffffd\n" +
            "eyr:2021 iyr:2012\n" +
            "\n" +
            "eyr:2033\n" +
            "iyr:2019 hgt:190cm byr:1953\n" +
            "hcl:#6b5442\n" +
            "pid:584941735 ecl:hzl\n" +
            "\n" +
            "hgt:71cm\n" +
            "byr:2015 iyr:2025\n" +
            "ecl:#663b65 eyr:2039 hcl:z pid:62548949\n" +
            "\n" +
            "ecl:hzl byr:1943\n" +
            "iyr:2020 hgt:175cm pid:830628564 hcl:#7d3b0c eyr:2021\n" +
            "\n" +
            "hgt:182cm byr:1951 cid:175 eyr:2021 pid:635966127 ecl:blu iyr:2014 hcl:#18171d\n" +
            "\n" +
            "hcl:#733820 iyr:2011 pid:581100835 eyr:2022 ecl:grn byr:1985 hgt:192cm\n" +
            "\n" +
            "iyr:2013\n" +
            "ecl:grn\n" +
            "hgt:185cm hcl:#a97842 byr:1981 eyr:2029 pid:711625030\n" +
            "\n" +
            "byr:1995\n" +
            "pid:326992839\n" +
            "iyr:2015\n" +
            "eyr:2028 hcl:#733820 ecl:hzl\n" +
            "\n" +
            "hgt:160\n" +
            "eyr:2037 ecl:#6b6b83\n" +
            "cid:123 iyr:2028\n" +
            "pid:7692333345\n" +
            "hcl:z byr:2029\n" +
            "\n" +
            "hcl:#6b5442 iyr:2030\n" +
            "hgt:165cm byr:2028 ecl:#21516d\n" +
            "eyr:2039\n" +
            "pid:182cm\n" +
            "\n" +
            "hgt:159cm iyr:2018 pid:610521467 eyr:2028 ecl:amb byr:1934 hcl:#602927\n" +
            "\n" +
            "ecl:blu\n" +
            "hcl:#09d9a5 hgt:162cm iyr:2020\n" +
            "eyr:2025 byr:1971 pid:406714780\n" +
            "\n" +
            "hgt:179cm eyr:2022 hcl:#18171d\n" +
            "ecl:blu pid:314891131 iyr:2015\n" +
            "byr:2002\n" +
            "\n" +
            "hcl:#623a2f hgt:181cm pid:442693333 byr:1990 ecl:grn eyr:2027\n" +
            "iyr:2011\n" +
            "\n" +
            "iyr:2022 eyr:1939\n" +
            "pid:557187110 hcl:#18171d hgt:60cm ecl:#d6ac04 byr:1984\n" +
            "\n" +
            "ecl:grn byr:1948 hgt:174cm pid:438876745 cid:321\n" +
            "iyr:2018\n" +
            "hcl:#866857 eyr:2023\n" +
            "\n" +
            "hgt:189cm iyr:2012 hcl:#602927 pid:978388052 ecl:brn\n" +
            "eyr:2030\n" +
            "\n" +
            "ecl:amb cid:235\n" +
            "byr:1938\n" +
            "pid:315825546 hcl:#ceb3a1 eyr:2029\n" +
            "iyr:2013 hgt:171cm\n" +
            "\n" +
            "ecl:dne hcl:z\n" +
            "hgt:76cm byr:2010\n" +
            "cid:185 eyr:2001\n" +
            "\n" +
            "hcl:#733820 byr:1988 pid:558453117\n" +
            "hgt:66in\n" +
            "ecl:oth iyr:2010 eyr:2021\n" +
            "\n" +
            "byr:1926 pid:796557821 cid:155 hcl:#efcc98\n" +
            "hgt:159cm eyr:2023 ecl:oth iyr:2016\n" +
            "\n" +
            "byr:2023 eyr:2031 hcl:0ba99a pid:14902250\n" +
            "hgt:132 ecl:#9b89b1 iyr:2017\n" +
            "\n" +
            "hcl:#a97842 byr:1926\n" +
            "cid:205\n" +
            "ecl:blu\n" +
            "iyr:2016 hgt:159cm eyr:2029\n" +
            "\n" +
            "byr:1939 hcl:#866857\n" +
            "pid:025607627 hgt:174cm cid:309 eyr:2026 ecl:brn\n" +
            "\n" +
            "ecl:hzl pid:805133506\n" +
            "iyr:2014\n" +
            "byr:1991\n" +
            "hcl:#cfa07d\n" +
            "cid:350\n" +
            "hgt:190cm\n" +
            "\n" +
            "hgt:155cm byr:1941 eyr:2024\n" +
            "cid:164 hcl:#602927 iyr:2013 pid:531781358 ecl:amb\n" +
            "\n" +
            "hcl:#72a068 hgt:164cm\n" +
            "pid:621006770\n" +
            "ecl:brn\n" +
            "eyr:2029 byr:1969\n" +
            "\n" +
            "byr:1991\n" +
            "ecl:grn iyr:2020\n" +
            "pid:9921729009 eyr:2029 hcl:#623a2f\n" +
            "hgt:62in\n" +
            "\n" +
            "iyr:2017 ecl:hzl\n" +
            "pid:768217275 eyr:2020 byr:1937\n" +
            "hcl:#866857 hgt:157cm\n" +
            "\n" +
            "cid:270 byr:1993 hcl:#733820 ecl:hzl pid:722650020\n" +
            "hgt:174cm iyr:2010\n" +
            "eyr:2021\n" +
            "\n" +
            "hcl:#c0946f ecl:blu\n" +
            "hgt:154cm\n" +
            "eyr:2022 byr:1929 pid:357023679 iyr:2010\n" +
            "\n" +
            "ecl:hzl\n" +
            "iyr:2013 hgt:165cm byr:1979 eyr:2023 hcl:#733820 pid:008734536\n" +
            "\n" +
            "hcl:#341e13\n" +
            "eyr:2030 byr:1993\n" +
            "iyr:2014 hgt:193cm\n" +
            "cid:346\n" +
            "ecl:blu pid:536339538\n" +
            "\n" +
            "eyr:2030\n" +
            "ecl:hzl\n" +
            "cid:296 pid:660062554 hcl:#efcc98\n" +
            "byr:1977 hgt:179cm\n" +
            "iyr:2010\n" +
            "\n" +
            "cid:119 pid:498520651 hgt:159cm\n" +
            "eyr:2029 iyr:2015 hcl:#18171d\n" +
            "ecl:gmt\n" +
            "byr:1950\n" +
            "\n" +
            "eyr:2025 iyr:2010 hcl:#efcc98 pid:196372989 hgt:181cm byr:1952 ecl:oth\n" +
            "\n" +
            "cid:317\n" +
            "eyr:2026 ecl:blu hcl:#733820\n" +
            "hgt:184cm\n" +
            "pid:549730813 byr:1927 iyr:2018\n" +
            "\n" +
            "pid:591769824\n" +
            "hgt:180cm\n" +
            "byr:1920\n" +
            "ecl:blu\n" +
            "eyr:2021 hcl:#cfa07d iyr:2017\n" +
            "\n" +
            "pid:988946348 hgt:183cm cid:117 byr:1955 ecl:blu\n" +
            "iyr:2015 hcl:#623a2f eyr:2029\n" +
            "\n" +
            "iyr:2014\n" +
            "eyr:2026 hgt:184cm\n" +
            "ecl:oth\n" +
            "hcl:#7d3b0c pid:252101860\n" +
            "\n" +
            "byr:1995\n" +
            "hgt:182cm ecl:brn hcl:#6b5442\n" +
            "iyr:2012 eyr:2028 pid:482757872\n" +
            "\n" +
            "iyr:2017 cid:333 ecl:gry hcl:#623a2f hgt:157cm eyr:2021\n" +
            "pid:487895819\n" +
            "byr:1951\n" +
            "\n" +
            "hcl:#fffffd\n" +
            "hgt:193cm eyr:2025 byr:1927 iyr:2014 ecl:oth pid:989206297\n" +
            "\n" +
            "eyr:2030 ecl:brn hcl:#18171d hgt:193cm\n" +
            "iyr:2013 byr:1953 pid:862636088\n" +
            "\n" +
            "hcl:#fffffd\n" +
            "pid:204286737 ecl:gry byr:1923\n" +
            "hgt:181cm\n" +
            "iyr:2015\n" +
            "eyr:2023\n" +
            "\n" +
            "cid:288 pid:413935643 ecl:gry\n" +
            "iyr:2012\n" +
            "hgt:171cm\n" +
            "hcl:#623a2f\n" +
            "eyr:2020 byr:1943\n" +
            "\n" +
            "byr:2023 hcl:#c0946f\n" +
            "ecl:oth\n" +
            "pid:182634296 eyr:2009\n" +
            "cid:306 hgt:183cm\n" +
            "iyr:2029\n" +
            "\n" +
            "eyr:2026 ecl:hzl byr:2003\n" +
            "iyr:2027 pid:734296691 hgt:188cm hcl:#fffffd\n" +
            "\n" +
            "hcl:#18171d ecl:gry pid:401957684 eyr:2020\n" +
            "iyr:2017 cid:141 byr:1944 hgt:74in\n" +
            "\n" +
            "ecl:grn hcl:z\n" +
            "pid:335097003 byr:1925\n" +
            "hgt:170in iyr:2020 eyr:2022\n" +
            "\n" +
            "pid:727198487\n" +
            "hgt:173cm\n" +
            "cid:323 hcl:#18171d iyr:2012 eyr:2024\n" +
            "byr:1995 ecl:blu\n" +
            "\n" +
            "ecl:amb hcl:#602927\n" +
            "pid:460274414\n" +
            "hgt:76in byr:1995\n" +
            "iyr:2020\n" +
            "eyr:2028\n" +
            "\n" +
            "byr:2002 ecl:oth pid:101164770\n" +
            "hgt:172cm hcl:#fffffd eyr:2023 iyr:2016\n" +
            "\n" +
            "ecl:blu hcl:#888785 iyr:2016 pid:031162631 eyr:2025 hgt:186cm\n" +
            "byr:1959\n" +
            "\n" +
            "ecl:blu pid:093242619 hgt:188cm byr:1970\n" +
            "eyr:2025\n" +
            "hcl:#6b5442\n" +
            "iyr:2020\n" +
            "\n" +
            "byr:1990 eyr:2025 ecl:grn\n" +
            "pid:907309460\n" +
            "iyr:2011 hcl:#602927 hgt:62in\n" +
            "\n" +
            "pid:346468647 eyr:2021\n" +
            "ecl:oth hgt:169cm\n" +
            "iyr:2010 cid:233\n" +
            "hcl:#b6652a byr:1977\n" +
            "\n" +
            "pid:904834317 iyr:2011\n" +
            "hcl:#b6652a eyr:2028 cid:281\n" +
            "byr:1944 hgt:187cm ecl:gry\n" +
            "\n" +
            "eyr:1988 pid:663941602\n" +
            "hgt:156in\n" +
            "hcl:#fa2e93 iyr:2015 ecl:gry byr:1953\n" +
            "\n" +
            "hgt:184cm cid:107 pid:094829817\n" +
            "ecl:gry byr:1998 eyr:2023 iyr:2017\n" +
            "\n" +
            "eyr:2020 ecl:gry byr:1955 hcl:#a97842 pid:553841536\n" +
            "\n" +
            "hgt:185cm eyr:2022 hcl:#341e13 ecl:oth byr:1934 pid:863541754 cid:178\n" +
            "iyr:2016\n" +
            "\n" +
            "eyr:2029 iyr:2014 byr:1937 cid:232 hgt:177cm hcl:#fffffd ecl:blu\n" +
            "pid:076753558\n" +
            "\n" +
            "hcl:#cfa07d\n" +
            "hgt:168cm\n" +
            "ecl:grn\n" +
            "pid:664159349 eyr:2028 iyr:2017 byr:1972\n" +
            "\n" +
            "hcl:#a97842\n" +
            "byr:1987\n" +
            "eyr:2020 hgt:182cm\n" +
            "iyr:2018\n" +
            "ecl:brn pid:560272731\n" +
            "\n" +
            "hgt:172cm cid:125 ecl:blu pid:291640184\n" +
            "byr:1926\n" +
            "iyr:2014 hcl:#ceb3a1\n" +
            "\n" +
            "iyr:2027 hgt:84 hcl:z\n" +
            "ecl:#b68fec\n" +
            "pid:809408661\n" +
            "byr:2018 eyr:1927 cid:87\n" +
            "\n" +
            "pid:951007276 cid:260 eyr:2025\n" +
            "ecl:brn iyr:2015 byr:1957\n" +
            "hcl:#4b8216 hgt:161cm\n" +
            "\n" +
            "pid:359973697 hcl:#6b5442\n" +
            "eyr:2022 hgt:169cm\n" +
            "byr:1965 ecl:brn iyr:2013\n" +
            "\n" +
            "iyr:2012 hgt:65in eyr:2024 pid:842371195\n" +
            "ecl:amb\n" +
            "hcl:#341e13 byr:2000\n" +
            "\n" +
            "ecl:hzl hgt:170cm byr:1950\n" +
            "cid:289 eyr:2037 iyr:2021 hcl:#18171d pid:389051819\n" +
            "\n" +
            "hgt:159cm\n" +
            "ecl:amb hcl:#c0946f eyr:2020 pid:010539976 iyr:2011 byr:1921\n" +
            "\n" +
            "hgt:176cm cid:270 pid:838338992\n" +
            "eyr:2024 hcl:#866857\n" +
            "ecl:amb iyr:2015 byr:1982\n" +
            "\n" +
            "ecl:blu\n" +
            "cid:246 hgt:185cm\n" +
            "byr:1987\n" +
            "hcl:#fffffd pid:042361456 eyr:2022\n" +
            "iyr:2010\n" +
            "\n" +
            "hgt:164cm\n" +
            "pid:881486702 ecl:brn byr:1969 hcl:#c0946f\n" +
            "iyr:2010 eyr:2030\n" +
            "\n" +
            "iyr:2019 hcl:#6b5442 hgt:167cm\n" +
            "ecl:amb\n" +
            "cid:207 byr:1922\n" +
            "eyr:2025 pid:343956182\n" +
            "\n" +
            "ecl:oth iyr:2012\n" +
            "hgt:158cm\n" +
            "eyr:2024 hcl:#602927 byr:1964\n" +
            "\n" +
            "byr:1988 pid:030965463 hgt:154cm\n" +
            "ecl:gry eyr:2020 cid:227\n" +
            "iyr:2012\n" +
            "hcl:#3edc53\n" +
            "\n" +
            "hgt:178cm hcl:#c0946f byr:1945 ecl:amb eyr:2030\n" +
            "\n" +
            "hgt:158cm pid:270264980 eyr:2027 iyr:2016 byr:1928 cid:259\n" +
            "ecl:gry hcl:#733820\n" +
            "\n" +
            "byr:2026 hgt:164in cid:235 ecl:xry\n" +
            "hcl:z pid:2517730699\n" +
            "eyr:2033 iyr:2024\n" +
            "\n" +
            "ecl:grn hgt:69cm pid:1321222581 byr:1987\n" +
            "eyr:2035\n" +
            "iyr:2018 hcl:#fffffd\n" +
            "\n" +
            "hcl:#733820 cid:244\n" +
            "ecl:gry iyr:2013 eyr:2028\n" +
            "pid:794178180 hgt:74in byr:1923\n" +
            "\n" +
            "hcl:#a97842 byr:1934 ecl:hzl eyr:2027\n" +
            "pid:401882857\n" +
            "iyr:2018 hgt:185cm\n" +
            "\n" +
            "iyr:2018\n" +
            "pid:665564950 byr:1990 ecl:hzl\n" +
            "hgt:154cm\n" +
            "eyr:2026 hcl:#623a2f\n" +
            "\n" +
            "hcl:#602927 cid:189 byr:1967 pid:332861702 eyr:2021\n" +
            "hgt:163cm\n" +
            "ecl:amb\n" +
            "\n" +
            "ecl:grn pid:734161280 hgt:184cm\n" +
            "iyr:2018 eyr:2020 byr:1929 hcl:#a97842\n" +
            "\n" +
            "iyr:2018 byr:1925\n" +
            "eyr:2022 hgt:193cm ecl:hzl\n" +
            "hcl:#341e13\n" +
            "pid:008582320\n" +
            "\n" +
            "byr:2025 ecl:dne hgt:167cm pid:48963526\n" +
            "iyr:2025 hcl:z\n" +
            "eyr:2034\n" +
            "\n" +
            "hcl:#cfa07d ecl:hzl eyr:2029 cid:194 byr:1936\n" +
            "iyr:2020\n" +
            "hgt:186cm\n" +
            "pid:328573727\n" +
            "\n" +
            "iyr:2011 hgt:188cm pid:338435675 cid:326 ecl:gry\n" +
            "eyr:2027\n" +
            "hcl:#6b5442\n" +
            "byr:1958\n" +
            "\n" +
            "pid:165cm\n" +
            "hgt:70 iyr:1996\n" +
            "eyr:2034 cid:210 hcl:z ecl:#75606f byr:2027\n" +
            "\n" +
            "hgt:180in hcl:#a0515a pid:#97a753\n" +
            "byr:2026 iyr:2016\n" +
            "eyr:1995\n" +
            "\n" +
            "eyr:2020\n" +
            "hcl:#18171d byr:1978 iyr:2012 hgt:68in\n" +
            "ecl:amb cid:346 pid:332495922\n" +
            "\n" +
            "ecl:blu hgt:61in pid:747650669\n" +
            "byr:1961 eyr:2028\n" +
            "iyr:2020\n" +
            "hcl:#4992f2\n" +
            "\n" +
            "byr:1958 iyr:2017 ecl:oth\n" +
            "hgt:153cm\n" +
            "hcl:#602927 eyr:2023 pid:108391213\n" +
            "\n" +
            "byr:1976 eyr:2023 iyr:2015 hgt:177cm pid:391628371 hcl:#8069c4\n" +
            "ecl:grn\n" +
            "\n" +
            "pid:910402636 ecl:gry hgt:188cm byr:1924 hcl:#82dfdc eyr:2029\n" +
            "\n" +
            "byr:1978 pid:302223240 iyr:2017\n" +
            "hgt:174cm\n" +
            "hcl:#6b6569 ecl:blu eyr:2027\n" +
            "\n" +
            "cid:135\n" +
            "byr:1995 iyr:2015 ecl:oth pid:054611703\n" +
            "eyr:2023\n" +
            "hcl:#7d3b0c hgt:75in\n" +
            "\n" +
            "ecl:grn\n" +
            "eyr:2020 hgt:184cm pid:444944678 iyr:2019 hcl:#efcc98\n" +
            "\n" +
            "byr:1946\n" +
            "hgt:70in eyr:2022 hcl:#6b5442 ecl:amb iyr:2018 pid:859762925\n" +
            "\n" +
            "byr:1995 eyr:2022\n" +
            "ecl:grn pid:575081777\n" +
            "hcl:#341e13\n" +
            "hgt:183in iyr:2018\n" +
            "\n" +
            "eyr:2028 hgt:162cm byr:1989 hcl:#0bd11f\n" +
            "iyr:2020 ecl:gry\n" +
            "pid:073498924\n" +
            "\n" +
            "iyr:2014\n" +
            "pid:122787281 byr:1982 cid:138 eyr:2021 hcl:#866857 ecl:hzl hgt:184cm\n" +
            "\n" +
            "cid:198 byr:2014\n" +
            "pid:5529128129\n" +
            "hgt:185in\n" +
            "iyr:2025\n" +
            "hcl:z\n" +
            "eyr:2023\n" +
            "ecl:gmt\n" +
            "\n" +
            "eyr:2021 hgt:170cm\n" +
            "cid:74\n" +
            "iyr:2019 pid:943445928 byr:1980\n" +
            "ecl:oth hcl:#ceb3a1\n" +
            "\n" +
            "iyr:2020 eyr:2030 pid:201122734 cid:246 hgt:169cm ecl:grn hcl:#fffffd byr:1962\n" +
            "\n" +
            "pid:025560194\n" +
            "byr:1989\n" +
            "hcl:#cfa07d hgt:182cm ecl:blu eyr:2025 iyr:2012\n" +
            "\n" +
            "hgt:151cm\n" +
            "hcl:#efcc98 ecl:blu\n" +
            "byr:1983 eyr:2023 pid:814513328 iyr:2013 cid:73\n" +
            "\n" +
            "byr:1961 pid:536384108 hgt:188cm ecl:amb iyr:2013 eyr:2027 hcl:#888785 cid:121\n" +
            "\n" +
            "pid:364607819\n" +
            "eyr:2024 ecl:amb hcl:#b6652a iyr:2016\n" +
            "byr:2000 hgt:187cm\n" +
            "\n" +
            "hcl:z eyr:1956 iyr:2028\n" +
            "hgt:168cm cid:105\n" +
            "byr:2026\n" +
            "ecl:#5b17d3\n" +
            "\n" +
            "cid:207 pid:913509058 ecl:brn byr:2001 eyr:2026\n" +
            "hcl:#866857 iyr:2019\n" +
            "hgt:180cm\n" +
            "\n" +
            "pid:363979129\n" +
            "eyr:2027 iyr:2013\n" +
            "ecl:gry hcl:#866857 byr:1957 hgt:62in\n" +
            "\n" +
            "byr:1932\n" +
            "eyr:2027\n" +
            "hgt:66in ecl:hzl hcl:#efcc98 pid:417620217 iyr:2013\n" +
            "\n" +
            "iyr:2013 cid:331 hgt:192cm\n" +
            "hcl:#d896d9 pid:795744816 byr:1935\n" +
            "\n" +
            "byr:1960 hcl:#888785 hgt:176cm ecl:hzl pid:025206542\n" +
            "iyr:2015 eyr:2030\n" +
            "\n" +
            "ecl:oth hgt:182cm\n" +
            "hcl:#341e13\n" +
            "pid:526568190 iyr:2018 cid:280 byr:1997\n" +
            "eyr:2028\n" +
            "\n" +
            "hgt:186cm pid:273625601 byr:1993 iyr:2018 eyr:2021 hcl:#733820\n" +
            "ecl:blu\n" +
            "\n" +
            "hgt:74cm\n" +
            "byr:1981 eyr:2024\n" +
            "ecl:amb iyr:2012 pid:154027492 hcl:#733820\n" +
            "\n" +
            "hcl:#a97842 pid:347084450 ecl:oth\n" +
            "eyr:2030 hgt:176cm byr:1955 cid:229\n" +
            "iyr:2013\n" +
            "\n" +
            "hcl:#fffffd byr:1979 iyr:2017\n" +
            "pid:183840860 hgt:177cm ecl:blu eyr:2023\n" +
            "\n" +
            "pid:045246162 eyr:2021 byr:1928 hgt:190cm ecl:gry hcl:#602927\n" +
            "\n" +
            "pid:273620987\n" +
            "eyr:2022 hgt:162cm\n" +
            "cid:269\n" +
            "byr:1991 hcl:#602927 ecl:amb iyr:2019\n" +
            "\n" +
            "pid:621069556 ecl:amb\n" +
            "cid:202 byr:2020 hgt:189cm\n" +
            "iyr:2014 hcl:#fffffd\n" +
            "eyr:2027\n" +
            "\n" +
            "eyr:2022 byr:1988\n" +
            "hgt:190cm\n" +
            "pid:349839553 hcl:#602927 iyr:2018 ecl:gry\n" +
            "\n" +
            "iyr:2014 ecl:gry\n" +
            "hcl:#733820 eyr:2025 hgt:179cm pid:231854667 byr:1984\n" +
            "cid:102\n" +
            "\n" +
            "eyr:2020\n" +
            "pid:509400891 hcl:#cfa07d hgt:172cm\n" +
            "ecl:grn byr:1997 iyr:2020\n" +
            "\n" +
            "iyr:2017 byr:1994 hgt:174cm ecl:amb\n" +
            "pid:685743124\n" +
            "hcl:#fffffd eyr:2029\n" +
            "\n" +
            "iyr:2012 hgt:177cm byr:1999 pid:549190825 hcl:#b6652a eyr:2028 ecl:oth cid:316\n" +
            "\n" +
            "hgt:192cm ecl:grn byr:1924\n" +
            "iyr:2011 eyr:2029 hcl:#efcc98\n" +
            "pid:215962187\n" +
            "\n" +
            "iyr:2011 hcl:#866857\n" +
            "cid:164\n" +
            "hgt:184cm\n" +
            "ecl:gry eyr:2023 byr:1959 pid:204093118\n" +
            "\n" +
            "hgt:172cm ecl:hzl hcl:#3f2f3a pid:623470811 byr:1938 iyr:2013 eyr:2022\n" +
            "\n" +
            "hcl:#b6652a\n" +
            "iyr:2019 hgt:152in\n" +
            "ecl:oth\n" +
            "pid:189008850 byr:2006\n" +
            "\n" +
            "ecl:oth hcl:#602927\n" +
            "pid:049746898 byr:1924 hgt:150cm eyr:2026\n" +
            "iyr:2014\n" +
            "\n" +
            "ecl:oth\n" +
            "eyr:2028 byr:2018 hcl:#733820\n" +
            "pid:8676207205 iyr:2018\n" +
            "hgt:190cm\n" +
            "\n" +
            "eyr:2023 cid:308 hgt:170cm ecl:oth iyr:2014 hcl:#18171d pid:874405208 byr:1936\n" +
            "\n" +
            "eyr:2021 ecl:hzl\n" +
            "pid:423603306\n" +
            "hcl:#c0946f cid:147\n" +
            "byr:1988 iyr:2016 hgt:164cm\n" +
            "\n" +
            "hgt:176cm iyr:2010\n" +
            "hcl:#6b5442 cid:280 byr:1988 ecl:hzl pid:967151288 eyr:2028\n" +
            "\n" +
            "cid:299 hgt:163cm ecl:gry\n" +
            "pid:561439154 eyr:2023\n" +
            "hcl:#cfa07d iyr:2019 byr:1959\n" +
            "\n" +
            "pid:635547007\n" +
            "ecl:blu\n" +
            "byr:1996 hcl:#7d3b0c cid:280 eyr:2023\n" +
            "hgt:170cm iyr:2017\n" +
            "\n" +
            "hcl:#888785 iyr:2014\n" +
            "ecl:brn\n" +
            "hgt:190cm byr:1941 eyr:2021\n" +
            "\n" +
            "hcl:#c0946f cid:199 hgt:162cm ecl:amb pid:130696599 eyr:2022 iyr:2018 byr:1948\n" +
            "\n" +
            "cid:314 hcl:#a4fc09 ecl:hzl iyr:2019\n" +
            "pid:886849824 eyr:2026 byr:1933 hgt:178cm\n" +
            "\n" +
            "byr:1996 iyr:2016 eyr:2030 hgt:169cm\n" +
            "pid:119207760\n" +
            "hcl:#ef542c\n" +
            "ecl:brn\n" +
            "\n" +
            "iyr:2030 eyr:2039 hcl:#c0946f pid:#7336a0 hgt:182cm cid:347\n" +
            "ecl:#c81361 byr:2003\n" +
            "\n" +
            "pid:727812879 iyr:2013 eyr:2027 hgt:172cm\n" +
            "hcl:#7d3b0c ecl:gry byr:1966\n" +
            "\n" +
            "hcl:#341e13\n" +
            "iyr:2016 pid:744997238\n" +
            "cid:322\n" +
            "byr:1973\n" +
            "ecl:hzl eyr:2028 hgt:190cm\n" +
            "\n" +
            "hgt:171cm eyr:2026\n" +
            "iyr:2014 ecl:oth\n" +
            "pid:074049558 hcl:#04083f byr:1923\n" +
            "\n" +
            "pid:973713235\n" +
            "eyr:2021\n" +
            "ecl:brn\n" +
            "byr:1922 hcl:#fffffd iyr:2012\n" +
            "hgt:178cm\n" +
            "\n" +
            "ecl:#10165d\n" +
            "cid:201 eyr:2026 pid:#ceefa8 byr:2020\n" +
            "hgt:164cm iyr:2011\n" +
            "hcl:9fccf7\n" +
            "\n" +
            "ecl:blu\n" +
            "hgt:165cm iyr:2012 eyr:2025 pid:775787557\n" +
            "byr:1952 hcl:#623a2f\n" +
            "\n" +
            "pid:6186829005 ecl:lzr hcl:z hgt:69in iyr:2021 byr:2018 eyr:1974\n" +
            "\n" +
            "pid:824641755 eyr:2028 byr:1950 hgt:184cm\n" +
            "hcl:#c0946f\n" +
            "iyr:2014\n" +
            "\n" +
            "hcl:#7d3b0c cid:84 hgt:187cm iyr:2015\n" +
            "pid:895876610\n" +
            "byr:1988 eyr:2023\n" +
            "\n" +
            "hcl:#fffffd\n" +
            "hgt:157cm iyr:2020 eyr:2030 ecl:grn pid:486236241\n" +
            "\n" +
            "iyr:2010\n" +
            "eyr:2029\n" +
            "hgt:74in ecl:hzl byr:1926 pid:348573885 hcl:#9d1214\n" +
            "\n" +
            "hgt:171cm ecl:oth\n" +
            "eyr:2022 pid:148728436 byr:1993 hcl:#a97842 iyr:2013\n" +
            "\n" +
            "iyr:2019\n" +
            "hgt:151cm\n" +
            "eyr:2020 pid:319882814 ecl:grn byr:1966 cid:256 hcl:#3107b3\n" +
            "\n" +
            "hgt:184cm ecl:grn\n" +
            "byr:1947\n" +
            "eyr:2025 iyr:2015 pid:827962962 cid:62 hcl:#f3a364\n" +
            "\n" +
            "iyr:2013\n" +
            "hcl:#fffffd pid:215012801 ecl:amb eyr:2024\n" +
            "hgt:154cm\n" +
            "byr:1973\n" +
            "\n" +
            "ecl:hzl hgt:152cm\n" +
            "hcl:#623a2f\n" +
            "byr:1944 eyr:2022 pid:295632731\n" +
            "cid:243 iyr:2019\n" +
            "\n" +
            "ecl:brn\n" +
            "iyr:2011 pid:089250747 byr:1984 hcl:73e739 cid:253 hgt:161cm eyr:2021\n" +
            "\n" +
            "hcl:#18171d byr:1944 pid:732054667 eyr:2021\n" +
            "ecl:oth hgt:173cm\n" +
            "\n" +
            "ecl:gry pid:445116331\n" +
            "hcl:#a97842\n" +
            "hgt:187cm eyr:2026 iyr:2020 byr:1992\n" +
            "\n" +
            "hcl:80c091 pid:745555899\n" +
            "iyr:2021\n" +
            "hgt:170cm\n" +
            "byr:1990\n" +
            "\n" +
            "pid:058987865 byr:1927 cid:209\n" +
            "hcl:#65ccf6 eyr:2025\n" +
            "ecl:brn iyr:2012 hgt:164cm\n" +
            "\n" +
            "hgt:67cm\n" +
            "byr:2026 hcl:f8e749 iyr:2023 eyr:1921 ecl:lzr\n" +
            "\n" +
            "eyr:2028 iyr:2013 pid:103268377 hgt:179cm byr:1922\n" +
            "ecl:hzl\n" +
            "hcl:#7d3b0c\n" +
            "\n" +
            "byr:1923 ecl:gry hgt:167cm hcl:#7fc8ee iyr:2015 pid:427963077 eyr:2024\n" +
            "\n" +
            "byr:1927 ecl:grn pid:741328150\n" +
            "eyr:2029 hcl:#733820\n" +
            "iyr:2015 hgt:157cm\n" +
            "\n" +
            "hgt:70cm hcl:e76970 iyr:1945 cid:186\n" +
            "byr:1921 eyr:2029\n" +
            "pid:823622634\n" +
            "ecl:zzz\n" +
            "\n" +
            "hgt:61cm cid:87 hcl:d5e5ff\n" +
            "eyr:2024 ecl:dne pid:182634269\n" +
            "iyr:2029\n" +
            "\n" +
            "hcl:#623a2f eyr:2020 byr:1936 ecl:gry pid:236984204\n" +
            "iyr:2011 hgt:156cm\n" +
            "\n" +
            "pid:872645776\n" +
            "byr:2023\n" +
            "cid:220 ecl:blu hgt:172cm eyr:2033\n" +
            "iyr:2010 hcl:ff82f9\n" +
            "\n" +
            "pid:774489073 iyr:2013 byr:1922 ecl:brn eyr:2025 hcl:#18171d hgt:163cm\n" +
            "\n" +
            "eyr:2024 hgt:65in byr:1962 iyr:2019\n" +
            "pid:112233558 hcl:#888785 ecl:grn\n" +
            "\n" +
            "hgt:172cm eyr:2022\n" +
            "hcl:#18171d ecl:blu\n" +
            "pid:609008608 iyr:2013\n" +
            "cid:244 byr:1980\n" +
            "\n" +
            "cid:124 hgt:175in eyr:2025\n" +
            "hcl:674e80 pid:099875931 iyr:1956\n" +
            "\n" +
            "byr:1926 hgt:188cm\n" +
            "ecl:hzl eyr:2021\n" +
            "iyr:2018\n" +
            "hcl:#866857 pid:557800355\n" +
            "\n" +
            "byr:1939 pid:200409089\n" +
            "eyr:2026 hgt:164cm\n" +
            "ecl:grn iyr:2013\n" +
            "hcl:#733820\n" +
            "\n" +
            "cid:73 hgt:169cm iyr:2016 byr:1976 ecl:gry eyr:2024\n" +
            "pid:043453462\n" +
            "\n" +
            "pid:609818712 hcl:#733820 byr:1958\n" +
            "eyr:2025 hgt:187cm iyr:2017 ecl:gry\n" +
            "\n" +
            "hgt:66in pid:618590610 iyr:2013 byr:1938 hcl:#d1bda9\n" +
            "eyr:2022\n" +
            "ecl:grn cid:69\n" +
            "\n" +
            "hgt:156cm pid:755742405\n" +
            "byr:1929 hcl:#6b5442 eyr:2024\n" +
            "iyr:2018\n" +
            "ecl:gry\n" +
            "cid:105\n" +
            "\n" +
            "eyr:2030 pid:77022842\n" +
            "hgt:160cm byr:1989\n" +
            "iyr:2011 hcl:#7d3b0c ecl:blu\n" +
            "\n" +
            "iyr:2015\n" +
            "hcl:#341e13 byr:1968 pid:434159843\n" +
            "ecl:amb hgt:150cm\n" +
            "eyr:2030\n" +
            "\n" +
            "hcl:z eyr:1993 pid:#b3a5a6 iyr:1947 hgt:176in\n" +
            "ecl:#78876d\n" +
            "\n" +
            "cid:249 hcl:#cfa07d\n" +
            "hgt:180cm ecl:gry eyr:2026 byr:1965\n" +
            "pid:048327438 iyr:2010\n" +
            "\n" +
            "pid:136468890 ecl:gry\n" +
            "byr:1940\n" +
            "hcl:#fffffd hgt:185cm iyr:2016 eyr:2021\n" +
            "\n" +
            "hcl:#b6652a hgt:180in byr:1976 eyr:2022 pid:156cm ecl:#737836\n" +
            "iyr:2013\n" +
            "\n" +
            "ecl:amb iyr:2016 hgt:162cm byr:1955 pid:193cm eyr:2028 cid:346\n" +
            "hcl:#733820\n" +
            "\n" +
            "iyr:2010 byr:1932 eyr:2025 ecl:grn\n" +
            "pid:595837820\n" +
            "hcl:#341e13\n" +
            "hgt:166cm cid:224\n" +
            "\n" +
            "pid:481646831\n" +
            "eyr:2029\n" +
            "hcl:#623a2f cid:319 iyr:2016\n" +
            "ecl:brn hgt:160cm byr:1944\n" +
            "\n" +
            "ecl:zzz pid:428329840 cid:238 iyr:2022 hgt:76cm\n" +
            "hcl:#a97842\n" +
            "byr:2024 eyr:2028\n" +
            "\n" +
            "iyr:2014 hgt:170cm\n" +
            "byr:1963 hcl:#623a2f\n" +
            "eyr:2026 pid:225910806 ecl:gry\n" +
            "\n" +
            "ecl:grn iyr:2010 hgt:193cm byr:1928 eyr:2028 pid:343022641 hcl:#733820\n" +
            "\n" +
            "eyr:2023 ecl:grn\n" +
            "byr:1950 iyr:2012 hcl:#866857 pid:400725165\n" +
            "hgt:193cm\n" +
            "\n" +
            "cid:195 iyr:2014 ecl:oth eyr:2027 byr:1966\n" +
            "hgt:177cm hcl:#18171d pid:913894485\n" +
            "\n" +
            "iyr:2015 hgt:154cm\n" +
            "cid:206\n" +
            "pid:134599284 hcl:#602927\n" +
            "eyr:2023 ecl:brn\n" +
            "byr:1983\n" +
            "\n" +
            "ecl:#2d0e7a pid:#f34625 eyr:1942 iyr:2027 byr:2013 hcl:z hgt:162cm\n" +
            "\n" +
            "hgt:189cm byr:1965 iyr:2011\n" +
            "cid:178 ecl:hzl\n" +
            "hcl:#b6652a eyr:2026 pid:683560227\n" +
            "\n" +
            "eyr:2030 pid:047446524 ecl:grn hgt:167cm iyr:2017 hcl:#602927\n" +
            "byr:1920\n" +
            "\n" +
            "cid:86\n" +
            "iyr:1920 hgt:193cm\n" +
            "eyr:2027 pid:401913877 ecl:hzl\n" +
            "hcl:#888785 byr:1953\n" +
            "\n" +
            "byr:1991\n" +
            "ecl:grn\n" +
            "iyr:2016\n" +
            "hcl:#5e1ef2 hgt:186cm\n" +
            "pid:076499738\n" +
            "eyr:2025\n" +
            "\n" +
            "eyr:2030 hcl:#18171d pid:750694893\n" +
            "hgt:157cm iyr:2020 cid:338\n" +
            "byr:1956 ecl:gry\n" +
            "\n" +
            "iyr:2027 pid:#37f002 hgt:164cm ecl:#80df11\n" +
            "hcl:#aeacee cid:320\n" +
            "eyr:2039 byr:1956\n" +
            "\n" +
            "iyr:2014 hcl:#733820 ecl:grn\n" +
            "byr:1960\n" +
            "eyr:2025 pid:667089568\n" +
            "\n" +
            "hgt:163cm\n" +
            "byr:1962 cid:108 ecl:gry hcl:#733820 iyr:2012\n" +
            "eyr:2029 pid:763684725\n" +
            "\n" +
            "byr:1984 hcl:#888785 hgt:159cm iyr:2012 ecl:gry\n" +
            "eyr:2024 cid:236 pid:174711749\n" +
            "\n" +
            "ecl:gry pid:044931271\n" +
            "hcl:#b6652a eyr:2029 iyr:2013 byr:1985\n" +
            "\n" +
            "byr:1973 iyr:2018 hcl:#a97842 pid:937214113 ecl:blu\n" +
            "cid:247 hgt:186cm eyr:2023\n" +
            "\n" +
            "cid:108 pid:231782961 iyr:2017\n" +
            "eyr:2034 hgt:170cm byr:2025 hcl:#18171d ecl:utc\n" +
            "\n" +
            "pid:298274796 byr:1928 hcl:#a97842 hgt:188cm iyr:2011 ecl:gry eyr:2028\n" +
            "\n" +
            "hgt:65cm iyr:1943 eyr:2025\n" +
            "hcl:z\n" +
            "pid:65702335 ecl:#bb54e6 byr:2010\n" +
            "\n" +
            "pid:499116613 eyr:2024\n" +
            "ecl:gry hcl:#cfa07d hgt:193cm byr:1999\n" +
            "cid:278 iyr:2015\n" +
            "\n" +
            "hcl:#6b5442 eyr:2027 hgt:175cm byr:1988\n" +
            "ecl:brn pid:410075320 iyr:2010\n" +
            "\n" +
            "pid:269678991 ecl:oth iyr:2013\n" +
            "hcl:#602927 byr:1991 eyr:2023\n" +
            "\n" +
            "ecl:oth\n" +
            "pid:144593265 hcl:#fffffd\n" +
            "eyr:2020 iyr:2018\n" +
            "byr:1975 hgt:160cm\n" +
            "cid:304\n" +
            "\n" +
            "iyr:2014 hcl:#ceb3a1 eyr:2029\n" +
            "byr:1951 pid:520804395 hgt:185cm ecl:oth\n" +
            "\n" +
            "hgt:159cm\n" +
            "pid:312887994\n" +
            "cid:205\n" +
            "iyr:2016 ecl:hzl hcl:#866857 eyr:2029 byr:1944\n" +
            "\n" +
            "iyr:2023 ecl:#54c85c byr:2030\n" +
            "eyr:1946 cid:190 pid:512417622\n" +
            "\n" +
            "byr:1946 eyr:2023 hgt:163cm\n" +
            "hcl:#2d4e9c ecl:brn pid:839043333 iyr:2014\n" +
            "\n" +
            "iyr:2027 cid:122 hgt:187cm eyr:1975 ecl:grn byr:1920\n" +
            "hcl:#c0946f\n" +
            "\n" +
            "eyr:2029 hgt:189cm ecl:blu byr:1922 iyr:2016\n" +
            "pid:924104599\n" +
            "hcl:#b6652a\n" +
            "\n" +
            "hgt:162cm\n" +
            "iyr:2016 byr:1921 hcl:#18171d eyr:1938 ecl:hzl\n" +
            "pid:682222023\n" +
            "\n" +
            "cid:118 pid:959515596\n" +
            "byr:1921 iyr:2010 eyr:2029 hcl:#7d3b0c ecl:oth hgt:158cm\n" +
            "\n" +
            "ecl:#8ac844 pid:162cm\n" +
            "hcl:8f4d80 hgt:150in byr:2005\n" +
            "eyr:2008\n" +
            "iyr:2017 cid:174\n" +
            "\n" +
            "hcl:z byr:1936\n" +
            "pid:255481052 eyr:2021\n" +
            "iyr:2012 hgt:170cm cid:276 ecl:hzl\n" +
            "\n" +
            "iyr:2013 byr:1935 hgt:179cm\n" +
            "eyr:2023 ecl:amb pid:073621563 hcl:#623a2f\n" +
            "\n" +
            "hcl:#18171d cid:230 byr:1989 ecl:oth eyr:2021 hgt:181cm pid:661224730\n" +
            "iyr:2019\n" +
            "\n" +
            "pid:748039140 iyr:2020 eyr:2020 ecl:#6ebbc2 hcl:#fffffd hgt:171cm\n" +
            "byr:1995\n" +
            "\n" +
            "ecl:hzl pid:758144605 hcl:#ceb3a1 hgt:186cm\n" +
            "eyr:2028 iyr:2014\n" +
            "byr:1928\n" +
            "\n" +
            "ecl:hzl\n" +
            "hgt:66in\n" +
            "byr:2000 iyr:2017 eyr:2020\n" +
            "pid:162973694 hcl:#a97842\n" +
            "\n" +
            "iyr:2012 pid:749770535\n" +
            "byr:1969 cid:148\n" +
            "hcl:#733820\n" +
            "hgt:180cm eyr:2021 ecl:hzl\n" +
            "\n" +
            "iyr:2010\n" +
            "byr:1958\n" +
            "hgt:164cm\n" +
            "ecl:blu hcl:#733820 pid:890634327 eyr:2024\n" +
            "\n" +
            "hgt:70in pid:218397894\n" +
            "iyr:2020 eyr:2025 ecl:gry hcl:#341e13\n" +
            "byr:1970\n" +
            "\n" +
            "eyr:2020 pid:854208004 hgt:157cm hcl:#7d3b0c ecl:amb byr:1981 iyr:2020\n" +
            "\n" +
            "byr:1924\n" +
            "cid:321 eyr:2028 hcl:#cfa07d iyr:2010 ecl:amb pid:036669613 hgt:170cm\n" +
            "\n" +
            "ecl:#6649d4 pid:0026989865 cid:188\n" +
            "hgt:152in\n" +
            "byr:1950 hcl:z eyr:1928 iyr:1963\n" +
            "\n" +
            "hcl:#ceb3a1 ecl:grn eyr:2028 pid:074363489 iyr:2010 hgt:173cm byr:1966\n" +
            "\n" +
            "eyr:2030\n" +
            "pid:9731612333 ecl:#f8824c\n" +
            "iyr:2022 hgt:161in\n" +
            "byr:2023\n" +
            "cid:316\n" +
            "hcl:z\n" +
            "\n" +
            "hgt:175cm iyr:2016 eyr:2024 cid:244\n" +
            "byr:1952\n" +
            "pid:085432899\n" +
            "hcl:#fffffd ecl:brn\n" +
            "\n" +
            "ecl:brn eyr:2026 iyr:2017 hgt:75in\n" +
            "pid:745302991 byr:1969 hcl:#7394c7\n";

    public static void main(String[] args) {
        part1();
        part2();
    }


    private static void part1() {
        String[][] passports = getPassports();

        int validPassports = 0;
        for (String[] passport : passports) {
            if (passport.length < 7) {
                continue;
            }

            if (passport.length == 8) {
                validPassports++;
                continue;
            }

            validPassports++;
            for (String line : passport) {
                if (line.contains("cid")) {
                    validPassports--;
                    break;
                }
            }
        }
        System.out.println(validPassports);
    }

    private static void part2() {
        String[][] passports = getPassports();

        int validPassports = 0;

        for (String[] passport : passports) {
            if (passport.length < 7) {
                continue;
            }

            if (passport.length == 7 && Arrays.stream(passport).anyMatch(s -> s.contains("cid"))) {
                continue;
            }

            if (validateFields(passport)) {
                validPassports++;
            }
        }

        System.out.println(validPassports);
    }

    private static boolean validateFields(String[] passport) {
        for (String keyValue : passport) {
            if (!validateField(keyValue)) {
                return false;
            }
        }
        return true;
    }

    private static boolean validateField(String keyValue) {
        String[] kv = keyValue.split(":");
        String key = kv[0];
        String value = kv[1];
        try {
            switch (key) {
                case "byr" -> {
                    int intValue = Integer.parseInt(value);
                    return intValue >= 1920 && intValue <= 2002;
                }
                case "iyr" -> {
                    int intValue = Integer.parseInt(value);
                    return intValue >= 2010 && intValue <= 2020;
                }
                case "eyr" -> {
                    int intValue = Integer.parseInt(value);
                    return intValue >= 2020 && intValue <= 2030;
                }
                case "hgt" -> {
                    String[] values = value.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
                    int intValue = Integer.parseInt(values[0]);
                    String unit = values[1];

                    if (!(unit.equals("cm") || unit.equals("in"))) {
                        return false;
                    }

                    if (unit.equals("cm")) {
                        return intValue >= 150 && intValue <= 193;
                    } else {
                        return intValue >= 59 && intValue <= 76;
                    }
                }
                case "hcl" -> {
                    if (value.charAt(0) != '#') {
                        return false;
                    }

                    return value.substring(1).matches("^[0-9a-f]{6}$");
                }

                case "ecl" -> {
                    List<String> allowedValues = Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth");

                    return allowedValues.contains(value);
                }

                case "pid" -> {
                    return value.matches("^\\d{9}$");
                }
                default -> {
                    return true;
                }
            }
        } catch (Exception ex) {
            return false;
        }
    }

    private static String[][] getPassports() {
        String[] t = s.split("\n\n");
        String[][] passports = new String[t.length][8];

        for (int i = 0; i < t.length; i++) {
            t[i] = t[i].replace("\n", " ");
            passports[i] = t[i].split(" ");
        }
        return passports;
    }
}
