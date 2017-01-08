package io.github.octokit.request;

/**
 * Created by Mahendran Sakkarai on 1/8/2017.
 */

public interface Callback<T> {
    void onSuccess(T response);

    void onError(String error);
}
