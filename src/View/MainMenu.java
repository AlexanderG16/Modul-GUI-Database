package View;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JButton;

public class MainMenu extends JFrame implements ActionListener{
    public MainMenu(){
        setTitle("Main Menu");
        setSize(300, 300);
        setBackground(Color.white);
        setLayout(new GridLayout(3, 1));
        //

        JButton rekam = new JButton("Perekaman");
        rekam.addActionListener(this);
        add(rekam);
        JButton cari = new JButton("Pencarian");
        add(cari);
        cari.addActionListener(this);
        JButton exit = new JButton("Exit");
        exit.addActionListener(this);
        add(exit);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        switch (e.getActionCommand()) {
            case "Perekaman":
                this.dispose();
                new InputDataPage();
                break;
            case "Pencarian":
                this.dispose();
                new PencarianPage();
                break;
            case "Exit":
                dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                System.exit(0);
        }
    }
}
