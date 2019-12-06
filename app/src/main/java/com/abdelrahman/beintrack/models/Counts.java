package com.abdelrahman.beintrack.models;

import android.annotation.SuppressLint;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Abdel-Rahman El-Shikh on 06-Dec-19.
 */
public class Counts {
    @SerializedName("posts")
    @Expose
    private Integer posts;
    @SerializedName("followers")
    @Expose
    private Integer followers;
    @SerializedName("following")
    @Expose
    private Integer following;

    public String getPosts() {
        return getNumberWithSuffix(posts);
    }


    public String getFollowers() {
        return getNumberWithSuffix(followers);
    }


    public String getFollowing() {
        return getNumberWithSuffix(following);
    }

    @SuppressLint("DefaultLocale")
    public String getNumberWithSuffix(Integer number) {
        if (number < 1000) return "" + number;
        int exp = (int) (Math.log(number) / Math.log(1000));
        return String.format("%.1f %c",
                number / Math.pow(1000, exp),
                "kMGTPE".charAt(exp - 1));
    }

}
