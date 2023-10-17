package com.phuoc.recycleviewmvvmlivedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class UserViewModel extends ViewModel {
    private MutableLiveData<List<User>> mListMutableLiveData;
    private List<User> mListUser;

    public  UserViewModel() {
        mListMutableLiveData = new MutableLiveData<>();

        initData();

    }

    private void initData() {

        mListUser = new ArrayList<>();
        mListUser.add(new User(R.drawable.fb, "Phuoc 123", "Phuoc 123"));

        mListMutableLiveData.setValue(mListUser);
    }

    public MutableLiveData<List<User>> getListMutableLiveData() {
        return mListMutableLiveData;
    }

    public void AddUser(User user) {
        mListUser.add(0, user);
        mListMutableLiveData.setValue(mListUser);
    }
}
