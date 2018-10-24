package parent.school.salsal.com.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import parent.school.salsal.com.view.fragment.FragmentAttendance;
import parent.school.salsal.com.view.fragment.FragmentProfileParent;
import parent.school.salsal.com.view.fragment.FragmentProfileSchools;
import parent.school.salsal.com.view.fragment.FragmentProfileStudent;
import parent.school.salsal.com.view.fragment.FragmentScheduleWeekly;

public class AdapterPagerSchedule extends FragmentPagerAdapter {

    public final static int POSITION_SCHEDULE_WEEKLY = 0;
    public final static int POSITION_ATTENDANCE = 1;

    public AdapterPagerSchedule(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case POSITION_SCHEDULE_WEEKLY:
                return FragmentScheduleWeekly.newInstance();
            case POSITION_ATTENDANCE:
                return FragmentAttendance.newInstance();
            default:
                FragmentProfileParent.newInstance();
        }
        return null;

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case POSITION_SCHEDULE_WEEKLY:
                return "برنامه هفتگی";
            case POSITION_ATTENDANCE:
                return "حضور غیاب";
            default:
                FragmentScheduleWeekly.newInstance();
        }
        return "";
    }

    @Override
    public int getCount() {
        return 2;
    }
}
