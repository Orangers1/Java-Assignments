package assign07;

/**
 * The Magic class represents a magical item that has power and a cost associated with it.
 */
public class Magic extends Item {
    private int power;  // The power of the magic.
    private int cost;   // The cost of using the magic.

    /**
     * Returns a string representation of the Magic object.
     *
     * @return A string representation of the Magic object, including its name, power, and cost.
     */
    public String toString() {
        return "Magic: " + getName() + " - power = " + this.power + ", cost = " + this.cost;
    }

    /**
     * Gets the power of the magic.
     *
     * @return The power value of the magic.
     */
    public int getPower() {
        return this.power;
    }

    /**
     * Gets the cost of using the magic.
     *
     * @return The cost value of using the magic.
     */
    public int getCost() {
        return this.cost;
    }

    /**
     * Constructs a Magic object with the specified name, power, and cost.
     *
     * @param name  The name of the magic.
     * @param power The power value of the magic.
     * @param cost  The cost of using the magic.
     */
    public Magic(String name, int power, int cost) {
        super(name);
        this.power = power;
        this.cost = cost;
    }

    /**
     * Merges the current magic with another magic item.
     * The power is added, and the cost is increased by 1.
     *
     * @param other The other magic item to merge with.
     */
    @Override
    public void merge(Item other) {
        if (other instanceof Magic) {
            if (!(other instanceof Tool)) {
                if (!(other instanceof Armor)) {
                    power = this.power + ((Magic) other).power;
                    cost += 1;
                }
            }
        }
    }

    /**
     * Compares this magic to another item. Magic is compared based on the ratio of power to cost.
     *
     * @param o The other item to compare with.
     * @return A positive integer if this magic is stronger, a negative integer if it's weaker, or 0 if they are equal.
     */
    @Override
    public int compareTo(Item o) {
        if (o instanceof Magic) {
            return (this.power / cost) - (((Magic) o).power / ((Magic) o).cost);
        } else {
            return -1; // Negative because magic is considered less powerful than other types of items.
        }
    }
}