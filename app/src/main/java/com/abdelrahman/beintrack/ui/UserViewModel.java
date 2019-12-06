package com.abdelrahman.beintrack.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.abdelrahman.beintrack.repositories.UserRepository;
import com.abdelrahman.beintrack.api.ApiResponse;
import com.abdelrahman.beintrack.models.Media;
import com.abdelrahman.beintrack.models.Profile;

/**
 * @author Abdel-Rahman El-Shikh on 06-Dec-19.
 */
public class UserViewModel extends ViewModel {
    private UserRepository userRepository;
    void init(){
        userRepository = UserRepository.getInstance();
    }

    public LiveData<ApiResponse<Profile>> getProfileData(){
        return userRepository.getProfileData();
    }
    public LiveData<ApiResponse<Media>> getHomeData(){
        return userRepository.getHomeData();
    }
}
