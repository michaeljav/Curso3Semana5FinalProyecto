package com.exampleandroiddemottest.petagramrecyclerview.presentador;



import android.content.Context;

import com.exampleandroiddemottest.petagramrecyclerview.db.ConstructorPets;
import com.exampleandroiddemottest.petagramrecyclerview.fragment.IRecyclerViewFragmentView;
import com.exampleandroiddemottest.petagramrecyclerview.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragmentPresentadorPet implements  IRecyclerViewFragmentPresenter {
    private Context mContext;
    private IRecyclerViewFragmentView mIRecyclerViewFragmentView;
   private ConstructorPets mConstructorPets;
   private ArrayList<Mascota> mPets;


    public RecyclerViewFragmentPresentadorPet(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        mContext = context;
        mIRecyclerViewFragmentView = iRecyclerViewFragmentView;
        obtenerPetsBaseDatos();
    }


    @Override
    public void obtenerPetsBaseDatos() {
        mConstructorPets = new ConstructorPets(mContext);

        mPets = mConstructorPets.obtenerDatos();
        mostrarPetsRecyclerView();


    }

    @Override
    public void mostrarPetsRecyclerView() {

        mIRecyclerViewFragmentView.inicializarOSetAdapterAlRecyclerView(mIRecyclerViewFragmentView.crearAdaptador(mPets));
        mIRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
