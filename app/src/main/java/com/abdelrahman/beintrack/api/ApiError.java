package com.abdelrahman.beintrack.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Abdel-Rahman El-Shikh on 05-Dec-19.
 */
public class ApiError {
    private int code;
    private String message;

    @SerializedName("errors")
    @Expose
    private List<String> errors = null;

    @SerializedName("error")
    @Expose
    private String error;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
