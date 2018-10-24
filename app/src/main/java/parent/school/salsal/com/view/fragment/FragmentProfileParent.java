package parent.school.salsal.com.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;
import parent.school.salsal.com.R;
import parent.school.salsal.com.model.ParentProfileRes;
import parent.school.salsal.com.util.PreferenceManager;
import parent.school.salsal.com.util.Utils;
import parent.school.salsal.com.webservice.APIErrorResult;
import parent.school.salsal.com.webservice.CallbackHandler;
import parent.school.salsal.com.webservice.WebServiceHelper;
import retrofit2.Response;

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
        final String token = PreferenceManager.getUserProfile(getContext()).get(PreferenceManager.PREF_TOKEN);
        WebServiceHelper.get(getContext()).getParentProfile(PreferenceManager.getUserProfile(getContext()).get(PreferenceManager.PREF_USER_ID)
                , token)
                .enqueue(new CallbackHandler<ParentProfileRes>(getContext(), true, true) {
                    @Override
                    public void onSuccess(Response<ParentProfileRes> response) {
                        if (isAdded()) {
                            txtName.setText(response.body().getData().getName());
                            txtBirthday.setText(Utils.convertBirthdayToString(response.body().getData().getBirthDate()));
                            txtEducation.setText(response.body().getData().getEducation());
                            txtMobile.setText(response.body().getData().getPhoneNumber());
                            txtEmail.setText(response.body().getData().getEmail());
                            txtNationalCode.setText(response.body().getData().getNationalCode());
                            PreferenceManager.SaveUserProfile(getContext(),
                                    response.body().getData().getUserId() + "",
                                    response.body().getData().getId() + "",
                                    token);
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
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
