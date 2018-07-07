package parent.school.salsal.com.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import parent.school.salsal.com.R;
import parent.school.salsal.com.adapter.AdapterSchedule;
import parent.school.salsal.com.model.ScheduleRes;

public class FragmentScheduleWeekly extends BaseFragment {
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


    public FragmentScheduleWeekly() {
        // Required empty public constructor
    }

    public static FragmentScheduleWeekly newInstance() {
        FragmentScheduleWeekly fragment = new FragmentScheduleWeekly();
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

        View view = inflater.inflate(R.layout.fragment_schedule_weekly, container, false);
        unbinder = ButterKnife.bind(this, view);
        List<ScheduleRes.DataBean> schedules = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ScheduleRes.DataBean schedule = new ScheduleRes.DataBean();
            schedule.setDayOfWeek(i);
            schedule.setPriority(i);
            schedules.add(schedule);
        }
        AdapterSchedule adapterSchedule = new AdapterSchedule(schedules);
        list.setLayoutManager(new LinearLayoutManager(getContext()));
        list.setAdapter(adapterSchedule);
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
}
