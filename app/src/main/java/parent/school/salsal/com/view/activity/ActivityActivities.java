package parent.school.salsal.com.view.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import parent.school.salsal.com.R;
import parent.school.salsal.com.adapter.AdapterActivities;
import parent.school.salsal.com.interfaces.OnDataSelectListener;
import parent.school.salsal.com.model.ActivityRes;
import parent.school.salsal.com.util.PreferenceManager;
import parent.school.salsal.com.webservice.APIErrorResult;
import parent.school.salsal.com.webservice.CallbackHandler;
import parent.school.salsal.com.webservice.WebServiceHelper;
import retrofit2.Response;

public class ActivityActivities extends BaseActivity implements OnDataSelectListener, View.OnClickListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.list)
    RecyclerView list;
    public static final String INTENT_KEY_COURSE_ID = "course_id";
    public static final String INTENT_KEY_CLASS_ID = "class_id";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);
        ButterKnife.bind(this);
        int courseId = getIntent().getIntExtra(INTENT_KEY_COURSE_ID, -1);
        int classId = getIntent().getIntExtra(INTENT_KEY_CLASS_ID, -1);
        toolbar.setTitle(R.string.title_activities);

        WebServiceHelper.get(this).getActivities(PreferenceManager.getCurrentStudentId(this), PreferenceManager.getUserProfile(this).get(PreferenceManager.PREF_TOKEN)).enqueue(new CallbackHandler<ActivityRes>(this, true, true) {
            @Override
            public void onSuccess(Response<ActivityRes> response) {
                AdapterActivities adapterActivities = new AdapterActivities(response.body().getData(), ActivityActivities.this);
                list.setLayoutManager(new LinearLayoutManager(ActivityActivities.this));
                list.setAdapter(adapterActivities);
            }

            @Override
            public void onFailed(APIErrorResult errorResult) {

            }
        });


    }

    @Override
    public void dataSelected(Object data) {
        Intent intent = new Intent(this, ActivityDetails.class);
        intent.putExtra(ActivityDetails.PARAM_ACTIVITY_ID, ((ActivityRes.DataBean) data).getId());
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {


        }
    }
}
