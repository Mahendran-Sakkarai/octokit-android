package io.github.octokit.model.authorization;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Mahendran Sakkarai on 1/9/2017.
 */

public class LoginRequest {
    @SerializedName("note")
    private String note;

    @SerializedName("scopes")
    private HashSet<String> scopes;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public HashSet<String> getScopes() {
        return scopes;
    }

    public void setScopes(HashSet<String> scopes) {
        this.scopes = scopes;
    }
}
