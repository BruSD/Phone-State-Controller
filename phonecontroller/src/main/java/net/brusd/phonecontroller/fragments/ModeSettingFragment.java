package net.brusd.phonecontroller.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import net.brusd.phonecontroller.Constant;
import net.brusd.phonecontroller.R;
import net.brusd.phonecontroller.utils.SharedPreferences;

/**
 * Created by BruSD on 10/13/2014.
 */
public class ModeSettingFragment extends Fragment {

    private View rootView;
    private Activity parrentActivity;
    private TextView ringValueTextView, alarmValueTextView, notificationValueTextView, modeNameTextView;
    private Switch ringSwitch, alarmSwitch, notificationSwitch, diconnectedSwitch;
    private ListView listView;
    private String modeName;


    private int modeID = 0;
    private int ringValue, alarmValue, notificationValue;
    private boolean ringBoolean, alarmBoolean, notificationBoolean;
    private int disconectedModeId;

    private RingSwitchListener ringSwitchListener;
    private AlarmSwitchListener alarmSwitchListener;
    private NotificationSwitchListener notificationSwitchListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_settings_mode, container, false);
        parrentActivity = getActivity();
        Bundle arguments = getArguments();
        if (arguments != null) {
            modeID = arguments.getInt(Constant.MODE_ID);
        }
        initDataToView();
        initView();
        setAllData();
        return rootView;
    }


    private void initView() {
        modeNameTextView = (TextView) rootView.findViewById(R.id.mode_name_setting_mode_frag_text_veiw);
        //Values
        ringValueTextView = (TextView) rootView.findViewById(R.id.ring_value_text_view);
        alarmValueTextView = (TextView) rootView.findViewById(R.id.alarm_value_text_view);
        notificationValueTextView = (TextView) rootView.findViewById(R.id.notification_value_text_view);
        //switch
        ringSwitch = (Switch) rootView.findViewById(R.id.ring_switch);
        ringSwitchListener = new RingSwitchListener();
        ringSwitch.setOnCheckedChangeListener(ringSwitchListener);

        alarmSwitch = (Switch) rootView.findViewById(R.id.alarm_switch);
        alarmSwitchListener = new AlarmSwitchListener();
        alarmSwitch.setOnCheckedChangeListener(alarmSwitchListener);

        notificationSwitch = (Switch) rootView.findViewById(R.id.notification_switch);
        notificationSwitchListener = new NotificationSwitchListener();
        notificationSwitch.setOnCheckedChangeListener(notificationSwitchListener);

        diconnectedSwitch = (Switch) rootView.findViewById(R.id.disconnected_switch);

        listView = (ListView) rootView.findViewById(R.id.wifi_in_this_mode_list_view);


    }

    private void initDataToView() {
        switch (modeID) {
            case Constant.MODE_FULL:
                initFullModeData();
                break;
            case Constant.MODE_MEDIUM:
                initMediumMode();
                break;
            case Constant.MODE_SILENT:
                initSilentMode();
                break;
        }
        disconectedModeId = SharedPreferences.getDisconetedModeID(parrentActivity);

    }


    //region INIT_DATA
    private void initFullModeData() {
        modeName = parrentActivity.getString(R.string.full_volume_mode_string);

        ringValue = SharedPreferences.getFullRingVolume(parrentActivity);
        alarmValue = SharedPreferences.getFullAlarmVolume(parrentActivity);
        notificationValue = SharedPreferences.getFullNotification(parrentActivity);

        ringBoolean = SharedPreferences.getFullRingBool(parrentActivity);
        alarmBoolean = SharedPreferences.getFullAlarmBool(parrentActivity);
        notificationBoolean = SharedPreferences.getFullNotificationBool(parrentActivity);
    }

    private void initMediumMode() {
        modeName = parrentActivity.getString(R.string.medium_volume_mode_string);

        ringValue = SharedPreferences.getMediumRingVolume(parrentActivity);
        alarmValue = SharedPreferences.getMediumAlarmVolume(parrentActivity);
        notificationValue = SharedPreferences.getMediumNotification(parrentActivity);

        ringBoolean = SharedPreferences.getMediumRingBool(parrentActivity);
        alarmBoolean = SharedPreferences.getMediumAlarmBool(parrentActivity);
        notificationBoolean = SharedPreferences.getMediumNotificationBool(parrentActivity);

    }

    private void initSilentMode() {
        modeName = parrentActivity.getString(R.string.silent_volume_mode_string);

        ringValue = SharedPreferences.getSilentRingVolume(parrentActivity);
        alarmValue = SharedPreferences.getSilentAlarmVolume(parrentActivity);
        notificationValue = SharedPreferences.getSilentNotification(parrentActivity);

        ringBoolean = SharedPreferences.getSilentRingBool(parrentActivity);
        alarmBoolean = SharedPreferences.getSilentAlarmBool(parrentActivity);
        notificationBoolean = SharedPreferences.getSilentNotificationBool(parrentActivity);

    }

    private void setAllData() {
        modeNameTextView.setText(modeName);

        if (modeID == disconectedModeId) {
            diconnectedSwitch.setChecked(true);
        } else {
            diconnectedSwitch.setChecked(false);
        }

        if (!ringBoolean) {
            ringSwitch.setChecked(ringBoolean);
            ringValueTextView.setText("");
        } else {
            ringSwitch.setChecked(ringBoolean);
            ringValueTextView.setText(ringValue + "%");
        }

        if (!alarmBoolean) {
            alarmSwitch.setChecked(alarmBoolean);
            alarmValueTextView.setText("");
        } else {
            alarmSwitch.setChecked(alarmBoolean);
            alarmValueTextView.setText(alarmValue + "%");
        }

        if (!notificationBoolean) {
            notificationSwitch.setChecked(notificationBoolean);
            notificationValueTextView.setText("");
        } else {
            notificationSwitch.setChecked(notificationBoolean);
            notificationValueTextView.setText(notificationValue + "%");
        }
    }
    //endregion


    class RingSwitchListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            ringBooleanChange(isChecked);

        }
    }

    private void ringBooleanChange(boolean isChecked) {
        switch (modeID) {
            case Constant.MODE_FULL:
                if (isChecked) {
                    ringValueTextView.setText(SharedPreferences.getFullRingVolume(parrentActivity) + "%");
                } else {
                    ringValueTextView.setText("");
                }
                SharedPreferences.setFullRingBool(parrentActivity, isChecked);

                break;
            case Constant.MODE_MEDIUM:
                if (isChecked) {
                    ringValueTextView.setText(SharedPreferences.getMediumRingVolume(parrentActivity) + "%");
                } else {
                    ringValueTextView.setText("");
                }
                SharedPreferences.setMediumRingBool(parrentActivity, isChecked);

                break;
            case Constant.MODE_SILENT:
                if (isChecked) {
                    ringValueTextView.setText(SharedPreferences.getSilentRingVolume(parrentActivity) + "%");
                } else {
                    ringValueTextView.setText("");
                }
                SharedPreferences.setSilentRingBool(parrentActivity, isChecked);

                break;
        }
    }

    class AlarmSwitchListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            alarmBooleanChange(isChecked);

        }
    }

    private void alarmBooleanChange(boolean isChecked) {
        switch (modeID) {
            case Constant.MODE_FULL:
                if (isChecked) {
                    alarmValueTextView.setText(SharedPreferences.getFullAlarmVolume(parrentActivity) + "%");
                } else {
                    alarmValueTextView.setText("");
                }
                SharedPreferences.setFullAlarmBool(parrentActivity, isChecked);

                break;
            case Constant.MODE_MEDIUM:
                if (isChecked) {
                    alarmValueTextView.setText(SharedPreferences.getMediumAlarmVolume(parrentActivity) + "%");
                } else {
                    alarmValueTextView.setText("");
                }
                SharedPreferences.setMediumAlarmBool(parrentActivity, isChecked);

                break;
            case Constant.MODE_SILENT:
                if (isChecked) {
                    alarmValueTextView.setText(SharedPreferences.getSilentAlarmVolume(parrentActivity) + "%");
                } else {
                    alarmValueTextView.setText("");
                }
                SharedPreferences.setSilentAlarmBool(parrentActivity, isChecked);

                break;
        }
    }

    class NotificationSwitchListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            notificationBooleanChange(isChecked);

        }
    }
    private void notificationBooleanChange(boolean isChecked) {
        switch (modeID) {
            case Constant.MODE_FULL:
                if (isChecked) {
                    notificationValueTextView.setText(SharedPreferences.getFullNotification(parrentActivity) + "%");
                } else {
                    notificationValueTextView.setText("");
                }
                SharedPreferences.setFullNotificationBool(parrentActivity, isChecked);

                break;
            case Constant.MODE_MEDIUM:
                if (isChecked) {
                    notificationValueTextView.setText(SharedPreferences.getMediumNotification(parrentActivity) + "%");
                } else {
                    notificationValueTextView.setText("");
                }
                SharedPreferences.setMediumNotificationBool(parrentActivity, isChecked);

                break;
            case Constant.MODE_SILENT:
                if (isChecked) {
                    notificationValueTextView.setText(SharedPreferences.getSilentNotification(parrentActivity) + "%");
                } else {
                    notificationValueTextView.setText("");
                }
                SharedPreferences.setSilentNotificationBool(parrentActivity, isChecked);

                break;
        }
    }
}
