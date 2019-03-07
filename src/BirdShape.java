import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class BirdShape implements MovableShape {


    private int x;
    private int y;
    private int width;
    private int xDirection;
    private int yDirection;
    private static final int ICON_WIDTH  = 870;
    private static final int ICON_HEIGHT = 525;

    BirdShape()
    {
        this.xDirection = 1;
        this.yDirection = 0;
        this.x = (int) (Math.random() * ((ICON_WIDTH) - 1));
        this.y = (int) (Math.random() * ((ICON_HEIGHT) - 1));
        this.width = 100;
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

    public int getWidth() { return width;}

    public void flipTranslate()
    {
        xDirection = -1 * xDirection;
        yDirection = -1 * yDirection;
    }


    public void draw(Graphics2D g2)
    {
        Ellipse2D.Double frontTire = new Ellipse2D.Double(x + width, y + width, width, width / 3);
        Point2D.Double r1 = new Point2D.Double(x + 2 * width, y + width + 15);
        Point2D.Double r2 = new Point2D.Double(x + 2 * width + 20, y + width + 18);
        Point2D.Double r3 = new Point2D.Double(x + 2 * width, y + width + 20);

        Line2D.Double line = new Line2D.Double(r1, r2);
        Line2D.Double line2 = new Line2D.Double(r2, r3);

        g2.setColor(Color.BLUE);
        g2.fillOval(x + width, y + width, width, width / 3);
        g2.setColor(Color.ORANGE);
        g2.draw(line);
        g2.draw(line2);
    }
}

