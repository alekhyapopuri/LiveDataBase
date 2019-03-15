package com.example.acer.livedatabase;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {
    EditText cid,cname,cmail,cnumber;
    ContactViewModel contactViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        cid=findViewById(R.id.uid);
        cname=findViewById(R.id.uname);
        cmail=findViewById(R.id.umail);
        cnumber=findViewById(R.id.unumber);
        String[] s=getIntent().getStringArrayExtra("data");
        cid.setText(s[0]);
        cname.setText(s[1]);
        cmail.setText(s[2]);
        cnumber.setText(s[3]);
        contactViewModel=ViewModelProviders.of(this).get(ContactViewModel.class);

    }

    public void update(View view) {
        MyEntity myEntity=new MyEntity();
        myEntity.setId(cid.getText().toString());
        myEntity.setName(cname.getText().toString());
        myEntity.setMailid(cmail.getText().toString());
        myEntity.setNumber(cnumber.getText().toString());

        contactViewModel.updatedata(myEntity);
        finish();

    }
}
