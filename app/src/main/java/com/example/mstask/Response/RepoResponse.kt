package com.example.mstask.Response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class RepoResponse (
    @Expose
    @SerializedName("id")
    val id: Int,
    @Expose
    @SerializedName("node_id")
    val node_id: String,
    @Expose
    @SerializedName("name")
    val name: String,
    @Expose
    @SerializedName("full_name")
    val full_name: String,
    @Expose
    @SerializedName("owner")
    val owner: Owner,
    @Expose
    @SerializedName("html_url")
    val html_url: String,
    @Expose
    @SerializedName("description")
    val description: String,
    @Expose
    @SerializedName("fork")
    val fork: Boolean,
    @Expose
    @SerializedName("url")
    val url: String,
    @Expose
    @SerializedName("forks_url")
    val forks_url: String,
    @Expose
    @SerializedName("keys_url")
    val keys_url: String,
    @Expose
    @SerializedName("collaborators_url")
    val collaborators_url: String,
    @Expose
    @SerializedName("teams_url")
    val teams_url: String,
    @Expose
    @SerializedName("hooks_url")
    val hooks_url: String,
    @Expose
    @SerializedName("issue_events_url")
    val issue_events_url: String,
    @Expose
    @SerializedName("events_url")
    val events_url: String,
    @Expose
    @SerializedName("assignees_url")
    val assignees_url: String,
    @Expose
    @SerializedName("branches_url")
    val branches_url: String,
    @Expose
    @SerializedName("tags_url")
    val tags_url: String,
    @Expose
    @SerializedName("blobs_url")
    val blobs_url: String,
    @Expose
    @SerializedName("git_tags_url")
    val git_tags_url: String,
    @Expose
    @SerializedName("git_refs_url")
    val git_refs_url: String,
    @Expose
    @SerializedName("trees_url")
    val trees_url: String,
    @Expose
    @SerializedName("statuses_url")
    val statuses_url: String,
    @Expose
    @SerializedName("languages_url")
    val languages_url: String,
    @Expose
    @SerializedName("stargazers_url")
    val stargazers_url: String,
    @Expose
    @SerializedName("contributors_url")
    val contributors_url: String,
    @Expose
    @SerializedName("subscribers_url")
    val subscribers_url: String,
    @Expose
    @SerializedName("subscription_url")
    val subscription_url: String,
    @Expose
    @SerializedName("commits_url")
    val commits_url: String,
    @Expose
    @SerializedName("git_commits_url")
    val git_commits_url: String,
    @Expose
    @SerializedName("comments_url")
    val comments_url: String,
    @Expose
    @SerializedName("issue_comment_url")
    val issue_comment_url: String,
    @Expose
    @SerializedName("contents_url")
    val contents_url: String,
    @Expose
    @SerializedName("compare_url")
    val compare_url: String,
    @Expose
    @SerializedName("merges_url")
    val merges_url: String,
    @Expose
    @SerializedName("archive_url")
    val archive_url: String,
    @Expose
    @SerializedName("downloads_url")
    val downloads_url: String,
    @Expose
    @SerializedName("issues_url")
    val issues_url: String,
    @Expose
    @SerializedName("pulls_url")
    val pulls_url: String,
    @Expose
    @SerializedName("milestones_url")
    val milestones_url: String,
    @Expose
    @SerializedName("notifications_url")
    val notifications_url: String,
    @Expose
    @SerializedName("labels_url")
    val labels_url: String,
    @Expose
    @SerializedName("releases_url")
    val releases_url: String,
    @Expose
    @SerializedName("deployments_url")
    val deployments_url: String
)

data class Owner(
    @Expose
    @SerializedName("login")
    val login: String,
    @Expose
    @SerializedName("id")
    val id: Int,
    @Expose
    @SerializedName("node_id")
    val node_id: String,
    @Expose
    @SerializedName("avatar_url")
    val avatar_url: String,
    @Expose
    @SerializedName("gravatar_id")
    val gravatar_id: String,
    @Expose
    @SerializedName("url")
    val url: String,
    @Expose
    @SerializedName("html_url")
    val html_url: String,
    @Expose
    @SerializedName("followers_url")
    val followers_url: String,
    @Expose
    @SerializedName("following_url")
    val following_url: String,
    @Expose
    @SerializedName("gists_url")
    val gists_url: String,
    @Expose
    @SerializedName("starred_url")
    val starred_url: String,
    @Expose
    @SerializedName("subscriptions_url")
    val subscriptions_url: String,
    @Expose
    @SerializedName("organizations_url")
    val organizations_url: String,
    @Expose
    @SerializedName("repos_url")
    val repos_url: String,
    @Expose
    @SerializedName("events_url")
    val events_url: String,
    @Expose
    @SerializedName("received_events_url")
    val received_events_url: String,
    @Expose
    @SerializedName("type")
    val type: String,
    @Expose
    @SerializedName("site_admin")
    val site_admin: Boolean
)
