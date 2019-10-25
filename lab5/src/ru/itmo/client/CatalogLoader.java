package ru.itmo.client;

import ru.itmo.exceptions.CatalogLoadException;
import ru.itmo.stocklist.ItemCatalog;

public interface CatalogLoader {
    public void load(ItemCatalog cat) throws CatalogLoadException;
}
