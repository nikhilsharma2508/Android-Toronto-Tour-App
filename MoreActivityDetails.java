package com.example.group_project_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MoreActivityDetails extends AppCompatActivity {

    TextView activityName,description,price,companyName;
    Button favb,share,book;
    ArrayList<UserAct> favdDetails,booklist;
    ImageView phoneIcon,image,image2;
    RatingBar r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_details);
        favdDetails= ActivitiesDB.getInstance().getFavlist();
        booklist = ActivitiesDB.getInstance().getBooklist();
        phoneIcon = (ImageView) findViewById(R.id.phoneicon);
        activityName = (TextView)findViewById(R.id.activityName);
        description = (TextView) findViewById(R.id.description);
        price  = (TextView) findViewById(R.id.price);
        r = (RatingBar)findViewById(R.id.ratingBar);
        book = (Button)findViewById(R.id.book);
        companyName = (TextView) findViewById(R.id.companyName);
        favb = (Button) findViewById(R.id.favourites);
        share = (Button)findViewById(R.id.share);
        image = (ImageView)findViewById(R.id.imageView1);
        image2 = (ImageView) findViewById(R.id.image2);
        Intent currentIntent = this.getIntent();
        ActivityDetails ac = (ActivityDetails) currentIntent.getSerializableExtra("activity_data");
        UserDetails uc = (UserDetails) currentIntent.getSerializableExtra("User_data");
        String x = currentIntent.getStringExtra("A");
        String index =  currentIntent.getStringExtra("I");

        favb.setText(x);

        if(ac != null){
                activityName.setText(ac.getNameOfActivity());
                price.setText("$"+ac.getPrice());
                description.setText(ac.getDescription());
                companyName.setText(ac.getCompanyName());
                r.setRating(ac.getStarRating());
                Glide.with(this).load(ac.getImageName()).centerCrop().into(image);
                Glide.with(this).load(ac.getImageUrl2()).centerCrop().into(image2);

            }

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String body = ac.getNameOfActivity()+"\n"+ac.getCompanyName() + "\n "+ "$"+ac.getPrice();
                String sub = ac.getNameOfActivity();
                myIntent.putExtra(Intent.EXTRA_SUBJECT, sub);
                myIntent.putExtra(Intent.EXTRA_TEXT, body);
                startActivity(Intent.createChooser(myIntent, "Share via"));
            }
        });
        phoneIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_DIAL);
                myIntent.setData(Uri.parse("tel:"+ac.getNum()));
                startActivity(myIntent);
            }
        });
        favb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(favb.getText().equals("Remove from Favourite")){
                    favdDetails.remove(Integer.parseInt(index));
                    Toast.makeText(getApplicationContext(),"Removed from favourite",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MoreActivityDetails.this,ActivitiesListActivity.class);
                    i.putExtra("User_data",uc);
                    startActivity(i);
                }
                else{
                    favdDetails.add(new UserAct(uc, ac));
                    Toast.makeText(MoreActivityDetails.this, "Added to favourites!", Toast.LENGTH_SHORT).show();
                    favb.setEnabled(false);
                }


            }
        });
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booklist.add(new UserAct(uc,ac));
                Intent i = new Intent(MoreActivityDetails.this,BookingReceipt.class);
                i.putExtra("User_data",uc);
                i.putExtra("activity_data",ac);
                startActivity(i);
                finish();
            }
        });
    }

}