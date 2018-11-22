package com.example.android.myuts;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toolbar;


public class MainActivity extends AppCompatActivity {
    DrawerLayout mDrawerLayout;
    android.support.v7.widget.Toolbar toolbar;
    ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }


        mDrawerLayout = findViewById(R.id.drawer_layout);
        drawerToggle = setupDrawerToggle();

        NavigationView navigationView = findViewById(R.id.nav_view);
        // kita tambahkan listener
        mDrawerLayout.addDrawerListener(drawerToggle);
        setupNavDrawer(navigationView);


    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(
                this,
                mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
    }

    private void setupNavDrawer(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.nav_gallery:
                        fragment = new GalleryFragment();
                        break;
                    case R.id.nav_info:
                        fragment = new InfoFragment();
                        break;
                    case R.id.nav_tatacara:
                        fragment = new TataCaraFragment();
                        break;
                    default:
                        fragment = new GalleryFragment();
                }

                // pakai fragment manager untuk mengatur dan mengganti fragment yang sesuai
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

                // setelah terpilih kita check pilihan dan set judul toolbar sesuai menu
                item.setChecked(true);
                setTitle(item.getTitle());
                mDrawerLayout.closeDrawers();

                return true;
            }


        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                mDrawerLayout.openDrawer(Gravity.START);
                return true;


        }


        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }


    public void btn_smp(View view) {
        Intent intent = new Intent(MainActivity. this,
                FashionActivity. class );
        startActivity( intent );
    }

    public void sd(View view) {
        Intent intent = new Intent(MainActivity. this,
                FashionActivity. class );
        startActivity( intent );
    }

}
