package com.example.tourguideproject.ui.monuments;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MonumentsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MonumentsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is monuments fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}