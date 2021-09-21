package com.rodolfo.tortados;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface TortaDAO {
    // DAO para manipular la tabla cake_entity
    @Insert
    public void addTorta(TortaEntity tortaEntity);

    @Query("SELECT * from torta_entity")
    public List<TortaEntity> getAllTortas();

    @Query("SELECT * from torta_entity WHERE id=:id")
    public TortaEntity getTortaById(int id);

    // DAO para manipular la tabla cake_detail_entity
    @Insert
    public void addTortaDetalle(TortaDetalleEntity tortaDetalleEntity);

    @Query("SELECT * from torta_detalle_entity WHERE id=:id")
    public TortaDetalleEntity getTortaDetalleById(int id);
}

