package parent.school.salsal.com.webservice;

import android.content.Context;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import parent.school.salsal.com.R;
import parent.school.salsal.com.interfaces.ApiInterface;
import parent.school.salsal.com.util.PreferenceManager;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Kasper on 11/16/2015.
 */
public class WebServiceHelper {

    private WebServiceHelper() {
    }

    public static ApiInterface get(String url) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                //  .client(okClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ApiInterface.class);
    }

    public static ApiInterface get(Context context) {
        OkHttpClient okClient = new OkHttpClient.Builder()
                .connectTimeout(40, TimeUnit.SECONDS)
                .readTimeout(40, TimeUnit.SECONDS)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PreferenceManager.getUrl() != null ? PreferenceManager.getUrl() : context.getString(R.string.BASE_URL))
                //  .client(okClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ApiInterface.class);
    }


}

