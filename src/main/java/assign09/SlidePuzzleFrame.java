package assign09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Josh Eggett
 * @version 1.0
 */
public class SlidePuzzleFrame extends JFrame implements ActionListener {
    private TileButton[][] tiles;
    private TileButton emptyTile;
    private JButton shuffleButton;
    private JButton solutionButton;
    private JLabel messageLabel;

    /**
     * Constructor.
     */
    public SlidePuzzleFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        tiles = new TileButton[4][4];
        createTiles();

        createUI();
        shuffle();
    }

    /**
     * Helper method to make the tiles for the GUI.
     */
    private void createTiles() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                String filename = "src/assign09/tile_" + row + "_" + col + ".png";
                tiles[row][col] = new TileButton(filename, row, col, 4 * row + col); // to get the ID of an image you just multiply row by 4 and add column.
            }
        }
        emptyTile = tiles[0][0]; // Initially, set the empty tile to the top-left corner
    }

    /**
     * Helper method to create the User interface.
     */
    private void createUI() {
        JPanel puzzlePanel = new JPanel(new GridLayout(4, 4));
        puzzlePanel.setPreferredSize(new Dimension(720, 720));

        // Add TileButtons to the puzzle panel
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                puzzlePanel.add(tiles[row][col]);
                tiles[row][col].addActionListener(this); // Add ActionListener to each TileButton
            }
        }
        // Create a panel for the messages
        JPanel messagePanel = new JPanel();
        messageLabel = new JLabel();
        messagePanel.add(messageLabel);

        JPanel buttonPanel = new JPanel();

        // Add shuffle button
        shuffleButton = new JButton("Shuffle");
        shuffleButton.addActionListener(this);
        buttonPanel.add(shuffleButton);

        // Add solution button
        solutionButton = new JButton("Show Solution");
        solutionButton.addActionListener(this);
        buttonPanel.add(solutionButton);

        // Create a main panel and add the puzzle panel and button panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(puzzlePanel, BorderLayout.CENTER);
        mainPanel.add(messagePanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Set the content pane of the frame to be the main panel
        setContentPane(mainPanel);
    }

    /**
     * ActionListener implementation.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button clicks
        if (e.getSource() == shuffleButton) {
            shuffle();
        } else if (e.getSource() == solutionButton) {
            solve();
        } else if (e.getSource() instanceof TileButton) {
            TileButton clickedTile = (TileButton) e.getSource();

            // check if the clicked tile is adjacent to the empty tile
            if (adjacentToEmpty(clickedTile)) {
                swapTiles(emptyTile, clickedTile);
                emptyTile = clickedTile; // reassign the empty tile variable

                // check if the puzzle has been solved
                if (isSolved()) {
                    showMessage("Congratulations! Puzzle Solved!");
                } else {
                    showMessage(""); // clear any previous message
                }
            } else {
                showMessage("Please click on a tile adjacent to the empty tile.");
            }
        }
    }

    /**
     * Helper method to display a string message in the GUI.
     * @param message - The message to display.
     */
    private void showMessage(String message) {
        messageLabel.setText(message);
    }

    /**
     * Method that sets the puzzle to the solved state.
     */
    public void solve() {
        // Loop over each tile
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                TileButton currentTile = tiles[row][col];

                // check if the imageID and button coords match
                while (currentTile.getImageID() != (4 * row + col)) {
                    // Swap the current tile with the one corresponding to the correct image ID
                    TileButton targetTile = tiles[currentTile.getImageID() / 4][currentTile.getImageID() % 4];
                    swapTiles(currentTile, targetTile);
                }
            }
        }
    }

    /**
     * Method to check if the puzzle has been solved. Called when tiles are swapped.
     *
     * @return true if puzzle is solved, otherwise false.
     */
    public boolean isSolved() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                TileButton currentTile = tiles[row][col];
                if (currentTile.getRow() != row || currentTile.getColumn() != col || currentTile.getImageID() != (4 * row + col)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Helper method to check if a tile is adjacent to the empty tile.
     *
      * @param tile - tile to check if its adjacent to the empty one
     * @return boolean true if its adjacent to the empty tile, false if not.
     */
    private boolean adjacentToEmpty(TileButton tile) {
        int rowDiff = Math.abs(tile.getRow() - emptyTile.getRow());
        int colDiff = Math.abs(tile.getColumn() - emptyTile.getColumn());
        return (rowDiff + colDiff == 1);
    }

    /**
     * Helper method to use the TileButtons swap method and swap the empty tile around
     *
      * @param tile1 - first tile to swap
     * @param tile2 - second to swap
     */
    private void swapTiles(TileButton tile1, TileButton tile2) {
        tile1.swap(tile2);
        if (tile1 == emptyTile) {
            emptyTile = tile2;
        } else if (tile2 == emptyTile) {
            emptyTile = tile1;
        }

    }

    /**
     * Method that shuffles the tiles.
     */
    public void shuffle() {
        Random rand = new Random();

        // Perform a series of random swaps to shuffle the puzzle
        for (int i = 0; i < 1000; i++) { // You can adjust the number of shuffles as needed
            // Gets the list of adjacent tiles to the empty tile
            TileButton[] adjacentTiles = getAdjacentTiles(emptyTile);

            // Select a random adjacent tile
            int randomIndex = rand.nextInt(adjacentTiles.length);
            TileButton randomTile = adjacentTiles[randomIndex];

            // Swap the empty tile with the randomly selected tile
            swapTiles(emptyTile, randomTile);
        }
    }

    /**
     * Helper method to get a list of adjacent tiles to the given tile
     *
     * @param tile the tile to check what is adjacent to it.
     * @return an array of adjacent tiles
     */
    private TileButton[] getAdjacentTiles(TileButton tile) {
        int row = tile.getRow();
        int col = tile.getColumn();

        TileButton[] adjacentTiles = new TileButton[4];
        int count = 0;

        if (row > 0) {
            adjacentTiles[count++] = tiles[row - 1][col]; // Tile above
        }
        if (row < 3) {
            adjacentTiles[count++] = tiles[row + 1][col]; // Tile below
        }
        if (col > 0) {
            adjacentTiles[count++] = tiles[row][col - 1]; // Tile to the left
        }
        if (col < 3) {
            adjacentTiles[count++] = tiles[row][col + 1]; // Tile to the right
        }
        return Arrays.copyOf(adjacentTiles, count);
    }
}