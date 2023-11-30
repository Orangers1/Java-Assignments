package assign10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Iterator;

public class PaintPanel extends JPanel implements MouseListener, MouseMotionListener, MouseWheelListener {
    private ArrayList<Shape2D> drawnShapes; // ArrayList to hold all drawn shapes
    private Shape2D previewShape; // Shape for temporary preview
    private EnumShape currentShapeType; // Current shape type to draw
    private Color nextShapeColor; // Color to apply to the next shape
    private boolean fillMode; // Current fill mode
    private double zoomFactor; // Zoom factor
    private double lastPressedX; // X coordinate where the mouse button was last pressed
    private double lastPressedY; // Y coordinate where the mouse button was last pressed

    // Constructor
    public PaintPanel() {
        drawnShapes = new ArrayList<>();
        this.setBackground(Color.WHITE);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        previewShape = null;
        currentShapeType = EnumShape.LINE;
        nextShapeColor = Color.BLACK;
        fillMode = false;
        zoomFactor = 1.0;
        lastPressedX = 0.0;
        lastPressedY = 0.0;

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("pressed mouse");
        lastPressedX = e.getX();
        lastPressedY = e.getY();

        // Create a temporary preview shape based on the current shape type
        previewShape = createShape(getMousePosition().x, getMousePosition().y, e.getX(), e.getY(),nextShapeColor, fillMode);
        this.drawnShapes.add(previewShape);
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Add the preview shape to the list of drawn shapes
        if (previewShape != null) {
            drawnShapes.add(previewShape);

            repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Resize the preview shape based on the current mouse coordinates
        if (previewShape != null) {
            previewShape.resize(e.getX(), e.getY());
            repaint();
        }
    }

        @Override
        public void mouseMoved(MouseEvent e) {
            // Resize the preview shape based on the current mouse coordinates
            if (previewShape != null) {
                previewShape.move(e.getX(), e.getY());
                repaint();
            }
        }


    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
// Adjust the zoom factor based on the mouse wheel rotation
        int rotation = e.getWheelRotation();
        if (rotation > 0) {
            // Zoom out
            zoomFactor /= 1.2; // You can adjust the constant for different zoom sensitivity
        } else {
            // Zoom in
            zoomFactor *= 1.2; // You can adjust the constant for different zoom sensitivity
        }
        if (previewShape != null) {
            previewShape.resize(e.getX(), e.getY());
        }

        repaint();
    }
    private Shape2D createShape(int x, int y, int x2, int y2, Color color, boolean filled) {
        Shape2D shape;

        switch (currentShapeType) {
            case LINE:
                shape = new Line(x,y, (int) lastPressedX, (int) lastPressedY, color, filled);
                break;
            case RECTANGLE:
                shape = new Rectangle(x,y, (int) lastPressedX, (int) lastPressedY,color,filled);
                break;
            case OVAL:
                shape = new Oval(x,y, (int) lastPressedX, (int) lastPressedY,color,filled);
                break;
            default:
                throw new IllegalArgumentException("Invalid shape type");
        }
        return shape;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw all shapes in the list
        for (Shape2D shape : drawnShapes) {
            shape.draw(g, zoomFactor);
        }

        // Draw the preview shape if not null
        if (previewShape != null) {
            previewShape.draw(g, zoomFactor);
        }
    }
    // Other methods for setting properties and clearing shapes
    public void setCurrentShapeType(EnumShape currentShapeType) {
        this.currentShapeType = currentShapeType;
    }

    public void setNextShapeColor(Color nextShapeColor) {
        this.nextShapeColor = nextShapeColor;
    }

    public void setFillMode(boolean fillMode) {
        this.fillMode = fillMode;
    }

    public void setZoomFactor(double zoomFactor) {
        this.zoomFactor = zoomFactor;
    }

    public void clear() {
        drawnShapes.clear();
        repaint();
    }
}
