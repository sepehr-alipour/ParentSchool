package parent.school.salsal.com.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import parent.school.salsal.com.R;
import parent.school.salsal.com.adapter.AdapterCourseList;
import parent.school.salsal.com.adapter.OnReceiverClickListener;
import parent.school.salsal.com.model.CourseRes;
import parent.school.salsal.com.model.ReceiverMessageItem;
import parent.school.salsal.com.model.StudentRes;
import parent.school.salsal.com.util.PreferenceManager;
import parent.school.salsal.com.view.activity.ActivityActivities;
import parent.school.salsal.com.webservice.APIErrorResult;
import parent.school.salsal.com.webservice.CallbackHandler;
import parent.school.salsal.com.webservice.WebServiceHelper;
import retrofit2.Response;

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


        WebServiceHelper.get(getContext()).getCourses(PreferenceManager.getCurrentStudentId(getContext()),
                PreferenceManager.getUserProfile(getContext()).get(PreferenceManager.PREF_TOKEN)).enqueue(new CallbackHandler<CourseRes>(getContext(), true, true) {
            @Override
            public void onSuccess(Response<CourseRes> response) {
                AdapterCourseList adapterCourseList = new AdapterCourseList(response.body().getData(), FragmentCourses.this);
                list.setLayoutManager(new LinearLayoutManager(getContext()));
                list.setAdapter(adapterCourseList);
            }

            @Override
            public void onFailed(APIErrorResult errorResult) {

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
    public void clicked(ReceiverMessageItem receiverMessageItem, int position) {

    }

    @Override
    public void clicked(StudentRes.DataBean studentRes, int position) {

    }

    @Override
    public void clicked(CourseRes.DataBean courseRes, int position) {
        startActivity(new Intent(getContext(), ActivityActivities.class));
    }
}
