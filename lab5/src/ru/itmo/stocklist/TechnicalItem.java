package ru.itmo.stocklist;

public class TechnicalItem extends GenericItem {
    short warrantyTime;

    @Override
    public void printAll() {
        super.printAll();
        System.out.println("Warranty Time: " + warrantyTime);
    }
}
