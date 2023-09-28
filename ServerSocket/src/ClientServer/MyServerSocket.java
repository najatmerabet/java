package ClientServer;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class MyServerSocket extends Thread{

    int nmbrclient;
    private int port ;
    public MyServerSocket(int port){
        this.port=port;
    }

    @Override
    public void run()  {
        try {
            ServerSocket ss=new ServerSocket(port);
            while (true)
            {
                Socket s= ss.accept();
                System.out.println("server is ready");
                nmbrclient++;
                new excution(s,nmbrclient).start();
            }

        }catch (IOException e)
        {
            e.printStackTrace();
        }


    }
    class excution extends Thread{
        private Socket socket;
        private int nmbrC;

        public excution(Socket socket,int nmbrC)
        {
            super();
            this.socket=socket;
            this.nmbrC=nmbrC;
        }
        @Override
        public void run()
        {
            FiltreSocket panneau =null;
            System.out.println("connexion de client num" + nmbrC);
            InputStream inputStream = null;
            try {
                inputStream = socket.getInputStream();
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                BufferedImage bufferedImage = ImageIO.read(bufferedInputStream);
                OutputStream outputStream = socket.getOutputStream();
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
                BufferedImage b=null;
                panneau = new FiltreSocket();
                panneau.ajouterImage(bufferedImage);
                if(port==2022) {
                    b = panneau.filtreMoyenneur();
                }
                if(port==2024)
                {
                    b = panneau.filtreGaussian();
                }
                Image image = b;
                BufferedImage bufferedImage1 = new BufferedImage(image.getWidth(null),image.getHeight(null),BufferedImage.TYPE_INT_RGB );
                Graphics graphics = bufferedImage1.createGraphics();
                graphics.drawImage(image, 0, 0, null);
                graphics.dispose();
                ImageIO.write(bufferedImage1, "png", bufferedOutputStream);
                bufferedInputStream.close();
                bufferedOutputStream.close();
                socket.close();
            }catch(IOException e){
                e.printStackTrace();
            }


        }
    }
    public static void main(String[]args){

        new MyServerSocket(Integer.parseInt(args[0])).start();
    }

}
