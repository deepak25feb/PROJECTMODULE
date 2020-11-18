package com.example.tyitproject2020.HomePage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.tyitproject2020.R;
import com.example.tyitproject2020.SideNavFrag.FeedBackFrag;
import com.example.tyitproject2020.SideNavFrag.LogoutFrag;
import com.example.tyitproject2020.SideNavFrag.SeetingFrag;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

//This activity is implementing side view navigation

public class HomePageIndex extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    Fragment selectedFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_index);

        //Implementing ToolBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); // Now tool bar will work similar to  Action Bar ... || At this level navigation will work automatically!!!....


        //------------------------Bottom Navigation Listner
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        //------------------------


        drawer = findViewById(R.id.drawer_layout);  //from this Activity MainLayout

        //Side Navigation Listner when clicked on one of menu in the navigation
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //--------------------SIDE NAVIGATION Animation
        //Below code will going to give rotation animation of navigation bar
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close); //defining string are compulsory reason force param are required
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        //--------------------------


        // ByDefault frag view when first opened................. without clicking ..NOTE : Frag+Bottom Navigation have a tendency to store current state of UI
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragYoutube(HomePageIndex.this)).commit();
        }

    } //oncreate ends here


    //Side Navigation Listner and based menu item selection fragment manager will transact the fragments accordingly
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_feedback:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FeedBackFrag()).commit();
                break;
            case R.id.nav_setting:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SeetingFrag()).commit();
                break;
            case R.id.nav_logout:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LogoutFrag()).commit();
                break;
            case R.id.nav_listen:
                Toast.makeText(this, "JUMP TO AUDIO ACTIVITY", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_send:
                Toast.makeText(this, "JUMP TO MISC ACITVITY", Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START); //onclick close the side navigation bar

        return true; //if set false then it means no item should be selected....
    }


    //________________Bootom Navigation variable
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_vid:
                            selectedFragment = new HomeFragYoutube(HomePageIndex.this);
                            break;
                        case R.id.nav_course:
                            selectedFragment = new HomeFragCourse();
                            break;
                        case R.id.nav_misc:
                            selectedFragment = new HomeFragMisc();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true; //this means when menu is clicked menu should be show as clicked
                }
            };


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed(); //close the Activity as usual
        }
    }


}