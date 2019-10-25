package ru.itmo.client;

import ru.itmo.exceptions.CatalogLoadException;
import ru.itmo.exceptions.ItemAlreadyExistsException;
import ru.itmo.stocklist.FoodItem;
import ru.itmo.stocklist.ItemCatalog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;


public class CatalogFileLoader implements CatalogLoader {
    private String fileName;
    ItemCatalog cat;
    public CatalogFileLoader(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public void load(ItemCatalog cat) throws CatalogLoadException {
        FileInputStream fis;
        String line;
        File f = new File(
                getClass().getClassLoader().getResource(fileName).getFile()
        );

        try {
            fis = new FileInputStream(f);
            Scanner s = new Scanner(fis);

            while(s.hasNextLine()) {
                line = s.nextLine();
                if(line.length() == 0) break;
                String[] item_fld = line.split(";");
                String name = item_fld[0];
                float price = Float.parseFloat(item_fld[1]);
                short expires = Short.parseShort(item_fld[2]);
                FoodItem item = new FoodItem(name, price, null, new Date(), expires);
                cat.addItem(item);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new CatalogLoadException(e);
        } catch (ItemAlreadyExistsException e) {
            e.printStackTrace();
            throw new CatalogLoadException(e);
        }
    }
}

