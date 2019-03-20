import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.util.Arrays;


class MainWindow extends JFrame {

    private AnimationWindow Animation;
    private JPanel FrameButtonPanel;
    private JPanel AnimationButtonPanel;
    private JPanel CheckBoxPanel;
    private JButton[] FrameButtons;
    private JButton[] AnimationButtons;
    private JCheckBox[] CheckBoxes;
    private static final int WINDOW_HEIGHT = 675;
    private static final int WINDOW_WIDTH = 1000;


    MainWindow()    {
        Animation = new AnimationWindow();
        FrameButtonPanel = new JPanel();
        FrameButtons = new JButton[6];
        AnimationButtonPanel = new JPanel();
        AnimationButtons = new JButton[2];
        CheckBoxes = new JCheckBox[3];
        CheckBoxPanel = new JPanel();


        setLayout(new BorderLayout());
        CheckBoxPanel.setLayout(new GridLayout(3, 1));
        CheckBoxPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        FrameButtonPanel.setLayout(new GridLayout(1, 6));
        FrameButtonPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        AnimationButtonPanel.setLayout(new GridLayout(1, 2));
        AnimationButtonPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        setPreferredSize(new Dimension(WINDOW_WIDTH,WINDOW_HEIGHT));
    }

    /**
     *
     */
    void run()
    {


        Timer t = new Timer(1, event -> {
            Animation.CheckShapes();
        });

        t.start();
        initializeFrameButtons();
        initializePanelButtons();
        initializeCheckBoxes();

        //Panel Buttons
        AnimationButtons[0].addActionListener(event ->
        {
            Animation.setVisible(false);
            t.stop();
        });

        AnimationButtons[1].addActionListener(event ->
        {
            remove(Animation);
            Animation.removeAllShapes();
            validate();
            repaint();
            pack();
            t.stop();
        });

        //Frame Buttons
        FrameButtons[0].addActionListener(event ->
        {
            addAnimation(t);
        });
        FrameButtons[1].addActionListener(event ->
        {
            if(CheckBoxes[0].isSelected())
            {
                Animation.add(new UFOShape());
            }
            if(CheckBoxes[1].isSelected())
            {
                Animation.add(new BirdShape());
            }
            if(CheckBoxes[2].isSelected())
            {
                Animation.add(new RocketShape());
            }
            if(!Arrays.asList(getComponents()).contains(Animation))
            {
                addAnimation(t);
            }
            Animation.repaint();
        });
        FrameButtons[2].addActionListener(event ->
        {
            if(CheckBoxes[0].isSelected())
            {
                Animation.remove(150);
            }
            if(CheckBoxes[1].isSelected())
            {
                Animation.remove(100);
            }
            if(CheckBoxes[2].isSelected())
            {
                Animation.remove(200);
            }
            Animation.repaint();
        });
        FrameButtons[3].addActionListener(event ->
        {
            if (t.isRunning()) { t.stop(); FrameButtons[3].setText("Resume");}
            else { t.start(); FrameButtons[3].setText("Pause");}
        });
        FrameButtons[4].addActionListener(event -> Animation.flipTranslate());
        FrameButtons[5].addActionListener(event ->
        {
            this.dispose();
            System.exit(0);
        });

        addFrameButtons();
        addPanelButtons();
        addCheckBoxes();


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);

    }

    /**
     *
     * @param t
     */
    private void addAnimation(Timer t) {
        add(Animation, BorderLayout.BEFORE_LINE_BEGINS);
        validate();
        repaint();
        pack();
        Animation.setVisible(true);
        t.start();
    }

    private void initializeFrameButtons()
    {
        FrameButtons[0] = new JButton("Show Window");
        FrameButtons[1] = new JButton("Add");
        FrameButtons[2] = new JButton("Remove");
        FrameButtons[3] = new JButton("Pause");
        FrameButtons[4] = new JButton("Change Direction");
        FrameButtons[5] = new JButton("Exit");

    }

    private void addFrameButtons()
    {
        for(int i = 0; i < 6; i ++)
        {
            FrameButtonPanel.add(FrameButtons[i]);
        }
        add(FrameButtonPanel, BorderLayout.NORTH);
    }

    private void initializePanelButtons()
    {
        AnimationButtons[0] = new JButton("Hide");
        AnimationButtons[1] = new JButton("Exit");

    }

    private void addPanelButtons()
    {
        for(int i = 0; i < 2; i ++)
        {
            AnimationButtonPanel.add(AnimationButtons[i]);
        }
        Animation.add(AnimationButtonPanel, BorderLayout.SOUTH);
    }

    private void initializeCheckBoxes()
    {
        CheckBoxes[0] = new JCheckBox("UFO");
        CheckBoxes[1] = new JCheckBox("Bird");
        CheckBoxes[1].setSelected(true);
        CheckBoxes[2] = new JCheckBox("Rocket");
    }

    private void addCheckBoxes()
    {
        for(int i = 0; i < 3; i ++)
        {
            CheckBoxPanel.add(CheckBoxes[i]);
        }
        add(CheckBoxPanel, BorderLayout.EAST);
    }

}
