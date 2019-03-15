package com.example.acer.livedatabase;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

public class ContactRepository {

    public static MyDao myDao;
    LiveData<List<MyEntity>> getalldata;

    public ContactRepository(Context context) {
        ContactDataBase contactDataBase=ContactDataBase.getInstance(context);
        myDao=contactDataBase.myDaos();
        getalldata=myDao.getAllContacts();

    }
    LiveData<List<MyEntity>> getallContacts(){
        return getalldata;
    }
    public void insert(MyEntity myEntity){
        new InsertTask().execute(myEntity);
    }
    public void update(MyEntity myEntity){
        new updateTask().execute(myEntity);
    }
    public void delete(MyEntity myEntity){
        new deleteTask().execute(myEntity);
    }
    public void deleteall(){
        new deleteallTask().execute();
    }
    public class InsertTask extends AsyncTask<MyEntity,Void,Void>{

        @Override
        protected Void doInBackground(MyEntity... myEntities) {
            myDao.insertContact(myEntities[0]);
            return null;
        }
    }
    public class updateTask extends AsyncTask<MyEntity,Void,Void>{

        @Override
        protected Void doInBackground(MyEntity... myEntities) {
            myDao.updateContact(myEntities[0]);
            return null;
        }
    }
    public class deleteTask extends AsyncTask<MyEntity,Void,Void>{

        @Override
        protected Void doInBackground(MyEntity... myEntities) {
            myDao.deleteContact(myEntities[0]);
            return null;
        }
    }
    public class deleteallTask extends AsyncTask<Void,Void,Void>{


        @Override
        protected Void doInBackground(Void... voids) {
            myDao.deleteAll();
            return null;
        }
    }
}
