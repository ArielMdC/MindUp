package com.example.mindup.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.mindup.R;

public class PerfilFragment extends Fragment implements View.OnClickListener {

    ImageButton imageButtonFoto;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_perfil, container, false);

        imageButtonFoto = (ImageButton) view.findViewById(R.id.imageButtonFoto);

        imageButtonFoto.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        if (imageButtonFoto.getId() == view.getId()) {
            AlertDialog alertDialog;
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

            builder.setTitle("Carregar Foto");
            builder.setMessage("Carregar Foto");
            builder.setPositiveButton("Tirar Nova Foto", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getContext(), "Tirar Nova Foto", Toast.LENGTH_SHORT).show();
                }

            });
            builder.setNegativeButton("Galeria", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getContext(), "Galeria", Toast.LENGTH_SHORT).show();
                }

            });

            alertDialog = builder.create();
            alertDialog.show();
        }

    }

}
