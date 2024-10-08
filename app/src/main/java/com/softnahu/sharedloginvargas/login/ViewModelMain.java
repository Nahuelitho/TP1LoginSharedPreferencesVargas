package com.softnahu.sharedloginvargas.login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.softnahu.sharedloginvargas.modelo.Usuario;
import com.softnahu.sharedloginvargas.registro.SegundaActivity;
import com.softnahu.sharedloginvargas.request.ApiClient;

public class ViewModelMain extends AndroidViewModel {
    private Context context;

    public ViewModelMain(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }
    public void login (String mail, String pass){
        Usuario usuario2 = ApiClient.login(context,mail,pass);
        if(usuario2!=null){
        if(usuario2.getEmail().equals(mail)&&usuario2.getPassword().equals(pass)){
            Intent intent= new Intent(context, SegundaActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
            Toast.makeText(context, "Inicio Sesion", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Clave Incorrecta", Toast.LENGTH_SHORT).show();
        }
        }else {
            Toast.makeText(context, "Cree un Usuario", Toast.LENGTH_SHORT).show();
        }

    }
    public void registrar (){
        Intent intent= new Intent(context, SegundaActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        Toast.makeText(context, "Registrar usuario", Toast.LENGTH_SHORT).show();
    }

}
