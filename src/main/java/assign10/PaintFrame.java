package assign10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;

public class PaintFrame extends JFrame implements ActionListener {
    private PaintPanel paintPanel;
    private JButton[] buttons;
    private boolean fill = false;


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttons[0]) { // oval button
            selectOval();
        } else if (e.getSource() == buttons[1]) { // color button
            selectColor();
        }else if (e.getSource() == buttons[2]) { // line button
            selectLine();
        }else if (e.getSource() == buttons[3]) { // rectangle button
            selectRectangle();
        }else if (e.getSource() == buttons[4]) { // fill button
            selectFill();
        }
    }
    private void selectOval(){
        paintPanel.setCurrentShapeType(EnumShape.OVAL);
    }
    private void selectColor(){
        Color color = JColorChooser.showDialog(this, "Choose a color!", Color.BLACK);
        paintPanel.setNextShapeColor(color);
    }
    private void selectRectangle(){
        paintPanel.setCurrentShapeType(EnumShape.RECTANGLE);
    }
    private void selectLine(){
        paintPanel.setCurrentShapeType(EnumShape.LINE);
    }
    private void selectFill(){
        fill = !fill;
        paintPanel.setFillMode(fill);
    }
    public PaintFrame() {
        super("Paint Frame");

        // Set up the main frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Create PaintPanel
        paintPanel = new PaintPanel();
        add(paintPanel, BorderLayout.CENTER);

        // Create JPanel for buttons
        JPanel buttonPanel = new JPanel();

        // Create buttons with icons
        JButton colorButton = createButton("Color", "colorIcon.png", "Select color");
        JButton lineButton = createButton("Line", "lineIcon.png", "Draw a line");
        JButton rectangleButton = createButton("Rectangle", "rectIcon.png", "Draw a rectangle");
        JButton ovalButton = createButton("Oval", "ovalIcon.png", "Draw an oval");
        JButton fillToggle = createButton("Toggle Fill", "fillIcon.png", "Toggle fill mode");

        // Add buttons to the button panel
        buttonPanel.add(colorButton);
        buttonPanel.add(lineButton);
        buttonPanel.add(rectangleButton);
        buttonPanel.add(ovalButton);
        buttonPanel.add(fillToggle);

        buttons = new JButton[5];
        buttons[0] = ovalButton;
        buttons[1] = colorButton;
        buttons[2] = lineButton;
        buttons[3] = rectangleButton;
        buttons[4] = fillToggle;

        // Add the button panel to the frame
        add(buttonPanel, BorderLayout.SOUTH);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Create a menu
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        // Create menu items with icons
        JMenuItem saveItem = createMenuItem("Save", "NoImage", "Save drawing to file");
        JMenuItem clearItem = createMenuItem("Clear", "NoImage", "Clear drawing");
        JMenuItem exitItem = createMenuItem("Exit", "NoImage", "Exit the application");

        // Add menu items to the menu
        fileMenu.add(saveItem);
        fileMenu.add(clearItem);
        fileMenu.add(exitItem);

        // Set up action listeners for buttons and menu items
        colorButton.addActionListener(this);
        lineButton.addActionListener(this);
        rectangleButton.addActionListener(this);
        ovalButton.addActionListener(this);
        fillToggle.addActionListener(this);
        saveItem.addActionListener(this);
        clearItem.addActionListener(this);
        exitItem.addActionListener(this);
    }
    private JButton createButton(String text, String iconName, String toolTip) {
        JButton button = new JButton(text);
        button.setToolTipText(toolTip);

        try {
            if (!(iconName.equals("NoImage"))) {
                Image icon = ImageIO.read(new File("src/main/java/assign10/" + iconName));
                button.setIcon(new ImageIcon(icon));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return button;
    }
    private JMenuItem createMenuItem(String text, String iconName, String toolTip) {
        JMenuItem menuItem = new JMenuItem(text);
        menuItem.setToolTipText(toolTip);

        try {
            if(!(iconName.equals("NoImage"))) {
                Image icon = ImageIO.read(new File("src/main/java/assign10/" + iconName));
                menuItem.setIcon(new ImageIcon(icon));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return menuItem;
    }

}
