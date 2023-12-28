package com.example.mislugares;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    static ArrayList<Lugar> lugares;
    Bundle bundle;
    LugarAdapter lugarAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        lugares = new ArrayList<>();

        //Lugares predefinidos
        lugares.add(new Lugar(R.drawable.educacion_logo, "IES Julián Marías", "C/Eusebio González Suárez, 43, 47014 Valladolid",
                "http://iesjulianmarias.centros.educa.jcyl.es/sitio", "983354733", "Uno de los mejores institutos de Parquesol", "Educacion"));
        lugares.add(new Lugar(R.drawable.cafe_logo, "Cafetería Donde Fer", "C/Cdad. de la Habana, 15, 47016 Valladolid",
                "https://estacafeterianotenianitlfniweb.com", "989453678", "La cafetería de toda la vida", "Restauracion"));
        lugares.add(new Lugar(R.drawable.waypoint_logo, "Rio Shopping", "C/Me Falta un Tornillo",
                "https://www.rioshopping.com/", "983327820", "Uno de los mejores centros comerciales de Valladolid", "CC"));

        //Adaptador personalizado para mostrar los lugares en el arrayList
        lugarAdapter = new LugarAdapter(this, R.layout.filas_listview, lugares);
        listView.setAdapter(lugarAdapter);
        listView.setOnItemClickListener(this);

        bundle = new Bundle();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    //opciones del menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast toast = makeText(this, "Funcion no implementada", LENGTH_SHORT);
        switch (item.getItemId()){
            case R.id.configOpt:
                toast.show();
                break;
            case R.id.acercaOpt:
                Toast acercaDe = makeText(this, "Esta aplicación ha sido desarollada por Javier Villacorta García", LENGTH_SHORT);
                acercaDe.show();
                break;
            case R.id.nuevoOpt:
                Intent nuevo = new Intent(this, NuevoLugarActivity.class);
                startActivity(nuevo);
                break;
            case R.id.buscarOpt:
                toast.show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this, LugarActivity.class);
        //Mete los valores de cada elemento del arrayList en un bundle para mandarlo
        //a la siguiente actividad
        bundle.putString("kNombre", lugares.get(i).getNombre());
        bundle.putString("kDir", lugares.get(i).getDireccion());
        bundle.putString("kWeb", lugares.get(i).getWeb());
        bundle.putString("kTlf", lugares.get(i).getTlf());
        bundle.putString("kDesc", lugares.get(i).getDescrip());
        bundle.putString("kTipo", lugares.get(i).getTipo());
        bundle.putInt("kPosicion", i);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    //Elimina el lugar seleccionado
    public static void eliminarLugar(int posLugar){
        lugares.remove(posLugar);
    }
}