package parent.school.salsal.com.webservice;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonPrimitive;

import parent.school.salsal.com.R;
import parent.school.salsal.com.view.activity.ActivityLoading;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Kasper on 11/16/2015.
 */
public abstract class CallbackHandler<T> implements Callback<T> {
    Context context;
    boolean showLoading;
    boolean showError;

    public CallbackHandler(Context context, boolean showLoading, boolean showError) {
        this.context = context;
        this.showLoading = showLoading;
        this.showError = showError;
        if (showLoading) {
            context.startActivity(new Intent(context, ActivityLoading.class));
        }
    }

    public CallbackHandler(Context context, boolean showLoading) {
        this.context = context;
        this.showLoading = this.showError = showLoading;
        if (showLoading) {
            context.startActivity(new Intent(context, ActivityLoading.class));

        }
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {


        //MessageBox.HideLoading(context);

        if (response.isSuccessful() && response.body() != null) {
            onSuccess(response);
            if (ActivityLoading.instance != null) {
                ActivityLoading.instance.finish();
            }
        } else {
            APIErrorResult apiErrorResult = null;
            try {
                if (ActivityLoading.instance != null) {
                    ActivityLoading.instance.finish();
                }
                apiErrorResult = new Gson().fromJson(response.errorBody().string(), APIErrorResult.class);
                apiErrorResult.setCode(response.code());

            } catch (Exception e) {
                e.printStackTrace();
            }
            if (apiErrorResult == null) {

                apiErrorResult = new APIErrorResult();
                apiErrorResult.setCode(-1);
                apiErrorResult.setMessage(new JsonPrimitive(context.getResources().getString(R.string.failed_server)));
            }
            if (showError) {
                //MessageBox.Show(context, context.getResources().getString(R.string.error), apiErrorResult.getMessage(), null, MessageBox.MessageBoxIcon.Error);
            }
            onFailed(apiErrorResult);

        }


    }


    @Override
    public void onFailure(Call<T> call, Throwable t) {

        Log.i("TestApiListBid", "onFailed");

    }


    public abstract void onSuccess(Response<T> response);

    public abstract void onFailed(APIErrorResult errorResult);
}
