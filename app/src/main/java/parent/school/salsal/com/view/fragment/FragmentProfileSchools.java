package parent.school.salsal.com.view.fragment;

import android.content.Intent;
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
import parent.school.salsal.com.adapter.OnReceiverClickListener;
import parent.school.salsal.com.adapter.AdapterSpinnerSchool;
import parent.school.salsal.com.interfaces.OnDataSelectListener;
import parent.school.salsal.com.model.CourseRes;
import parent.school.salsal.com.model.ReceiverMessageItem;
import parent.school.salsal.com.model.SchoolListRes;
import parent.school.salsal.com.model.StudentRes;
import parent.school.salsal.com.view.activity.ActivityActivities;

public class FragmentProfileSchools extends BaseFragment implements OnDataSelectListener {

    @BindView(R.id.list)
    RecyclerView list;
    Unbinder unbinder;

    public static FragmentProfileSchools newInstance() {
        FragmentProfileSchools fragment = new FragmentProfileSchools();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schools, container, false);
        unbinder = ButterKnife.bind(this, view);

        String[] schools = getResources().getStringArray(R.array.schools);
        ArrayList<SchoolListRes> listSchools = new ArrayList<>();
        for (int i = 0; i < schools.length; i++) {
            SchoolListRes schoolListRes = new SchoolListRes();
            schoolListRes.setName(schools[i]);
           // schoolListRes.setLogo(R.drawable.logo);
            listSchools.add(schoolListRes);
        }
        AdapterSchools adapterSchoolList = new AdapterSchools(listSchools, this);
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
