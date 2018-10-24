package parent.school.salsal.com.view.activity;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.internal.operators.parallel.ParallelFromArray;
import parent.school.salsal.com.R;
import parent.school.salsal.com.model.ActivityDetailRes;
import parent.school.salsal.com.model.ActivityRes;
import parent.school.salsal.com.util.PreferenceManager;
import parent.school.salsal.com.webservice.APIErrorResult;
import parent.school.salsal.com.webservice.CallbackHandler;
import parent.school.salsal.com.webservice.WebServiceHelper;
import retrofit2.Response;

public class ActivityDetails extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.txt_details)
    TextView txtDetails;
    @BindView(R.id.btnSendMessage)
    AppCompatButton btnSendMessage;
    @BindView(R.id.list)
    RecyclerView list;
    @BindView(R.id.bottom_sheet)
    LinearLayout bottomSheet;

    public static final String PARAM_ACTIVITY_ID = "activity_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_details);
        ButterKnife.bind(this);
        int activityId = getIntent().getIntExtra(PARAM_ACTIVITY_ID, -1);
        String token = PreferenceManager.getUserProfile(this).get(PreferenceManager.PREF_TOKEN);
        WebServiceHelper.get(this).getActivityDetails(activityId, token).enqueue(new CallbackHandler<ActivityDetailRes>(this, true, true) {
            @Override
            public void onSuccess(Response<ActivityDetailRes> response) {
                txtDetails.setText(response.body().getData().get(0).getActivityDesc());
                txtTitle.setText(response.body().getData().get(0).getActivityTitle());
            }

            @Override
            public void onFailed(APIErrorResult errorResult) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        //todo answer activity
        //WebServiceHelper.get(this)
    }
}
