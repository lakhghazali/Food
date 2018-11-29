package com.example.lakhder.eatit.model;

public class Food {

    private String Description,Name,Image,MenuId,Price,Discount;

    public Food() {
    }

    public Food(String description, String name, String image, String menuId, String price, String discount) {
        Description = description;
        Name = name;
        Image = image;
        MenuId = menuId;
        Price = price;
        Discount = discount;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }
}
