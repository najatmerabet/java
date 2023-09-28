package ClientServer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;

public class FiltreSocket extends JPanel {


    BufferedImage monImage = null;


    protected void ajouterImage(BufferedImage fichierImage)
    {
        monImage = fichierImage;


        repaint();

    }
    protected BufferedImage filtreMoyenneur()
    {
        BufferedImage image = new BufferedImage(monImage.getWidth(),monImage.getHeight(), monImage.getType());
        float[ ] masqueMedian =
                {
                        1/9f, 1/9f, 1/9f,
                        1/9f, 1/9f, 1/9f,
                        1/9f, 1/9f, 1/9f
                };

        Kernel masque = new Kernel(3, 3, masqueMedian);
        ConvolveOp operation = new ConvolveOp(masque);

            operation.filter(monImage, image);
            monImage = image;

        System.out.println("convolution effectue");
        repaint();
        return  monImage;

    }
    protected BufferedImage filtreGaussian()
    {
        BufferedImage image = new BufferedImage(monImage.getWidth(),monImage.getHeight(), monImage.getType());
        float[ ] masqueMedian =
                {
                        1/9f, 1/9f, 1/9f,
                        1/9f, 1/9f, 1/9f,
                        1/9f, 1/9f, 1/9f
                };

        Kernel masque = new Kernel(3, 3, masqueMedian);
        ConvolveOp operation = new ConvolveOp(masque);

            operation.filter(monImage, image);
            monImage = image;
            System.out.println("convolution effectuée");
            repaint();



        return  monImage;
    }
}
