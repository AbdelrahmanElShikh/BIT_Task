package com.abdelrahman.beintrack.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.abdelrahman.beintrack.R;
import com.abdelrahman.beintrack.databinding.ActivityFullScreenBinding;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.Objects;

public class FullScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFullScreenBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_full_screen);
        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra("imageUrl");
        String title = intent.getStringExtra("title");
        setSupportActionBar(binding.toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
        binding.toolbar.setNavigationIcon(R.drawable.ic_back);
        binding.toolbar.setNavigationOnClickListener(view -> onBackPressed());
        Picasso.get().load(imageUrl).placeholder(R.drawable.ic_placeholder).error(R.drawable.ic_error).into(binding.imgFullScreen, new Callback() {
            @Override
            public void onSuccess() {
                //Do Nothing
            }

            @Override
            public void onError(Exception e) {
                showErrorDialog();
            }
        });
    }
    private void showErrorDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.image_error);
        builder.setCancelable(false);
        builder.setPositiveButton(
                R.string.back,
                (dialog, id) -> {
                    dialog.cancel();
                    onBackPressed();
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
