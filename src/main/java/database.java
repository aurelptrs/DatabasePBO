import java.sql.*;


public class database {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1/perpus";
    static final String USER = "root";
    static final String PASS = "";

    static Connection conn;
    static Statement stmt;
    static ResultSet rs;


    public static void tampilkan(){
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT * FROM buku");
            int i = 1;
            while(rs.next())
            {
                System.out.println("\nData ke-"+i);
                System.out.println("id Buku : " + rs.getString("id"));
                System.out.println("Judul Buku : "+rs.getString("judul_buku"));
                System.out.println("Tahun Terbit : "+rs.getString("tahun_terbit"));
                System.out.println("Stok : "+rs.getString("stok"));
                System.out.println("Penulis : "+rs.getString("penulis"));
                i++;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void deleteData(int id){
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "DELETE FROM buku WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            stmt.close();
            conn.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void masukkanBuku(int id,String judul_buku,int tahun_terbit,int stok,int penulis){
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql = "INSERT INTO buku (id,judul_buku,tahun_terbit,stok,penulis) VALUES (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, judul_buku);
            ps.setInt(3, tahun_terbit);
            ps.setInt(4, stok);
            ps.setInt(5, penulis);
            ps.execute();
            stmt.close();
            conn.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void editBuku(int id,String Ujudul_buku,int Utahun_terbit,int Ustok,int Upenulis){
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();

            String sql = "UPDATE buku SET judul_buku = ?, tahun_terbit = ?,stok = ?,penulis = ? WHERE id = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, Ujudul_buku);
            ps.setInt(2, Utahun_terbit);
            ps.setInt(3, Ustok);
            ps.setInt(4, Upenulis);
            ps.setInt(5, id);
            ps.execute();
            stmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


}



