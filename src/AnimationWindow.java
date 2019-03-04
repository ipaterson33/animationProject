import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class AnimationWindow extends JPanel {

    private static final int ICON_WIDTH  = 900;
    private static final int ICON_HEIGHT = 570;
    private static final int PANEL_WIDTH = 915;
    private static final int PANEL_HEIGHT = 600;
    final JLabel label;
    ShapeIcon shapes;



    public AnimationWindow()
    {
        shapes = new ShapeIcon(ICON_WIDTH, ICON_HEIGHT);
        label = new JLabel((shapes));
        label.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        add(label, BorderLayout.CENTER);

    }

    public void add(MoveableShape shape)
    {
        shapes.add(shape);
    }

    public void remove()
    {
        shapes.remove();
    }

    public void CheckShapes()
    {
        shapes.checkShapes();
        label.repaint();
    }


    public void flipTranslate() {
        shapes.flipTranslate();
    }
}
