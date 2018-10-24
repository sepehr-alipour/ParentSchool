package parent.school.salsal.com.view.activity;

import android.os.Bundle;
import androidx.core.widget.NestedScrollView;
import androidx.appcompat.widget.AppCompatRatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;
import parent.school.salsal.com.R;
import parent.school.salsal.com.model.TeacherProfileRes;
import parent.school.salsal.com.util.PreferenceManager;
import parent.school.salsal.com.util.Utils;
import parent.school.salsal.com.webservice.APIErrorResult;
import parent.school.salsal.com.webservice.CallbackHandler;
import parent.school.salsal.com.webservice.WebServiceHelper;
import retrofit2.Response;

public class ActivityTeacherProfile extends BaseActivity {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Unbinder unbinder;
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
    @BindView(R.id.ratingBar)
    AppCompatRatingBar ratingBar;
    /*@BindView(R.id.fabEdit)
    FloatingActionButton fabEdit;*/
    @BindView(R.id.list)
    NestedScrollView list;

    public static final String EXTRA_TEACHER_ID = "teacher_id";
    @BindView(R.id.profile_image)
    CircleImageView profileImage;
    @BindView(R.id.txt_name)
    TextView txtName;

    public ActivityTeacherProfile() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_profile);
        unbinder = ButterKnife.bind(this);
        int id = getIntent().getIntExtra(EXTRA_TEACHER_ID, -1);
        WebServiceHelper.get(this).getTeacherProfile(id, PreferenceManager.getUserProfile(this).get(PreferenceManager.PREF_TOKEN)).enqueue(new CallbackHandler<TeacherProfileRes>(this, true, true) {
            @Override
            public void onSuccess(Response<TeacherProfileRes> response) {
                txtBirthday.setText(Utils.convertBirthdayToString(response.body().getData().getBirthDate()));
                txtEducation.setText(response.body().getData().getEducation());
                txtEmail.setText(response.body().getData().getEmail());
                txtMobile.setText(response.body().getData().getPhoneNumber());
                txtNationalCode.setText(response.body().getData().getNationalCode());
                ratingBar.setRating(response.body().getData().getRate());
                txtName.setText(response.body().getData().getName());
                RequestOptions requestOptions = new RequestOptions();
                requestOptions.placeholder(R.drawable.ic_action_profile);
                Glide.with(ActivityTeacherProfile.this)
                        .setDefaultRequestOptions(requestOptions)
                        .load(response.body().getData().getImageUrl())
                        .into(profileImage);
            }

            @Override
            public void onFailed(APIErrorResult errorResult) {

            }
        });

    }


}
