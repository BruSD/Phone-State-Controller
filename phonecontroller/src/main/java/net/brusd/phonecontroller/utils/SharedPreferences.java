package net.brusd.phonecontroller.utils;

import android.content.Context;

import net.brusd.phonecontroller.Constant;

/**
 * Created by BruSD on 6/16/2014.
 */
public class SharedPreferences {

    public static final String PREFS_NAME = Constant.PROJECT_NAME + "StateSettings";
    public static final String GLOBAL_VOLUME_MODE = Constant.PROJECT_NAME + "GlobalMode";

    private static android.content.SharedPreferences settings;
    private static Context context = null;

    public static android.content.SharedPreferences getSP(Context _context) {
        context = _context;
        android.content.SharedPreferences settingsTemp = context.getSharedPreferences(PREFS_NAME, 0);
        return settingsTemp;
    }

    public static int getFullVolumeValue(Context context) {
        settings = getSP(context);
        return settings.getInt(Constant.PROJECT_NAME + Constant.FULL_VOLUME_MODE, 100);
    }

    public static void setFullVolumeValue(Context context, int volume) {
        settings = getSP(context);

        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putInt(Constant.PROJECT_NAME + Constant.FULL_VOLUME_MODE, volume);
        // Commit the edits!
        editor.commit();
    }
    public static int getMediumVolumeValue(Context context) {
        settings = getSP(context);
        return settings.getInt(Constant.PROJECT_NAME + Constant.MEDIUM_VOLUME_MODE, 50);
    }

    public static void setMediumVolumeValue(Context context, int volume) {
        settings = getSP(context);

        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putInt(Constant.PROJECT_NAME + Constant.MEDIUM_VOLUME_MODE, volume);
        // Commit the edits!
        editor.commit();
    }

    public static int getSilentVolumeValue(Context context) {
        settings = getSP(context);
        return settings.getInt(Constant.PROJECT_NAME + Constant.SILENT_VOLUME_MODE, 0);
    }

    public static void setSilentVolumeValue(Context context, int volume) {
        settings = getSP(context);

        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putInt(Constant.PROJECT_NAME + Constant.SILENT_VOLUME_MODE, volume);
        // Commit the edits!
        editor.commit();
    }
    public static int getGlobalVolumeMode(Context context) {
        settings = getSP(context);
        return settings.getInt(GLOBAL_VOLUME_MODE, 0);
    }

    public static void setGlobalVolumeMode(Context context, int modeID) {
        settings = getSP(context);

        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putInt(GLOBAL_VOLUME_MODE, modeID);
        // Commit the edits!
        editor.commit();
    }
}
