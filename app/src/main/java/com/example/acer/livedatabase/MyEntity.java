package com.example.acer.livedatabase;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "contact_details")
public class MyEntity {
    @PrimaryKey @NonNull
    @ColumnInfo(name="contact_id")
    String id;
    @ColumnInfo(name = "contact_name")
    String name;
    @ColumnInfo(name = "contact_mailid")
    String mailid;
    @ColumnInfo(name = "contact_number")
    String number;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMailid() {
        return mailid;
    }

    public void setMailid(String mailid) {
        this.mailid = mailid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
