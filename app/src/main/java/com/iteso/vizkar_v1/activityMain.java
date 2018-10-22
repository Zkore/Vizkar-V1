package com.iteso.vizkar_v1;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.iteso.vizkar_v1.beans.FragmentEventosProximos;
import com.iteso.vizkar_v1.beans.FragmentPerfil;
import com.iteso.vizkar_v1.beans.fragmentMisEventos;
import com.iteso.vizkar_v1.tools.Constant;

public class activityMain extends AppCompatActivity {
    //Este activity va a tener todos los fragmentos

    private static final int TOTAL_PAGES = 3;
    private FragmentEventosProximos fragmentEventosProximos;
    private fragmentMisEventos fragmentMisEventos;
    private FragmentPerfil fragmentPerfil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TabLayout tabLayout = findViewById(R.id.tabs);

        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        ViewPager mViewPager = findViewById(R.id.ViewPager_Main);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        //tabLayout.setupWithViewPager(mViewPager);
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
                    if (fragmentEventosProximos == null)
                        fragmentEventosProximos = new FragmentEventosProximos();
                    return fragmentEventosProximos;
                case Constant.FRAGMENT_MISEVENTOS:
                    if (fragmentMisEventos == null)
                        fragmentMisEventos = new fragmentMisEventos();
                    return fragmentMisEventos;
                case Constant.FRAGMENT_PERFIL:
                    if (fragmentPerfil == null)
                        fragmentPerfil = new FragmentPerfil();
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
                    //TODO poner strings en values
                    //return getString(R.string.section1);
                    return "Eventos Proximos";
                case Constant.FRAGMENT_MISEVENTOS:
                    //return getString(R.string.section2);
                return "Eventos Proximos";
                case Constant.FRAGMENT_PERFIL:
                    //return getString(R.string.section3);
                return "Perfil";
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
        //TODO
        PreferenceManager.getDefaultSharedPreferences(getBaseContext()).edit().clear().apply();
        this.startActivity(intent);
    }
    /*
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case Constant.ACTIVITY_DETAIL:
                if(resultCode == RESULT_OK){
                    if(data.getExtras() != null) {
                        int fragment = data.getExtras().getInt(Constant.EXTRA_FRAGMENT);
                        switch (fragment) {
                            case Constant.FRAGMENT_TECHNOLOGY:
                                fragmentTechnology.onActivityResult(requestCode, resultCode, data);
                                break;
                            case Constant.FRAGMENT_HOME:
                                fragmentHome.onActivityResult(requestCode, resultCode, data);
                                break;
                            case Constant.FRAGMENT_ELECTRONICS:
                                fragmentElectronics.onActivityResult(requestCode, resultCode, data);
                                break;
                        }
                    }
                }
                break;
        }
    }
    */
}

