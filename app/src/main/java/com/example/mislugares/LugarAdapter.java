package com.example.mislugares;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class LugarAdapter extends ArrayAdapter<Lugar> {
    private Context context;
    private int resource;

    public LugarAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Lugar> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(resource, parent, false);

        ImageView imageViewFoto = convertView.findViewById(R.id.foto);
        TextView textViewNombre = convertView.findViewById(R.id.textNombre);
        TextView textViewDirecc = convertView.findViewById(R.id.textDireccion);

        imageViewFoto.setImageResource(getItem(position).getFoto());
        textViewNombre.setText(getItem(position).getNombre());
        textViewDirecc.setText(getItem(position).getDireccion());

        return convertView;
    }
}
