import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.event.*;

public class HW2 extends JFrame {
 
    HW2() {
        super("JSlider demo");
        super.setSize(440, 500);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);
        setupGUI();
        super.setVisible(true);
    }
 
    private void setupGUI() {
        super.setLayout(new BorderLayout(5, 5));
        OvalPanel drawingPanel = new OvalPanel();
        super.add(drawingPanel, BorderLayout.CENTER);
        JSlider radiusSlider = new JSlider(JSlider.HORIZONTAL, 0, 400, 0);
        radiusSlider.addChangeListener(drawingPanel);
        radiusSlider.setMajorTickSpacing(100);
        radiusSlider.setMinorTickSpacing(10);
        radiusSlider.setPaintTicks(true);
        radiusSlider.setPaintLabels(true);
        super.add(radiusSlider, BorderLayout.SOUTH);
    }
 
    class OvalPanel extends JPanel implements ChangeListener {
 
        private int radius = -1;
 
        @Override
        public void stateChanged(ChangeEvent e) {
            JSlider slider = (JSlider)e.getSource();
            radius = slider.getValue();
            repaint();
        }
 
        @Override
        protected void paintComponent(Graphics g) {
            if(radius == -1) return;
            Graphics2D g2d = (Graphics2D)g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(super.getBackground());
            g2d.fillRect(0, 0, super.getParent().getWidth(), super.getParent().getHeight());
            g2d.setColor(Color.BLUE);
            int x = (super.getWidth()/2) - (radius/2);
            int y = (super.getHeight()/2) - (radius/2);
            g2d.drawOval(x, y, radius, radius);
        }
    }
 
    public static void main( String[] args ) throws Exception {
        javax.swing.SwingUtilities.invokeAndWait(new Runnable(){
            @Override
            public void run() { 
                new HW2(); 
            }
        });
    }
}