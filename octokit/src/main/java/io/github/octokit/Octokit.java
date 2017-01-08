package io.github.octokit;

import android.util.Base64;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;

import io.github.octokit.model.authorization.AuthorizationResponse;
import io.github.octokit.model.authorization.LoginRequest;
import io.github.octokit.model.authorization.Scope;
import io.github.octokit.request.Callback;
import io.github.octokit.services.UserService;
import io.github.octokit.util.OctokitUtil;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mahendran Sakkarai on 1/8/2017.
 */

public class Octokit {
    private static Octokit INSTANCE;
    private static String BASE_URL = "https://api.github.com";
    private static Retrofit.Builder mBuilder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    public Octokit init() {
        if (INSTANCE == null) {
            synchronized (Octokit.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Octokit();
                }
            }
        }
        return INSTANCE;
    }

    private Octokit(){
        // Initialized to restrict to create object outside
    }

    public void login(String username, String password, ArrayList<Scope> scopes,
                      final Callback callback){
        if (username != null && password != null) {
            // Converting the username and password as baseencoded string to add it in header
            String credentials = username + ":" + password;
            final String basic = "Basic " + Base64
                    .encodeToString(credentials.getBytes(), Base64.NO_WRAP);

            // Creating requestBody with the scope details
            LoginRequest loginRequest = new LoginRequest();
            // Creating a random uuid as note to request for login.
            loginRequest.setNote(UUID.randomUUID().toString());
            HashSet<String> scopesToRequest = OctokitUtil.getScopes(scopes);
            if (scopesToRequest.size() > 0)
                loginRequest.setScopes(scopesToRequest);

            // Creating request body appending with the data.
            RequestBody body = RequestBody.create(
                    MediaType.parse("application/json; charset=utf-8"),
                    new Gson().toJson(loginRequest));

            Call<AuthorizationResponse> call = mBuilder.build()
                    .create(UserService.class).login(basic, body);
            call.enqueue(new retrofit2.Callback<AuthorizationResponse>() {
                @Override
                public void onResponse(Call<AuthorizationResponse> call, Response<AuthorizationResponse> response) {
                    callback.onSuccess(response.body());
                }

                @Override
                public void onFailure(Call<AuthorizationResponse> call, Throwable t) {
                    callback.onError(t.toString());
                }
            });
        } else {
            callback.onError("Username and Password are required fields!");
        }
    }
}
