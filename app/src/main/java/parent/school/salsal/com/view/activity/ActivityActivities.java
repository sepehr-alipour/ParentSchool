package parent.school.salsal.com.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import parent.school.salsal.com.R;
import parent.school.salsal.com.adapter.AdapterActivities;
import parent.school.salsal.com.interfaces.OnDataSelectListener;
import parent.school.salsal.com.model.ActivityRes;

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
        toolbar.setTitle("لیست فعالیت های");
        ArrayList<ActivityRes.DataBean> activities = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ActivityRes.DataBean activityRes = new ActivityRes.DataBean();
            activityRes.setTitle("فعالیت" + i);
            activityRes.setDesc("توضیح" + i);
            activityRes.setAtypeId(2);
            activityRes.setExpireDate("1397/02/05");
            activities.add(activityRes);
        }

        AdapterActivities adapterActivities = new AdapterActivities(activities, this);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapterActivities);

    }

    @Override
    public void dataSelected(Object data) {

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {


        }
    }
}
