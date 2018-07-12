package parent.school.salsal.com.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import parent.school.salsal.com.R;
import parent.school.salsal.com.adapter.AdapterSchools;
import parent.school.salsal.com.adapter.AdapterTeachers;
import parent.school.salsal.com.interfaces.OnDataSelectListener;
import parent.school.salsal.com.model.SchoolListRes;
import parent.school.salsal.com.model.TeacherProfileRes;

public class FragmentProfileTeachers extends BaseFragment implements OnDataSelectListener {

    @BindView(R.id.list)
    RecyclerView list;
    Unbinder unbinder;

    public static FragmentProfileTeachers newInstance() {
        FragmentProfileTeachers fragment = new FragmentProfileTeachers();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teachers, container, false);
        unbinder = ButterKnife.bind(this, view);

        ArrayList<TeacherProfileRes> listTeachers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TeacherProfileRes teacherItem = new TeacherProfileRes();
            teacherItem.setName("معلم" + i);
            teacherItem.setImageUrl("https://pickaface.net/gallery/avatar/unr_paii_180627_0934_vpwcm.png");
            listTeachers.add(teacherItem);
        }
        AdapterTeachers adapterSchoolList = new AdapterTeachers(listTeachers, this);
        list.setLayoutManager(new LinearLayoutManager(getContext()));
        list.setAdapter(adapterSchoolList);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public void dataSelected(Object data) {

    }
}
