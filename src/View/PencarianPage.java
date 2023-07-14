package View;

import java.awt.event.*;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import Controller.DataController;

public class PencarianPage extends JFrame{
    public PencarianPage(){
        JFrame frame = this;
        setTitle("Cari Penduduk");
        setSize(400, 150);
        setBackground(Color.white);
        setLayout(null);
        //
        JLabel nik = new JLabel("NIK: ");
        nik.setBounds(10, 10, 50, 30);
        JTextField nikField = new JTextField();
        nikField.setBounds(60, 10, 250, 30);
        JButton cari = new JButton("Cari Penduduk");
        cari.setBounds(10, 50, 150, 30);
        cari.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                DataController c = new DataController();
                c.getDataFromDB(nikField.getText());
            }
        });
        JButton back = new JButton("Back");
        back.setBounds(230, 50, 150, 30);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new MainMenu();
            }
        });
        add(nik); add(nikField); add(cari); add(back);

        setVisible(true);
    }
}
