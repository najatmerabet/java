package ClientServer;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.*;
import java.rmi.server.*;
import javax.imageio.ImageIO;

public class FiltreRemote extends UnicastRemoteObject implements Filtrer{

    FiltreRemote() throws RemoteException {
        super();
    }





    public byte[] sobel(File f) {
        BufferedImage fimg = null;
        float[] mat = {-1.f, 0.f, 1.f,
                -2.f, 0.f, 2.f,
                -1.f, 0.f, 1.f};
        try {
            BufferedImage img = ImageIO.read(f);
            Kernel kernel = new Kernel(3, 3, mat);
            ConvolveOp cop = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
            fimg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
            cop.filter(img, fimg);
            File file = new File("res.jpg");
            ImageIO.write(fimg, "jpg", file);
            System.out.println(fimg != null);
            System.out.println("Done");
        } catch (Exception e) {
            System.out.println(e);
        }
        return downloadFileFromServer("res.jpg");
    }

    public byte[] filtreMedian(File f)
    {
        BufferedImage fimg = null;
        float[ ] masqueMedian =
                {
                        1/9f, 1/9f, 1/9f,
                        1/9f, 1/9f, 1/9f,
                        1/9f, 1/9f, 1/9f
                };

        try {
            BufferedImage img = ImageIO.read(f);
            Kernel kernel = new Kernel(3, 3, masqueMedian);
            ConvolveOp cop = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
            fimg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
            cop.filter(img, fimg);
            File file = new File("res.jpg");
            ImageIO.write(fimg, "jpg", file);
            System.out.println(fimg != null);
            System.out.println("Done");
        } catch (Exception e) {
            System.out.println(e);
        }
        return downloadFileFromServer("res.jpg");
    }




    public byte[] downloadFileFromServer(String serverpath) {

        byte[] mydata;

        File serverpathfile = new File(serverpath);
        mydata = new byte[(int) serverpathfile.length()];
        FileInputStream in;
        try {
            in = new FileInputStream(serverpathfile);
            try {
                in.read(mydata, 0, mydata.length);
            } catch (IOException e) {

                e.printStackTrace();
            }
            try {
                in.close();
            } catch (IOException e) {

                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }

        return mydata;

    }
}



