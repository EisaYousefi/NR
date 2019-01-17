package com.broa.nestdapp.tablayout;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.broa.nestdapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TablayoutFragment extends Fragment {


    public TablayoutFragment() {
        // Required empty public constructor
    }

    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_tablayout, container, false);
        ButterKnife.bind(this,view);

        configViewpager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        setcustomTabs();
        return view;
    }

    private void setcustomTabs() {
        TextView tab1 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tab,null);
        tab1.setText("call");
        tab1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_call_black_24dp,0,0,0);
        tabLayout.getTabAt(0).setCustomView(tab1);

        TextView tab2 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tab,null);
        tab2.setText("Msg");
        tab2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_message_black_24dp,0,0,0);
        tabLayout.getTabAt(1).setCustomView(tab2);



    }
    private void configViewpager(ViewPager viewPager) {

//        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
//        transaction.replace(R.id.frm_layout_F1, new Tab1Fragment());
//        transaction.addToBackStack(null);
//        transaction.commit();



        Adapter adapter = new Adapter(getChildFragmentManager());
        adapter.addToList(new Tab1Fragment(),"111111111111");
        adapter.addToList(new Tab2Fragment(),"22222222222");
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(10);

    }
}
