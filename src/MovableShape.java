import java.awt.*;

public interface MovableShape
{
        /**
         *
         * @param g2
         */
        void draw(Graphics2D g2);

        /**
         *
         */
        void translate();

        /**
         *
         * @return
         */
        int getX();

        /**
         *
         * @return
         */
        int getY();

        /**
         *
         * @return
         */
        int getXDirection();

        /**
         *
         * @return
         */
        int getYDirection();

        /**
         *
         * @return
         */
        int getWidth();

        /**
         *
         * @param newX
         */
        void setX(int newX);

        /**
         *
         * @param newY
         */
        void setY(int newY);

        /**
         *
         */
        void flipTranslate();

}
