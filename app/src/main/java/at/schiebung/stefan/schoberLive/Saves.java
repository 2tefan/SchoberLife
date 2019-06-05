package at.schiebung.stefan.schoberLive;

import android.content.Context;
import android.content.SharedPreferences;

import at.favre.lib.armadillo.Armadillo;
import timber.log.Timber;

class Saves
{
    static void loadSaves(Context context)
    {
        Vars.resetToDefaults();
        SharedPreferences preferences = Armadillo.create(context, context.getString(R.string.prefName)).encryptionFingerprint(context).enableKitKatSupport(true).build();

        Vars.reputation = preferences.getInt(context.getString(R.string.saveReputation), Vars.reputation);
        Vars.grade = preferences.getInt(context.getString(R.string.saveGrade), Vars.grade);
        Vars.parents = preferences.getInt(context.getString(R.string.saveParents), Vars.parents);
        Vars.money = preferences.getInt(context.getString(R.string.saveMoney), Vars.money);
        Vars.loadedSave = preferences.getBoolean(context.getString(R.string.saveLoadedSave), Vars.loadedSave);

        Vars.countPlayedTimes = preferences.getInt(context.getString(R.string.saveCountPlayedTimes), Vars.countPlayedTimes);
        Vars.failedReputation = preferences.getInt(context.getString(R.string.saveFailedReputation), Vars.failedReputation);
        Vars.failedGrade = preferences.getInt(context.getString(R.string.saveFailedGrade), Vars.failedGrade);
        Vars.failedParents = preferences.getInt(context.getString(R.string.saveFailedParents), Vars.failedParents);
        Vars.failedMoney = preferences.getInt(context.getString(R.string.saveFailedMoney), Vars.failedMoney);

        Timber.i("Reputation: %s", Vars.reputation);
        Timber.i("Grade: %s", Vars.grade);
        Timber.i("Parents: %s", Vars.parents);
        Timber.i("Money: %s", Vars.money);
        Timber.i("LoadedSave: %s", Vars.loadedSave);
        Timber.i("CountPlayedTimes: %s", Vars.countPlayedTimes);
    }

    static void saveSaves(Context context)
    {
        SharedPreferences preferences = Armadillo.create(context, context.getString(R.string.prefName)).encryptionFingerprint(context).enableKitKatSupport(true).build();

        preferences.edit().putInt(context.getString(R.string.saveReputation), Vars.reputation).apply();
        preferences.edit().putInt(context.getString(R.string.saveGrade), Vars.grade).apply();
        preferences.edit().putInt(context.getString(R.string.saveParents), Vars.parents).apply();
        preferences.edit().putInt(context.getString(R.string.saveMoney), Vars.money).apply();
        preferences.edit().putBoolean(context.getString(R.string.saveLoadedSave), true).apply();

        preferences.edit().putInt(context.getString(R.string.saveCountPlayedTimes), Vars.countPlayedTimes).apply();
    }
}
