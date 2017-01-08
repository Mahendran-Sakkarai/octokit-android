package io.github.octokit.model.authorization;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Mahendran Sakkarai on 1/8/2017.
 */
public class AuthorizationResponse {
    @SerializedName("id")
    private int id;

    @SerializedName("scopes")
    private ArrayList<String> scopes;

    @SerializedName("token")
    private String token;

    @SerializedName("token_last_eight")
    private String tokenLastEight;

    @SerializedName("hashed_token")
    private String hashedToken;

    @SerializedName("url")
    private String url;

    @SerializedName("app")
    private Application app;

    @SerializedName("note")
    private String note;

    @SerializedName("note_url")
    private String noteUrl;

    @SerializedName("fingerprint")
    private String fingerPrint;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("updated_at")
    private String updatedAt;

    public int getId() {
        return id;
    }

    public ArrayList<String> getScopes() {
        return scopes;
    }

    public String getToken() {
        return token;
    }

    public String getTokenLastEight() {
        return tokenLastEight;
    }

    public String getHashedToken() {
        return hashedToken;
    }

    public String getUrl() {
        return url;
    }

    public Application getApp() {
        return app;
    }

    public String getNote() {
        return note;
    }

    public String getNoteUrl() {
        return noteUrl;
    }

    public String getFingerPrint() {
        return fingerPrint;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}
