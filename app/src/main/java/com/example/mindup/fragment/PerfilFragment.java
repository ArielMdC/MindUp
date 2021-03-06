package com.example.mindup.fragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mindup.R;


public class PerfilFragment extends Fragment implements View.OnClickListener {

    ImageButton imageButtonFoto;
    ImageView imageViewFoto;
    Integer CAMERA_PIC_REQUEST = 0;
    Integer PICK_IMAGE = 1;
    static final int REQUEST_IMAGE_OPEN = 1;
//teste
    public void selectImage() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("image/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        // Only the system receives the ACTION_OPEN_DOCUMENT, so no need to test.
        startActivityForResult(intent, REQUEST_IMAGE_OPEN);
    }
//teste

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        imageButtonFoto = (ImageButton) view.findViewById(R.id.imageButtonFoto);
        imageViewFoto = (ImageView) view.findViewById(R.id.imageViewFoto);

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
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, CAMERA_PIC_REQUEST);
                }

            });
            builder.setNegativeButton("Galeria", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getContext(), "Galeria", Toast.LENGTH_SHORT).show();
                    selectImage();
                }

            });

            alertDialog = builder.create();
            alertDialog.show();
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 0:
                if (resultCode == Activity.RESULT_OK) {
                    Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
                    imageViewFoto.setImageBitmap(thumbnail);
                }
            case 1:
                if (requestCode == REQUEST_IMAGE_OPEN && resultCode == Activity.RESULT_OK) {
                    Uri fullPhotoUri = data.getData();
                    imageViewFoto.setImageURI(fullPhotoUri);
                    // Do work with full size photo saved at fullPhotoUr
                }
        }
    }

}
