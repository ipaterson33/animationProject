import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class RocketShape implements MovableShape
{
    private int x;
    private int y;
    private int width;
    private int xDirection;
    private int yDirection;
    private static final int ICON_WIDTH  = 870;
    private static final int ICON_HEIGHT = 570;

    RocketShape()
    {
        this.xDirection = 0;
        this.yDirection = 1;
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

    public void flipTranslate()
    {
        xDirection = -1 * xDirection;
        yDirection = -1 * yDirection;
    }


    public void draw(Graphics2D g2)
    {
     Rectangle2D.Double body = new Rectangle2D.Double(x, y, width/4, width/2);
        Point2D.Double r1 = new Point2D.Double(x + width / 6, y + width / 6);
        Point2D.Double r2 = new Point2D.Double(x + width / 3, y);
        Point2D.Double r3 = new Point2D.Double(x + width * 2/3, y);
        Point2D.Double r4 = new Point2D.Double(x + width * 5 / 6, y + width / 6);
        Line2D.Double frontWindshield = new Line2D.Double(r1, r2);
        Line2D.Double roofTop = new Line2D.Double(r2, r3);
        Line2D.Double rearWindshield  = new Line2D.Double(r3, r4);

       g2.draw(body);
        g2.draw(frontWindshield);
        g2.draw(roofTop);
        g2.draw(rearWindshield);
        }
}
