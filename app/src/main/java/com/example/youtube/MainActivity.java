package com.example.youtube;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.youtube.fragment.ExploreFragment;
import com.example.youtube.fragment.HomeFragment;
import com.example.youtube.fragment.LibraryFragment;
import com.example.youtube.fragment.SubscriptionsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("");

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        frameLayout = findViewById(R.id.frame_layout);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        HomeFragment homeFragment = new HomeFragment();
                        selectedFragment(homeFragment);
                        break;
                    case R.id.explore:
                        ExploreFragment exploreFragment = new ExploreFragment();
                        selectedFragment(exploreFragment);
                        break;
                    case R.id.add:
                        Toast.makeText(MainActivity.this, "Add a video", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.subscriptions:
                        SubscriptionsFragment subscriptionsFragment = new SubscriptionsFragment();
                        selectedFragment(subscriptionsFragment);
                        break;
                    case R.id.library:
                        LibraryFragment libraryFragment = new LibraryFragment();
                        selectedFragment(libraryFragment);
                        break;
                }
                return false;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.home);
    }

    private void selectedFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.notification:
                Toast.makeText(this, "Notification", Toast.LENGTH_SHORT).show();
                break;
            case R.id.search:
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
                break;
            case R.id.account:
                Toast.makeText(this, "Account", Toast.LENGTH_SHORT).show();
                break;
            default:
                super.onOptionsItemSelected(item);
        }
        return false;
    }
}