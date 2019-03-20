import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShapeIcon implements Icon {
    private int width;
    private int height;
    private static final int ICON_WIDTH  = 870;
    private static final int ICON_HEIGHT = 570;
    private ArrayList<MovableShape> shapes;

    /**
     * Icon with arrayList of MoveableShapes to display the animation
     * @param width : The Width of the JLabel that will be displayed on the AnimationWindow
     * @param height : The Height of the JLabel that will be displayed on the AnimationWindow
     */
    ShapeIcon(int width, int height)
    {
        shapes = new ArrayList<>();
        this.width = width;
        this.height = height;
    }

    /**
     * Function for getting the width of the JLabel
     * @return Integer of Label Width
     */
    public int getIconWidth()
    {
        return width;
    }

    /**
     * Function for getting the Height of the JLabel
     * @return Integer of Label Height
     */
    public int getIconHeight()
    {
        return height;
    }

    /**
     * Adds a MoveableShape interfaced object to the ArrayList of MoveableShapes
     * @param shape : Is whatever shape that has implemented MoveableShape
     */
    void add(MovableShape shape)
    {
        shapes.add(shape);
    }

    /**
     * Removes the most recent instance of a shape from the arrayList
     * @param x : Integer of the width of the shape specified to be deleted
     */
    void remove(int x)
    {
        int i = shapes.size() -1 ;
        boolean deleted = false;
        while (!deleted) {
            if (shapes.get(i).getWidth() == x)
            {
                shapes.remove(i);
                deleted = true;
            }
            else
            {
                i--;
            }
        }
    }


    void removeAll() {
        for (int i = shapes.size() - 1; i >= 0; i--)
        {
            shapes.remove(i);
        }
    }


    void checkShapes() {
        MovableShape temp;
        for (int i = shapes.size() - 1; i >= 0; i--) {
            temp = shapes.get(i);
            if (atEdge(temp.getX(), ICON_WIDTH)) {
                if (temp.getXDirection() > 0)
                    temp.setX(-100);
                else
                    temp.setX(ICON_WIDTH);
            }
            if (atEdge(temp.getY(), ICON_HEIGHT)) {
                if (temp.getYDirection() > 0)
                    temp.setY(-100);
                else
                    temp.setY(ICON_HEIGHT);
            }
            temp.translate();
            shapes.set(i, temp);
        }
    }

    void flipTranslate()
    {
        MovableShape temp;
        for(int i = shapes.size()-1; i >= 0; i--)
        {
            temp = shapes.get(i);
            temp.flipTranslate();
            shapes.set(i, temp);
        }
    }

    private boolean atEdge(int x, int dimension)
    {
        return (x <  -100 || x > dimension);
    }


    /**
     * Function for painting shapes to the label
     * @param c
     * @param g
     * @param x
     * @param y
     */
    public void paintIcon(Component c, Graphics g, int x, int y)
    {
        for (int i = shapes.size() - 1; i >= 0; i--) {
            Graphics2D g2 = (Graphics2D) g;
            shapes.get(i).draw(g2);
        }
    }
}
