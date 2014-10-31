package net.brusd.phonecontroller.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import net.brusd.phonecontroller.AppDataBase.AppDB;
import net.brusd.phonecontroller.Constant;
import net.brusd.phonecontroller.R;
import net.brusd.phonecontroller.utils.ModeSimpleAdapter;
import net.brusd.phonecontroller.utils.SharedPreferences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created by BruSD on 6/7/2014.
 */
public class ModesFragment extends Fragment {
    private View rootView;
    private Activity parentActivity;
    private ListView modeListView;
    private static AppDB appDB = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_modes, container, false);
        parentActivity = getActivity();
        appDB = AppDB.getInstance(parentActivity);
        modeListView = (ListView)rootView.findViewById(R.id.mode_list);
        initModeList();
        return rootView;
    }

    private void initModeList(){
        int count;
        ArrayList<HashMap<String, Object>> modes = new ArrayList<>();
        HashMap<String, Object> mode =  new HashMap<>();
        //Full volume Mode
        mode.put(Constant.VOLUME_OF_MODE, SharedPreferences.getFullRingVolume(parentActivity));
        if (Constant.MODE_FULL == SharedPreferences.getGlobalVolumeMode(parentActivity)){
            count = -1;
        }else {
            count = appDB.getCountOfWifiReletedToMode(Constant.MODE_FULL);
        }

        mode.put(Constant.RELETADE_TO_MODE, count);
        mode.put(Constant.MODE_ID, Constant.MODE_FULL);
        modes.add(mode);

        //Medium volume mode

        mode = new HashMap<>();
        mode.put(Constant.VOLUME_OF_MODE, SharedPreferences.getMediumRingVolume(parentActivity));
        if (Constant.MODE_MEDIUM == SharedPreferences.getGlobalVolumeMode(parentActivity)){
            count = -1;
        }else {
            count = appDB.getCountOfWifiReletedToMode(Constant.MODE_MEDIUM);
        }

        mode.put(Constant.RELETADE_TO_MODE, count);
        mode.put(Constant.MODE_ID, Constant.MODE_MEDIUM);
        modes.add(mode);

        //Silent volume mode
        mode = new HashMap<>();
        mode = new HashMap<>();
        mode.put(Constant.VOLUME_OF_MODE, SharedPreferences.getSilentRingVolume(parentActivity));
        if (Constant.MODE_SILENT == SharedPreferences.getGlobalVolumeMode(parentActivity)){
            count = -1;
        }else {
            count = appDB.getCountOfWifiReletedToMode(Constant.MODE_SILENT);
        }

        mode.put(Constant.RELETADE_TO_MODE, count);
        mode.put(Constant.MODE_ID, Constant.MODE_SILENT);
        modes.add(mode);

        ModeSimpleAdapter modeSimpleAdapter =  new ModeSimpleAdapter(parentActivity, modes, 0, null, null);
        modeListView.setAdapter(modeSimpleAdapter);
    }


}
