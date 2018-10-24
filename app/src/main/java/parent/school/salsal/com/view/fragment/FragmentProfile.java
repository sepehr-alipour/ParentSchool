package parent.school.salsal.com.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import parent.school.salsal.com.R;
import parent.school.salsal.com.adapter.AdapterPagerProfile;
import parent.school.salsal.com.util.PreferenceManager;
import parent.school.salsal.com.view.activity.ActivityEditProfile;
import parent.school.salsal.com.view.activity.ActivitySchools;

public class FragmentProfile extends Fragment implements View.OnClickListener {


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
    int mode = -1;

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
        viewPager.setOffscreenPageLimit(1);
        tabLayout.setupWithViewPager(viewPager);
        fabEdit.setOnClickListener(this);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case AdapterPagerProfile.POSITION_SCHOOL:
                        fabEdit.setImageResource(R.drawable.ic_action_add);
                        fabEdit.show();
                        break;
                    case AdapterPagerProfile.POSITION_TEACHERS:
                        fabEdit.hide();
                        break;
                    default:
                        fabEdit.setImageResource(R.drawable.ic_action_edit);
                        fabEdit.show();
                }
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

    @Override
    public void onClick(View v) {
        Intent intent = null;
        if (v.getId() == R.id.fabEdit) {
            switch (viewPager.getCurrentItem()) {
                case AdapterPagerProfile.POSITION_PARENT:

                    intent = new Intent(getContext(), ActivityEditProfile.class);
                    intent.putExtra(ActivityEditProfile.PARAMS_NAME_STUDENT, ActivityEditProfile.TYPE_PARENT);
                    intent.putExtra(ActivityEditProfile.PARAMS_NAME_ID, PreferenceManager.getUserProfile(getContext()).get(PreferenceManager.PREF_PARENT_ID));
                    startActivity(intent);
                    break;
                case AdapterPagerProfile.POSITION_STUDENT:

                    intent = new Intent(getContext(), ActivityEditProfile.class);
                    intent.putExtra(ActivityEditProfile.PARAMS_NAME_STUDENT, ActivityEditProfile.TYPE_STUDENT);
                    intent.putExtra(ActivityEditProfile.PARAMS_NAME_ID, PreferenceManager.getCurrentStudentId(getContext()));
                    startActivity(intent);
                    break;

                case AdapterPagerProfile.POSITION_SCHOOL:
                    intent = new Intent(getContext(), ActivitySchools.class);
                    startActivity(intent);
                    break;


            }
        }
    }
}
