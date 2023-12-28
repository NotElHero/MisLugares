package com.example.mislugares;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class LugarActivity extends AppCompatActivity implements View.OnClickListener {
    String nombre, direccion, web, tlf, desc, tipo;
    TextView textNombre, textTipo, textDireccion, textTlf, textWeb, textInfo;
    Button botonLlamar, botonIr;
    ImageButton botonCamara, botonGaleria;
    ImageView fotoLugar;
    int posicionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lugar_layout);

        Bundle bundle = getIntent().getExtras();
        nombre = bundle.getString("kNombre", "Nombre");
        direccion = bundle.getString("kDir", "Direccion");
        web = bundle.getString("kWeb", "Web");
        tlf = bundle.getString("kTlf", "Telefono");
        desc = bundle.getString("kDesc", "Descripcion");
        tipo = bundle.getString("kTipo", "Tipo");
        posicionList = bundle.getInt("kPosicion", 0);

        textNombre = findViewById(R.id.textNombreLugar);
        textDireccion = findViewById(R.id.textDirecc);
        textWeb = findViewById(R.id.textWeb);
        textTlf = findViewById(R.id.textTlf);
        textInfo = findViewById(R.id.textInfo);
        textTipo = findViewById(R.id.textTipo);

        textNombre.setText(nombre);
        textDireccion.setText(direccion);
        textWeb.setText(web);
        textTlf.setText(tlf);
        textInfo.setText(desc);
        textTipo.setText(tipo);

        botonLlamar = findViewById(R.id.botonLlamar);
        botonIr = findViewById(R.id.botonIr);
        botonLlamar.setOnClickListener(this);
        botonIr.setOnClickListener(this);

        botonCamara = findViewById(R.id.botonCamara);
        botonGaleria = findViewById(R.id.botonGaleria);
        botonCamara.setOnClickListener(this);
        botonGaleria.setOnClickListener(this);

        fotoLugar = findViewById(R.id.imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.lugar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.editarOpc:
                Intent intent = new Intent(this, EditarLugarActivity.class);
                Bundle bundle1 = new Bundle();
                bundle1.putString("kNombre", nombre);
                bundle1.putString("kDir", direccion);
                bundle1.putString("kWeb", web);
                bundle1.putString("kTlf", tlf);
                bundle1.putString("kDesc", desc);
                bundle1.putString("kTipo", tipo);
                intent.putExtras(bundle1);
                startActivity(intent);
                break;
            case R.id.borrarOpc:
                MainActivity.eliminarLugar(posicionList);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.botonLlamar:
                Intent llamar = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", textTlf.getText().toString(), null));
                startActivity(llamar);
                break;
            case R.id.botonIr:
                Intent irWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(textWeb.getText().toString()));
                startActivity(irWeb);
                break;
            case R.id.botonCamara:
                Intent camaraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(camaraIntent);
                break;
            case R.id.botonGaleria:
                //no funciona
                break;
        }
    }
}
