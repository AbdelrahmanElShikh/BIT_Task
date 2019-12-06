package com.abdelrahman.beintrack.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;

import com.abdelrahman.beintrack.R;
import com.abdelrahman.beintrack.adapter.ImageAdapter;
import com.abdelrahman.beintrack.databinding.ActivityMainBinding;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements ImageAdapter.OnImageClicked {
    private static final String TAG = "MainActivity";
    private ActivityMainBinding binding;
    private UserViewModel mViewModel;
    private ImageAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        mViewModel.init();
        mAdapter = new ImageAdapter(this);
        binding.recyclerViewImages.setLayoutManager(new GridLayoutManager(this, 3));
        binding.recyclerViewImages.setAdapter(mAdapter);
        observeProfileData();
        observeHomeData();
    }


    private void observeProfileData() {
        mViewModel.getProfileData().observe(this, profileResponse -> {
            switch (profileResponse.getStatus()) {
                case SUCCESS:
                    Picasso.get().load(profileResponse.getData().getUser().getProfilePicture()).placeholder(R.drawable.ic_placeholder).into(binding.imgUserImage);
                    binding.setProfile(profileResponse.getData());
                    binding.imgUserImage.setOnClickListener(view -> openFullScreenActivity(
                            profileResponse.getData().getUser().getProfilePicture(),
                            profileResponse.getData().getUser().getFullName()));
                    break;
                case ERROR:
                    Toast.makeText(this, profileResponse.getApiError().getMessage(), Toast.LENGTH_SHORT).show();
                    break;
                case Failure:
                    Toast.makeText(this, profileResponse.getApiException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "observeProfileData: Failure -> " + profileResponse.getApiException().getLocalizedMessage());
            }
        });
    }

    private void observeHomeData() {
        mViewModel.getHomeData().observe(this, homeResponse -> {
            switch (homeResponse.getStatus()) {
                case SUCCESS:
                    mAdapter.setImages(homeResponse.getData().getImages());
                    break;
                case ERROR:
                    Toast.makeText(this, homeResponse.getApiError().getMessage(), Toast.LENGTH_SHORT).show();
                    break;
                case Failure:
                    Toast.makeText(this, homeResponse.getApiException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "observeProfileData: Failure -> " + homeResponse.getApiException().getLocalizedMessage());
            }
            binding.progressbar.setVisibility(View.GONE);
        });
    }

    @Override
    public void onImageClicked(String imageUrl, String title) {
        openFullScreenActivity(imageUrl, title);
    }

    private void openFullScreenActivity(String imageUrl, String title) {
        Intent intent = new Intent(this, FullScreenActivity.class);
        intent.putExtra("imageUrl", imageUrl);
        intent.putExtra("title", title);
        startActivity(intent);
    }

}
