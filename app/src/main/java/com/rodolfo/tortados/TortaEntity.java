package com.rodolfo.tortados;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="torta_entity")
public class TortaEntity {
    @PrimaryKey
    private int id;
    private String title;
    private String previewDescription;
    private String size;
    private int price;
    private String image;

    public TortaEntity(int id, String title, String previewDescription, String size, int price, String image) {
        this.id = id;
        this.title = title;
        this.previewDescription = previewDescription;
        this.size = size;
        this.price = price;
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
