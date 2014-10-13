package net.brusd.phonecontroller;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import net.brusd.phonecontroller.fragments.AboutFragment;
import net.brusd.phonecontroller.fragments.HomeFragment;
import net.brusd.phonecontroller.fragments.ModesFragment;
import net.brusd.phonecontroller.fragments.SavedWiFiFragment;
import net.brusd.phonecontroller.fragments.SettingsFragment;


public class MainActivity extends Activity implements View.OnClickListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private FragmentChangeBroadcastReceiver fragmentChangeBroadcastReceiver;

    private Button homeButton, modesButton, savedWiFiButton, settingsButton, rateUsButton, aboutButon;

    public enum ContentType {
        HOME, MODES, SAVED_WIFI, MODE_SETTING, SETTING, ABOUT
    }

    public ContentType currentFragment = ContentType.HOME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerTitle = this.getString(R.string.drawer_open);
        mTitle = mDrawerTitle;
        initialDrawerContent();
        fragmentChangeBroadcastReceiver = new FragmentChangeBroadcastReceiver();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setFragment(currentFragment, null);

        IntentFilter filter = new IntentFilter();
        filter.addAction(Constant.SET_MODE_SETTING);
        registerReceiver(fragmentChangeBroadcastReceiver, filter);
    }

    @Override
    protected void onPause() {
        if (fragmentChangeBroadcastReceiver != null)
            unregisterReceiver(fragmentChangeBroadcastReceiver);
        super.onPause();
    }

    private void initialDrawerContent() {

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                R.drawable.ic_drawer,  /* nav drawer icon to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description */
                R.string.app_name  /* "close drawer" description */
        ) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getActionBar().setTitle(mTitle);
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                initDrawerButton(drawerView);
                getActionBar().setTitle(mDrawerTitle);
            }
        };

        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }

    public void initDrawerButton(View drawerView) {
        homeButton = (Button) drawerView.findViewById(R.id.home_button);
        modesButton = (Button) drawerView.findViewById(R.id.modes_button);
        savedWiFiButton = (Button) drawerView.findViewById(R.id.saved_wifi_button);
        settingsButton = (Button) drawerView.findViewById(R.id.settings_button);
        rateUsButton = (Button) drawerView.findViewById(R.id.rate_us_button);
        aboutButon = (Button) drawerView.findViewById(R.id.about_button);

        homeButton.setOnClickListener(this);
        modesButton.setOnClickListener(this);
        savedWiFiButton.setOnClickListener(this);
        settingsButton.setOnClickListener(this);
        rateUsButton.setOnClickListener(this);
        aboutButon.setOnClickListener(this);

        LinearLayout emptyLinerLayout = (LinearLayout) drawerView.findViewById(R.id.empty_liner_layout);
        emptyLinerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.closeDrawers();
            }
        });
    }

    @Override
    public void onClick(View v) {

        mDrawerLayout.closeDrawers();
        switch (v.getId()) {
            case R.id.home_button:
                setFragment(ContentType.HOME, null);
                break;
            case R.id.modes_button:
                setFragment(ContentType.MODES, null);
                break;
            case R.id.saved_wifi_button:
                setFragment(ContentType.SAVED_WIFI, null);
                break;
            case R.id.settings_button:
                setFragment(ContentType.SETTING, null);
                break;
            case R.id.rate_us_button:
                break;
            case R.id.about_button:
                setFragment(ContentType.ABOUT, null);
                break;
        }
    }

    private void setFragment(ContentType contentType, Bundle bundle) {
        final Fragment fragmentOld = getFragmentManager().findFragmentById(R.id.fragment_container);

        final Fragment fragment = fragmentFromContentType(contentType);


        if (!fragment.equals(fragmentOld)) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            fragment.setArguments(bundle);
            ft.replace(R.id.fragment_container, fragment);
            ft.commitAllowingStateLoss();
        }

    }


    private Fragment fragmentFromContentType(ContentType contentType) {
        Fragment fragment;
        switch (contentType) {
            case HOME: {
                fragment = new HomeFragment();

                currentFragment = ContentType.HOME;
                break;

            }
            case MODES: {
                fragment = new ModesFragment();
                currentFragment = ContentType.MODES;
                break;
            }
            case SAVED_WIFI: {
                fragment = new SavedWiFiFragment();
                currentFragment = ContentType.SAVED_WIFI;
                break;
            }
            case SETTING: {
                fragment = new SettingsFragment();
                currentFragment = ContentType.SETTING;
                break;
            }

            case ABOUT: {
                fragment = new AboutFragment();
                currentFragment = ContentType.ABOUT;
                break;
            }
            default: {
                return null;
            }

        }
        return fragment;
    }

    class FragmentChangeBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Constant.SET_MODE_SETTING)) {
                int modeID = intent.getIntExtra(Constant.MODE_ID, 0);
                Bundle bundle = new Bundle();
                bundle.putInt(Constant.MODE_ID, modeID);
                Toast.makeText(context, ""+modeID, Toast.LENGTH_LONG).show();
//                setFragment(ContentType.MODE_SETTING, bundle);

            }
        }
    }
}


