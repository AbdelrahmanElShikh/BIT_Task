package com.abdelrahman.beintrack.api;

import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Response;

import static com.abdelrahman.beintrack.api.Status.ERROR;
import static com.abdelrahman.beintrack.api.Status.Failure;
import static com.abdelrahman.beintrack.api.Status.SUCCESS;

/**
 * @author Abdel-Rahman El-Shikh on 05-Dec-19.
 */
public abstract class RequestHandler<T> {
    private MutableLiveData<ApiResponse<T>> apiResponseLiveData;

    protected RequestHandler() {
        apiResponseLiveData = new MutableLiveData<>();
    }

    public abstract Call<T> makeRequest();

    public void doRequest() {
        ApiResponse<T> apiResponse = new ApiResponse<>();
        makeRequest().enqueue(new ApiCallback<T>() {
            @Override
            void handleException(Exception t) {
                //Failure happened
                apiResponse.setApiException(t);
                apiResponse.setStatus(Failure);
                apiResponseLiveData.setValue(apiResponse);
            }

            @Override
            void handleError(Response<T> response) {
                //response isn't successful
                apiResponse.setApiError(RetrofitBuilder.convertErrors(response.errorBody()));
                apiResponse.setStatus(ERROR);
                apiResponseLiveData.setValue(apiResponse);
            }

            @Override
            void handlerResponseData(T body) {
                //response is successful
                apiResponse.setData(body);
                apiResponse.setStatus(SUCCESS);
                apiResponseLiveData.setValue(apiResponse);
            }
        });
    }

    public MutableLiveData<ApiResponse<T>> getApiResponseLiveData() {
        return apiResponseLiveData;
    }
}
