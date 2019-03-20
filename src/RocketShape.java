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
        this.yDirection = -1;
        this.x = (int) (Math.random() * ((ICON_WIDTH) - 1));
        this.y = (int) (Math.random() * ((ICON_HEIGHT) - 1));
        this.width = 200;
    }

    public void translate()
    {
        x += xDirection;
        y += yDirection;
    }

    public int getWidth()
    {
        return width;
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
        Rectangle2D.Double body = new Rectangle2D.Double(x + width *3 /8, y + width * 1 / 4, width/4, width * 5 / 8);
        Point2D.Double r1 = new Point2D.Double(x + width * 3 / 8, y + width *3 / 4);
        Point2D.Double r2 = new Point2D.Double(x + width * 1 / 4, y + width *7 / 8);
        Point2D.Double r3 = new Point2D.Double(x + width * 5 / 16, y + width *7 / 8);
        Point2D.Double r4 = new Point2D.Double(x + width * 3 / 8, y + width *13 / 16);
        Point2D.Double r5 = new Point2D.Double(x + width * 5 / 8, y + width *3 / 4);
        Point2D.Double r6 = new Point2D.Double(x + width * 3 / 4, y + width *7 / 8);
        Point2D.Double r7 = new Point2D.Double(x + width * 11 / 16, y + width *7 / 8);
        Point2D.Double r8 = new Point2D.Double(x + width * 5 / 8, y + width *13 / 16);
        Point2D.Double r9 = new Point2D.Double(x + width * 7 / 16, y + width *7 / 8);
        Point2D.Double r10 = new Point2D.Double(x + width * 3 / 8, y + width *15 / 16);
        Point2D.Double r11 = new Point2D.Double(x + width * 5 / 8, y + width *15 / 16);
        Point2D.Double r12 = new Point2D.Double(x + width * 9 / 16, y + width *7 / 8);
        Line2D.Double lWing1 = new Line2D.Double(r1, r2);
        Line2D.Double lWing2 = new Line2D.Double(r2, r3);
        Line2D.Double lWing3  = new Line2D.Double(r3, r4);
        Line2D.Double rWing1 = new Line2D.Double(r5, r6);
        Line2D.Double rWing2 = new Line2D.Double(r6, r7);
        Line2D.Double rWing3  = new Line2D.Double(r7, r8);
        Line2D.Double engine1 = new Line2D.Double(r9, r10);
        Line2D.Double engine2 = new Line2D.Double(r10, r11);
        Line2D.Double engine3 = new Line2D.Double(r11, r12);

        g2.setColor(Color.BLACK);
        //g2.fillRect(x + width *3 /8, y + width * 1 / 4, width/4, width * 5 / 8);
        g2.fill(body);
        g2.setColor(Color.BLACK);
        g2.fillOval(x + width * 3/8, y + width / 8, width / 4, width / 4);
        g2.draw(lWing1);
        g2.draw(lWing2);
        g2.draw(lWing3);
        g2.draw(rWing1);
        g2.draw(rWing2);
        g2.draw(rWing3);
        g2.setColor(Color.ORANGE);
        g2.draw(engine1);
        g2.draw(engine2);
        g2.draw(engine3);
        }
}
