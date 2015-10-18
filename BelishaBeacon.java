import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
/**
 * Created by Ben on 3/29/15.
 */
public class BelishaBeacon extends JFrame{
    JButton flashbutton = new JButton("Flash");
    JButton steadybutton = new JButton("Steady");
    JPanel bPanel = new JPanel();
    BeaconDrawer vpanel = new BeaconDrawer();
    Timer timer;
    boolean timerstart=false;

    public BelishaBeacon(){
        bPanel.add(flashbutton);
        bPanel.add(steadybutton);
        flashbutton.setPreferredSize(new Dimension(190, 30));
        steadybutton.setPreferredSize(new Dimension(190, 30));
        this.add(vpanel,BorderLayout.CENTER);
        this.add(bPanel, BorderLayout.SOUTH);
        flashbutton.addActionListener(new FlashListener());
        steadybutton.addActionListener(new SteadyListener());
    }

    public static void main (String[] args){
        JFrame vpanel = new BelishaBeacon();
        vpanel.setTitle("Belisha Beacon");
        vpanel.setSize(400, 500);
        vpanel.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        vpanel.setVisible(true);
    }

    class FlashListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            timer = new Timer(500, new TimerListener());
            timer.start();
            timerstart=true;
        }
    }

    class SteadyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            vpanel.steady();
            repaint();
            if (timerstart=true){
                timer.stop();
            }
        }
    }

    class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (vpanel.flash==false){
                vpanel.flash();
                repaint();
            }
            else if (vpanel.flash==true){
                vpanel.steady();
                repaint();
            }
        }
    }

    public class BeaconDrawer extends JPanel {
        public boolean flash = false;
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.BLACK);
            g2.fillRect(195, 125, 11, 25);g2.fillRect(195, 175, 11, 25);g2.fillRect(195, 225, 11, 25);g2.fillRect(195, 275, 11, 25);g2.fillRect(195, 325, 11, 25);
            g2.draw(new Rectangle(195, 150, 10, 25));g2.draw(new Rectangle(195, 200, 10, 25));g2.draw(new Rectangle(195, 250, 10, 25));g2.draw(new Rectangle(195, 300, 10, 25));g2.draw(new Rectangle(195, 350, 10, 25));
            Ellipse2D.Double bulb = new Ellipse2D.Double(175,75,50,50);
            g2.setColor(Color.ORANGE);
            g2.draw(bulb);
            g2.fill(bulb);

            if (flash!=false){
                g2.setColor(Color.LIGHT_GRAY);
                g2.draw(bulb);
                g2.fill(bulb);
            }
        }

        public void flash() { flash = true; }
        public void steady() { flash = false; }
    }

}
