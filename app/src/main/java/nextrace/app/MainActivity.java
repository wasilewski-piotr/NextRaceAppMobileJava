package nextrace.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.home:{
                if(drawerLayout.isDrawerOpen(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return true;
                }else{
                    return false;
                }
            }

            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    private void init(){
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout);
        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.main_page:{
                NavOptions navOptions = new NavOptions.Builder()
                        .setPopUpTo(R.id.main, true)
                        .build();
                Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.main_page_fragment, null, navOptions);
                break;
            }

            case R.id.search_page:{
                if(isValidDestination(R.id.search_page)){
                    Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.search_page_fragment);
                }
                break;
            }

            case R.id.formula_1_page:{
                if(isValidDestination(R.id.formula_1_page)){
                    Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.formula_1_page_fragment);
                }
                break;
            }

            case R.id.formula_2_page:{
                if(isValidDestination(R.id.formula_2_page)){
                    Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.formula_2_page_fragment);
                }
                break;
            }

            case R.id.formula_3_page:{
                if(isValidDestination(R.id.formula_3_page)){
                    Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.formula_3_page_fragment);
                }
                break;
            }

            case R.id.formula_e_page:{
                if(isValidDestination(R.id.formula_e_page)){
                    Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.formula_e_page_fragment);
                }
                break;
            }

            case R.id.dtm_page:{
                if(isValidDestination(R.id.dtm_page)){
                    Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.dtm_page_fragment);
                }
                break;
            }

            case R.id.history_events_page:{
                if(isValidDestination(R.id.history_events_page)){
                    Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.previous_races_page_fragment);
                }
                break;
            }

            case R.id.about_me_page:{
                if(isValidDestination(R.id.about_me_page)){
                    Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.about_me_page_fragment);
                }
                break;
            }

            case R.id.donate_page:{
                if(isValidDestination(R.id.donate_page)){
                    Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.donate_page_fragment);
                }
                break;
            }
        }

        menuItem.setChecked(true);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private boolean isValidDestination(int dest){
        return dest != Navigation.findNavController(this, R.id.nav_host_fragment).getCurrentDestination().getId();
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(Navigation.findNavController(this, R.id.nav_host_fragment), drawerLayout);
    }
}
