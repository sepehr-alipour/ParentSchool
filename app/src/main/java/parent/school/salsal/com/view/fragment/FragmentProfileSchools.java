package parent.school.salsal.com.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import parent.school.salsal.com.R;
import parent.school.salsal.com.adapter.AdapterSchools;
import parent.school.salsal.com.interfaces.OnDataSelectListener;
import parent.school.salsal.com.model.LoginReq;
import parent.school.salsal.com.util.PreferenceManager;

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

        ArrayList<LoginReq> listSchools = PreferenceManager.getSchoolConnections();
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
