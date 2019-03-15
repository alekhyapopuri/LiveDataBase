package com.example.acer.livedatabase;

import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Delete;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Myviewholder> {
    Context context;
    List<MyEntity> contactList;
    ContactViewModel cvm;


    public MyAdapter(MainActivity mainActivity, List<MyEntity> myEntities) {
        this.context=mainActivity;
        this.contactList=myEntities;

    }

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(context).inflate(R.layout.rowdesign,parent,false);
        return new Myviewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final Myviewholder holder, final int position) {
        MyEntity me=contactList.get(position);
        holder.t1.setText(me.id);
        holder.t2.setText(me.name);
        holder.t3.setText(me.mailid);
        holder.t4.setText(me.number);
        holder.bedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String[] names=new String[4];
               names[0]=contactList.get(position).getId();
               names[1]=contactList.get(position).getName();
               names[2]=contactList.get(position).getMailid();
               names[3]=contactList.get(position).getNumber();
                Intent in=new Intent(context,UpdateActivity.class);
                in.putExtra("data",names);
                context.startActivity(in);
            }
        });
        holder.bdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String deid=contactList.get(position).getId();
                cvm=ViewModelProviders.of((FragmentActivity) context).get(ContactViewModel.class);
                MyEntity me=new MyEntity();
                me.setId(deid);
                cvm.deletedata(me);

                //Intent it=new Intent(context,delete.class);
                //it.putExtra("dele",deid);
                //context.startActivity(it);

            }
        });
        holder.bclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyEntity myen=new MyEntity();
                cvm=ViewModelProviders.of((FragmentActivity) context).get(ContactViewModel.class);
                cvm.deletealldata();


            }
        });


    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder {
        TextView t1,t2,t3,t4;
        Button bedit,bdelete,bclear;
        public Myviewholder(View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.rid);
            t2=itemView.findViewById(R.id.rname);
            t3=itemView.findViewById(R.id.rmail);
            t4=itemView.findViewById(R.id.rnumber);
            bedit=itemView.findViewById(R.id.bed);
            bdelete=itemView.findViewById(R.id.bdel);
            bclear=itemView.findViewById(R.id.clr);
        }
    }
}
