package edu.gmu.cs477.khan_suyat_finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        loadFragment(new GroceryListFragment());
    }

    private boolean loadFragment(Fragment fragment){
        if(fragment != null){

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();

            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch(menuItem.getItemId()){
            case R.id.navigation_recipes:
                fragment = new RecipesFragment();
                break;

            case R.id.navigation_grocerylist:
                fragment = new GroceryListFragment();
                break;

            case R.id.navigation_calories:
                fragment = new CaloricIntakeFragment();
                break;
        }
        return loadFragment(fragment);
    }

    /*this button can be found in Grocery List page*/
    public void onAddClick(View view){
        Intent intent = new Intent(this, AddGrocery.class);
        startActivity(intent);
    }
}
