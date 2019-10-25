package ru.itmo.client;


import ru.itmo.exceptions.CatalogLoadException;
import ru.itmo.exceptions.ItemAlreadyExistsException;
import ru.itmo.stocklist.Category;
import ru.itmo.stocklist.FoodItem;
import ru.itmo.stocklist.GenericItem;
import ru.itmo.stocklist.ItemCatalog;

import java.util.Date;

public class CatalogStubLoader implements CatalogLoader {

    @Override
    public void load(ItemCatalog cat) throws CatalogLoadException {
        GenericItem item1 = new GenericItem("Sony TV",23000, Category.GENERAL);
        FoodItem item2 = new FoodItem("Bread",12,null,new Date(),(short)10);
        try {
            cat.addItem(item1);
            cat.addItem(item2);
        } catch (ItemAlreadyExistsException e) {
            throw new CatalogLoadException(e);
        }
    }
}
