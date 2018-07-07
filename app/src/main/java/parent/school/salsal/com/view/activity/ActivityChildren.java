package parent.school.salsal.com.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import parent.school.salsal.com.R;
import parent.school.salsal.com.adapter.AdapterChildren;
import parent.school.salsal.com.model.StudentRes;

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

        String[] schools = getResources().getStringArray(R.array.students);
        final ArrayList<StudentRes> list = new ArrayList<>();
        for (int i = 0; i < schools.length; i++) {
            StudentRes schoolListRes = new StudentRes();
            schoolListRes.setName(schools[i]);
            schoolListRes.setAvatar("https://pickaface.net/gallery/avatar/unr_paii_180627_0934_vpwcm.png");
            list.add(schoolListRes);
        }
        AdapterChildren adapter = new AdapterChildren(this, list);
        spnChildren.setAdapter(adapter);
        spnChildren.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                RequestOptions requestOptions = new RequestOptions();
                requestOptions.placeholder(R.drawable.ic_action_profile);
                Glide.with(ActivityChildren.this)
                        .setDefaultRequestOptions(requestOptions)
                        .load(list.get(position).getAvatar())
                        .into(imgAvatar);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(ActivityChildren.this, ActivityMain.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}

