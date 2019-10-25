package ru.billing.stocklist;

public class TechnicalItem extends GenericItem {
    short warrantyTime;

    public TechnicalItem(String name, float price){
        super(name, price, Category.TECHNICAL);
    }

    @Override
    public void printAll() {
        super.printAll();
        System.out.println("Warranty Time: " + warrantyTime+ "\n");
    }
}
