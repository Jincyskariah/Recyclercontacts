package com.example.recyclercontacts;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recyclercontacts.adapter.Myadapter;

import java.util.ArrayList;

public class Contacts extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String>number;
    ArrayList<String>mylist;
    //ArrayList<String>cntslist;
    FloatingActionButton fbtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

       // cntslist=new ArrayList<String>();
        String intenttag1= (String) getIntent().getSerializableExtra("intenttag");

        Log.e("TsG",intenttag1);
        if(intenttag1.equals("cntactbtn"))
        {
            mylist=new ArrayList<String>();
            mylist = (ArrayList<String>) getIntent().getSerializableExtra("contactslist");

        }
      else if(intenttag1.equals("plusbtn"))   {
          //get the value
            mylist=new ArrayList<String>();
            mylist = (ArrayList<String>) getIntent().getSerializableExtra("contactslist");

        }




        recyclerView=findViewById(R.id.rview);
        number=new ArrayList<String>();
        number.add("9400756454");
        number.add("7567384646");
        number.add("9847466437");
        number.add("8746483908");
        number.add("9545678098");
        number.add("9644788874");
        number.add("9342625788");
        number.add("8726251076");
        number.add("9785994489");
        number.add("9857949363");
        number.add("8675893937");

        LinearLayoutManager vlayoutmanager=new LinearLayoutManager(Contacts.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(vlayoutmanager);
        recyclerView.setAdapter(new Myadapter(mylist));

        //Myadapter myadapter=new Myadapter(number);

    }

}
