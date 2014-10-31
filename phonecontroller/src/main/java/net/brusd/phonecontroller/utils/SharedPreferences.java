package net.brusd.phonecontroller.utils;

import android.content.Context;

import net.brusd.phonecontroller.Constant;

/**
 * Created by BruSD on 6/16/2014.
 */
public class SharedPreferences {

    public static final String PREFS_NAME = Constant.PROJECT_NAME + "StateSettings";

    public static final String GLOBAL_VOLUME_MODE = Constant.PROJECT_NAME + "GlobalMode";
    public static final String GLOBAL_DISCONECTED_MODE = Constant.PROJECT_NAME + "GLOBAL_DISCONECTED_MODE";

    //Full Volume
    public static final String FULL_RING_VOLUME_MODE = Constant.PROJECT_NAME + "FULL_RING_VOLUME_MODE";
    public static final String FULL_ALARM_VOLUME_MODE = Constant.PROJECT_NAME + "FULL_ALARM_VOLUME_MODE";
    public static final String FULL_NOTIFICATION_VOLUME_MODE = Constant.PROJECT_NAME + "FULL_NOTIFICATION_VOLUME_MODE";

    public static final String FULL_RING_BOOL = Constant.PROJECT_NAME + "FULL_RING_BOOL";
    public static final String FULL_ALARM_BOOL = Constant.PROJECT_NAME + "FULL_ALARM_BOOL";
    public static final String FULL_NOTIFICATION_BOOL = Constant.PROJECT_NAME + "FULL_NOTIFICATION_BOOL";

    //Medium Volume
    public static final String MEDIUM_RING_VOLUME_MODE = Constant.PROJECT_NAME + "MEDIUM_RING_VOLUME_MODE";
    public static final String MEDIUM_ALARM_VOLUME_MODE = Constant.PROJECT_NAME + "MEDIUM_ALARM_VOLUME_MODE";
    public static final String MEDIUM_NOTIFICATION_VOLUME_MODE = Constant.PROJECT_NAME + "MEDIUM_NOTIFICATION_VOLUME_MODE";

    public static final String MEDIUM_RING_BOOL = Constant.PROJECT_NAME + "MEDIUM_RING_BOOL";
    public static final String MEDIUM_ALARM_BOOL = Constant.PROJECT_NAME + "MEDIUM_ALARM_BOOL";
    public static final String MEDIUM_NOTIFICATION_BOOL = Constant.PROJECT_NAME + "MEDIUM_NOTIFICATION_BOOL";

    //Medium Volume
    public static final String SILENT_RING_VOLUME_MODE = Constant.PROJECT_NAME + "SILENT_RING_VOLUME_MODE";
    public static final String SILENT_ALARM_VOLUME_MODE = Constant.PROJECT_NAME + "SILENT_ALARM_VOLUME_MODE";
    public static final String SILENT_NOTIFICATION_VOLUME_MODE = Constant.PROJECT_NAME + "SILENT_NOTIFICATION_VOLUME_MODE";

    public static final String SILENT_RING_BOOL = Constant.PROJECT_NAME + "SILENT_RING_BOOL";
    public static final String SILENT_ALARM_BOOL = Constant.PROJECT_NAME + "SILENT_ALARM_BOOL";
    public static final String SILENT_NOTIFICATION_BOOL = Constant.PROJECT_NAME + "SILENT_NOTIFICATION_BOOL";


    private static android.content.SharedPreferences settings;
    private static Context context = null;

    public static android.content.SharedPreferences getSP(Context _context) {
        context = _context;
        android.content.SharedPreferences settingsTemp = context.getSharedPreferences(PREFS_NAME, 0);
        return settingsTemp;
    }


    //    region Global

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

    public static int getDisconetedModeID(Context context) {
        settings = getSP(context);
        return settings.getInt(GLOBAL_DISCONECTED_MODE, Constant.MODE_FULL);
    }

    public static void setDisconetedModeID(Context context, int modeID) {
        settings = getSP(context);

        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putInt(GLOBAL_DISCONECTED_MODE, modeID);
        // Commit the edits!
        editor.commit();
    }
//  endregion

    //region Full
    public static int getFullRingVolume(Context context) {
        settings = getSP(context);
        return settings.getInt(FULL_RING_VOLUME_MODE, 100);
    }

    public static void setFullRingVolume(Context context, int value) {
        settings = getSP(context);

        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putInt(FULL_RING_VOLUME_MODE, value);
        // Commit the edits!
        editor.commit();
    }

    public static int getFullAlarmVolume(Context context) {
        settings = getSP(context);
        return settings.getInt(FULL_ALARM_VOLUME_MODE, 100);
    }

    public static void setFullAlarmVolume(Context context, int value) {
        settings = getSP(context);

        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putInt(FULL_ALARM_VOLUME_MODE, value);
        // Commit the edits!
        editor.commit();
    }

    public static int getFullNotification(Context context) {
        settings = getSP(context);
        return settings.getInt(FULL_NOTIFICATION_VOLUME_MODE, 100);
    }

    public static void setFullNotification(Context context, int value) {
        settings = getSP(context);

        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putInt(FULL_NOTIFICATION_VOLUME_MODE, value);
        // Commit the edits!
        editor.commit();
    }

    public static boolean getFullRingBool(Context context) {
        settings = getSP(context);
        return settings.getBoolean(FULL_RING_BOOL, true);
    }

    public static void setFullRingBool(Context context, boolean value) {
        settings = getSP(context);

        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(FULL_RING_BOOL, value);
        // Commit the edits!
        editor.commit();
    }

    public static boolean getFullAlarmBool(Context context) {
        settings = getSP(context);
        return settings.getBoolean(FULL_ALARM_BOOL, true);
    }

    public static void setFullAlarmBool(Context context, boolean value) {
        settings = getSP(context);

        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(FULL_ALARM_BOOL, value);
        // Commit the edits!
        editor.commit();
    }

    public static boolean getFullNotificationBool(Context context) {
        settings = getSP(context);
        return settings.getBoolean(FULL_NOTIFICATION_BOOL, true);
    }

    public static void setFullNotificationBool(Context context, boolean value) {
        settings = getSP(context);

        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(FULL_NOTIFICATION_BOOL, value);
        // Commit the edits!
        editor.commit();
    }
    //endregion

    //region Medium
    public static int getMediumRingVolume(Context context) {
        settings = getSP(context);
        return settings.getInt(MEDIUM_RING_VOLUME_MODE, 50);
    }

    public static void setMediumRingVolume(Context context, int value) {
        settings = getSP(context);

        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putInt(MEDIUM_RING_VOLUME_MODE, value);
        // Commit the edits!
        editor.commit();
    }

    public static int getMediumAlarmVolume(Context context) {
        settings = getSP(context);
        return settings.getInt(MEDIUM_ALARM_VOLUME_MODE, 50);
    }

    public static void setMediumAlarmVolume(Context context, int value) {
        settings = getSP(context);

        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putInt(MEDIUM_ALARM_VOLUME_MODE, value);
        // Commit the edits!
        editor.commit();
    }

    public static int getMediumNotification(Context context) {
        settings = getSP(context);
        return settings.getInt(MEDIUM_NOTIFICATION_VOLUME_MODE, 50);
    }

    public static void setMediumNotification(Context context, int value) {
        settings = getSP(context);

        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putInt(MEDIUM_NOTIFICATION_VOLUME_MODE, value);
        // Commit the edits!
        editor.commit();
    }

    public static boolean getMediumRingBool(Context context) {
        settings = getSP(context);
        return settings.getBoolean(MEDIUM_RING_BOOL, true);
    }

    public static void setMediumRingBool(Context context, boolean value) {
        settings = getSP(context);

        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(MEDIUM_RING_BOOL, value);
        // Commit the edits!
        editor.commit();
    }

    public static boolean getMediumAlarmBool(Context context) {
        settings = getSP(context);
        return settings.getBoolean(MEDIUM_ALARM_BOOL, true);
    }

    public static void setMediumAlarmBool(Context context, boolean value) {
        settings = getSP(context);

        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(MEDIUM_ALARM_BOOL, value);
        // Commit the edits!
        editor.commit();
    }

    public static boolean getMediumNotificationBool(Context context) {
        settings = getSP(context);
        return settings.getBoolean(MEDIUM_NOTIFICATION_BOOL, true);
    }

    public static void setMediumNotificationBool(Context context, boolean value) {
        settings = getSP(context);

        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(MEDIUM_NOTIFICATION_BOOL, value);
        // Commit the edits!
        editor.commit();
    }
    //endregion

    //region Silent
    public static int getSilentRingVolume(Context context) {
        settings = getSP(context);
        return settings.getInt(SILENT_RING_VOLUME_MODE, 0);
    }

    public static void setSilentRingVolume(Context context, int value) {
        settings = getSP(context);

        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putInt(SILENT_RING_VOLUME_MODE, value);
        // Commit the edits!
        editor.commit();
    }

    public static int getSilentAlarmVolume(Context context) {
        settings = getSP(context);
        return settings.getInt(SILENT_ALARM_VOLUME_MODE, 0);
    }

    public static void setSilentAlarmVolume(Context context, int value) {
        settings = getSP(context);

        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putInt(SILENT_ALARM_VOLUME_MODE, value);
        // Commit the edits!
        editor.commit();
    }

    public static int getSilentNotification(Context context) {
        settings = getSP(context);
        return settings.getInt(SILENT_NOTIFICATION_VOLUME_MODE, 0);
    }

    public static void setSilentNotification(Context context, int value) {
        settings = getSP(context);

        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putInt(SILENT_NOTIFICATION_VOLUME_MODE, value);
        // Commit the edits!
        editor.commit();
    }

    public static boolean getSilentRingBool(Context context) {
        settings = getSP(context);
        return settings.getBoolean(SILENT_RING_BOOL, false);
    }

    public static void setSilentRingBool(Context context, boolean value) {
        settings = getSP(context);

        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(SILENT_RING_BOOL, value);
        // Commit the edits!
        editor.commit();
    }

    public static boolean getSilentAlarmBool(Context context) {
        settings = getSP(context);
        return settings.getBoolean(SILENT_ALARM_BOOL, false);
    }

    public static void setSilentAlarmBool(Context context, boolean value) {
        settings = getSP(context);

        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(SILENT_ALARM_BOOL, value);
        // Commit the edits!
        editor.commit();
    }

    public static boolean getSilentNotificationBool(Context context) {
        settings = getSP(context);
        return settings.getBoolean(SILENT_NOTIFICATION_BOOL, false);
    }

    public static void setSilentNotificationBool(Context context, boolean value) {
        settings = getSP(context);

        android.content.SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(SILENT_NOTIFICATION_BOOL, value);
        // Commit the edits!
        editor.commit();
    }
    //endregion
}
