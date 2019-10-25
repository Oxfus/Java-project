package ru.billing.stocklist;

import java.util.Date;

public class FoodItem extends GenericItem{
    private Date dateOfIncome;
    private short expires;

    public Date getDate() {
        return dateOfIncome;
    }

    public void setDate(Date dateOfIncome) {
        this.dateOfIncome = dateOfIncome;
    }

    public short getExpires() {
        return expires;
    }

    public void setExpires(short expires) {
        this.expires = expires;
    }

    public FoodItem(String name, float price, FoodItem analog, Date dateOfIncome, short expires){
        super(name, price, Category.FOOD);
        this.dateOfIncome = dateOfIncome;
        this.expires = expires;
    }

    public FoodItem(String name, float price, short expires) {
        this(name, price, null, new Date(100),expires);
    }

    public FoodItem(String name) {
        this(name, 100, null, new Date(100), (short)1);
    }

    @Override
    public void printAll()
    {
        System.out.println(
                "Id of article: " + ID + "\n" +
                        "Name of article: " + name + "\n" +
                        "Price of article: " + price + "\n" +
                        "General category: " + category + "\n" +
                        "Date of Income: " + dateOfIncome + "\n" +
                        "Expires: " + expires + "\n"
        );
    }
}
