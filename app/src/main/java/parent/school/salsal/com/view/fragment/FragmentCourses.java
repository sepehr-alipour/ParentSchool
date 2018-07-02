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
import parent.school.salsal.com.adapter.AdapterCourseList;
import parent.school.salsal.com.adapter.OnReceiverClickListener;
import parent.school.salsal.com.model.CourseRes;
import parent.school.salsal.com.model.ReceiverMessageItem;
import parent.school.salsal.com.model.StudentRes;

public class FragmentCourses extends BaseFragment implements OnReceiverClickListener {

    @BindView(R.id.list)
    RecyclerView list;
    Unbinder unbinder;

    public static FragmentCourses newInstance() {
        FragmentCourses fragment = new FragmentCourses();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_courses, container, false);
        unbinder = ButterKnife.bind(this, view);

        ArrayList<CourseRes.DataBean> courses = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CourseRes.DataBean courseRes = new CourseRes.DataBean();
            courseRes.setTitle("درس" + i);
            courses.add(courseRes);
        }
        AdapterCourseList adapterCourseList = new AdapterCourseList(courses, this);
        list.setLayoutManager(new LinearLayoutManager(getContext()));
        list.setAdapter(adapterCourseList);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void clicked(ReceiverMessageItem receiverMessageItem, int position) {

    }

    @Override
    public void clicked(StudentRes.DataBean studentRes, int position) {

    }

    @Override
    public void clicked(CourseRes.DataBean courseRes, int position) {

    }
}
