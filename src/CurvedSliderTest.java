import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class CurvedSliderTest
{
    public static void main(String[] args) throws IOException
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI()
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.getContentPane().setLayout(new BorderLayout());

        CurvedSlider gaugePanel = new CurvedSlider();
        f.getContentPane().add(gaugePanel, BorderLayout.CENTER);

        JPanel controlPanel = createControlPanel(gaugePanel);
        f.getContentPane().add(controlPanel, BorderLayout.NORTH);

        f.setSize(600,800);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    static JPanel createControlPanel(final CurvedSlider gaugePanel)
    {
        final JSlider minAngleSlider = new JSlider(0, 100, 0);
        final JSlider maxAngleSlider = new JSlider(0, 100, 0);
        final JSlider minValueSlider = new JSlider(0, 100, 0);
        final JSlider maxValueSlider = new JSlider(0, 100, 0);
        final JSlider valueSlider = new JSlider(0, 100, 0);

        JPanel controlPanel = new JPanel(new GridLayout(0,2));
        controlPanel.add(new JLabel("minAngle"));
        controlPanel.add(minAngleSlider);
        controlPanel.add(new JLabel("maxAngle"));
        controlPanel.add(maxAngleSlider);
        controlPanel.add(new JLabel("minValue"));
        controlPanel.add(minValueSlider);
        controlPanel.add(new JLabel("maxValue"));
        controlPanel.add(maxValueSlider);
        controlPanel.add(new JLabel("value"));
        controlPanel.add(valueSlider);

        ChangeListener changeListener = new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                double minAngle = minAngleSlider.getValue() / 100.0 * Math.PI * 2;
                double maxAngle = maxAngleSlider.getValue() / 100.0 * Math.PI * 2;
                double minValue = minValueSlider.getValue() / 100.0;
                double maxValue = maxValueSlider.getValue() / 100.0;
                double value = valueSlider.getValue() / 100.0;

                gaugePanel.setAngles(minAngle, maxAngle);
                gaugePanel.setRange(minValue, maxValue);
                gaugePanel.setValue(value);
            }
        };
        minAngleSlider.addChangeListener(changeListener);
        maxAngleSlider.addChangeListener(changeListener);
        minValueSlider.addChangeListener(changeListener);
        maxValueSlider.addChangeListener(changeListener);
        valueSlider.addChangeListener(changeListener);

        minAngleSlider.setValue(50);
        maxAngleSlider.setValue(0);
        minValueSlider.setValue(10);
        maxValueSlider.setValue(90);
        valueSlider.setValue(50);

        return controlPanel;
    }


}



class CurvedSlider extends JPanel implements MouseListener, MouseMotionListener
{
    private double minAngleRad = 0.0;
    private double maxAngleRad = 0.0;
    private double minValue = 0.0;
    private double maxValue = 0.0;
    private double value = 0.0;

    CurvedSlider()
    {
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    void setAngles(double minAngleRad, double maxAngleRad)
    {
        this.minAngleRad = minAngleRad;
        this.maxAngleRad = maxAngleRad;
        repaint();
    }

    void setRange(double minValue, double maxValue)
    {
        this.minValue = minValue;
        this.maxValue = maxValue;
        repaint();
    }

    void setValue(double value)
    {
        this.value = value;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics gr)
    {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D)gr;
        g.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING, 
            RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.WHITE);
        g.fillRect(0,0,getWidth(),getHeight());

        boolean printValues = false;
        printValues = true;
        if (printValues)
        {
            int ty = 20;
            g.setColor(Color.BLACK);
            g.drawString("minAngle "+Math.toDegrees(minAngleRad), 20, ty+=20);
            g.drawString("maxAngle "+Math.toDegrees(maxAngleRad), 20, ty+=20);
            g.drawString("minValue "+minValue, 20, ty+=20);
            g.drawString("maxValue "+maxValue, 20, ty+=20);
            g.drawString("value "+value, 20, ty+=20);
        }

        double alpha = (value - minValue) / (maxValue - minValue);
        double angleRad = minAngleRad + alpha * (maxAngleRad - minAngleRad);

        double radius = Math.min(getWidth(), getHeight()) / 3.0;

        final double thickness = 15;
        double xC = getWidth() / 2.0;
        double yC = getHeight() / 2.0;
        double x0 = xC + Math.cos(angleRad) * (radius - thickness);
        double y0 = yC - Math.sin(angleRad) * (radius - thickness);
        double x1 = xC + Math.cos(angleRad) * radius;
        double y1 = yC - Math.sin(angleRad) * radius;

        Shape background0 = new Arc2D.Double(
            xC-radius, yC-radius, 
            radius+radius, radius+radius, 
            Math.toDegrees(minAngleRad), 
            Math.toDegrees(maxAngleRad-minAngleRad), 
            Arc2D.PIE);

        Shape background1 = new Ellipse2D.Double(
            xC-radius+thickness, yC-radius+thickness, 
            radius+radius-thickness-thickness, 
            radius+radius-thickness-thickness);

        Area a = new Area(background0);
        a.subtract(new Area(background1));

        g.setColor(Color.GRAY);
        g.fill(a);
        g.setStroke(new BasicStroke(3.0f, 
            BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g.setColor(Color.LIGHT_GRAY);
        g.draw(a);

        g.setStroke(new BasicStroke(8.0f, 
            BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g.setColor(Color.BLACK);
        g.draw(new Line2D.Double(x0, y0, x1, y1));
    }

    private void updateAngle(Point p)
    {
        double xC = getWidth() / 2.0;
        double yC = getHeight() / 2.0;
        double dx = p.getX() - xC;
        double dy = p.getY() - yC;
        double angleRad = Math.atan2(-dy, dx);
        if (angleRad < -Math.PI / 2)
        {
            angleRad = 2 * Math.PI + angleRad;
        }
        angleRad = Math.max(maxAngleRad, Math.min(minAngleRad, angleRad));
        double alpha = (angleRad - minAngleRad) / (maxAngleRad - minAngleRad);
        double value = minValue + alpha * (maxValue - minValue);
        setValue(value);
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        updateAngle(e.getPoint());
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        updateAngle(e.getPoint());
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
    }
}