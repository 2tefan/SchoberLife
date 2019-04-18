package at.schiebung.stefan.schober0021;

import android.content.Context;

public class Saves
{
	public static void loadSaves(Context context)
	{
		SecurePreferences preferences = new SecurePreferences(context,
		                                                      Vars.preferences_name,
		                                                      Vars.preferences_key,
		                                                      true);
	}

	public static void saveSaves(Context context)
	{
		SecurePreferences preferences = new SecurePreferences(context,
		                                                      Vars.preferences_name,
		                                                      Vars.preferences_key,
		                                                      true);
	}
}
