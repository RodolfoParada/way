package com.rodolfo.tortados;

import androidx.room.RoomDatabase;
import androidx.room.Database;

@Database(entities = {TortaEntity.class,TortaDetalleEntity.class}, version = 1)
public abstract class BaseDeDatos extends RoomDatabase {
    public abstract TortaDAO tortaDAO();
}
