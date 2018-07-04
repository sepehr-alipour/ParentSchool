package parent.school.salsal.com.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import parent.school.salsal.com.R;

public class FragmentProfileStudent extends BaseFragment {
    public static FragmentProfileStudent newInstance() {
        FragmentProfileStudent fragment = new FragmentProfileStudent();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_student, container, false);
        return view;
    }

}
