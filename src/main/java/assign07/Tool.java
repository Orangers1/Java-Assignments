package assign07;

/**
 * The Tool class represents a tool item that has power associated with it.
 */
public class Tool extends Item {
    private int power;  // The power of the tool.

    /**
     * Constructs a Tool object with the specified name and power.
     *
     * @param name  The name of the tool.
     * @param power The power value of the tool.
     */
    public Tool(String name, int power) {
        super(name);
        this.power = power;
    }

    /**
     * Gets the power of the tool.
     *
     * @return The power value of the tool.
     */
    public int getPower() {
        return this.power;
    }

    /**
     * Merges the current tool with another tool item.
     * The power is added.
     *
     * @param other The other tool item to merge with.
     */
    @Override
    public void merge(Item other) {
        if (other instanceof Tool) {
            if (!(other instanceof Magic)) {
                if (!(other instanceof Armor)) {
                    power = this.power + ((Tool) other).power;
                }
            }
        }
    }

    /**
     * Compares this tool to another item. Tools are compared based on their power.
     *
     * @param o The other item to compare with.
     * @return A positive integer if this tool is stronger, a negative integer if it's weaker, or 0 if they are equal.
     */
    @Override
    public int compareTo(Item o) {
        if (o instanceof Tool) {
            return this.power - ((Tool) o).power;
        } else {
            return 1; // Positive because tools are considered more powerful than other types of items.
        }
    }
}