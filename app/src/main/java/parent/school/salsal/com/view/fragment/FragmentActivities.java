package parent.school.salsal.com.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import parent.school.salsal.com.R;

public class FragmentActivities extends Fragment {


    public FragmentActivities() {
        // Required empty public constructor
    }

    public static FragmentActivities newInstance() {
        FragmentActivities fragment = new FragmentActivities();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_activities, container, false);
    }

}
