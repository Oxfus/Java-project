package ru.billing.client;

import ru.billing.stocklist.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        GenericItem food = new FoodItem("Coca-Cola");
        GenericItem technical = new TechnicalItem("Bucket", 100);
        GenericItem[] items = new GenericItem[]{food, technical};
        for (int i = 0; i < 2; i++) {
            items[i].printAll();
        }

        String line = "Конфеты 'Маска';45;120";
        String[] item_fld = line.split(";");
        FoodItem foody = new FoodItem(item_fld[0], Float.valueOf(item_fld[1]), Short.valueOf(item_fld[2]));
        foody.printAll();
        ItemCatalog cat = new ItemCatalog();

        GenericItem item1 = new GenericItem("a", 100, Category.GENERAL);
        GenericItem item2 = new GenericItem("a", 100, Category.GENERAL);
        GenericItem item3 = new GenericItem("b", 100, Category.GENERAL);
        GenericItem item4 = new GenericItem("c", 100, Category.GENERAL);
        GenericItem item5 = new GenericItem("d", 100, Category.GENERAL);
        GenericItem item6 = new GenericItem("e", 100, Category.GENERAL);
        GenericItem item7 = new GenericItem("f", 100, Category.GENERAL);
        GenericItem item8 = new GenericItem("g", 100, Category.GENERAL);
        GenericItem item9 = new GenericItem("h", 100, Category.GENERAL);
        GenericItem item10 = new GenericItem("j", 100, Category.GENERAL);


        cat.addItem(item1);
        cat.addItem(item2);
        cat.addItem(item3);
        cat.addItem(item4);
        cat.addItem(item5);
        cat.addItem(item6);
        cat.addItem(item7);
        cat.addItem(item8);
        cat.addItem(item9);
        cat.addItem(item10);

        long begin = new Date().getTime();
        for (int i = 0; i < 100000; i++)
            cat.findItemByID(10);
        long end = new Date().getTime();
        System.out.println("In HashMap: " + (end - begin));
        begin = new
                Date().getTime();
        for (int i = 0; i < 100000; i++)
            cat.findItemByIDAL(10);
        end = new Date().getTime();
        System.out.println("In ArrayList: " + (end - begin));

        CatalogLoader loader = new CatalogStubLoader();
        loader.load(cat);
        cat.printItems();
    }
}
