package com.eslamwaheed.mvvmpoc;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private MutableLiveData<Integer> counterMutableLiveData = new MutableLiveData<>();
    private int counter;

    public MutableLiveData<Integer> getInitCount() {
        counterMutableLiveData.setValue(counter);
        return counterMutableLiveData;
    }

    public void addCount() {
        counter += 1;
        counterMutableLiveData.setValue(counter);
    }
}
