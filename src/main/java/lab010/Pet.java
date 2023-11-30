package lab010;

public abstract class Pet {
    private String name;
    public Pet(String name){
        this.name = name;
    }
    public abstract void feed(int amount);
}

