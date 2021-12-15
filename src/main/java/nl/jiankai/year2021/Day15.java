package nl.jiankai.year2021;

import java.util.Arrays;
import java.util.List;

public class Day15 {
    public static void main(String[] args) {
        grid = createGrid(input);
//        part1();
        part2();
    }

    private static int[][] createGrid(List<String> input) {
        int[][] grid = new int[input.size()][input.get(0).length()];
        for (int i = 0; i < input.size(); i++) {
            String line = input.get(i);
            for (int j = 0; j < line.length(); j++) {
                grid[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        return grid;
    }

    private static void part1() {
        grid[0][0] = 0;
        findCheapestPath(grid);
    }

    private static void part2() {
        int[][] local = createEnlargedGrid();
        local[0][0] = 0;
        findCheapestPath(local);
    }

    private static int[][] createEnlargedGrid() {
        int m = grid.length;
        int n = grid[0].length;
        int[][] enlargedGrid = new int[m * 5][n * 5];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                enlargedGrid[i][j] = grid[i][j];
            }
        }
        for (int i = 0; i < enlargedGrid.length; i++) {
            for (int j = n; j < enlargedGrid[i].length; j++) {
                int val = enlargedGrid[i][j - n] + 1;
                enlargedGrid[i][j] = val == 10 ? 1 : val;
            }
        }
        for (int i = m; i < enlargedGrid.length; i++) {
            for (int j = 0; j < enlargedGrid[i].length; j++) {
                int val = enlargedGrid[i - m][j] + 1;
                enlargedGrid[i][j] = val == 10 ? 1 : val;
            }
        }

        for (int i = m; i < enlargedGrid.length; i++) {
            for (int j = n; j < enlargedGrid[i].length; j++) {
                int val = enlargedGrid[i][j - n] + 1;
                enlargedGrid[i][j] = val == 10 ? 1 : val;
            }
        }
        return enlargedGrid;
    }

    private static void findCheapestPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }

        for (int i = 1; i < n; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        System.out.println(dp[m - 1][n - 1]);
    }


    static List<String> input = Arrays.asList(("1377191657764644549114627284634913412287739519982496231416283824918194961929936311588211113324916282\n" +
            "1212297521448698359953919612341968949351139967911631956522229222119792152999899993551168415419536961\n" +
            "6159423311678979112521371444921299897197276181489988271511963872918146853113979656119891919929116284\n" +
            "4791323871358399412199298219622788641186798927938163199341117218462279651818983841791285198158689197\n" +
            "7974189811899763275179618283116319192597185732127393472591197762491696726534696112661928998124191441\n" +
            "1719457851119351145679896476439455919892412234291392849988759922872162286199995759192522267673971911\n" +
            "5158991981989914259268282912286934836159941437649989252868156886971224151841291227119542781714229192\n" +
            "8971141349643841951211794248819968548427435466191723999244827371882121325261988461388697379557117813\n" +
            "6984596925919191179943678951217187999979717952993237915971469193192562968292161332928141319899991618\n" +
            "9198522521864259381829335129227674372277199124547185988889492259941882883937916158399823156688865128\n" +
            "8124682618753649934148821878377819747891787181829195781346118199594997697952812114668182584998375593\n" +
            "9981691284313278913662888992426344931897231669692112847984979448943849148537789387936982196747899979\n" +
            "4612594287729384862398119828742189442883965266198489994718698924935284181865741287193312419976111121\n" +
            "9698161969149478565386491726144137461938929999938688185784251478539975684351897911814796415999137427\n" +
            "4215198687955128645232416239572133179888263876627217299182179119281398198291519743556311698595119447\n" +
            "4769546216536687838722946279539949718927689379457711267152121289312649499122925941999769894516538948\n" +
            "2995881981397899317151897695171147699149921139717478649199572991745138182938859417981979318636371733\n" +
            "5896265687179618976487519127375146169177832848256796867888967833698488841993835411394159986678877843\n" +
            "3216645889149389762597933279559298615997238172696673733899239658535753129812911379977549791117989658\n" +
            "3884816682163948316281466989293387989351399981758245478789465919897897823972111872243196689493592859\n" +
            "2147411131991983852642238326868847926889726486359749798736947597961361232791761388538288138311778889\n" +
            "9667691879291819996979958298917569848789574811461556979737155191582528998586729496138919417641516671\n" +
            "2985749275368176832969872226792613823962499974291511594718356964791163978998319397955899236233367196\n" +
            "9146792975371119515819629946162595322898172566118389981777412389859448518999793848789641614927396527\n" +
            "3837698153921119789191289266863437969919159469416859886989979288999338293364182598593531435838918299\n" +
            "3116635237718874995349321215895321218981134288293817795799641825791914139998851951282874988993695793\n" +
            "7561593471951437617129518549197936965341984929165166946255778981198999251529198369291988622121996798\n" +
            "5671179846637276839326113991917774391317631914135868839991981526789969485778186774513984993819918858\n" +
            "6829332192876499239259333179131416651652797879989678673653791799313167962195825894623277922675147419\n" +
            "2114199213615191896184775491411521611589987859919419942228661718872131759515219245894537581322719999\n" +
            "9111987791914149296428193389129811532587733939222947217392149842114232514793791618151173592229671281\n" +
            "6995979618889983189931395618837152991881964616562117919875424671693616994916979814989851972258726362\n" +
            "8173982492272918487736387139295771914721973489627891148815174139856171119417695981112277482189839214\n" +
            "1973523966752994411692968746997296995879577697121374597143849499591366213426378939791149178595161638\n" +
            "5585893988624565875416425158849421541992777828132459639548799994998964889296735678462311472353412967\n" +
            "7998888978481899581293841169535632193113981375899864159935724481141949931596889935158262842998335918\n" +
            "3628289787876715955926724188591588897816776996999489661971733199394273281174961857913237989933989451\n" +
            "8999891193589892228558191976973146639339899432418722147824142953482626221311856529949321934951835227\n" +
            "3992588951996859132652698919297445999986186384145475156862729991985721181638964313723299881446598791\n" +
            "8998893814179771279297296539879723788234226489159913739727989917182438292712863462491283593165387584\n" +
            "2225959678947915336339588711833943992739379439179861836978399199426662599832739483128822695786825928\n" +
            "4919938138891315978138689416887291774881364839148591162128739219164535299459734549155337432999197911\n" +
            "5811216519919174895539797554977936679185698239492921912567121774999488711422544391969771432876537978\n" +
            "5239614948192317841478695119921598999373194178187891395921768432788912522293359417821221957119946281\n" +
            "1988479858958131921192883481392499559613188252381615491311198981658653691389656839995274969418186999\n" +
            "7681966495996941919639623988649188782853795834411334478225123731129587739936417679491619562326995611\n" +
            "5163121511288963298982952314191859371657513679589589729491476296199145629795989556991718931869954195\n" +
            "5286192694799561972391914255528729388961162579826999991948753996967849341943671642439977232844987241\n" +
            "4428178895995144247759399167269333681679595491292381917995999298326832893137644125138231529974592499\n" +
            "4818747595975454796832557299789738541316991638259842799695195686599979445783273918859921299915986952\n" +
            "9417754891252219525194996254344713299966647874186411227972277894179442589131199217999933824814123221\n" +
            "4994994141179221782999435468132963989941331328924377879416667894964349919881719919273389195858632919\n" +
            "6976968727729789979799866987389137352126998771769996593346529935239178231461934599332849891191669783\n" +
            "3638279769222728924783398321639372424899579939421986797719284324742197761998188819691989998694456134\n" +
            "7942399772312398643212169162588662393626113494573293938992496629858316948459199523796897485999921378\n" +
            "1618926196928832916821317498771468433845191219257749761298211872798193673922139789349388129994864112\n" +
            "2744672662951116969991384387997932899791711411128942949881741539172615486131619958932849888897989682\n" +
            "8193685169797222169278874619231971178551717869816119199998223293869323667584378393769322171757659961\n" +
            "3567192399993235879219629458779937992841292566997843196897379191646481548121489984711917991295935959\n" +
            "9145791161291867819713918855165912963216971699817988984653272136935995972742126586832589192163991927\n" +
            "8712419729372896439849678162371923271999124418917611596199166288782836898567935828461556972645691618\n" +
            "1974943823672482569954185719922998567599896762236938717767279661182995366114432538799683897379592854\n" +
            "9379716279297768319753269447991272919214661239572849997471968329889977329941157596172896596534356541\n" +
            "6646625991776574551798145872614721797912217571335478976189691399885799159954742823589679431499683381\n" +
            "8989686475467621429635363139819837633819917676359955759915798412948369139162496822357488719729929699\n" +
            "9952575399865114983355711819388989998898752988216171812892716892892635288989999528963419618898418969\n" +
            "5628277482612799192913177936216253978413218756816239842196325888285889223998597986171699813494975765\n" +
            "8787997189686121858117929165777499728392581119799148997676831848921925893394992791762794499675789289\n" +
            "7568442691119995411445659817292988957454727197967556114172439626332319694755129914814595388989917393\n" +
            "1167946915152153284992129919799398949246947728761958125919513931223797949156627271789872543952184319\n" +
            "4333282313991449435292492972979115959364971739574697214551891471125231369421937456949722396783112819\n" +
            "7993297562943921256985797994839951414791377275818117983949117165983469235412826115996393789982931376\n" +
            "1298945898187917593419458849192816235299119793321858952722674788872499636859117952152983654581115748\n" +
            "4878958876835131628931718969837331917173664888187661244567581167587853362752963213489995238858567899\n" +
            "9168679699798852526937699621149596872192558861969279971951421899916958917919199222795984799115181512\n" +
            "8495992724128927671571265912135878347948681836489591199188311363919513913891778977157177888916936997\n" +
            "8999191812299999181826412647458779129464557453899711499291711727199181999313788754481739897894282299\n" +
            "2297358211198319622489958131157137589129796865587176999673399971359991483798893432429642581288291194\n" +
            "9191151249993972592269748389939197998879479776716874389424892989896918395262244556692919498634767192\n" +
            "3146999389982294398923279851895822879874999174675832246619395368959948618376991191857891919997189827\n" +
            "9252644326896871318783941879993798291951189674981419995699216498289849253481984958375343761948696962\n" +
            "4149366989699391314516198739739998365611211146769689837964632818199827733417982911432639733919961118\n" +
            "3785694943346449113313437192173297234317511989486918779179169811959978466519619814382389974795179229\n" +
            "8173193661981438212589321931819226834981393943686781771986927128994261912991939615971363661699439979\n" +
            "8479197349619477856688178917192741661541913841798699288998264161919784358998345986951361544895722194\n" +
            "9387823917552123692884995799334448659591539912212939191659149351819987712961219375817984328598599894\n" +
            "7812964315918866599999396818117119925739213839329419979879298266584522638128949596632628794899927594\n" +
            "2391843348716127619923835446829918293129713997618113899286695811914941791777191781188282864971628831\n" +
            "9869814173464627244763819721441998547833914115357196275866981483721979728829754991183494575248873899\n" +
            "3759525119799512972171139432761121922192889938411511154289933278983814729624198361288155121749742596\n" +
            "2429134344895591883761666874289213982919652654471211641928968826911633151195891488124183473783171928\n" +
            "8886181492349995235524939198716394499923967835658289266169965949434995834857389557293375945691237192\n" +
            "2153231111419541496813818582276229211229793882886697591279261494221346473438333716131521195987982819\n" +
            "9983399491911518719129352817678695921953245885213828259983567431899628715997395359992977155298181325\n" +
            "3474642518564151369499969799513918368919798899185479829989997639246197855513493872738928431872179498\n" +
            "2732318412186196256356897928718985284818126794829779199946899179899192919186578957838955489991999919\n" +
            "5174898514492714279961793617689337727531149659179437978254251988382912951529715877997391742994559149\n" +
            "6441191197877982527547982766164652298155632979453683329949678198587924143899618194194673133812385279\n" +
            "9721933192312647794494392675978994249714237519435528899779968981967867171823197399159123171497951794\n" +
            "9529734972179199615231232651591988769887899696743322386222999813557814511366456767451396998925196619").split("\n"));

    static int[][] grid;
    static int[][] enlargedGrid;
}
