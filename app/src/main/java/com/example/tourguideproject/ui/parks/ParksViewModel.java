package com.example.tourguideproject.ui.parks;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ParksViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ParksViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is parks fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}