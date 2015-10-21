/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akash
 */
import java.awt.*;
 import java.awt.font.*;
 import java.awt.geom.*;
 import javax.swing.*;
 import javax.swing.event.*;

 public class Speedometer
 {
 public static void main(String[] args)
 {
 SpeedometerPanel speedometer = new SpeedometerPanel();
 SpeedometerAction action = new SpeedometerAction(speedometer);
 JFrame f = new JFrame("Speedometer");
 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 f.getContentPane().add(speedometer);
 f.getContentPane().add(action.getUIpanel(), "South");
 f.setSize(200,150);
 f.setLocation(900,600);
 f.setUndecorated(true);
 f.setVisible(true);
 }
 }

 class SpeedometerPanel extends JPanel
 {
 Font font;
 final int PAD;
 double phi;
 // Image image;

 public SpeedometerPanel()
 {
 // loadImage();
 font = new Font("Arial", Font.PLAIN, 6);
 PAD = 5;
 phi = -90.0; // 12 o'clock
 // setBackground(Color.lightGray);
 }

 protected void paintComponent(Graphics g)
 {
 super.paintComponent(g);
 Graphics2D g2 = (Graphics2D)g;
 g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
 RenderingHints.VALUE_ANTIALIAS_ON);
 int w = getWidth();
 System.out.println("width = " + w);
 int h = getHeight();
 System.out.println("height = " + h);
 // draw dial
 double dia = w*7/8;
 System.out.println("diameter = " + dia);
 double x = (w - dia)/2;
 System.out.println("x = " + x);
 double y = (h - dia)/2 + dia/4;
 System.out.println("y = " + y);
 double start = 0.0;
 double extent = 180.0;
 Shape arc = new Arc2D.Double(x, y, dia, dia, start, extent, Arc2D.OPEN);
 g2.draw(arc);

 // draw 10 tick marks
 double thetaInc = extent/10;
 double theta = 0.0;
 double x0 = x + dia/2;
 double y0 = y + dia/2;
 double r = dia/2;
 double x1, y1, x2, y2;
 Shape tick;
 for(int i = 0; i < 11; i++)
 {
 x1 = x0 + (r - 4) * Math.cos(Math.toRadians(theta));
 y1 = y0 + (r - 4) * Math.sin(Math.toRadians(theta));
 x2 = x0 + r * Math.cos(Math.toRadians(theta));
 y2 = y0 + r * Math.sin(Math.toRadians(theta));
 tick = new Line2D.Double(x1, y1, x2, y2);
 g2.draw(tick);
 theta -= thetaInc;
 }

 // draw tick labels
 g2.setFont(font);
 FontRenderContext frc = g2.getFontRenderContext();
 LineMetrics lm;
 theta = 0.0;
 for(int i = 0; i < 11; i++)
 {
      //float value = (10 - i)/10;
 String s = String.valueOf("0." + (10-i));
 float width = (float)font.getStringBounds(s, frc).getWidth();
 lm = font.getLineMetrics(s, frc);
 float height = lm.getAscent();
 double cos = Math.cos(Math.toRadians(theta));
 double sin = Math.sin(Math.toRadians(theta));
 double diag = Math.sqrt(width*width + height*height)/2;
 double cx = x0 + (r - PAD) * cos - (width * cos)/2;
 double cy = y0 + (r - PAD) * sin - (height * sin)/2;
 float sx = (float)cx - width/2;
 float sy = (float)cy + height/2;
 g2.drawString(s, sx, sy);
 theta -= thetaInc;
 }

 // draw needle
 double x3, y3, x4, y4;
 // radius is one half of the minimum width of the needle 
 // with the origin (x0,y0) located midway between 
 // the low tip and the place of maximum width 
 double radius = 5.0; 
 x1 = x0 - radius * Math.cos(Math.toRadians(phi));
 y1 = y0 - radius * Math.sin(Math.toRadians(phi));
 // Shape s0 = new Line2D.Double(x0, y0, x1, y1);
 double phiOffset = Math.toDegrees(Math.atan2(2.5,2.5));
 x2 = x0 + radius * Math.sqrt(2) * Math.cos(Math.toRadians(phi - phiOffset));
 y2 = y0 + radius * Math.sqrt(2) * Math.sin(Math.toRadians(phi - phiOffset));
 Shape s1 = new Line2D.Double(x1, y1, x2, y2);
 x3 = x0 + (r - 8) * Math.cos(Math.toRadians(phi));
 y3 = y0 + (r - 8) * Math.sin(Math.toRadians(phi));
 Shape s2 = new Line2D.Double(x2, y2, x3, y3);
 x4 = x0 + radius * Math.sqrt(2) * Math.cos(Math.toRadians(phi + phiOffset));
 y4 = y0 + radius * Math.sqrt(2) * Math.sin(Math.toRadians(phi + phiOffset));
 Shape s3 = new Line2D.Double(x3, y3, x4, y4);
 Shape s4 = new Line2D.Double(x4, y4, x1, y1);
 GeneralPath needle = new GeneralPath(s1);
 needle.append(s2, true);
 needle.append(s3, true);
 needle.append(s4, true);
 g2.setPaint(Color.black);
 g2.fill(needle);
 }

 public void setSpeed(double speed)
 {
 //     System.out.println("Speed " + speed);
 phi = 18 * speed - 180.0;
 // System.out.println("phi =" + phi);
 repaint();
 }
 }

 class SpeedometerAction
 {
 SpeedometerPanel speedometer;

 public SpeedometerAction(SpeedometerPanel sp)
 {
 speedometer = sp;
 }

 public JPanel getUIpanel()
 {
 final JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
 // slider.setBackground(Color.lightGray);
 slider.setMajorTickSpacing(5);
 slider.setMinorTickSpacing(1);
 slider.setPaintTicks(true);
 slider.setPaintLabels(true);
 slider.addChangeListener(new ChangeListener()
 {
 public void stateChanged(ChangeEvent e)
 {
 speedometer.setSpeed(Math.random()/*slider.getValue()*/);
 }
 });
 JPanel panel = new JPanel();
 // panel.setBackground(Color.lightGray);
 panel.add(slider);
 return panel;
 }
 } 
