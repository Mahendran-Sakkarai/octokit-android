package io.github.octokit.util;

import java.util.ArrayList;
import java.util.HashSet;

import io.github.octokit.model.authorization.Scope;

/**
 * Created by Mahendran Sakkarai on 1/9/2017.
 */
public class OctokitUtil {
    public static HashSet<String> getScopes(ArrayList<Scope> scopes) {
        HashSet<String> scopesToAdd = new HashSet<>();

        for (Scope scope : scopes) {
            scopesToAdd.add(scope.getScope());
            if (scope.getScopes() != null) {
                for (Scope nestedScope : scopes) {
                    scopesToAdd.add(nestedScope.getScope());
                }
            }
        }

        return scopesToAdd;
    }
}
