package parent.school.salsal.com.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import parent.school.salsal.com.view.fragment.FragmentProfileParent;
import parent.school.salsal.com.view.fragment.FragmentProfileSchools;
import parent.school.salsal.com.view.fragment.FragmentProfileStudent;
import parent.school.salsal.com.view.fragment.FragmentProfileTeachers;

public class AdapterPagerProfile extends FragmentPagerAdapter {

    public final static int POSITION_PARENT = 0;
    public final static int POSITION_STUDENT = 1;
    public final static int POSITION_TEACHERS = 2;
    public final static int POSITION_SCHOOL = 3;

    public AdapterPagerProfile(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case POSITION_PARENT:
                return FragmentProfileParent.newInstance();
            case POSITION_STUDENT:
                return FragmentProfileStudent.newInstance();
            case POSITION_TEACHERS:
                return FragmentProfileTeachers.newInstance();
            case POSITION_SCHOOL:
                return FragmentProfileSchools.newInstance();
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
                return "اولیا";
            case POSITION_STUDENT:
                return "دانش آموز";
            case POSITION_TEACHERS:
                return "معلم ها";
            case POSITION_SCHOOL:
                return "مدرسه";
            default:
                FragmentProfileParent.newInstance();
        }
        return "";
    }

    @Override
    public int getCount() {
        return 4;
    }
}
