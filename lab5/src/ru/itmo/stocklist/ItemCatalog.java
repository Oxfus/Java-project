package ru.itmo.stocklist;

import ru.itmo.exceptions.ItemAlreadyExistsException;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemCatalog {
    private HashMap<Integer, GenericItem> catalog = new HashMap<Integer,GenericItem>();

    private ArrayList<GenericItem> ALCatalog = new ArrayList<GenericItem>();

    public void addItem(GenericItem item) throws ItemAlreadyExistsException {
        if (catalog.containsKey(item))
            throw new ItemAlreadyExistsException();
        catalog.put(item.getID(), item);
        ALCatalog.add(item);
    }

    public void printItems() {
        for (GenericItem i : ALCatalog) {
            i.printAll();
        }
    }

    public GenericItem findItemByID(int id) {
        if (!catalog.containsKey(id)) {
            return null;
        } else {
            return catalog.get(id);
        }
    }

    public GenericItem findItemByIDAL(int id) {
        for (GenericItem i : ALCatalog) {
            if (i.getID() == id) return i;
        }
        return null;
    }
}
