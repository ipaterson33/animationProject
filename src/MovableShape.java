import java.awt.*;

public interface MovableShape
{
        /**
         * Interface Function to draw a shape to a jlabel
         * @param g2 Graphics
         */
        void draw(Graphics2D g2);

        /**
         * Moves a drawn shape on the screen
         */
        void translate();

        /**
         * Gets the location of a shape on the jlabel
         * @return Integer
         */
        int getX();

        /**
         * Gets the location of a shape on the jlabel
         * @return Integer
         */
        int getY();

        /**
         * gets the horizontal trajectory of the shape
         * @return integer
         */
        int getXDirection();

        /**
         * gets the vertical trajectory of the shape
         * @return integer
         */
        int getYDirection();

        /**
         * gets width of a shape
         * @return integer
         */
        int getWidth();

        /**
         * used for wrapping the object
         * @param newX : integer to assign where the shape will appear next
         */
        void setX(int newX);

        /**
         * user for wrapping the object
         * @param newY : integer to assign where the shape will appear next
         */
        void setY(int newY);

        /**
         * multiplies the direction of movement by -1 to reverse its trajectory
         */
        void flipTranslate();

}
