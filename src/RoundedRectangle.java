import javax.swing.*;
import java.awt.*;

public class RoundedRectangle extends JPanel {
    private int radius;
    public RoundedRectangle(int width, int height, int radius){
        this.radius = radius;
        setOpaque(false);
        setPreferredSize(new Dimension(width, height));
    }
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.setColor(getBackground());
        g2.fillRoundRect(0,0,getWidth(),getHeight(),radius,radius);
        g2.dispose();
    }
}
