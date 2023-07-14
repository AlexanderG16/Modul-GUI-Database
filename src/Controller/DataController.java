package Controller;

import java.sql.Statement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataController {
    static DatabaseHandler conn = new DatabaseHandler();
    public boolean inputDataToDB(String nik, String nama, String tempatLahir, Date tanggalLahir, String jenisKelamin, String golDarah, String alamat, String rtRw, String kelDesa, String kecamatan, String agama, String statusKawin, String pekerjaan, Date berlakuHingga, String warganegara, String fotoFilePath, String ttdFilePath, String kotaBuat){
        conn.connect();
        String query = "INSERT INTO penduduk (nik, nama, tempat_lahir, tanggal_lahir, jenis_kelamin, gol_darah, alamat, rt_rw, kel_desa, kecamatan, agama, status_kawin, pekerjaan, warganegara, foto, ttd, berlaku_hingga, kota_buat) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt;
        try {
            stmt = conn.con.prepareStatement(query);
            stmt.setString(1, nik);
            stmt.setString(2, nama);
            stmt.setString(3, tempatLahir);
            stmt.setDate(4, tanggalLahir);
            stmt.setString(5, jenisKelamin);
            stmt.setString(6, golDarah);
            stmt.setString(7, alamat);
            stmt.setString(8, rtRw);
            stmt.setString(9, kelDesa);
            stmt.setString(10, kecamatan);
            stmt.setString(11, agama);
            stmt.setString(12, statusKawin);
            stmt.setString(13, pekerjaan);
            stmt.setString(14, warganegara);
            stmt.setString(15, fotoFilePath);
            stmt.setString(16, ttdFilePath);
            stmt.setDate(17, berlakuHingga);
            stmt.setString(18, kotaBuat);

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public void getDataFromDB(String nik){
        try {
            Statement st = conn.con.createStatement();
            String query = "SELECT * FROM penduduk WHERE nik=" + nik;
            ResultSet rs = st.executeQuery(query);
            if (rs.next()){
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
