package View;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class HasilKTP extends JFrame{
    public HasilKTP(String nik, String nama, String tempatLahir, Date tanggalLahir, String jenisKelamin, String golDarah, String alamat, String rtRw, String kelDesa, String kecamatan, String agama, String statusKawin, String pekerjaan, Date berlakuHingga, String warganegara, String fotoFilePath, String ttdFilePath, String kotaBuat, String tanggalBuat) {
        JFrame frame = this;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(530, 350);
        JPanel panel = new JPanel(null);
        panel.setPreferredSize(new Dimension(530, 350));
        
        JLabel labelTitle = new JLabel("Republik Harapan Bangsa");
        labelTitle.setBounds(150, 10, 400, 20);
        labelTitle.setFont(new Font("Arial", Font.BOLD, 18));
        JLabel labelNIKHasil = new JLabel("NIK         : " + nik);
        labelNIKHasil.setBounds(10, 50, 380, 20);
        labelNIKHasil.setFont(new Font("Arial", Font.BOLD, 18));
        JLabel labelNamaHasil = new JLabel("Nama                            : " + nama);
        labelNamaHasil.setBounds(10, 80, 380, 20);
        JLabel labelTTLHasil = new JLabel("Tempat/Tgl Lahir       : " + tempatLahir + ", " + tanggalLahir.toString());
        labelTTLHasil.setBounds(10, 95, 380, 20);
        JLabel labelJKHasil = new JLabel("Jenis Kelamin            : " + jenisKelamin);
        labelJKHasil.setBounds(10, 110, 200, 20);
        JLabel labelGolDarHasil = new JLabel("Gol. Darah     : " + golDarah);
        labelGolDarHasil.setBounds(220, 110, 100, 20);
        JLabel labelAlamatHasil = new JLabel("Alamat                         : " + alamat);
        labelAlamatHasil.setBounds(10, 125, 380, 20);
        JLabel labelRTRWHasil = new JLabel("RT/RW                   : " + rtRw);
        labelRTRWHasil.setBounds(30, 140, 380, 20);
        JLabel labelKelDesaHasil = new JLabel("Kel/Desa               : " + kelDesa);
        labelKelDesaHasil.setBounds(30, 155, 380, 20);
        JLabel labelKecamatanHasil = new JLabel("Kecamatan          : " + kecamatan);
        labelKecamatanHasil.setBounds(30, 170, 380, 20);
        JLabel labelAgamaHasil = new JLabel("Agama                         : " + agama);
        labelAgamaHasil.setBounds(10, 185, 380, 20);
        JLabel labelStatusPerkawinanHasil = new JLabel("Status Perkawinan  : " + statusKawin);
        labelStatusPerkawinanHasil.setBounds(10, 200, 380, 20);
        JLabel labelPekerjaanHasil = new JLabel("Pekerjaan                   : " + pekerjaan);
        labelPekerjaanHasil.setBounds(10, 215, 380, 20);
        JLabel labelKewarganegaraanHasil = new JLabel("Kewarganegaraan   : " + warganegara);
        labelKewarganegaraanHasil.setBounds(10, 230, 380, 20);
        JLabel labelMasaBerlakuHasil = new JLabel("Masa Berlaku            : " + berlakuHingga.toString());
        labelMasaBerlakuHasil.setBounds(10, 245, 380, 20);
        JLabel labelKotaPembuatanHasil = new JLabel(kotaBuat);
        labelKotaPembuatanHasil.setBounds(415, 215, 380, 20);
        labelKotaPembuatanHasil.setFont(new Font("Arial", Font.PLAIN, 12));
        JLabel labelTanggalPembuatanHasil = new JLabel(tanggalBuat);
        labelTanggalPembuatanHasil.setBounds(400, 227, 380, 20);
        labelTanggalPembuatanHasil.setFont(new Font("Arial", Font.PLAIN, 12));
        ImageIcon originalFotoIcon = new ImageIcon(fotoFilePath);
        Image originalFoto = originalFotoIcon.getImage();
        Image resizedFoto = originalFoto.getScaledInstance(125, 155, Image.SCALE_SMOOTH);
        ImageIcon resizedFotoIcon = new ImageIcon(resizedFoto);
        JLabel labelFotoHasil = new JLabel(resizedFotoIcon);
        labelFotoHasil.setBounds(370, 60, 125, 155);
        ImageIcon originalTTDIcon = new ImageIcon(ttdFilePath);
        Image originalTTD = originalTTDIcon.getImage();
        Image resizedTTD = originalTTD.getScaledInstance(125, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedTTDIcon = new ImageIcon(resizedTTD);
        JLabel labelTTDHasil = new JLabel(resizedTTDIcon);
        labelTTDHasil.setBounds(370, 250, 125, 50);
        JButton back = new JButton("Back to Main Menu");
        back.setBounds(10, 280, 150, 30);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new MainMenu();
            }
        });
        
        panel.add(labelTitle);
        panel.add(labelNIKHasil);
        panel.add(labelNamaHasil);
        panel.add(labelTTLHasil);
        panel.add(labelJKHasil);
        panel.add(labelGolDarHasil);
        panel.add(labelAlamatHasil);
        panel.add(labelRTRWHasil);
        panel.add(labelKelDesaHasil);
        panel.add(labelKecamatanHasil);
        panel.add(labelAgamaHasil);
        panel.add(labelStatusPerkawinanHasil);
        panel.add(labelPekerjaanHasil);
        panel.add(labelKewarganegaraanHasil);
        panel.add(labelMasaBerlakuHasil);
        panel.add(labelKotaPembuatanHasil);
        panel.add(labelTanggalPembuatanHasil);
        panel.add(labelFotoHasil);
        panel.add(labelTTDHasil);
        panel.add(back);

        panel.setBackground(Color.decode("#ccdef6"));
        add(panel);
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new HasilKTP(null, null, null, new Date(0), null, null, null, null, null, null, null, null, null, new Date(0), null, "Downloads/Pasfoto.jpg", null, null, "1970-1-1");
            }
        });
    }
}
