package ClientServer;

import java.awt.Image;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;



import java.net.Socket;
import java.rmi.Naming;
import javax.imageio.ImageIO;
public class MyClient extends javax.swing.JFrame {
    String getselectedImage;
    Image imFit;
    Socket socket;

    public MyClient() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        image_originale = new javax.swing.JLabel();
        button_choisir_image = new javax.swing.JButton();
        titre = new javax.swing.JLabel();
        chek_moy = new javax.swing.JCheckBox();
        chek_guss = new javax.swing.JCheckBox();
        chek_sobel = new javax.swing.JCheckBox();
        chek_nv_gris = new javax.swing.JCheckBox();
        button_filtrer = new javax.swing.JButton();
        afficher_res = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        img_moy = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        img_guss = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        img_nvg = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        img_med = new javax.swing.JLabel();
        img_sobel = new javax.swing.JLabel();
        img_sobell = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 254, 240));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(image_originale, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(image_originale, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
        );

        button_choisir_image.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        button_choisir_image.setText("Choisir une image");
        button_choisir_image.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_choisir_imageActionPerformed(evt);
            }    
        });

        titre.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        titre.setText("Image Originale");

        chek_moy.setBackground(new java.awt.Color(253, 252, 229));
        chek_moy.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        chek_moy.setText("Moyenne");

        chek_guss.setBackground(new java.awt.Color(253, 252, 229));
        chek_guss.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        chek_guss.setText("Gaussian");

        chek_sobel.setBackground(new java.awt.Color(253, 252, 229));
        chek_sobel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        chek_sobel.setText("Sobel   ");

        chek_nv_gris.setBackground(new java.awt.Color(253, 252, 229));
        chek_nv_gris.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        chek_nv_gris.setText("Filtre Median");

        button_filtrer.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        button_filtrer.setText("Filtrer");
        button_filtrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_filtrerActionPerformed(evt);
            }
        });

        afficher_res.setBackground(new java.awt.Color(204, 204, 255));
        afficher_res.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(img_moy, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(img_moy, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
        );

        afficher_res.addTab("Filtre Moyenne", jPanel4);

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(img_guss, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(img_guss, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
        );

        afficher_res.addTab("Filtre de Gussian", jPanel5);

        jPanel7.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(img_nvg, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(img_nvg, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
        );

        afficher_res.addTab("Filtre Median", jPanel7);

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(img_sobell, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(img_sobel, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(img_med, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(img_med, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(img_sobel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(img_sobell, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
        );

        afficher_res.addTab("Filtre se Sobel", jPanel6);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel3.setText("Choisir un filtre :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(button_filtrer, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button_choisir_image, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(160, 160, 160)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(43, 43, 43)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(chek_nv_gris, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(chek_sobel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(chek_guss, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addComponent(chek_moy, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(89, 89, 89))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(162, 162, 162)
                                                .addComponent(afficher_res, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(336, 336, 336)
                                                .addComponent(titre, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(83, 83, 83)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(chek_moy)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(chek_guss)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(chek_sobel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(chek_nv_gris)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 12, Short.MAX_VALUE)
                                                .addComponent(titre)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(23, 23, 23)
                                                .addComponent(button_choisir_image)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(button_filtrer)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(afficher_res, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void button_choisir_imageActionPerformed(java.awt.event.ActionEvent evt) {
        img_guss.setIcon(null);
        img_moy.setIcon(null);
        img_nvg.setIcon(null);
        img_sobell.setIcon(null);
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("4 Extensions Supported", "jpg", "png", "jpeg", "gif");
        fileChooser.setFileFilter(filter);
        int selected = fileChooser.showOpenDialog(null);

        if (selected == JFileChooser.APPROVE_OPTION) {

            File file = fileChooser.getSelectedFile();



            //Get Path of the selected image.

            getselectedImage = file.getAbsolutePath();

            ImageIcon imIco = new ImageIcon(getselectedImage);

            imFit = imIco.getImage();

            Image imgFit = imFit.getScaledInstance(image_originale.getWidth(), image_originale.getHeight(), Image.SCALE_SMOOTH);

            image_originale.setIcon(new ImageIcon(imgFit));
        }
    }

    private void button_filtrerActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if(chek_moy.isSelected()){
                socket = new Socket("localhost", 2022);
                System.out.println("connected to server.");
                afficher_socket(img_moy);
            }
            if(chek_guss.isSelected()){
                socket = new Socket("localhost", 2024);
                System.out.println("connected to server.");
                afficher_socket(img_guss);
            }
            if (chek_sobel.isSelected()){
                afficher_Rmi(img_sobell,2020,"filter1");
            }
            if (chek_nv_gris.isSelected()){
                afficher_Rmi(img_nvg,2021,"filter2");
            }


        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void afficher_socket(JLabel label ) throws IOException
    {
        OutputStream outputStream = socket.getOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        System.out.println(getselectedImage);
        Image image =  imFit;

        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);

        Graphics graphics = bufferedImage.createGraphics();
        graphics.drawImage(image, 0, 0, null);
        graphics.dispose();
        ImageIO.write(bufferedImage, "png", bufferedOutputStream);



        InputStream inputStream = socket.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        BufferedImage bufferedImage1 = ImageIO.read(bufferedInputStream);
        Image imgFit = bufferedImage1.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);

        label.setIcon(new ImageIcon(imgFit ));
        bufferedOutputStream.close();
        bufferedInputStream.close();
        socket.close();
    }
    byte[] mydata;
    public void afficher_Rmi(JLabel label,int port,String s)
    {

        try {
            Filtrer stub = (Filtrer) Naming.lookup("rmi://localhost:"+port+"/"+s);
            System.out.println("GET SOBEL FILTER");
            if(s=="filter1") {
                 mydata = stub.sobel(new File(getselectedImage));
            }
            if(s=="filter2") {
                mydata = stub.filtreMedian(new File(getselectedImage));
            }
            InputStream is = new ByteArrayInputStream(mydata);
            BufferedImage newBi = ImageIO.read(is);
            Image imgFit = newBi.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);

            label.setIcon(new ImageIcon(imgFit ));
          //  label.setIcon(new ImageIcon(mydata));

        } catch (Exception e) {
            System.out.println(e);
        }
    }



    public static void main(String args[]) throws IOException {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JTabbedPane afficher_res;
    private javax.swing.JButton button_choisir_image;
    private javax.swing.JButton button_filtrer;
    private javax.swing.JCheckBox chek_guss;
    private javax.swing.JCheckBox chek_moy;
    private javax.swing.JCheckBox chek_nv_gris;
    private javax.swing.JCheckBox chek_sobel;
    private javax.swing.JLabel image_originale;
    private javax.swing.JLabel img_guss;
    private javax.swing.JLabel img_moy;
    private javax.swing.JLabel img_med;
    private javax.swing.JLabel img_nvg;
    private javax.swing.JLabel img_sobel;
    private javax.swing.JLabel img_sobell;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel titre;
    // End of variables declaration
}