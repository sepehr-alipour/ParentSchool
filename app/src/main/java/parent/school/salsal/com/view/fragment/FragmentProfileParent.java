package parent.school.salsal.com.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;
import parent.school.salsal.com.R;

public class FragmentProfileParent extends BaseFragment {

    @BindView(R.id.txtName)
    TextView txtName;
    @BindView(R.id.profile_image)
    CircleImageView profileImage;
    @BindView(R.id.txtEducation)
    TextView txtEducation;
    @BindView(R.id.txtBirthday)
    TextView txtBirthday;
    @BindView(R.id.txtEmail)
    TextView txtEmail;
    @BindView(R.id.txtMobile)
    TextView txtMobile;
    @BindView(R.id.txtNationalCode)
    TextView txtNationalCode;
    @BindView(R.id.list)
    NestedScrollView list;
    Unbinder unbinder;

    public static FragmentProfileParent newInstance() {
        FragmentProfileParent fragment = new FragmentProfileParent();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_parent, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
