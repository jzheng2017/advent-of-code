package nl.jiankai.year2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Day7 {
    public static void main(String[] args) {
        part1();
        part2();
    }

    private static void part1() {
        Directory filesystem = constructFilesystem();
        List<Integer> answer = new ArrayList<>();
        filesystem.evaluateDirectorySize(answer);
        System.out.println(answer.stream().mapToInt(Integer::intValue).sum());
    }

    private static void part2() {
        Directory filesystem = constructFilesystem();
        List<Integer> answer = new ArrayList<>();
        int totalUsedSpace = filesystem.evaluateDirectorySize(answer);
        int remainingSpace = 70000000 - totalUsedSpace;
        int spaceNeeded = 30000000;
        int spaceThatHasToBeFreed = spaceNeeded - remainingSpace;
        answer.stream().filter(size -> size >= spaceThatHasToBeFreed).sorted().findFirst().ifPresent(System.out::println);
    }

    private static Directory constructFilesystem() {
        Directory parent = new Directory(null, "");
        Directory currentWorkingDirectory = parent;
        for (String statement : input) {
            if (statement.startsWith("$ cd /") || statement.startsWith("$ ls")) {
            } else if (statement.startsWith("$ cd ..")) {
                currentWorkingDirectory = currentWorkingDirectory.parent;
            } else if (statement.startsWith("$ cd")) {
                String[] split = statement.split(" ");
                Optional<Directory> directory = currentWorkingDirectory.directories.stream().filter(dir -> dir.directoryName.equals(split[2])).findFirst();
                if (directory.isPresent()) {
                    currentWorkingDirectory = directory.get();
                } else {
                    currentWorkingDirectory = new Directory(currentWorkingDirectory, split[2]);
                }
            } else if (statement.startsWith("dir ")) {
                String[] split = statement.split(" ");
                currentWorkingDirectory.addDirectory(new Directory(currentWorkingDirectory, split[1]));
            } else {
                String[] split = statement.split(" ");
                currentWorkingDirectory.addFile(new Directory.File(Integer.parseInt(split[0]), split[1]));
            }
        }

        return parent;
    }

    private static List<String> input = Arrays.asList(("$ cd /\n" +
            "$ ls\n" +
            "dir blrnnv\n" +
            "dir ctfjwl\n" +
            "dir dqf\n" +
            "135993 dqqbcfr\n" +
            "dir ftj\n" +
            "125510 fzjdz\n" +
            "dir jvtlfbzr\n" +
            "31762 lsvw.lwr\n" +
            "dir qfstpm\n" +
            "dir sbprmc\n" +
            "dir svbnljr\n" +
            "dir tchbjclg\n" +
            "dir wtm\n" +
            "dir ztrz\n" +
            "$ cd blrnnv\n" +
            "$ ls\n" +
            "169869 mjjj.wnq\n" +
            "$ cd ..\n" +
            "$ cd ctfjwl\n" +
            "$ ls\n" +
            "209537 zzdpcnmt.qbf\n" +
            "$ cd ..\n" +
            "$ cd dqf\n" +
            "$ ls\n" +
            "205200 hnbqlmmg\n" +
            "80316 lmw.zmd\n" +
            "dir mwj\n" +
            "122312 tsrwvqbg.tzh\n" +
            "$ cd mwj\n" +
            "$ ls\n" +
            "18195 bddslhrg.twf\n" +
            "122813 qfccg.crl\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd ftj\n" +
            "$ ls\n" +
            "dir clchr\n" +
            "dir hmd\n" +
            "40232 vtzlv\n" +
            "$ cd clchr\n" +
            "$ ls\n" +
            "dir sbzf\n" +
            "$ cd sbzf\n" +
            "$ ls\n" +
            "257770 thwhz.pgp\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd hmd\n" +
            "$ ls\n" +
            "62643 bddslhrg.qzl\n" +
            "dir lfpm\n" +
            "277745 sgddpc\n" +
            "117478 vjchlsrc.cmh\n" +
            "7911 zzdpcnmt.qbf\n" +
            "$ cd lfpm\n" +
            "$ ls\n" +
            "107158 bddslhrg\n" +
            "253844 fzjdz.mlw\n" +
            "217005 glzsnz.cvs\n" +
            "71371 qfccg.crl\n" +
            "193163 sdmmmds.nwt\n" +
            "dir vlnbm\n" +
            "$ cd vlnbm\n" +
            "$ ls\n" +
            "143113 lwhtsvg.bjm\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd jvtlfbzr\n" +
            "$ ls\n" +
            "dir gwz\n" +
            "dir hfftvmw\n" +
            "dir jlftgw\n" +
            "dir nnpvwtvt\n" +
            "98713 wtbzpqvb\n" +
            "$ cd gwz\n" +
            "$ ls\n" +
            "161853 blfnwqtm.vhw\n" +
            "180524 fbqpql.bbw\n" +
            "dir jvrdcf\n" +
            "dir ldcmtwvt\n" +
            "dir pjm\n" +
            "dir qjj\n" +
            "$ cd jvrdcf\n" +
            "$ ls\n" +
            "42681 bddslhrg\n" +
            "dir cbcq\n" +
            "dir fzjdz\n" +
            "dir ghwnd\n" +
            "dir gpbhtj\n" +
            "dir hsmlb\n" +
            "dir mjjj\n" +
            "129934 sdmmmds.nwt\n" +
            "dir wdvqhn\n" +
            "196970 zzdpcnmt.qbf\n" +
            "$ cd cbcq\n" +
            "$ ls\n" +
            "dir hsw\n" +
            "262458 lbhzblh.zfn\n" +
            "dir qbpvrr\n" +
            "205708 sdmmmds.nwt\n" +
            "263842 tqcgmwbj.bcn\n" +
            "4847 vjchlsrc.cmh\n" +
            "72550 wnmpdtrr.zrc\n" +
            "$ cd hsw\n" +
            "$ ls\n" +
            "dir rdvfwbw\n" +
            "$ cd rdvfwbw\n" +
            "$ ls\n" +
            "dir fthdrqnr\n" +
            "$ cd fthdrqnr\n" +
            "$ ls\n" +
            "31974 htnpjdr.wsl\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd qbpvrr\n" +
            "$ ls\n" +
            "198987 nnhpdvv.vvn\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd fzjdz\n" +
            "$ ls\n" +
            "149832 ldb.qnt\n" +
            "183866 nbnzfplj.lrs\n" +
            "$ cd ..\n" +
            "$ cd ghwnd\n" +
            "$ ls\n" +
            "177598 ggchv.tsv\n" +
            "163367 mjjj\n" +
            "13258 pdcf.flm\n" +
            "$ cd ..\n" +
            "$ cd gpbhtj\n" +
            "$ ls\n" +
            "dir cvm\n" +
            "160598 fcng.sbf\n" +
            "272547 ndnlzb\n" +
            "285657 pvs.ldf\n" +
            "166261 sdmmmds.nwt\n" +
            "207433 zzdpcnmt.qbf\n" +
            "$ cd cvm\n" +
            "$ ls\n" +
            "246462 fpwvfs.gpb\n" +
            "133303 vjchlsrc.cmh\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd hsmlb\n" +
            "$ ls\n" +
            "252425 tqcgmwbj.bcn\n" +
            "$ cd ..\n" +
            "$ cd mjjj\n" +
            "$ ls\n" +
            "96351 fvgj\n" +
            "272667 qfccg.crl\n" +
            "196309 ssv.ljs\n" +
            "$ cd ..\n" +
            "$ cd wdvqhn\n" +
            "$ ls\n" +
            "190200 sdmmmds.nwt\n" +
            "dir tjgfcs\n" +
            "214364 tqcgmwbj.bcn\n" +
            "174218 wqpmmgtd\n" +
            "$ cd tjgfcs\n" +
            "$ ls\n" +
            "dir gngb\n" +
            "268455 hqctmf.cdg\n" +
            "242060 prbwvv\n" +
            "$ cd gngb\n" +
            "$ ls\n" +
            "102313 fhqgpb.cqc\n" +
            "77189 mjjj.cdw\n" +
            "163701 sdmmmds.nwt\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd ldcmtwvt\n" +
            "$ ls\n" +
            "dir bqmbrr\n" +
            "dir cfcfnspz\n" +
            "dir fzjdz\n" +
            "dir gvd\n" +
            "dir mpqtgd\n" +
            "9560 mqfdcz.wqt\n" +
            "75810 shps\n" +
            "249000 tqcgmwbj.bcn\n" +
            "139099 zdv.zgz\n" +
            "dir zpct\n" +
            "$ cd bqmbrr\n" +
            "$ ls\n" +
            "175893 hwrdtwsv.brd\n" +
            "$ cd ..\n" +
            "$ cd cfcfnspz\n" +
            "$ ls\n" +
            "dir gmzsn\n" +
            "dir gvrfbt\n" +
            "105314 mjjj\n" +
            "181873 vjchlsrc.cmh\n" +
            "$ cd gmzsn\n" +
            "$ ls\n" +
            "dir bddslhrg\n" +
            "$ cd bddslhrg\n" +
            "$ ls\n" +
            "dir cspptmpm\n" +
            "258841 fzjdz.bfs\n" +
            "dir npmh\n" +
            "72584 qfccg.crl\n" +
            "$ cd cspptmpm\n" +
            "$ ls\n" +
            "239223 fzjdz\n" +
            "11003 sdmmmds.nwt\n" +
            "73589 tqcgmwbj.bcn\n" +
            "251204 vdz.jcd\n" +
            "$ cd ..\n" +
            "$ cd npmh\n" +
            "$ ls\n" +
            "186878 bddslhrg\n" +
            "264830 bddslhrg.gdq\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd gvrfbt\n" +
            "$ ls\n" +
            "200067 zcvjj\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd fzjdz\n" +
            "$ ls\n" +
            "dir bddslhrg\n" +
            "dir fvqszrj\n" +
            "dir gqcdtjzj\n" +
            "dir pcfr\n" +
            "250120 pqqbpmr\n" +
            "dir qbpvrr\n" +
            "$ cd bddslhrg\n" +
            "$ ls\n" +
            "72852 sjn\n" +
            "$ cd ..\n" +
            "$ cd fvqszrj\n" +
            "$ ls\n" +
            "dir mmzcqr\n" +
            "24439 tqcgmwbj.bcn\n" +
            "dir vhpqjr\n" +
            "$ cd mmzcqr\n" +
            "$ ls\n" +
            "dir gzfqggrr\n" +
            "$ cd gzfqggrr\n" +
            "$ ls\n" +
            "162528 frdgcr.gnb\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd vhpqjr\n" +
            "$ ls\n" +
            "194144 mjjj\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd gqcdtjzj\n" +
            "$ ls\n" +
            "231917 pftb\n" +
            "174091 vbzfgtwp\n" +
            "$ cd ..\n" +
            "$ cd pcfr\n" +
            "$ ls\n" +
            "dir dtbws\n" +
            "76624 qfccg.crl\n" +
            "dir qjqjd\n" +
            "dir qjsldd\n" +
            "$ cd dtbws\n" +
            "$ ls\n" +
            "dir vwjnsbjm\n" +
            "$ cd vwjnsbjm\n" +
            "$ ls\n" +
            "56502 mjjj.jqj\n" +
            "130426 qfglmz\n" +
            "23199 vjchlsrc.cmh\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd qjqjd\n" +
            "$ ls\n" +
            "71015 qfccg.crl\n" +
            "40443 vjchlsrc.cmh\n" +
            "$ cd ..\n" +
            "$ cd qjsldd\n" +
            "$ ls\n" +
            "261945 fzjdz.vcw\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd qbpvrr\n" +
            "$ ls\n" +
            "138915 fvh.sdp\n" +
            "dir mdvqv\n" +
            "168843 qbpvrr\n" +
            "90599 tchbjclg\n" +
            "226671 vjchlsrc.cmh\n" +
            "$ cd mdvqv\n" +
            "$ ls\n" +
            "159050 bddslhrg\n" +
            "2691 fzjdz\n" +
            "245322 psr\n" +
            "7732 zhnbgcc.lsc\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd gvd\n" +
            "$ ls\n" +
            "84112 bhnt.gjg\n" +
            "18231 gzrgd.vvj\n" +
            "dir ntvmrrd\n" +
            "234773 rcfbjzj\n" +
            "281805 sdmmmds.nwt\n" +
            "267837 zzdpcnmt.qbf\n" +
            "$ cd ntvmrrd\n" +
            "$ ls\n" +
            "46209 lwvvwd.rtg\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd mpqtgd\n" +
            "$ ls\n" +
            "99833 qbpvrr\n" +
            "$ cd ..\n" +
            "$ cd zpct\n" +
            "$ ls\n" +
            "dir bddslhrg\n" +
            "272296 znffshsg.jrt\n" +
            "$ cd bddslhrg\n" +
            "$ ls\n" +
            "81585 vjchlsrc.cmh\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd pjm\n" +
            "$ ls\n" +
            "147674 rbctzb\n" +
            "$ cd ..\n" +
            "$ cd qjj\n" +
            "$ ls\n" +
            "21770 wtht.fpd\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd hfftvmw\n" +
            "$ ls\n" +
            "dir bhvzrsv\n" +
            "130208 cclgndpd\n" +
            "dir fzjdz\n" +
            "39285 jtmcp.pjv\n" +
            "dir mbgvdmpp\n" +
            "dir tchbjclg\n" +
            "202920 vjchlsrc.cmh\n" +
            "$ cd bhvzrsv\n" +
            "$ ls\n" +
            "167049 bts\n" +
            "dir mjjj\n" +
            "257434 qsrpmshg\n" +
            "279724 sdmmmds.nwt\n" +
            "149934 snpb.zwq\n" +
            "254808 tqcgmwbj.bcn\n" +
            "dir wgf\n" +
            "$ cd mjjj\n" +
            "$ ls\n" +
            "dir mrlvp\n" +
            "$ cd mrlvp\n" +
            "$ ls\n" +
            "197237 pmwjbf.lmn\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd wgf\n" +
            "$ ls\n" +
            "77157 zzdpcnmt.qbf\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd fzjdz\n" +
            "$ ls\n" +
            "77499 mjjj.pdq\n" +
            "dir shrpdcg\n" +
            "180282 zzdpcnmt.qbf\n" +
            "$ cd shrpdcg\n" +
            "$ ls\n" +
            "22528 bddslhrg\n" +
            "191369 mjjj.llb\n" +
            "35213 sdmmmds.nwt\n" +
            "131772 spfmhdpf.wtr\n" +
            "284434 tpzg.qjg\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd mbgvdmpp\n" +
            "$ ls\n" +
            "220250 fsdzqhc.ljm\n" +
            "101355 vnrcwb\n" +
            "$ cd ..\n" +
            "$ cd tchbjclg\n" +
            "$ ls\n" +
            "113952 gjbp.qgs\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd jlftgw\n" +
            "$ ls\n" +
            "dir bddslhrg\n" +
            "210047 cdbch\n" +
            "dir dvrb\n" +
            "266336 fhvwlg\n" +
            "139851 qfccg.crl\n" +
            "dir rcqhb\n" +
            "176510 vjchlsrc.cmh\n" +
            "dir wfrjg\n" +
            "$ cd bddslhrg\n" +
            "$ ls\n" +
            "78175 zzdpcnmt.qbf\n" +
            "$ cd ..\n" +
            "$ cd dvrb\n" +
            "$ ls\n" +
            "216103 fzjdz.blg\n" +
            "$ cd ..\n" +
            "$ cd rcqhb\n" +
            "$ ls\n" +
            "39727 cgfjm.dpt\n" +
            "dir pwb\n" +
            "$ cd pwb\n" +
            "$ ls\n" +
            "39040 sdmmmds.nwt\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd wfrjg\n" +
            "$ ls\n" +
            "206877 zzdpcnmt.qbf\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd nnpvwtvt\n" +
            "$ ls\n" +
            "264455 czrjz\n" +
            "dir nfdv\n" +
            "dir nmcp\n" +
            "113232 pffgw.hbv\n" +
            "dir qrzlrt\n" +
            "$ cd nfdv\n" +
            "$ ls\n" +
            "dir fpldng\n" +
            "dir jhj\n" +
            "56720 ltv\n" +
            "170870 rgvs.ggh\n" +
            "$ cd fpldng\n" +
            "$ ls\n" +
            "157283 vzv.qrq\n" +
            "$ cd ..\n" +
            "$ cd jhj\n" +
            "$ ls\n" +
            "172487 qpfh.lpr\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd nmcp\n" +
            "$ ls\n" +
            "273633 zzdpcnmt.qbf\n" +
            "$ cd ..\n" +
            "$ cd qrzlrt\n" +
            "$ ls\n" +
            "111080 bddslhrg\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd qfstpm\n" +
            "$ ls\n" +
            "92950 hjr.zjn\n" +
            "252254 sdmmmds.nwt\n" +
            "$ cd ..\n" +
            "$ cd sbprmc\n" +
            "$ ls\n" +
            "dir bddslhrg\n" +
            "158704 bgnt.vbd\n" +
            "dir cddp\n" +
            "dir cpf\n" +
            "dir hfns\n" +
            "276655 phcccdq\n" +
            "dir qbpvrr\n" +
            "dir srjpcj\n" +
            "55405 vhb.mbj\n" +
            "$ cd bddslhrg\n" +
            "$ ls\n" +
            "238260 mjjj\n" +
            "$ cd ..\n" +
            "$ cd cddp\n" +
            "$ ls\n" +
            "87685 fzjdz.sbz\n" +
            "$ cd ..\n" +
            "$ cd cpf\n" +
            "$ ls\n" +
            "dir tchbjclg\n" +
            "$ cd tchbjclg\n" +
            "$ ls\n" +
            "dir wjcvfvz\n" +
            "$ cd wjcvfvz\n" +
            "$ ls\n" +
            "280711 svmf.czw\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd hfns\n" +
            "$ ls\n" +
            "dir bbjnrhf\n" +
            "dir cvjtpc\n" +
            "101075 ddbml.vff\n" +
            "dir gdlqtlv\n" +
            "157960 mswfp.wcj\n" +
            "187182 qddfchn.dpg\n" +
            "59533 rfjvzcq\n" +
            "47332 wszmlq.nbt\n" +
            "$ cd bbjnrhf\n" +
            "$ ls\n" +
            "269590 dgmjpzcz\n" +
            "dir mjjj\n" +
            "84955 mjjj.jqn\n" +
            "dir mwqvvsnt\n" +
            "dir qbpvrr\n" +
            "dir qtdmwqcj\n" +
            "131930 tqcgmwbj.bcn\n" +
            "dir vvwb\n" +
            "$ cd mjjj\n" +
            "$ ls\n" +
            "dir hvvh\n" +
            "$ cd hvvh\n" +
            "$ ls\n" +
            "235980 vmmvp.sbh\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd mwqvvsnt\n" +
            "$ ls\n" +
            "242698 mjjj.qbm\n" +
            "15137 rncwrgjl.jfr\n" +
            "158528 sdmmmds.nwt\n" +
            "$ cd ..\n" +
            "$ cd qbpvrr\n" +
            "$ ls\n" +
            "dir gpc\n" +
            "$ cd gpc\n" +
            "$ ls\n" +
            "184310 lqfgplfg\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd qtdmwqcj\n" +
            "$ ls\n" +
            "30238 cfpng.fnl\n" +
            "284340 gst\n" +
            "dir lvcjcglg\n" +
            "82263 twmnlqcq\n" +
            "78023 zzdpcnmt.qbf\n" +
            "$ cd lvcjcglg\n" +
            "$ ls\n" +
            "225027 lsdrg.wqv\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd vvwb\n" +
            "$ ls\n" +
            "184590 trg.vmc\n" +
            "156231 zzdpcnmt.qbf\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd cvjtpc\n" +
            "$ ls\n" +
            "dir whqnlc\n" +
            "$ cd whqnlc\n" +
            "$ ls\n" +
            "66362 jnsprdt.vrs\n" +
            "dir tchbjclg\n" +
            "dir zhw\n" +
            "$ cd tchbjclg\n" +
            "$ ls\n" +
            "227846 vqjtc.pld\n" +
            "$ cd ..\n" +
            "$ cd zhw\n" +
            "$ ls\n" +
            "dir bgwcrp\n" +
            "$ cd bgwcrp\n" +
            "$ ls\n" +
            "114175 dftv\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd gdlqtlv\n" +
            "$ ls\n" +
            "121215 gbltpcv.prz\n" +
            "41387 tqcgmwbj.bcn\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd qbpvrr\n" +
            "$ ls\n" +
            "79921 tqcgmwbj.bcn\n" +
            "263185 vjchlsrc.cmh\n" +
            "$ cd ..\n" +
            "$ cd srjpcj\n" +
            "$ ls\n" +
            "106650 fzjdz.tdf\n" +
            "135245 qfccg.crl\n" +
            "97014 tvlmvqm\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd svbnljr\n" +
            "$ ls\n" +
            "286919 lwvw.zlr\n" +
            "$ cd ..\n" +
            "$ cd tchbjclg\n" +
            "$ ls\n" +
            "dir bljmjwm\n" +
            "dir hsjww\n" +
            "dir ptfsh\n" +
            "dir qbpvrr\n" +
            "147832 qfccg.crl\n" +
            "$ cd bljmjwm\n" +
            "$ ls\n" +
            "dir cqtmhzbf\n" +
            "dir mfpcdbg\n" +
            "dir qlzg\n" +
            "dir qtdh\n" +
            "dir tbdff\n" +
            "dir tchbjclg\n" +
            "211603 zhr.gwl\n" +
            "$ cd cqtmhzbf\n" +
            "$ ls\n" +
            "dir mmbgqlm\n" +
            "150758 tqcgmwbj.bcn\n" +
            "dir ztcbmbw\n" +
            "$ cd mmbgqlm\n" +
            "$ ls\n" +
            "93439 bddslhrg.gnm\n" +
            "25644 qbpvrr.jhm\n" +
            "$ cd ..\n" +
            "$ cd ztcbmbw\n" +
            "$ ls\n" +
            "dir cmwwg\n" +
            "dir stgmndfd\n" +
            "$ cd cmwwg\n" +
            "$ ls\n" +
            "239158 bfl.pwl\n" +
            "dir dbvnwz\n" +
            "17700 pqtpmpp\n" +
            "dir tchbjclg\n" +
            "$ cd dbvnwz\n" +
            "$ ls\n" +
            "217821 bzgsbc.zzp\n" +
            "$ cd ..\n" +
            "$ cd tchbjclg\n" +
            "$ ls\n" +
            "dir tpdtglwp\n" +
            "52714 vjchlsrc.cmh\n" +
            "111040 zzdpcnmt.qbf\n" +
            "$ cd tpdtglwp\n" +
            "$ ls\n" +
            "287567 jmddscd\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd stgmndfd\n" +
            "$ ls\n" +
            "38426 bll.pww\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd mfpcdbg\n" +
            "$ ls\n" +
            "dir trjgzcj\n" +
            "$ cd trjgzcj\n" +
            "$ ls\n" +
            "dir hngr\n" +
            "268655 lgrwtch\n" +
            "258843 pbpnjf.tmg\n" +
            "100112 qbh\n" +
            "72784 qbpvrr.cpg\n" +
            "dir vbmqtf\n" +
            "197735 vjchlsrc.cmh\n" +
            "$ cd hngr\n" +
            "$ ls\n" +
            "82873 cwbmqp.llb\n" +
            "261780 hsgwfv.pfn\n" +
            "42859 ljt\n" +
            "dir tchbjclg\n" +
            "$ cd tchbjclg\n" +
            "$ ls\n" +
            "dir fhsgvttf\n" +
            "253131 gtghn\n" +
            "dir nzpcvjhp\n" +
            "dir tpqrqtqj\n" +
            "$ cd fhsgvttf\n" +
            "$ ls\n" +
            "56727 mjjj.vzf\n" +
            "$ cd ..\n" +
            "$ cd nzpcvjhp\n" +
            "$ ls\n" +
            "dir bddslhrg\n" +
            "dir blhrls\n" +
            "$ cd bddslhrg\n" +
            "$ ls\n" +
            "242433 vpvpqtqb.dfr\n" +
            "$ cd ..\n" +
            "$ cd blhrls\n" +
            "$ ls\n" +
            "110313 fzjdz.qtf\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd tpqrqtqj\n" +
            "$ ls\n" +
            "dir dfjmpvj\n" +
            "114636 gmqqrtv\n" +
            "dir mjjj\n" +
            "175067 wggfznff\n" +
            "$ cd dfjmpvj\n" +
            "$ ls\n" +
            "174485 sjzg\n" +
            "$ cd ..\n" +
            "$ cd mjjj\n" +
            "$ ls\n" +
            "111397 pslm.fjf\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd vbmqtf\n" +
            "$ ls\n" +
            "151429 tchbjclg.tzm\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd qlzg\n" +
            "$ ls\n" +
            "127640 bddslhrg.wbj\n" +
            "dir fzjdz\n" +
            "dir ghllcw\n" +
            "62733 qfccg.crl\n" +
            "96986 qwgh\n" +
            "268380 vjchlsrc.cmh\n" +
            "$ cd fzjdz\n" +
            "$ ls\n" +
            "153535 gcjss\n" +
            "$ cd ..\n" +
            "$ cd ghllcw\n" +
            "$ ls\n" +
            "dir fzjdz\n" +
            "dir hwfm\n" +
            "2536 jglh.njg\n" +
            "dir mjjj\n" +
            "dir mlhwcg\n" +
            "200842 qfccg.crl\n" +
            "dir tchbjclg\n" +
            "246542 tqcgmwbj.bcn\n" +
            "dir tqtsl\n" +
            "dir vpn\n" +
            "$ cd fzjdz\n" +
            "$ ls\n" +
            "124920 jzsbrwj\n" +
            "dir wtvfgcrq\n" +
            "$ cd wtvfgcrq\n" +
            "$ ls\n" +
            "dir ltnzjbl\n" +
            "187917 mjjj.svp\n" +
            "dir nvgrzrbr\n" +
            "dir pngcwl\n" +
            "$ cd ltnzjbl\n" +
            "$ ls\n" +
            "151460 jmc.zjf\n" +
            "252590 tchbjclg\n" +
            "$ cd ..\n" +
            "$ cd nvgrzrbr\n" +
            "$ ls\n" +
            "193994 qbpvrr.tsv\n" +
            "152776 tchbjclg.swm\n" +
            "243770 vqzs.hjp\n" +
            "$ cd ..\n" +
            "$ cd pngcwl\n" +
            "$ ls\n" +
            "74603 bddslhrg\n" +
            "288915 vjchlsrc.cmh\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd hwfm\n" +
            "$ ls\n" +
            "dir qbpvrr\n" +
            "92630 vjchlsrc.cmh\n" +
            "$ cd qbpvrr\n" +
            "$ ls\n" +
            "dir vlwbhgnv\n" +
            "$ cd vlwbhgnv\n" +
            "$ ls\n" +
            "5248 tchbjclg\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd mjjj\n" +
            "$ ls\n" +
            "255751 qfccg.crl\n" +
            "$ cd ..\n" +
            "$ cd mlhwcg\n" +
            "$ ls\n" +
            "115287 pfmch.ncr\n" +
            "$ cd ..\n" +
            "$ cd tchbjclg\n" +
            "$ ls\n" +
            "dir jgrmrzlh\n" +
            "155900 jpljl.fnw\n" +
            "$ cd jgrmrzlh\n" +
            "$ ls\n" +
            "dir mjjj\n" +
            "96116 qbpvrr\n" +
            "270714 tqcgmwbj.bcn\n" +
            "$ cd mjjj\n" +
            "$ ls\n" +
            "59415 dpdgtz\n" +
            "47363 twghmhf.qhf\n" +
            "194434 vbnppl.fws\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd tqtsl\n" +
            "$ ls\n" +
            "34243 qqf\n" +
            "131945 qtplsbwd\n" +
            "$ cd ..\n" +
            "$ cd vpn\n" +
            "$ ls\n" +
            "286479 sdmmmds.nwt\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd qtdh\n" +
            "$ ls\n" +
            "215668 nhfpn\n" +
            "$ cd ..\n" +
            "$ cd tbdff\n" +
            "$ ls\n" +
            "48347 qfccg.crl\n" +
            "178091 vbsqcnmm\n" +
            "$ cd ..\n" +
            "$ cd tchbjclg\n" +
            "$ ls\n" +
            "dir bddslhrg\n" +
            "dir cwn\n" +
            "251313 hll.ctt\n" +
            "dir qbpvrr\n" +
            "dir scsp\n" +
            "$ cd bddslhrg\n" +
            "$ ls\n" +
            "dir pqtj\n" +
            "185542 qbpvrr\n" +
            "dir tchbjclg\n" +
            "$ cd pqtj\n" +
            "$ ls\n" +
            "141015 jtwpnb.wvf\n" +
            "17260 lgvbns.pvt\n" +
            "$ cd ..\n" +
            "$ cd tchbjclg\n" +
            "$ ls\n" +
            "dir btsmnvn\n" +
            "237149 hhgbtf.zzs\n" +
            "258581 lwvfgbdj.gpp\n" +
            "31561 mjjj\n" +
            "240514 qbwq\n" +
            "90283 qfccg.crl\n" +
            "$ cd btsmnvn\n" +
            "$ ls\n" +
            "dir bddslhrg\n" +
            "dir qbpvrr\n" +
            "$ cd bddslhrg\n" +
            "$ ls\n" +
            "144007 tchbjclg.qql\n" +
            "$ cd ..\n" +
            "$ cd qbpvrr\n" +
            "$ ls\n" +
            "211075 mjjj\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd cwn\n" +
            "$ ls\n" +
            "67908 gldrw\n" +
            "231112 qbpvrr\n" +
            "$ cd ..\n" +
            "$ cd qbpvrr\n" +
            "$ ls\n" +
            "4482 fzjdz.lzr\n" +
            "134244 rnscgpv.tvg\n" +
            "211213 tmvzclz.mjg\n" +
            "107771 wvzs.nns\n" +
            "$ cd ..\n" +
            "$ cd scsp\n" +
            "$ ls\n" +
            "30654 zzdpcnmt.qbf\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd hsjww\n" +
            "$ ls\n" +
            "12233 crzr.jrf\n" +
            "dir qbpvrr\n" +
            "$ cd qbpvrr\n" +
            "$ ls\n" +
            "dir bddslhrg\n" +
            "54681 fzjdz.wzv\n" +
            "212670 hpmzrq\n" +
            "dir mcvbjw\n" +
            "138779 nhsdjmjj.szh\n" +
            "dir nllvlzfr\n" +
            "217275 tqcgmwbj.bcn\n" +
            "$ cd bddslhrg\n" +
            "$ ls\n" +
            "261081 lbdqrjjp.ffj\n" +
            "244506 wvn.ttr\n" +
            "55843 zbng.zmm\n" +
            "$ cd ..\n" +
            "$ cd mcvbjw\n" +
            "$ ls\n" +
            "149468 rcvbqhh\n" +
            "$ cd ..\n" +
            "$ cd nllvlzfr\n" +
            "$ ls\n" +
            "162791 rdrhrnzc\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd ptfsh\n" +
            "$ ls\n" +
            "163959 bddslhrg.wwb\n" +
            "dir hthjj\n" +
            "dir hwpv\n" +
            "222930 ndvqsfbs.rfb\n" +
            "dir rgrcfr\n" +
            "dir rvrsrfl\n" +
            "95254 tqcgmwbj.bcn\n" +
            "282463 vjchlsrc.cmh\n" +
            "181699 zzdpcnmt.qbf\n" +
            "$ cd hthjj\n" +
            "$ ls\n" +
            "101683 dthb.hwv\n" +
            "112759 mjmdfgl.vdz\n" +
            "191795 whtfg\n" +
            "$ cd ..\n" +
            "$ cd hwpv\n" +
            "$ ls\n" +
            "244334 fzjdz.pgp\n" +
            "$ cd ..\n" +
            "$ cd rgrcfr\n" +
            "$ ls\n" +
            "dir wpslpf\n" +
            "$ cd wpslpf\n" +
            "$ ls\n" +
            "87578 mjjj\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd rvrsrfl\n" +
            "$ ls\n" +
            "dir qbpvrr\n" +
            "$ cd qbpvrr\n" +
            "$ ls\n" +
            "dir gqv\n" +
            "dir hfg\n" +
            "dir lpbc\n" +
            "dir ppp\n" +
            "16805 snlhrz\n" +
            "29365 wnd.mdj\n" +
            "$ cd gqv\n" +
            "$ ls\n" +
            "229300 tqcgmwbj.bcn\n" +
            "$ cd ..\n" +
            "$ cd hfg\n" +
            "$ ls\n" +
            "1680 hcmmjtbq.wcv\n" +
            "$ cd ..\n" +
            "$ cd lpbc\n" +
            "$ ls\n" +
            "100372 lqf\n" +
            "88156 sddtdz\n" +
            "$ cd ..\n" +
            "$ cd ppp\n" +
            "$ ls\n" +
            "79608 tchbjclg\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd qbpvrr\n" +
            "$ ls\n" +
            "22955 zzdpcnmt.qbf\n" +
            "$ cd ..\n" +
            "$ cd ..\n" +
            "$ cd wtm\n" +
            "$ ls\n" +
            "4584 qfccg.crl\n" +
            "$ cd ..\n" +
            "$ cd ztrz\n" +
            "$ ls\n" +
            "187968 fzjdz.thw\n").split("\n"));

    private static class Directory {
        private Directory parent;
        private String path;
        private String directoryName;
        private List<File> files = new ArrayList<>();
        private List<Directory> directories = new ArrayList<>();

        public Directory(Directory parent, String path) {
            this.parent = parent;
            this.path = parent != null ? parent.path + "/" + path : path;
            this.directoryName = path;
        }

        public int evaluateDirectorySize(List<Integer> directorySizeUnderConstraint) {
            int size = files.stream().mapToInt(File::getSize).sum() + directories.stream().mapToInt(directory -> directory.evaluateDirectorySize(directorySizeUnderConstraint)).sum();
            directorySizeUnderConstraint.add(size);
            return size;
        }

        public void addDirectory(Directory directory) {
            this.directories.add(directory);
        }

        public void addFile(File file) {
            this.files.add(file);
        }

        private static class File {
            private int size;
            private String name;

            private File(int size, String name) {
                this.size = size;
                this.name = name;
            }

            public int getSize() {
                return size;
            }
        }
    }
}
