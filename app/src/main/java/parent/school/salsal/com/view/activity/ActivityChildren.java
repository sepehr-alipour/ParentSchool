package parent.school.salsal.com.view.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import parent.school.salsal.com.R;
import parent.school.salsal.com.adapter.AdapterChildren;
import parent.school.salsal.com.model.StudentRes;
import parent.school.salsal.com.util.PreferenceManager;
import parent.school.salsal.com.webservice.APIErrorResult;
import parent.school.salsal.com.webservice.CallbackHandler;
import parent.school.salsal.com.webservice.WebServiceHelper;
import retrofit2.Response;

/**
 * Created by Sepehr on 12/4/2017.
 */

public class ActivityChildren extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.imgAvatar)
    CircleImageView imgAvatar;
    @BindView(R.id.spnChildren)
    AppCompatSpinner spnChildren;
    @BindView(R.id.btnLogin)
    AppCompatButton btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_children);
        ButterKnife.bind(this);
        btnLogin.setOnClickListener(this);

        WebServiceHelper.get(this).getParentStudents(PreferenceManager.getUserProfile(this).get(PreferenceManager.PREF_TOKEN)).enqueue(new CallbackHandler<StudentRes>(this, true, true) {
            @Override
            public void onSuccess(final Response<StudentRes> response) {
                AdapterChildren adapter = new AdapterChildren(ActivityChildren.this, response.body().getData());
                spnChildren.setAdapter(adapter);
                spnChildren.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        RequestOptions requestOptions = new RequestOptions();
                        requestOptions.placeholder(R.drawable.ic_action_profile);
                        Glide.with(ActivityChildren.this)
                                .setDefaultRequestOptions(requestOptions)
                                .load(response.body().getData().get(position).getImageUrl())
                                .into(imgAvatar);

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }

            @Override
            public void onFailed(APIErrorResult errorResult) {

            }
        });


    }

    @Override
    public void onClick(View v) {
        PreferenceManager.setCurentStudent(this, ((StudentRes.DataBean) (spnChildren.getSelectedItem())).getId());
        Intent intent = new Intent(ActivityChildren.this, ActivityMain.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}

