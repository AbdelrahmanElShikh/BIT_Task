package com.abdelrahman.beintrack.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Abdel-Rahman El-Shikh on 06-Dec-19.
 */
public class Profile {
    @SerializedName("data")
    @Expose
    private User user;

    public User getUser() {
        return user;
    }


}
