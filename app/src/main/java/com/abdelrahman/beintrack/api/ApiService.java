package com.abdelrahman.beintrack.api;

import com.abdelrahman.beintrack.models.Media;
import com.abdelrahman.beintrack.models.Profile;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author Abdel-Rahman El-Shikh on 05-Dec-19.
 */
public interface ApiService {
    //get home data (The Images)
    @GET("home")
    Call<Media> getHomeData();

    //get User Data like (name - bio - followers)
    @GET("profile")
    Call<Profile> getProfileData();
}
