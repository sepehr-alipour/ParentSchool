package parent.school.salsal.com.view.activity;

import android.os.Handler;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.core.content.ContextCompat;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import parent.school.salsal.com.R;
import parent.school.salsal.com.view.fragment.FragmentCourses;
import parent.school.salsal.com.view.fragment.FragmentNotifications;
import parent.school.salsal.com.view.fragment.FragmentProfile;
import parent.school.salsal.com.view.fragment.FragmentSchedule;

public class ActivityMain extends BaseActivity implements View.OnClickListener,
        AHBottomNavigation.OnTabSelectedListener {

    @BindView(R.id.bottom_navigation)
    AHBottomNavigation bottomNavigation;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private final int TAB_PROFILE = 0;
    private final int TAB_َACTIVITIES = 1;
    private final int TAB_SCHEDLEَ = 2;
    private final int TAB_NOTIFICATIONS = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.tab_profile, R.drawable.ic_action_profile, R.color.colorPrimary);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.tab_activities, R.drawable.ic_action_activity, R.color.colorPrimary);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.tab_schedule, R.drawable.ic_action_date, R.color.colorPrimary);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem(R.string.tab_notifications, R.drawable.ic_action_notification, R.color.colorPrimary);

// Add items
        bottomNavigation.setAccentColor(ContextCompat.getColor(this, R.color.colorPrimary));
        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);
        bottomNavigation.addItem(item4);
        bottomNavigation.setOnTabSelectedListener(this);
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        bottomNavigation.setCurrentItem(TAB_NOTIFICATIONS);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean onTabSelected(int position, boolean wasSelected) {
        Fragment selectedFragment = null;
        switch (position) {
            case TAB_PROFILE:
                //toolbar.setVisibility(View.GONE);
                selectedFragment = FragmentProfile.newInstance();
                break;
            case TAB_َACTIVITIES:
                // toolbar.setVisibility(View.VISIBLE);

                selectedFragment = FragmentCourses.newInstance();
                break;
            case TAB_SCHEDLEَ:
                //  toolbar.setVisibility(View.VISIBLE);

                selectedFragment = FragmentSchedule.newInstance();
                break;
            case TAB_NOTIFICATIONS:
                //  toolbar.setVisibility(View.VISIBLE);

                selectedFragment = FragmentNotifications.newInstance();
                break;
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.homeContainer, selectedFragment);
        transaction.commit();
        return true;
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, R.string.toast_exit, Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}
