package nl.jiankai.year2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day8 {
    public static void main(String[] args) {
//        part1();
        part2();
    }

    static void part1() {
        List<String> after = input.stream().map(s -> s.substring(s.indexOf("|") + 2)).collect(Collectors.toList());

        System.out.println(after);

        int count = 0;

        for (String s : after) {
            String[] words = s.split(" ");
            for (String word : words) {
                if (word.length() == 2 || word.length() == 4 || word.length() == 3 || word.length() == 7) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static void part2() {
        int sum = 0;
        for (int i = 0; i < input.size(); i++) {
            StringBuilder digits = new StringBuilder();
            String[] line = input.get(i).split(" \\| ");
            String[] words = line[0].split(" ");
            String[] output = line[1].split(" ");

            List<String> unknowns = new ArrayList<>();
            String[] numbers = new String[10];

            for (String word : words) {
                char[] c = word.toCharArray();
                Arrays.sort(c);
                String w = new String(c);
                if (word.length() == 2) {
                    numbers[1] = w;
                } else if (word.length() == 4) {
                    numbers[4] = w;
                } else if (word.length() == 3) {
                    numbers[7] = w;
                } else if (word.length() == 7) {
                    numbers[8] = w;
                } else {
                    unknowns.add(w);
                }
            }

            char[] t = numbers[1].toCharArray();

            String nonMatchingOneAndFour = numbers[4];
            for (char c : t) {
                nonMatchingOneAndFour = nonMatchingOneAndFour.replace(Character.toString(c), "");
            }
            for (String unknown : unknowns) {
                if (unknown.length() == 5) {
                    if (containsAll(unknown, nonMatchingOneAndFour.toCharArray())) {
                        numbers[5] = unknown;
                    } else if (containsAll(unknown, numbers[1].toCharArray())) {
                        numbers[3] = unknown;
                    } else {
                        numbers[2] = unknown;
                    }
                } else if (unknown.length() == 6) {
                    if (containsAll(unknown, numbers[4].toCharArray())) {
                        numbers[9] = unknown;
                    } else if (containsAll(unknown, numbers[1].toCharArray())) {
                        numbers[0] = unknown;
                    } else {
                        numbers[6] = unknown;
                    }
                }
            }

            for (String s : output) {
                char[] c = s.toCharArray();
                Arrays.sort(c);
                String w = new String(c);

                for (int j = 0; j < words.length; j++) {
                    if (w.equals(numbers[j])) {
                        digits.append(j);
                    }
                }
            }
            sum += Integer.parseInt(digits.toString());
        }
        System.out.println(sum);
    }

    private static boolean containsAll(String word, char[] keywords) {
        boolean containsAll = true;
        for (char keyword : keywords) {
            if (word.indexOf(keyword) == -1) {
                containsAll = false;
                break;
            }
        }

        return containsAll;
    }

    static List<String> input = Arrays.asList(("bg gcdaeb aebg efabdcg abdce cafdbe fcbdeg bdacg gbd cafgd | daecb dcbae gb eabg\n" +
            "eabfdc fgd cegd aedgf fbacgd dceaf dg aebdcgf efbag edgfac | cgebadf dgce deafc acdbfg\n" +
            "dcgfb fe bcgefd adecfb fgdec dfe egadc fadgceb facbgd befg | fdacgb fbcdg dcefbg bcdfg\n" +
            "gebdcf eg ecgabd gabed agdfb dbace fgbacde facebd egd gcea | agdbe gde deg agcebd\n" +
            "efb fgeacbd efcdb adfe fcdabg cabfd dcebg deafcb cgbfae ef | bgcde adcgbf feb adfe\n" +
            "gfdcaeb cdgfa agefc cge cgadfb fegdbc ecda eagbf gdfcae ec | dfbecg degcaf gafcd cge\n" +
            "eacbdg gdfb dfcbge cgd egcdf gd bfedc aedcfb fcgea bdafceg | gd gcbefd begadcf gcd\n" +
            "gafced dcge ec gafcbde efgca agefb defabc eac cafdg dagbfc | fegba edcbagf efacg eca\n" +
            "ebfdc dbfae cbfgd agbecd ced ec dcefbga ecfg fgbdac fbedcg | ce ce cgadfb ecd\n" +
            "dgbfe gcbdaf cbegfa gfcda gadfce gbafedc ecg ce cgdfe aecd | efbcgda fbaegc cdae dcae\n" +
            "fca gcbfed ecadfbg fbgcda gfbdc cfadb afcbeg fa baced fagd | afc fdcbge af badcfg\n" +
            "fdegc defgacb acged gf deacfg cfg fbaecg abcgde dfag befcd | fgc egfdc cdaebg ebgcad\n" +
            "afgdbce ebfcd dfbecg bafged bg bcged egcda fabcde bdg fbgc | dbg gbd dgfeab fdebc\n" +
            "ecdbfa cage cdaegf dfgea cadbfge dbagfc ea dbfge efa cfdga | ea afe fgcad dgfcab\n" +
            "dafge cebf cgebd ecbgadf gbf bf debgf cdgfbe dbgcae gdacbf | defag edbcg becf bgf\n" +
            "gdb egfabc dbcfeg fagd gd abcde gdabfe fabge fcabedg debga | gfda bdg gaebf gbd\n" +
            "cbdfg fbcdgea ebdc bc cgb egfdb facgd egdfcb fbgade facbeg | gcfbd dbce dcbe fbdceg\n" +
            "fg afg agedcb fbdgeac gbfca eacgfd fceab cgabd bfdgac bgdf | bgdf afebgcd dbgafc bdfg\n" +
            "fbagced cegfd feabc dfbacg bg eagb bcaefd abegfc gfb ebfcg | gfb gb gbf gdfce\n" +
            "dfceba bdcaf decab ea bae acebdfg egabfd bdgec cbadgf efac | dcbeg bdceafg ae abcfd\n" +
            "gbfeac deagc geafc efgb agfcdeb dbacgf ecbfa cfg fg edbcaf | cgeda fegb aebfc gf\n" +
            "acgbfed cabdef gfbcde abced ca dbafgc adc fcedb feca aebdg | gecfdb caefdb baedcf cgeabfd\n" +
            "ed bdge dceagb gafceb dce cgaed bdgecfa gabec fdagc aedbfc | acdeg dce dcbega dfgca\n" +
            "ecgdb cbefdg fgbc cfegad cf fce fadeb bdgeac agecfbd fdcbe | fc bgdace cfe edfacg\n" +
            "ed fdbgc cfeab adbgfc adgebf ebdcf fgedbc gecd def dcgaebf | dfagbc bagdcf gdce ed\n" +
            "bgdfa gefbcd fdceab fe fabde edf caebd acfe deagbc dcbfeag | fe fbgedc abecdg fdebac\n" +
            "bafgde cfgba dcbag fcbgae dafc fdgebac da bdcagf gad cgdbe | dfca ad dga fcbgdea\n" +
            "abecgd agbec bcfegd gfacbde ca bafced fabeg acb cgbed agdc | gdceb cfdbage afbdgce begac\n" +
            "cfb gdafb dfcgba facbde cdefabg egdcf gfcbd cb agbc febgda | cb efbacd agbc cb\n" +
            "bdce dgaec dcefga dcaegb fbgae dba db afdbcg fceagbd gdabe | eagbdcf bd febgacd cebd\n" +
            "bad fgeab bd agfdce fcadeb agdec edbfgca dcbg bcegda edgba | dbfeac bfecda bfgecda dbgc\n" +
            "egcbfad gdfec faced ecdgfb decfga fac fa fdag cfbgae baced | gcfaed aedcfg fadg fa\n" +
            "ebfdc gadcfb fcgdea ace abcde ea gecdabf gdcba gbae dacbeg | bfdgac gadcb acbgd ae\n" +
            "gcafe abfged egfadbc fbdec dg gdebfc gfedc dbcg fcbead gde | gdbc faegc gde deagbfc\n" +
            "decabg gdcfa dfbca cgdefab bdegfa afcdeb bdcea bdf bf becf | aebdfc efbc dfegab bf\n" +
            "cdfegb gcdaf fa bfdacge egfa daf gdbac degcf adfecg ebcfda | cedgbaf fdgec afd gadcf\n" +
            "gd bcfde adegfc cegbfd gdc dgbe bdgcf gfaebcd cabfg edacfb | daecgf agbcf caebfd cbedaf\n" +
            "decbf ebcfg egcaf gfaecb gbf gaeb cadegf ecgfabd agdbfc gb | fgb dfcgae cfbge abfgce\n" +
            "bgfed cedgf cegabf gfc fc eagbdc caegd fcad dbaecgf dfceag | fcda efdbg fedgb bfaedcg\n" +
            "dcafbg aebdc fgdcb efc fgedca fe gbfe fdbagec cfebd cebdgf | gbef gfcbd cef ef\n" +
            "fabdgc cbd db cfgda cfabd eacgdf dagb abefdgc fbeac gdfcbe | bfdca ebdagfc dcb bdag\n" +
            "bgdface geabdc edabg aeb agec ea fcagbd acdfbe acdbg bdegf | cbedgaf bgcaed ea abfedc\n" +
            "abfeg fedbag fbegc dcgfbae fbgcd ec abefcg eafdcg fec aebc | gabef ec geabf fcgdb\n" +
            "gdcbef edfbg cg cafgbd gedc gcefb acfegdb eacbf dbfgea gcb | cgb bfdge gefbc agbfdc\n" +
            "gecbfad fdga debagc da bcdgaf abcfd abcfg bad dfebc aefbcg | cbfga dbcaf cfbda fgad\n" +
            "cbegdf cdga bfaecg egdfc dfaceg fbedagc dgeaf ga gfa efbda | gcdaef agf fga efdag\n" +
            "abd dcaf ad cbgefd abcge ecdbfag cbedf fgbade adebc acdebf | bagec dcfa ad dbaec\n" +
            "efcdb cedgaf edfcab dgecb dgbf egd baegc dg efdgbc gbefcda | afcdeb dg cfbdge gcbed\n" +
            "bgdfca bgf bfgac gdfc cedabg gabedf fdbagec cebfa gbdac fg | facbg cfagb abcgd edagbc\n" +
            "ebagdcf ecgbfa bgadf bdfac cfb cbdgfa ceadb cf dgcf fabdeg | cdfab eagfdb gdfeba fc\n" +
            "gbc bc fegac cfgeda gfcba acbe bcegfd abfgd dgaefcb ecbgfa | edfbgc ecab cbfag efagdbc\n" +
            "de gacfeb fabce ecgbdf adbef cbgdeaf aced dfe bfadg fcabde | gbdefca daefb cgedfb cead\n" +
            "dbf edbfa bedcgfa begafc fdega db cadb facebd fcaeb fdcgbe | bcgfea cbefda fabce cabfe\n" +
            "fcb cegbdf fgdeb fcdeb cfdae cgdb cfgabe bc agcbfde aebfdg | gcdb fcb bdefg edfbg\n" +
            "gfead fgdcbe egdfacb gacd cdf ecgfda edacf adbgfe dc ebcfa | agdc fdc geacbfd fagdbe\n" +
            "gcfabe cefag dafg agecd ad decbg fcedgba cedafg cda ebcfda | aebcfd bfdeagc afecg cgbedaf\n" +
            "gcefdb aecbfgd fdegb ga fgcbda eagf aedgb dceba befdga gad | edagfb gad fgae ebgad\n" +
            "abdfge gfcea bcdg decabf gadbf cafgd dc cdf cdabgf dfceagb | gfdca bcagdf eagdbf dfc\n" +
            "ab dfagbe efbacd fba acfdeg efgad eabdgfc bfgea egcbf adgb | dafgbe gbafe ab dagbcef\n" +
            "febgd gbf bf cdebga gdebc bfcedg befc agcedfb cbgafd agfed | bf degaf gcdeb fbg\n" +
            "cegdfa db cafegdb decga gbd aedb gecfb bdcgfa cdagbe becdg | agbdefc cadbefg fgbce db\n" +
            "gcdfabe fcabg gafdc fbagec bf agbce gbf dcebga feab gcfdbe | cegba fb bdcgefa bgf\n" +
            "bfc cedafb bacfg gedcba acdbg dcfbega gdfb acfge bf adbgcf | fb fcb bf dfcbea\n" +
            "bdgca fca edfbac gcdf fc cbgeda afbgc afebg fbdgac gfeadbc | bfcdga adbfce gbedca cf\n" +
            "cf abdfce fabdg bcdgfa fgcb caebdfg cgdfa ecadg cdf gbedaf | fc acdfbg gcbf cfd\n" +
            "dcbea dfgcbe dbefag dcbaf cgfa fa cbgdf bfa begcfda adgfcb | fba abf edcbfg gcbdef\n" +
            "gd fgbacd geda dfecb cdg ceagb ecgdb dceafbg afcgeb cdebga | dacfbge efacgb eadg gdcbe\n" +
            "dfbcae fe bfcgea cefg fgeab fgdab dgecab fdgeabc eagbc aef | ef fbdcaeg aefcbg efa\n" +
            "fdcgb cdeabf gdafcb efcg bfagced fe gfebcd gdbfe feb bgeda | fcgbd fe bdegf gefc\n" +
            "cdgaeb gfeabdc dbfg bdc gcadbf fdbac db gcabf cgeafb eafcd | decfa bdfg bfadcg bd\n" +
            "fdgea ab eafb dafcge cdbaefg eadbgf edacbg fbdgc gfbad gba | ba ab ab gdbfae\n" +
            "bacdfe defab fbeg egfad dfbagce fg febgda gfdbca fga gdaec | dgbfac dcgae bedfa bfeg\n" +
            "feadb cbd fgbedac bdceag bcaf aefcdb cb decbf edgcf bfdeag | fabged egdcf fbgdace bfedca\n" +
            "cdafe agfedbc gebc aeb fegdba cabgfe cfbea dabcfg eb cbgfa | gacbdf egfbcad cadfe gcbe\n" +
            "deg dbecg abdce agcfebd dg defgcb fagecb febgda fcdg ebfgc | debfcg egcbafd cfadbeg cgdf\n" +
            "cebfad efc dbcfg gfdcbe cfdgba agfed ec becg dfgec gedbfac | bgfdc fce gfedc gbfadc\n" +
            "eabdcf bfcgd gabdfe bacfe bde eadc cbdagfe ebcfd ed afegcb | cdea fcgeba cbfgd bafdeg\n" +
            "gcdab bdafge dc aefcdg acbgfd bdfc cdg eagbc gdeacbf fgadb | dfbc gaedfbc bcfd bdcf\n" +
            "efdca gced dbagefc afdeg feagbd fce ce dcabf adcegf efcabg | gfebac ecafd adbegfc abfdc\n" +
            "bfadcg cgfda bc fbcegd fbac ebagd cagbd egcafbd cbd dfgaec | dbeag cb adgcb abdgfc\n" +
            "dgbef gbacf bcde cd degafc dbefag fcd gcdbf bedcfga cebfgd | cd bdcgf ebdc bagcf\n" +
            "gc fegdac dgefa cefab bcafdeg decg fcg dafbcg fegbda ecgfa | ceagf cg gfeca cgf\n" +
            "fbage cfdaegb dcfgb dbae gefacd de cbagef gfbed deg ebgdfa | fgdace fegcba ed dge\n" +
            "geb ebfacg gbeca gcbedf eafb egadc fbcag cfadbg fbecgad eb | fcgab baef bdagcf gfebac\n" +
            "egbcaf fcgab gaebdf bf dcfeabg befc aebgc bgf adcgf bgdaec | gbface dcbage fgb abcge\n" +
            "bgcdae fdab becadf fa beacd fae gebfc fdeagc acfeb ecabfgd | cfbea fdaebgc afe gfdeca\n" +
            "gefc bgadf dcebfa ef gcaebd dcbafeg cgdbef dbcge efd fgbed | acbfde gcbde dbecg fe\n" +
            "cadefb degbc degfb dc dfcabeg ced cabeg cbefga adgcbe agdc | efdbac acgd agebdc ecd\n" +
            "fcgbea gdfceb eadcb gdef gdbcafe fdc fdbec febgc bcgfda fd | cfd dfcegab dcbfga fd\n" +
            "gabdec dgfcea dagbe gf dgf cabgfed bagf befcd bfdage fbdge | gfcabed bfdge fagb abecdgf\n" +
            "abc gdcea cgbfad egcfabd eafb gfceb cfaebg fbdegc gecba ba | cab ab efcdbg efcgadb\n" +
            "bafdcg gdbaef cf abfc dceag fcg fadgb ebfgdac fdcga ecdgbf | gedfbc gadce adcge fcg\n" +
            "afb fadce dafcb ab degfbc abdcefg gabdcf fagbde bdfgc abgc | dfacbeg ebdagf afb acfdb\n" +
            "cfaedb dce edgcbaf bgdfc dcefb ce cbea fdgaec aebfd fgadeb | ced acgdef dfeagbc ce\n" +
            "egfcdb cdfgbea cgafb efgd gcdbae ecdabf bcdge df bfd fcdbg | cdebg df bfd dfebcg\n" +
            "gbecdfa ce ebacd dgafbc bec dfabc baedg bgacfe efdc fdbeca | cfdba ecb ec bgecfa\n" +
            "cadfbe bfgdeac gdeab ebfcg degfb dfag edf degabf gcebad fd | fgbed abcfde becgf begdf\n" +
            "fgd egdbf fgbce gcbaed dabeg dafe fd cagbefd bgedaf abfcdg | fadbgc df dfea adebfg\n" +
            "fdb gcadbfe fd acbde gdcf cfgbe gfbcde bdfec gabcfe ebagdf | dgfebc dgcf bfgec fcbgdea\n" +
            "dgcbf daegfcb ec cfae dbcega cge gbaecf fgbce fagedb befag | fcgbae cbgedaf bcfega fcae\n" +
            "cbadge eg dbecgf edbgf dcabef gecf fgbad ebg edbcf adcbfge | egb eafdbc geb bdfga\n" +
            "afebg gfcaeb bgfdce cfea af bgade fba bcefg edfgcab cadgbf | ebcfg cfageb gdbae egabd\n" +
            "agfdc fegb badfg fbcdgea dfbaec gdeab eafdgb abf bf cdaegb | gadbe cbdfae gdafeb gdabef\n" +
            "cgdeba gadcbf gebca ad afegbdc acgbfe gcade fegcd dac bdea | ebgcad becgda cad dac\n" +
            "becafdg gd cdg cgebfd efbcg cbaed febgac becdg bdfg ecfgda | cbgfe gd adcbe efdcagb\n" +
            "efcb aebgfd aecdfgb gdcaf bfa bf aecfgb cadebg gbfac ceabg | bcfe fb bf fcbe\n" +
            "bgaf bgedcfa ecdbfa cgfea gea baefc ag cgdfe gdcaeb ecfbga | gea ebcaf gfecd ega\n" +
            "adfegb degcb dgb bg adgfceb cdeagf acged gdecab abcg cfdbe | gedac gfbdace becgd ebgacd\n" +
            "af fgcdba bgecf bcfage dgcfeba cfa ebfa cegfbd fecag edgca | bgfaced fa fa cbgef\n" +
            "egbfcda deacb gfdacb fdcabe bgedc ae fade afbcd gfcaeb bae | ea bcaedfg gcaefb deaf\n" +
            "feagd becafg ebca eb geb cdafgb feabg faegcbd cebgdf bcagf | afcbeg afgcb facbgd fgdea\n" +
            "cdbfea efagd bafegc deb dgaecb dbgae db ecagdbf dbgc ecabg | gdaeb bdcg aegdcb agefd\n" +
            "abe cdbgafe cabef befgc fbadce ba facgde adfce bacged badf | abcedg adefc bfad bfda\n" +
            "beafc efdabc fbdgae dcaegbf beadc adcgb ecabfg decf de dea | egbdfa fedc febca fcabe\n" +
            "bd dbeg dcbfeg cgfad dfbgc ebcgf bgecaf cfadeb fbd abfdgce | deagcfb gfdca fbgec decbfg\n" +
            "febadgc df gecfa cebad fdeac fad gadebf dbfc eacdgb cfeadb | bafdcge afcdgeb cdgaebf fda\n" +
            "cgedabf debfga gfe fg gfba gacfed dfbeg bdfea dbcefa bdgec | dceagfb ebdfa dbfeg fadeb\n" +
            "egafcb cg ceg ebgcfad dacbef afedg gcbdea bcfae cefag gbcf | gdfea egc ecgaf fdgbcea\n" +
            "egfba adecfb gc cfg cfdbeg gdac eafgcd dfcea cgefa bfaecgd | gc aecdbf cgf dcbegf\n" +
            "abcfde eafbd dagfebc bgea aefdg dga dgbfac faebgd edcfg ga | eabg eabcgfd abeg deacbfg\n" +
            "ac fbgeda begcfa decgf gfcbad eagcbdf gbaef eabc gac egcaf | eafdgbc fgabdc agc cagfe\n" +
            "abdfg gefba ecafb eg egf febcdag egac beagfc edgcfb acbdfe | bcafed gfe eg febdgc\n" +
            "fgcba bge efgcab bfgae adbecg fcge defgcba bedfa abgcfd eg | ge abdef badef gfcdeab\n" +
            "gdecbf fcbdae acedf acfb cdbae cgdeba fc gafed fgacdbe ecf | bacf bdaecg cebad cfgdbea\n" +
            "abfcde fa afd degba cdgbeaf bafed eadcgf cbaf bdcfe cedbgf | dgbae bfedc fcba aedgbfc\n" +
            "egfadc ec ecbf abgcd gfdbae eac abedf fegacdb bcedfa cdbae | ce cdbga ceabd beagdf\n" +
            "bdcae bfc fb bfcdeg ebacgd aecfgdb bfdcea acdfg cbadf baef | cfbdae fbc abgedc fcb\n" +
            "bf afged adbegc ebfc gbadfce bdf fbcdeg bdcge efgdb fbadgc | cfeb ebcfgad febgcda fbd\n" +
            "fbeda dfega bf becda fba dfcb cagbed abfdec cfagbe aebdcfg | bdcf eacbd abdecg ebafdc\n" +
            "baecfd dg gbdc edagb bdaec ebgaf bcefadg dge eagcbd acgfde | deg dg deg bdacef\n" +
            "degabf gdbef cedg bgfcd dfacegb dcb dbgfec fcagb cedabf dc | gecd bdc gbedf acbfg\n" +
            "efdag ce cabe bcfdga egcad gcbad bdagce cde cdfebga dfgecb | agdec cde dagce cgade\n" +
            "adbgc bgecd ebdgcf dgafbce abcefg gefdab ec edcf dgfbe ebc | geabdfc edagbf efdc ec\n" +
            "deagf bdcf dgc fbegcd deabcfg cd edfgc aebgcd fecgab efcgb | gcefbd fbdc edcfbg efgbc\n" +
            "fbgedc bacged egbacf cbf gaecb fc fdcbeag ecaf cbgaf agdbf | cfagb bgacf eacbgd fgbca\n" +
            "abdeg gdcea bdfega fgadb eb bgfe aecdfb facbdg gdebfca abe | aeb efacdgb eba be\n" +
            "fcdgab cbgfa gc gfdc bcg fageb cbfgdea cgaebd fcdab dceafb | fcabg gc cfdg bcadfe\n" +
            "dfgcb ebgadc efb ecgba becfg feagbd cgebaf ceaf cgfbdea fe | fe bfe bef fcbgd\n" +
            "fabde cbdg gcbae fegbac acfgde edgab bedgacf deg cdbega gd | dcgb cgfeda eafdb egd\n" +
            "gfac bcaegf cf fcb ebcda edcbgaf dgfbce agfeb geafdb cabfe | ecadb fc ebadgf efcba\n" +
            "fbgcad bfcae cf afbeg dcfe cbf cbgaed ceadb bcedaf fabcged | adfegbc fbc ceabd fc\n" +
            "dabf dacbg fgabc db cgdafeb eacbgf cgfdba bgd dgcae gdfceb | bacegf cbgfed bd bd\n" +
            "dfec dgcabe cf bfdca fgadbce bfceag edabc fcb fdabg bcfeda | fbc bdfga efdc cbefag\n" +
            "edcbga fcagb gb dagcef fgeb egcfa dfbagec agb gcfeab dcfba | bcdefag ceagbfd efbg fecga\n" +
            "eacdgf cb ebc afgecb dbeaf cbfea ebfcdga edfgcb egafc acgb | efbad cebaf deafb aedbf\n" +
            "gedba fegdbc dgf deafg gceadf afcdeb gfca fg eadfc dbcfgea | gdacfbe gf faecbd egfad\n" +
            "fe gef adebgc fcde eadgc gfcaed bfcga gafce bdgcfea fbgeda | dabfge cefd afdgce feg\n" +
            "gafd feadbc cfbage ceabdgf edgcb acgbf ad fbadgc acdgb adb | ecbafd cdabg abd bad\n" +
            "gea defga egdc dafbg fbadec fbcega aedcf ge cgafde cabdfge | ge fdceag efcad cdbfea\n" +
            "gecdbfa bgdfca cdbfa ecdfba dgfca cbag ga ebdagf fdgec gaf | fgcdeab bcedaf gbca cgab\n" +
            "defcgb edcfg gcadf fac dgfcae bgafec cfagebd aced ac afdgb | afdcg dgfce fcegbad ac\n" +
            "eab cfdega ab bfgaec gbdfeca gdeca dfecb abgedc ebacd badg | gcafbed ecdagf bcfgade ba\n" +
            "cbd acdfbg bgefda cb fgedbc acfb bafdegc dgafb dbacg gaedc | bc baefgd gbdefa cb\n" +
            "edc gfead edgbfa efbca dc dcgbafe dcgf aecfd gafdce bdcgea | bfeca fbaec bfaec fdaec\n" +
            "dagef efgcbad gcbd ebagfc db eafcbd efcgb deb bedfg cfedgb | cgadbef bd dgacbfe befgd\n" +
            "gcefbad cebgaf efcgb bdge bdafc cdfgea de dfe bfdgec cebfd | dfecb de fdebc fde\n" +
            "fe aef cgbea dbfcga dfagce cbafed cebagdf cgeaf afcdg efgd | fadbce fe aegdcf ef\n" +
            "adbgf dcbfae cebgdaf bf gafde gdcba cdaegb fab gcbf dbcafg | adbgf gbedacf afb gcbaefd\n" +
            "cfagb geb dagbcf edbfa egdfacb efgba fcbeag eadcbg gecf eg | ge cfeg bafde afdbe\n" +
            "ge bfedca adgbf dfceb dfgaec egfbd gfcdbe fcgedba gebc ged | fcbde cgdafeb cdfaebg eg\n" +
            "cdebaf cgdefb fdbcega bdaf fgecad afc af abefc acgeb bcfde | abfd fbad fdecb geabc\n" +
            "edfga dcagb afgcbd facb dbegcf fb bgf gfcbdae gabfd cegadb | fbdcga fbdga fb gfb\n" +
            "dcegba dfb adbec cdbafe df fcbeg dbfce dfabcg edfa cbedafg | fd efgcb cbafed dagceb\n" +
            "afcbe cfa agbef bfgacd cf cgef cbgeafd aefbgc gefbad abcde | gfcabde afc fca fabgde\n" +
            "bacdge dfbc bc ecgfdab edgbcf cgafde gbaef cgefb ecb edfcg | bgdcef bgedafc cdaebgf cbfd\n" +
            "egdc cbdgfa def dcafe de dcgaf abefc dbaegf fdgcea ebgacfd | edgc gbcedaf fgcaed geadcfb\n" +
            "dbac bfdge cgb bcgde cb gbfdcea acfebg bdcgea adecfg edgca | dgeac feabcg aegcd gcb\n" +
            "dcbeg dcgef acdfg efabgcd dfaceb efgb fbcdge aegbcd ef efd | dfbcge bgef gcdef cfdag\n" +
            "dfgb gfc afcde egbcd cfgde cdbegf agbecf gf bcdeag fgdebca | becgd gf edgabc dfcabge\n" +
            "cd bdaefg cabfed cdgfbae bgceda eadbg egdc cabgd bcd fagbc | dbgac fedacb edbfacg dgce\n" +
            "acde faegd dfa bgeaf efacgd fbagcd da bcaefdg ecdgf febdgc | dfegc dgbcef adf cedfag\n" +
            "fag cbafe ecbfag gcbdf edfcba cgea bagefd agdcefb ag bagcf | fcabg ebagcf gdcfb egfbda\n" +
            "badf fgdbace gfced fdcea efacbd ade bcfeag ad cabef dacgbe | afbd edgcf fabd fagebc\n" +
            "ac cfdabge bgac gfade fdbgc dac dbcfge dgcfa dcgfba fbdcae | cbagdf geadf dbcagf adc\n" +
            "dcgba dc gadfeb fcdg baedcf aegbc dbacgf eagbfdc bdc gbdaf | abgcd cbd gbfad gbcea\n" +
            "bfagec fcbeg ce dfagcb bfcade ebc dfegb acgdbfe gcae agcbf | gcae afdgbec bfagc ebagfcd\n" +
            "bgacf gfdabc abgcef fdab cdbag decbg geadcf ebfacdg ad cad | bcaefg cgbdaf bgcaefd agbcf\n" +
            "fbadeg gbe dgcbea gb bcgd bdecgaf agecb cegda cefadg bacef | aedgc cgdb aegcd agdcef\n" +
            "gbecdf aefg eg gec bcefa gcbad egcba cefbad fecgab badfecg | ge afbec edfcba agcfdbe\n" +
            "fbga cedbf ba ebagdf baegdfc aeb bagced gfcdea bfead afged | gdafce ba eba efcdgab\n" +
            "beafdc bca defac ab edfcga edcbg cabed bacgdfe gbadcf eabf | cfdage cafbde efcbda cdgeaf\n" +
            "efg agfcde abgfd efbc cdebg febgd ef cdgbae fegbdc befgcad | ef efbc dfgba fge\n" +
            "acgfb eabgc cfdab fg afg gcef gfdbea becfag beafdcg gebcda | fgec gefc agbefc cgfdeba\n" +
            "adfeg cgdfeab feba fgeabd dgabe egbcfd aebgdc def cgdaf ef | febgda adfgc bgdcea gadfe\n" +
            "cgabf bcg bfgd edbcgaf acegf adbefc ebadcg bg cdbfa cbfdga | eadcbf deagfbc fcage dfbgac\n" +
            "dge ceabdg fdbce cedgb acfdgb cbdagfe gdabc gabe fdaceg ge | eg gde cdebf abecdg\n" +
            "cdage eagcf ade gebcaf faecgd gcbed abdfeg cdaf ad degbcfa | bdgec aegcd adcgbfe feacbg\n" +
            "debg gec dbfegca ge acdeb acgfd abegfc bcadge eadgc efdacb | cfdbae ge cgabef dgafc\n" +
            "gcfabe ed adcgf febac bgdfea dfaec deafcb acfbegd dcbe ade | fcgda dea fcdag de\n" +
            "bdfecg adgbefc dfbeg dabecf agefd gdba ad dfa faecg beadfg | cgfabed abdg cfdgbae adefbc\n" +
            "cdbge cbaegd cde afcdbg cbadegf efgadc agdcb fgcbe ed daeb | ecd ecd dcgeab dbcge\n" +
            "ebcg fbgae fbaec cefbgda ecf bdfac efbadg gfceda cfbage ec | cfdage ec caebgf cgeb\n" +
            "cgfbead fed fgecda dfeagb ecfg efcda cfbda fe dcbgae edacg | fedac efd ceadg cgdae\n" +
            "dgbae acbfedg acbe ceagd gacebd dgbefc cadfg ecg fdbaeg ec | dgfbae ec fedbcag abec\n" +
            "ecbgadf ab afbe fgcba fgcead bgfaec cgafe dgabec dfcgb abg | bafe bfea cgbdea ba\n" +
            "cf dfbce dfc befda abdefcg gaebdc dfacbg cefg gbdec fgbedc | cdf cabgdf cfdabg bgecd\n" +
            "gbadef bcfd gabedfc bd cbfag fegbac gcdab gafbdc dgeac bgd | db dbaegf gaebfd cgaed\n" +
            "ebgafc ecg agfcd ecab dbfgea eagcbfd edcbgf bgaef ce acegf | egbfa bcgfaed abec ce\n" +
            "acdfbg afgdb ea bea ebgda agecfbd bcgde cfgeab aefd defgba | agbed ae fgbaed defa\n" +
            "gcebadf ed bafce bgcfad daefb bfadg aefbgd fgcdeb daeg ebd | cdgfba ecbfdg edbaf gade").split("\n"));
}
