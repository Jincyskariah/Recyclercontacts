package com.example.recyclercontacts.adapter;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recyclercontacts.Contacts;
import com.example.recyclercontacts.R;

import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyVH>{

    public Myadapter(ArrayList<String> number) {
        this.number = number;
    }

   ArrayList<String>number;



    @NonNull
    @Override
    public Myadapter.MyVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View myview= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitem,viewGroup,false);

        return new Myadapter.MyVH(myview);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVH myVH, int position) {
        myVH.number.setText(number.get(position));

    }



    @Override
    public int getItemCount() {
        return number.size();
    }




    public class MyVH extends RecyclerView.ViewHolder{
        TextView number;

        public MyVH(@NonNull View itemView) {
            super(itemView);
            number=itemView.findViewById(R.id.txtphno);

        }

    }

    }

