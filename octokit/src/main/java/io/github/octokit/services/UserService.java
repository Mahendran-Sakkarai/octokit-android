package io.github.octokit.services;

import io.github.octokit.model.authorization.AuthorizationResponse;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Mahendran Sakkarai on 1/8/2017.
 */

public interface UserService {
    @Headers("Content-type: application/json")
    @POST("authorization")
    Call<AuthorizationResponse> login(@Header("Authorization") String authorization,
                                      @Body RequestBody scope);
}
