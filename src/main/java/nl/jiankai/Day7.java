package nl.jiankai;

import java.util.*;

public class Day7 {
    private static List<String> rules = Arrays.asList(("pale chartreuse bags contain 3 faded orange bags.\n" +
            "drab gold bags contain 5 dark aqua bags.\n" +
            "mirrored magenta bags contain 3 dotted violet bags.\n" +
            "posh black bags contain 3 dark lavender bags, 3 mirrored coral bags, 1 dotted chartreuse bag.\n" +
            "striped yellow bags contain 5 pale red bags, 2 light lime bags, 5 clear indigo bags.\n" +
            "bright aqua bags contain 2 vibrant orange bags, 4 clear lavender bags, 1 pale gray bag.\n" +
            "dim silver bags contain 2 bright blue bags, 3 faded olive bags, 1 faded cyan bag.\n" +
            "light beige bags contain 2 bright silver bags, 4 vibrant crimson bags.\n" +
            "dull cyan bags contain 2 drab beige bags, 3 mirrored turquoise bags, 2 mirrored indigo bags.\n" +
            "dark black bags contain 5 dull turquoise bags, 4 faded cyan bags, 4 plaid coral bags.\n" +
            "dotted bronze bags contain 3 light blue bags, 2 dull teal bags, 3 dull chartreuse bags, 1 plaid green bag.\n" +
            "light purple bags contain 3 clear tan bags, 3 dull tan bags.\n" +
            "wavy orange bags contain 3 wavy tan bags, 3 faded green bags, 1 shiny brown bag, 2 dim tan bags.\n" +
            "drab beige bags contain 1 vibrant tan bag, 3 pale chartreuse bags, 3 plaid indigo bags, 2 mirrored chartreuse bags.\n" +
            "light coral bags contain 4 faded green bags, 1 pale crimson bag, 3 light bronze bags, 4 posh blue bags.\n" +
            "wavy coral bags contain 5 vibrant cyan bags, 5 light blue bags, 1 dotted turquoise bag.\n" +
            "dotted plum bags contain 1 clear orange bag, 2 drab black bags, 5 dull chartreuse bags, 5 plaid fuchsia bags.\n" +
            "striped olive bags contain 4 clear brown bags, 2 shiny beige bags.\n" +
            "vibrant maroon bags contain 2 dotted beige bags, 4 plaid olive bags, 5 dull black bags, 5 mirrored aqua bags.\n" +
            "drab purple bags contain 2 light green bags, 1 clear orange bag.\n" +
            "shiny violet bags contain 5 drab white bags, 5 dark aqua bags, 3 muted gray bags, 4 wavy orange bags.\n" +
            "muted maroon bags contain 2 plaid red bags, 3 bright silver bags, 5 posh yellow bags, 1 bright yellow bag.\n" +
            "clear black bags contain 1 bright plum bag, 1 faded brown bag, 4 wavy chartreuse bags.\n" +
            "dotted maroon bags contain 5 mirrored turquoise bags.\n" +
            "drab silver bags contain 2 vibrant violet bags, 2 muted orange bags, 4 dull purple bags.\n" +
            "faded purple bags contain 1 bright lime bag, 2 striped brown bags, 5 dull maroon bags, 2 shiny olive bags.\n" +
            "dull maroon bags contain 1 clear lime bag.\n" +
            "pale salmon bags contain 5 striped blue bags, 5 posh blue bags.\n" +
            "plaid orange bags contain 1 pale coral bag, 3 shiny orange bags.\n" +
            "drab black bags contain 5 vibrant orange bags, 1 dotted tomato bag, 2 dim red bags, 3 muted blue bags.\n" +
            "dotted teal bags contain 3 light fuchsia bags, 5 vibrant tan bags.\n" +
            "plaid tan bags contain 5 dark brown bags.\n" +
            "shiny coral bags contain 2 pale green bags, 1 muted lavender bag.\n" +
            "plaid plum bags contain 5 drab lavender bags, 2 shiny teal bags, 1 plaid tan bag.\n" +
            "dim olive bags contain 1 dark beige bag, 1 drab coral bag, 5 muted chartreuse bags, 4 bright teal bags.\n" +
            "dim bronze bags contain 1 striped turquoise bag, 4 muted turquoise bags.\n" +
            "muted red bags contain 5 dark gray bags, 4 muted gray bags, 5 muted blue bags.\n" +
            "shiny crimson bags contain 2 dark aqua bags, 4 faded fuchsia bags, 3 faded tomato bags.\n" +
            "vibrant teal bags contain 1 dark cyan bag, 4 wavy lime bags, 1 bright crimson bag.\n" +
            "dark yellow bags contain 2 striped coral bags, 1 drab tomato bag.\n" +
            "posh orange bags contain 3 wavy lime bags, 3 clear lavender bags, 5 bright indigo bags.\n" +
            "shiny orange bags contain 3 striped gold bags.\n" +
            "wavy magenta bags contain 2 vibrant crimson bags, 3 mirrored teal bags, 1 shiny lime bag.\n" +
            "clear indigo bags contain 2 pale green bags.\n" +
            "wavy red bags contain 5 plaid indigo bags.\n" +
            "wavy crimson bags contain 2 dim teal bags.\n" +
            "clear chartreuse bags contain 2 dull gray bags, 4 plaid lime bags, 3 striped cyan bags.\n" +
            "muted beige bags contain 2 drab white bags.\n" +
            "dim plum bags contain 3 vibrant green bags, 1 clear red bag.\n" +
            "dotted white bags contain 5 wavy magenta bags.\n" +
            "shiny chartreuse bags contain 2 striped tan bags, 2 dim maroon bags, 5 plaid bronze bags, 4 dark white bags.\n" +
            "pale green bags contain 5 drab crimson bags, 3 dull teal bags, 4 plaid red bags.\n" +
            "clear purple bags contain 3 light indigo bags.\n" +
            "striped brown bags contain 1 light yellow bag.\n" +
            "bright plum bags contain 4 faded olive bags, 2 dotted crimson bags, 3 pale green bags, 1 light yellow bag.\n" +
            "posh crimson bags contain 3 bright aqua bags.\n" +
            "dotted olive bags contain 4 striped tomato bags, 4 faded chartreuse bags, 2 dull bronze bags, 2 shiny olive bags.\n" +
            "striped magenta bags contain 2 posh indigo bags, 3 dotted tomato bags.\n" +
            "vibrant chartreuse bags contain 5 light crimson bags, 5 light bronze bags.\n" +
            "light cyan bags contain 1 faded red bag, 1 light silver bag.\n" +
            "faded teal bags contain 5 vibrant crimson bags, 3 drab gray bags, 5 striped turquoise bags, 1 pale plum bag.\n" +
            "mirrored aqua bags contain 1 vibrant white bag.\n" +
            "dull violet bags contain 2 dull orange bags, 1 light green bag.\n" +
            "clear orange bags contain 5 dark green bags.\n" +
            "muted silver bags contain 4 striped indigo bags, 3 mirrored lime bags, 1 bright lavender bag.\n" +
            "posh green bags contain 4 drab gold bags, 4 dim black bags, 4 faded gold bags.\n" +
            "dark bronze bags contain 1 faded plum bag, 5 mirrored teal bags, 5 striped indigo bags, 4 muted salmon bags.\n" +
            "shiny teal bags contain 4 plaid tomato bags, 3 clear brown bags, 4 dull silver bags, 2 wavy orange bags.\n" +
            "light gold bags contain 4 pale tan bags, 3 vibrant gray bags, 5 wavy tan bags, 5 dark violet bags.\n" +
            "bright indigo bags contain 5 shiny silver bags, 4 wavy indigo bags, 5 dark gold bags.\n" +
            "bright gray bags contain 5 shiny lime bags, 4 dull aqua bags.\n" +
            "dotted orange bags contain 1 dim red bag, 4 striped blue bags, 3 bright lavender bags.\n" +
            "dark indigo bags contain 4 drab indigo bags, 1 dotted turquoise bag.\n" +
            "pale lavender bags contain 2 vibrant green bags, 4 dim yellow bags, 1 mirrored yellow bag, 1 bright blue bag.\n" +
            "dotted silver bags contain 2 posh blue bags, 3 posh maroon bags.\n" +
            "plaid salmon bags contain 4 light yellow bags.\n" +
            "plaid magenta bags contain 3 striped gold bags, 2 mirrored black bags, 3 dull tan bags.\n" +
            "wavy blue bags contain 3 faded teal bags, 4 drab blue bags, 1 dotted gold bag.\n" +
            "muted black bags contain 1 drab teal bag, 3 muted lime bags.\n" +
            "clear violet bags contain 3 bright lavender bags, 1 vibrant plum bag, 3 wavy white bags, 1 shiny chartreuse bag.\n" +
            "bright teal bags contain 1 muted chartreuse bag, 4 dull indigo bags, 5 striped tomato bags, 1 drab white bag.\n" +
            "drab lime bags contain 3 posh maroon bags.\n" +
            "shiny tan bags contain 3 faded chartreuse bags, 3 wavy orange bags, 4 drab white bags, 4 light chartreuse bags.\n" +
            "light green bags contain 4 dotted tan bags, 1 dim salmon bag.\n" +
            "pale tan bags contain 3 posh green bags.\n" +
            "light gray bags contain 3 posh brown bags, 3 dim green bags, 3 mirrored tan bags, 1 mirrored yellow bag.\n" +
            "clear gray bags contain 4 dim brown bags.\n" +
            "drab magenta bags contain 4 dark aqua bags, 5 faded tomato bags.\n" +
            "pale violet bags contain 2 bright violet bags, 1 bright indigo bag, 2 muted salmon bags.\n" +
            "vibrant black bags contain 1 bright magenta bag, 4 vibrant crimson bags, 4 clear blue bags, 2 light chartreuse bags.\n" +
            "striped white bags contain 3 plaid yellow bags, 3 muted orange bags, 1 shiny gold bag, 5 light white bags.\n" +
            "wavy turquoise bags contain 5 wavy tan bags, 4 posh chartreuse bags, 5 posh red bags, 3 muted purple bags.\n" +
            "light white bags contain 3 shiny brown bags, 1 striped tan bag, 2 bright lime bags, 5 shiny yellow bags.\n" +
            "faded orange bags contain 3 dim silver bags, 5 wavy tomato bags, 4 wavy chartreuse bags, 1 shiny black bag.\n" +
            "mirrored fuchsia bags contain 2 plaid lime bags, 3 vibrant salmon bags.\n" +
            "dull aqua bags contain 5 clear brown bags, 3 dull indigo bags, 3 dull green bags, 2 muted gold bags.\n" +
            "dim gray bags contain 5 dark bronze bags, 4 dark silver bags, 3 wavy cyan bags.\n" +
            "dull tomato bags contain 4 drab tan bags, 3 striped brown bags.\n" +
            "dim gold bags contain 3 shiny tomato bags, 2 dim tomato bags.\n" +
            "striped beige bags contain 3 shiny violet bags, 3 striped aqua bags, 3 muted blue bags, 3 shiny gold bags.\n" +
            "mirrored coral bags contain 2 muted coral bags, 3 shiny teal bags.\n" +
            "vibrant white bags contain 1 clear brown bag, 3 drab gold bags, 2 wavy crimson bags, 5 light plum bags.\n" +
            "posh tan bags contain 3 dim salmon bags, 1 faded gold bag, 1 drab gray bag, 4 shiny coral bags.\n" +
            "drab tan bags contain 4 bright magenta bags, 3 dull green bags, 1 drab crimson bag, 4 dark green bags.\n" +
            "striped coral bags contain 2 drab tan bags, 4 wavy purple bags.\n" +
            "dark white bags contain 1 bright magenta bag.\n" +
            "striped red bags contain 3 plaid black bags.\n" +
            "drab coral bags contain 4 dotted violet bags, 2 pale magenta bags, 5 posh purple bags, 4 light lime bags.\n" +
            "pale yellow bags contain 5 plaid black bags, 3 shiny olive bags, 3 clear brown bags.\n" +
            "faded coral bags contain 2 pale salmon bags, 5 dim teal bags, 3 vibrant crimson bags.\n" +
            "faded black bags contain 2 wavy white bags, 5 faded brown bags, 4 drab beige bags.\n" +
            "dim salmon bags contain 4 vibrant white bags, 3 wavy salmon bags, 2 wavy lime bags, 2 bright purple bags.\n" +
            "dim black bags contain 3 dull tan bags, 2 striped beige bags, 2 plaid brown bags.\n" +
            "plaid cyan bags contain 2 muted coral bags, 3 dim red bags.\n" +
            "dotted gold bags contain 3 dotted orange bags, 3 striped coral bags, 1 clear magenta bag, 1 dotted crimson bag.\n" +
            "mirrored white bags contain 4 clear brown bags, 2 drab crimson bags, 4 shiny gold bags, 2 posh red bags.\n" +
            "vibrant olive bags contain 4 striped indigo bags, 5 dim salmon bags, 5 bright magenta bags.\n" +
            "dim teal bags contain 5 striped blue bags, 4 dull aqua bags, 5 dark cyan bags, 2 wavy magenta bags.\n" +
            "faded chartreuse bags contain no other bags.\n" +
            "clear yellow bags contain 5 wavy olive bags, 1 drab tomato bag, 2 plaid red bags.\n" +
            "mirrored bronze bags contain 1 vibrant beige bag, 5 clear cyan bags, 3 muted aqua bags, 5 striped turquoise bags.\n" +
            "vibrant tan bags contain 2 dull tomato bags, 5 dark aqua bags, 3 muted gray bags.\n" +
            "light olive bags contain 4 dark white bags, 2 dim teal bags.\n" +
            "light lavender bags contain 5 wavy indigo bags, 3 posh olive bags, 4 striped brown bags.\n" +
            "dotted gray bags contain 1 dim red bag, 5 light tomato bags, 2 dull gray bags, 4 light black bags.\n" +
            "plaid olive bags contain 5 wavy purple bags, 2 posh blue bags, 3 faded purple bags, 1 pale fuchsia bag.\n" +
            "muted salmon bags contain 5 shiny tan bags.\n" +
            "dark olive bags contain 4 mirrored black bags.\n" +
            "striped turquoise bags contain 4 pale olive bags, 2 pale tomato bags, 3 bright yellow bags.\n" +
            "plaid fuchsia bags contain 4 clear silver bags.\n" +
            "vibrant magenta bags contain 1 vibrant green bag, 2 muted silver bags, 4 light plum bags, 5 pale teal bags.\n" +
            "vibrant bronze bags contain 2 dull gold bags, 2 bright coral bags.\n" +
            "mirrored purple bags contain 1 drab tomato bag, 3 faded silver bags.\n" +
            "light lime bags contain 5 shiny violet bags, 4 wavy aqua bags.\n" +
            "pale gold bags contain 3 vibrant brown bags, 5 dim red bags.\n" +
            "dim orange bags contain 4 dark cyan bags, 3 light chartreuse bags, 3 wavy orange bags, 5 dark green bags.\n" +
            "clear fuchsia bags contain 4 posh blue bags, 4 mirrored lavender bags.\n" +
            "pale bronze bags contain 3 pale silver bags, 2 dotted tomato bags, 4 plaid gold bags.\n" +
            "dotted aqua bags contain 3 drab magenta bags, 3 dull green bags.\n" +
            "posh silver bags contain 5 striped lavender bags, 1 dotted maroon bag.\n" +
            "dim coral bags contain 1 wavy bronze bag, 5 striped gray bags, 2 light indigo bags, 2 dim orange bags.\n" +
            "bright green bags contain 5 drab plum bags.\n" +
            "striped teal bags contain 1 light fuchsia bag, 5 vibrant aqua bags, 3 mirrored white bags.\n" +
            "dim crimson bags contain 5 posh gray bags.\n" +
            "drab salmon bags contain 3 bright olive bags, 5 dim tan bags.\n" +
            "muted green bags contain 2 dark beige bags, 4 posh coral bags.\n" +
            "light tan bags contain 5 wavy white bags, 3 dim indigo bags, 3 bright green bags, 5 clear lavender bags.\n" +
            "posh teal bags contain 4 pale salmon bags.\n" +
            "muted cyan bags contain 4 posh yellow bags.\n" +
            "bright turquoise bags contain 3 posh indigo bags, 2 mirrored salmon bags, 2 dim magenta bags.\n" +
            "vibrant salmon bags contain 5 light tomato bags.\n" +
            "dark violet bags contain 3 light bronze bags, 5 dark gold bags, 1 striped magenta bag, 4 faded lavender bags.\n" +
            "faded maroon bags contain 5 plaid teal bags, 5 light turquoise bags, 5 posh white bags, 4 drab orange bags.\n" +
            "dotted magenta bags contain 4 shiny chartreuse bags, 5 drab turquoise bags, 4 bright tomato bags, 2 striped maroon bags.\n" +
            "dotted beige bags contain 5 clear white bags.\n" +
            "bright magenta bags contain no other bags.\n" +
            "dull red bags contain 2 muted lavender bags.\n" +
            "drab green bags contain 2 dotted cyan bags, 4 striped white bags, 3 muted magenta bags.\n" +
            "posh brown bags contain 5 muted lavender bags, 2 posh red bags, 5 drab magenta bags.\n" +
            "faded tan bags contain 3 bright purple bags, 5 plaid tomato bags, 3 dull teal bags.\n" +
            "faded brown bags contain 2 light silver bags, 5 mirrored tan bags, 2 clear tan bags, 2 drab gold bags.\n" +
            "striped black bags contain 3 vibrant yellow bags, 3 dull blue bags, 1 dull aqua bag, 5 dull teal bags.\n" +
            "faded white bags contain 1 muted maroon bag, 1 dark gray bag, 5 dark white bags.\n" +
            "drab aqua bags contain 3 muted white bags, 4 dark cyan bags, 5 pale tomato bags.\n" +
            "dull teal bags contain 2 plaid red bags, 5 mirrored teal bags.\n" +
            "vibrant plum bags contain 2 dim salmon bags, 3 light purple bags, 2 muted gray bags.\n" +
            "plaid crimson bags contain 5 shiny blue bags, 1 dull bronze bag.\n" +
            "wavy violet bags contain 3 dotted tomato bags, 3 striped brown bags.\n" +
            "clear cyan bags contain 1 drab crimson bag, 2 shiny lime bags.\n" +
            "shiny green bags contain 5 muted gray bags.\n" +
            "posh purple bags contain 2 vibrant white bags.\n" +
            "plaid lime bags contain 2 clear crimson bags, 3 bright magenta bags, 5 shiny silver bags, 1 posh blue bag.\n" +
            "dotted violet bags contain 1 dark teal bag, 5 faded crimson bags.\n" +
            "pale maroon bags contain 5 mirrored lime bags, 5 clear olive bags, 5 shiny orange bags, 4 mirrored fuchsia bags.\n" +
            "wavy indigo bags contain 5 plaid lime bags, 5 plaid fuchsia bags, 2 faded chartreuse bags, 4 dotted tomato bags.\n" +
            "faded silver bags contain 5 striped lavender bags, 4 muted lavender bags, 5 plaid brown bags.\n" +
            "drab violet bags contain 1 posh white bag.\n" +
            "bright white bags contain 3 light cyan bags, 1 dark indigo bag, 2 pale turquoise bags, 1 pale brown bag.\n" +
            "faded olive bags contain 2 clear lime bags, 4 muted chartreuse bags.\n" +
            "muted violet bags contain 1 clear lavender bag, 1 dark green bag, 3 dark cyan bags.\n" +
            "shiny gray bags contain 2 dull tan bags, 1 shiny olive bag.\n" +
            "plaid blue bags contain 3 dark aqua bags, 4 muted silver bags, 5 pale beige bags, 1 drab chartreuse bag.\n" +
            "posh fuchsia bags contain 5 posh red bags, 2 muted gray bags.\n" +
            "faded blue bags contain 1 plaid fuchsia bag, 1 mirrored turquoise bag, 2 plaid indigo bags, 1 dark aqua bag.\n" +
            "bright brown bags contain 4 drab violet bags, 5 shiny lime bags, 2 bright beige bags.\n" +
            "mirrored teal bags contain 5 dark gray bags.\n" +
            "bright violet bags contain 2 dotted crimson bags, 3 striped coral bags, 5 shiny maroon bags, 3 dull lavender bags.\n" +
            "striped plum bags contain 2 dim orange bags, 4 clear blue bags, 3 shiny violet bags.\n" +
            "plaid green bags contain 2 bright teal bags, 5 striped lime bags.\n" +
            "muted fuchsia bags contain 4 clear gold bags, 2 vibrant plum bags, 5 bright black bags.\n" +
            "bright purple bags contain 3 vibrant crimson bags, 1 dotted maroon bag, 4 dark gold bags.\n" +
            "faded cyan bags contain 4 dim teal bags.\n" +
            "wavy fuchsia bags contain 5 dull yellow bags, 2 light yellow bags, 5 bright black bags.\n" +
            "wavy salmon bags contain 1 shiny black bag, 3 bright teal bags, 5 clear yellow bags, 1 dull maroon bag.\n" +
            "dark fuchsia bags contain 1 muted violet bag, 3 light cyan bags.\n" +
            "clear salmon bags contain 4 light beige bags, 4 vibrant green bags, 3 pale yellow bags, 1 muted turquoise bag.\n" +
            "pale purple bags contain 1 bright blue bag, 5 pale bronze bags.\n" +
            "posh salmon bags contain 3 faded cyan bags, 4 posh maroon bags, 1 plaid green bag, 2 shiny silver bags.\n" +
            "bright blue bags contain 3 vibrant green bags, 2 drab gray bags.\n" +
            "shiny brown bags contain no other bags.\n" +
            "dark gold bags contain 5 vibrant aqua bags, 2 posh yellow bags.\n" +
            "mirrored violet bags contain 2 pale silver bags, 1 posh fuchsia bag.\n" +
            "bright fuchsia bags contain 3 muted brown bags, 3 plaid purple bags, 2 faded coral bags, 3 mirrored turquoise bags.\n" +
            "dim beige bags contain 2 dull lime bags, 3 dim gold bags, 3 plaid fuchsia bags, 1 posh yellow bag.\n" +
            "shiny white bags contain 1 pale fuchsia bag, 3 shiny beige bags, 3 posh aqua bags, 5 clear tan bags.\n" +
            "posh red bags contain 3 bright magenta bags, 2 dark aqua bags, 4 dark cyan bags.\n" +
            "vibrant fuchsia bags contain 3 striped indigo bags.\n" +
            "faded tomato bags contain 3 wavy olive bags, 5 shiny brown bags, 5 shiny tan bags.\n" +
            "dull purple bags contain 4 plaid teal bags, 4 dull indigo bags, 3 dull bronze bags, 4 faded tan bags.\n" +
            "shiny magenta bags contain 4 pale tomato bags, 4 shiny brown bags.\n" +
            "wavy tan bags contain no other bags.\n" +
            "dull salmon bags contain 3 faded crimson bags, 5 shiny fuchsia bags, 4 dotted silver bags.\n" +
            "pale magenta bags contain 2 faded chartreuse bags.\n" +
            "vibrant purple bags contain 3 muted orange bags, 5 dotted brown bags.\n" +
            "shiny turquoise bags contain 4 dotted turquoise bags, 1 dotted purple bag, 4 dim black bags.\n" +
            "shiny black bags contain 2 clear brown bags, 4 vibrant yellow bags, 1 vibrant aqua bag, 5 mirrored teal bags.\n" +
            "shiny cyan bags contain 3 dotted coral bags.\n" +
            "dim magenta bags contain 3 bright purple bags, 2 wavy white bags, 2 shiny fuchsia bags, 2 shiny yellow bags.\n" +
            "pale beige bags contain 3 dim orange bags, 5 wavy purple bags.\n" +
            "wavy bronze bags contain 5 posh yellow bags, 1 pale green bag, 5 dark cyan bags.\n" +
            "dull blue bags contain 4 wavy tan bags.\n" +
            "striped lime bags contain 5 striped crimson bags, 1 bright plum bag, 5 plaid yellow bags.\n" +
            "faded magenta bags contain 1 plaid green bag, 2 vibrant silver bags, 1 dim turquoise bag.\n" +
            "muted white bags contain 5 bright lime bags, 4 light fuchsia bags, 4 light violet bags, 4 dark aqua bags.\n" +
            "pale fuchsia bags contain 1 striped tomato bag, 1 drab crimson bag, 4 shiny yellow bags.\n" +
            "posh cyan bags contain 5 dark maroon bags.\n" +
            "dim indigo bags contain 3 dark gold bags, 5 bright maroon bags.\n" +
            "faded fuchsia bags contain 4 plaid tomato bags, 2 mirrored red bags.\n" +
            "shiny red bags contain 5 dull olive bags, 1 posh tan bag, 4 bright green bags.\n" +
            "posh maroon bags contain 4 clear blue bags, 5 muted chartreuse bags.\n" +
            "shiny indigo bags contain 4 wavy orange bags.\n" +
            "dim violet bags contain 1 dotted chartreuse bag, 2 mirrored lime bags, 1 drab chartreuse bag.\n" +
            "dim lime bags contain 4 posh fuchsia bags, 5 dull blue bags, 2 dull silver bags, 2 bright lime bags.\n" +
            "muted blue bags contain 5 mirrored lime bags.\n" +
            "dotted fuchsia bags contain 2 wavy magenta bags.\n" +
            "bright beige bags contain 1 mirrored maroon bag.\n" +
            "light bronze bags contain 1 posh maroon bag, 1 dotted maroon bag, 3 clear silver bags.\n" +
            "posh olive bags contain 2 wavy orange bags.\n" +
            "shiny salmon bags contain 2 light teal bags, 5 dark violet bags.\n" +
            "plaid tomato bags contain 5 shiny tan bags, 5 drab white bags.\n" +
            "striped blue bags contain 3 dark cyan bags, 2 pale magenta bags, 3 striped indigo bags.\n" +
            "bright lime bags contain 4 dark cyan bags.\n" +
            "vibrant crimson bags contain no other bags.\n" +
            "mirrored salmon bags contain 1 pale gray bag, 5 dark plum bags.\n" +
            "dim brown bags contain 4 faded fuchsia bags, 4 dull indigo bags.\n" +
            "clear aqua bags contain 1 mirrored black bag, 1 light bronze bag, 2 mirrored maroon bags, 4 mirrored white bags.\n" +
            "clear red bags contain 1 bright lavender bag.\n" +
            "dark maroon bags contain 1 light chartreuse bag.\n" +
            "bright silver bags contain 1 wavy tan bag, 3 plaid black bags, 2 dark gray bags.\n" +
            "faded lime bags contain 1 pale silver bag, 3 drab teal bags.\n" +
            "plaid lavender bags contain 1 plaid fuchsia bag.\n" +
            "faded yellow bags contain 4 dull blue bags.\n" +
            "dark blue bags contain 1 dotted red bag, 1 bright indigo bag, 2 posh tan bags.\n" +
            "light aqua bags contain 3 shiny olive bags, 2 dotted brown bags, 1 dull green bag.\n" +
            "striped gray bags contain 5 faded crimson bags, 4 clear white bags.\n" +
            "dark chartreuse bags contain 5 faded lime bags.\n" +
            "plaid chartreuse bags contain 3 shiny teal bags.\n" +
            "wavy gray bags contain 5 plaid lime bags, 5 wavy olive bags, 5 dim orange bags.\n" +
            "dull yellow bags contain 5 faded chartreuse bags, 2 clear crimson bags, 4 faded fuchsia bags.\n" +
            "muted magenta bags contain 4 mirrored teal bags, 3 drab silver bags, 3 drab lavender bags, 2 mirrored orange bags.\n" +
            "pale turquoise bags contain 3 bright lavender bags, 1 shiny tan bag, 4 posh teal bags, 2 posh cyan bags.\n" +
            "light turquoise bags contain 1 plaid gold bag.\n" +
            "pale brown bags contain 4 muted orange bags.\n" +
            "posh chartreuse bags contain 1 plaid lime bag, 4 shiny gray bags, 3 pale bronze bags, 3 vibrant bronze bags.\n" +
            "posh gray bags contain 3 dim salmon bags.\n" +
            "wavy tomato bags contain 3 vibrant salmon bags, 5 vibrant yellow bags, 2 vibrant green bags, 3 striped brown bags.\n" +
            "dotted indigo bags contain 5 shiny fuchsia bags, 1 posh lime bag, 1 muted beige bag.\n" +
            "pale lime bags contain 4 wavy fuchsia bags.\n" +
            "dull lime bags contain 2 light bronze bags, 3 light beige bags, 4 wavy tomato bags.\n" +
            "shiny olive bags contain 5 dull aqua bags, 5 muted gray bags, 5 posh olive bags.\n" +
            "muted teal bags contain 3 dull teal bags, 5 bright magenta bags.\n" +
            "dull white bags contain 5 striped yellow bags, 1 dim aqua bag.\n" +
            "shiny silver bags contain 4 shiny olive bags, 4 wavy orange bags, 2 mirrored red bags.\n" +
            "dim turquoise bags contain 4 drab gold bags.\n" +
            "clear brown bags contain no other bags.\n" +
            "mirrored olive bags contain 4 dim aqua bags.\n" +
            "striped purple bags contain 5 wavy tan bags.\n" +
            "faded violet bags contain 4 dull tan bags.\n" +
            "faded salmon bags contain 5 striped fuchsia bags, 1 muted lime bag.\n" +
            "mirrored yellow bags contain 2 dark orange bags.\n" +
            "wavy gold bags contain 2 muted salmon bags.\n" +
            "pale tomato bags contain 1 vibrant crimson bag, 5 light black bags, 3 dotted brown bags.\n" +
            "clear bronze bags contain 1 mirrored black bag, 3 wavy red bags, 4 faded white bags, 5 vibrant bronze bags.\n" +
            "mirrored silver bags contain 3 wavy salmon bags, 4 drab brown bags, 1 striped green bag, 4 mirrored lime bags.\n" +
            "dull bronze bags contain 1 dim orange bag, 1 light maroon bag, 5 wavy bronze bags, 2 posh blue bags.\n" +
            "posh lime bags contain 2 dark bronze bags.\n" +
            "light teal bags contain 4 dotted cyan bags, 4 dark crimson bags, 4 striped orange bags, 4 pale black bags.\n" +
            "dark lime bags contain 2 posh red bags.\n" +
            "vibrant yellow bags contain 4 dull indigo bags.\n" +
            "vibrant green bags contain 3 bright silver bags, 1 striped fuchsia bag, 5 dim tan bags.\n" +
            "mirrored lavender bags contain 1 dull maroon bag, 1 bright silver bag, 4 drab teal bags, 2 posh blue bags.\n" +
            "bright salmon bags contain 1 dark aqua bag.\n" +
            "clear green bags contain 3 vibrant blue bags, 4 dotted salmon bags, 5 striped violet bags.\n" +
            "clear lavender bags contain 2 faded silver bags, 5 dim tan bags, 4 drab white bags.\n" +
            "dim chartreuse bags contain 4 dark gray bags.\n" +
            "posh blue bags contain 1 clear silver bag, 5 clear crimson bags, 2 light beige bags.\n" +
            "dim maroon bags contain 5 dotted fuchsia bags.\n" +
            "muted crimson bags contain 1 dark cyan bag.\n" +
            "drab cyan bags contain 4 wavy brown bags.\n" +
            "faded lavender bags contain 3 posh coral bags, 2 dotted violet bags, 3 pale gray bags, 4 plaid beige bags.\n" +
            "dim aqua bags contain 5 dim tan bags, 3 posh olive bags.\n" +
            "posh magenta bags contain 3 bright orange bags, 4 bright salmon bags, 1 vibrant beige bag.\n" +
            "plaid purple bags contain 2 mirrored gray bags, 5 mirrored tan bags.\n" +
            "muted tomato bags contain 1 dotted tomato bag, 4 bright magenta bags, 1 striped turquoise bag.\n" +
            "dull black bags contain 5 wavy coral bags, 4 wavy beige bags, 1 drab lavender bag, 4 dark beige bags.\n" +
            "mirrored maroon bags contain 4 shiny teal bags, 3 light blue bags, 1 light aqua bag, 3 faded tan bags.\n" +
            "posh aqua bags contain 3 dotted orange bags, 4 wavy crimson bags, 5 pale magenta bags, 5 posh fuchsia bags.\n" +
            "muted lavender bags contain 4 faded green bags, 1 dark aqua bag, 4 posh maroon bags, 2 dark white bags.\n" +
            "posh tomato bags contain 2 posh black bags.\n" +
            "dull gold bags contain 1 faded turquoise bag, 4 drab brown bags, 4 shiny turquoise bags.\n" +
            "plaid violet bags contain 3 bright plum bags, 4 clear olive bags, 4 drab bronze bags.\n" +
            "pale silver bags contain 5 wavy olive bags, 5 dull indigo bags, 1 light plum bag, 4 dark gray bags.\n" +
            "dull brown bags contain 1 dim orange bag.\n" +
            "shiny beige bags contain 5 faded purple bags.\n" +
            "striped cyan bags contain 1 muted black bag, 4 dull aqua bags.\n" +
            "dotted green bags contain 4 wavy white bags, 2 shiny violet bags, 4 muted chartreuse bags.\n" +
            "dotted chartreuse bags contain 5 dull bronze bags.\n" +
            "plaid aqua bags contain 2 shiny indigo bags, 5 muted lavender bags, 3 light blue bags, 4 vibrant salmon bags.\n" +
            "mirrored beige bags contain 2 light white bags, 1 wavy coral bag.\n" +
            "light orange bags contain 3 drab salmon bags, 3 clear lavender bags, 4 dark beige bags, 1 clear purple bag.\n" +
            "dark tan bags contain 1 posh olive bag.\n" +
            "muted lime bags contain 3 faded chartreuse bags, 4 muted silver bags, 3 vibrant salmon bags, 1 mirrored blue bag.\n" +
            "posh gold bags contain 5 vibrant magenta bags.\n" +
            "faded beige bags contain 5 faded black bags, 4 clear coral bags, 4 bright olive bags, 1 faded lime bag.\n" +
            "vibrant turquoise bags contain 3 clear cyan bags, 1 dotted fuchsia bag.\n" +
            "faded bronze bags contain 4 posh teal bags, 3 plaid tomato bags, 4 dark bronze bags.\n" +
            "shiny blue bags contain 3 drab indigo bags, 1 dark lime bag.\n" +
            "plaid yellow bags contain 1 plaid lime bag.\n" +
            "shiny aqua bags contain 1 vibrant tomato bag, 4 dark aqua bags, 5 vibrant cyan bags, 4 striped coral bags.\n" +
            "mirrored indigo bags contain 5 vibrant turquoise bags.\n" +
            "wavy cyan bags contain 1 light yellow bag, 4 faded fuchsia bags, 2 clear silver bags, 3 vibrant fuchsia bags.\n" +
            "dull gray bags contain 2 mirrored turquoise bags, 2 posh yellow bags.\n" +
            "dim yellow bags contain 4 light silver bags.\n" +
            "striped crimson bags contain 3 dim salmon bags.\n" +
            "pale coral bags contain 4 vibrant violet bags, 4 posh teal bags, 3 drab aqua bags.\n" +
            "faded aqua bags contain 3 bright magenta bags, 4 muted aqua bags, 3 light salmon bags, 3 light black bags.\n" +
            "drab orange bags contain 2 drab purple bags, 5 light black bags, 5 dull blue bags, 1 bright purple bag.\n" +
            "drab bronze bags contain 3 clear violet bags, 3 drab crimson bags, 3 dotted yellow bags, 5 muted salmon bags.\n" +
            "drab blue bags contain 3 faded violet bags, 4 bright lavender bags, 2 vibrant cyan bags.\n" +
            "pale olive bags contain 4 shiny yellow bags, 1 dull yellow bag, 2 striped tomato bags.\n" +
            "light salmon bags contain 2 shiny gold bags, 2 light silver bags, 4 wavy magenta bags.\n" +
            "wavy brown bags contain 4 dim indigo bags, 3 pale olive bags, 3 mirrored orange bags.\n" +
            "vibrant beige bags contain 5 light lavender bags, 3 wavy bronze bags, 1 plaid yellow bag, 2 dark aqua bags.\n" +
            "clear tan bags contain 3 posh fuchsia bags, 1 pale fuchsia bag.\n" +
            "dotted turquoise bags contain 3 light maroon bags.\n" +
            "dull magenta bags contain 2 dark tomato bags.\n" +
            "dull chartreuse bags contain 5 light chartreuse bags, 2 dotted chartreuse bags.\n" +
            "bright red bags contain 1 dotted brown bag, 1 posh yellow bag, 5 light white bags, 4 shiny maroon bags.\n" +
            "bright bronze bags contain 4 bright salmon bags, 4 plaid bronze bags, 2 dim chartreuse bags.\n" +
            "vibrant gold bags contain 2 faded purple bags, 3 mirrored maroon bags, 3 dull gray bags.\n" +
            "vibrant cyan bags contain 2 faded olive bags, 4 dull silver bags, 3 mirrored lime bags, 4 faded red bags.\n" +
            "mirrored plum bags contain 3 dark orange bags, 5 plaid lavender bags, 5 dim red bags.\n" +
            "clear white bags contain 3 striped beige bags.\n" +
            "drab fuchsia bags contain 4 striped magenta bags, 2 vibrant violet bags, 4 pale aqua bags.\n" +
            "dark purple bags contain 5 striped violet bags.\n" +
            "mirrored tomato bags contain 5 drab olive bags.\n" +
            "dull olive bags contain 4 wavy purple bags.\n" +
            "wavy maroon bags contain 4 pale gold bags.\n" +
            "vibrant blue bags contain 1 faded lime bag, 4 light plum bags.\n" +
            "clear teal bags contain 4 dark green bags, 5 clear brown bags.\n" +
            "clear beige bags contain 4 shiny cyan bags, 3 striped salmon bags.\n" +
            "drab indigo bags contain 5 drab tan bags, 4 shiny black bags, 4 striped brown bags.\n" +
            "muted bronze bags contain 4 dark chartreuse bags, 5 pale crimson bags, 4 vibrant gold bags.\n" +
            "muted olive bags contain 3 wavy olive bags, 5 dark bronze bags, 4 bright aqua bags, 1 dotted yellow bag.\n" +
            "dull beige bags contain 1 dull purple bag.\n" +
            "dotted yellow bags contain 3 dim plum bags, 2 plaid lavender bags.\n" +
            "wavy lavender bags contain 1 vibrant violet bag, 4 posh blue bags, 1 posh plum bag.\n" +
            "dim fuchsia bags contain 5 pale yellow bags, 4 faded plum bags, 5 bright lime bags.\n" +
            "plaid gray bags contain 5 dark violet bags, 2 dotted crimson bags, 4 dull fuchsia bags, 1 drab magenta bag.\n" +
            "vibrant coral bags contain 2 shiny cyan bags, 4 pale magenta bags, 5 striped coral bags, 3 pale teal bags.\n" +
            "drab yellow bags contain 4 clear orange bags, 5 faded fuchsia bags.\n" +
            "dark red bags contain 5 mirrored maroon bags, 3 clear blue bags, 2 striped crimson bags, 2 dotted violet bags.\n" +
            "mirrored cyan bags contain 5 dotted maroon bags, 5 posh turquoise bags, 2 faded gray bags.\n" +
            "muted yellow bags contain 1 light cyan bag, 2 dim orange bags, 5 dull olive bags, 5 light green bags.\n" +
            "wavy aqua bags contain 2 muted cyan bags, 4 mirrored green bags, 5 muted tomato bags.\n" +
            "vibrant lavender bags contain 1 dotted gold bag, 1 light chartreuse bag, 3 mirrored gray bags.\n" +
            "bright black bags contain 1 striped lavender bag, 2 shiny tan bags, 4 bright lime bags.\n" +
            "wavy chartreuse bags contain 4 mirrored red bags.\n" +
            "dull turquoise bags contain 5 faded red bags, 1 light brown bag, 1 clear magenta bag.\n" +
            "dull silver bags contain 4 dark gray bags, 1 faded green bag.\n" +
            "pale black bags contain 1 plaid indigo bag, 3 light tomato bags, 4 drab blue bags.\n" +
            "clear tomato bags contain 1 dim tan bag, 1 clear lavender bag, 1 striped fuchsia bag, 5 clear orange bags.\n" +
            "dark cyan bags contain 4 shiny brown bags.\n" +
            "pale blue bags contain 1 clear green bag.\n" +
            "dotted lavender bags contain 3 dotted maroon bags, 5 wavy salmon bags, 2 pale tomato bags, 5 mirrored blue bags.\n" +
            "pale orange bags contain 4 pale silver bags, 4 striped lime bags.\n" +
            "drab chartreuse bags contain 2 dark gold bags, 5 clear crimson bags, 3 dull green bags.\n" +
            "striped violet bags contain 4 plaid lime bags.\n" +
            "muted gold bags contain no other bags.\n" +
            "mirrored gray bags contain 1 light green bag, 1 striped beige bag.\n" +
            "bright lavender bags contain 2 clear blue bags.\n" +
            "striped gold bags contain 3 muted turquoise bags.\n" +
            "dim white bags contain 1 vibrant lavender bag.\n" +
            "wavy beige bags contain 4 light chartreuse bags, 5 dark lime bags.\n" +
            "dim tomato bags contain 2 wavy aqua bags, 3 faded salmon bags.\n" +
            "light blue bags contain 2 wavy purple bags, 1 dull olive bag.\n" +
            "drab brown bags contain 5 drab magenta bags, 2 muted teal bags.\n" +
            "wavy olive bags contain 3 pale green bags, 5 muted gray bags.\n" +
            "bright chartreuse bags contain 1 clear yellow bag, 2 dotted olive bags, 1 posh olive bag.\n" +
            "posh violet bags contain 5 muted tomato bags, 5 light aqua bags, 3 pale cyan bags, 2 mirrored chartreuse bags.\n" +
            "dotted blue bags contain 4 plaid yellow bags, 3 vibrant bronze bags, 2 dull maroon bags, 3 shiny silver bags.\n" +
            "pale white bags contain 3 plaid brown bags, 2 mirrored aqua bags, 2 dim turquoise bags.\n" +
            "dull lavender bags contain 1 light blue bag, 5 drab tan bags, 3 light yellow bags.\n" +
            "pale cyan bags contain 5 pale green bags, 5 dull tomato bags, 4 vibrant orange bags.\n" +
            "mirrored tan bags contain 1 mirrored blue bag, 5 wavy purple bags.\n" +
            "plaid maroon bags contain 5 bright orange bags, 1 dull fuchsia bag, 5 dull indigo bags, 4 light white bags.\n" +
            "drab plum bags contain 5 pale silver bags, 1 clear yellow bag, 5 dotted fuchsia bags.\n" +
            "muted aqua bags contain 2 posh blue bags, 3 muted chartreuse bags, 1 drab tan bag, 3 dotted brown bags.\n" +
            "striped lavender bags contain 3 posh yellow bags, 5 drab white bags, 1 muted gold bag.\n" +
            "posh bronze bags contain 1 mirrored lime bag, 2 muted cyan bags, 3 muted aqua bags.\n" +
            "dotted brown bags contain 1 dotted orange bag, 3 striped blue bags, 3 dotted teal bags, 4 wavy magenta bags.\n" +
            "light chartreuse bags contain no other bags.\n" +
            "dotted purple bags contain 3 muted lavender bags.\n" +
            "vibrant violet bags contain 3 light violet bags.\n" +
            "dark green bags contain 3 mirrored teal bags, 3 bright magenta bags, 2 light chartreuse bags.\n" +
            "faded indigo bags contain 3 faded fuchsia bags, 4 dim magenta bags.\n" +
            "bright cyan bags contain 4 vibrant olive bags, 4 faded olive bags, 1 posh teal bag.\n" +
            "drab white bags contain no other bags.\n" +
            "clear magenta bags contain 1 dotted maroon bag, 2 wavy olive bags, 5 drab white bags.\n" +
            "light yellow bags contain 4 shiny brown bags, 4 light fuchsia bags, 1 mirrored turquoise bag, 2 drab teal bags.\n" +
            "dark beige bags contain 4 dim crimson bags, 5 mirrored turquoise bags, 3 posh yellow bags, 1 dull chartreuse bag.\n" +
            "dark teal bags contain 5 mirrored tan bags, 5 vibrant tomato bags, 2 bright violet bags, 2 striped silver bags.\n" +
            "pale plum bags contain 2 drab white bags.\n" +
            "light red bags contain 2 striped blue bags, 2 bright violet bags, 4 clear orange bags.\n" +
            "plaid brown bags contain 4 light maroon bags, 5 dull bronze bags, 3 plaid black bags.\n" +
            "plaid bronze bags contain 4 muted salmon bags, 1 light violet bag, 4 plaid black bags.\n" +
            "bright orange bags contain 5 light green bags, 2 wavy plum bags, 5 faded coral bags.\n" +
            "plaid black bags contain 5 dark green bags, 3 dull indigo bags, 3 dim tan bags.\n" +
            "shiny lime bags contain 5 bright lime bags.\n" +
            "shiny fuchsia bags contain 2 dotted tan bags, 3 drab white bags.\n" +
            "bright gold bags contain 1 drab magenta bag, 4 pale salmon bags.\n" +
            "shiny gold bags contain 1 drab white bag, 2 wavy purple bags, 2 muted gray bags, 5 clear crimson bags.\n" +
            "plaid beige bags contain 3 dotted yellow bags.\n" +
            "vibrant silver bags contain 2 muted gold bags, 5 dim teal bags, 4 mirrored white bags, 2 clear blue bags.\n" +
            "dotted black bags contain 1 wavy crimson bag, 5 vibrant purple bags.\n" +
            "mirrored brown bags contain 4 drab aqua bags, 4 dark teal bags, 5 striped plum bags.\n" +
            "dotted red bags contain 5 bright lime bags, 5 vibrant magenta bags, 1 striped turquoise bag.\n" +
            "bright tan bags contain 2 dull yellow bags, 2 posh tomato bags.\n" +
            "striped aqua bags contain 3 clear blue bags, 1 dark maroon bag.\n" +
            "dotted coral bags contain 1 vibrant silver bag, 3 dark green bags, 4 posh gray bags, 2 light red bags.\n" +
            "mirrored lime bags contain 3 mirrored white bags, 1 plaid tomato bag, 2 shiny yellow bags, 2 vibrant black bags.\n" +
            "dark gray bags contain 3 faded green bags, 3 vibrant crimson bags.\n" +
            "wavy lime bags contain 5 wavy salmon bags, 2 faded tomato bags.\n" +
            "dotted lime bags contain 5 drab brown bags, 1 faded salmon bag, 2 wavy violet bags, 4 posh olive bags.\n" +
            "light black bags contain 5 striped indigo bags.\n" +
            "shiny yellow bags contain 5 wavy tan bags, 5 drab white bags, 4 posh olive bags.\n" +
            "bright yellow bags contain 3 posh red bags, 2 plaid black bags.\n" +
            "dull tan bags contain 4 clear brown bags, 3 wavy tan bags.\n" +
            "shiny tomato bags contain 2 shiny orange bags, 4 light lavender bags, 1 plaid lavender bag.\n" +
            "vibrant aqua bags contain 5 pale green bags, 3 drab crimson bags, 2 shiny brown bags.\n" +
            "striped salmon bags contain 2 posh orange bags.\n" +
            "light silver bags contain 1 shiny yellow bag, 4 mirrored turquoise bags, 1 bright coral bag, 2 posh maroon bags.\n" +
            "striped fuchsia bags contain 3 drab white bags, 3 faded chartreuse bags, 4 vibrant black bags, 3 wavy tan bags.\n" +
            "bright tomato bags contain 3 light beige bags, 4 drab teal bags.\n" +
            "shiny plum bags contain 4 clear bronze bags.\n" +
            "vibrant red bags contain 3 bright magenta bags.\n" +
            "mirrored orange bags contain 2 mirrored white bags, 3 dotted brown bags, 3 bright silver bags, 4 pale teal bags.\n" +
            "dull indigo bags contain no other bags.\n" +
            "wavy yellow bags contain 4 wavy white bags.\n" +
            "muted turquoise bags contain 2 posh red bags, 3 dark green bags, 4 mirrored white bags.\n" +
            "striped indigo bags contain 3 dark cyan bags, 5 clear blue bags, 2 faded chartreuse bags.\n" +
            "mirrored green bags contain 4 mirrored chartreuse bags, 3 striped red bags.\n" +
            "plaid white bags contain 1 vibrant salmon bag, 1 dark yellow bag, 2 vibrant violet bags.\n" +
            "dark plum bags contain 4 muted coral bags, 4 mirrored blue bags, 1 vibrant aqua bag.\n" +
            "drab turquoise bags contain 1 dotted purple bag, 1 light plum bag.\n" +
            "light maroon bags contain 2 wavy purple bags, 2 dim orange bags, 1 mirrored white bag, 3 striped tomato bags.\n" +
            "shiny maroon bags contain 2 bright blue bags.\n" +
            "drab crimson bags contain 1 bright magenta bag, 3 drab white bags.\n" +
            "dark aqua bags contain 3 shiny brown bags, 5 dark gray bags.\n" +
            "posh turquoise bags contain 2 shiny gray bags.\n" +
            "muted indigo bags contain 4 wavy purple bags.\n" +
            "dotted salmon bags contain 1 vibrant violet bag, 1 mirrored lavender bag.\n" +
            "plaid indigo bags contain 2 wavy indigo bags, 2 dark white bags, 3 wavy tan bags, 3 vibrant crimson bags.\n" +
            "muted brown bags contain 3 posh yellow bags, 4 shiny lime bags, 5 striped lavender bags.\n" +
            "vibrant gray bags contain 1 mirrored silver bag, 2 light coral bags, 1 faded gold bag, 1 dull fuchsia bag.\n" +
            "drab tomato bags contain 1 wavy tan bag, 1 shiny tan bag, 1 clear crimson bag.\n" +
            "wavy white bags contain 3 muted blue bags, 2 wavy plum bags, 4 dim silver bags, 3 mirrored tan bags.\n" +
            "shiny lavender bags contain 1 posh coral bag, 2 dotted crimson bags, 2 plaid red bags, 1 striped silver bag.\n" +
            "dull fuchsia bags contain 4 light bronze bags, 3 clear gray bags, 1 bright coral bag.\n" +
            "drab teal bags contain 5 muted chartreuse bags, 4 dull silver bags, 5 vibrant black bags, 3 shiny olive bags.\n" +
            "clear crimson bags contain 4 clear brown bags, 3 drab crimson bags, 4 clear blue bags, 1 vibrant black bag.\n" +
            "posh beige bags contain 5 plaid teal bags.\n" +
            "clear silver bags contain 3 plaid tomato bags, 3 bright silver bags, 1 mirrored white bag.\n" +
            "mirrored red bags contain 2 striped indigo bags, 2 drab teal bags.\n" +
            "posh indigo bags contain 3 faded red bags.\n" +
            "dark silver bags contain 5 wavy tan bags, 2 dotted maroon bags.\n" +
            "drab red bags contain 2 dotted chartreuse bags, 3 mirrored tan bags, 5 pale plum bags.\n" +
            "plaid turquoise bags contain 4 dim silver bags, 1 bright orange bag.\n" +
            "dim blue bags contain 1 muted lavender bag, 1 wavy plum bag.\n" +
            "plaid coral bags contain 2 shiny coral bags.\n" +
            "striped silver bags contain 2 muted brown bags.\n" +
            "vibrant tomato bags contain 1 muted black bag.\n" +
            "dark turquoise bags contain 2 light silver bags.\n" +
            "vibrant lime bags contain 2 light beige bags, 3 bright green bags, 5 faded purple bags.\n" +
            "mirrored chartreuse bags contain 2 wavy tan bags, 5 dim tan bags.\n" +
            "light plum bags contain 5 faded green bags.\n" +
            "dim tan bags contain 1 faded chartreuse bag, 2 clear brown bags, 1 faded green bag, 2 muted gold bags.\n" +
            "shiny bronze bags contain 5 drab aqua bags.\n" +
            "dotted tomato bags contain 4 wavy magenta bags.\n" +
            "mirrored crimson bags contain 1 dim bronze bag.\n" +
            "light crimson bags contain 3 posh red bags.\n" +
            "dull coral bags contain 3 striped crimson bags, 4 mirrored salmon bags.\n" +
            "drab lavender bags contain 3 dim salmon bags.\n" +
            "dotted crimson bags contain 3 dark cyan bags, 4 posh blue bags, 2 light fuchsia bags.\n" +
            "dotted tan bags contain 2 posh fuchsia bags, 4 dim black bags.\n" +
            "dark coral bags contain 2 mirrored green bags, 4 shiny white bags, 2 shiny tomato bags.\n" +
            "striped orange bags contain 1 muted violet bag, 5 pale cyan bags, 2 drab tomato bags, 3 faded violet bags.\n" +
            "pale aqua bags contain 3 shiny fuchsia bags, 4 shiny violet bags.\n" +
            "wavy plum bags contain 4 light chartreuse bags, 5 vibrant tan bags, 4 muted lime bags.\n" +
            "mirrored turquoise bags contain 4 shiny brown bags, 4 drab tan bags.\n" +
            "dark magenta bags contain 5 faded violet bags, 2 posh lavender bags.\n" +
            "striped bronze bags contain 3 light silver bags, 3 mirrored brown bags, 3 posh purple bags, 4 drab turquoise bags.\n" +
            "faded red bags contain 2 dark cyan bags, 2 striped tan bags, 4 mirrored violet bags.\n" +
            "faded turquoise bags contain 1 striped crimson bag.\n" +
            "clear gold bags contain 3 clear crimson bags, 5 faded green bags, 4 dim tan bags.\n" +
            "clear coral bags contain 3 striped salmon bags.\n" +
            "faded gray bags contain 4 light salmon bags, 5 clear orange bags, 1 dim yellow bag, 2 wavy green bags.\n" +
            "posh lavender bags contain 2 clear silver bags, 1 wavy indigo bag, 4 faded brown bags, 2 light white bags.\n" +
            "pale red bags contain 3 clear orange bags.\n" +
            "dim lavender bags contain 1 posh silver bag.\n" +
            "vibrant orange bags contain 2 pale magenta bags.\n" +
            "pale gray bags contain 2 dark aqua bags, 2 mirrored turquoise bags, 2 striped fuchsia bags, 5 wavy purple bags.\n" +
            "pale teal bags contain 2 striped brown bags, 4 shiny brown bags.\n" +
            "muted tan bags contain 3 dotted purple bags, 5 clear blue bags, 5 bright plum bags.\n" +
            "dotted cyan bags contain 1 mirrored chartreuse bag, 2 dotted gray bags, 5 pale tomato bags, 1 mirrored lime bag.\n" +
            "dark brown bags contain 4 vibrant orange bags, 3 faded olive bags, 5 posh blue bags.\n" +
            "dull orange bags contain 5 posh coral bags, 5 vibrant green bags, 3 dull maroon bags, 1 striped tomato bag.\n" +
            "plaid silver bags contain 1 muted turquoise bag, 1 wavy green bag.\n" +
            "dull crimson bags contain 4 faded red bags, 1 dotted plum bag, 2 plaid orange bags, 1 posh yellow bag.\n" +
            "muted orange bags contain 4 pale yellow bags, 1 dark maroon bag, 5 mirrored white bags.\n" +
            "wavy black bags contain 4 mirrored blue bags, 4 drab chartreuse bags, 4 dull aqua bags.\n" +
            "light magenta bags contain 2 muted coral bags, 3 wavy violet bags.\n" +
            "faded crimson bags contain 2 dim orange bags, 3 vibrant crimson bags, 4 clear lime bags, 5 wavy olive bags.\n" +
            "light fuchsia bags contain 2 dull green bags, 4 dull indigo bags.\n" +
            "mirrored black bags contain 1 wavy magenta bag, 3 light bronze bags, 3 dull teal bags.\n" +
            "striped tan bags contain 5 vibrant yellow bags, 3 dull silver bags, 5 mirrored teal bags.\n" +
            "dark crimson bags contain 1 mirrored teal bag, 2 muted maroon bags, 5 dull green bags.\n" +
            "light indigo bags contain 5 dotted purple bags.\n" +
            "light brown bags contain 4 dark fuchsia bags, 1 bright olive bag.\n" +
            "wavy purple bags contain 3 vibrant black bags, 5 dull teal bags, 1 bright magenta bag.\n" +
            "posh white bags contain 5 muted purple bags, 5 drab silver bags.\n" +
            "faded gold bags contain 2 dull teal bags, 5 muted orange bags, 3 mirrored lavender bags, 2 clear orange bags.\n" +
            "clear maroon bags contain 2 dim crimson bags, 3 dim maroon bags, 5 wavy salmon bags, 5 mirrored black bags.\n" +
            "bright maroon bags contain 5 dark bronze bags, 4 pale coral bags.\n" +
            "clear turquoise bags contain 1 muted gold bag.\n" +
            "bright coral bags contain 3 striped lavender bags, 4 drab tomato bags, 1 bright lime bag.\n" +
            "wavy teal bags contain 3 faded tan bags.\n" +
            "mirrored gold bags contain 4 faded violet bags.\n" +
            "dark orange bags contain 5 muted purple bags, 1 drab turquoise bag, 5 pale beige bags.\n" +
            "dull green bags contain 1 faded chartreuse bag.\n" +
            "posh plum bags contain 1 dull turquoise bag.\n" +
            "plaid red bags contain 4 wavy orange bags.\n" +
            "faded green bags contain 2 wavy tan bags, 2 muted gold bags.\n" +
            "drab maroon bags contain 5 striped fuchsia bags, 5 light indigo bags.\n" +
            "clear blue bags contain 5 bright magenta bags, 2 muted gold bags, 1 faded chartreuse bag.\n" +
            "shiny purple bags contain 3 mirrored lavender bags, 3 light crimson bags, 2 light turquoise bags, 1 drab aqua bag.\n" +
            "wavy silver bags contain 5 mirrored tan bags, 2 dotted crimson bags, 3 pale magenta bags, 5 vibrant plum bags.\n" +
            "drab gray bags contain 4 mirrored red bags, 4 plaid yellow bags, 4 muted silver bags, 3 light black bags.\n" +
            "striped maroon bags contain 5 dull teal bags, 1 bright indigo bag, 3 clear gray bags.\n" +
            "striped tomato bags contain 2 clear gold bags, 4 plaid red bags, 1 vibrant yellow bag, 2 dark aqua bags.\n" +
            "vibrant brown bags contain 4 vibrant orange bags.\n" +
            "wavy green bags contain 5 striped coral bags, 5 clear brown bags, 4 drab gold bags, 3 faded green bags.\n" +
            "dark tomato bags contain 3 wavy gray bags, 4 clear yellow bags, 4 light fuchsia bags, 1 drab plum bag.\n" +
            "plaid gold bags contain 3 faded red bags.\n" +
            "light tomato bags contain 1 striped black bag.\n" +
            "clear olive bags contain 2 drab lime bags.\n" +
            "dim red bags contain 4 light yellow bags, 5 vibrant yellow bags, 3 dark green bags, 2 vibrant aqua bags.\n" +
            "vibrant indigo bags contain 1 vibrant silver bag.\n" +
            "pale crimson bags contain 4 wavy green bags, 1 striped fuchsia bag, 4 posh indigo bags.\n" +
            "clear lime bags contain 1 wavy tan bag.\n" +
            "muted gray bags contain 1 faded green bag, 2 dull silver bags, 4 drab crimson bags.\n" +
            "striped chartreuse bags contain 2 vibrant silver bags, 2 shiny tan bags, 3 muted silver bags, 2 shiny maroon bags.\n" +
            "muted coral bags contain 5 dark maroon bags, 1 clear lavender bag, 4 bright teal bags, 4 faded cyan bags.\n" +
            "posh coral bags contain 2 clear brown bags.\n" +
            "bright crimson bags contain 2 vibrant salmon bags.\n" +
            "muted plum bags contain 1 pale silver bag.\n" +
            "dull plum bags contain 2 shiny cyan bags, 3 faded salmon bags.\n" +
            "bright olive bags contain 3 dim brown bags, 5 dark brown bags, 1 muted white bag.\n" +
            "clear plum bags contain 5 clear chartreuse bags, 5 striped aqua bags.\n" +
            "muted chartreuse bags contain 1 faded crimson bag, 1 dark cyan bag.\n" +
            "muted purple bags contain 1 bright plum bag, 2 light olive bags, 2 striped red bags, 4 pale magenta bags.\n" +
            "posh yellow bags contain 4 wavy purple bags, 3 dark green bags, 3 striped tomato bags, 3 light chartreuse bags.\n" +
            "light violet bags contain 5 plaid black bags, 1 muted brown bag, 1 vibrant aqua bag.\n" +
            "drab olive bags contain 1 dim brown bag, 2 dull blue bags.\n" +
            "pale indigo bags contain 3 dark magenta bags, 2 dull blue bags.\n" +
            "mirrored blue bags contain 5 clear crimson bags, 1 clear orange bag, 3 drab tomato bags.\n" +
            "striped green bags contain 2 shiny black bags, 4 dotted chartreuse bags, 4 wavy white bags.\n" +
            "plaid teal bags contain 4 dark green bags, 5 muted chartreuse bags, 5 vibrant aqua bags, 4 dotted olive bags.\n" +
            "faded plum bags contain 2 drab white bags, 4 light blue bags, 2 clear lavender bags, 3 vibrant white bags.\n" +
            "dim green bags contain 2 faded green bags, 2 bright magenta bags.\n" +
            "dark lavender bags contain 2 muted lime bags, 2 faded tomato bags, 5 wavy purple bags, 3 light olive bags.\n" +
            "dim purple bags contain 4 dotted plum bags.\n" +
            "dark salmon bags contain 1 dull violet bag, 3 bright indigo bags.\n" +
            "dim cyan bags contain 5 dim crimson bags, 2 clear brown bags, 1 muted brown bag, 4 light silver bags.").split("\n"));

    private static Map<String, List<Rule>> parsedRules;
    private static List<String> alreadySearchedColor;

    public static void main(String[] args) {
        parsedRules = parse();

        part1();
        part2();
    }


    private static Map<String, List<Rule>> parse() {
        Map<String, List<Rule>> parsedRules = new HashMap<>();

        for (String rule : rules) {
            String[] splitRules = rule.split("bags contain");
            String bag = splitRules[0].trim();
            parsedRules.put(bag, new ArrayList<>());

            if (splitRules[1].contains("no other bag")) continue;

            List<Rule> ruleList = parsedRules.get(bag);

            String[] bagRules = splitRules[1].trim().split(",");

            for (String bagRule : bagRules) {
                String[] splitBagRule = bagRule.trim().split(" ", 2);
                ruleList.add(new Rule(Integer.parseInt(splitBagRule[0]), splitBagRule[1].split(" bag")[0]));
            }
        }

        return parsedRules;
    }

    private static void part1() {
        int maxColors = traverseMapForMaxColors("shiny gold");
        System.out.println(maxColors);
    }

    private static void part2() {
        int bagsRequired = getBagsRequired("shiny gold");
        System.out.println(bagsRequired);
    }

    private static int getBagsRequired(String bagColor) {
        List<Rule> canContain = parsedRules.get(bagColor);
        int total = 0;

        for (Rule color : canContain) {
            total += color.quantity + (color.quantity * getBagsRequired(color.bag));
        }

        return total;
    }

    private static int traverseMapForMaxColors(String bagColor) {
        alreadySearchedColor = new ArrayList<>();
        int maxColors = 0;

        for (Map.Entry<String, List<Rule>> rule : parsedRules.entrySet()) {
            final String currentColor = rule.getKey();

            if (hasColor(currentColor, bagColor)) {
                maxColors++;
            }
        }
        return maxColors;
    }

    private static boolean hasColor(String currentColor, String bagColor) {
        List<Rule> canContain = parsedRules.get(currentColor);

        for (Rule color : canContain) {

            if (color.bag.equals(bagColor)) return true;

            if (hasColor(color.bag, bagColor)) {
                return true;
            }
        }

        return false;
    }
}
