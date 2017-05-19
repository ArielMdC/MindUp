package com.example.mindup;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PerfilActivity extends Activity implements View.OnClickListener {

    ImageButton imageButtonEditarPerfil, imageButtonNovaFoto, imageButtonSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        imageButtonEditarPerfil = (ImageButton) findViewById(R.id.imageButtonEditarPerfil);
        imageButtonNovaFoto = (ImageButton) findViewById(R.id.imageButtonNovaFoto);
        imageButtonSalvar = (ImageButton) findViewById(R.id.imageButtonSalvar);

        imageButtonEditarPerfil.setOnClickListener(this);
        imageButtonSalvar.setOnClickListener(this);
        imageButtonNovaFoto.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

    }
}
