package nl.jiankai;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.ceil;

public class Day5 {
    private static String[] arr = ("BBFFBFBRLL\n" +
            "FFFFBFBRLR\n" +
            "BFFBBFBRLR\n" +
            "BFBBBFBLLL\n" +
            "FFBBFBBLRR\n" +
            "BFBFFFFRRL\n" +
            "BBBBFFFRLR\n" +
            "BFFFBBFRLL\n" +
            "FFFFBFBRRL\n" +
            "BFBBFFFRRL\n" +
            "BBFBBBFRLL\n" +
            "FBFFBFFRLL\n" +
            "FBBBBBBLRL\n" +
            "FFFBBFBLRL\n" +
            "FFBBFFFLLR\n" +
            "FBBFFFBLLL\n" +
            "FFBFBBBRRL\n" +
            "FBFBBBFRRL\n" +
            "FFBBBFFLRL\n" +
            "BFBBBBFRLR\n" +
            "FBBBFFBRRL\n" +
            "FBBFBFFRLL\n" +
            "FBFBFBBLLL\n" +
            "BFBFFFFLRR\n" +
            "FFFBBFFLLL\n" +
            "FFFFBFFRLL\n" +
            "FBBBBFBRRR\n" +
            "FBBFBBBLRL\n" +
            "BBBBFFFLLL\n" +
            "FFFFBFBLLR\n" +
            "BFFFFBBRLL\n" +
            "BFFFFBBRLR\n" +
            "BFFFFFBRLL\n" +
            "BFFBBBFRRL\n" +
            "FBFFBBBLRR\n" +
            "BFBFFBFRRR\n" +
            "BBBBFFBLRR\n" +
            "FFFFFBBRLR\n" +
            "BFFFBBBRLR\n" +
            "BBFBFFBRRL\n" +
            "FBBFBFBLRR\n" +
            "BFBBFBFRLR\n" +
            "FFFFFBFRRR\n" +
            "BFFFFFBLRL\n" +
            "FFFBFBBLLR\n" +
            "BFFFBBBLRR\n" +
            "FFBFFBBRRL\n" +
            "FBBBBBBLLL\n" +
            "FBBBBFBLRL\n" +
            "BBFFFBFRRL\n" +
            "BBFFFBBRRL\n" +
            "FFBFBFBLRL\n" +
            "FFFFBBBRLR\n" +
            "FBBFFBFLRL\n" +
            "FBBBBFBRLR\n" +
            "BBFBFBBLRL\n" +
            "BBBBFFFLRR\n" +
            "BFBBFFBRLL\n" +
            "BFBBFBBRLR\n" +
            "FFFBBFBRRR\n" +
            "BFFBBBFRRR\n" +
            "BFBBFBBLRR\n" +
            "FBBFFBBLRL\n" +
            "FFFBFBBRRL\n" +
            "BFFFBFBRRR\n" +
            "FBBBFFBLRR\n" +
            "BBFFBBBLLR\n" +
            "BFFBBBBRLR\n" +
            "BBBBFBFRRR\n" +
            "BBBBFFFRRL\n" +
            "BBFFBBBRRL\n" +
            "FFBBBBBRRL\n" +
            "FFFFBBFRRL\n" +
            "BFFFFFBLLL\n" +
            "FFBFFBBLRL\n" +
            "FFFBBFFLRL\n" +
            "BFBFBFFLLR\n" +
            "FFFFBFFRRL\n" +
            "FBBBBFFRLR\n" +
            "FBBBBFBRRL\n" +
            "FBBBFBFLLR\n" +
            "FBBBBBBRRR\n" +
            "FBBFFFFRRL\n" +
            "FBFBFFFRLL\n" +
            "BBFFFBFRLL\n" +
            "BFFBFFFRLL\n" +
            "FFFFBFFLRL\n" +
            "FBBFFFFLLR\n" +
            "BBBBFFBRLL\n" +
            "FBFBFBBRLL\n" +
            "BBFBBBFLLL\n" +
            "FFBFBBBRRR\n" +
            "BFBBFBFRRR\n" +
            "BFBFBBFLRR\n" +
            "BBFBBBFLRL\n" +
            "BBFFFBBLRL\n" +
            "FBFFFBFRLR\n" +
            "FFBFFBBRLL\n" +
            "FFBFFBFRLR\n" +
            "BBBFBFFLLR\n" +
            "BBFBFBBLRR\n" +
            "FBBBBFFLLR\n" +
            "BFFBFBFLRL\n" +
            "FFFBFFFLRR\n" +
            "FBBFBBBRRL\n" +
            "FBFBBBBRRL\n" +
            "BFBFBBFLLL\n" +
            "BFBFBBFRLL\n" +
            "FBFBFFBLLR\n" +
            "FBFFFFBRLR\n" +
            "BBFBBBFRRL\n" +
            "BBBFFFFLLL\n" +
            "FFFFBFBLRL\n" +
            "FFBFFFBLLR\n" +
            "FFFBBBBRRL\n" +
            "FFBFFFBLRL\n" +
            "BBBBFBFRRL\n" +
            "FFFBFFFLLR\n" +
            "BBBBFBBRLR\n" +
            "BBFBBBBRRL\n" +
            "FBFBFFBRLL\n" +
            "FBBBFBFRLL\n" +
            "BFFBFBBRLR\n" +
            "FBFBFBBLRR\n" +
            "FBBFFFBLRR\n" +
            "FFFBBFFRLR\n" +
            "BBBFFFBRLR\n" +
            "BBFFBFFLLL\n" +
            "BFFFFBBLLR\n" +
            "BFBFBBFLRL\n" +
            "FFBFBFBRLL\n" +
            "FBBFBFBRRL\n" +
            "BBBFBFFLLL\n" +
            "FFBBFFFRRR\n" +
            "BFFBBFBLLL\n" +
            "BBBFFBFLLR\n" +
            "FFFBFBBLLL\n" +
            "FFBFBFFRLL\n" +
            "BFFBBBBLRL\n" +
            "FBFBBFFLRL\n" +
            "FBFFBFBLRL\n" +
            "BFBBBBFLRR\n" +
            "BBBFBFFRRR\n" +
            "FBFBBFFRLR\n" +
            "BFBBFFFLLR\n" +
            "BFFFBFBLRR\n" +
            "FBFBFBBRLR\n" +
            "FFFFFBFRLR\n" +
            "FFFFBBBRRL\n" +
            "FBBFFBFLLL\n" +
            "FBBBBBBRLR\n" +
            "FBBFFFBRLR\n" +
            "FBBBFBBRLL\n" +
            "FFFBFBFRLL\n" +
            "BFBFBBFLLR\n" +
            "FFBFFBFRRL\n" +
            "BBFBBBFRLR\n" +
            "FFBBBBBLRL\n" +
            "BBFBBFBRLL\n" +
            "FFBFFFBRLL\n" +
            "FFBBBFFRLR\n" +
            "BFFBBBFLRL\n" +
            "FFBFBFBRRL\n" +
            "FBBFFFBRRR\n" +
            "BBFBBFFLLL\n" +
            "FBFFFFFRLL\n" +
            "FBFFFFBLRL\n" +
            "FFFBFFBRRR\n" +
            "BBBFBFBRLL\n" +
            "BBBBFBBRLL\n" +
            "BFFBFBBLLR\n" +
            "BBBFFFBLRL\n" +
            "BFFBFFBRLL\n" +
            "BFFBBFBRRL\n" +
            "FBFFFFFRRL\n" +
            "FFBBFBBRRR\n" +
            "BBFFBBFLLR\n" +
            "FFBFFBBLRR\n" +
            "BBBFBFFLRL\n" +
            "BBBBBFFLLL\n" +
            "FFBBBBBLRR\n" +
            "BFFBFFBRLR\n" +
            "BFFBBFBLRL\n" +
            "BBFFBBFRRL\n" +
            "FFFBFFBRLR\n" +
            "BFBFBBBLLR\n" +
            "BFFBFFFLLL\n" +
            "FBBFBBBRLR\n" +
            "BFBFBBBRRL\n" +
            "FBFBFFBRRL\n" +
            "BBBFBFBLRL\n" +
            "BFFFBBBLLR\n" +
            "FBBBFBFLRR\n" +
            "FFBBBBBRLR\n" +
            "FFBFFBBLLL\n" +
            "BBFFBFBLRL\n" +
            "BFBFBFBRRL\n" +
            "BFBFFBFLRR\n" +
            "FFBBBFBLLR\n" +
            "BFBFBBBRRR\n" +
            "FBFFBBFLRR\n" +
            "BBBFBFFRLR\n" +
            "BFFFFBFRLL\n" +
            "FFFFBBFLRL\n" +
            "FBBBBFBLLR\n" +
            "BFBFFFFLLR\n" +
            "FFBBFBBRLL\n" +
            "FBFBBFFRRL\n" +
            "BFFFBBFLRR\n" +
            "BBBFFBFLRR\n" +
            "FBBBFFFLRR\n" +
            "BBFFFBFRLR\n" +
            "FFFBFBBRLR\n" +
            "FFBBFBBLRL\n" +
            "FBFFBBBRRR\n" +
            "BBFBBBBLLR\n" +
            "BFFFFFBRLR\n" +
            "BBFBFBFRLR\n" +
            "FBFBBBFLRR\n" +
            "BBFFFBBLLL\n" +
            "BBBFBFBLLR\n" +
            "BFFBBFFLRL\n" +
            "FFBFFFFRLR\n" +
            "BFFFFFBRRR\n" +
            "FFBBBFBLRR\n" +
            "BBBFBBBLRR\n" +
            "BBBBBFFLRL\n" +
            "FBFFFBFRRR\n" +
            "BFFFFFBLLR\n" +
            "FFBBFBFLRL\n" +
            "BBFFFBFRRR\n" +
            "BBBFBFBRLR\n" +
            "BBFBBFBLRL\n" +
            "FFFBFFBLRL\n" +
            "FFFBFFBRLL\n" +
            "BBBBFFFRLL\n" +
            "FBBFFFFLRR\n" +
            "FFBBFFBLLR\n" +
            "FBFFBFBRLL\n" +
            "FFBFBFFLLL\n" +
            "BFBBFFBLRR\n" +
            "BFBFFFBRLR\n" +
            "BBBFFBFRRL\n" +
            "FFBBFBBRLR\n" +
            "BBFFFFBRLL\n" +
            "BBFFBFBLLR\n" +
            "BBFFBFBRRL\n" +
            "FBBBFBBRRL\n" +
            "FFFFFBBRLL\n" +
            "FBFFFBFRRL\n" +
            "FBBFBFFLRL\n" +
            "FBFBBBFRLL\n" +
            "BFFFBFFLRR\n" +
            "BFFBBFBRRR\n" +
            "BFBBFBBLLL\n" +
            "BBFBFFFLRL\n" +
            "BFBFFFFRRR\n" +
            "FBBFBBBLRR\n" +
            "FFBBBBBLLR\n" +
            "FFFFBBFRRR\n" +
            "FFBBFFBRRR\n" +
            "BBFFFBBLLR\n" +
            "BFFBFFBLLR\n" +
            "BBBFFFFRLL\n" +
            "FFFBFBFLLR\n" +
            "BBFBFFBLRL\n" +
            "FFBBBFBRRL\n" +
            "BBFBBBBRRR\n" +
            "BBFBBFBRRR\n" +
            "FFFFBFBRLL\n" +
            "FFFBFFBLLR\n" +
            "FFBFBBBLLR\n" +
            "FBBBFBFLRL\n" +
            "BFBBBBBLLL\n" +
            "BFBBFBFRLL\n" +
            "BFBFBBBLRR\n" +
            "FFBFBFBLLL\n" +
            "BFBFFFBLLR\n" +
            "BBBBFBBRRL\n" +
            "FFBFFBFLRR\n" +
            "FBFBBFFLLL\n" +
            "BFBFBBBRLL\n" +
            "BFBFFFBRRR\n" +
            "FBBFBBFRRR\n" +
            "BFFBFBFRLL\n" +
            "BBFFFFBRRL\n" +
            "BFBFBFBLRL\n" +
            "FBBBFFBRRR\n" +
            "FFFFBBBLLR\n" +
            "BBBFFFFRRR\n" +
            "BBBFFFFLRR\n" +
            "FFBFBBFLLL\n" +
            "BFBFBFFRRR\n" +
            "BBFFFBBRLR\n" +
            "FBBBBBFLRR\n" +
            "FBFFBFBLLR\n" +
            "FFBFFFBLLL\n" +
            "BFFFFBBLRL\n" +
            "BBBFBBBRRR\n" +
            "BBBFFFBRRL\n" +
            "BFFFFBBLRR\n" +
            "BBFFBBBRLL\n" +
            "BFBFFFFLRL\n" +
            "BBFFFFFLRR\n" +
            "BBFFFBFLRR\n" +
            "FBFFBBFRRL\n" +
            "BFFFBBBLLL\n" +
            "BFBBBFFRRL\n" +
            "BFFFBFBLRL\n" +
            "FBBBBFFRLL\n" +
            "BFBFBBBLLL\n" +
            "BFBBFFBLLR\n" +
            "BBBBFBBLLL\n" +
            "FBFBFBFLRR\n" +
            "FBBBFFFRLR\n" +
            "BFFBFBFRRL\n" +
            "BFBBFFFRLR\n" +
            "FBBBFFFLRL\n" +
            "FBBBBFFLRR\n" +
            "FBFFFFBLLL\n" +
            "BBBFFBBRLL\n" +
            "FBBFBFFLLL\n" +
            "BFFBBFBRLL\n" +
            "BFFFFBFRLR\n" +
            "FFFBBFFRRR\n" +
            "FFFBBBFRLR\n" +
            "FBBFFBFRRR\n" +
            "FBFFFFBRRR\n" +
            "BFBFBFBRLL\n" +
            "BBBBBFFRLL\n" +
            "BFFFFBFLLL\n" +
            "BBFFBBFRRR\n" +
            "BFBFFFBLLL\n" +
            "FFFBFBFRRR\n" +
            "FBFBBFBRRL\n" +
            "BFBFFFBRRL\n" +
            "FFFBBBBRRR\n" +
            "BFBFFBBLLR\n" +
            "FBBBFBBLLR\n" +
            "BBFBBFBLLR\n" +
            "BFFFFFFLLL\n" +
            "FBBFBFFRLR\n" +
            "FFBBBBFLLL\n" +
            "BFBBFBFLRL\n" +
            "BFBFBFBLLL\n" +
            "FBBBFBBLLL\n" +
            "BFBFBFBRRR\n" +
            "FBFBFFFLRR\n" +
            "FBFBBFBLLL\n" +
            "FBFFFFBLRR\n" +
            "BBBFFBFRLL\n" +
            "FFFBFFBRRL\n" +
            "BBFBFBFRRR\n" +
            "FBBFFBFRLL\n" +
            "BBBFBBFRRR\n" +
            "FBFBBFFLRR\n" +
            "BBFBBBBLLL\n" +
            "FFBFFBBLLR\n" +
            "FBBBFFFRRR\n" +
            "FFFFFBBLLL\n" +
            "FBFFBBBRRL\n" +
            "BFFBBBFRLL\n" +
            "BFFFBFFLLR\n" +
            "FBFFBBBLLL\n" +
            "FFFBBBBRLR\n" +
            "BFBBBFFLLR\n" +
            "FBFBBBBLLR\n" +
            "FBBFBFBRRR\n" +
            "BBFFBFFRRR\n" +
            "FBBFFFFLRL\n" +
            "FBFBBBBLRR\n" +
            "FFBBFBFRRR\n" +
            "FBFBBFBRLR\n" +
            "BBFBFBFRRL\n" +
            "FBBBBBFLLL\n" +
            "FBFFBFFLLR\n" +
            "FBFBFBFLLL\n" +
            "BFFBFBFLRR\n" +
            "FBBBBBFRLL\n" +
            "BFFBBBFRLR\n" +
            "BBFFFFFLLL\n" +
            "FFFFBBFRLR\n" +
            "BFBBBBBLLR\n" +
            "BBFFFBBRLL\n" +
            "FBFFFFFLRR\n" +
            "BBBFFBBRRR\n" +
            "FFFBFFBLRR\n" +
            "BFFFFFFRLL\n" +
            "BBFFFBFLLR\n" +
            "BFFBBFFLLL\n" +
            "FBBBFFFRRL\n" +
            "BBBBFBFLLL\n" +
            "FBBFFFFRLL\n" +
            "FBFBBFBRRR\n" +
            "BFFFFFFRLR\n" +
            "BFBFFFFLLL\n" +
            "FBFBBFBLLR\n" +
            "BFBBFBFLLR\n" +
            "BFBBFBBLRL\n" +
            "BFFFBFFRLR\n" +
            "BBFBBFFRRR\n" +
            "FBFBFBFRLL\n" +
            "FFBBFBFRRL\n" +
            "BFFFBFFLRL\n" +
            "FBFFBBBLRL\n" +
            "BBBFFBFLRL\n" +
            "FFBBBFBRRR\n" +
            "BFFFBFBRRL\n" +
            "FFBBFBFLLR\n" +
            "BFFBFFFLRL\n" +
            "BBBFFFFLRL\n" +
            "FFBBFFBRLR\n" +
            "BFFBFBBRRR\n" +
            "BFFBFFBLRR\n" +
            "BFFFBBBLRL\n" +
            "FFBFBFFRRR\n" +
            "FFBFBBFRRL\n" +
            "FFBBBBFRLR\n" +
            "BBBFBBFLRR\n" +
            "BFBBFFFLRL\n" +
            "BFBBBBFRRR\n" +
            "FFBFFFBLRR\n" +
            "FFBFBFFLLR\n" +
            "FBFFBFBRRL\n" +
            "BFFFFFFLRR\n" +
            "FBBBBBBLRR\n" +
            "BBFFBBFLLL\n" +
            "BFBBBBFRRL\n" +
            "FFBFFFFLLR\n" +
            "BBFFFBFLLL\n" +
            "FFBFBFFLRR\n" +
            "FFBBBBFLRL\n" +
            "FFFBBBFRRR\n" +
            "FBBFFBFLRR\n" +
            "FBFBBBBRLL\n" +
            "FFFBBBBLLL\n" +
            "FFBBBBFRRL\n" +
            "FBBBBBBLLR\n" +
            "FBBFBFFLLR\n" +
            "BFBBFBFRRL\n" +
            "BBFFBFBLRR\n" +
            "FBFFBFFRRR\n" +
            "FFFBBBBRLL\n" +
            "BFFFFFFLLR\n" +
            "BFFFFBFLLR\n" +
            "FFFBBBFRRL\n" +
            "BFFBFFFLLR\n" +
            "FBFFFFFLLL\n" +
            "BBBBFBBLRR\n" +
            "BBFFBFFRRL\n" +
            "BFBBFFBLRL\n" +
            "FBBBBFFRRR\n" +
            "FFFBBFBLLR\n" +
            "FBBFFFFRLR\n" +
            "FFFBFBBLRL\n" +
            "BFBBBBFLLR\n" +
            "BBFFFBBRRR\n" +
            "BFBFBBFRRR\n" +
            "FFFBFFFRRL\n" +
            "BBFBFBFRLL\n" +
            "FBFFBFFRLR\n" +
            "BFFBFFBLLL\n" +
            "FFFFBFBRRR\n" +
            "BFFBBFFRLR\n" +
            "FBBBFBBLRL\n" +
            "FBFFBBBRLL\n" +
            "FBBBBBFRLR\n" +
            "FBBBFFBLLR\n" +
            "FBFBBFFRLL\n" +
            "FFBBBFFRRL\n" +
            "BBFBBBBLRR\n" +
            "BFFFFBBRRL\n" +
            "BFFFBFFRRL\n" +
            "FBBFBBFRRL\n" +
            "BFBBFFBRLR\n" +
            "BFFFFBFLRL\n" +
            "BBFFFFBLLR\n" +
            "FBFFFFFRRR\n" +
            "FFFFBBBRLL\n" +
            "FFFFBBFLLR\n" +
            "BBBFBBBLLR\n" +
            "FFBFFFFRLL\n" +
            "FBBBFFFLLR\n" +
            "FFFFBBBLRL\n" +
            "FBFBBBFLLL\n" +
            "FBFFFBFLLL\n" +
            "BBBFFBBLRR\n" +
            "FBBBFFFLLL\n" +
            "BBFBBFFRLR\n" +
            "FFFFBFFLLL\n" +
            "BBFFBFFLLR\n" +
            "BFBBBBFRLL\n" +
            "BFFBBFFRLL\n" +
            "BBFFFFBRLR\n" +
            "FBBBBFBRLL\n" +
            "BFBBFFBLLL\n" +
            "FBBFFFFLLL\n" +
            "FFBFFBBRRR\n" +
            "FBFFBBBLLR\n" +
            "BFBBBFBLRL\n" +
            "BBFFBBFRLR\n" +
            "FFBBBFFRRR\n" +
            "BBBBFBFRLL\n" +
            "BFFFBBBRRR\n" +
            "BBFFFFFRLR\n" +
            "FBFBFFFLLR\n" +
            "BBFFBBFRLL\n" +
            "BFFBBFFLLR\n" +
            "FFFFBBBRRR\n" +
            "FFFBFBFRRL\n" +
            "BBBFBBFRRL\n" +
            "FBBBFBBRLR\n" +
            "FBFBFFFRRR\n" +
            "BFFBBBBLLR\n" +
            "BBBFBFBLRR\n" +
            "FBFBBFBLRR\n" +
            "BBBFFBBRLR\n" +
            "FBFBFBBLRL\n" +
            "BBBFFBBLLR\n" +
            "BBFBFBBRLL\n" +
            "FBBBFFBRLL\n" +
            "FFBBFFFRLL\n" +
            "FBFFBFFRRL\n" +
            "BBBBFFBRRR\n" +
            "FBFBFFFLLL\n" +
            "FFFFBBFRLL\n" +
            "BFFBFFFRRR\n" +
            "BBFFBFBRLR\n" +
            "FFBBBFBRLL\n" +
            "BBFBFFFLLL\n" +
            "FBBFBBFRLR\n" +
            "FFFBFFFRLL\n" +
            "FBBFFBFRRL\n" +
            "BFBFFBFLRL\n" +
            "BBBFFFFRRL\n" +
            "BBFFBBBRRR\n" +
            "FFBFBFFRLR\n" +
            "FFBBFFFRLR\n" +
            "FBFBFBBRRL\n" +
            "FFBBFBBLLR\n" +
            "FBFFFFFRLR\n" +
            "BBBBFBBLRL\n" +
            "BBFFBFFRLL\n" +
            "FBBBFBFLLL\n" +
            "BBBFBFBLLL\n" +
            "BFFBFFFLRR\n" +
            "BFBFFBFRLL\n" +
            "BFBBBBFLRL\n" +
            "BBBBFFFLRL\n" +
            "FFFBFFBLLL\n" +
            "FFFFBFBLRR\n" +
            "FFFFFBBRRR\n" +
            "FFFBFBBLRR\n" +
            "BFFFBBFRRL\n" +
            "FFBFBBFLRR\n" +
            "BBFBBBBRLL\n" +
            "FBBBBBFRRR\n" +
            "BFFFFBFLRR\n" +
            "BFBFFBBRRL\n" +
            "FBFBBFBLRL\n" +
            "BBBFFBBLLL\n" +
            "FFBBBFFLRR\n" +
            "BBBBFBFLRL\n" +
            "BBBBFFBLLL\n" +
            "BFFFBBBRLL\n" +
            "FBBFFFBLLR\n" +
            "BFBBBFFRLL\n" +
            "FBBFFBFRLR\n" +
            "BBFBBFBRRL\n" +
            "BFBBFBBRLL\n" +
            "BBFBFFFRRR\n" +
            "FBBBFFBRLR\n" +
            "BBFFBBBLLL\n" +
            "BFFFBFBLLR\n" +
            "BBFBFFBRLR\n" +
            "FFBFFFBRRL\n" +
            "FFBFBFBRLR\n" +
            "BBFFBFBLLL\n" +
            "BFBFBBBRLR\n" +
            "FBFFFBFLRL\n" +
            "BFBFFFFRLR\n" +
            "BBFFFFFRLL\n" +
            "BBBFFFBRRR\n" +
            "FBFFBBFRRR\n" +
            "FFFBBFFLLR\n" +
            "FFFBFBFRLR\n" +
            "FFBBBBFLRR\n" +
            "BFFFBFBRLR\n" +
            "FFBFFBBRLR\n" +
            "FBBFFFBRLL\n" +
            "FBBFBFFLRR\n" +
            "BFFFFFFRRR\n" +
            "BBBFBBBRLL\n" +
            "FBFFFBBRRL\n" +
            "FFBBBFBLRL\n" +
            "FBFFBFBLLL\n" +
            "FFFFBFFRLR\n" +
            "FBFFBFFLRL\n" +
            "FFBFBFFRRL\n" +
            "FBBBFFBLLL\n" +
            "BFFFFBBRRR\n" +
            "BBBBFFBLLR\n" +
            "FFFFFBBLRL\n" +
            "FFBBBFFLLR\n" +
            "FBBBFFFRLL\n" +
            "FFBFFBFRRR\n" +
            "BBBBFFBRLR\n" +
            "FFBBFBFLRR\n" +
            "BFBBBBBRLL\n" +
            "BFBBBBBLRL\n" +
            "FFBFBBFRLR\n" +
            "FFBFBBBRLL\n" +
            "BFFBBFBLLR\n" +
            "BFBFFFFRLL\n" +
            "BBFBBFFRRL\n" +
            "BFBFFBFRLR\n" +
            "FFBBFFFLRL\n" +
            "FFBBBFFLLL\n" +
            "BFFBFBFLLL\n" +
            "BFBFBFBRLR\n" +
            "FBBFBFBLLR\n" +
            "BFBFFBBLRR\n" +
            "FFFFBFFLRR\n" +
            "BBFBBFBLLL\n" +
            "FBFFFFFLRL\n" +
            "BBBBFBFRLR\n" +
            "BFFFBBFRRR\n" +
            "BBFBBFFLRR\n" +
            "BFBBBFBRLL\n" +
            "BFFBFFBLRL\n" +
            "BFBFFFBLRR\n" +
            "BFFFBFFRRR\n" +
            "FBFFFBBLLL\n" +
            "FBFBBBBLRL\n" +
            "FBFBFFFRLR\n" +
            "BBFFBBFLRL\n" +
            "BFBFBFBLLR\n" +
            "FBFFFBFLRR\n" +
            "BFFBFBBRRL\n" +
            "FBFBBBFLLR\n" +
            "FBFBFFBLRL\n" +
            "BBFBFBBRRR\n" +
            "FBBFFBBLRR\n" +
            "BBFFFFBLLL\n" +
            "FBFFBBBRLR\n" +
            "FBFFFBFLLR\n" +
            "BFBBFFFLLL\n" +
            "BBBBFBFLRR\n" +
            "BFFBFBBRLL\n" +
            "BFFFFFFRRL\n" +
            "BFBFBFFRRL\n" +
            "FFBFBFBLRR\n" +
            "FFFBFBFLRR\n" +
            "FFFBFBBRRR\n" +
            "FBFFFBBRLR\n" +
            "FFBBFFBRRL\n" +
            "BBFBBBBRLR\n" +
            "FFFBBFBRLR\n" +
            "FBFFBBFLRL\n" +
            "BBBFFFBRLL\n" +
            "BBBFBBBRLR\n" +
            "FFBFFFFRRR\n" +
            "FBBFBFBLLL\n" +
            "BFBBBFBRRR\n" +
            "BFBBFFBRRL\n" +
            "FFFBBBFLLL\n" +
            "FBBBBFBLLL\n" +
            "FFBFBFBLLR\n" +
            "BFFBFFFRLR\n" +
            "BBBBFBFLLR\n" +
            "FBBFBBFLLL\n" +
            "FBFFFBBLRR\n" +
            "FFBFBBFRRR\n" +
            "FBFBFBBRRR\n" +
            "FFBFBFBRRR\n" +
            "FFBBFBFRLL\n" +
            "FBFBBBBLLL\n" +
            "BFBFFBBLLL\n" +
            "BBBFFFFRLR\n" +
            "BBBFBFBRRR\n" +
            "BFBFBFBLRR\n" +
            "BFBFBBFRLR\n" +
            "BFBBBFFLLL\n" +
            "FBBFFBBRRR\n" +
            "BFFFFFBLRR\n" +
            "BFFBFBFRLR\n" +
            "BBFFBFFRLR\n" +
            "BFBBBBBLRR\n" +
            "FBFFFBBLRL\n" +
            "BFFBFBFRRR\n" +
            "BFFFFBFRRL\n" +
            "FFBFBBBLLL\n" +
            "FBBBFBFRLR\n" +
            "FFFBBFBLLL\n" +
            "FBFBBBFRLR\n" +
            "BFBFFFBRLL\n" +
            "BFFBBBBLRR\n" +
            "BBFFBFFLRL\n" +
            "BBBFBBFRLL\n" +
            "BBBFFFBLRR\n" +
            "FBBFFBBRLR\n" +
            "FBBFBBFLRR\n" +
            "BBFBFBBRRL\n" +
            "FFBBBBBLLL\n" +
            "BFBBFBBLLR\n" +
            "BFBBBFFLRR\n" +
            "BBBFFFBLLL\n" +
            "FBFBBBBRLR\n" +
            "FBFBFFBLRR\n" +
            "FFFBBBFLRL\n" +
            "BBBFFBBLRL\n" +
            "FBBFBFBRLL\n" +
            "BBBBFBBLLR\n" +
            "FFBBBBBRRR\n" +
            "BBBFBBFLRL\n" +
            "BFBBBFBRLR\n" +
            "FFFBFFFRRR\n" +
            "BFFFBBFRLR\n" +
            "FBFFFFBRLL\n" +
            "BFFBFFBRRL\n" +
            "BBBFBBBRRL\n" +
            "FFBFFBFRLL\n" +
            "FBFBBFFRRR\n" +
            "FFBFFFBRLR\n" +
            "FFFFBFFLLR\n" +
            "FFBBFFFLLL\n" +
            "FBFFFBBLLR\n" +
            "FFBFBBFLRL\n" +
            "BFFBFBBLLL\n" +
            "FBBBFBBLRR\n" +
            "FFFBFBFLLL\n" +
            "FBBFBFBLRL\n" +
            "FFBBFFFRRL\n" +
            "BFBFBFFRLL\n" +
            "BFFFFBFRRR\n" +
            "BBBBFFFRRR\n" +
            "BFFBFFBRRR\n" +
            "FFFFBFFRRR\n" +
            "FFBBFBBRRL\n" +
            "FBBFBBBRLL\n" +
            "BBBBFFBLRL\n" +
            "FBBFBBFRLL\n" +
            "BFFBBBBRLL\n" +
            "BFBBBFBRRL\n" +
            "BBFBFBFLLR\n" +
            "FFFBBBBLLR\n" +
            "BFFBBFFLRR\n" +
            "BBBFBBBLRL\n" +
            "FBBFBFFRRL\n" +
            "BBFBFFFRRL\n" +
            "BBFBFFBLRR\n" +
            "BBBFBBFRLR\n" +
            "FBBBFBFRRR\n" +
            "BBFBFBFLRL\n" +
            "FBBFBBFLRL\n" +
            "FFBFFFFLRR\n" +
            "BFBBFBBRRL\n" +
            "FBBBBFFRRL\n" +
            "FBFBFFBRRR\n" +
            "BBBFFBFLLL\n" +
            "FFFBFFFLRL\n" +
            "FBFBBBFRRR\n" +
            "BBBFBFFRRL\n" +
            "BFBFFFBLRL\n" +
            "BBBFBFFLRR\n" +
            "BFFFBFFLLL\n" +
            "FFBFBBFLLR\n" +
            "FFBFBBFRLL\n" +
            "FBFBBBFLRL\n" +
            "BFFBBBBRRL\n" +
            "FBBBFBFRRL\n" +
            "FFBBBFBLLL\n" +
            "BFBBBFFLRL\n" +
            "BBBBBFFLLR\n" +
            "FBFBFFFRRL\n" +
            "BFFBFBBLRR\n" +
            "BBFFFFBLRR\n" +
            "FBFFBFBLRR\n" +
            "FBFFBBFRLR\n" +
            "FFBBFFBLRL\n" +
            "FFFFFBBLRR\n" +
            "BBBBBFFLRR\n" +
            "BFBBBBFLLL\n" +
            "FBBFBFFRRR\n" +
            "FFFFFBBLLR\n" +
            "FFBFFBFLLL\n" +
            "FFBFBBBLRR\n" +
            "FFBBFBFRLR\n" +
            "BFBBBFFRRR\n" +
            "FBFFBFBRLR\n" +
            "BBBFBBFLLR\n" +
            "BFBBFBFLRR\n" +
            "FBBBFFBLRL\n" +
            "BFBBBBBRLR\n" +
            "FBBFBBFLLR\n" +
            "BFBBBFFRLR\n" +
            "FBBBBBFLRL\n" +
            "BFBBBBBRRR\n" +
            "BFFBBBBRRR\n" +
            "BBFBFBFLRR\n" +
            "BFFBBBBLLL\n" +
            "BBFFFBFLRL\n" +
            "BFBBFBFLLL\n" +
            "FBFFFFBRRL\n" +
            "FFBBBBFRRR\n" +
            "FFBFBBBRLR\n" +
            "BBFBFBFLLL\n" +
            "FBFFBFBRRR\n" +
            "FFFBBBFLLR\n" +
            "FFFBFBFLRL\n" +
            "BFBFBBBLRL\n" +
            "FBBFFBBLLL\n" +
            "BBBFBFBRRL\n" +
            "FBFFFBBRRR\n" +
            "BFFFBFBLLL\n" +
            "FFFFBFBLLL\n" +
            "FFFBBFBRLL\n" +
            "FBBFFFBRRL\n" +
            "FFBBFBFLLL\n" +
            "FFBBFFBRLL\n" +
            "FBFBFBFLLR\n" +
            "BBFFFFBLRL\n" +
            "BFBFBBFRRL\n" +
            "FFFBFBBRLL\n" +
            "FBBFFBBRLL\n" +
            "BBFBFBBLLR\n" +
            "BFFFBFFRLL\n" +
            "BFBFBFFLRR\n" +
            "FBFFFFBLLR\n" +
            "FFFBBFBRRL\n" +
            "FFFBBBBLRL\n" +
            "FFBBFFBLRR\n" +
            "BFFFBBFLLL\n" +
            "FFFBFFFLLL\n" +
            "FBFBFBFRRR\n" +
            "BFBBBFBLLR\n" +
            "BFFBFFFRRL\n" +
            "FFFFBBFLRR\n" +
            "FBFBFBFRRL\n" +
            "BFBBFBBRRR\n" +
            "BFBFFBBLRL\n" +
            "FBFBBFBRLL\n" +
            "FBBBBFFLRL\n" +
            "FFBFBFFLRL\n" +
            "FBBFBBBRRR\n" +
            "FBFBFBFRLR\n" +
            "FFBFFFFLRL\n" +
            "BBFBFBBRLR\n" +
            "BFBFFBBRLL\n" +
            "BBFFBFBRRR\n" +
            "BFBBBBBRRL\n" +
            "BBFBBBFLLR\n" +
            "BBFFBBBRLR\n" +
            "BBFBFFFLLR\n" +
            "FFFFBBFLLL\n" +
            "FBBFFFFRRR\n" +
            "BBFBFFBRLL\n" +
            "FFBBFBBLLL\n" +
            "BFBBFFFRRR\n" +
            "BFBBFFFRLL\n" +
            "BFFBBFFRRL\n" +
            "BBFBBBFRRR\n" +
            "BFFFBFBRLL\n" +
            "BFFFBBBRRL\n" +
            "FBFBBFFLLR\n" +
            "FBFFBBFRLL\n" +
            "BBFBBFBLRR\n" +
            "BBBFFFFLLR\n" +
            "FBBFBBBLLL\n" +
            "FBFFBBFLLL\n" +
            "BFFBFBBLRL\n" +
            "BBFFFFFRRL\n" +
            "FFBBBBBRLL\n" +
            "FBFFBFFLLL\n" +
            "FFFFFBFRRL\n" +
            "BBBBFFBRRL\n" +
            "FBBFBFBRLR\n" +
            "BBFBBFBRLR\n" +
            "BFFBBFBLRR\n" +
            "BFFFFBBLLL\n" +
            "BBBBFBBRRR\n" +
            "BBBFFFBLLR\n" +
            "FFBFFFFLLL\n" +
            "FBBFFBFLLR\n" +
            "BBFFFFFLRL\n" +
            "FFFFBBBLRR\n" +
            "FBBBBFFLLL\n" +
            "FFBBFFBLLL\n" +
            "BBFBFFBRRR\n" +
            "FBFBFBFLRL\n" +
            "FFFBBBFLRR\n" +
            "BFBBBFBLRR\n" +
            "FBBBBBFLLR\n" +
            "BBFFBBBLRL\n" +
            "FFBFFBFLLR\n" +
            "FFFBBBFRLL\n" +
            "FBFFFBBRLL\n" +
            "BFFBFBFLLR\n" +
            "FFBBBFBRLR\n" +
            "BBFFFBBLRR\n" +
            "BFFFBBFLRL\n" +
            "FFFBBFFLRR\n" +
            "BBBFBBBLLL\n" +
            "BBFBFFFRLL\n" +
            "FFFBBFFRRL\n" +
            "BFBBFFFLRR\n" +
            "BBFFFFBRRR\n" +
            "BBFFFFFLLR\n" +
            "BBFBBBBLRL\n" +
            "FFBFBBBLRL\n" +
            "BBFFFFFRRR\n" +
            "FBFBFFBLLL\n" +
            "BFFBBBFLRR\n" +
            "FFFFFBBRRL\n" +
            "BFFFFFBRRL\n" +
            "BBBFBFFRLL\n" +
            "FBFFBBFLLR\n" +
            "BBBFFBFRRR\n" +
            "BBFBFFFLRR\n" +
            "BBFFBBFLRR\n" +
            "BFBFFBFRRL\n" +
            "FBBBFBBRRR\n" +
            "BBFFBFFLRR\n" +
            "BBFBFFFRLR\n" +
            "FBBBBBFRRL\n" +
            "BFFFBBFLLR\n" +
            "BBFBBFFLLR\n" +
            "FBFFFFFLLR\n" +
            "FFFBBFFRLL\n" +
            "BBFBBFFRLL\n" +
            "FFFFBBBLLL\n" +
            "BFBFFBBRLR\n" +
            "FBBFBBBLLR\n" +
            "BFFBBBFLLR\n" +
            "BFFFFFFLRL\n" +
            "BFFBBBFLLL\n" +
            "BFBFFBFLLL\n" +
            "BBFBFFBLLL\n" +
            "FFBBBBFRLL\n" +
            "FBFFBFFLRR\n" +
            "BBBFFBBRRL\n" +
            "BFFBBFFRRR\n" +
            "BBBBFFFLLR\n" +
            "BFBBFFBRRR\n" +
            "FBFFFBFRLL\n" +
            "FFBBBFFRLL\n" +
            "FBBBBFBLRR\n" +
            "FFFBBFBLRR\n" +
            "FFBBFFFLRR\n" +
            "BBFBBBFLRR\n" +
            "FBFBFFBRLR\n" +
            "FBBFFBBLLR\n" +
            "BBFFBBBLRR\n" +
            "BBFBFFBLLR\n" +
            "FBBFFFBLRL\n" +
            "BFBFBFFLRL\n" +
            "FFFBFFFRLR\n" +
            "FBFBFFFLRL\n" +
            "BBBFFBFRLR\n" +
            "BBBFBBFLLL\n" +
            "FBFBFBBLLR\n" +
            "BFBFBFFLLL\n" +
            "FFBFFFBRRR\n" +
            "BFBFBFFRLR\n" +
            "FFFBBBBLRR\n" +
            "BBFBBFFLRL\n" +
            "FFBFFFFRRL\n" +
            "BFBFFBFLLR\n" +
            "FFBBBBFLLR\n" +
            "FBFBBBBRRR\n" +
            "FFBFFBFLRL\n" +
            "FBBBBBBRLL\n" +
            "BBFBFBBLLL\n" +
            "FBBFFBBRRL\n" +
            "FBBBBBBRRL").split("\n");

    public static void main(String[] args) {
        part1();
        part2();
    }

    private static void part1() {
        List<Integer> seatIds = Arrays.stream(arr)
                .map(Day5::decode).sorted().collect(Collectors.toList());
        System.out.println(seatIds.get(seatIds.size() - 1));
    }

    private static void part2() {
        List<Integer> seatIds = Arrays.stream(arr)
                .map(Day5::decode).sorted().collect(Collectors.toList());
        int start = seatIds.get(0);

        for (Integer seatId : seatIds) {
            if (!seatId.equals(start++)) {
                System.out.println(seatId - 1);
                break;
            }
        }
    }

    private static int decode(String s) {
        final int row = getRow(s.substring(0, 7));
        final int column = getColumn(s.substring(7));

        return row * 8 + column;
    }

    private static int getColumn(String substring) {
        int start = 0;
        int end = 7;

        for (int i = 0; i < substring.length(); i++) {
            if (substring.charAt(i) == 'L') {
                end -= (int) ceil(1.0 * (end - start) / 2);
            } else if (substring.charAt(i) == 'R') {
                start += (int) ceil(1.0 * (end - start) / 2);
            }
        }

        return end;
    }

    private static int getRow(String substring) {
        int start = 0;
        int end = 127;
        for (int i = 0; i < substring.length(); i++) {
            if (substring.charAt(i) == 'F') {
                end -= (int) ceil(1.0 * (end - start) / 2);
            } else if (substring.charAt(i) == 'B') {
                start += (int) ceil(1.0 * (end - start) / 2);
            }
        }
        return end;
    }
}
