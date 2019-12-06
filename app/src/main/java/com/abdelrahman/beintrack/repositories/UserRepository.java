package com.abdelrahman.beintrack.repositories;

import androidx.lifecycle.MutableLiveData;

import com.abdelrahman.beintrack.api.ApiResponse;
import com.abdelrahman.beintrack.api.ApiService;
import com.abdelrahman.beintrack.api.RequestHandler;
import com.abdelrahman.beintrack.api.RetrofitBuilder;
import com.abdelrahman.beintrack.models.Media;
import com.abdelrahman.beintrack.models.Profile;

import retrofit2.Call;

/**
 * @author Abdel-Rahman El-Shikh on 06-Dec-19.
 */
public class UserRepository {
    private static UserRepository userRepository;
    private ApiService apiService = RetrofitBuilder.createService();

    public static UserRepository getInstance() {
        if (userRepository == null)
            userRepository = new UserRepository();
        return userRepository;
    }

    public MutableLiveData<ApiResponse<Media>> getHomeData() {
        RequestHandler<Media> requestHandler = new RequestHandler<Media>() {
            @Override
            public Call<Media> makeRequest() {
                return apiService.getHomeData();
            }
        };
        requestHandler.doRequest();
        return requestHandler.getApiResponseLiveData();
    }

    public MutableLiveData<ApiResponse<Profile>> getProfileData() {
        RequestHandler<Profile> requestHandler = new RequestHandler<Profile>() {
            @Override
            public Call<Profile> makeRequest() {
                return apiService.getProfileData();
            }
        };
        requestHandler.doRequest();
        return requestHandler.getApiResponseLiveData();
    }
}
