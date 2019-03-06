import java.awt.*;


public interface MovableShape
{
        void draw(Graphics2D g2);

        void translate();

        int getX();

        int getY();

        int getXDirection();

        int getYDirection();

        void setX(int newX);

        void setY(int newY);

        void flipTranslate();

}
