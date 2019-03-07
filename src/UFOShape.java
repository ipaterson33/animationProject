import java.awt.*;
import java.awt.geom.Ellipse2D;


public class UFOShape implements MovableShape {
    private int x;
    private int y;
    private int width;
    private int xDirection;
    private int yDirection;
    private static final int ICON_WIDTH  = 870;
    private static final int ICON_HEIGHT = 570;

    UFOShape()
    {
        this.xDirection = 1;
        this.yDirection = 1;
        this.x = (int) (Math.random() * ((ICON_WIDTH) - 1));
        this.y = (int) (Math.random() * ((ICON_HEIGHT) - 1));
        this.width = 150;
    }

    public int getWidth()
    {
        return width;
    }

    public void translate()
    {
        x += xDirection;
        y += yDirection;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public int getXDirection()
    {
        return this.xDirection;
    }

    public int getYDirection()
    {
        return this.yDirection;
    }

    public void setX(int newX)
    {
        x = newX;
    }

    public void setY(int newY) { y = newY; }

    public void flipTranslate()
    {
        xDirection = -1 * xDirection;
        yDirection = -1 * yDirection;
    }


    public void draw(Graphics2D g2)
    {
        g2.setColor(Color.GRAY);
        g2.fillOval(x + width, y + width, width, width / 4);
        g2.fillOval(x + width*5/4, y + width * 4/5, width / 2, width / 2);
        Ellipse2D line = new Ellipse2D.Double(x + width * 5/4, y + width * 12/11, width / 2, width / 6);
        g2.setColor(Color.BLACK);
        g2.fillOval(x + width * 11/8, y + width *5/6, width / 5, width / 5);
        g2.draw(line);
    }
}
