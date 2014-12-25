package com.ads.fish.master;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/6/24.
 */
public class Answer {
    public final static int GATE_MAX = 12;
    public final static List<Integer[]> VALUES = new ArrayList<Integer[]>();
    public final static List<Integer[][]> TS = new ArrayList<Integer[][]>();
    public final static List<Integer[][]> CHALLENGES = new ArrayList<Integer[][]>();
    public final static String[] TITLES = new String[]{"时间已到!", "恭喜您过关了!", "您真牛!", "您真棒!"};
    public final static List<int[]> timeLevels = new ArrayList<int[]>();

    private final static int[] time0 = {0, 60, 90, 170};
    private final static int[] time1 = {0, 80, 110, 190};
    private final static int[] time2 = {0, 100, 130, 210};
    private final static int[] time3 = {0, 120, 150, 230};
    private final static int[] time4 = {0, 140, 180, 240};
    static {
        timeLevels.add(time0);
        timeLevels.add(time1);
        timeLevels.add(time2);
        timeLevels.add(time3);
        timeLevels.add(time4);
    }
    private final static Integer[][] T1 = new Integer[][]{{6, 7, 8, 11, 12, 13, 16, 17, 18}, {6, 7, 8, 11, 12, 13, 16, 17, 18}, {6, 7, 8, 11, 12, 13, 16, 17, 18}, {6, 7, 8, 11, 12, 13, 16, 17, 18}};
    private final static Integer[][] T2 = new Integer[][]{{0, 1, 5}, {0, 1, 6}, {1, 6, 5}, {0, 5, 6}};
    private final static Integer[][] T3 = new Integer[][]{{5, 9, 10, 11, 12, 13, 14, 15, 19}, {1, 2, 3, 7, 12, 17, 21, 22, 23}, {5, 9, 10, 11, 12, 13, 14, 15, 19}, {1, 2, 3, 7, 12, 17, 21, 22, 23}};
    private final static Integer[][] T4 = new Integer[][]{{2, 7, 12, 17, 22}, {10, 11, 12, 13, 14}, {2, 7, 12, 17, 22}, {10, 11, 12, 13, 14}};
    private final static Integer[][] T5 = new Integer[][]{{0, 5, 10, 15, 20, 21, 22, 23, 24}, {0, 1, 2, 3, 4, 5, 10, 15, 20}, {0, 1, 2, 3, 4, 9, 14, 19, 24}, {4, 9, 14, 19, 24, 23, 22, 21, 20}};
    private final static Integer[][] T6 = new Integer[][]{{2, 14, 22, 10}, {2, 14, 22, 10}, {2, 14, 22, 10}, {2, 14, 22, 10}};
    private final static Integer[][] T7 = new Integer[][]{{0, 5, 10, 15, 20, 4, 9, 14, 19, 24}, {0, 1, 2, 3, 4, 20, 21, 22, 23, 24}, {0, 5, 10, 15, 20, 4, 9, 14, 19, 24}, {0, 1, 2, 3, 4, 20, 21, 22, 23, 24}};
    private final static Integer[][] T8 = new Integer[][]{{0, 4, 20, 24}, {0, 4, 20, 24}, {0, 4, 20, 24}, {0, 4, 20, 24}};
    private final static Integer[] A1 = {0, 0};
    private final static Integer[] A2 = {0, 0};
    private final static Integer[] A3 = {0, 0};
    private final static Integer[] A4 = {0, 0};
    private final static Integer[] A5 = {0, 0};
    private final static Integer[] A6 = {0, 0};
    private final static Integer[] A7 = {0, 0};
    private final static Integer[] A8 = {0, 0};
    private final static Integer[] A9 = {0, 0};
    private final static Integer[] A10 = {0, 0};
    private final static Integer[] A11 = {0, 0};
    private final static Integer[] A12 = {0, 0};
    private final static Integer[] A13 = {0, 0};
    private final static Integer[] A14 = {0, 0};
    private final static Integer[] A15 = {0, 0};
    private final static Integer[] A16 = {0, 0};
    private final static Integer[] A17 = {0, 0};
    private final static Integer[] A18 = {0, 0};
    private final static Integer[] A19 = {0, 0};
    private final static Integer[] A20 = {0, 0};
    private final static Integer[] A21 = {0, 0};
    private final static Integer[] A22 = {0, 0};
    private final static Integer[] A23 = {0, 0};
    private final static Integer[] A24 = {0, 0};
    private final static Integer[] A25 = {0, 0};
    private final static Integer[] A26 = {0, 0};
    private final static Integer[] A27 = {0, 0};
    private final static Integer[] A28 = {0, 0};
    private final static Integer[] A29 = {0, 0};
    private final static Integer[] A30 = {0, 0};
    private final static Integer[] A31 = {0, 0};
    private final static Integer[] A32 = {0, 0};
    private final static Integer[] A33 = {0, 0};
    private final static Integer[] A34 = {0, 0};
    private final static Integer[] A35 = {0, 0};
    private final static Integer[] A36 = {0, 0};
    private final static Integer[] A37 = {0, 0};
    private final static Integer[] A38 = {0, 0};
    private final static Integer[] A39 = {0, 0};
    private final static Integer[] A40 = {0, 0};
    private final static Integer[] A41 = {0, 0};
    private final static Integer[] A42 = {0, 0};
    private final static Integer[] A43 = {0, 0};
    private final static Integer[] A44 = {0, 0};
    private final static Integer[] A45 = {0, 0};
    private final static Integer[] A46 = {0, 0};
    private final static Integer[] A47 = {0, 0};
    private final static Integer[] A48 = {0, 0};
    private final static Integer[] A49 = {0, 0};
    private final static Integer[] A50 = {0, 0};
    private final static Integer[] A51 = {0, 0};
    private final static Integer[] A52 = {0, 0};
    private final static Integer[] A53 = {0, 0};
    private final static Integer[] A54 = {0, 0};

    static {
        VALUES.add(A1);
        VALUES.add(A2);
        VALUES.add(A3);
        VALUES.add(A4);
        VALUES.add(A5);
        VALUES.add(A6);
        VALUES.add(A7);
        VALUES.add(A8);
        VALUES.add(A9);
        VALUES.add(A10);
        VALUES.add(A11);
        VALUES.add(A12);
        VALUES.add(A13);
        VALUES.add(A14);
        VALUES.add(A15);
        VALUES.add(A16);
        VALUES.add(A17);
        VALUES.add(A18);
        VALUES.add(A19);
        VALUES.add(A20);
        VALUES.add(A21);
        VALUES.add(A22);
        VALUES.add(A23);
        VALUES.add(A24);
        VALUES.add(A25);
        VALUES.add(A26);
        VALUES.add(A27);
        VALUES.add(A28);
        VALUES.add(A29);
        VALUES.add(A30);
        VALUES.add(A31);
        VALUES.add(A32);
        VALUES.add(A33);
        VALUES.add(A34);
        VALUES.add(A35);
        VALUES.add(A36);
        VALUES.add(A37);
        VALUES.add(A38);
        VALUES.add(A39);
        VALUES.add(A40);
        VALUES.add(A41);
        VALUES.add(A42);
        VALUES.add(A43);
        VALUES.add(A44);
        VALUES.add(A45);
        VALUES.add(A46);
        VALUES.add(A47);
        VALUES.add(A48);
        VALUES.add(A49);
        VALUES.add(A50);
        VALUES.add(A51);
        VALUES.add(A52);
        VALUES.add(A53);
        VALUES.add(A54);
        TS.add(T1);
        TS.add(T2);
        TS.add(T3);
        TS.add(T4);
        TS.add(T5);
        TS.add(T6);
        TS.add(T7);
        TS.add(T8);
    }

    private final static Integer[][] CHALLENGE1 = {
            {2, 3},
            {11, 0},
            {12, 2},
            {14, 0},
            {22, 1}
    };
    private final static Integer[][] CHALLENGE2 = {
            {0, 0, 0, 0, 0, 0, 0, 1, 0},
            {5, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 7, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 8},
            {0, 0, 9, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 6, 0, 0, 0},
            {0, 3, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 2, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 4, 0, 0}
    };
    private final static Integer[][] CHALLENGE3 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 9},
            {0, 0, 0, 0, 0, -3, 0, 0, 0},
            {0, 7, 0, 0, 0, 0, 0, 0, 0},
            {6, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 2, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 8, 0, 0},
            {0, 0, 0, 0, 4, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, -5}
    };
    private final static Integer[][] CHALLENGE4 = {
            {0, 0, 0, 0, 8, 0, 0, 0, 0},
            {0, 0, -2, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 3, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 6, 0, 0, 0, 0, 0, 0, 0},
            {5, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 4, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 0}
    };
    private final static Integer[][] CHALLENGE5 = {
            {0, 0, 0, 0, 7, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 5, 0},
            {0, 0, 0, -1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 9, 0, 0},
            {0, 6, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, -8, 0, 0, 0},
            {0, 0, 0, -2, 0, -2, 0, 0, 0},
            {3, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 4, 0, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE6 = {
            {0, 3, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 4, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, -2, -2},
            {0, 0, 0, 0, 6, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, -7, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 8, 0, 0, 0, 0, 0, 0},
            {9, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, -5}
    };
    private final static Integer[][] CHALLENGE7 = {
            {1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, -6, 0, -6, -6, 0, 0, 0, 0},
            {0, 0, 5, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, -2, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 9, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 4},
            {0, -8, 0, 0, -8, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 7, 0, 0}
    };
    private final static Integer[][] CHALLENGE8 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 7},
            {8, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, -4, 0, 0, -4, 0, 0, 0},
            {9, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 5, 0, 0, 0, 0},
            {0, 0, -6, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, -2, 0, 0, 0},
            {0, -1, -1, 0, 0, -1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 3, 0}
    };
    private final static Integer[][] CHALLENGE9 = {
            {-8, 0, 0, 0, 0, 0, -8, 0, -8},
            {0, 0, 0, 0, 0, 0, 0, 0, -2},
            {0, 3, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 4, 0, 4},
            {0, 0, 0, 0, 0, 0, 0, 6, 0},
            {0, 0, 0, 0, 0, 9, 0, 0, 0},
            {0, 0, 0, 0, 7, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, -1, 0, 0},
            {0, 0, 0, 5, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE10 = {
            {0, 0, 0, 0, 0, 5, 0, 0, 0},
            {0, 0, -1, 0, 0, 0, -1, -1, 0},
            {0, 4, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 9, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 6, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, -2, -2},
            {0, 0, 0, 0, 0, 0, -8, -8, 0},
            {0, 0, -3, 0, 0, 0, -3, 0, 0},
            {7, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE11 = {
            {0, -7, 0, -7, 0, -7, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 6},
            {0, -9, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 4, 0, 0, 0, 0},
            {0, -2, 0, 0, 0, -2, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 3, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 5, 0}
    };
    private final static Integer[][] CHALLENGE12 = {
            {0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, -5, 0, -5, 0, -5, 0, 0},
            {0, 4, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, -8, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 9, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 6},
            {0, 0, -3, 0, -3, -3, -3, 0, 0},
            {0, 0, -7, 0, -7, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE13 = {
            {0, 0, 0, 0, 0, 0, 7, 0, 0},
            {0, 0, -2, 0, 0, -2, 0, 0, 0},
            {0, 0, 0, 8, 0, 0, 0, 0, 0},
            {0, -3, -3, 0, 0, -3, 0, 0, 0},
            {4, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 6, 0, 0, 0, 0},
            {0, -1, -1, 0, 0, -1, 0, 0, -1},
            {0, 0, -5, 0, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE14 = {
            {0, -4, -4, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 2, 0},
            {0, 0, -5, 0, 0, 0, 0, 0, 0},
            {0, -8, -8, 0, -8, 0, 0, 0, -8},
            {0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, -3, -3, 0, 0, 0, 0, 0, -3},
            {0, 0, 0, 0, 0, 0, 9, 0, 0},
            {6, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE15 = {
            {0, 6, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 4},
            {-5, 0, 0, -5, -5, -5, 0, -5, 0},
            {-2, 0, 0, -2, 0, -2, 0, -2, 0},
            {0, 0, 0, 0, 0, -3, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, -8, 0, -8, 0, -8, 0},
            {0, 0, 0, -9, 0, -9, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE16 = {
            {-4, 0, -4, 0, 0, -4, 0, 0, -4},
            {0, 5, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, -6, 0, 0, -6, 0, 0, -6},
            {0, 0, 0, 0, 3, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, -1, 0, 0, -1},
            {0, 0, 0, 0, 0, 0, 0, 8, 0},
            {-7, 0, -7, -7, 0, -7, 0, 0, -7},
            {0, 0, 0, 0, 0, 0, 0, 0, -2}
    };
    private final static Integer[][] CHALLENGE17 = {
            {4, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, -8, 0, 0, -8, -8, 0},
            {0, 0, 0, 0, 0, 0, 0, -1, 0},
            {170, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 7, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 2},
            {0, 0, -6, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, -3, -3, 0}
    };
    private final static Integer[][] CHALLENGE18 = {
            {0, 0, -8, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, -5, 0, -5, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 7},
            {0, 0, 0, 0, 0, 0, 1, 0, 0},
            {-9, 0, -9, -9, -9, -9, 0, 0, 0},
            {0, 0, 0, -3, -3, 0, 0, 0, 0},
            {0, 0, 0, -4, -4, -4, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 2, 0},
            {180, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE19 = {
            {190, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, -5, 0, 0, 0, 0, 0, -5, 0},
            {0, -3, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 4, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 0, 0},
            {191, 0, 0, 0, 0, 0, 0, 0, 0},
            {-6, -6, 0, 0, 0, 0, 0, -6, 0}
    };
    private final static Integer[][] CHALLENGE20 = {
            {0, 0, 0, -3, -3, 0, 0, 0, 0},
            {200, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, -8, -8, 0, -8, 0, 0},
            {9, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 4, 0, 0, 0, 0, 0, 0},
            {201, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, -1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 6, 0},
            {0, 0, 0, -7, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE21 = {
            {7, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 5, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 9, 0, 0, 0, 0, 0, 0},
            {210, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, -4, -4, -4, -4, 0, 0},
            {0, 0, 0, -6, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, -2, -2, 0},
            {0, 0, 0, -1, 0, -1, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE22 = {
            {0, 0, 4, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, -9, -9, 0, 0, -9},
            {0, 0, 0, 0, 0, 0, 0, 2, 0},
            {0, 0, 0, 0, -5, 0, 0, 0, 0},
            {220, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 7, 0, 0, 0, 0, 0},
            {221, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, -3, 0, 0, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE23 = {
            {230, 0, 0, 0, 0, 0, 0, 0, 0},
            {7, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, -9, 0, 0, 0, 0, 0, -9, 0},
            {231, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, -1, 0, 0, -1, -1, 0, -1, 0},
            {0, 0, 0, 6, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 8, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, -3, 0}
    };
    private final static Integer[][] CHALLENGE24 = {
            {0, -7, 0, -7, 0, 0, 0, 0, 0},
            {0, -3, -3, -3, -3, -3, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 6},
            {2, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, -1, 0, 0, 0, 0, 0},
            {240, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, -5, 0, 0, -5, -5, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 8, 0, 0}
    };
    private final static Integer[][] CHALLENGE25 = {
            {0, 0, 0, 0, 1, 0, 0, 0, 0},
            {250, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, -5, -5, 0, -5, 0, 0, 0},
            {251, 0, 0, 0, 0, 0, 0, 0, 0},
            {-3, 0, 0, -3, 0, -3, 0, 0, 0},
            {252, 0, 0, 0, 0, 0, 0, 0, 0},
            {-2, -2, -2, -2, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE26 = {
            {260, 0, 0, 0, 0, 0, 0, 0, 0},
            {261, 0, 0, 0, 0, 0, 0, 0, 0},
            {262, 0, 0, 0, 0, 0, 0, 0, 0},
            {10, 0, 10, 10, 0, 10, 0, 10, 0},
            {0, -8, 0, 0, -8, 0, 0, 0, 0},
            {0, -3, 0, 0, 0, 0, 0, 0, 0},
            {0, -1, 0, 0, -1, 0, 0, 0, -1},
            {0, 0, 0, 0, 0, 0, 0, -6, 0}
    };
    private final static Integer[][] CHALLENGE27 = {
            {270, 0, 0, 0, 0, 0, 0, 0, 0},
            {271, 0, 0, 0, 0, 0, 0, 0, 0},
            {-1, 0, -1, 0, 0, 0, 0, 0, -1},
            {0, 9, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, -2, 0, -2, 0, 0, 0},
            {0, 0, -8, 0, 0, 0, 0, 0, -8},
            {0, 0, 0, 0, 0, 0, 0, 7, 0},
            {0, 0, 0, -3, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, -6}
    };
    private final static Integer[][] CHALLENGE28 = {
            {0, 0, 0, 0, 0, -8, 0, -8, -8},
            {0, 0, 0, 0, 0, -5, 0, 0, -5},
            {0, 0, 0, 0, 0, 0, 3, 0, 0},
            {0, 0, 6, 0, 0, 0, 0, 0, 0},
            {280, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, -7, 0, 0, 0},
            {0, 0, 0, 0, -4, 0, 0, 0, 0},
            {0, 0, 0, 0, -1, 0, 0, 0, 0},
            {281, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE29 = {
            {290, 0, 0, 0, 0, 0, 0, 0, 0},
            {291, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 9, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, -7, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, -2, 0, 0, 0, 0, 0},
            {0, 0, 0, -8, 0, 0, -8, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 6, 0}
    };
    private final static Integer[][] CHALLENGE30 = {
            {0, 0, 0, -6, 0, -6, 0, -6, 0},
            {0, 0, 0, 0, 0, 0, 9, 0, 0},
            {0, 0, 0, -7, 0, 0, 0, 0, 0},
            {300, 0, 0, 0, 0, 0, 0, 0, 0},
            {-4, 0, -4, -4, 0, -4, 0, -4, 0},
            {-3, 0, 0, 0, 0, 0, 0, -3, 0},
            {0, 5, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 8}
    };
    private final static Integer[][] CHALLENGE31 = {
            {310, 0, 0, 0, 0, 0, 0, 0, 0},
            {311, 0, 0, 0, 0, 0, 0, 0, 0},
            {312, 0, 0, 0, 0, 0, 0, 0, 0},
            {10, 10, 10, 10, 10, 0, 0, 0, 0},
            {10, 10, 0, 10, 10, 0, 0, 0, 0},
            {0, 0, 0, 10, 10, 10, 0, 0, 0},
            {313, 0, 0, 0, 0, 0, 0, 0, 0},
            {314, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {10, 0, 0, 0, 10, 0, 10, 10, 0},
            {0, 0, 0, 0, 0, 10, 10, 0, 10},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE32 = {
            {320, 0, 0, 0, 0, 0, 0, 0, 0},
            {321, 0, 0, 0, 0, 0, 0, 0, 0},
            {322, 0, 0, 0, 0, 0, 0, 0, 0},
            {10, 10, 10, 0, 0, 10, 0, 0, 0},
            {0, 0, 10, 0, 10, 0, 10, 0, 0},
            {0, 0, 0, 0, 0, 10, 0, 10, 10},
            {323, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {10, 0, 0, 0, 0, 0, 10, 0, 10},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE33 = {
            {330, 0, 0, 0, 0, 0, 0, 0, 0},
            {331, 0, 0, 0, 0, 0, 0, 0, 0},
            {332, 0, 0, 0, 0, 0, 0, 0, 0},
            {10, 10, 10, 0, 0, 10, 0, 0, 0},
            {10, 10, 10, 10, 0, 0, 10, 0, 10},
            {0, 0, 10, 10, 10, 10, 0, 0, 0},
            {333, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {10, 0, 0, 0, 0, 0, 0, 10, 10},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE34 = {
            {340, 0, 0, 0, 0, 0, 0, 0, 0},
            {341, 0, 0, 0, 0, 0, 0, 0, 0},
            {342, 0, 0, 0, 0, 0, 0, 0, 0},
            {10, 10, 0, 10, 10, 0, 0, 0, 0},
            {0, 0, 0, 0, 10, 10, 0, 10, 10},
            {10, 0, 10, 0, 0, 0, 10, 0, 10},
            {343, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 10, 0, 0, 10, 10, 10},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE35 = {
            {350, 0, 0, 0, 0, 0, 0, 0, 0},
            {351, 0, 0, 0, 0, 0, 0, 0, 0},
            {352, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 10, 0, 10, 0, 10, 10, 10, 10},
            {0, 10, 10, 0, 10, 0, 10, 10, 0},
            {10, 10, 10, 10, 0, 10, 10, 0, 0},
            {353, 0, 0, 0, 0, 0, 0, 0, 0},
            {354, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {10, 0, 10, 0, 10, 10, 0, 10, 10},
            {10, 0, 0, 10, 10, 10, 10, 10, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE36 = {
            {360, 0, 0, 0, 0, 0, 0, 0, 0},
            {361, 0, 0, 0, 0, 0, 0, 0, 0},
            {362, 0, 0, 0, 0, 0, 0, 0, 0},
            {10, 10, 10, 0, 10, 0, 10, 0, 10},
            {10, 0, 10, 0, 10, 0, 10, 10, 10},
            {10, 0, 10, 10, 10, 0, 10, 0, 10},
            {363, 0, 0, 0, 0, 0, 0, 0, 0},
            {364, 0, 0, 0, 0, 0, 0, 0, 0},
            {365, 0, 0, 0, 0, 0, 0, 0, 0},
            {10, 0, 0, 0, 10, 0, 10, 0, 0},
            {10, 0, 10, 0, 10, 0, 0, 0, 0},
            {0, 0, 10, 0, 10, 0, 0, 0, 10}
    };
    private final static Integer[][] CHALLENGE37 = {
            {370, 0, 0, 0, 0, 0, 0, 0, 0},
            {371, 0, 0, 0, 0, 0, 0, 0, 0},
            {372, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 10, 10, 10, 10, 0, 0, 0, 0},
            {0, 10, 0, 0, 10, 10, 0, 0, 10},
            {0, 0, 0, 0, 10, 10, 10, 10, 0},
            {373, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {10, 0, 0, 10, 10, 0, 0, 10, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE38 = {
            {380, 0, 0, 0, 0, 0, 0, 0, 0},
            {381, 0, 0, 0, 0, 0, 0, 0, 0},
            {382, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 10, 10, 0, 10, 0, 0, 10, 0},
            {0, 10, 0, 0, 10, 0, 10, 10, 0},
            {10, 10, 0, 10, 10, 0, 0, 0, 0},
            {383, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 10, 10, 10, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE39 = {
            {390, 0, 0, 0, 0, 0, 0, 0, 0},
            {391, 0, 0, 0, 0, 0, 0, 0, 0},
            {392, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 10, 10, 10},
            {10, 10, 10, 0, 0, 0, 0, 0, 0},
            {0, 0, 10, 0, 0, 10, 0, 0, 10},
            {393, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {10, 0, 0, 10, 0, 0, 10, 0, 0},
            {394, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE40 = {
            {400, 0, 0, 0, 0, 0, 0, 0, 0},
            {401, 0, 0, 0, 0, 0, 0, 0, 0},
            {402, 0, 0, 0, 0, 0, 0, 0, 0},
            {10, 0, 0, 0, 10, 0, 10, 0, 0},
            {0, 0, 0, 10, 10, 10, 0, 0, 0},
            {10, 10, 10, 0, 0, 0, 0, 0, 0},
            {403, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 10, 0, 0, 0, 0, 10, 0},
            {0, -6, -6, 0, 0, -6, 0, -6, -6},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
    };
    private final static Integer[][] CHALLENGE41 = {
            {0, 0, -5, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 9, 0, 0},
            {-4, 0, 0, 0, 0, 0, 0, 0, 0},
            {410, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, -7, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 6, 0},
            {411, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, -2, 0, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE42 = {
            {420, 0, 0, 0, 0, 0, 0, 0, 0},
            {421, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, -1, 0, 0, 0, 0},
            {10, 0, 10, 0, 10, 0, 10, 0, 10},
            {0, 0, 0, 0, 0, 9, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, -6},
            {0, 0, 4, 0, 0, 0, 0, 0, 0},
            {0, 0, -2, 0, 0, 0, 0, 0, 0},
            {0, -8, 0, 0, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE43 = {
            {430, 0, 0, 0, 0, 0, 0, 0, 0},
            {431, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 9, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 2, 0, 0, 0, 0},
            {0, 0, 0, -8, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, -3, 0},
            {0, 0, 0, 0, 0, -6, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE44 = {
            {440, 0, 0, 0, 0, 0, 0, 0, 0},
            {441, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, -1, 0, -1, 0, 0, 0, 0},
            {10, 10, 10, 0, 10, 0, 0, 10, 0},
            {0, 0, 0, 0, -8, 0, 0, 0, 0},
            {0, 0, 0, -5, 0, -5, -5, 0, 0},
            {0, -6, -6, 0, -6, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, -9, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE45 = {
            {450, 0, 0, 0, 0, 0, 0, 0, 0},
            {451, 0, 0, 0, 0, 0, 0, 0, 0},
            {452, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, -7, 0, -7, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 2, 0, 0},
            {0, 0, 0, 4, 0, 0, 0, 0, 0},
            {0, 0, 3, 0, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE46 = {
            {460, 0, 0, 0, 0, 0, 0, 0, 0},
            {461, 0, 0, 0, 0, 0, 0, 0, 0},
            {462, 0, 0, 0, 0, 0, 0, 0, 0},
            {463, 0, 0, 0, 0, 0, 0, 0, 0},
            {464, 0, 0, 0, 0, 0, 0, 0, 0},
            {465, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE47 = {
            {470, 0, 0, 0, 0, 0, 0, 0, 0},
            {471, 0, 0, 0, 0, 0, 0, 0, 0},
            {472, 0, 0, 0, 0, 0, 0, 0, 0},
            {473, 0, 0, 0, 0, 0, 0, 0, 0},
            {474, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE48 = {
            {480, 0, 0, 0, 0, 0, 0, 0, 0},
            {481, 0, 0, 0, 0, 0, 0, 0, 0},
            {482, 0, 0, 0, 0, 0, 0, 0, 0},
            {483, 0, 0, 0, 0, 0, 0, 0, 0},
            {484, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE49 = {
            {490, 0, 0, 0, 0, 0, 0, 0, 0},
            {491, 0, 0, 0, 0, 0, 0, 0, 0},
            {492, 0, 0, 0, 0, 0, 0, 0, 0},
            {493, 0, 0, 0, 0, 0, 0, 0, 0},
            {494, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE50 = {
            {500, 0, 0, 0, 0, 0, 0, 0, 0},
            {501, 0, 0, 0, 0, 0, 0, 0, 0},
            {502, 0, 0, 0, 0, 0, 0, 0, 0},
            {503, 0, 0, 0, 0, 0, 0, 0, 0},
            {504, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE51 = {
            {510, 0, 0, 0, 0, 0, 0, 0, 0},
            {511, 0, 0, 0, 0, 0, 0, 0, 0},
            {512, 0, 0, 0, 0, 0, 0, 0, 0},
            {513, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE52 = {
            {520, 0, 0, 0, 0, 0, 0, 0, 0},
            {521, 0, 0, 0, 0, 0, 0, 0, 0},
            {522, 0, 0, 0, 0, 0, 0, 0, 0},
            {523, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE53 = {
            {530, 0, 0, 0, 0, 0, 0, 0, 0},
            {531, 0, 0, 0, 0, 0, 0, 0, 0},
            {532, 0, 0, 0, 0, 0, 0, 0, 0},
            {533, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE54 = {
            {540, 0, 0, 0, 0, 0, 0, 0, 0},
            {541, 0, 0, 0, 0, 0, 0, 0, 0},
            {542, 0, 0, 0, 0, 0, 0, 0, 0},
            {543, 0, 0, 0, 0, 0, 0, 0, 0},
            {544, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE55 = {
            {550, 0, 0, 0, 0, 0, 0, 0, 0},
            {551, 0, 0, 0, 0, 0, 0, 0, 0},
            {552, 0, 0, 0, 0, 0, 0, 0, 0},
            {553, 0, 0, 0, 0, 0, 0, 0, 0},
            {554, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE56 = {
            {560, 0, 0, 0, 0, 0, 0, 0, 0},
            {561, 0, 0, 0, 0, 0, 0, 0, 0},
            {562, 0, 0, 0, 0, 0, 0, 0, 0},
            {563, 0, 0, 0, 0, 0, 0, 0, 0},
            {564, 0, 0, 0, 0, 0, 0, 0, 0},
            {565, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE57 = {
            {570, 0, 0, 0, 0, 0, 0, 0, 0},
            {571, 0, 0, 0, 0, 0, 0, 0, 0},
            {572, 0, 0, 0, 0, 0, 0, 0, 0},
            {573, 0, 0, 0, 0, 0, 0, 0, 0},
            {574, 0, 0, 0, 0, 0, 0, 0, 0},
            {575, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE58 = {
            {580, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE59 = {
            {590, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private final static Integer[][] CHALLENGE60 = {
            {600, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    static {
        CHALLENGES.add(CHALLENGE1);
        CHALLENGES.add(CHALLENGE2);
        CHALLENGES.add(CHALLENGE3);
        CHALLENGES.add(CHALLENGE4);
        CHALLENGES.add(CHALLENGE5);
        CHALLENGES.add(CHALLENGE6);
        CHALLENGES.add(CHALLENGE7);
        CHALLENGES.add(CHALLENGE8);
        CHALLENGES.add(CHALLENGE9);
        CHALLENGES.add(CHALLENGE10);
        CHALLENGES.add(CHALLENGE11);
        CHALLENGES.add(CHALLENGE12);
        CHALLENGES.add(CHALLENGE13);
        CHALLENGES.add(CHALLENGE14);
        CHALLENGES.add(CHALLENGE15);
        CHALLENGES.add(CHALLENGE16);
        CHALLENGES.add(CHALLENGE17);
        CHALLENGES.add(CHALLENGE18);
        CHALLENGES.add(CHALLENGE19);
        CHALLENGES.add(CHALLENGE20);
        CHALLENGES.add(CHALLENGE21);
        CHALLENGES.add(CHALLENGE22);
        CHALLENGES.add(CHALLENGE23);
        CHALLENGES.add(CHALLENGE24);
        CHALLENGES.add(CHALLENGE25);
        CHALLENGES.add(CHALLENGE26);
        CHALLENGES.add(CHALLENGE27);
        CHALLENGES.add(CHALLENGE28);
        CHALLENGES.add(CHALLENGE29);
        CHALLENGES.add(CHALLENGE30);
        CHALLENGES.add(CHALLENGE31);
        CHALLENGES.add(CHALLENGE32);
        CHALLENGES.add(CHALLENGE33);
        CHALLENGES.add(CHALLENGE34);
        CHALLENGES.add(CHALLENGE35);
        CHALLENGES.add(CHALLENGE36);
        CHALLENGES.add(CHALLENGE37);
        CHALLENGES.add(CHALLENGE38);
        CHALLENGES.add(CHALLENGE39);
        CHALLENGES.add(CHALLENGE40);
        CHALLENGES.add(CHALLENGE41);
        CHALLENGES.add(CHALLENGE42);
        CHALLENGES.add(CHALLENGE43);
        CHALLENGES.add(CHALLENGE44);
        CHALLENGES.add(CHALLENGE45);
        CHALLENGES.add(CHALLENGE46);
        CHALLENGES.add(CHALLENGE47);
        CHALLENGES.add(CHALLENGE48);
        CHALLENGES.add(CHALLENGE49);
        CHALLENGES.add(CHALLENGE50);
        CHALLENGES.add(CHALLENGE51);
        CHALLENGES.add(CHALLENGE52);
        CHALLENGES.add(CHALLENGE53);
        CHALLENGES.add(CHALLENGE54);
        CHALLENGES.add(CHALLENGE55);
        CHALLENGES.add(CHALLENGE56);
        CHALLENGES.add(CHALLENGE57);
        CHALLENGES.add(CHALLENGE58);
        CHALLENGES.add(CHALLENGE59);
        CHALLENGES.add(CHALLENGE60);
    }

    public static List<Integer> gateStars = new ArrayList<Integer>();

    public static boolean isLasterSmallGate(int nextGateNum) {
        return nextGateNum == 12 || nextGateNum == 24 || nextGateNum == 36 || nextGateNum == 48 || nextGateNum == 60;
    }

    public static int getLevel() {
        return Settings.unlockGateNum / 12;
    }
}
