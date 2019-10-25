package ru.billing.stocklist;

public class GenericItem {
    static int currentID = 0;
    protected int ID;
    protected String name;
    protected float price;
    protected Category category;

    public static int getCurrentID() {
        return currentID;
    }

    public static void setCurrentID(int currentID) {
        GenericItem.currentID = currentID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public GenericItem(String name, float price, Category category) {
        ID = currentID++;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public GenericItem(String name, float price, GenericItem analog) {
        this(name, price, analog.category);
    }

    public GenericItem() {
        this.ID = currentID++;
    }

    public void printAll()
    {
        //
        System.out.println(
                "Id of article: " + ID + "\n" +
                        "Name of article: " + name + "\n" +
                        "Price of article: " + price + "\n" +
                        "General category: " + category
        );
    }

}
