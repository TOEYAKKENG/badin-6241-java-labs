package onchoysakul.badin.lab11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MobileDeviceCompleteV3 extends MobileDeviceCompleteV2 implements ComponentListener {

    private Timer resizeTimer, moveTimer;
    private int width, height, x, y; // Store only new values

    public MobileDeviceCompleteV3(String title) {
        super(title);

        // Timers to prevent excessive pop-ups
        resizeTimer = new Timer(500, e -> showSize());
        resizeTimer.setRepeats(false);

        moveTimer = new Timer(500, e -> showMove());
        moveTimer.setRepeats(false);
    }

    @Override
    public void addListeners() {
        this.addComponentListener(this);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        width = getWidth();
        height = getHeight();
        resizeTimer.restart(); // Delay pop-up to prevent stacking
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        x = getX();
        y = getY();
        moveTimer.restart(); // Delay pop-up to prevent stacking
    }

    private void showSize() {
        JOptionPane.showMessageDialog(this, "Window resized to: " + width + " x " + height, "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showMove() {
        JOptionPane.showMessageDialog(this, "Window moved to: X=" + x + " Y=" + y, "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void componentShown(ComponentEvent e) {
        JOptionPane.showMessageDialog(this, "Window is now visible.", "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        JOptionPane.showMessageDialog(this, "Window is now invisible.", "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MobileDeviceCompleteV3::createAndShowGUI);
    }

    public static void createAndShowGUI() {
        MobileDeviceCompleteV3 window = new MobileDeviceCompleteV3("Mobile Device CompleteV3");
        window.addComponents();
        window.addMenus();
        window.addListeners();
        window.setFrameFeatures();
    }

    protected void setFrameFeatures() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
    }
}
