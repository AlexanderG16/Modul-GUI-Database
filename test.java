import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;

/*from  w w w.  java2s  .  c o  m*/
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test extends JFrame{
    public void FileRetriever() {
        setTitle("Retrieve Foto KTP");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new FlowLayout());

        JLabel fotoLabel = new JLabel();
        fotoLabel.setPreferredSize(new Dimension(150, 200));
        add(fotoLabel);

        retrieveFile();

        setVisible(true);
    }

    public void retrieveFile() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");
            String sql = "SELECT content FROM files WHERE name = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "nama_file.jpg"); // Ganti dengan nama file yang ingin diambil

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                byte[] content = resultSet.getBytes("content");
                Image image = getImageFromBytes(content);
                if (image != null) {
                    ImageIcon imageIcon = new ImageIcon(image);
                    fotoLabel.setIcon(imageIcon);
                }
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Image getImageFromBytes(byte[] imageData) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
            BufferedImage bufferedImage = ImageIO.read(bis);
            return bufferedImage;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        String filePath = "C:/path/to/your/file.jpg"; // Ganti dengan path file yang ingin diupload
        String dbUrl = "jdbc:mysql://localhost:3306/your_database"; // Ganti dengan URL database Anda
        String username = "your_username"; // Ganti dengan username database Anda
        String password = "your_password"; // Ganti dengan password database Anda

        try {
            // Membaca konten file sebagai byte array
            File file = new File(filePath);
            byte[] fileData = new byte[(int) file.length()];
            FileInputStream fis = new FileInputStream(file);
            fis.read(fileData);
            fis.close();

            // Membuat koneksi ke database
            Connection connection = DriverManager.getConnection(dbUrl, username, password);

            // Menyiapkan pernyataan SQL untuk menyimpan data file ke dalam tabel
            String sql = "INSERT INTO your_table (file_data) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setBytes(1, fileData);

            // Menjalankan pernyataan SQL
            statement.executeUpdate();

            System.out.println("File uploaded successfully.");

            // Menutup koneksi dan pernyataan
            statement.close();
            connection.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath);
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}