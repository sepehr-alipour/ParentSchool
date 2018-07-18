package parent.school.salsal.com.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import parent.school.salsal.com.R;
import parent.school.salsal.com.model.LoginReq;
import parent.school.salsal.com.model.LoginRes;
import parent.school.salsal.com.util.PreferenceManager;
import parent.school.salsal.com.webservice.APIErrorResult;
import parent.school.salsal.com.webservice.CallbackHandler;
import parent.school.salsal.com.webservice.WebServiceHelper;
import retrofit2.Response;

/**
 * Created by Sepehr on 12/4/2017.
 */

public class ActivityLogin extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.edtUsername)
    AppCompatEditText edtUsername;
    @BindView(R.id.edtPassword)
    AppCompatEditText edtPassword;
    @BindView(R.id.btnLogin)
    AppCompatButton btnLogin;
    private boolean inEdit = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        btnLogin.setOnClickListener(this);

     /*   LoginReq schoolConnection = PreferenceManager.getSchoolConnection(getIntent().getIntExtra(FragmentAddSchool.INTENT_KEY_SCHOOL_ID, -1));
        if (schoolConnection != null) {
            inEdit = true;
            edtPassword.setText(schoolConnection.getPassword());
            edtUsername.setText(schoolConnection.getUsername());
            edtUrl.setText(schoolConnection.getConnectionUrl());
            edtSchoolName.setText(schoolConnection.getSchoolName());
        }*/
    }

    @Override
    public void onClick(View v) {


        if (TextUtils.isEmpty(edtPassword.getText().toString()) ||
                TextUtils.isEmpty(edtUsername.getText().toString()) ||
                TextUtils.isEmpty(edtUsername.getText().toString())) {

            Toast.makeText(ActivityLogin.this, getString(R.string.toast_empty_edittext), Toast.LENGTH_SHORT).show();
        } else {
            final LoginReq loginReq = PreferenceManager.getSchoolConnection(PreferenceManager.getSchoolConnections().size());
            loginReq.setUsername(edtUsername.getText().toString());
            loginReq.setPassword(edtPassword.getText().toString());
            if (inEdit) {
         /*       int id = getIntent().getIntExtra(FragmentAddSchool.INTENT_KEY_SCHOOL_ID, -1);
                loginReq.setId(PreferenceManager.getSchoolConnection(id).getId());
                loginReq.setChecked(PreferenceManager.getSchoolConnection(id).isChecked());
                PreferenceManager.updateSchoolConnection(loginReq);

                setResult(RESULT_OK);
                finish();*/
            } else {

                loginReq.setChecked(true);

                PreferenceManager.updateSchoolConnection(loginReq);
                WebServiceHelper.get(ActivityLogin.this).loginUser(loginReq).enqueue(new CallbackHandler<LoginRes>(ActivityLogin.this, true, true) {
                    @Override
                    public void onSuccess(Response<LoginRes> response) {
                        PreferenceManager.SaveUserProfile(ActivityLogin.this, response.body().getData().getUserId(), response.body().getData().getToken());
                        Intent intent = new Intent(ActivityLogin.this, ActivityChildren.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailed(APIErrorResult errorResult) {
                        PreferenceManager.removeSchoolConnection(loginReq);
                        Toast.makeText(ActivityLogin.this, errorResult.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }

    }
}
