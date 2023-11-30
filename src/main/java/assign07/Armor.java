package assign07;

/**
 * The Armor class represents an armor item that can be used for defense.
 */
public class Armor extends Item {
    private int defense;   // The defense value of the armor.
    private int condition; // The condition of the armor.

    /**
     * Constructs an Armor object with the given name.
     *
     * @param name The name of the armor.
     */
    public Armor(String name) {
        super(name);
    }

    /**
     * Gets the defense value of the armor.
     *
     * @return The defense value.
     */
    public int getDefense() {
        return this.defense;
    }

    /**
     * Gets the condition of the armor.
     *
     * @return The condition value.
     */
    public int getCondition() {
        return this.condition;
    }

    /**
     * Constructs an Armor object with the specified name, defense, and condition.
     *
     * @param itemName The name of the armor.
     * @param defense  The defense value of the armor.
     * @param condition The condition of the armor.
     */
    public Armor(String itemName, int defense, int condition) {
        super(itemName);
        this.defense = defense;
        this.condition = condition;
    }

    /**
     * Merges the current armor with another armor item.
     * The defense is added, and the condition is updated to the maximum of the two armors.
     *
     * @param other The other armor item to merge with.
     */
    @Override
    public void merge(Item other) {
        if (other instanceof Armor) {
            if (!(other instanceof Magic)) {
                if (!(other instanceof Tool)) {
                    defense = this.defense + ((Armor) other).defense;
                    condition = Math.max(this.condition, ((Armor) other).condition);
                }
            }
        }
    }

    /**
     * Compares this armor to another item. Armor is compared based on defense and condition.
     *
     * @param o The other item to compare with.
     * @return A negative integer if this armor is weaker, a positive integer if it's stronger, or 0 if they are equal.
     */
    @Override
    public int compareTo(Item o) {
        if (o instanceof Armor) {
            if ((this.condition * this.defense) == ((Armor) o).condition * ((Armor) o).defense) {
                return 0;
            }
            return -((this.defense * this.condition) - (((Armor) o).defense * this.condition));
        } else if (o instanceof Tool) {
            return -1; // Negative because Tool > the others.
        } else {
            return 1; // Positive because magic and armor > other types.
        }
    }
}