package com.example.wasalahore.RainGauges;

import android.os.Build;
import android.os.Bundle;

import com.example.wasalahore.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

public class RainGaugeHome extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    TabItem tabDashboard;
    TabItem tabReport;
    TabItem tabSummary;
    TabItem tabGraph;

    ViewPager viewPager;
    RainPagerAdapterClass rainPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rain_gauge_home);


        toolbar = findViewById(R.id.rain_toolbar);
        toolbar.setTitle("Give Reviews");
        setSupportActionBar(toolbar);


        tabLayout = findViewById(R.id.rain_tab_layout);
        viewPager = findViewById(R.id.rain_viewpager);
        tabDashboard = findViewById(R.id.rain_dashboard);

        tabGraph = findViewById(R.id.rain_graph);

        rainPagerAdapter = new RainPagerAdapterClass(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(rainPagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(RainGaugeHome.this, R.color.colorPrimary));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(RainGaugeHome.this, R.color.colorPrimary));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(RainGaugeHome.this, R.color.colorPrimary));
                    }
                } else if (tab.getPosition() == 1) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(RainGaugeHome.this, R.color.colorPrimaryDark));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(RainGaugeHome.this, R.color.colorPrimaryDark));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(RainGaugeHome.this, R.color.colorPrimaryDark));
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
}
