import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShapeIcon implements Icon {
    private int width;
    private int height;
    private static final int ICON_WIDTH  = 870;
    private static final int ICON_HEIGHT = 570;
    private ArrayList<MoveableShape> shapes;

    public ShapeIcon(int width, int height)
    {
        shapes = new ArrayList<>();
        this.width = width;
        this.height = height;
    }

    public int getIconWidth()
    {
        return width;
    }

    public int getIconHeight()
    {
        return height;
    }

    public void add(MoveableShape shape)
    {
        shapes.add(shape);
    }

    public void remove()
    {
        shapes.remove(shapes.size() - 1);
    }


    public void checkShapes() {
        MoveableShape temp;
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

    public void flipTranslate()
    {
        MoveableShape temp;
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


    public void paintIcon(Component c, Graphics g, int x, int y)
    {
        for (int i = shapes.size() - 1; i >= 0; i--) {
            Graphics2D g2 = (Graphics2D) g;
            shapes.get(i).draw(g2);
        }
    }
}
