package com.example.tourguideproject.ui.museum;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MuseumViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MuseumViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is museum fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}