package com.abdelrahman.beintrack.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abdelrahman.beintrack.R;
import com.abdelrahman.beintrack.models.Image;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * @author Abdel-Rahman El-Shikh on 06-Dec-19.
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private List<Image> images;
    private OnImageClicked listener;

    public ImageAdapter(OnImageClicked listener) {
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Image image = images.get(position);
        Picasso.get().load(image.getImage()).error(R.drawable.ic_error).placeholder(R.drawable.ic_placeholder).into(holder.imageView);
    }

    public void setImages(List<Image> images) {
        this.images = images;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return images == null ? 0 : images.size();
    }

    public interface OnImageClicked {
        void onImageClicked(String imageUrl,String title);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            imageView.setOnClickListener(view -> listener.onImageClicked(images.get(getAdapterPosition()).getImage(),images.get(getAdapterPosition()).getTitle()));
        }
    }
}
