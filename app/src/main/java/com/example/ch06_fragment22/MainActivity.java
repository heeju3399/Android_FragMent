package com.example.ch06_fragment22;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements androidx.appcompat.app.ActionBar.TabListener {

    ActionBar.Tab tabSong, tabArtist, tabAlbum;
    private Object ActionBar;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(bar.NAVIGATION_MODE_TABS);

        //======SONG======//
        tabSong = bar.newTab();
        tabSong.setText("음악별");
        tabSong.setTabListener(this);
        bar.addTab(tabSong);
        //======SONG======//
        //======Artist======//
        tabArtist = bar.newTab();
        tabArtist.setText("아티스트");
        tabArtist.setTabListener(this);
        bar.addTab(tabArtist);
        //======Artist======//
        //======앨범======//
        tabAlbum = bar.newTab();
        tabAlbum.setText("앨범");
        tabAlbum.setTabListener(this);
        bar.addTab(tabAlbum);
        //======앨범======//

    }

    public static class MyTabFragment extends Fragment {
        String tabName;
        private Object MainActivity;

        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle data = getArguments();
            tabName = data.getString("tabName");
        }
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState){
            //리니어레이아웃//
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout baseLayout = new LinearLayout(super.getActivity());
            baseLayout.setOrientation(LinearLayout.VERTICAL);
            baseLayout.setLayoutParams(params);
            //리니어레이아웃//
            //그리드레이아웃//

            //그리드레이아웃//


            if(tabName=="음악별") baseLayout.setBackgroundColor(Color.RED);
            if(tabName=="아티스트") baseLayout.setBackgroundColor(Color.GREEN);
            if(tabName=="앨범") baseLayout.setBackgroundColor(Color.BLUE);

            return baseLayout;

        }
    }

    MyTabFragment myFrags[] = new MyTabFragment[3];
    @Override
    public void onTabSelected(androidx.appcompat.app.ActionBar.Tab tab, FragmentTransaction ft) {
        MyTabFragment myTabFrag = null;
        // if(myFrags[tab.getPosition()]==null){
        myTabFrag = new MyTabFragment();
        Bundle data = new Bundle();
        data.putString("tabName",tab.getText().toString());
        myTabFrag.setArguments(data);
        myFrags[tab.getPosition()] = myTabFrag;
        Log.i("ddd","myTabFrag::"+myFrags[1]);

        //  }else{
        //     myTabFrag = myFrags[tab.getPosition()];//(myTabFragment)
        ft.replace(android.R.id.content, myTabFrag);
        //  }
    }

    @Override
    public void onTabUnselected(androidx.appcompat.app.ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(androidx.appcompat.app.ActionBar.Tab tab, FragmentTransaction ft) {

    }





}