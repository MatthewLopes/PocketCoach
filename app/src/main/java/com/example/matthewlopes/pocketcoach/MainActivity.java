package com.example.matthewlopes.pocketcoach;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import layout.DataFragment;
import layout.GymFragment;
import layout.ProfileFragment;
import layout.SocialFragment;
import layout.WorkoutFragment;


public class MainActivity extends AppCompatActivity {


    //private TextView mTextMessage;


    //This method listens for which navigation item is clicked, then switchs the fragment to the
    //Corresponding fragment.
    public BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
            manager = getSupportFragmentManager();
            switch (item.getItemId()) {
                case R.id.navigation_social:
                    SocialFragment socialFragment = new SocialFragment();
                    manager.beginTransaction().replace(R.id.contentLayout, socialFragment, socialFragment.getTag()).commit();
                    return true;
                case R.id.navigation_workout:
                    WorkoutFragment workoutFragment = new WorkoutFragment();
                    manager.beginTransaction().replace(R.id.contentLayout, workoutFragment, workoutFragment.getTag()).commit();
                    return true;
                case R.id.navigation_profile:
                    ProfileFragment profileFragment = new ProfileFragment();
                    manager.beginTransaction().replace(R.id.contentLayout, profileFragment, profileFragment.getTag()).commit();
                    return true;
                case R.id.navigation_data:
                    DataFragment dataFragment = new DataFragment();
                    manager.beginTransaction().replace(R.id.contentLayout, dataFragment, dataFragment.getTag()).commit();
                    return true;
                case R.id.navigation_gyms:
                    GymFragment gymFragment = new GymFragment();
                    manager.beginTransaction().replace(R.id.contentLayout, gymFragment, gymFragment.getTag()).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //This code sets the default starting fragment to the profile page so that the first page
        //The user sees is the profile page.
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        manager = getSupportFragmentManager();
        ProfileFragment profileFragment = new ProfileFragment();
        manager.beginTransaction().replace(R.id.contentLayout, profileFragment, profileFragment.getTag()).commit();

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_profile);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
