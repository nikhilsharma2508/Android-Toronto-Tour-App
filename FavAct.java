package com.example.group_project_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class FavAct extends AppCompatActivity {
    ArrayList<UserAct> favdDetailss;
    ListView listViewf;
    ArrayList<ActivityDetails> activityDetails;
    Button removeAll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);
        ArrayList<String> activityName = new ArrayList<>();
        ArrayList<Float> price= new ArrayList<>();
        ArrayList<String> imageName = new ArrayList<>();
        removeAll = (Button) findViewById(R.id.removeAll);
        Intent currentIntent = this.getIntent();
        UserDetails ucf = (UserDetails) currentIntent.getSerializableExtra("User_data");
        favdDetailss= ActivitiesDB.getInstance().getFavlist();
        activityDetails = ActivitiesDB.getInstance().getActivityList();


        for(int i=0;i<favdDetailss.size();i++){
            if(favdDetailss.get(i).us.getId()==ucf.getId()){
            activityName.add(favdDetailss.get(i).act.getNameOfActivity());
            price.add(favdDetailss.get(i).act.getPrice());
            imageName.add(favdDetailss.get(i).act.getImageName());}
        }
        MyListAdapter adapter = new MyListAdapter(this,activityName,imageName,price);
        listViewf =(ListView) findViewById(R.id.list);
        listViewf.setAdapter(adapter);
        removeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int size = favdDetailss.size();
                for(int i=0;i<=size;i++){

                    try{
                    if(favdDetailss.get(i)==null){
                        break;
                    }
                    else{

                        if(favdDetailss.get(i).us.getId()==ucf.getId()){
                            favdDetailss.remove(i);
                            i--;
                        }
                    }}
                    catch (Exception e){
                        System.out.println(e);
                    }
                }
                Toast.makeText(getApplicationContext(),"All items Removed from favourite",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(FavAct.this,ActivitiesListActivity.class);
                i.putExtra("User_data",ucf);
                startActivity(i);
                finish();
            }
        });
        listViewf.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent i2 = new Intent(FavAct.this,MoreActivityDetails.class);
                ActivityDetails ac = favdDetailss.get(i).act;
                i2.putExtra("activity_data", (Serializable) ac);
                i2.putExtra("User_data",(Serializable)ucf );
                i2.putExtra("A","Remove from Favourite");
                String x = Integer.toString(i);
                i2.putExtra("I",x);
                startActivity(i2);

            }
        });
        listViewf.invalidateViews();

    }
}