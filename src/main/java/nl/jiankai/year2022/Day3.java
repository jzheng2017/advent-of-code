package nl.jiankai.year2022;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day3 {
    public static void main(String[] args) {
        part1();
        part2();
    }

    private static void part1() {
        int sum = 0;

        for (String rucksack : input) {
            Set<Character> rightHalf = new HashSet<>(rucksack.substring(rucksack.length() / 2).chars().mapToObj(c -> (char) c).toList());
            char[] leftHalf = rucksack.substring(0, rucksack.length() / 2).toCharArray();
            for (char c : leftHalf) {
                if (rightHalf.contains(c)) {
                    sum += Character.isLowerCase(c) ? c - 'a' + 1 : c - 'A' + 27;
                    break;
                }
            }
        }

        System.out.println(sum);
    }

    private static void part2() {
        int sum = 0;

        for (int i = 0; i < input.size(); i += 3) {
            String line = input.get(i);
            Set<Character> secondGroup = new HashSet<>(input.get(i + 1).chars().mapToObj(c -> (char) c).toList());
            Set<Character> thirdGroup = new HashSet<>(input.get(i + 2).chars().mapToObj(c -> (char) c).toList());

            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                if (secondGroup.contains(c) && thirdGroup.contains(c)) {
                    sum += Character.isLowerCase(c) ? c - 'a' + 1 : c - 'A' + 27;
                    break;
                }
            }
        }

        System.out.println(sum);
    }

    private static List<String> input = Arrays.asList(("dtddvvhwttHJhwdhJPddhwJGppmGjgpQgTjQplQpTljwpg\n" +
            "BfzSzRSVVMVNRMDDNBSNSnfBmbrglGQbmNpQggFjpgpbQlQb\n" +
            "ZSBffLnVZdCCPJjhhL\n" +
            "RGCZpWWWFlHQQbgvFssg\n" +
            "jLnMzjnrnjjNjhrjdwbHscsVVgDVQPvPwh\n" +
            "nfJnLMLzjJMtnjNnnBbZtBWBqqbTTTBRpT\n" +
            "nddlhBtqTBqTVSlBtmCmVcRVmZggfWbcZc\n" +
            "jDjvPrPSNPwrDNRWbbgWCjRRCcWm\n" +
            "DzDwSpFrvrvFPQLzQnsqztBthTJnGJqlsJ\n" +
            "gssGmzwgRgsNmTsqgDnDJnbDHHhhzFdDDh\n" +
            "WQVFjMWrVQrVvVVjVctSSLSMZhnJZPBnbdnhbnHZZBDJBh\n" +
            "VCtcccVQLrfvrSlGmfTfNgfmlFgm\n" +
            "DsmfsBbNNZhDWsbmWmNbbPDHLFjcctjjGcnZGzncnctcGH\n" +
            "SwVQJrjVwpgSVRpjpVRrlTMCFFCLCFFcHzzGMcHrtHHH\n" +
            "ppVwTwSwpwvSlSlJTjVVbPhsvvBssWsNfsqWPvWs\n" +
            "BJwqwJtqqDDDrGDnPFzPFfpphD\n" +
            "TgZscCHQLSHgZcfMzpjFFjzsshfj\n" +
            "LcNlTVQCCVLLZTLNvpRtpvBBvRJmNB\n" +
            "bDBGQBBCTTNPGPPwPzcHfVHrDtLWLVrWVjjHWr\n" +
            "gpssqqsqlMFfLZQWftjVpr\n" +
            "lvqqFMRlFcQvbzCNCG\n" +
            "fhhMDdPhWMJMWvhhSfwRSGlzFbSFNlzw\n" +
            "LcqTCqcgZqjTggVjcwbFRwbDBTzbRGRwTS\n" +
            "cHLpZgnCHpQsDdsmQp\n" +
            "jwStJjJhtgJStpgwJMggQWqQTNTfNTWfbNNMCCNG\n" +
            "zRZnFPRZPVncPGVFRlRmGHCTqfCCPCHHfLfbTQCbTq\n" +
            "lnVmFZRZDnRVBFZcrZlhjpggvppthGhphpwprS\n" +
            "lcttSptHHllQbMcsrltSQGpvNBzpgWBBBDDGWzvgLz\n" +
            "PdjPVRFhFqFjRRCjzvRWnWLBLgbBBLzg\n" +
            "hhCCFbPTmjPdhZjhPhZCmTjjMsrJSfHrcmHJrHHmlcJSsmft\n" +
            "WhWnLZSSnSzQQhfLLNSfmDHrCFDDHtpjGGtTGQCG\n" +
            "gJbJBcMVwJlRRdbwvwJBVtjdtHHTmptpHTCtTFrFCp\n" +
            "JwwgvRMJlvJwgqgvqRMcnWWhLPzzsqfnZWnfWWnj\n" +
            "zdwTSvzHMvVSzDCtZhtGmbTGhm\n" +
            "lcBHfFjjgtsmDCgshD\n" +
            "cJPBnqNFnLfHJFPqljclqJzQvSSVWvSnMwvSzSWWdMWM\n" +
            "pNJMcZrsZDLDcbcccMpQffHqvgdwdFFmdmqwvqmgmzsw\n" +
            "hhnWjTTStRCGSMgvvgvdqvdFjvVz\n" +
            "hCTSWhPGttTCGBWMRlTCMSnPBDJpbDfDpNpbbNJfJDJbpJpN\n" +
            "lbcQcSNFchhQNqHLLqhLqrMpqM\n" +
            "WfsnsszPWfBBVpHdprrpdnGL\n" +
            "WTzWfwjtTBzwwBDzmfSSQmmbFZcpQNcbZZbv\n" +
            "PwSJSlmtPPgwgmHhPPvRvGHLRLQRBQGCQVGb\n" +
            "rnsFDnnfGGRWQRnW\n" +
            "dfTTfTFdfrfFFFzQFPJPSSlhqtllNPzgwS\n" +
            "MMbTFZrcrGZMDqNStWScDtzS\n" +
            "dvWmhQggQvCnfnqPqDnDjnfP\n" +
            "lgvdvLClWCQlgdhlrMBBHpGlwbHHGH\n" +
            "CQHgQpPdCQpsCpzRwSVRSzRZwZ\n" +
            "JbNBbcbrJvbJnqVznwwTzrzz\n" +
            "wNbfLvvfDNNBHPFLhddFsQss\n" +
            "VVzqvwzpqvzqNVVHGNqjHpNfSQDWdWwJdPWrWccdQrWrrDdd\n" +
            "nLcbtBRtBhcnWSJQlJSgll\n" +
            "tFbLLLRRhMtsBMtRCRsLCMBVjjvHTNjHHjzcvFFppGHzTT\n" +
            "QCPrPWNPlWjGGZqGmvdPGd\n" +
            "JgpHpSfphhfpVmBSgnTvdtddGvZVdvddDv\n" +
            "LhphBfHpSwSwfHcMgfpmBWWWbsNCjFWsljNbbjlLjb\n" +
            "QJmQbRmdfmdSQRQZSJltTltNvTrtDtrlftDD\n" +
            "wpZcHVwwMgBpWMVgWpHLphztDvvGvDPlnGvDLlNrDPnNPl\n" +
            "McgWFWHHHzVpMgZQFqbjsdjqqRCq\n" +
            "JPhLFfMJDLQnjNCvWWpdjjdM\n" +
            "crSwnwVnwSRBcNBNjjWCdC\n" +
            "GlbTGbsSzrtbmbfhnJQP\n" +
            "fDLSWVDRHHfVWHgPcZlDlZbbQhBcZQbb\n" +
            "jrmFmprTpFztmddjdjrpvBQlQZGhQbTsQbGcQbcbQs\n" +
            "nvqdpmjFnwpLSWlfnVNnWl\n" +
            "nZBRbBJzznNNCnJZwnBSCJMcpcTpcwhcqhmsmWMwFWLL\n" +
            "jQfvjgtfvPlHHqWpvWThpWqWch\n" +
            "VljjjgjQjrTDlDgrHtVCbnJZzNzNbnRNNJZrJR\n" +
            "MQtJnttlMLlJQsNhQrVVrFVWRRbbVFdJDD\n" +
            "vGjvzmjzgHqSjjSzmSGHTWbfDFWrbFzFfdDVrfRWDb\n" +
            "qPRqvTSPggqGgHCmllnCNLtnhcnnsnnw\n" +
            "zrlZsQMFrsgQFMMjMCbjVDCTCW\n" +
            "NqHNRdBppcJJcTpdmRfHThpdDWDtvbWVtbLjWbttWqqCCbLt\n" +
            "mhJpJHTJmBhcJhwhgwzsQwSSlzQQzGlZ\n" +
            "TvsszlvnzRRVTqzVrqrjjZGPfQPFqPqG\n" +
            "mcNhDNchppWmWSNhdSmSCQNjPFjrfGjrgPFCrgFPgPgrLf\n" +
            "SDddWpdMWSwNDmMNwlJRQwJlsVRRvzlsHt\n" +
            "DTtggjsFFFTlPJhvctBqBqSRmSMBSRnmnRcm\n" +
            "fGfwZdrbHVLdbGdHHwwQGVwBBCMMfvCNRNSMMMSRBmmRCN\n" +
            "dGZzGHGVVbvHvHwbzpGbHLrwFDDFTtsglhFspgJshslTDJjT\n" +
            "CbzspssWwCPcvvplrfqfDCJrDqdllB\n" +
            "LjttnjNTNGgQQJdBrffTwB\n" +
            "nVtLSgggjFwtMczhvzpZbSZW\n" +
            "HCzCHHvWthWFHhssWCVmnqZrnqVrmrmgnbrqmN\n" +
            "wPPGBjQQGwGbSlSLwgnpnrBZnBBmnMNnMN\n" +
            "jTTbJlJjPPLPGHHTthhhHcFWTT\n" +
            "qRdvvPDrCpzPHzcdrrcRqtbJJgjhgtWjJgbWJtgCFb\n" +
            "GTwGwNscLllGTZmGSTZGlSBMnhggjbgtgbtbsgWFFMhbMF\n" +
            "ZSQBSmlmzcrdQRqz\n" +
            "cSpTRphwwghRfgSScqPpnDqDCjDjJJJJDvDLCvvn\n" +
            "BVmmQFQBQVNBVmsWlbQFGBBlCHTJznzHLHvvCnjjNLHJDLHD\n" +
            "MFsZZMbBGblbQTmQsFsQMMfPcPcwSpwtStgPphZtctPc\n" +
            "QZbbZBdjPBjbQQbZnSSltlfwWvlvwNtNjwFMMN\n" +
            "DLVqTJqpSVtfsptwfWpv\n" +
            "rcRRVVTSbPQBPrBZ\n" +
            "tjSgSjLFSnVjDWRsQj\n" +
            "lcdqhfFpqZGpZqznrVRWPrnWRVBsVG\n" +
            "FHddNNNHwTHMHvvS\n" +
            "qCSDSQlwBHNbgJrHnLJH\n" +
            "GRpRpRfnmRWWVWgVrF\n" +
            "jhdZjpnvGfTZZQPlCtqQQSsS\n" +
            "FMZSGWWBrZjMBZMrBWMGjjZDnCRqpgPnbRwPbFnvvqFnDR\n" +
            "QHcpfVVslfdVlQclcctqRgqgbsCwbCwPCCCPwD\n" +
            "NLHfLhclmmhdfNNpfQMBmZWBrJMmZWBzMrjj\n" +
            "pBMpRgBMQwzRthmzLC\n" +
            "HPcJvrvDbjvrFDcvWrHfHfWHmdddtdTLztmtdtfllmNdNhNz\n" +
            "DvPFDvnPJLngQsggMGGQ\n" +
            "BbcFHvbhhDbbTSvZmwwgJPPlDlZldd\n" +
            "prCrNLMNgWWJBdrJ\n" +
            "fQMLCfLLtpqsNNMnnfBhcBSVGbhhhcqVbcjc\n" +
            "ZchcZZjmmNpgmJtgmM\n" +
            "RLrHllWrQZQGlBpbGFGFFM\n" +
            "RQnLHrqPLnZHzqjfVPcvVTfCvPTC\n" +
            "fMtwjfMwrbjfGrtrpPGrwpNNVNVqcbdVqHZTFNbcHSNL\n" +
            "mgzvDnJmnJhFJHSTNqZLHncHLS\n" +
            "vRzhzslJFhRffPPQMjGtGl\n" +
            "VMMNjWppQVwzNWrZdrrtMCMZCtMT\n" +
            "ngDScLcvPPgDPDGhGDPGSHVbHTHmZtTSrBHZbZBmBb\n" +
            "LhlglLghnVlplswJjs\n" +
            "bGJQZZTQQLJJbQZlTZLjCGQTsDhWFhmshhvjWVFVVrgtDsst\n" +
            "NScqwHcwwnnzBwqPqqsmVNhgsDDVtsghrFFg\n" +
            "pcrcwnpcffrcBzfbCRLpRLMMRlRLQl\n" +
            "hzCzCzpRgCzzzCctNsNWNqsZqZhPqNPb\n" +
            "TdBwmdrrrDmvwTvqNsSRssPlsWsq\n" +
            "FDBRRHDMTmBfmrmngnpjGgVptMgLCp\n" +
            "ZPLLnSPMFGvFZMSvHhDhqHfqvfqbDW\n" +
            "GgcppCgBcrQBBgplrVddhDqqqfdHgWdfqb\n" +
            "CcCjQszmGBQjrcCwCmCccPwPTPnMPTnMJSMMRZSPJL\n" +
            "LcVVcqqSHRLzRnCfNnGzNW\n" +
            "LZPPdljlCggMjgNM\n" +
            "PTvwlPtwtlJvZTQvbcHppFLHVVTcFssF\n" +
            "fpWzvzNgWJBVfBJzWzBVJNzWbZcbHhlbthjlrrPrjZZPHZhJ\n" +
            "hRDmGCFDwQnStncrjnccHcMP\n" +
            "GmmsGRmFTsFwSCsRQDsCSqqpfvfgzddWggvqdpfBWzVh\n" +
            "wjRBFljJGDFwwlGGpBSjGDtwTVtTgHHHsHHsVTVzsHqq\n" +
            "CPLNPdbWvbMWbcmvPNdLVqtsHqgCqHChZhhsVsHt\n" +
            "PWcPfPvmvNQbbWdWpJjJBDptGnDFjftn\n" +
            "mFFmJpDMmmnJFjWDVclsSpcflSsQwSsc\n" +
            "HrjNNjHNfVwLNSSl\n" +
            "tdZbhjHZHPbdCTvbbhhrGbbHMFmRMvnRRFmmvJMDmgJDJMnq\n" +
            "szJZhshbsfZJjbttchPctdTnWnRWVWMMnBdLRpMnBz\n" +
            "SrNwvDSwrCmnVRvjpWLBBn\n" +
            "ggGmgNFrgSDwmNgrCmtPsZPsjQGsqPcsqqJP\n" +
            "gjSWSjJSWrWzppzW\n" +
            "MCMzHNGNqHfscsFtrtwscVcr\n" +
            "qGHNGNHLCnLmTCHfMMmNTzzldzgJlJZZgJljgTdD\n" +
            "QGTQtQzTmdTsGTLcdFTGzdtBBjtwvBBJDvDMHJgjJvww\n" +
            "lPlqsZWnDJjZvZgV\n" +
            "ShCfCRnWGFsRRRrF\n" +
            "lwGtndCrrmGCwdmhzQrBzrHvLVggPgHv\n" +
            "fjMjDZJqSDJfJqDNDjJffjZLHPHHFvVFzHBLgLFpFpBSgL\n" +
            "MsTZWRNZfJZZqMGVGhhlhhccRnhC\n" +
            "MMvncqvcHcSnsdzzgvdfQjpljpQVTdDQDRTRlVpQ\n" +
            "wLCrNtBFFHHThRlH\n" +
            "bPJtHmCWssqgGPvq\n" +
            "LvTLsmDWvTWqTsmqjRTmjwgdwgnMHMMFgdtHmBmFVn\n" +
            "rlSCJzCSfpGGlhznQdnwFhtHgBFwtV\n" +
            "SGZJJSSrVfCbGJLjPsWbvjRsPTqR\n" +
            "pNqVVDCMVMBpqJVdMNHrccGHrtNtTFFFrQ\n" +
            "hwmllWbvvbnPvbSvtrFhhJzzHztcTztT\n" +
            "WSnbnPbbbvlWlRvnsqqMgLRMjLgVLCJdRV\n" +
            "GphVTGVMtQwtJmtCJP\n" +
            "FRRsBBsFqRNZNNrgqBdRfCZvbmPgmQzJQPnmJbJmQPJPPmwj\n" +
            "RNqsFrRfZZsZWvNqWRFvrBZvWhhCGVplhlWTlTpSCLpMhWMD\n" +
            "RZRjgbZHjjhsSnRsZstDRStsTVpFhBqFphMqPPpTFQVMPFTM\n" +
            "zrcGJwNNdwJrfNdJWvGdJzdTlTFlqTVPFTVFPPBpqNTbBP\n" +
            "WwLdLGfrRLStCZbD\n" +
            "mrmTqJWTvDDppTDb\n" +
            "DGzBfCzNDzdMwnLlbn\n" +
            "FVZPFZFFZPgjmWZsDtsq\n" +
            "TpnFTnFRCgRgldMRnDnRcrcdbdPBHbtPqbVcccrH\n" +
            "WNWLfQQmfhhSNwmrcbSVqPtbZDZcPb\n" +
            "LQhwLQvQvNfJhJRDMGFRlCMDMD\n" +
            "vLFTDmjVvLgnNHPphN\n" +
            "lMClGCmsRdCnPzCccngCpz\n" +
            "dlGZwRsRrRwswGsdSbbZSbVDrVBmDWWWFJrTrFvFTmqV\n" +
            "SGsZRqGLWLLtZRHRRcLHGTlJjzgJpjzTpNTNJNWpTm\n" +
            "MPMPvFFvFBrPPDPMQMPChjgpNpSNTmmmpNlTDljlTz\n" +
            "vnhrvMvnhSRqqLqnfn\n" +
            "mGFrlBmFQNQFljhqqqqbmHMsTPRbWWCsLMWRsb\n" +
            "wnwtvpwVzDVpvzzwZppnctMLtMPWWCstTsWTsTLffRRW\n" +
            "vwDJgZnvZJFqgLBFGqgl\n" +
            "QdGltnWNWqTdqQWvWsMJcrTcFcrgshJRMs\n" +
            "BzPLCDPzzzzCCLLfCBzfSDmLMrDJMglrcRbbhRsFhMrRJcsM\n" +
            "fjSzwwHfSzPzfCVBHlpdjGnZqnZptqQWjGvG\n" +
            "VbJZbgVzvzmhQpQWpQzhDp\n" +
            "tHPPcGcFBlCctCGtGcBBNlDLMGfMLwWfwwqMLLJwQWwp\n" +
            "dCHTPTPJdTBFPdrZjgsjrjnmdgms\n" +
            "JJpBvJQBZVvcFqqnsWdWvjsn\n" +
            "DCfbDbTtbgfCSHqqNdFMPhPDFnPPDWsPjM\n" +
            "bTmzTNCTNmfqTgJQcpLrpZLzVlVL\n" +
            "dtTLntTjzTftnmwnqGGQHNmm\n" +
            "SWbShCPMBgBRRFSFtRZZmm\n" +
            "DlJPCJCgPWhttzpvdjcpVl\n" +
            "WdzsNvWMzNsMHWddWCVffqmSmScLPvLPgLgLPplrrPmL\n" +
            "BtnzbnBhbwttwtZlmmlgcwSrLgmmpm\n" +
            "bFhQtbGBTnjBBbjTtFBbVDzddDDfjdDDqNWVjWHj\n" +
            "ppmtpgLLZLCbMQvQQThdtrvPhV\n" +
            "BBlHBwHRjHqBzzbHHqjjQdDQTDhPQDvnQlrQDQvr\n" +
            "HGjFzwHNczbzRFcGzHGFSJSpspsmpssMLLSZCppmfs\n" +
            "MpGrMMMcTsHMVHcvbwwmmcRSmDmDmv\n" +
            "zCNptqCBQQLCNLCzbfvSvbSzSDRDSmSv\n" +
            "CNNqNgNQJNgQtCqLlllZdZhTrThsnHpVVssPTsGP\n" +
            "jhSGcShDrLcLLFcw\n" +
            "MVzQvQNZVLHvHPdhLW\n" +
            "qzhhQlVbgqjmSjJDsgmR\n" +
            "CFzSPCgcsVVzFgzSCsBJwjdwJtNllnwglJlp\n" +
            "QrvbqWvvLbmvDMMmbdwFWpNNwwwwptjJWn\n" +
            "RZRZZqvvvDbDHCRTGchHFSGG\n" +
            "SszgPSPPVltDlqtz\n" +
            "WfTdTBdQdFnWBBBhBhNjVJtpNsVlDDDHHJWp\n" +
            "hQhrLFsBwdQPggbRgPwRMg\n" +
            "frRppMMDMpDnJfprnZhrrhpzWgvvGCvvFzWFvzvVVWFGJB\n" +
            "TcmLwTsccqwqbPwsdwqdTPSvBvzzztvggVvQCGWQCLBvCv\n" +
            "sswNjscwmqjwSssjdZNMfHHlHhfrnrgnfR\n" +
            "JpBJBdmdzZzzpngmbCnlqnNbNM\n" +
            "MMTHGccLTLvwRMlRnnQnbblnRnSs\n" +
            "vVGtvMcjLVGHfHDrPPWZppBpJpfZZZ\n" +
            "FGJtlttPdPtGFldlPRGpJTVzSBSSggHgJjVmBMHjJm\n" +
            "rhbvqrQLrWqrWLLfqbjjgNmVNSgzTmNgNS\n" +
            "hsffZQqnqCfZzlPPGlRlcwDs\n" +
            "HDDdZpcFwHFRFcZqDctpRDHpwTCVwjrBTQTBLBLBJJBjjQTJ\n" +
            "ldlMzhlPshPbLrrVrQQCMQjB\n" +
            "glzNfWlvbHqSdNNNcF\n" +
            "jZCMtnZZHCZwBWMwCwtMmfPFfvHDvzHFLPmFDfvh\n" +
            "RcrQdRRdGTzGvDGmfgjh\n" +
            "TsQscdQsQNTNqQQpRrRVCCBMMJJWMMVNVjnNJM\n" +
            "zVPWhVzLzWBWHZnlqBllqlpRbGNdffscGNdbDRnNSfcG\n" +
            "MtvSFQQwMcpsGRNGFR\n" +
            "vvTwJJSgmCSMmjVPPJWWhzllWLVV\n" +
            "RjdfnJfmbVvVJVFQcs\n" +
            "rZDZGBBZVvLZLHFW\n" +
            "qPzTDPlVrjNgfCdmPd\n" +
            "bcjmQPrnbmVmsLVrLrjmcHGRWlZHHRwHpZRHWWwH\n" +
            "nFhqzFqJzDJfvfSFqFfGHWZZHGRJRWHZWdpWwZ\n" +
            "hBCtDSSFCTqCCFzSnzMrLNmrMNPTNMQPMmNL\n" +
            "qvNBSJVDJGGVSJbVDDVhDbbqPjpWpWzWrnpWvvWPMjnWnpWz\n" +
            "mlTltwcwMWTPfNTN\n" +
            "CtCwFmCgmcmlRFmFCtRCHgmDJsbBhVqsbBHVDbNHDHJqqb\n" +
            "csBFBsLrBGBWcgLcBvRgpRhbwRwlbQwbwQgD\n" +
            "DCqmDmtTRtRlhdlh\n" +
            "qnCmTNPmmCnSSzmzNzGLzLccGDBzGrBLvvcW\n" +
            "FjfBjHnHzPFwhvFFqh\n" +
            "bjRpGsNsPqQvPclb\n" +
            "NWGGWGrrZVZjsCLmDMMgzgrSnzSm\n" +
            "MDgmmsNCmZMWmHCZLrvnLBBjPLVlPVbW\n" +
            "zcJGQwJdFRnrBVzqzvPr\n" +
            "hTQwhJwcfTFddFdGSfcRQQGFsggsgsHHnSmgsgsmgCnHNZpC\n" +
            "BPfwzfsgsvfszvBRbQpttRVpJbJpVg\n" +
            "LhTmHLbmbcFTFrWCbFqhFHLHVRpVtQpZVVDVprnDMJtJQnVZ\n" +
            "TGWWbTFFGTqlHhqhSdNdNfNSldjjBfjv\n" +
            "zCzpWTccHlWcPzMljMttbJfjmlfm\n" +
            "DqqQVZZqVsqJnbbnmjbJJQ\n" +
            "ZRmDZsSgVmGLsVqsLDFvrcccHrcTWCgWHBCHcCWp\n" +
            "cvGlQMtQlPtQWWMlcGsrFwFdbgdbdGGDCDCwdd\n" +
            "VChVZNBVjTTfhNTFgzrzrJgSdzgzwf\n" +
            "THThZTqZRHZRqNVZNTVLjRCMmQsntQctMnsPmMmMcWtLMQ\n" +
            "pNRHrbNlNnRLNpMMMTrcGcGTcccz\n" +
            "ZttBmsJmZdjsvTTvvdBMjDhfMGWGDfDfcScjfD\n" +
            "CmtTtwvtCsgllNHPPFbLpC\n" +
            "NpQcvwwRHvdfRvQsNfBQNvfRhVmVMqsZMmMshjMMtWZtMmrm\n" +
            "CGHbSSzFLSSHzTnbLnCWMrtWMtjnZMhZrqZtqW\n" +
            "FzCPPzLbPgFJbHSPldNRpgNfvvccgvwf\n" +
            "nSjpnnhNchMQZMSScnshshncJCGwHGClwmHPZlJPTVZCwHJf\n" +
            "LvtzBTgLWgLPlPwHPLPJ\n" +
            "dTBDqRqFzzhQFhshhNhM\n" +
            "HjjdPsjnllHsbnnDnbTBzLBFBZLLpRFRcCHRFz\n" +
            "wqqWwQhQQMCQffqqhtwMGhpZFRRZvzWzFvBvpvmcRvZm\n" +
            "fGfghtNhthqJrQqMqMMSgDdbPjbssDbdSnjCdd\n" +
            "cqPwJJnnffBFqSfJFnDDPVplLdglGgLVjzGLdVSzVt\n" +
            "WHRTWNHsQTNbzsbCbTsvWrWtjlgVdLgLdvdgvmLjpGlgtm\n" +
            "ZMQrTbNHZNsHHrQCZrNDFzhwnMJcfnDhJPPPFh\n" +
            "LRCFbjNjbCZDmtmqmRRmLtFJBgWBBpvJMwBJvGjBBvMBgw\n" +
            "TTrlfHzccVllZhdQgdGMJWvgWgBndwpG\n" +
            "fVSshSVlsfslhsSHHSZtZZNmNFmtmbFCDF\n" +
            "SPGCBPDMtbcbCtchSMccDTTrrrTFTrsrMTWHTHFVWF\n" +
            "JmnzqVmmwwfpJpmdHRTRsdsTrFdrQp\n" +
            "LqwLgzJgnjqLwgGcVbtjDGjcVbhv\n" +
            "PQcMvrvMsvmdSPPVccmSJcSpGBWWWbBHfWWnfttJWnWJpJ\n" +
            "wDzqhjzmqRzDRwqDzNDbWtjWBBBtGbtHpHnnBf\n" +
            "zglRhDqqDZgRNmZQVCdcCPQvvdZv\n" +
            "RpVjRgvFjGBNWtBWFDtt\n" +
            "dcqQwlqMMsCLLfbgQmtD\n" +
            "snlgzsggTzSTSJTr\n" +
            "dLHhDdtlMngFcFsFLFzzsj\n" +
            "vWRGGRVrrWvvGQQJBRsmQzmsqnffqcNfNcfz\n" +
            "vSRVJBVBwTvWTnHphTgDgtMpDl\n" +
            "bvvGnnJbfPmfdgJJSVtwwCpTScVfNpSC\n" +
            "sjsZWDqBqqMRZsDjbWMVwtwNNcNtScRHpRRttp\n" +
            "hzhDqqWDzZzDZzZLQPJPdPnPvlrbGdlnFQ\n" +
            "PwWHTwzFvNHsNzmmMwzNWGQrCqCFjpZbpnGqrqnpbr\n" +
            "gRVRgJRJlDLSJddDccQVrtZnCqjndnrZdnqnqpdq\n" +
            "chhgSSJfQhRRcSSSSBLVfzmzHTNzMNsTNWHMMvMP\n" +
            "lftqSpBSvhlDBDlhBSczQGmcFMcMVVFMmGFWsm\n" +
            "rHLHTNdggsLLnwLHbTTgdrTMPPmMGWZGQQMzQVQFZQGM\n" +
            "gbJnrHHjnbrgLrRrHpBJvSBDDsfJsDtstq\n" +
            "dBTtFLTtVmpdLhMprSRSWMRSMR\n" +
            "QvJvQbjbCgCQRBhzzRsNWNBC\n" +
            "bjgGqQGbQnjGQgnQgbGgjJnDLHLdfPVtdDmLZdBFVVZttdTf\n").split("\n"));
}
