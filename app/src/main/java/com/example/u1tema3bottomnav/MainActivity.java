package com.example.u1tema3bottomnav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private ActionBar toolbar;
    Fragment FragmentoSeleccionado = null;
    FragmentManager fragmentManager =getSupportFragmentManager();
    FragmentTransaction transaction = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = getSupportActionBar();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Fragment FragmentoSeleccionado = null;
        Llamarvista();
        toolbar.setTitle("Shop");
    }



    void Llamarvista(){

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentoSeleccionado = new ListaFragmento();
        transaction.replace(R.id.frame_container, FragmentoSeleccionado);
        transaction.commit();
    }



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            Fragment FragmentoSeleccionado = null;
            FragmentManager fragmentManager =getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_shop:
                    /*FragmentoSeleccionado = new ListaFragmento();

                    transaction.replace(R.id.frame_container, FragmentoSeleccionado);
                    transaction.commit();
                    toolbar.setTitle("Shop");*/
                    Llamarvista();
                    return true;
                case R.id.navigation_gifts:
                    FragmentoSeleccionado = new GridFragment();
                    //FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.frame_container, FragmentoSeleccionado);
                    transaction.commit();
                    toolbar.setTitle("My Gifts");
                    return true;
                case R.id.navigation_cart:
                    toolbar.setTitle("Cart");
                    return true;
                case R.id.navigation_profile:
                    toolbar.setTitle("Profile");
                    return true;
            }
            return false;
        }
    };
}
