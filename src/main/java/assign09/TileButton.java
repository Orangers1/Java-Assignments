package assign09;

import javax.swing.*;

/**
 * Class defining
 *
 * @author Josh Eggett
 * @version 1.0
 */
public class TileButton extends JButton {

    private final int row;
    private final int column;
    private int imageID;

    public TileButton(String filename, int row, int column, int imageID) {
        super(new ImageIcon(filename));
        this.row = row;
        this.column = column;
        this.imageID = imageID;
    }

    /**
     * Gets the row
     * @return row of this tile
     */
    public int getRow() {
        return row;
    }
    /**
     * Gets the column
     * @return column of this tile
     */
    public int getColumn() {
        return column;
    }
    /**
     * Gets the image ID
     * @return imageID of this tile
     */
    public int getImageID() {
        return imageID;
    }
    /**
     * Updates this and the other tiles information to swap them.
     */
    public void swap(TileButton other) {
        // Swap Icons
        Icon tempIcon = this.getIcon();
        this.setIcon(other.getIcon());
        other.setIcon(tempIcon);

        // Swap image IDs
        int tempImageID = this.imageID;
        this.imageID = other.imageID;
        other.imageID = tempImageID;
    }
}
