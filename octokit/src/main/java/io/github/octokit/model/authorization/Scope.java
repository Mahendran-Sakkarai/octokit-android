package io.github.octokit.model.authorization;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Mahendran Sakkarai on 1/8/2017.
 * <p>
 * Scopes defined in Github developer documentation.
 * For more details check https://developer.github.com/v3/oauth/#scopes
 */

public enum Scope {
    /**
     * Grants read-only access to public information (includes public user profile info, public
     * repository info, and gists)
     */
    NO_SCOPE(null),

    /**
     * Grants read access to a user's email addresses.
     */
    USER_EMAIL("user:email"),

    /**
     * Grants access to follow or unfollow other users.
     */
    USER_FOLLOW("user:follow"),

    /**
     * Grants read/write access to profile info only. Note that this scope includes user:email
     * and user:follow.
     */
    USER("user", new ArrayList<>(Arrays.asList(Scope.USER_EMAIL, Scope.USER_FOLLOW))),

    /**
     * Grants read/write access to code, commit statuses, collaborators, and deployment statuses
     * for public repositories and organizations. Also required for starring public repositories.
     */
    PUBLIC_REPO("public_repo"),

    /**
     * Grants access to deployment statuses for public and private repositories.
     * This scope is only necessary to grant other users or services access to deployment statuses,
     * without granting access to the code.
     */
    REPO_DEPLOYMENT("repo_deployment"),

    /**
     * Grants read/write access to public and private repository commit statuses.
     * This scope is only necessary to grant other users or services access to private repository
     * commit statuses without granting access to the code.
     */
    REPO_STATUS("repo:status"),

    /**
     * Grants read/write access to code, commit statuses, invitations, collaborators, adding
     * team memberships, and deployment statuses for public and private repositories and
     * organizations.
     */
    REPO("repo", new ArrayList<>(
            Arrays.asList(Scope.REPO_STATUS, Scope.REPO_DEPLOYMENT, Scope.PUBLIC_REPO))),

    /**
     * Grants access to delete adminable repositories.
     */
    DELETE_REPO("delete_repo"),

    /**
     * Grants read access to a user's notifications. repo also provides this access.
     */
    NOTIFICATIONS("notifications"),

    /**
     * Grants write access to gists.
     */
    GIST("gist"),

    /**
     * Grants read and ping access to hooks in public or private repositories.
     */
    READ_REPO_HOOK("read:repo_hook"),

    /**
     * Grants read, write, and ping access to hooks in public or private repositories.
     */
    WRITE_REPO_HOOK("write:repo_hook"),

    /**
     * Grants read, write, ping, and delete access to hooks in public or private repositories.
     */
    ADMIN_REPO_HOOK("admin:repo_hook",
            new ArrayList<>(Arrays.asList(Scope.READ_REPO_HOOK, Scope.WRITE_REPO_HOOK))),

    /**
     * Grants read, write, ping, and delete access to organization hooks.
     * Note: OAuth tokens will only be able to perform these actions on organization hooks which
     * were created by the OAuth application. Personal access tokens will only be able to
     * perform these actions on organization hooks created by a user.
     */
    ADMIN_ORG_HOOK("admin:org_hook"),

    /**
     * Read-only access to organization, teams, and membership.
     */
    READ_ORG("read:org"),

    /**
     * Publicize and unpublicize organization membership.
     */
    WRITE_ORG("write:org"),

    /**
     * Fully manage organization, teams, and memberships.
     */
    ADMIN_ORG("admin:org", new ArrayList<>(Arrays.asList(Scope.READ_ORG, Scope.WRITE_ORG))),

    /**
     * List and view details for public keys.
     */
    READ_PUBLIC_KEY("read:public_key"),

    /**
     * Create, list, and view details for public keys.
     */
    WRITE_PUBLIC_KEY("write:public_key"),

    /**
     * Fully manage public keys.
     */
    ADMIN_PUBLIC_KEY("admin:public_key", new ArrayList<>(
            Arrays.asList(Scope.READ_PUBLIC_KEY, Scope.WRITE_PUBLIC_KEY))),

    /**
     * List and view details for GPG keys.
     */
    READ_GPG_KEY("read:gpg_key"),

    /**
     * Create, list, and view details for GPG keys.
     */
    WRITE_GPG_KEY("write:gpg_key"),

    /**
     * Fully manage GPG keys.
     */
    ADMIN_GPG_KEY("admin:gpg_key", new ArrayList<>(
            Arrays.asList(Scope.READ_GPG_KEY, Scope.WRITE_GPG_KEY)));

    private ArrayList<Scope> scopes;
    private String scope;

    Scope(String scope) {
        this.scope = scope;
    }

    Scope(String scope, ArrayList<Scope> scopes) {
        this.scopes = scopes;
    }

    public String getScope(){
        return scope;
    }

    public ArrayList<Scope> getScopes(){
        return scopes;
    }
}
