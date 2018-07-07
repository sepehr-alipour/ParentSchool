package parent.school.salsal.com.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import parent.school.salsal.com.R;
import parent.school.salsal.com.adapter.AdapterSpinnerSchool;
import parent.school.salsal.com.model.SchoolListRes;


public class ActivitySchools extends BaseActivity {

    @BindView(R.id.edtAutoSchools)
    AppCompatAutoCompleteTextView edtAutoSchools;
    @BindView(R.id.btnLogin)
    AppCompatButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schools);
        ButterKnife.bind(this);

        String[] schools = getResources().getStringArray(R.array.schools);
        ArrayList<SchoolListRes> list = new ArrayList<>();
        for (int i = 0; i < schools.length; i++) {
            SchoolListRes schoolListRes = new SchoolListRes();
            schoolListRes.setName(schools[i]);
            schoolListRes.setLogo(R.drawable.logo);
            list.add(schoolListRes);
        }
        AdapterSpinnerSchool adapter = new AdapterSpinnerSchool(this, list);
        edtAutoSchools.setAdapter(adapter);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivitySchools.this, ActivityLogin.class));
            }
        });

    }
}
