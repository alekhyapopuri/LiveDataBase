package com.example.acer.livedatabase;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class ContactViewModel extends AndroidViewModel {
    public ContactRepository contactRepository;
    public LiveData<List<MyEntity>> getContactsData;
    public ContactViewModel(@NonNull Application application) {
        super(application);
        contactRepository=new ContactRepository(application);
        getContactsData=contactRepository.getallContacts();
    }
    public void insertdata(MyEntity myEntity){
        contactRepository.insert(myEntity);
    }
    public void deletedata(MyEntity myEntity){
        contactRepository.delete(myEntity);
    }
    public void updatedata(MyEntity myEntity){
        contactRepository.update(myEntity);
    }
    public void deletealldata(){
        contactRepository.deleteall();
    }
    public LiveData<List<MyEntity>> getAllc(){
        return getContactsData;
    }
}
