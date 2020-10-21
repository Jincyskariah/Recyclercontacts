package com.example.recyclercontacts;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.constraint.Guideline;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private FloatingActionButton ftngbtn1;
    private FloatingActionButton ftngbtn2;
    private FloatingActionButton ftngbtn3;
    private TextView txtnum;
    private Guideline guideline;
    private Guideline guideline2;
    private Guideline guideline3;
    private Guideline guideline4;
    private Guideline guideline5;
    private Guideline guideline6;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private ImageButton btn10;
    private Button btn11;
    private ImageButton btn12;
    ArrayList<String>mylist;
    ArrayList<String>contactList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mylist=new ArrayList<String>();
        contactList=new ArrayList<>();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        if (txtnum.getText().equals(""))
             {
                 txtnum.setText("1");
             }
        else
             {
                 txtnum.setText(txtnum.getText()+"1");
             }

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtnum.getText().equals("")){
                    txtnum.setText("2");
                }
                else
                {
                    txtnum.setText(txtnum.getText()+"2");
                }



            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtnum.getText().equals("")){
                    txtnum.setText("3");
                }
                else
                {
                    txtnum.setText(txtnum.getText()+"3");
                }

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtnum.getText().equals("")){
                    txtnum.setText("4");
                }
                else
                {
                    txtnum.setText(txtnum.getText()+"4");
                }

            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtnum.getText().equals("")){
                    txtnum.setText("5");
                }
                else
                {
                    txtnum.setText(txtnum.getText()+"5");
                }

            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtnum.getText().equals("")){
                    txtnum.setText("6");
                }
                else
                {
                    txtnum.setText(txtnum.getText()+"6");
                }
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtnum.getText().equals("")){
                    txtnum.setText("7");
                }
                else
                {
                    txtnum.setText(txtnum.getText()+"7");
                }

            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtnum.getText().equals("")){
                    txtnum.setText("8");
                }
                else
                {
                    txtnum.setText(txtnum.getText()+"8");
                }

            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtnum.getText().equals("")){
                    txtnum.setText("9");
                }
                else
                {
                    txtnum.setText(txtnum.getText()+"9");
                }

            }
        });
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtnum.getText().equals("")){
                    txtnum.setText("0");
                }
                else
                {
                    txtnum.setText(txtnum.getText()+"0");
                }

            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendSMS(txtnum.getText().toString());



            }
        });
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+txtnum.getText().toString()));
                startActivity(intent);


            }
        });
        ftngbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Contacts.class);
                intent.putExtra("intenttag","plusbtn");
                intent.putExtra("contactslist",storeData(mylist));

                startActivity(intent);

            }
        });
        ftngbtn2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("pref",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                String data=txtnum.getText().toString();
                editor.putString("dialnum",data);
                editor.apply();
                Intent  intent=new Intent(MainActivity.this,Recent.class);
                startActivity(intent);

            }
        });
        ftngbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get the txtnum to textnumber
                String textnumber=txtnum.getText().toString();
                //add to the arraylist
                mylist.add(textnumber);
                Intent intent=new Intent(MainActivity.this,Contacts.class);
                //pass the value to the next activity
                intent.putExtra("contactslist",mylist);

                storeData(mylist);


                intent.putExtra("intenttag","plusbtn");
                startActivity(intent);


            }
        });
















    }

    private ArrayList<String> storeData(ArrayList<String> mylist) {
        contactList=mylist;
        return contactList;
    }

    protected void sendSMS(String pn) {
        Log.i("Send SMS", "");
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);

        smsIntent.setData(Uri.parse("smsto:"));
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("address"  , new String (pn));
        smsIntent.putExtra("sms_body"  , "Test  message frm contaccts app ");

        try {
            startActivity(smsIntent);
            finish();
            Log.i("Finished sending SMS...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this,
                    "SMS faild, please try again later.", Toast.LENGTH_SHORT).show();
        }
    }

    private void initView() {
        ftngbtn1 = (FloatingActionButton) findViewById(R.id.ftngbtn1);
        ftngbtn2 = (FloatingActionButton) findViewById(R.id.ftngbtn2);
        ftngbtn3 = (FloatingActionButton) findViewById(R.id.ftngbtn3);
        txtnum = (TextView) findViewById(R.id.txtnum);
        guideline = (Guideline) findViewById(R.id.guideline);
        guideline2 = (Guideline) findViewById(R.id.guideline2);
        guideline3 = (Guideline) findViewById(R.id.guideline3);
        guideline4 = (Guideline) findViewById(R.id.guideline4);
        guideline5 = (Guideline) findViewById(R.id.guideline5);
        guideline6 = (Guideline) findViewById(R.id.guideline6);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn10 = (ImageButton) findViewById(R.id.btn10);
        btn11 = (Button) findViewById(R.id.btn11);
        btn12 = (ImageButton) findViewById(R.id.btn12);


    }
}
