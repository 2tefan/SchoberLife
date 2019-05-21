package at.schiebung.stefan.schober0021;

import android.content.Context;
import android.content.SharedPreferences;

import at.favre.lib.armadillo.Armadillo;
import timber.log.Timber;

class Saves
{
    static void loadSaves(Context context)
    {
        SharedPreferences preferences = Armadillo.create(context, context.getString(R.string.prefName)).encryptionFingerprint(context).enableKitKatSupport(true).build();

        Vars.reputation = preferences.getInt(context.getString(R.string.reputation), Vars.reputation);
        Vars.grade = preferences.getInt(context.getString(R.string.grade), Vars.grade);
        Vars.parents = preferences.getInt(context.getString(R.string.parents), Vars.parents);
        Vars.money = preferences.getInt(context.getString(R.string.money), Vars.money);
        Vars.loadedSave = preferences.getBoolean(context.getString(R.string.loadedSave), Vars.loadedSave);

        Vars.countPlayedTimes = preferences.getInt(context.getString(R.string.countPlayedTimes), Vars.countPlayedTimes);

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

        preferences.edit().putInt(context.getString(R.string.reputation), Vars.reputation).apply();
        preferences.edit().putInt(context.getString(R.string.grade), Vars.grade).apply();
        preferences.edit().putInt(context.getString(R.string.parents), Vars.parents).apply();
        preferences.edit().putInt(context.getString(R.string.money), Vars.money).apply();
        preferences.edit().putBoolean(context.getString(R.string.loadedSave), true).apply();

        preferences.edit().putInt(context.getString(R.string.countPlayedTimes), Vars.countPlayedTimes).apply();
    }
}
