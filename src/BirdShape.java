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

        Point2D.Double r1 = new Point2D.Double(x + 9 * width / 16, y + width / 2);
        Point2D.Double r2 = new Point2D.Double(x + width * 7 / 16, y + 3 * width / 4);
        Point2D.Double r3 = new Point2D.Double(x + width / 4 , y + 3 * width / 4);
        Point2D.Double r4 = new Point2D.Double(x + width * 6 / 16, y + width / 2);
        Point2D.Double r5 = new Point2D.Double(x + width * 5/ 8 , y + 7 * width / 16);
        Point2D.Double r6 = new Point2D.Double(x + width * 5 / 8, y + width * 9 / 16);
        Point2D.Double r7 = new Point2D.Double(x + width * 7 / 8, y + width / 2);
        Point2D.Double r8 = new Point2D.Double(x + width / 2, y + width / 4);
        Point2D.Double r9 = new Point2D.Double(x + width * 3 / 8, y + width / 4);
        Point2D.Double r10 = new Point2D.Double(x + width * 5 / 8, y + width * 7 / 16);
        Point2D.Double r11 = new Point2D.Double(x + width * 7 / 16, y + width * 7 / 16);
        Point2D.Double r12 = new Point2D.Double(x + width * 3 / 8, y + width / 2);
        Point2D.Double r13 = new Point2D.Double(x + width * 1 / 8, y + width * 3 / 8);
        Point2D.Double r14 = new Point2D.Double(x + width * 1 / 8, y + width * 5 / 8);
        Line2D.Double fwing1 = new Line2D.Double(r1, r2);
        Line2D.Double fwing2 = new Line2D.Double(r2, r3);
        Line2D.Double fwing3  = new Line2D.Double(r3, r4);
        Line2D.Double nose1 = new Line2D.Double(r5, r6);
        Line2D.Double nose2 = new Line2D.Double(r6, r7);
        Line2D.Double nose3 = new Line2D.Double(r7, r5);
        Line2D.Double wing1 = new Line2D.Double(r8, r10);
        Line2D.Double wing2 = new Line2D.Double(r9, r11);
        Line2D.Double wing3 = new Line2D.Double(r8, r9);
        Line2D.Double tail1 = new Line2D.Double(r12, r13);
        Line2D.Double tail2 = new Line2D.Double(r13, r14);
        Line2D.Double tail3 = new Line2D.Double(r14, r12);


        g2.draw(nose1);
        g2.draw(nose2);
        g2.draw(nose3);
        g2.draw(wing1);
        g2.draw(wing2);
        g2.draw(wing3);
        g2.draw(tail1);
        g2.draw(tail2);
        g2.draw(tail3);
        g2.setColor(Color.BLUE);
        g2.fillOval(x + width / 4, y + width * 3 / 8, width / 2, width / 4);
        g2.setColor(Color.BLACK);
        g2.fillOval(x + width * 9 / 16, y + width * 13 / 32, width / 11, width / 11);
        g2.draw(fwing1);
        g2.draw(fwing2);
        g2.draw(fwing3);
    }
}

