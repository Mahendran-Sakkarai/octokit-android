package io.github.octokit.model.authorization;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mahendran Sakkarai on 1/8/2017.
 */
class Application {
    @SerializedName("name")
    private String name;

    @SerializedName("url")
    private String url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
