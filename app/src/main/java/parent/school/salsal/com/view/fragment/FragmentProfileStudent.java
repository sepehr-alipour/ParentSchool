package parent.school.salsal.com.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;
import parent.school.salsal.com.R;
import parent.school.salsal.com.model.StudentProfileRes;
import parent.school.salsal.com.model.StudentRes;
import parent.school.salsal.com.util.PreferenceManager;
import parent.school.salsal.com.view.activity.ActivityChildren;
import parent.school.salsal.com.view.activity.ActivityLogin;
import parent.school.salsal.com.webservice.APIErrorResult;
import parent.school.salsal.com.webservice.CallbackHandler;
import parent.school.salsal.com.webservice.WebServiceHelper;
import retrofit2.Response;

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
        WebServiceHelper.get(getContext()).getStudentProfile(PreferenceManager.getCurrentStudentId(getContext()), PreferenceManager.getUserProfile(getContext()).get(PreferenceManager.PREF_TOKEN)).enqueue(new CallbackHandler<StudentProfileRes>(getContext(), true, true) {
            @Override
            public void onSuccess(Response<StudentProfileRes> response) {
                if (isAdded()) {
                    txtStdId.setText(response.body().getData().getId() + "");
                    txtName.setText(response.body().getData().getName());
                    txtBirthday.setText(response.body().getData().getBirthDate() + "");
                    txtNationalCode.setText(response.body().getData().getNationalCode() + "");
                    RequestOptions requestOptions = new RequestOptions();
                    requestOptions.placeholder(R.drawable.ic_action_profile);
                    Glide.with(getContext())
                            .setDefaultRequestOptions(requestOptions)
                            .load(response.body().getData().getImageUrl())
                            .into(profileImage);
                }
            }

            @Override
            public void onFailed(APIErrorResult errorResult) {

            }
        });
        btnChangeStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ActivityChildren.class);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
