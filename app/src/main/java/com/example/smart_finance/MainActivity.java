package com.example.smart_finance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.home_page)
                Toast.makeText(MainActivity.this, "Home selected", Toast.LENGTH_SHORT).show();
                else if (id == R.id.shopping)
                Toast.makeText(MainActivity.this, "Shopping selected", Toast.LENGTH_SHORT).show();
                else if (id == R.id.renovation)
                    Toast.makeText(MainActivity.this, "Renovation selected", Toast.LENGTH_SHORT).show();
                else if (id == R.id.rest)
                    Toast.makeText(MainActivity.this, "Rest selected", Toast.LENGTH_SHORT).show();
                else if (id == R.id.street_food)
                    Toast.makeText(MainActivity.this, "Street food selected", Toast.LENGTH_SHORT).show();
                else if (id == R.id.utilities)
                    Toast.makeText(MainActivity.this, "Utilities selected", Toast.LENGTH_SHORT).show();
                else if (id == R.id.login)
                    Toast.makeText(MainActivity.this, "Login selected", Toast.LENGTH_SHORT).show();
                else if (id == R.id.logout)
                    Toast.makeText(MainActivity.this, "Logout selected", Toast.LENGTH_SHORT).show();

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}