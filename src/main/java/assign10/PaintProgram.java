package assign10;

import javax.swing.*;

public class PaintProgram {
    public static void main(String[] args) {

        PaintFrame frame = new PaintFrame();
        frame.pack();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Slide Puzzle");
    }
}
