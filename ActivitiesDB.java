package com.example.group_project_android;

import java.util.ArrayList;

public class ActivitiesDB {

    private static ActivitiesDB instance = null;

    public static ActivitiesDB getInstance() {
        if (instance == null) {
            instance = new ActivitiesDB();
        }
        return instance;
    }
    private ActivitiesDB(){
        this.activityList = new ArrayList<ActivityDetails>();
        this.userList = new ArrayList<UserDetails>();
        activityList.add(new ActivityDetails(1,"AMUSEMENT PARK THRILL","With more than 30 rides and attractions and 14 mouth-watering food outlets, Centre Island’s iconic Centreville Amusement Park is the ultimate summer destination for families with young children!",4,"Alpha Tours",50,"https://travel.home.sndimg.com/content/dam/images/travel/fullset/2015/05/14/101-amazing-thrills-tg/cedar-point-sandusky-ohio.jpg.rend.hgtvcom.616.462.suffix/1491582056026.jpeg",14844458,"https://images.unsplash.com/photo-1513889961551-628c1e5e2ee9?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8YW11c2VtZW50JTIwcGFya3xlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&w=1000&q=80"));
        activityList.add(new ActivityDetails(2,"MUSEUM MANIA","Explore the history, art and culture of Toronto at The Museum of Contemporary Art.",3,"Beta Tours",30,"https://imagesvc.meredithcorp.io/v3/mm/image?q=85&c=sc&poi=face&w=1600&h=800&url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F28%2F2020%2F03%2Fgallery-uffizi-florence-italy-ONLINEMUSE0320.jpg",12212448,"https://media.cntraveler.com/photos/59a72bf067623235c140522d/16:9/w_2927,h_1646,c_limit/Field-Museum_North-Entrance.jpg"));
        activityList.add(new ActivityDetails(3,"BEACH GALORE","Also known as “The Beaches,” this relaxed neighbourhood with a small-town vibe is a top summer destination, drawing families and tourists to its sandy beaches and quaint boardwalk. ",5,"Gamma Tours",25,"https://images.unsplash.com/photo-1620127682229-33388276e540?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8c3VtbWVyJTIwYmVhY2h8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80",12211445,"https://pix10.agoda.net/hotelImages/301716/-1/fe9724d8fb4da3dd4590353bd771a276.jpg?s=1024x768"));
        activityList.add(new ActivityDetails(4,"ICE SKATING","The sound of blades gliding on ice, the crisp winter air and a mug of steaming hot chocolate warming your hands." ,5,"Theta Tours",40,"https://storage.googleapis.com/proudcity/ketteringohparks/uploads/2019/08/KetteringIceClinic-60.jpg",12211445,"https://www.flare.com/wp-content/uploads/2017/11/FB_SkatingRinks02.jpg"));
        activityList.add(new ActivityDetails(5,"NATURE WALK","Looking for a great trail near Toronto, Ontario? BELTLINE TRAIL has THE great trail running trails, hiking trails, mountain biking trails and more, with hand-curated trail maps and driving directions as well as detailed reviews and photos from hikers, campers, and nature lovers like you.",2,"Greek Tours",9,"https://pyxis.nymag.com/v1/imgs/746/418/1f45b4c19eab71f6e0f340e335324bbb2b-23-nature-walk.rsquare.w330.jpg",12211445,"https://freshkillspark.org/wp-content/uploads/2019/06/DA4_0089_06-04-17-Freshkills-Discovery-e1561391355527.jpg"));

        userList.add(new UserDetails("Stavan","stavan@gmail.com","stavan@123",0));
        userList.add(new UserDetails("Shivam","shivam@gmail.com","shivam@123",1));
        userList.add(new UserDetails("Nikhil","nikhil@gmail.com","nikhil@123",2));


    }



    private ArrayList<UserDetails> userList;
    private ArrayList<ActivityDetails> activityList;
    private ArrayList<UserAct> favlist= new ArrayList<>();
    private ArrayList<UserAct> booklist= new ArrayList<>();

    public ArrayList<UserAct> getFavlist() {
        return favlist;
    }

//
    public ArrayList<UserAct> getBooklist() { return booklist; }

    public ArrayList<ActivityDetails> getActivityList(){
        return this.activityList;
    }

    public ArrayList<UserDetails> getUserList(){
        return this.userList;
    }
}
