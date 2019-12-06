package com.abdelrahman.beintrack.models;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Abdel-Rahman El-Shikh on 06-Dec-19.
 */
public class Media {
    @SerializedName("data")
    @Expose
    private List<Image> data = null;
    @SerializedName("status")
    @Expose
    private Boolean status;

    public List<Image> getImages() {
        return data;
    }

    public void setImages(List<Image> data) {
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
