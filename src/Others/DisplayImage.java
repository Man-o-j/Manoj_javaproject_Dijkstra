package Others;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


public class DisplayImage implements Runnable{
    public static JFrame frame=new JFrame();
    @Override
    public void run() {
        BufferedImage img= null;
        try {
            img = ImageIO.read(new File("src/STATE TRANSPORTATION SYSTEM.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageIcon icon=new ImageIcon(img);
        frame.setLayout(new FlowLayout());
        frame.setSize(742,546);
        JLabel lbl=new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

}
