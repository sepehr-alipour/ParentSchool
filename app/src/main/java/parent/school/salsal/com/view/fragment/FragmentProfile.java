package parent.school.salsal.com.view.fragment;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import parent.school.salsal.com.R;
import parent.school.salsal.com.adapter.AdapterPagerProfile;

public class FragmentProfile extends Fragment {


    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.fabEdit)
    FloatingActionButton fabEdit;
    @BindView(R.id.htab_maincontent)
    CoordinatorLayout htabMaincontent;
    Unbinder unbinder;

    public FragmentProfile() {
        // Required empty public constructor
    }

    public static FragmentProfile newInstance() {
        FragmentProfile fragment = new FragmentProfile();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        AdapterPagerProfile pagerAdapter = new AdapterPagerProfile(getChildFragmentManager());

        unbinder = ButterKnife.bind(this, view);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == AdapterPagerProfile.POSITION_SCHOOL) {
                    fabEdit.setImageResource(R.drawable.ic_action_add);

                } else fabEdit.setImageResource(R.drawable.ic_action_edit);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
