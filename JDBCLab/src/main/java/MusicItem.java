public class MusicItem {
    static int currentID = 0;
    protected int ID;
    protected String name;
    protected float price;
    protected Category category;

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

    public MusicItem(String name, float price, Category category) {
        ID = currentID++;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public MusicItem(int ID, String name, float price, Category category) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public void printAll()
    {
        System.out.println(
                "Id of article: " + ID + "\n" +
                        "Name of article: " + name + "\n" +
                        "Price of article: " + price + "\n" +
                        "General category: " + category + "\n"
        );
    }

}
