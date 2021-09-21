package com.rodolfo.tortados;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="torta_detalle_entity")
public class TortaDetalleEntity {
    @PrimaryKey
    private int id;
    private String title;
    private String previewDescription;
    private String detailDescription;
    private String image;
    private String shape;
    private String size;
    private int price;
    private int lastPrice;
    private boolean delivery;

    public TortaDetalleEntity(int id, String title, String previewDescription, String detailDescription, String image, String shape, String size, int price, int lastPrice, boolean delivery) {
        this.id = id;
        this.title = title;
        this.previewDescription = previewDescription;
        this.detailDescription = detailDescription;
        this.image = image;
        this.shape = shape;
        this.size = size;
        this.price = price;
        this.lastPrice = lastPrice;
        this.delivery = delivery;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPreviewDescription() {
        return previewDescription;
    }

    public void setPreviewDescription(String previewDescription) {
        this.previewDescription = previewDescription;
    }

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(int lastPrice) {
        this.lastPrice = lastPrice;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }
}
