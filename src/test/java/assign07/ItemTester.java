package assign07;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The ItemTester class contains test cases for the Item, Armor, Tool, and Magic classes.
 */
public class ItemTester {
    ItemTester itemTester;

    /**
     * Sets up the ItemTester instance before each test.
     */
    @BeforeEach
    void setUp() {
        itemTester = new ItemTester();
    }

    /**
     * Tears down the ItemTester instance after each test.
     */
    @AfterEach
    void tearDown() {
    }

    /**
     * Test case for the Armor class.
     */
    @Test
    void testArmor() {
        Armor armor = new Armor("rats", 5, 5);
        assertEquals(5, armor.getCondition());
        assertEquals(5, armor.getDefense());
        assertEquals("rats", armor.getName());
        Armor otherArmor = new Armor("seven", 6, 6);
        armor.merge(otherArmor);
        assertEquals(11, armor.getDefense());
        assertEquals(6, armor.getCondition());
    }

    /**
     * Test case for the Tool class.
     */
    @Test
    void testTool() {
        Tool tool = new Tool("rats", 5);
        assertEquals(5, tool.getPower());
        assertEquals("rats", tool.getName());
        Tool otherTool = new Tool("seven", 6);
        tool.merge(otherTool);
        assertEquals(11, tool.getPower());
    }

    /**
     * Test case for the Magic class.
     */
    @Test
    void testMagic() {
        Magic magic = new Magic("rats", 5, 5);
        assertEquals(5, magic.getPower());
        assertEquals(5, magic.getCost());
        assertEquals("rats", magic.getName());
        Magic otherMagic = new Magic("seven", 6, 6);
        magic.merge(otherMagic);
        assertEquals(11, magic.getPower());
    }

    /**
     * Test case to ensure that merging items of different types does not affect the original item.
     */
    @Test
    void testMergeOtherItemTypes() {
        Magic mergeWithTool = new Magic("blue", 2, 16);
        Tool mergeWithMagic = new Tool("orange", 11111);
        Magic mergeWithToolTemp = mergeWithTool;
        mergeWithTool.merge(mergeWithMagic);
        assertEquals(mergeWithTool, mergeWithToolTemp);

        Magic mergeWithArmor = new Magic("carrot", 95, 25);
        Armor armorMergeWithMagic = new Armor("armorRat", 15, 13);
        Magic mergeWithArmorTemp = mergeWithArmor;
        mergeWithArmor.merge(armorMergeWithMagic);
        assertEquals(mergeWithArmor, mergeWithArmorTemp);

        Tool toolMergeWithTool = new Tool("rats", 15);
        Armor armorMergeWithTool = new Armor("steve", 207, 32);
        Tool toolMergeWithToolTemp = toolMergeWithTool;
        toolMergeWithTool.merge(armorMergeWithTool);
        assertEquals(toolMergeWithTool, toolMergeWithToolTemp);
        assertEquals(15, toolMergeWithTool.getPower());
    }
}