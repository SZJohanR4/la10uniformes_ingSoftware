package GUI_Proveedor_Interfaz;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import ingsoftware.la10uniformes_ingsoft.R;

/**
 * Created by Sebastian on 13/05/2016.
 */
public class Main_Proveedor extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        Consultar_Publicidad_Asignada.OnFragmentInteractionListener, Consultar_Uniformes_Publicados.OnFragmentInteractionListener,
        Eliminar_Uniformes.OnFragmentInteractionListener, Publicar_Uniformes.OnFragmentInteractionListener,
        Solicitar_Suscripcion.OnFragmentInteractionListener, Ver_Solicitud_Reserva.OnFragmentInteractionListener
        {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.proveedor);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "este es el boton para subir los uniformes por parte del proveedor", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
 */
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_Proveedor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        boolean fragmentTransaction=false;
        Fragment fragment=null;

        if (id == R.id.nav_consultar_uniformes) {
            fragment=new Consultar_Uniformes_Publicados();
            fragmentTransaction=true;

        } else if (id == R.id.nav_consultarpublicidad) {
            fragment=new Consultar_Publicidad_Asignada();
            fragmentTransaction=true;

        } else if (id == R.id.nav_eliminar_uniformes) {
            fragment=new Eliminar_Uniformes();
            fragmentTransaction=true;

        }else if (id == R.id.nav_solicitud_reserva) {
            fragment=new Ver_Solicitud_Reserva();
            fragmentTransaction=true;

        }else if (id == R.id.nav_solicitar_suscripcion){
            fragment=new Solicitar_Suscripcion();
            fragmentTransaction=true;
        }else if (id == R.id.nav_publicarUniforme){
            fragment=new Publicar_Uniformes();
            fragmentTransaction=true;
        }else if (id==R.id.action_settings){

        }


        if (fragmentTransaction) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_main,fragment)
                    .commit();
            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
