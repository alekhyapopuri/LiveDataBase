package com.example.acer.livedatabase;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import java.util.List;

@Database(entities = MyEntity.class,version = 1)
public abstract class ContactDataBase extends RoomDatabase {

    public abstract MyDao myDaos();
    public static ContactDataBase instance;
    public static ContactDataBase getInstance(Context context){

        if(instance==null){
            instance=Room.databaseBuilder(context,ContactDataBase.class,"contact").fallbackToDestructiveMigration().build();
        }

            return instance;

    }
}
