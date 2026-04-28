import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RoundedButton extends JButton {
    private int radius;
    public RoundedButton(String text, int width, int height, int radius){
        super(text);
        this.radius = radius;
        setOpaque(false);
        setPreferredSize(new Dimension(width, height));
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);

        addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                setBackground(getBackground().darker());
                repaint();
            }
            @Override
            public void mouseReleased(MouseEvent e){
                setBackground(getBackground().brighter());
            }
        });
    }
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0,0,getWidth(),getHeight(),radius,radius);
        g2.dispose();
        super.paintComponent(g);
    }
}
