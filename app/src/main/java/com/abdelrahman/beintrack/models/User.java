package com.abdelrahman.beintrack.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Abdel-Rahman El-Shikh on 06-Dec-19.
 */
public class User {

    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("profile_picture")
    @Expose
    private String profilePicture;
    @SerializedName("bio")
    @Expose
    private String bio;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("counts")
    @Expose
    private Counts counts;



    public String getFullName() {
        return fullName;
    }


    public String getProfilePicture() {
        return profilePicture;
    }


    public String getBio() {
        return bio;
    }


    public String getLocation() {
        return location;
    }


    public Counts getCounts() {
        return counts;
    }

}
