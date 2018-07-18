package parent.school.salsal.com.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import parent.school.salsal.com.R;
import parent.school.salsal.com.adapter.AdapterAttendance;
import parent.school.salsal.com.adapter.AdapterCourseList;
import parent.school.salsal.com.interfaces.OnDataSelectListener;
import parent.school.salsal.com.model.AttendanceRes;
import parent.school.salsal.com.model.CourseRes;
import parent.school.salsal.com.util.PreferenceManager;
import parent.school.salsal.com.webservice.APIErrorResult;
import parent.school.salsal.com.webservice.CallbackHandler;
import parent.school.salsal.com.webservice.WebServiceHelper;
import retrofit2.Response;

public class FragmentAttendance extends BaseFragment implements OnDataSelectListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Unbinder unbinder;
    @BindView(R.id.list)
    RecyclerView list;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public FragmentAttendance() {
        // Required empty public constructor
    }

    public static FragmentAttendance newInstance() {
        FragmentAttendance fragment = new FragmentAttendance();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_attendance, container, false);
        unbinder = ButterKnife.bind(this, view);
        WebServiceHelper.get(getContext()).getAttendance(PreferenceManager.getCurrentStudentId(getContext()),
                PreferenceManager.getUserProfile(getContext()).get(PreferenceManager.PREF_TOKEN)).enqueue(new CallbackHandler<AttendanceRes>(getContext(), true, true) {
            @Override
            public void onSuccess(Response<AttendanceRes> response) {
                AdapterAttendance adapterCourseList = new AdapterAttendance(response.body().getData(), FragmentAttendance.this);
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
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
        }
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
