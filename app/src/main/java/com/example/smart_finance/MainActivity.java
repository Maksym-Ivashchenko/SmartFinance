package com.example.smart_finance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    BottomNavigationView bottomNavigationView;
    ActionBarDrawerToggle drawerToggle;
    FloatingActionButton fab;
    Toolbar toolbar;
    FragmentManager fragmentManager;


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fab);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setBackground(null);

        bottomNavigationView.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.home) {
                replaceFragment(new HomeFragment());
                return true;
            } else if (item.getItemId() == R.id.diagram) {
                replaceFragment(new DiagramFragment());
                return true;
            } else if (item.getItemId() == R.id.reports) {
                replaceFragment(new ReportsFragment());
                return true;
            } else if (item.getItemId() == R.id.profile) {
                replaceFragment(new ProfileFragment());
                return true;
            } else if (item.getItemId() == R.id.shopping) {
                replaceFragment(new ShoppingFragment());
            }
            return false;
        });

        fragmentManager = getSupportFragmentManager();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.home);
        }
        replaceFragment(new HomeFragment());

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomDialog();
//                Toast.makeText(MainActivity.this, "is clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void showBottomDialog() {

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheetlayout);

        LinearLayout videoLayout = dialog.findViewById(R.id.layoutVideo);
        LinearLayout shortsLayout = dialog.findViewById(R.id.layoutShorts);
        LinearLayout liveLayout = dialog.findViewById(R.id.layoutLive);
        ImageView cancelButton = dialog.findViewById(R.id.cancelButton);

        videoLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                Toast.makeText(MainActivity.this, "Upload a Video is clicked", Toast.LENGTH_SHORT).show();

            }
        });

        shortsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                Toast.makeText(MainActivity.this, "Create a short is Clicked", Toast.LENGTH_SHORT).show();

            }
        });

        liveLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                Toast.makeText(MainActivity.this, "Go live is Clicked", Toast.LENGTH_SHORT).show();

            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }


    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.home_page) {
            replaceFragment(new HomeFragment());
        } else if (item.getItemId() == R.id.shopping) {
            replaceFragment(new ShoppingFragment());
        } else if (item.getItemId() == R.id.renovation) {
            replaceFragment(new ShoppingFragment());
        } else if (item.getItemId() == R.id.rest) {
            replaceFragment(new ShoppingFragment());
        } else if (item.getItemId() == R.id.street_food) {
            replaceFragment(new ShoppingFragment());
        } else if (item.getItemId() == R.id.utilities) {
            replaceFragment(new ShoppingFragment());
        } else if (item.getItemId() == R.id.login) {
            replaceFragment(new ShoppingFragment());
        } else if (item.getItemId() == R.id.logout) {
            replaceFragment(new ShoppingFragment());
        } else if (item.getItemId() == R.id.home_page) {
            Toast.makeText(this, "You clicked " + R.string.home, Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.shopping) {
            Toast.makeText(this, "You clicked " + R.string.category_name_shop, Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.renovation) {
            Toast.makeText(this, "You clicked " + R.string.category_name_renovation, Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.rest) {
            Toast.makeText(this, "You clicked " + R.string.category_name_rest, Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.street_food) {
            Toast.makeText(this, "You clicked " + R.string.category_name_street_food, Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.utilities) {
            Toast.makeText(this, "You clicked " + R.string.category_name_util, Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.login) {
            Toast.makeText(this, "You clicked " + R.string.login, Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.logout) {
            Toast.makeText(this, "You clicked " + R.string.logout, Toast.LENGTH_SHORT).show();
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
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