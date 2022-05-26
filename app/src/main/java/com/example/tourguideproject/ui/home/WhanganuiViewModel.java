package com.example.tourguideproject.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WhanganuiViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public WhanganuiViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Whanganui fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}