package com.schober.schoberLife;

class Vars
{
    private static final int     defaultReputation = 500;
    private static final int     defaultGrade      = 500;
    private static final int     defaultParents    = 500;
    private static final int     defaultMoney      = 500;
    private static final boolean defaultLoadedSave = false;

    private static final int defaultCountPlayedTimes = 0;
    private static final int defaultFailedReputation = 0;
    private static final int defaultFailedGrade      = 0;
    private static final int defaultFailedParents    = 0;
    private static final int defaultFailedMoney      = 0;

    static int     reputation;
    static int     grade;
    static int     parents;
    static int     money;
    static boolean loadedSave;

    static int countPlayedTimes;
    static int failedReputation;
    static int failedGrade;
    static int failedParents;
    static int failedMoney;

    static void resetToDefaults()
    {
        reputation = defaultReputation;
        grade = defaultGrade;
        parents = defaultParents;
        money = defaultMoney;
        loadedSave = defaultLoadedSave;

        countPlayedTimes = defaultCountPlayedTimes;
        failedReputation = defaultFailedReputation;
        failedGrade = defaultFailedGrade;
        failedParents = defaultFailedParents;
        failedMoney = defaultFailedMoney;
    }
}
