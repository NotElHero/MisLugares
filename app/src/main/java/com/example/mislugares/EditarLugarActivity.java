package com.example.mislugares;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class EditarLugarActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText etNombre, etDireccion, etTlf, etWeb, etDesc;
    String nombre, direccion, web, tlf, desc, tipo;
    Spinner spinner;
    Bundle bundleTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lugar_edit_layout);

        bundleTipo = new Bundle();

        Bundle bundle = getIntent().getExtras();
        nombre = bundle.getString("kNombre", "Nombre");
        direccion = bundle.getString("kDir", "Direccion");
        web = bundle.getString("kWeb", "Web");
        tlf = bundle.getString("kTlf", "Telefono");
        desc = bundle.getString("kDesc", "Descripcion");
        tipo = bundle.getString("kTipo", "Tipo");

        spinner = findViewById(R.id.spinner);

        etNombre = findViewById(R.id.editTextNombre);
        etDireccion = findViewById(R.id.editTextDirec);
        etTlf = findViewById(R.id.editTextTlf);
        etWeb = findViewById(R.id.editTextWeb);
        etDesc = findViewById(R.id.editTextDesc);

        //adapter para el spinner
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.tiposLugares, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setOnItemSelectedListener(this);
        spinner.setAdapter(spinnerAdapter);

        etNombre.setText(nombre);
        etDireccion.setText(direccion);
        etTlf.setText(tlf);
        etWeb.setText(web);
        etDesc.setText(desc);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.lugar_editar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.cancelar:
                finish();
                break;
            case R.id.guardar:
                MainActivity.lugares.add(new Lugar(R.drawable.waypoint_logo, etNombre.getText().toString(), etDireccion.getText().toString(),
                        etWeb.getText().toString(), etTlf.getText().toString(), etDesc.getText().toString(),
                        spinner.getTransitionName()));
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
