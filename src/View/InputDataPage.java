package View;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Controller.DateLabelFormatter;
import Controller.GetButton;
import Controller.DataController;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class InputDataPage extends JFrame{
    public InputDataPage(){
        JFrame frame = this;
        setTitle("Input Data KTP");
        setBackground(Color.white);
        setSize(600, 800);
        //
        // NIK
        JLabel nikLabel = new JLabel("Masukkan NIK:");
        nikLabel.setBounds(10, 10, 100, 30);
        add(nikLabel);
        JTextField nikField = new JTextField();
        nikField.setBounds(10, 40, 100, 20);
        add(nikField);
        // Nama
        JLabel namaLabel = new JLabel("Masukkan nama:");
        namaLabel.setBounds(10, 60, 100, 30);
        add(namaLabel);
        JTextField namaField = new JTextField();
        namaField.setBounds(10, 90, 150, 20);
        add(namaField);
        // Tempat Lahir
        JLabel tempatLahirLabel = new JLabel("Masukkan Tempat Lahir:");
        tempatLahirLabel.setBounds(10, 110, 150, 30);
        add(tempatLahirLabel);
        JTextField tempatLahirField = new JTextField();
        tempatLahirField.setBounds(10, 140, 150, 20);
        add(tempatLahirField);
        // Tanggal Lahir
        JLabel tanggalLahirLabel = new JLabel("Masukkan Tanggal Lahir:");
        tanggalLahirLabel.setBounds(10, 160, 250, 30);
        add(tanggalLahirLabel);
        UtilDateModel tanggalLahirModel = new UtilDateModel();
        JDatePanelImpl tanggalLahirDatePanel = new JDatePanelImpl(tanggalLahirModel);
        JDatePickerImpl tanggalLahirDatePicker = new JDatePickerImpl(tanggalLahirDatePanel, new DateLabelFormatter());
        tanggalLahirDatePicker.setBounds(10, 190, 130, 30);
        add(tanggalLahirDatePicker);
        // Jenis Kelamin
        JLabel jenisKelaminLabel = new JLabel("Pilih Jenis Kelamin:");
        jenisKelaminLabel.setBounds(10, 220, 250, 30);
        add(jenisKelaminLabel);
        JRadioButton lakiLaki = new JRadioButton("Laki-Laki");
        JRadioButton perempuan = new JRadioButton("Perempuan");
        lakiLaki.setBounds(10, 250, 100, 30);
        perempuan.setBounds(110, 250, 100, 30);
        ButtonGroup jenisKelamin = new ButtonGroup(){{add(lakiLaki); add(perempuan);}};
        add(lakiLaki); add(perempuan);
        // Golongan Darah
        JLabel golDarahLabel = new JLabel("Pilih Golongan Darah:");
        golDarahLabel.setBounds(10, 280, 250, 30);
        add(golDarahLabel);
        JRadioButton a = new JRadioButton("A");
        a.setBounds(10, 310, 50, 30);
        JRadioButton b = new JRadioButton("B");
        b.setBounds(60, 310, 50, 30);
        JRadioButton o = new JRadioButton("O");
        o.setBounds(110, 310, 50, 30);
        JRadioButton ab = new JRadioButton("AB");
        ab.setBounds(160, 310, 50, 30);
        ButtonGroup golDarah = new ButtonGroup(){{add(a); add(b); add(o); add(ab);}};
        add(a); add(b); add(o); add(ab);
        // Alamat
        JLabel alamatLabel = new JLabel("Masukkan Alamat:");
        alamatLabel.setBounds(10, 340, 150, 30);
        add(alamatLabel);
        JTextField alamatField = new JTextField();
        alamatField.setBounds(10, 370, 200, 20);
        add(alamatField);
        // RT/RW
        JLabel rtRwLabel = new JLabel("Masukkan RT/RW:");
        rtRwLabel.setBounds(10, 390, 150, 30);
        add(rtRwLabel);
        JTextField rtRWField = new JTextField();
        rtRWField.setBounds(10, 420, 150, 20);
        add(rtRWField);
        // Kel/Desa
        JLabel kelDesaLabel = new JLabel("Masukkan Kel/Desa:");
        kelDesaLabel.setBounds(10, 440, 150, 30);
        add(kelDesaLabel);
        JTextField kelDesaField = new JTextField();
        kelDesaField.setBounds(10, 470, 150, 20);
        add(kelDesaField);
        // Kecamatan
        JLabel kecamatanLabel = new JLabel("Masukkan Kecamatan:");
        kecamatanLabel.setBounds(10, 490, 150, 30);
        add(kecamatanLabel);
        JTextField kecamatanField = new JTextField();
        kecamatanField.setBounds(10, 520, 150, 20);
        add(kecamatanField);
        // Agama
        JLabel agamaLabel = new JLabel("Masukkan Agama:");
        agamaLabel.setBounds(10, 540, 150, 30);
        add(agamaLabel);
        String[] listAgama = {"Kristen", "Katolik", "Islam", "Hindu", "Buddha"};
        JComboBox<String> agama = new JComboBox<String>(listAgama);
        agama.setBounds(10, 570, 70, 30);
        agama.setSelectedItem(null);
        add(agama);
        // Status Kawin
        JLabel statusKawinLabel = new JLabel("Masukkan Status Perkawinan:");
        statusKawinLabel.setBounds(10, 600, 150, 30);
        add(statusKawinLabel);
        String[] listStatus = {"Belum Menikah", "Menikah", "Jandah/Duda"};
        JComboBox<String> statusKawin = new JComboBox<String>(listStatus);
        statusKawin.setBounds(10, 630, 130, 30);
        statusKawin.setSelectedItem(null);
        add(statusKawin);
        // Pekerjaan
        JLabel pekerjaanLabel = new JLabel("Masukkan Pekerjaan:");
        pekerjaanLabel.setBounds(10, 660, 150, 30);
        add(pekerjaanLabel);
        JCheckBox karyaSwasta = new JCheckBox("Karyawan Swasta");
        karyaSwasta.setBounds(10, 690, 130, 30);
        JCheckBox pns = new JCheckBox("PNS");
        pns.setBounds(140, 690, 50, 30);
        JCheckBox wiraswasta = new JCheckBox("Wiraswasta");
        wiraswasta.setBounds(190, 690, 100, 30);
        JCheckBox akademisi = new JCheckBox("Akademisi");
        akademisi.setBounds(290, 690, 100, 30);
        JCheckBox nganggur = new JCheckBox("Pengangguran");
        nganggur.setBounds(390, 690, 130, 30);
        nganggur.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
                if (e.getStateChange() == 1){
                    karyaSwasta.setEnabled(false); karyaSwasta.setSelected(false);
                    pns.setEnabled(false); pns.setSelected(false);
                    wiraswasta.setEnabled(false); wiraswasta.setSelected(false);
                    akademisi.setEnabled(false); akademisi.setSelected(false);
                }
                else{
                    karyaSwasta.setEnabled(true);
                    pns.setEnabled(true);
                    wiraswasta.setEnabled(true);
                    akademisi.setEnabled(true);
                }
            }
        });
        add(karyaSwasta); add(pns); add(wiraswasta); add(akademisi); add(nganggur);
        // Kewarganegaraan
        JLabel wargaLabel = new JLabel("Pilih Kewarganegaraan:");
        wargaLabel.setBounds(250, 10, 180, 30);
        add(wargaLabel);
        JRadioButton wni = new JRadioButton("WNI");
        JRadioButton wna = new JRadioButton("WNA");
        wni.setBounds(250, 40, 50, 30);
        wna.setBounds(300, 40, 60, 30);
        ButtonGroup warga = new ButtonGroup(){{add(wni); add(wna);}};
        JLabel negaraLabel = new JLabel("Masukkan Warga Negara:");
        negaraLabel.setBounds(400, 20, 150, 30);
        negaraLabel.setVisible(false);
        add(negaraLabel);
        JTextField negaraField = new JTextField();
        negaraField.setBounds(400, 50, 150, 20);
        negaraField.setVisible(false);
        add(negaraField);
        wna.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
                if (e.getStateChange() == 1){
                    negaraLabel.setVisible(true);
                    negaraField.setVisible(true);
                }
                else{
                    negaraLabel.setVisible(false);
                    negaraField.setVisible(false);
                }
            }
        });
        add(wni); add(wna);
        // Foto
        JLabel fotoLabel = new JLabel("Masukkan foto:");
        fotoLabel.setBounds(250, 70, 250, 30);
        add(fotoLabel);
        JButton browseButton = new JButton("Pilih Foto");
        browseButton.setBounds(250, 100, 250, 30);
        JLabel fotoPreview = new JLabel();
        fotoPreview.setBounds(250, 100, 75, 100);
        fotoPreview.setVisible(false);
        JLabel fotoPath = new JLabel();
        add(fotoPreview);
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    fotoPath.setText(selectedFile.getAbsolutePath());
                    // Tambahkan logika untuk memproses file foto yang dipilih
                    ImageIcon imageIcon = new ImageIcon(selectedFile.getPath());
                    Image image = imageIcon.getImage().getScaledInstance(75, 100, Image.SCALE_DEFAULT);
                    fotoPreview.setIcon(new ImageIcon(image));
                    fotoPreview.setVisible(true);
                }
            }
        });
        add(browseButton);
        // Tanda Tangan
        JLabel ttdLabel = new JLabel("Masukkan Tanda Tangan:");
        ttdLabel.setBounds(250, 200, 250, 30);
        add(ttdLabel);
        JButton ttdBrowseButton = new JButton("Pilih Foto Tanda Tangan");
        ttdBrowseButton.setBounds(250, 230, 250, 30);
        JLabel ttdPreview = new JLabel();
        ttdPreview.setBounds(250, 230, 75, 100);
        ttdPreview.setVisible(false);
        JLabel ttdPath = new JLabel();
        add(ttdPreview);
        ttdBrowseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    ttdPath.setText(selectedFile.getAbsolutePath());
                    // Tambahkan logika untuk memproses file ttd yang dipilih
                    ImageIcon imageIcon = new ImageIcon(selectedFile.getPath());
                    Image image = imageIcon.getImage().getScaledInstance(75, 100, Image.SCALE_DEFAULT);
                    ttdPreview.setIcon(new ImageIcon(image));
                    ttdPreview.setVisible(true);
                }
            }
        });
        add(ttdBrowseButton);
        // Expired Date
        JLabel berlakuHinggaLabel = new JLabel("Berlaku Hingga:");
        berlakuHinggaLabel.setBounds(250, 330, 250, 30);
        add(berlakuHinggaLabel);
        UtilDateModel berlakuHinggaModel = new UtilDateModel();
        JDatePanelImpl berlakuHinggaDatePanel = new JDatePanelImpl(berlakuHinggaModel);
        JDatePickerImpl berlakuHinggaDatePicker = new JDatePickerImpl(berlakuHinggaDatePanel, new DateLabelFormatter());
        berlakuHinggaDatePicker.setBounds(250, 360, 130, 30);
        add(berlakuHinggaDatePicker);
        // Kota Buat KTP
        JLabel kotaBuatLabel = new JLabel("Masukkan Kota Pembuatan KTP:");
        kotaBuatLabel.setBounds(250, 390, 200, 30);
        add(kotaBuatLabel);
        JTextField kotaBuatField = new JTextField();
        kotaBuatField.setBounds(250, 420, 100, 20);
        add(kotaBuatField);
        // Tanggal Pembuatan KTP
        JLabel tanggalBuatLabel = new JLabel("Tanggal Pembuatan KTP: " + new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        tanggalBuatLabel.setBounds(250, 440, 250, 30);
        add(tanggalBuatLabel);
        // Button Insert Data
        JButton insertData = new JButton("Insert Data");
        insertData.setBounds(250, 520, 100, 50);
        insertData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                GetButton c = new GetButton();
                String pilGolDar = c.getSelectedButtonText(golDarah), pilJenisKelamin = c.getSelectedButtonText(jenisKelamin);
                if (nikField.getText().equals("") || namaField.getText().equals("") || tempatLahirField.getText().equals("") || tanggalLahirDatePicker.getModel().getValue() == null || jenisKelamin.getSelection() == null || golDarah.getSelection() == null || alamatField.getText().equals("") || rtRWField.getText().equals("") || kelDesaField.getText().equals("") || kecamatanField.getText().equals("") || agama.getSelectedItem() == null || statusKawin.getSelectedItem() == null || (!karyaSwasta.isSelected() && !pns.isSelected() && !wiraswasta.isSelected() && !akademisi.isSelected() && !nganggur.isSelected()) || warga.getSelection() == null || berlakuHinggaDatePicker.getModel().getValue() == null || kotaBuatField.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Masukkan seluruh input! Tidak boleh ada yang kosong!", "Masih ada yang kosong", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    DataController control = new DataController();
                    StringBuilder builderPekerjaan = new StringBuilder();
                            if (karyaSwasta.isSelected()) {
                                builderPekerjaan.append(karyaSwasta.getText()).append(", ");
                            }
                            if (pns.isSelected()) {
                                builderPekerjaan.append(pns.getText()).append(", ");
                            }
                            if (wiraswasta.isSelected()) {
                                builderPekerjaan.append(wiraswasta.getText()).append(", ");
                            }
                            if (akademisi.isSelected()) {
                                builderPekerjaan.append(akademisi.getText()).append(", ");
                            }
                            if (nganggur.isSelected()) {
                                builderPekerjaan.append(nganggur.getText()).append(", ");
                            }
                            if (builderPekerjaan.length() > 0) {
                                builderPekerjaan.setLength(builderPekerjaan.length() - 2);
                            }
                    String pekerjaan = builderPekerjaan.toString();
                    StringBuilder builderKewarganegaraan = new StringBuilder();
                    if(wni.isSelected()){
                        builderKewarganegaraan.append(wni.getText());
                    }else if(wna.isSelected()){
                        builderKewarganegaraan.append(wna.getText()).append("(").append(negaraField.getText()).append(")");
                    }
                    String kewarganegaraan = builderKewarganegaraan.toString();
                    if(control.inputDataToDB(nikField.getText(), namaField.getText(), tempatLahirField.getText(), new java.sql.Date(tanggalLahirModel.getValue().getTime()), pilJenisKelamin.toUpperCase(), pilGolDar.toUpperCase(), alamatField.getText(), rtRWField.getText(), kelDesaField.getText(), kecamatanField.getText(), agama.getSelectedItem().toString(), statusKawin.getSelectedItem().toString(), pekerjaan, new java.sql.Date(berlakuHinggaModel.getValue().getTime()), kewarganegaraan, fotoPath.getText(), ttdPath.getText(), kotaBuatField.getText())){
                        JOptionPane.showMessageDialog(null, "Data has been uploaded successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE, null);
                        frame.dispose();
                        new HasilKTP(nikField.getText(), namaField.getText(), tempatLahirField.getText(), new java.sql.Date(tanggalLahirModel.getValue().getTime()), pilJenisKelamin.toUpperCase(), pilGolDar.toUpperCase(), alamatField.getText(), rtRWField.getText(), kelDesaField.getText(), kecamatanField.getText(), agama.getSelectedItem().toString(), statusKawin.getSelectedItem().toString(), pekerjaan, new java.sql.Date(berlakuHinggaModel.getValue().getTime()), kewarganegaraan, fotoPath.getText(), ttdPath.getText(), kotaBuatField.getText(), new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
                    }

                }
            }
        });
        add(insertData);
        // Button back
        JButton back = new JButton("Back");
        back.setBounds(250, 580, 100, 50);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new MainMenu();
            }
        });
        add(back);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new InputDataPage();
    }
}
