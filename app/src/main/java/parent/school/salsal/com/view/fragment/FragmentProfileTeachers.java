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
import parent.school.salsal.com.adapter.AdapterTeachers;
import parent.school.salsal.com.interfaces.OnDataSelectListener;
import parent.school.salsal.com.model.TeachersProfileRes;
import parent.school.salsal.com.util.PreferenceManager;
import parent.school.salsal.com.view.activity.ActivityTeacherProfile;
import parent.school.salsal.com.webservice.APIErrorResult;
import parent.school.salsal.com.webservice.CallbackHandler;
import parent.school.salsal.com.webservice.WebServiceHelper;
import retrofit2.Response;

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


        WebServiceHelper.get(getContext()).getTeachers(PreferenceManager.getCurrentStudentId(getContext()),
                PreferenceManager.getUserProfile(getContext()).get(PreferenceManager.PREF_TOKEN)).enqueue(new CallbackHandler<TeachersProfileRes>(getContext(), true, true) {
            @Override
            public void onSuccess(Response<TeachersProfileRes> response) {
                AdapterTeachers adapterSchoolList = new AdapterTeachers(response.body().getData(), FragmentProfileTeachers.this);
                list.setLayoutManager(new LinearLayoutManager(getContext()));
                list.setAdapter(adapterSchoolList);
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
    public void dataSelected(Object data) {
        Intent intent = new Intent(getContext(), ActivityTeacherProfile.class);
        intent.putExtra(ActivityTeacherProfile.EXTRA_TEACHER_ID, ((TeachersProfileRes.DataBean) data).getId());
        startActivity(intent);
    }
}
