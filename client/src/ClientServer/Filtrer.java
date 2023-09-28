package ClientServer;


import java.awt.image.BufferedImage;
import java.io.File;
import java.rmi.*;

public interface Filtrer extends Remote {
    public byte[] sobel(File f) throws RemoteException;
    public byte[] filtreMedian(File f) throws RemoteException;
}

