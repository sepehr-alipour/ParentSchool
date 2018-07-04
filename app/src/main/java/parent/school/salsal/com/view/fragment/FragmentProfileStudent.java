package parent.school.salsal.com.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;
import parent.school.salsal.com.R;

public class FragmentProfileStudent extends BaseFragment {
    @BindView(R.id.txtName)
    TextView txtName;
    @BindView(R.id.profile_image)
    CircleImageView profileImage;
    @BindView(R.id.btnChangeStudent)
    AppCompatButton btnChangeStudent;
    @BindView(R.id.txtStdId)
    TextView txtStdId;
    @BindView(R.id.txtBirthday)
    TextView txtBirthday;
    @BindView(R.id.txtNationalCode)
    TextView txtNationalCode;
    @BindView(R.id.list)
    NestedScrollView list;
    Unbinder unbinder;

    public static FragmentProfileStudent newInstance() {
        FragmentProfileStudent fragment = new FragmentProfileStudent();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_student, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
