package com.broa.nestdapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.broa.nestdapp.nestedRecycler.RecyclerViewFragment;
import com.broa.nestdapp.tablayout.TablayoutFragment;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView navigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation = findViewById(R.id.navigation);
        selectFragment(new TablayoutFragment());
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_tablayout:
                    selectFragment(new TablayoutFragment());
                    return true;
                case R.id.navigation_recyclerview:
                    selectFragment(new RecyclerViewFragment());
                    return true;
                case R.id.navigation_notifications:
                    selectFragment(new CustomviewFragment());
                    return true;
            }
            return false;
        }
    };

    private void selectFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frm_contaner_main,fragment );
        transaction.commit();

    }


}
