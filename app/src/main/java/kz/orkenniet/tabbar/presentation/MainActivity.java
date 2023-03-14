package kz.orkenniet.tabbar.presentation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import kz.orkenniet.R;
import kz.orkenniet.library.presentation.BibliotekaFragment;
import kz.orkenniet.quotes.presentation.CitatyFragment;
import kz.orkenniet.home.presentation.HomeFragment;
import kz.orkenniet.profile.presentation.ProfilFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
        private BottomNavigationView bottomNavigationView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            bottomNavigationView = findViewById(R.id.navigation);
            bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

            // Set the home fragment as the default fragment to display
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
        }

        private BottomNavigationView.OnNavigationItemSelectedListener navListener =
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;

                        switch (item.getItemId()) {
                            case R.id.glavnaya:
                                selectedFragment = new HomeFragment();
                                break;
                            case R.id.biblioteka:
                                selectedFragment = new BibliotekaFragment();
                                break;
                            case R.id.citaty:
                                selectedFragment = new CitatyFragment();
                                break;
                            case R.id.profil:
                                selectedFragment = new ProfilFragment();
                                break;
                        }

                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                selectedFragment).commit();

                        return true;
                    }
                };

}