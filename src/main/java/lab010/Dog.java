package lab010;

public class Dog extends Pet implements ConversationPartner {
    private int age;
    

    public Dog(String name, int age) {
        super(name);
        // MISSING CODE
        this.age = age;
    }

    @Override
    public void talk() {

    }

    @Override
    public void feed(int amount) {

    }
    // MISSING METHOD
}
