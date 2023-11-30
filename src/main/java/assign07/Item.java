package assign07;

public abstract class Item implements Comparable<Item>{
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public abstract void merge(Item other);

}
