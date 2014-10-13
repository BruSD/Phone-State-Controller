package net.brusd.phonecontroller.utils;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import net.brusd.phonecontroller.Constant;
import net.brusd.phonecontroller.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by BruSD on 10/10/2014.
 */
public class ModeSimpleAdapter extends SimpleAdapter {

    private ArrayList<HashMap<String, Object>> modes = new ArrayList<>();
    private Context context;
    private String globalString, associeteString;

    public ModeSimpleAdapter(Context context, ArrayList<HashMap<String, Object>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        this.modes = data;
        this.context = context;

        globalString = context.getString(R.string.global_mode_string);
        associeteString = context.getString(R.string.associated_with_string);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        TextView modeNameTextView, associateWithTextView, valueTextView;
        ImageView modeIconImageView;
        ImageButton settingsImageButton;


        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = li.inflate(R.layout.item_lest_of_mode, parent, false);
        modeNameTextView = (TextView) convertView.findViewById(R.id.mode_name_text_view);
        associateWithTextView = (TextView) convertView.findViewById(R.id.associate_with_text_view);
        valueTextView = (TextView) convertView.findViewById(R.id.volume_value_text_view);
        modeIconImageView = (ImageView) convertView.findViewById(R.id.mode_image_view);
        settingsImageButton = (ImageButton) convertView.findViewById(R.id.settings_mode_image_view);

        final HashMap<String, Object> mode = modes.get(position);

        switch ((Integer) mode.get(Constant.MODE_ID)) {
            case Constant.MODE_FULL:
                modeNameTextView.setText(context.getString(R.string.full_volume_mode_string));
                convertView.setBackgroundColor(context.getResources().getColor(R.color.full_mode));
                modeIconImageView.setImageDrawable(context.getResources().getDrawable(android.R.drawable.ic_lock_silent_mode_off));
                break;
            case Constant.MODE_MEDIUM:
                modeNameTextView.setText(context.getString(R.string.medium_volume_mode_string));
                convertView.setBackgroundColor(context.getResources().getColor(R.color.medium_mode));
                modeIconImageView.setImageDrawable(context.getResources().getDrawable(android.R.drawable.ic_lock_silent_mode_off));
                break;
            case Constant.MODE_SILENT:
                modeNameTextView.setText(context.getString(R.string.silent_volume_mode_string));
                convertView.setBackgroundColor(context.getResources().getColor(R.color.silent_mode));
                modeIconImageView.setImageDrawable(context.getResources().getDrawable(android.R.drawable.ic_lock_silent_mode));
                break;
        }

        settingsImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(Constant.SET_MODE_SETTING);
                intent.putExtra(Constant.MODE_ID, (Integer)mode.get(Constant.MODE_ID));
                context.sendBroadcast(intent);
            }
        });
        int releted = (Integer) mode.get(Constant.RELETADE_TO_MODE);
        if (releted != -1) {
            associateWithTextView.setText(associeteString + releted+" WiFi");
        } else {
            associateWithTextView.setText(globalString);
        }
        valueTextView.setText(mode.get(Constant.VOLUME_OF_MODE) + "%");
        return convertView;
    }

}
