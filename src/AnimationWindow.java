import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

class AnimationWindow extends JPanel {

    private static final int ICON_WIDTH  = 900;
    private static final int ICON_HEIGHT = 570;
    private static final int PANEL_WIDTH = 915;
    private static final int PANEL_HEIGHT = 600;
    private final JLabel label;
    private ShapeIcon shapes;


    /**
     * where all animation takes place
     */
    AnimationWindow()
    {
        shapes = new ShapeIcon(ICON_WIDTH, ICON_HEIGHT);
        label = new JLabel(shapes);
        label.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        add(label, BorderLayout.CENTER);

    }

    /**
     *
     */
    void removeAllShapes()
    {
        shapes.removeAll();
    }

    void add(MovableShape shape)
    {
        shapes.add(shape);
    }

    /**
     *
     * @param i
     */
    public void remove(int i)
    {
        shapes.remove(i);
    }

    /**
     *
     */
    void CheckShapes()
    {
        shapes.checkShapes();
        label.repaint();
    }

    /**
     *
     */
    void flipTranslate() {
        shapes.flipTranslate();
    }
}
