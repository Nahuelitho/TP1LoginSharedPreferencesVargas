package com.softnahu.sharedloginvargas.registro;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.softnahu.sharedloginvargas.modelo.Usuario;
import com.softnahu.sharedloginvargas.request.ApiClient;

public class ViewModelSegundaActivity extends AndroidViewModel {
    private Context context;

    private MutableLiveData<Usuario>mUser;

    public LiveData<Usuario>getMUser(){
        if (mUser==null){
            mUser=new MutableLiveData<>();
        }
        return mUser;
    }

    public ViewModelSegundaActivity(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }

    public void guardar (Usuario usuario){
        ApiClient.guardar(context,usuario);
        Toast.makeText(context, "Usuario Guardado", Toast.LENGTH_SHORT).show();
    }
    public void leer(){
        Usuario usuario=ApiClient.leer(context);
        if(usuario.getDni() == -1) {
            mUser.setValue(new Usuario());
        }
        else {
            mUser.setValue(usuario);
        }
    }

}
