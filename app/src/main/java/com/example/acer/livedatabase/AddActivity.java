package com.example.acer.livedatabase;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    EditText iid,iname,imail,inumber;
    ContactViewModel contactViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        iid=findViewById(R.id.aid);
        iname=findViewById(R.id.aname);
        imail=findViewById(R.id.amail);
        inumber=findViewById(R.id.anumber);
        contactViewModel=ViewModelProviders.of(this).get(ContactViewModel.class);
    }

    public void save(View view) {
        MyEntity myEntity=new MyEntity();
        myEntity.setId(iid.getText().toString());
        myEntity.setName(iname.getText().toString());
        myEntity.setMailid(imail.getText().toString());
        myEntity.setNumber(inumber.getText().toString());

        contactViewModel.insertdata(myEntity);
        Toast.makeText(this, "data inserted", Toast.LENGTH_SHORT).show();
        finish();
    }
}
