package com.exampleandroiddemottest.petagramrecyclerview.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.exampleandroiddemottest.petagramrecyclerview.R;
import com.exampleandroiddemottest.petagramrecyclerview.db.ConstructorPets;
import com.exampleandroiddemottest.petagramrecyclerview.pojo.Mascota;

import java.util.ArrayList;

public class PetsAdapter  extends  RecyclerView.Adapter<PetsAdapter.PetsViewHolder>{


    ArrayList<Mascota> mMascotaArrayLi;
    Activity activity;

    public PetsAdapter(ArrayList<Mascota> mascotaArrayLi, Activity activity) {
        this.mMascotaArrayLi = mascotaArrayLi;
        this.activity = activity;
    }






    //Inflar el layout y lo pasara al viewholder para el obtenga los views
    @NonNull
    @Override
    public PetsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflar o dar vida a nuestro layour cardview;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card__view__peg,parent,false);

        PetsViewHolder petsViewHolder = new PetsViewHolder(v);

        return petsViewHolder;
    }

    ////Asocia cada elemnto de  la lista con cada view
    ////
    //Este metodo se va invocando cada vez que se va recorriendo la lista de contactos, uno a uno items.
    //y va obteniendo la position of each element
    //asi va extrayendo los elementos de cada lista

    @Override
    public void onBindViewHolder(@NonNull final PetsViewHolder petsViewHolder, int position) {

            final Mascota mascota = mMascotaArrayLi.get(position);

              petsViewHolder.imgPhotoMain.setImageResource(mascota.getImageMain());
              petsViewHolder.textBoneWhite.setText(mascota.getNamePets());
              petsViewHolder.textBoneYellow.setText(String.valueOf(mascota.getLikes()));


              petsViewHolder.imgBoneWhite.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {

                     mascota.setLikes(mascota.getLikes()+1);
                     petsViewHolder.textBoneYellow.setText(String.valueOf(mascota.getLikes()));

                      Toast.makeText(activity,"Diste like a "+ mascota.getNamePets(),Toast.LENGTH_SHORT).show();
                      ConstructorPets    constructorPets = new ConstructorPets(activity);
                      constructorPets.darLikePets(mascota);
                      petsViewHolder.textBoneYellow.setText(String.valueOf(constructorPets.obtenerLikesPet(mascota)));
                    //  Toast.makeText(activity,String.valueOf(mascota.getLikes()),Toast.LENGTH_SHORT).show();
                  }
              });



    }

    @Override
    public int getItemCount() {
        return mMascotaArrayLi.size();
    }




    public static  class PetsViewHolder extends RecyclerView.ViewHolder  {

        private ImageView imgPhotoMain;
        private  ImageView imgBoneWhite;
        private TextView textBoneWhite;
        private TextView  textBoneYellow;



        public PetsViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imgPhotoMain = itemView.findViewById(R.id.imgPhotoMain);
            this.imgBoneWhite = itemView.findViewById(R.id.imgBoneWhite);
            this.textBoneWhite = itemView.findViewById(R.id.textBoneWhite);
            this.textBoneYellow = itemView.findViewById(R.id.textBoneYellow);

        }



    }

}
