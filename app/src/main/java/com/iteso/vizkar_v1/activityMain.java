package com.iteso.vizkar_v1;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.iteso.vizkar_v1.beans.FragmentEventosProximos;
import com.iteso.vizkar_v1.beans.FragmentPerfil;
import com.iteso.vizkar_v1.beans.fragmentMisEventos;
import com.iteso.vizkar_v1.tools.Constant;

import java.security.MessageDigest;

public class activityMain extends AppCompatActivity {
    //Este activity va a tener todos los fragmentos

    private static final int TOTAL_PAGES = 3;
    private FragmentEventosProximos fragmentEventosProximos;
    private fragmentMisEventos fragmentMisEventos1;
    private FragmentPerfil fragmentPerfil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout tabLayout = findViewById(R.id.tabs);

        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        ViewPager mViewPager = findViewById(R.id.ViewPager_Main);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);

        //Para obtener
        try {
            PackageInfo info = getPackageManager().getPackageInfo("com.iteso.vizkar_v1", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures){
                MessageDigest messageDigest = MessageDigest.getInstance("SHA");
                messageDigest.update(signature.toByteArray());
                Log.e("Google" , Base64.encodeToString(messageDigest.digest(),Base64.DEFAULT));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }



    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position) {
                case Constant.FRAGMENT_EVENTOSPROXIMOS:
                    if (fragmentEventosProximos == null){
                        fragmentEventosProximos = new FragmentEventosProximos();
                    Log.e("Fragment" , "EventosProximos");
                    }
                    return fragmentEventosProximos;
                case Constant.FRAGMENT_MISEVENTOS:
                    if (fragmentMisEventos1 == null) {
                        fragmentMisEventos1 = new fragmentMisEventos();
                        Log.e("Fragment" , "MisEventos");
                    }
                    return fragmentMisEventos1;
                case Constant.FRAGMENT_PERFIL:
                    if (fragmentPerfil == null) {
                        fragmentPerfil = new FragmentPerfil();
                        Log.e("Fragment", "Perfil");
                    }
                    return fragmentPerfil;
                default:
                    return new FragmentEventosProximos();
            }
        }


        @Override
        public int getCount() {
            return TOTAL_PAGES;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case Constant.FRAGMENT_EVENTOSPROXIMOS:
                    return getString(R.string.section1);
                    //return "Eventos Proximos";
                case Constant.FRAGMENT_MISEVENTOS:
                    return getString(R.string.section2);
                //return "Eventos Proximos";
                case Constant.FRAGMENT_PERFIL:
                    return getString(R.string.section3);
                //return "Perfil";
            }
            return null;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id){
            case R.id.action_log_out:
                logOutopt();
                return true;

            default:
                Log.i("holo", "default: ");
                return super.onOptionsItemSelected(item);

        }

    }

    private void logOutopt(){
        Intent intent = new Intent( this, activityLoginScreen.class);
        PreferenceManager.getDefaultSharedPreferences(getBaseContext()).edit().clear().apply();
        this.startActivity(intent);
    }
}

