package parent.school.salsal.com.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import parent.school.salsal.com.view.fragment.FragmentProfileParent;
import parent.school.salsal.com.view.fragment.FragmentProfileStudent;

public class AdapterPager extends FragmentPagerAdapter {

    private final int POSITION_PARENT = 0;
    private final int POSITION_STUDENT = 1;

    public AdapterPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case POSITION_PARENT:
                return FragmentProfileParent.newInstance();
            case POSITION_STUDENT:
                return FragmentProfileStudent.newInstance();
            default:
                FragmentProfileParent.newInstance();
        }
        return null;

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case POSITION_PARENT:
                return "مشخصات اولیا";
            case POSITION_STUDENT:
                return "مشخصات دانش آموز";
            default:
                FragmentProfileParent.newInstance();
        }
        return "";
    }

    @Override
    public int getCount() {
        return 2;
    }
}
