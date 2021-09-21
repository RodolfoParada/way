package com.rodolfo.tortados;

import android.app.Application;
import androidx.room.Room;

public class TortaApp extends Application {
    public static BaseDeDatos basededatoApp;

    @Override
    public void onCreate() {
        super.onCreate();
        TortaApp.basededatoApp = Room.databaseBuilder(this, BaseDeDatos.class, "app-db").build();
    }
}

